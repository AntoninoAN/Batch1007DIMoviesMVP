package com.example.ditest.di.component;

import com.example.ditest.di.CustomApplication;
import com.example.ditest.di.module.ModuleApplication;
import com.example.ditest.di.module.ModuleNetwork;
import com.example.ditest.di.module.ModulePresenter;
import com.example.ditest.di.module.ModuleView;
import com.example.ditest.presenter.Presenter;
import com.example.ditest.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ModuleApplication.class,
        ModuleNetwork.class,
        ModuleView.class,
        ModulePresenter.class})
public interface MovieComponent {
     void inject(MainActivity activity);
}
