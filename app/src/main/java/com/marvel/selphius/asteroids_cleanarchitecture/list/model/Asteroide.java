package com.marvel.selphius.asteroids_cleanarchitecture.list.model;

public class Asteroide {

    private int id;

    private String date;

    private String neoReferenceId;

    private String name;

    private String nasaJplUrl;

    private long abstoluteMagnitudeH;

    private boolean isPotentiallyHazardousAsteroid;

    public String getNeoReferenceId() {
        return neoReferenceId;
    }

    public void setNeoReferenceId(String neoReferenceId) {
        this.neoReferenceId = neoReferenceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNasaJplUrl() {
        return nasaJplUrl;
    }

    public void setNasaJplUrl(String nasaJplUrl) {
        this.nasaJplUrl = nasaJplUrl;
    }

    public long getAbsoluteMagnitudeH() {
        return abstoluteMagnitudeH;
    }

    public void setAbsoluteMagnitudeH(long abstoluteMagnitudeH) {
        this.abstoluteMagnitudeH = abstoluteMagnitudeH;
    }

    public boolean isPotentiallyHazardousAsteroid() {
        return isPotentiallyHazardousAsteroid;
    }

    public void setPotentiallyHazardousAsteroid(boolean potentiallyHazardousAsteroid) {
        isPotentiallyHazardousAsteroid = potentiallyHazardousAsteroid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
