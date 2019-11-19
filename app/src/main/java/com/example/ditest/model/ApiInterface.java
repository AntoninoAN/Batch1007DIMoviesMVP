package com.example.ditest.model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    //
    @GET("api/movies")
    Call<MovieResult> getMovies();
}
