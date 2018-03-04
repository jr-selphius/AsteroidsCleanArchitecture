package com.marvel.selphius.asteroids_cleanarchitecture.datasource.remote.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by selphius on 24/2/18.
 */

public class Asteroid {

    private String date;

    @Expose
    private Links links;

    @SerializedName("neo_reference_id")
    @Expose
    private String neoReferenceId;

    @Expose
    private String name;

    @SerializedName("nasa_jpl_url")
    @Expose
    private String nasaJplUrl;

    @SerializedName("abstolute_magnitude_h")
    @Expose
    private long abstoluteMagnitudeH;

    @SerializedName("estimated_diameter")
    @Expose
    private StimatedDiameter estimatedDiameter;

    @SerializedName("is_potentially_hazardous_asteroid")
    @Expose
    private boolean isPotentiallyHazardousAsteroid;

    @SerializedName("close_approach_data")
    @Expose
    private List<CloseApproachData> closeApproachData;

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

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

    public StimatedDiameter getEstimatedDiameter() {
        return estimatedDiameter;
    }

    public void setEstimatedDiameter(StimatedDiameter estimatedDiameter) {
        this.estimatedDiameter = estimatedDiameter;
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

    public List<CloseApproachData> getCloseApproachData() {
        return closeApproachData;
    }

    public void setCloseApproachData(List<CloseApproachData> closeApproachData) {
        this.closeApproachData = closeApproachData;
    }
}
