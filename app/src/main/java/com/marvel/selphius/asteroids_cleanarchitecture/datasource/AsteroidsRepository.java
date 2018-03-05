package com.marvel.selphius.asteroids_cleanarchitecture.datasource;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.marvel.selphius.asteroids_cleanarchitecture.datasource.local.LocalDataSource;
import com.marvel.selphius.asteroids_cleanarchitecture.datasource.remote.RemoteDataSource;
import com.marvel.selphius.asteroids_cleanarchitecture.datasource.remote.api.ApiResponse;
import com.marvel.selphius.asteroids_cleanarchitecture.datasource.remote.model.Asteroid;
import com.marvel.selphius.asteroids_cleanarchitecture.mappers.LocalAsteroidToRemoteAsteroidMapper;
import com.marvel.selphius.asteroids_cleanarchitecture.mappers.LocalToAsteroidEntityMapper;
import com.marvel.selphius.asteroids_cleanarchitecture.mappers.RemoteToAsteroidEntityMapper;
import com.marvel.selphius.asteroids_cleanarchitecture.model.AsteroidEntity;
import com.marvel.selphius.asteroids_cleanarchitecture.util.NetworkBoundResource;
import com.marvel.selphius.asteroids_cleanarchitecture.util.Resource;

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
    public LiveData<Resource<List<AsteroidEntity>>> getTodayAsteroids() {

        return new NetworkBoundResource<List<AsteroidEntity>, List<Asteroid>>() {

            @Override
            protected void saveCallResult(@NonNull List<Asteroid> asteroids) {
                localDataSource.insertAsteroids(new LocalAsteroidToRemoteAsteroidMapper().reverseMap(asteroids));
            }

            @Override
            protected boolean shouldFetch(@Nullable List<AsteroidEntity> data) {
                return data == null || data.size() == 0;
            }

            @NonNull
            @Override
            protected LiveData<List<AsteroidEntity>> loadFromDb() {

                return Transformations.map(localDataSource.getTodayAsteroids(), new Function<List<com.marvel.selphius.asteroids_cleanarchitecture.datasource.local.model.Asteroid>, List<AsteroidEntity>>() {
                    @Override
                    public List<AsteroidEntity> apply(List<com.marvel.selphius.asteroids_cleanarchitecture.datasource.local.model.Asteroid> localAsteroids) {

                        LocalToAsteroidEntityMapper mapper = new LocalToAsteroidEntityMapper();
                        return mapper.map(localAsteroids);
                    }
                });
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<List<Asteroid>>> createCall() {
                return remoteDatasource.getTodayAsteroids();
            }
        }.getAsLiveData();

        /*return Transformations.map(remoteDatasource.getTodayAsteroids(), new Function<ApiResponse<List<Asteroid>>, List<AsteroidEntity>>() {
            @Override
            public List<AsteroidEntity> apply(ApiResponse<List<Asteroid>> input) {
                List<Asteroid> remoteAsteroids = input.body;
                RemoteToAsteroidEntityMapper remoteToAsteroidEntityMapper = new RemoteToAsteroidEntityMapper();
                return remoteToAsteroidEntityMapper.map(remoteAsteroids);
            }
        });*/

    }
}
