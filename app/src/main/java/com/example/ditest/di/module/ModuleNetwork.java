package com.example.ditest.di.module;

import com.example.ditest.model.Network;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ModuleNetwork {

    @Provides
    public Network provideNetwork(){
        return new Network();
    }
}
