package com.alberto.a12restaurantes;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.alberto.a12restaurantes.model.Restaurante;
import com.alberto.a12restaurantes.databinding.FragmentRestauranteBinding;
import com.bumptech.glide.Glide;

import java.util.List;


public class MyRestauranteRecyclerViewAdapter extends RecyclerView.Adapter<MyRestauranteRecyclerViewAdapter.ViewHolder> {

    private final List<Restaurante> mValues;
    // 5 - Rescatamos el contexto desde el fragment
    private Context ctx;

    public MyRestauranteRecyclerViewAdapter(Context context, List<Restaurante> items) {
        ctx = context;
        mValues = items;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentRestauranteBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }
    // METODO IMPORTANTE: Realiza el dibujado de la lista.
    // Es lanzado tantas veces como elementos tengamos en la lista
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        // 3 - Rescatamos los datos del elemento que ocupa la posicion "position".
        holder.mItem = mValues.get(position);
        holder.textViewNombreRestaurante.setText(mValues.get(position).getNombre());
        holder.textViewDireccionRestaurante.setText(mValues.get(position).getDireccion());
        holder.ratingBarRestaurante.setRating(mValues.get(position).getValoracion());
        // 4 - Implementamos la carga de la imagen que ocupa el ImageView

        Glide.with(ctx).load(mValues.get(position).getUrlFoto()).into(holder.imageViewFotoRestaurante);
    }

    // Devuelve el valor del tamaño de la lista de Restaurantes
    @Override
    public int getItemCount() {
        return mValues.size();
    }

    // Esta clase mapea el diseño de los objetos del layout donde definimos un elemento de la lista.
    // coge cada uno de los elementos de nuestro layout y los asigna a una variable final del tipo que sea.
    // Esta clase depende en gran medida del diseño que tengamos

    public class ViewHolder extends RecyclerView.ViewHolder {
        // 1 - Cada componente que tenemos en cada fila
        public final TextView textViewNombreRestaurante;
        public final TextView textViewDireccionRestaurante;
        public final ImageView imageViewFotoRestaurante;
        public final RatingBar ratingBarRestaurante;

        public Restaurante mItem;

        // Dentro de este metodo constructor recibiremos por parametro el layout completo.
        // y a partir de ese elemento raiz podemos buscar el elemento en cuestion.
        public ViewHolder(FragmentRestauranteBinding binding) {
            super(binding.getRoot());
            // 2 - Vinculamos los elementos
            textViewNombreRestaurante = binding.textViewNombre;
            textViewDireccionRestaurante = binding.textViewDireccion;
            imageViewFotoRestaurante = binding.imageViewRestaurante;
            ratingBarRestaurante = binding.ratingBarValoracion;

        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewNombreRestaurante.getText() + "'";
        }
    }
}









