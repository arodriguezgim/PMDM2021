package com.alberto.a19_firebasedam21;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

public class HomeActivity extends AppCompatActivity {

    TextView tvemail, tvmetodo;
    Button logOut, errorButton;
    boolean mostrarBotonError;
    // Remote Config
    private FirebaseRemoteConfig mFirebaseRemoteConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvemail = findViewById(R.id.emailTextView);
        tvmetodo = findViewById(R.id.metodoTextView);
        logOut = findViewById(R.id.logoutButton);
        errorButton = findViewById(R.id.errorButton);

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