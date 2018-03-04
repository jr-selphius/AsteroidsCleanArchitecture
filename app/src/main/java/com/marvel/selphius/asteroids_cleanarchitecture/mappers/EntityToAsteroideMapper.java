package com.marvel.selphius.asteroids_cleanarchitecture.mappers;

import com.marvel.selphius.asteroids_cleanarchitecture.datasource.Mapper;
import com.marvel.selphius.asteroids_cleanarchitecture.model.AsteroidEntity;
import com.marvel.selphius.asteroids_cleanarchitecture.list.model.Asteroide;

public class EntityToAsteroideMapper extends Mapper<AsteroidEntity, Asteroide> {

    @Override
    public Asteroide map(AsteroidEntity value) {

        Asteroide asteroide = new Asteroide();
        asteroide.setName(value.getName());
        asteroide.setNasaJplUrl(value.getNasaJplUrl());
        asteroide.setDate(value.getDate());
        asteroide.setAbsoluteMagnitudeH(value.getAbstoluteMagnitudeH());
        return asteroide;
    }

    @Override
    public AsteroidEntity reverseMap(Asteroide value) {
        return null;
    }
}
