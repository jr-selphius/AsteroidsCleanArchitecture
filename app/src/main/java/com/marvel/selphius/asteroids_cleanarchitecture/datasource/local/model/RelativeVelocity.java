package com.marvel.selphius.asteroids_cleanarchitecture.datasource.local.model;

public class RelativeVelocity {

    private String kilometersPerSecond;

    private String kilometersPerHour;

    private String milesPerHour;

    public String getKilometersPerSecond() {
        return kilometersPerSecond;
    }

    public void setKilometersPerSecond(String kilometersPerSecond) {
        this.kilometersPerSecond = kilometersPerSecond;
    }

    public String getKilometersPerHour() {
        return kilometersPerHour;
    }

    public void setKilometersPerHour(String kilometersPerHour) {
        this.kilometersPerHour = kilometersPerHour;
    }

    public String getMilesPerHour() {
        return milesPerHour;
    }

    public void setMilesPerHour(String milesPerHour) {
        this.milesPerHour = milesPerHour;
    }
}
