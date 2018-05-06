package com.marvel.selphius.asteroids_cleanarchitecture.list.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import com.marvel.selphius.asteroids_cleanarchitecture.R;
import com.marvel.selphius.asteroids_cleanarchitecture.list.domain.GetTodayAsteroidsUseCase;
import com.marvel.selphius.asteroids_cleanarchitecture.list.model.Asteroide;
import com.marvel.selphius.asteroids_cleanarchitecture.mappers.EntityToAsteroideMapper;
import com.marvel.selphius.asteroids_cleanarchitecture.model.AsteroidEntity;
import com.marvel.selphius.asteroids_cleanarchitecture.util.SingleLiveEvent;

import java.util.List;

public class MainAsteroidsViewModel extends ViewModel {

    private LiveData<List<Asteroide>> asteroids;

    private MutableLiveData<Boolean> mustShowProgress = new MutableLiveData<>();

    private SingleLiveEvent<Integer> centralMessage = new SingleLiveEvent<>();

    public MainAsteroidsViewModel(GetTodayAsteroidsUseCase getTodayAsteroidsUseCase) {

        asteroids = Transformations.map(getTodayAsteroidsUseCase.execute(), input -> {
            List<AsteroidEntity> data = input.data;
            if (data != null) {

                mustShowProgress.setValue(false);

                if (data.size() == 0) {
                    centralMessage.setValue(R.string.no_asteroids_today);
                }

                return new EntityToAsteroideMapper().map(data);
            }
            return null;
        });
    }

    public LiveData<List<Asteroide>> getAsteroids() {
        return asteroids;
    }

    public MutableLiveData<Boolean> mustShowProgress() {
        return mustShowProgress;
    }

    public SingleLiveEvent<Integer> getCentralMessage() {
        return centralMessage;
    }
}
