package com.alberto.a10pokemonapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.alberto.a10pokemonapp.R;
import com.alberto.a10pokemonapp.model.Pokemon;

import java.util.ArrayList;

public class PokemonListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Pokemon> pokemonList;
    private int layoutId;

    public PokemonListAdapter(Context context, ArrayList<Pokemon> pokemonList, int layoutId) {
        this.context = context;
        this.pokemonList = pokemonList;
        this.layoutId = layoutId;
    }

    @Override
    public int getCount() {
        return pokemonList.size();
    }

    @Override
    public Object getItem(int position) {
        return pokemonList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Pokemon pokemon = (Pokemon) getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.item,null);
        TextView pokemonIdTextView = convertView.findViewById(R.id.pokemon_list_id_textview);
        TextView pokemonNameTextView = convertView.findViewById(R.id.pokemon_list_name_textview);
        ImageView pokemonTypeImageView = convertView.findViewById(R.id.pokemon_list_type_image);

        //llenamos los elementos de la lista
        pokemonIdTextView.setText(pokemon.getId());
        pokemonNameTextView.setText(pokemon.getNombre());
        final Pokemon.Type type = pokemon.getType();
        //En base al superpoder que tenga, le asignaremos un icono u otro
        switch (type){
            case FIRE:
                pokemonTypeImageView.setImageResource(R.drawable.fire);
                break;
            case WATER:
                pokemonTypeImageView.setImageResource(R.drawable.water);
                break;
            case PLANT:
                pokemonTypeImageView.setImageResource(R.drawable.plant);
                break;
            case ELECTRIC:
                pokemonTypeImageView.setImageResource(R.drawable.electric);
                break;
        }

        return convertView;
    }







}
