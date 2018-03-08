package com.marvel.selphius.asteroids_cleanarchitecture.di;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.marvel.selphius.asteroids_cleanarchitecture.list.ui.TodayAsteroidsViewModelFactory;
import com.marvel.selphius.asteroids_cleanarchitecture.datasource.AsteroidsRepository;
import com.marvel.selphius.asteroids_cleanarchitecture.datasource.local.AppDatabase;
import com.marvel.selphius.asteroids_cleanarchitecture.datasource.local.AsteroidDao;
import com.marvel.selphius.asteroids_cleanarchitecture.datasource.local.LocalDataSourceImpl;
import com.marvel.selphius.asteroids_cleanarchitecture.datasource.remote.api.AsteroidDeserializer;
import com.marvel.selphius.asteroids_cleanarchitecture.datasource.remote.api.AsteroidNasaService;
import com.marvel.selphius.asteroids_cleanarchitecture.datasource.remote.RemoteDataSourceImpl;
import com.marvel.selphius.asteroids_cleanarchitecture.datasource.remote.model.Asteroid;
import com.marvel.selphius.asteroids_cleanarchitecture.list.domain.GetTodayAsteroidsUseCase;
import com.marvel.selphius.asteroids_cleanarchitecture.util.LiveDataCallAdapterFactory;

import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return application;
    }

    @Provides
    @Singleton
    public GsonConverterFactory provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Type asteroidListType = new TypeToken<List<Asteroid>>() {}.getType();
        gsonBuilder.registerTypeAdapter(asteroidListType, new AsteroidDeserializer());
        Gson gson = gsonBuilder.create();
        return GsonConverterFactory.create(gson);
    }

    @Provides
    @Singleton
    public AsteroidNasaService provideRetrofit(GsonConverterFactory gsonConverterFactory) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.nasa.gov/neo/rest/v1/")
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .build();

        return retrofit.create(AsteroidNasaService.class);
    }

    @Provides
    @Singleton
    public RemoteDataSourceImpl provideRemoteDataSource(AsteroidNasaService service) {
        return new RemoteDataSourceImpl(service);
    }

    @Provides
    @Singleton
    public AppDatabase provideDatabase(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, "asteroids.database").build();
    }

    @Provides
    @Singleton
    public AsteroidDao provideAsteroidDao(AppDatabase database) {
        return database.asteroidDao();
    }

    @Provides
    @Singleton
    public LocalDataSourceImpl provideLocalDataSource(AsteroidDao asteroidDao) {
        return new LocalDataSourceImpl(asteroidDao);
    }

    @Provides
    @Singleton
    public AsteroidsRepository provideAsteroidsRepository(LocalDataSourceImpl localDataSource, RemoteDataSourceImpl remoteDataSource) {
        return new AsteroidsRepository(localDataSource, remoteDataSource);
    }

    @Provides
    public GetTodayAsteroidsUseCase provideGetTodayAsteroidsUseCase(AsteroidsRepository repository) {
        return new GetTodayAsteroidsUseCase(repository);
    }

    @Provides
    public TodayAsteroidsViewModelFactory provideViewModelFactory(GetTodayAsteroidsUseCase getTodayAsteroidsUseCase) {
        return new TodayAsteroidsViewModelFactory(getTodayAsteroidsUseCase);
    }

}
