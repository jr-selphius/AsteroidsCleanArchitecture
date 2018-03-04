package com.marvel.selphius.asteroids_cleanarchitecture.datasource.remote.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by selphius on 24/2/18.
 */

public class RelativeVelocity {

    @SerializedName("kilometers_per_second")
    @Expose
    private String kilometersPerSecond;

    @SerializedName("kilometers_per_hour")
    @Expose
    private String kilometersPerHour;

    @SerializedName("miles_per_hour")
    @Expose
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
