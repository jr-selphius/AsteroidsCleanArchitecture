package com.marvel.selphius.asteroids_cleanarchitecture.datasource.remote;

import android.arch.lifecycle.LiveData;

import com.marvel.selphius.asteroids_cleanarchitecture.datasource.remote.model.Asteroid;
import com.marvel.selphius.asteroids_cleanarchitecture.di.ApiResponse;

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
        /*final MutableLiveData<List<Asteroid>> liveData = new MutableLiveData<>();
        service.getTodayAsteroids().enqueue(new Callback<List<Asteroid>>() {
            @Override
            public void onResponse(Call<List<Asteroid>> call, Response<List<Asteroid>> response) {
                if (response.isSuccessful()) {
                    List<Asteroid> asteroids = response.body();
                    liveData.setValue(asteroids);
                }
            }

            @Override
            public void onFailure(Call<List<Asteroid>> call, Throwable t) {
                Timber.d("onFailure");
            }
        });

        return liveData;*/

        return service.getTodayAsteroids();
    }
}
