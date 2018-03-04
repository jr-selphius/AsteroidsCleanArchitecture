package com.marvel.selphius.asteroids_cleanarchitecture.datasource.remote.model;

import com.google.gson.annotations.Expose;

/**
 * Created by selphius on 24/2/18.
 */

public class MissDistance {

    @Expose
    private String astronomical;

    @Expose
    private String lunar;

    @Expose
    private String kilometers;

    @Expose
    private String miles;

    public String getAstronomical() {
        return astronomical;
    }

    public void setAstronomical(String astronomical) {
        this.astronomical = astronomical;
    }

    public String getLunar() {
        return lunar;
    }

    public void setLunar(String lunar) {
        this.lunar = lunar;
    }

    public String getKilometers() {
        return kilometers;
    }

    public void setKilometers(String kilometers) {
        this.kilometers = kilometers;
    }

    public String getMiles() {
        return miles;
    }

    public void setMiles(String miles) {
        this.miles = miles;
    }
}
