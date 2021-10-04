package com.alberto.a3_variosactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnIrAc2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIrAc2 = findViewById(R.id.btn1);

        btnIrAc2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        // Para cambiar de activity lo primero que haremos
        // será crearnos el Intent
        // 1 - Le diremos en el primer campo desde dónde le llamamos y en el segundo a dónde queremos ir
        Intent iraActivity2 = new Intent(MainActivity.this, SegundaActivity.class);

        // 2 - Lanzamos el activity cpn el metodo startActivity

        startActivity(iraActivity2);


    }





















}