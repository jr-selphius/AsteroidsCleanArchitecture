package com.marvel.selphius.asteroids_cleanarchitecture;

import android.support.multidex.MultiDexApplication;

import com.marvel.selphius.asteroids_cleanarchitecture.di.ApplicationComponent;
import com.marvel.selphius.asteroids_cleanarchitecture.di.ApplicationModule;
import com.marvel.selphius.asteroids_cleanarchitecture.di.DaggerApplicationComponent;
import com.marvel.selphius.asteroids_cleanarchitecture.list.di.ListComponent;
import com.marvel.selphius.asteroids_cleanarchitecture.list.di.ListModule;

public class CustomApplication extends MultiDexApplication {

    private ApplicationComponent component;

    private ListComponent listComponent;

    public ApplicationComponent getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        component.inject(this);
    }

    public ListComponent createListComponent() {
        listComponent = component.plus(new ListModule());
        return listComponent;
    }

    public void releaseListComponent() {
        listComponent = null;
    }
}
