package com.marvel.selphius.asteroids_cleanarchitecture.datasource.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.marvel.selphius.asteroids_cleanarchitecture.datasource.local.model.Asteroid;

@Database(entities = {Asteroid.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AsteroidDao asteroidDao();
}
