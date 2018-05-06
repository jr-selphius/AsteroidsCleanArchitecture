package com.marvel.selphius.asteroids_cleanarchitecture.list.di;

import com.marvel.selphius.asteroids_cleanarchitecture.list.ui.MainActivityFragment;

import dagger.Subcomponent;

@ListScope
@Subcomponent(modules = ListModule.class)
public interface ListComponent {
    void inject(MainActivityFragment target);
}

