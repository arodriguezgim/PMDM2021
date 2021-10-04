package com.alberto.a5_registrodesocios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGuardar = findViewById(R.id.boton_guardar);
        EditText etNombre = findViewById(R.id.nombre_socio);
        EditText etApellido = findViewById(R.id.apellido_socio);
        RatingBar rtBar = findViewById(R.id.ratingBar);

        btnGuardar.setOnClickListener(view -> {

            String nombreSocio = etNombre.getText().toString();
            String apellidoSocio = etApellido.getText().toString();
            Float puntuacion = rtBar.getRating();

            Intent irDetalle = new Intent(this, DetailActivity.class);
            startActivity(irDetalle);

        });

    }
}