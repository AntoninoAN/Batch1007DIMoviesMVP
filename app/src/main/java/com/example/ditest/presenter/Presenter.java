package com.example.ditest.presenter;

import android.util.Log;

import com.example.ditest.model.MovieResult;
import com.example.ditest.model.Network;
import com.example.ditest.view.ViewContract;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Presenter {
    private static final String TAG = "Presenter";
    private ViewContract view;

    private Network network;
    public Presenter(Network network){
        this.network = network;
    }

    public void initView(ViewContract view){
        this.view = view;
    }

    public void initNetworkCall(){
        network.getApi()
                .getMovies().enqueue(new Callback<MovieResult>() {
            @Override
            public void onResponse(Call<MovieResult> call,
                                   Response<MovieResult> response) {
                Log.d(TAG, "onResponse: "+response.body());
                sendDataSet(response.body());
            }

            @Override
            public void onFailure(Call<MovieResult> call,
                                  Throwable t) {
                sendError(t.getMessage());
            }
        });
    }

    void sendError(String errorMessage){
        view.getError(errorMessage);
    }

    void sendDataSet(MovieResult data){
        view.getData(data);
    }

    public void getFilterData(String query){
        //todo db.filterData...
    }
}
