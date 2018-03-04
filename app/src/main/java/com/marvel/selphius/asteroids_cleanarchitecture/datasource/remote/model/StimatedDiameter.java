package com.marvel.selphius.asteroids_cleanarchitecture.datasource.remote.model;

import com.google.gson.annotations.Expose;

/**
 * Created by selphius on 24/2/18.
 */

public class StimatedDiameter {

    @Expose
    private Kilometers kilometers;
    @Expose
    private Meters meters;
    @Expose
    private Miles miles;
    @Expose
    private Feet feet;

    public Kilometers getKilometers() {
        return kilometers;
    }

    public void setKilometers(Kilometers kilometers) {
        this.kilometers = kilometers;
    }

    public Meters getMeters() {
        return meters;
    }

    public void setMeters(Meters meters) {
        this.meters = meters;
    }

    public Miles getMiles() {
        return miles;
    }

    public void setMiles(Miles miles) {
        this.miles = miles;
    }

    public Feet getFeet() {
        return feet;
    }

    public void setFeet(Feet feet) {
        this.feet = feet;
    }
}
