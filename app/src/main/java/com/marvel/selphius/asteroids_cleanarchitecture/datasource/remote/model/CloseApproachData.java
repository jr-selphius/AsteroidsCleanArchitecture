package com.marvel.selphius.asteroids_cleanarchitecture.datasource.remote.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by selphius on 24/2/18.
 */

public class CloseApproachData {

    @SerializedName("close_approach_date")
    @Expose
    private String closeApproachDate;

    @SerializedName("epoch_date_close_approach")
    @Expose
    private long epochDateCloseApproach;

    @SerializedName("relative_velocity")
    @Expose
    private RelativeVelocity relativeVelocity;

    @SerializedName("miss_distance")
    @Expose
    private MissDistance missDistance;

    @SerializedName("orbiting_body")
    @Expose
    private String orbitingBody;

    public String getCloseApproachDate() {
        return closeApproachDate;
    }

    public void setCloseApproachDate(String closeApproachDate) {
        this.closeApproachDate = closeApproachDate;
    }

    public long getEpochDateCloseApproach() {
        return epochDateCloseApproach;
    }

    public void setEpochDateCloseApproach(long epochDateCloseApproach) {
        this.epochDateCloseApproach = epochDateCloseApproach;
    }

    public RelativeVelocity getRelativeVelocity() {
        return relativeVelocity;
    }

    public void setRelativeVelocity(RelativeVelocity relativeVelocity) {
        this.relativeVelocity = relativeVelocity;
    }

    public MissDistance getMissDistance() {
        return missDistance;
    }

    public void setMissDistance(MissDistance missDistance) {
        this.missDistance = missDistance;
    }

    public String getOrbitingBody() {
        return orbitingBody;
    }

    public void setOrbitingBody(String orbitingBody) {
        this.orbitingBody = orbitingBody;
    }
}
