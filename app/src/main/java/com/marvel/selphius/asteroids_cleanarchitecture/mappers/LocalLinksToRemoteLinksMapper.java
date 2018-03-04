package com.marvel.selphius.asteroids_cleanarchitecture.mappers;

import com.marvel.selphius.asteroids_cleanarchitecture.datasource.local.model.Links;

public class LocalLinksToRemoteLinksMapper extends Mapper<Links, com.marvel.selphius.asteroids_cleanarchitecture.datasource.remote.model.Links> {
    @Override
    public com.marvel.selphius.asteroids_cleanarchitecture.datasource.remote.model.Links map(Links value) {

        com.marvel.selphius.asteroids_cleanarchitecture.datasource.remote.model.Links links = new com.marvel.selphius.asteroids_cleanarchitecture.datasource.remote.model.Links();
        links.setNext(value.getNext());
        links.setPrev(value.getPrev());
        links.setSelf(value.getSelf());
        return links;
    }

    @Override
    public Links reverseMap(com.marvel.selphius.asteroids_cleanarchitecture.datasource.remote.model.Links value) {
        Links links = new Links();
        links.setNext(value.getNext());
        links.setPrev(value.getPrev());
        links.setSelf(value.getSelf());
        return links;
    }
}
