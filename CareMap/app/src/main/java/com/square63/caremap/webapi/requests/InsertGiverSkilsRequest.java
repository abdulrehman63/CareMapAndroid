package com.square63.caremap.webapi.requests;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class InsertGiverSkilsRequest implements Serializable {
    @SerializedName("CaregiverID")
    private String caregiverID;

    public String getCaregiverID() {
        return caregiverID;
    }

    public void setCaregiverID(String caregiverID) {
        this.caregiverID = caregiverID;
    }

    public String getSkillID() {
        return skillID;
    }

    public void setSkillID(String skillID) {
        this.skillID = skillID;
    }

    @SerializedName("SkillID")

    private String skillID;
}
