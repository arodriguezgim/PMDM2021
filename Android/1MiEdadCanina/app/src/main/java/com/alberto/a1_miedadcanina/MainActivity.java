package com.alberto.a1_miedadcanina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1 - Agregamos los ids a los elementos
        EditText edadEdit = findViewById(R.id.edad_et);
        TextView resultadoText =findViewById(R.id.resultado_tv);
        Button boton = findViewById(R.id.button_btn);

//        Log.v("MainActivity", "La actividad principal se ha creado");
        Log.d("MainActivity", "La actividad principal se ha creado");
//        Log.i("MainActivity", "La actividad principal se ha creado");
//        Log.w("MainActivity", "La actividad principal se ha creado");
//        Log.e("MainActivity", "La actividad principal se ha creado");


        // 2- Damos actividad al boton al ser pulsado
        boton.setOnClickListener( view -> {
            // 3- Recogemos el texto del EditText
            String edad = edadEdit.getText().toString();

            if ( !edad.isEmpty() ){
                //4 - Convertimo sese String a entero
                int edadInt = Integer.parseInt(edad);
                //5 - Calculamos la edad canina
                int resultado = edadInt * 7;
                // 6 - Creamos el texto que vamos a a mostrar
                String resultadoString = getString(R.string.texto_resultado, resultado);
                // 7 - Asignamos el texto al elemento TextView
                resultadoText.setText(resultadoString);
            } else {
                Log.d("MainActivity","Has introducido un campo vacio");

                Toast.makeText(this, getString(R.string.msg_toast),Toast.LENGTH_SHORT).show();
            }


        });
    }
}