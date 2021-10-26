package com.alberto.a9listapersonalizada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alberto.a9listapersonalizada.adaptadores.Adaptador;
import com.alberto.a9listapersonalizada.model.Entidad;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvItems;
    private Adaptador adaptador;
    private ArrayList<Entidad> arrayEntidad = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvItems = findViewById(R.id.lvItems);

        llenarItems();

        // Gestionamos el evento click de la FORMA A
        /*
        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
                intent.putExtra("item", arrayEntidad.get(position));
                startActivity(intent);
            }
        });
        */

    }

    private void llenarItems() {

        arrayEntidad.add(new Entidad(R.drawable.dbs_1,"SS BLUES","Goku y Vegeta"));
        arrayEntidad.add(new Entidad(R.drawable.dbs_2,"SS BLUES Y SS ROSE","Goku y Black"));
        arrayEntidad.add(new Entidad(R.drawable.dbs_3,"DB HEROES 1","Personajes Nuevos"));
        arrayEntidad.add(new Entidad(R.drawable.dbs_4,"DB HEROES 2","Otros personajes, Majin Boo"));
        arrayEntidad.add(new Entidad(R.drawable.dbs_4,"VEGETA","Sacrificio de Vegeta"));

        adaptador = new Adaptador(arrayEntidad,this);
        lvItems.setAdapter(adaptador);
    }
}




















