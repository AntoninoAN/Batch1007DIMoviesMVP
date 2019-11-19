package com.example.ditest.di.module;

import com.example.ditest.model.Network;
import com.example.ditest.presenter.Presenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ModulePresenter {

    @Provides
    public Presenter providePresenter(Network network){
        return new Presenter(network);
    }
}
