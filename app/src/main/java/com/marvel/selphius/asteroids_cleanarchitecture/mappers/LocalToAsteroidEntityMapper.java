package com.marvel.selphius.asteroids_cleanarchitecture.mappers;

import com.marvel.selphius.asteroids_cleanarchitecture.datasource.local.model.Asteroid;
import com.marvel.selphius.asteroids_cleanarchitecture.model.AsteroidEntity;

public class LocalToAsteroidEntityMapper extends Mapper<Asteroid, AsteroidEntity> {

    @Override
    public AsteroidEntity map(Asteroid value) {

        AsteroidEntity asteroid = new AsteroidEntity();
        asteroid.setUid(value.getUid());
        asteroid.setAbstoluteMagnitudeH(asteroid.getAbstoluteMagnitudeH());
        asteroid.setDate(value.getDate());
        asteroid.setName(value.getName());

        return asteroid;
    }

    @Override
    public Asteroid reverseMap(AsteroidEntity value) {
        return null;
    }
}
