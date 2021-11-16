package com.alberto.a16_pokefit;

import com.alberto.a16_pokefit.model.PokemonRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokemonService {
    @GET("pokemon")
    Call<PokemonRespuesta> obtenerListaPokemon();
}
