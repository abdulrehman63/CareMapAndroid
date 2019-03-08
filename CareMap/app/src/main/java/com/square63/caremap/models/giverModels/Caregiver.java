
package com.square63.caremap.models.giverModels;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Caregiver {

    @SerializedName("availabilityType")
    @Expose
    private Object availabilityType;
    @SerializedName("availabilityLocation")
    @Expose
    private Object availabilityLocation;
    @SerializedName("availabilityDistance")
    @Expose
    private String availabilityDistance;
    @SerializedName("driversLicense")
    @Expose
    private Object driversLicense;
    @SerializedName("availableTransportation")
    @Expose
    private Object availableTransportation;
    @SerializedName("vettingStatus")
    @Expose
    private Object vettingStatus;
    @SerializedName("vettingAuthorization")
    @Expose
    private Object vettingAuthorization;
    @SerializedName("desiredWage")
    @Expose
    private String desiredWage;
    @SerializedName("yearsOfExperience")
    @Expose
    private String yearsOfExperience;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("expFromDate")
    @Expose
    private Object expFromDate;
    @SerializedName("expToDate")
    @Expose
    private Object expToDate;
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
    @SerializedName("otherSkill")
    @Expose
    private Object otherSkill;
    @SerializedName("otherInterest")
    @Expose
    private Object otherInterest;
    @SerializedName("userID")
    @Expose
    private String userID;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("skills")
    @Expose
    private List<Object> skills = null;
    @SerializedName("profileTitle")
    @Expose
    private Object profileTitle;
    @SerializedName("id")
    @Expose
    private String id;

    public Object getAvailabilityType() {
        return availabilityType;
    }

    public void setAvailabilityType(Object availabilityType) {
        this.availabilityType = availabilityType;
    }

    public Object getAvailabilityLocation() {
        return availabilityLocation;
    }

    public void setAvailabilityLocation(Object availabilityLocation) {
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

    public Object getDriversLicense() {
        return driversLicense;
    }

    public void setDriversLicense(Object driversLicense) {
        this.driversLicense = driversLicense;
    }

    public Object getAvailableTransportation() {
        return availableTransportation;
    }

    public void setAvailableTransportation(Object availableTransportation) {
        this.availableTransportation = availableTransportation;
    }

    public Object getVettingStatus() {
        return vettingStatus;
    }

    public void setVettingStatus(Object vettingStatus) {
        this.vettingStatus = vettingStatus;
    }

    public Object getVettingAuthorization() {
        return vettingAuthorization;
    }

    public void setVettingAuthorization(Object vettingAuthorization) {
        this.vettingAuthorization = vettingAuthorization;
    }



    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Object getExpFromDate() {
        return expFromDate;
    }

    public void setExpFromDate(Object expFromDate) {
        this.expFromDate = expFromDate;
    }

    public Object getExpToDate() {
        return expToDate;
    }

    public void setExpToDate(Object expToDate) {
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

    public Object getOtherSkill() {
        return otherSkill;
    }

    public void setOtherSkill(Object otherSkill) {
        this.otherSkill = otherSkill;
    }

    public Object getOtherInterest() {
        return otherInterest;
    }

    public void setOtherInterest(Object otherInterest) {
        this.otherInterest = otherInterest;
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

    public List<Object> getSkills() {
        return skills;
    }

    public void setSkills(List<Object> skills) {
        this.skills = skills;
    }

    public Object getProfileTitle() {
        return profileTitle;
    }

    public void setProfileTitle(Object profileTitle) {
        this.profileTitle = profileTitle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
