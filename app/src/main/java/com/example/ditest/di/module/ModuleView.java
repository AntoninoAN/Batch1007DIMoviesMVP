package com.example.ditest.di.module;

import android.content.Context;

import androidx.recyclerview.widget.GridLayoutManager;

import com.example.ditest.view.CustomAdapter;
import com.example.ditest.view.CustomViewHolder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ModuleView {

    @Provides
    public CustomAdapter provideAdapter(){
        return new CustomAdapter();
    }

    @Provides
    public GridLayoutManager provideLayoutManager(Context context){
        return new GridLayoutManager(context, 3);
    }

}
