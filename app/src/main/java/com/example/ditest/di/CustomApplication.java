package com.example.ditest.di;

import android.app.Application;
import android.content.Context;

import com.example.ditest.di.component.DaggerMovieComponent;
import com.example.ditest.di.component.MovieComponent;
import com.example.ditest.di.module.ModuleApplication;
import com.example.ditest.di.module.ModuleNetwork;
import com.example.ditest.di.module.ModulePresenter;
import com.example.ditest.di.module.ModuleView;
import com.example.ditest.model.Network;
import com.example.ditest.presenter.Presenter;

public class CustomApplication extends Application {

    private MovieComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerMovieComponent.builder()
                .moduleApplication(new ModuleApplication(this))
                .moduleNetwork(new ModuleNetwork())
                .modulePresenter(new ModulePresenter())
                .moduleView(new ModuleView())
                .build();

    }

    public static MovieComponent getComponent(Context context){
        return ((CustomApplication)context.getApplicationContext()).component;
    }
}
