package com.marvel.selphius.asteroids_cleanarchitecture.datasource.local.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "asteroids")
public class Asteroid {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "date")
    private String date;

    @Embedded
    private Links links;

    @ColumnInfo(name = "neo_reference_id")
    private String neoReferenceId;

    private String name;

    @ColumnInfo(name = "nasa_jpl_url")
    private String nasaJplUrl;

    @ColumnInfo(name = "abstolute_magnitude_h")
    private long abstoluteMagnitudeH;

    @Embedded(prefix = "estimated_diameter")
    private StimatedDiameter estimatedDiameter;

    @ColumnInfo(name = "is_potentially_hazardous_asteroid")
    private boolean isPotentiallyHazardousAsteroid;

    /*@ColumnInfo(name = "close_approach_data")
    private List<CloseApproachData> closeApproachData;
*/
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

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
/*
    public List<CloseApproachData> getCloseApproachData() {
        return closeApproachData;
    }

    public void setCloseApproachData(List<CloseApproachData> closeApproachData) {
        this.closeApproachData = closeApproachData;
    }
    */
}
