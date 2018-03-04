package com.marvel.selphius.asteroids_cleanarchitecture.model;

public class AsteroidEntity {

    private int uid;

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

    public long getAbstoluteMagnitudeH() {
        return abstoluteMagnitudeH;
    }

    public void setAbstoluteMagnitudeH(long abstoluteMagnitudeH) {
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

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

}
