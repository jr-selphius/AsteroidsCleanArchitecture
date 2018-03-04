package com.marvel.selphius.asteroids_cleanarchitecture;

import android.app.Application;

import com.marvel.selphius.asteroids_cleanarchitecture.di.ApplicationComponent;
import com.marvel.selphius.asteroids_cleanarchitecture.di.ApplicationModule;
import com.marvel.selphius.asteroids_cleanarchitecture.di.DaggerApplicationComponent;

public class CustomApplication extends Application {

    private ApplicationComponent component;

    public ApplicationComponent getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }
}
