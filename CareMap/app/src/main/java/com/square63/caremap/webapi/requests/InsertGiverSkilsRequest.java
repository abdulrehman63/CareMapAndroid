package com.square63.caremap.webapi.requests;

import com.google.gson.annotations.SerializedName;
import com.square63.caremap.constants.Constants;
import com.square63.caremap.utils.PreferenceHelper;

import java.io.Serializable;

public class InsertGiverSkilsRequest implements Serializable {
    @SerializedName("CaregiverID")
    private String caregiverID=PreferenceHelper.getInstance().getString(Constants.GIVER_ID,"");
    @SerializedName("SeniorID")
    private String seniorID = PreferenceHelper.getInstance().getString(Constants.SENIOR_ID,"");

    public String getSeniorID() {
        return seniorID;
    }

    public void setSeniorID(String seniorID) {
        this.seniorID = seniorID;
    }

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
