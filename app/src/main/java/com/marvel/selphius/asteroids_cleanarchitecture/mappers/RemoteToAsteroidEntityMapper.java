package com.marvel.selphius.asteroids_cleanarchitecture.mappers;

import com.marvel.selphius.asteroids_cleanarchitecture.datasource.remote.model.Asteroid;
import com.marvel.selphius.asteroids_cleanarchitecture.model.AsteroidEntity;

public class RemoteToAsteroidEntityMapper extends Mapper<Asteroid, AsteroidEntity> {
    @Override
    public AsteroidEntity map(Asteroid value) {

        AsteroidEntity asteroid = new AsteroidEntity();
        asteroid.setName(String.valueOf(value.getName()));
        asteroid.setDate(value.getDate());
        asteroid.setAbstoluteMagnitudeH(value.getAbstoluteMagnitudeH());
        asteroid.setNasaJplUrl(value.getNasaJplUrl());
        asteroid.setPotentiallyHazardousAsteroid(value.isPotentiallyHazardousAsteroid());

        return asteroid;
    }

    @Override
    public Asteroid reverseMap(AsteroidEntity value) {
        return null;
    }
}
