package com.alberto.a16_pokefit;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alberto.a16_pokefit.model.Pokemon;
import com.alberto.a16_pokefit.model.PokemonRespuesta;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class PokemonFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 3;

    RecyclerView recyclerView;
    MyPokemonRecyclerViewAdapter adaptador;
    Retrofit retrofit;

    public PokemonFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static PokemonFragment newInstance(int columnCount) {
        PokemonFragment fragment = new PokemonFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pokemon_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            //EMPIEZA LA FIESTA
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://pokeapi.co/api/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            obtenerDatos(retrofit,context);

            //recyclerView.setAdapter(adaptador);
        }
        return view;
    }

    private void obtenerDatos(Retrofit retrofit, Context context) {
        PokemonService service = retrofit.create(PokemonService.class);
        Call<PokemonRespuesta> pokemonRespuestaCall = service.obtenerListaPokemon();

        pokemonRespuestaCall.enqueue(new Callback<PokemonRespuesta>() {
            @Override
            public void onResponse(Call<PokemonRespuesta> call, Response<PokemonRespuesta> response) {
                if (response.isSuccessful()){
                    PokemonRespuesta pokemonRespuesta = response.body();
                    //PokemonRespuesta es una clase que nosotros creamos
                    // y que tiene un arraylist en Java con el listado de los objetos Pokemon
                    ArrayList<Pokemon> listaPokemon = pokemonRespuesta.getResults();

                    adaptador = new MyPokemonRecyclerViewAdapter(listaPokemon, context);
                    recyclerView.setAdapter(adaptador);
                } else {
                    Log.e("POKEMON","onResponse: " + response.body());
                }
            }

            @Override
            public void onFailure(Call<PokemonRespuesta> call, Throwable t) {
                Log.e("POKEMON","onFailure: " + t.getMessage());
            }
        });
    }
}








