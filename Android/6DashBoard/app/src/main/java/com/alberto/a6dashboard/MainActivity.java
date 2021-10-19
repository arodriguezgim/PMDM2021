package com.alberto.a6dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.alberto.a6dashboard.activities.Amigos_Activity;
import com.alberto.a6dashboard.activities.Calculadora_Activity;
import com.alberto.a6dashboard.activities.EdadCanina_Activity;
import com.alberto.a6dashboard.activities.Galeria_Activity;
import com.alberto.a6dashboard.activities.Mapas_Activity;
import com.alberto.a6dashboard.activities.Quizzes_Activity;
import com.alberto.a6dashboard.activities.Restaurantes_Activity;
import com.alberto.a6dashboard.activities.Settings_Activity;

public class MainActivity extends AppCompatActivity {

    RelativeLayout rellay_calculadora, rellay_amigos, rellay_perrete, rellay_quizzes, rellay_galeria, rellay_mapas, rellay_restaurantes, rellay_settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rellay_calculadora = findViewById(R.id.rellay_calculadora);
        rellay_amigos = findViewById(R.id.rellay_amigos);
        rellay_perrete = findViewById(R.id.rellay_perrete);
        rellay_quizzes = findViewById(R.id.rellay_quizzes);
        rellay_galeria = findViewById(R.id.rellay_galeria);
        rellay_mapas = findViewById(R.id.rellay_mapas);
        rellay_restaurantes = findViewById(R.id.rellay_restaurantes);
        rellay_settings = findViewById(R.id.rellay_settings);

        rellay_calculadora.setOnClickListener( v -> {
            Intent intent = new Intent(this, Calculadora_Activity.class);
            startActivity(intent);
        });

        rellay_amigos.setOnClickListener( v -> {
            Intent intent = new Intent(this, Amigos_Activity.class);
            startActivity(intent);
        });

        rellay_perrete.setOnClickListener( v -> {
            Intent intent = new Intent(this, EdadCanina_Activity.class);
            startActivity(intent);
        });
        rellay_quizzes.setOnClickListener( v -> {
            Intent intent = new Intent(this, Quizzes_Activity.class);
            startActivity(intent);
        });
        rellay_galeria.setOnClickListener( v -> {
            Intent intent = new Intent(this, Galeria_Activity.class);
            startActivity(intent);
        });
        rellay_mapas.setOnClickListener( v -> {
            Intent intent = new Intent(this, Mapas_Activity.class);
            startActivity(intent);
        });
        rellay_restaurantes.setOnClickListener( v -> {
            Intent intent = new Intent(this, Restaurantes_Activity.class);
            startActivity(intent);
        });
        rellay_settings.setOnClickListener( v -> {
            Intent intent = new Intent(this, Settings_Activity.class);
            startActivity(intent);
        });
    }















}