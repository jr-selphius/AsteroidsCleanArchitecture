package com.marvel.selphius.asteroids_cleanarchitecture.datasource.local;

import android.arch.lifecycle.LiveData;

import com.marvel.selphius.asteroids_cleanarchitecture.datasource.local.model.Asteroid;

import java.util.List;

public interface LocalDataSource {

    LiveData<List<Asteroid>> getTodayAsteroids();

    void insertAsteroids(List<Asteroid> asteroids);
}
