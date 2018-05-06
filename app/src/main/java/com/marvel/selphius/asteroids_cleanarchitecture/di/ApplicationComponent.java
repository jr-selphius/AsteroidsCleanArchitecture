package com.marvel.selphius.asteroids_cleanarchitecture.di;

import com.marvel.selphius.asteroids_cleanarchitecture.CustomApplication;
import com.marvel.selphius.asteroids_cleanarchitecture.list.di.ListComponent;
import com.marvel.selphius.asteroids_cleanarchitecture.list.di.ListModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(CustomApplication target);
    ListComponent plus(ListModule listModule);
}
