package com.marvel.selphius.asteroids_cleanarchitecture.datasource.remote;

import android.arch.lifecycle.LiveData;

import com.marvel.selphius.asteroids_cleanarchitecture.datasource.remote.api.AsteroidNasaService;
import com.marvel.selphius.asteroids_cleanarchitecture.datasource.remote.model.Asteroid;
import com.marvel.selphius.asteroids_cleanarchitecture.datasource.remote.api.ApiResponse;

import java.util.List;

/**
 * Created by selphius on 2/3/18.
 */

public class RemoteDataSourceImpl implements RemoteDataSource {

    private AsteroidNasaService service;

    public RemoteDataSourceImpl(AsteroidNasaService service) {
        this.service = service;
    }

    @Override
    public LiveData<ApiResponse<List<Asteroid>>> getTodayAsteroids() {
        return service.getTodayAsteroids();
    }
}
