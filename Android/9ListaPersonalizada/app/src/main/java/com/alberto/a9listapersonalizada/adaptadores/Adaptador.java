package com.alberto.a9listapersonalizada.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.alberto.a9listapersonalizada.DetalleActivity;
import com.alberto.a9listapersonalizada.R;
import com.alberto.a9listapersonalizada.model.Entidad;

import java.util.ArrayList;

// 4 - extendemos de BaseAdapter y generamos los metodos
public class Adaptador extends BaseAdapter {
    // 1 - Creamos el arraylist de Entidad que serán los datos que
    //mostrará el ListView
    private ArrayList<Entidad> listEntidad;
    // 2 - Creamos un contexto
    private Context context;
    private LayoutInflater inflater;

    // 3 - Generamos el constructor
    public Adaptador(ArrayList<Entidad> listEntidad, Context context) {
        this.listEntidad = listEntidad;
        this.context = context;
    }

    // Este metodo indicará al ListView cuantos datos o numero de objetos se van a cargar (el tamaño)
    @Override
    public int getCount() {
        return listEntidad.size();
    }

    // Este metodo devolverá la posicion
    @Override
    public Object getItem(int position) {
        return listEntidad.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    // Aquí se creará cada item y se le asignará los valores
    //para cada elemento de cada item
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtenemos el objeto por cada Item a mostrar
        final Entidad entidad = (Entidad) getItem(position);

        // Creamos e inicializamos los elementos del item de la lista
        convertView = LayoutInflater.from(context).inflate(R.layout.item, null);
        ImageView imgFoto = convertView.findViewById(R.id.imgFoto);
        TextView tvTitulo = convertView.findViewById(R.id.tvTitulo);
        TextView tvContenido = convertView.findViewById(R.id.tvContenido);

        // LLenamos los elemntos con los valores de cada Item
        imgFoto.setImageResource(entidad.getImgFoto());
        tvTitulo.setText(entidad.getTitulo());
        tvContenido.setText(entidad.getContenido());

        // Gestionamos el evento click de la FORMA B
        convertView.setOnClickListener( v -> {

            Intent i = new Intent(context, DetalleActivity.class);
            i.putExtra("item", entidad);
            context.startActivity(i);

        });





        return convertView;
    }
}




















