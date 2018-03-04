package com.marvel.selphius.asteroids_cleanarchitecture.list.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marvel.selphius.asteroids_cleanarchitecture.R;
import com.marvel.selphius.asteroids_cleanarchitecture.list.model.Asteroide;

import java.util.List;

public class AsteroidsAdapter extends RecyclerView.Adapter<AsteroidViewHolder> {

    private List<Asteroide> asteroids;

    public AsteroidsAdapter(List<Asteroide> asteroids) {
        this.asteroids = asteroids;
    }

    public void replaceAsteroids(List<Asteroide> asteroids) {
        this.asteroids = asteroids;
    }

    @Override
    public AsteroidViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View asteroidItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.asteroid_item, parent, false);
        return new AsteroidViewHolder(asteroidItem);
    }

    @Override
    public void onBindViewHolder(AsteroidViewHolder holder, int position) {
        holder.bind(asteroids.get(position));
    }

    @Override
    public int getItemCount() {
        return asteroids.size();
    }
}
