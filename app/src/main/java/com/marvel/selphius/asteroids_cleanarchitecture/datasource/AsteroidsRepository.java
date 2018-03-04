package com.marvel.selphius.asteroids_cleanarchitecture.datasource;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;

import com.marvel.selphius.asteroids_cleanarchitecture.datasource.local.LocalDataSource;
import com.marvel.selphius.asteroids_cleanarchitecture.datasource.remote.RemoteDataSource;
import com.marvel.selphius.asteroids_cleanarchitecture.datasource.remote.model.Asteroid;
import com.marvel.selphius.asteroids_cleanarchitecture.di.ApiResponse;
import com.marvel.selphius.asteroids_cleanarchitecture.mappers.RemoteToAsteroidEntityMapper;
import com.marvel.selphius.asteroids_cleanarchitecture.model.AsteroidEntity;

import java.util.List;

public class AsteroidsRepository implements DataSource {

    /**
     * At this moment there is not coordination between differents
     * datasources.
     */
    private LocalDataSource localDataSource;

    private RemoteDataSource remoteDatasource;

    public AsteroidsRepository(LocalDataSource localDataSource, RemoteDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDatasource = remoteDataSource;
    }

    @Override
    public LiveData<List<AsteroidEntity>> getTodayAsteroids() {

        return Transformations.map(remoteDatasource.getTodayAsteroids(), new Function<ApiResponse<List<Asteroid>>, List<AsteroidEntity>>() {
            @Override
            public List<AsteroidEntity> apply(ApiResponse<List<Asteroid>> input) {
                List<Asteroid> remoteAsteroids = input.body;
                RemoteToAsteroidEntityMapper remoteToAsteroidEntityMapper = new RemoteToAsteroidEntityMapper();
                return remoteToAsteroidEntityMapper.map(remoteAsteroids);
            }
        });

    }
}
