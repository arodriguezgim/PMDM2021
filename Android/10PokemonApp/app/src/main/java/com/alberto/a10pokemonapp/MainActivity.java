package com.alberto.a10pokemonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.alberto.a10pokemonapp.adapter.PokemonListAdapter;
import com.alberto.a10pokemonapp.fragments.DetailFragment;
import com.alberto.a10pokemonapp.interfaces.iComunicaFragments;
import com.alberto.a10pokemonapp.model.Pokemon;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements iComunicaFragments {

    DetailFragment detalleFragmentPokemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void enviarPokemon(Pokemon pokemon) {

        //Esta interfaz sirve como puente para comunicar los Fragments
        // Toast.makeText(this, pokemon.getNombre(), Toast.LENGTH_SHORT).show();

        // Aqui realiceramos toda la logica necesaria para poder realizar el envío
        detalleFragmentPokemon = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.pokemon_detail_fragment);
        detalleFragmentPokemon.setPokemonImage(pokemon.getImageUrl());

        detalleFragmentPokemon.playPokemonSound(pokemon.getSoundId());

    }
}






















