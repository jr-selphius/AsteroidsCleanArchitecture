package com.marvel.selphius.asteroids_cleanarchitecture.datasource.local;

import android.arch.lifecycle.LiveData;

import com.marvel.selphius.asteroids_cleanarchitecture.datasource.local.model.Asteroid;

import java.util.List;

public class LocalDataSourceImpl implements LocalDataSource {

    private AsteroidDao asteroidDao;

    public LocalDataSourceImpl(AsteroidDao asteroidDao) {
        this.asteroidDao = asteroidDao;
    }

    @Override
    public LiveData<List<Asteroid>> getAsteroidsByDate(String date) {

        return asteroidDao.findByDate(date);
    }

    @Override
    public void insertAsteroids(List<Asteroid> asteroids) {
        asteroidDao.insertAll(asteroids);
    }
}
