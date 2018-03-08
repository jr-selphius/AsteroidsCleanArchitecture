package com.marvel.selphius.asteroids_cleanarchitecture.list.ui;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.marvel.selphius.asteroids_cleanarchitecture.list.domain.GetTodayAsteroidsUseCase;

public class TodayAsteroidsViewModelFactory implements ViewModelProvider.Factory {

    private GetTodayAsteroidsUseCase getTodayAsteroidsUseCase;

    public TodayAsteroidsViewModelFactory(GetTodayAsteroidsUseCase getTodayAsteroidsUseCase) {
        this.getTodayAsteroidsUseCase = getTodayAsteroidsUseCase;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {

        if (modelClass.isAssignableFrom(MainAsteroidsViewModel.class)) {
            return (T) new MainAsteroidsViewModel(getTodayAsteroidsUseCase);
        }

        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
