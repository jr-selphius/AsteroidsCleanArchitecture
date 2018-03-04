package com.marvel.selphius.asteroids_cleanarchitecture.datasource.local;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.marvel.selphius.asteroids_cleanarchitecture.datasource.local.model.Asteroid;

import java.util.List;


@Dao
public interface AsteroidDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Asteroid> asteroids);

    @Delete
    void delete(Asteroid asteroid);

    @Query("SELECT * FROM asteroids")
    LiveData<List<Asteroid>> getAll();

    @Query("SELECT * FROM asteroids WHERE date= :date")
    LiveData<List<Asteroid>> findByDate(String date);
}
