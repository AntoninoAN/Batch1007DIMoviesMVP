package com.example.ditest.di.module;

import android.content.Context;

import com.example.ditest.di.CustomApplication;
import com.example.ditest.view.CustomAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class ModuleApplication {

    private CustomApplication app;

    public ModuleApplication(CustomApplication app){
        this.app = app;
    }

    @Provides
    public CustomApplication provideApplication(){
        return app;
    }

    @Provides
    public Context provideContext(){
        return app.getBaseContext();
    }
}
