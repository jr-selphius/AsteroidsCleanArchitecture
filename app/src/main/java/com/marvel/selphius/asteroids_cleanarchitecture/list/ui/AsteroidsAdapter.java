package com.marvel.selphius.asteroids_cleanarchitecture.list.ui;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
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

    public void replaceAsteroids(List<Asteroide> newAsteroids) {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new AsteroidsDiffUtil(asteroids, newAsteroids));
        asteroids.clear();
        asteroids.addAll(newAsteroids);
        diffResult.dispatchUpdatesTo(this);
    }

    @Override
    public AsteroidViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View asteroidItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.asteroid_item, parent, false);
        return new AsteroidViewHolder(asteroidItem);
    }

    @Override
    public void onBindViewHolder(@NonNull AsteroidViewHolder holder, int position) {
        holder.bind(asteroids.get(position));
    }

    @Override
    public int getItemCount() {
        return asteroids.size();
    }
}
