package com.marvel.selphius.asteroids_cleanarchitecture.datasource;

import android.arch.lifecycle.LiveData;

import com.marvel.selphius.asteroids_cleanarchitecture.model.AsteroidEntity;

import java.util.List;

public interface DataSource {

    LiveData<List<AsteroidEntity>> getTodayAsteroids();
}
