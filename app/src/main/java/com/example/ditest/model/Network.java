package com.example.ditest.model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {

    public ApiInterface getApi(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://movies-sample.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ApiInterface.class);
    }
}
