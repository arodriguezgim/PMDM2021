package com.alberto.a19_firebasedam21;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

enum ProviderType {
    BASIC,
    GOOGLE
}
public class LoginActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    Button btnRegistrar, btnLogin, btnGoogle;
    LinearLayout authLayout;

    private FirebaseAnalytics mFirebaseAnalytics;
    // Autentificacion FIREBASE
    private FirebaseAuth mAuth;
    // Cliente GOOGLE
    private GoogleSignInClient mGoogleSignInClient;


    @Override
    protected void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        authLayout.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");
        etEmail = findViewById(R.id.emaileditText);
        etPassword = findViewById(R.id.passwordeditText);
        btnRegistrar = findViewById(R.id.registerButton);
        btnLogin = findViewById(R.id.loginButton);
        authLayout = findViewById(R.id.authLayout);
        btnGoogle = findViewById(R.id.loginGoogleButton);
        // esto es del servicio ANALYTICS
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString("DAM2","Aplicacion Iniciada");
        mFirebaseAnalytics.logEvent("DAM2", bundle);
        // Inicializo Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        // Comprobar si tenemos una sesion abierta
        comprobarSiLogin();
        // Notificaciones Push
        notificaciones();

        
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

        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logueoConGoogle();
            }
        });

    }

    private void notificaciones() {

        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                            return;
                        }

                        // Get new FCM registration token
                        String token = task.getResult();
                        Log.i("FIREBASE", "El token de mi movil es: "+token);

                    }
                });
    }

    private void logueoConGoogle() {
        // Al hacer click en el boton Login with Google
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("396174173353-gm4bv1b8omiq4un91f62936h9ap5703i.apps.googleusercontent.com")
                .requestEmail()
                .build();
        // Nos creamos el GoogleSignIn Client conlas opciones específicas de gso
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        signIn();
    }
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ( requestCode == 100){
            //Esto significa que venimos de loguearnos con Google
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                Log.d("FIREBASE", "firebaseAuthWithGoogle:" + account.getId());
                firebaseAuthWithGoogle(account.getIdToken());
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w("FIREBASE", "Google sign in failed", e);
            }

        }
    }

    private void firebaseAuthWithGoogle(String idToken) {

        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("FIREBASE", "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            iraHome(user.getEmail(), ProviderType.GOOGLE);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("FIREBASE", "signInWithCredential:failure", task.getException());

                        }
                    }
                });
    }

    private void comprobarSiLogin() {
        SharedPreferences sesion = getSharedPreferences("sesion", Context.MODE_PRIVATE);
        String _email = sesion.getString("email", null);
        String _metodo = sesion.getString("metodo", null);
        if ( _email != null && _metodo != null){
            authLayout.setVisibility(View.INVISIBLE);
            iraHome(_email, ProviderType.valueOf(_metodo));
        }
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
        i.putExtra("metodo", tipoLogueo.toString());
        startActivity(i);
    }

    private void registroUsuarioEmailPass() {

        String _email = etEmail.getText().toString();
        String _password = etPassword.getText().toString();

        if ( !_email.isEmpty() && !_password.isEmpty() ){
            // Si el email y el password introducido no estan vacios
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




















