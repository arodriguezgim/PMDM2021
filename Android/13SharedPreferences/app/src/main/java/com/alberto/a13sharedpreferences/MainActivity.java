package com.alberto.a13sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    EditText editTextEmail, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnEntrar);
        editTextEmail = findViewById(R.id.editTextTextEmailAddress);
        editTextPassword = findViewById(R.id.editTextTextPassword);

        // 1 - Al iniciar la aplicacion debe mostar lo que tiene guardado en el archivo SharedPreferences
        // Obtengo los valores que se han creado previamente
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);

        if (preferencias.getString("email", "") != ""){
            Intent i = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(i);
        }
        // Aquí tenemos que escribir LA REFERENCIA del valor que buscamos.
        // El par de comillas vacío es el valor inicial EN CASO DE QUE NO HAYA ningun valor.
        editTextEmail.setText(preferencias.getString("email", ""));
        editTextPassword.setText(preferencias.getString("pass", ""));


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Guardar();
                Toast.makeText(MainActivity.this,"Se ha guardado correctamente", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void Guardar(){

        // En este caso hemos de crear el objeto nuevamente
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        // Editor es la clase que me sirve paramodificar este archivo
        // Vamos a modificar el archivo SharedPreferences
        SharedPreferences.Editor Obj_editor = preferencias.edit();

        Obj_editor.putString("email",editTextEmail.getText().toString());
        Obj_editor.putString("pass",editTextPassword.getText().toString());
        // Commit confirma que lo que acabamos de recuperar arriba lo queremos GUARDAR. Sin Commit no guarda nada en SharedPreferences
        Obj_editor.commit();
        finish();
    }
}









































