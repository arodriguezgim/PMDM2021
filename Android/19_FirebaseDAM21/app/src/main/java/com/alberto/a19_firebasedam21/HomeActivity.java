package com.alberto.a19_firebasedam21;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

import java.util.HashMap;
import java.util.Map;

public class HomeActivity extends AppCompatActivity {

    TextView tvemail, tvmetodo;
    EditText direccionET, telefonoET;
    Button logOut, errorButton, guardarButton, recuperarButton, borrarButton;
    boolean mostrarBotonError;
    // Remote Config
    private FirebaseRemoteConfig mFirebaseRemoteConfig;
    // Firestorage
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvemail = findViewById(R.id.emailTextView);
        tvmetodo = findViewById(R.id.metodoTextView);
        logOut = findViewById(R.id.logoutButton);
        errorButton = findViewById(R.id.errorButton);
        guardarButton = findViewById(R.id.guardarButton);
        recuperarButton = findViewById(R.id.recuperrarButton);
        borrarButton = findViewById(R.id.borrarButton);
        direccionET = findViewById(R.id.addressTextView);
        telefonoET = findViewById(R.id.tfnoTextView);

        errorButton.setVisibility(View.INVISIBLE);
        //Recuperamos los datos del LoginActivity
        Bundle datos = this.getIntent().getExtras();
        String email = datos.getString("email");
        String metodo = datos.getString("metodo");
        // Guardado de datos
        SharedPreferences sesion = getSharedPreferences("sesion", Context.MODE_PRIVATE);
        SharedPreferences.Editor Obj_editor = sesion.edit();
        Obj_editor.putString("email",email);
        Obj_editor.putString("metodo",metodo);
        Obj_editor.apply();
        Obj_editor.commit();

        // Configuracion Remota (Parametros de configuracion)
        mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder()
                .setMinimumFetchIntervalInSeconds(60)
                .build();
        mFirebaseRemoteConfig.setConfigSettingsAsync(configSettings);
        mFirebaseRemoteConfig.fetchAndActivate()
                .addOnCompleteListener(this, new OnCompleteListener<Boolean>() {
                    @Override
                    public void onComplete(@NonNull Task<Boolean> task) {
                        if (task.isSuccessful()){
                            boolean updated = task.getResult();
                            Toast.makeText(HomeActivity.this, "Configuracion Remota obtenida satisfactoriamente", Toast.LENGTH_LONG).show();
                            mostrarBotonError = mFirebaseRemoteConfig.getBoolean("show_button");
                            String textoBotonError = mFirebaseRemoteConfig.getString("button_text");
                            if ( mostrarBotonError ){
                                errorButton.setVisibility(View.VISIBLE);
                                errorButton.setText(textoBotonError);
                            } else {
                                Toast.makeText(HomeActivity.this, "Fetch failed", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                });

        tvemail.setText(email);
        tvmetodo.setText(metodo);

        // Firestorage
        db = FirebaseFirestore.getInstance();

        guardarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtenemos los datos del usuario actualizados
                Map<String, Object> usuario = new HashMap<>();
                usuario.put("email", email);
                usuario.put("metodo",metodo);
                usuario.put("direccion", direccionET.getText().toString() );
                usuario.put("telefono", telefonoET.getText().toString() );

                db.collection("usuarios").document(email).set(usuario);
            }
        });

        //CLICK EN RECUPERAR
        recuperarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.collection("usuarios")
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        direccionET.setText(document.getString("direccion"));
                                        telefonoET.setText(document.getString("telefono"));
                                    }
                                } else {
                                    Log.w("TAG", "Error getting documents.", task.getException());
                                }
                            }
                        });
            }
        });



        borrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db.collection("usuarios").document(email).delete();
            }
        });

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Al hacer click en Salir borramos los datos guardados en preferencias
                SharedPreferences sesion = getSharedPreferences("sesion", Context.MODE_PRIVATE);
                SharedPreferences.Editor Obj_editor = sesion.edit();
                Obj_editor.clear();
                Obj_editor.apply();

                FirebaseAuth.getInstance().signOut();
                onBackPressed();
            }
        });

    }
}