package com.alberto.a14retrofitv1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<Post>> obtenerPostDeLaApi();
}
