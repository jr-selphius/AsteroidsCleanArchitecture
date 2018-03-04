package com.marvel.selphius.asteroids_cleanarchitecture.list.domain;

import android.arch.lifecycle.LiveData;

import com.marvel.selphius.asteroids_cleanarchitecture.datasource.AsteroidsRepository;
import com.marvel.selphius.asteroids_cleanarchitecture.model.AsteroidEntity;

import java.util.List;

public class GetTodayAsteroidsUseCase {

    AsteroidsRepository repository;

    public GetTodayAsteroidsUseCase(AsteroidsRepository repository) {
        this.repository = repository;
    }

    public LiveData<List<AsteroidEntity>> execute() {
        return repository.getTodayAsteroids();
    }
}
