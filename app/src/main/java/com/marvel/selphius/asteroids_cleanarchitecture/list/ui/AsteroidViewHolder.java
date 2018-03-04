package com.marvel.selphius.asteroids_cleanarchitecture.list.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.marvel.selphius.asteroids_cleanarchitecture.R;
import com.marvel.selphius.asteroids_cleanarchitecture.list.model.Asteroide;

import butterknife.BindView;
import butterknife.ButterKnife;

class AsteroidViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.name)
    TextView name;

    @BindView(R.id.hazardous)
    TextView hazardous;

    @BindView(R.id.date)
    TextView date;

    public AsteroidViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Asteroide asteroid) {
        name.setText(asteroid.getName());
        hazardous.setText(String.valueOf(asteroid.isPotentiallyHazardousAsteroid()));
        date.setText(asteroid.getDate());
    }
}
