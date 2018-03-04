package com.marvel.selphius.asteroids_cleanarchitecture.datasource.remote.api;

import android.arch.lifecycle.LiveData;

import com.marvel.selphius.asteroids_cleanarchitecture.datasource.remote.model.Asteroid;

import java.util.List;

import retrofit2.http.GET;

public interface AsteroidNasaService {

    @GET("feed/today?detailed=false&api_key=DEMO_KEY")
    LiveData<ApiResponse<List<Asteroid>>> getTodayAsteroids();

}
