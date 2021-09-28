package com.alberto.a3_variosactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        Button botonIraAct1 = findViewById(R.id.btn2);
        Button botonIraAct3 = findViewById(R.id.btn3);

        botonIraAct1.setOnClickListener( view -> {

            Intent intentIrAct1 = new Intent(this, MainActivity.class);
            startActivity(intentIrAct1);
        });

        // Controlo el evento onClic en el segundo boton
        botonIraAct3.setOnClickListener( view -> {
            //Me creo el intent al activity 3
            Intent ira3 = new Intent(this, TerceraActivity.class);
            startActivity(ira3);
        });
    }
}