package com.marvel.selphius.asteroids_cleanarchitecture.datasource.local.model;

import android.arch.persistence.room.Embedded;

public class StimatedDiameter {

    @Embedded(prefix = "kilometers")
    private Kilometers kilometers;

    @Embedded(prefix = "meters")
    private Meters meters;

    @Embedded(prefix = "miles")
    private Miles miles;

    @Embedded(prefix = "feet")
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
