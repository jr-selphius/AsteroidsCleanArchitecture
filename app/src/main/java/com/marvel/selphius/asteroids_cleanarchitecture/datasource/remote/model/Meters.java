package com.marvel.selphius.asteroids_cleanarchitecture.datasource.remote.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by selphius on 24/2/18.
 */

public class Meters {

    @SerializedName("stimated_diameter_min")
    @Expose
    private long stimatedDiameterMin;

    @SerializedName("stimated_diameter_max")
    @Expose
    private long stimagedDiameterMax;

    public long getStimatedDiameterMin() {
        return stimatedDiameterMin;
    }

    public void setStimatedDiameterMin(long stimatedDiameterMin) {
        this.stimatedDiameterMin = stimatedDiameterMin;
    }

    public long getStimagedDiameterMax() {
        return stimagedDiameterMax;
    }

    public void setStimagedDiameterMax(long stimagedDiameterMax) {
        this.stimagedDiameterMax = stimagedDiameterMax;
    }
}
