package com.marvel.selphius.asteroids_cleanarchitecture.datasource.remote;

import android.arch.lifecycle.LiveData;

import com.marvel.selphius.asteroids_cleanarchitecture.datasource.remote.model.Asteroid;
import com.marvel.selphius.asteroids_cleanarchitecture.di.ApiResponse;

import java.util.List;

public interface RemoteDataSource {

    LiveData<ApiResponse<List<Asteroid>>> getTodayAsteroids();
}
