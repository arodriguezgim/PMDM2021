package com.alberto.a8versionesdeandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    // 1 - Declaramos el elemento ListView
    ListView lista;
    // 3 - Nos declaramos la lista de elementos que vamos a mostrar
    List<String> androidVersionesLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2- Conectamos el elemento Listview con la vista
        lista = findViewById(R.id.listViewVersiones);
        // 4 - Cargamos la lista de elementos
        androidVersionesLista = new ArrayList<>();

        androidVersionesLista.add("Pie");
        androidVersionesLista.add("Oreo");
        androidVersionesLista.add("Nougat");
        androidVersionesLista.add("Marshmallow");
        androidVersionesLista.add("Lollipop");
        androidVersionesLista.add("KitKat");
        androidVersionesLista.add("...");

        // 5- Nos definimos EL ADAPTADOR:
        // Este adaptador coge la lista de strings y las va pintando en el ListView. Tantos como elemento visuales.
        ArrayAdapter adaptadorDeVersionesAndroid = new ArrayAdapter(
                this,   // Dónde nos encontramos
                android.R.layout.simple_list_item_1, // template que usamos para mostrar los resultados ( este lo lleva nativamente Android)
                androidVersionesLista  //  La lista de elementos que queremos mostrar por pantalla
        );

        // 6 - Vinculamos el ListView con la lista definida en el adaptador

        lista.setAdapter(adaptadorDeVersionesAndroid);

        // 7 - Gestionamos el evento click en cada elemento de la lista
        lista.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String version = androidVersionesLista.get(position);
        Toast.makeText(this,"La version seleccionada es " + version, Toast.LENGTH_SHORT).show();
    }







}














