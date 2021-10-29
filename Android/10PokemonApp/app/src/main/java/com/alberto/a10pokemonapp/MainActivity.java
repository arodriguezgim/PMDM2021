package com.alberto.a10pokemonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.alberto.a10pokemonapp.adapter.PokemonListAdapter;
import com.alberto.a10pokemonapp.model.Pokemon;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvPokemons;
    private PokemonListAdapter adaptador;
    private ArrayList<Pokemon> pokemonList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvPokemons = findViewById(R.id.pokemon_listView);

        pokemonList.add(new Pokemon("1","Bulbasaur",Pokemon.Type.PLANT));
        pokemonList.add(new Pokemon("2","IvySaur",Pokemon.Type.PLANT));
        pokemonList.add(new Pokemon("3","VenuaSaur",Pokemon.Type.PLANT));
        pokemonList.add(new Pokemon("4","Charmander",Pokemon.Type.FIRE));
        pokemonList.add(new Pokemon("5","Charmeleon",Pokemon.Type.WATER));
        pokemonList.add(new Pokemon("6","Charizard",Pokemon.Type.FIRE));
        pokemonList.add(new Pokemon("7","Squirtle",Pokemon.Type.WATER));
        pokemonList.add(new Pokemon("8","Blastoise",Pokemon.Type.ELECTRIC));
        pokemonList.add(new Pokemon("25","Pikachu",Pokemon.Type.ELECTRIC));
        pokemonList.add(new Pokemon("26","Raichu",Pokemon.Type.ELECTRIC));

        adaptador = new PokemonListAdapter(this,pokemonList,R.id.item);
        lvPokemons.setAdapter(adaptador);

        lvPokemons.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Pokemon selectedPokemon = (Pokemon) adaptador.getItem(position);
                if (selectedPokemon != null){
                    Toast.makeText(MainActivity.this,selectedPokemon.getNombre(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }











}