package com.alberto.a19_firebasedam21;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

enum ProviderType {
    BASIC, GOOGLE, FACEBOOK
}
public class LoginActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    Button btnRegistrar, btnLogin;

    private FirebaseAnalytics mFirebaseAnalytics;
    // Autentificacion FIREBASE
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");
        etEmail = findViewById(R.id.emaileditText);
        etPassword = findViewById(R.id.passwordeditText);
        btnRegistrar = findViewById(R.id.registerButton);
        btnLogin = findViewById(R.id.loginButton);
        // esto es del servicio ANALYTICS
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString("DAM2","Aplicacion Iniciada");
        mFirebaseAnalytics.logEvent("DAM2", bundle);
        // Inicializo Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registroUsuarioEmailPass();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loguarseWithEmailAndPassword();
            }
        });


    }

    private void loguarseWithEmailAndPassword() {
        String _email = etEmail.getText().toString();
        String _password = etPassword.getText().toString();

        mAuth.signInWithEmailAndPassword(_email, _password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("FIREBASE", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            iraHome(_email, ProviderType.BASIC );
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("FIREBASE", "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    private void iraHome(String email, ProviderType tipoLogueo) {
        Intent i = new Intent(LoginActivity.this, HomeActivity.class);
        i.putExtra("email", email );
        i.putExtra("metodo", tipoLogueo);
        startActivity(i);
    }

    private void registroUsuarioEmailPass() {

        String _email = etEmail.getText().toString();
        String _password = etPassword.getText().toString();

        if ( !_email.isEmpty() && !_password.isEmpty() ){
            // Si el email y el passwor introducido no estan vacios
            mAuth.createUserWithEmailAndPassword( _email, _password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if ( task.isSuccessful() ){
                                // El registro es satisfactorio
                                Log.i("FIREBASE","El usuario ha sido creado correctamente");
                                Toast.makeText(LoginActivity.this, "El Usuario SE HA CREADO Satisfactoriamente", Toast.LENGTH_LONG).show();
                                FirebaseUser user = mAuth.getCurrentUser();
                            } else {
                                Log.w("FIREBASE", "createUserWithEmailAndPassword: failure", task.getException());
                                Toast.makeText(LoginActivity.this, "Ha fallado el CREARSE un usuario", Toast.LENGTH_LONG).show();
                            }

                        }
                    });
        }
    }
}




















