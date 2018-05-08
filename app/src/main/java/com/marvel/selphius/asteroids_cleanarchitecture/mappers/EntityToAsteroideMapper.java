package com.marvel.selphius.asteroids_cleanarchitecture.mappers;

import com.marvel.selphius.asteroids_cleanarchitecture.model.AsteroidEntity;
import com.marvel.selphius.asteroids_cleanarchitecture.list.model.Asteroide;

public class EntityToAsteroideMapper extends Mapper<AsteroidEntity, Asteroide> {

    @Override
    public Asteroide map(AsteroidEntity value) {
        Asteroide asteroide = new Asteroide();
        asteroide.setId(value.getUid());
        asteroide.setName(value.getName());
        return asteroide;
    }

    @Override
    public AsteroidEntity reverseMap(Asteroide value) {
        return null;
    }
}
