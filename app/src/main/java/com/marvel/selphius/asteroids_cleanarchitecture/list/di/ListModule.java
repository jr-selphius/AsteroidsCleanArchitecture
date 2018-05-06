package com.marvel.selphius.asteroids_cleanarchitecture.list.di;

import com.marvel.selphius.asteroids_cleanarchitecture.datasource.AsteroidsRepository;
import com.marvel.selphius.asteroids_cleanarchitecture.list.domain.GetTodayAsteroidsUseCase;
import com.marvel.selphius.asteroids_cleanarchitecture.list.ui.TodayAsteroidsViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class ListModule {

    @Provides
    public GetTodayAsteroidsUseCase provideGetTodayAsteroidsUseCase(AsteroidsRepository repository) {
        return new GetTodayAsteroidsUseCase(repository);
    }

    @Provides
    public TodayAsteroidsViewModelFactory provideViewModelFactory(GetTodayAsteroidsUseCase getTodayAsteroidsUseCase) {
        return new TodayAsteroidsViewModelFactory(getTodayAsteroidsUseCase);
    }
}
