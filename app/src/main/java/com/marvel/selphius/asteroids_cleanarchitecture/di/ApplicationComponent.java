package com.marvel.selphius.asteroids_cleanarchitecture.di;

import com.marvel.selphius.asteroids_cleanarchitecture.list.ui.MainAsteroidsViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(MainAsteroidsViewModel target);
}
