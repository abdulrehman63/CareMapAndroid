package com.square63.caremap.models;

import android.databinding.Bindable;

import com.google.gson.annotations.SerializedName;
import com.square63.caremap.BR;

public class GetEducationModel {
    private String CaregiverID;

    public String getCaregiverID() {
        return CaregiverID;
    }

    public void setCaregiverID(String caregiverID) {
        CaregiverID = caregiverID;
    }

    @SerializedName("field")
    private String study;
    @SerializedName("college")
    private String college;

    public void setStudy(String study) {
        this.study = study;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @SerializedName("degree")

    private String degree;

    public String getStudy() {
        return study;
    }
    @SerializedName("startDate")
    private String startDate;
    @SerializedName("endDate")
    private String endDate;
}
