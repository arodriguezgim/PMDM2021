package com.alberto.radiobuttonverdadero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup rg = findViewById(R.id.radioGroupSexo);
        RadioButton rbHombre = findViewById(R.id.radioButtonHombre);
        RadioButton rbMujer = findViewById(R.id.radioButtonMujer);
        RadioButton rbIndeterminado = findViewById(R.id.radioButtonIndeterminado);
    }

    public void sexoSeleccionado(View view) {


        switch(view.getId()) {
            case R.id.radioButtonHombre:
                Toast.makeText(this,"Ha seleccionado Hombre", Toast.LENGTH_SHORT).show();
                    break;
            case R.id.radioButtonMujer:
                Toast.makeText(this,"Ha seleccionado Mujer", Toast.LENGTH_SHORT).show();
                    break;
            case R.id.radioButtonIndeterminado:
                Toast.makeText(this,"No sabes ni lo que eres", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}