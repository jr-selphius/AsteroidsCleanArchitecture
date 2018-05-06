package com.marvel.selphius.asteroids_cleanarchitecture.list.ui;

import android.support.v7.util.DiffUtil;

import com.marvel.selphius.asteroids_cleanarchitecture.list.model.Asteroide;

import java.util.List;

public class AsteroidsDiffUtil extends DiffUtil.Callback {

    private List<Asteroide> oldAsteroids;
    private List<Asteroide> newAsteroids;

    public AsteroidsDiffUtil(List<Asteroide> oldAsteroids, List<Asteroide> newAsteroids) {
        this.oldAsteroids = oldAsteroids;
        this.newAsteroids = newAsteroids;
    }

    @Override
    public int getOldListSize() {
        return oldAsteroids.size();
    }

    @Override
    public int getNewListSize() {
        return newAsteroids.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldAsteroids.get(oldItemPosition).getId() == newAsteroids.get(newItemPosition).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldAsteroids.get(oldItemPosition).equals(newAsteroids.get(newItemPosition)) ;
    }
}
