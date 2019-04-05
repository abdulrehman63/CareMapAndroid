
package com.square63.caremap.models.giverModels;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.square63.caremap.models.GiverSkills;
import com.square63.caremap.models.SkillsModel;

public class Caregiver {

    @SerializedName("availabilityType")
    @Expose
    private String availabilityType;
    @SerializedName("availabilityLocation")
    @Expose
    private String availabilityLocation;
    @SerializedName("availabilityDistance")
    @Expose
    private String availabilityDistance;
    @SerializedName("driversLicense")
    @Expose
    private String driversLicense;
    @SerializedName("availableTransportation")
    @Expose
    private String availableTransportation;
    @SerializedName("vettingStatus")
    @Expose
    private String vettingStatus;
    @SerializedName("vettingAuthorization")
    @Expose
    private String vettingAuthorization;
    @SerializedName("desiredWage")
    @Expose
    private String desiredWage;
    @SerializedName("yearsOfExperience")
    @Expose
    private String yearsOfExperience;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("expFromDate")
    @Expose
    private String expFromDate;
    @SerializedName("expToDate")
    @Expose
    private String expToDate;
    @SerializedName("ratePunct")
    @Expose
    private Integer ratePunct;
    @SerializedName("rateDepen")
    @Expose
    private Integer rateDepen;
    @SerializedName("rateTrans")
    @Expose
    private Integer rateTrans;
    @SerializedName("rateHirea")
    @Expose
    private Integer rateHirea;
    @SerializedName("rateItems")
    @Expose
    private Integer rateItems;
    @SerializedName("userID")
    @Expose
    private String userID;
    @SerializedName("user")
    @Expose
    private User user;

    @SerializedName("profileTitle")
    @Expose
    private String profileTitle;

    public ArrayList<GiverSkills> getSkillsModelArrayList() {
        return skillsModelArrayList;
    }

    public void setSkillsModelArrayList(ArrayList<GiverSkills> skillsModelArrayList) {
        this.skillsModelArrayList = skillsModelArrayList;
    }

    @SerializedName("id")
    @Expose

    private String id;

    @SerializedName("skills")
    private ArrayList<GiverSkills> skillsModelArrayList;

    public String getAvailabilityType() {
        return availabilityType;
    }

    public void setAvailabilityType(String availabilityType) {
        this.availabilityType = availabilityType;
    }

    public String getAvailabilityLocation() {
        return availabilityLocation;
    }

    public void setAvailabilityLocation(String availabilityLocation) {
        this.availabilityLocation = availabilityLocation;
    }

    public String getAvailabilityDistance() {
        return availabilityDistance;
    }

    public void setAvailabilityDistance(String availabilityDistance) {
        this.availabilityDistance = availabilityDistance;
    }

    public String getDesiredWage() {
        return desiredWage;
    }

    public void setDesiredWage(String desiredWage) {
        this.desiredWage = desiredWage;
    }

    public String getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(String yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getDriversLicense() {
        return driversLicense;
    }

    public void setDriversLicense(String driversLicense) {
        this.driversLicense = driversLicense;
    }

    public String getAvailableTransportation() {
        return availableTransportation;
    }

    public void setAvailableTransportation(String availableTransportation) {
        this.availableTransportation = availableTransportation;
    }

    public String getVettingStatus() {
        return vettingStatus;
    }

    public void setVettingStatus(String vettingStatus) {
        this.vettingStatus = vettingStatus;
    }

    public String getVettingAuthorization() {
        return vettingAuthorization;
    }

    public void setVettingAuthorization(String vettingAuthorization) {
        this.vettingAuthorization = vettingAuthorization;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExpFromDate() {
        return expFromDate;
    }

    public void setExpFromDate(String expFromDate) {
        this.expFromDate = expFromDate;
    }

    public String getExpToDate() {
        return expToDate;
    }

    public void setExpToDate(String expToDate) {
        this.expToDate = expToDate;
    }

    public Integer getRatePunct() {
        return ratePunct;
    }

    public void setRatePunct(Integer ratePunct) {
        this.ratePunct = ratePunct;
    }

    public Integer getRateDepen() {
        return rateDepen;
    }

    public void setRateDepen(Integer rateDepen) {
        this.rateDepen = rateDepen;
    }

    public Integer getRateTrans() {
        return rateTrans;
    }

    public void setRateTrans(Integer rateTrans) {
        this.rateTrans = rateTrans;
    }

    public Integer getRateHirea() {
        return rateHirea;
    }

    public void setRateHirea(Integer rateHirea) {
        this.rateHirea = rateHirea;
    }

    public Integer getRateItems() {
        return rateItems;
    }

    public void setRateItems(Integer rateItems) {
        this.rateItems = rateItems;
    }


    public String getUserID() {
        return userID;

    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public String getProfileTitle() {
        return profileTitle;
    }

    public void setProfileTitle(String profileTitle) {
        this.profileTitle = profileTitle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
