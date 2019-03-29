package com.square63.caremap.webapi;

import com.google.gson.annotations.SerializedName;
import com.square63.caremap.models.RegistrationModel;

import java.io.Serializable;

public class CreateGiverRequest implements Serializable {
    private String ExpFromDate;
    private String ExpToDate;

    public String getExpFromDate() {
        return ExpFromDate;
    }

    public void setExpFromDate(String expFromDate) {
        ExpFromDate = expFromDate;
    }

    public String getExpToDate() {
        return ExpToDate;
    }

    public void setExpToDate(String expToDate) {
        ExpToDate = expToDate;
    }

    public String getYearsOfExperience() {
        return YearsOfExperience;
    }

    public void setYearsOfExperience(String yearsOfExperience) {
        YearsOfExperience = yearsOfExperience;
    }

    public String getProfileTitle() {
        return ProfileTitle;
    }

    public void setProfileTitle(String profileTitle) {
        ProfileTitle = profileTitle;
    }

    public String getAvailabilityDistance() {
        return AvailabilityDistance;
    }

    public void setAvailabilityDistance(String availabilityDistance) {
        AvailabilityDistance = availabilityDistance;
    }

    public String getDesiredWage() {
        return DesiredWage;
    }

    public void setDesiredWage(String desiredWage) {
        DesiredWage = desiredWage;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    private String YearsOfExperience;
    private String ProfileTitle;
    private String AvailabilityDistance;
    private String DesiredWage;
    private String Description;
    public RegistrationModel getRegistrationModel() {
        return registrationModel;
    }

    public void setRegistrationModel(RegistrationModel registrationModel) {
        this.registrationModel = registrationModel;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    private String Id;
    @SerializedName("User")

    private RegistrationModel registrationModel;
}
