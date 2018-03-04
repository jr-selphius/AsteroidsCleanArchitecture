package com.marvel.selphius.asteroids_cleanarchitecture.mappers;

import com.marvel.selphius.asteroids_cleanarchitecture.datasource.Mapper;
import com.marvel.selphius.asteroids_cleanarchitecture.datasource.local.model.Asteroid;

public class LocalAsteroidToRemoteAsteroidMapper extends Mapper<Asteroid, com.marvel.selphius.asteroids_cleanarchitecture.datasource.remote.model.Asteroid> {
    @Override
    public com.marvel.selphius.asteroids_cleanarchitecture.datasource.remote.model.Asteroid map(Asteroid values) {
        com.marvel.selphius.asteroids_cleanarchitecture.datasource.remote.model.Asteroid asteroid = new com.marvel.selphius.asteroids_cleanarchitecture.datasource.remote.model.Asteroid();
        asteroid.setDate(values.getDate());
        asteroid.setAbstoluteMagnitudeH(values.getAbstoluteMagnitudeH());
        asteroid.setName(values.getName());
        asteroid.setNasaJplUrl(values.getNasaJplUrl());
        asteroid.setNeoReferenceId(values.getNeoReferenceId());
        LocalLinksToRemoteLinksMapper linksMapper = new LocalLinksToRemoteLinksMapper();
        asteroid.setLinks(linksMapper.map(values.getLinks()));
        return asteroid;
    }

    @Override
    public Asteroid reverseMap(com.marvel.selphius.asteroids_cleanarchitecture.datasource.remote.model.Asteroid values) {
        Asteroid asteroid = new Asteroid();
        asteroid.setDate(values.getDate());
        asteroid.setAbstoluteMagnitudeH(values.getAbstoluteMagnitudeH());
        asteroid.setName(values.getName());
        asteroid.setNasaJplUrl(values.getNasaJplUrl());
        asteroid.setNeoReferenceId(values.getNeoReferenceId());
        LocalLinksToRemoteLinksMapper linksMapper = new LocalLinksToRemoteLinksMapper();
        asteroid.setLinks(linksMapper.reverseMap(values.getLinks()));
        return asteroid;
    }
}
