package com.marvel.selphius.asteroids_cleanarchitecture.list.ui;

import android.app.Application;
import android.arch.core.util.Function;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;
import android.support.annotation.NonNull;

import com.marvel.selphius.asteroids_cleanarchitecture.CustomApplication;
import com.marvel.selphius.asteroids_cleanarchitecture.model.AsteroidEntity;
import com.marvel.selphius.asteroids_cleanarchitecture.list.domain.GetTodayAsteroidsUseCase;
import com.marvel.selphius.asteroids_cleanarchitecture.list.model.Asteroide;
import com.marvel.selphius.asteroids_cleanarchitecture.mappers.EntityToAsteroideMapper;

import java.util.List;

import javax.inject.Inject;

public class MainAsteroidsViewModel extends AndroidViewModel {

    private LiveData<List<Asteroide>> asteroids;

    @Inject
    GetTodayAsteroidsUseCase getTodayAsteroidsUseCase;

    public MainAsteroidsViewModel(@NonNull Application application) {
        super(application);

        ((CustomApplication) getApplication()).getComponent().inject(this);
    }

    public LiveData<List<Asteroide>> getAsteroids() {
        return asteroids;
    }

    public void loadAsteroids() {
        asteroids = Transformations.map(getTodayAsteroidsUseCase.execute(), new Function<List<AsteroidEntity>, List<Asteroide>>() {
            @Override
            public List<Asteroide> apply(List<AsteroidEntity> input) {
                EntityToAsteroideMapper entityToAsteroideMapper = new EntityToAsteroideMapper();
                return entityToAsteroideMapper.map(input);
            }
        });
    }

}
