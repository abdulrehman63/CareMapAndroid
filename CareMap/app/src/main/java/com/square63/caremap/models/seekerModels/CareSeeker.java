
package com.square63.caremap.models.seekerModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.square63.caremap.models.LanguageModel;

public class CareSeeker {


    @SerializedName("user")
    @Expose
    private SeekerUser user;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("nextOfKin")
    @Expose
    private String nextOfKin;
    @SerializedName("specialRequirements")
    @Expose
    private Object specialRequirements;
    @SerializedName("physicalCondition")
    @Expose
    private Object physicalCondition;
    @SerializedName("availabilityNeeded")
    @Expose
    private Object availabilityNeeded;
    @SerializedName("urgency")
    @Expose
    private Object urgency;
    @SerializedName("careForMe")
    @Expose
    private String careForMe;
    @SerializedName("transportation")
    @Expose
    private String transportation;
    @SerializedName("rateFrom")
    @Expose
    private Integer rateFrom;
    @SerializedName("rateTo")
    @Expose
    private Integer rateTo;
    @SerializedName("firstTime")
    @Expose
    private String firstTime;
    @SerializedName("contactMethod")
    @Expose
    private Object contactMethod;
    @SerializedName("contactTime")
    @Expose
    private Object contactTime;
    @SerializedName("postingTitle")
    @Expose
    private String postingTitle;
    @SerializedName("postingDescription")
    @Expose
    private String postingDescription;
    @SerializedName("postingActive")
    @Expose
    private Object postingActive;
    @SerializedName("jobHired")
    @Expose
    private String jobHired;
    @SerializedName("jobClosed")
    @Expose
    private Object jobClosed;
    @SerializedName("jobHiredDate")
    @Expose
    private String jobHiredDate;
    @SerializedName("jobClosedDate")
    @Expose
    private Object jobClosedDate;
    @SerializedName("otherSkill")
    @Expose
    private Object otherSkill;
    @SerializedName("otherInterest")
    @Expose
    private Object otherInterest;
    @SerializedName("userID")
    @Expose
    private String userID;

    public SeekerUser getUser() {
        return user;
    }

    public void setUser(SeekerUser user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNextOfKin() {
        return nextOfKin;
    }

    public void setNextOfKin(String nextOfKin) {
        this.nextOfKin = nextOfKin;
    }

    public Object getSpecialRequirements() {
        return specialRequirements;
    }

    public void setSpecialRequirements(Object specialRequirements) {
        this.specialRequirements = specialRequirements;
    }

    public Object getPhysicalCondition() {
        return physicalCondition;
    }

    public void setPhysicalCondition(Object physicalCondition) {
        this.physicalCondition = physicalCondition;
    }

    public Object getAvailabilityNeeded() {
        return availabilityNeeded;
    }

    public void setAvailabilityNeeded(Object availabilityNeeded) {
        this.availabilityNeeded = availabilityNeeded;
    }

    public Object getUrgency() {
        return urgency;
    }

    public void setUrgency(Object urgency) {
        this.urgency = urgency;
    }

    public String getCareForMe() {
        return careForMe;
    }

    public void setCareForMe(String careForMe) {
        this.careForMe = careForMe;
    }

    public String getTransportation() {
        return transportation;
    }

    public void setTransportation(String transportation) {
        this.transportation = transportation;
    }

    public Integer getRateFrom() {
        return rateFrom;
    }

    public void setRateFrom(Integer rateFrom) {
        this.rateFrom = rateFrom;
    }

    public Integer getRateTo() {
        return rateTo;
    }

    public void setRateTo(Integer rateTo) {
        this.rateTo = rateTo;
    }

    public String getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(String firstTime) {
        this.firstTime = firstTime;
    }

    public Object getContactMethod() {
        return contactMethod;
    }

    public void setContactMethod(Object contactMethod) {
        this.contactMethod = contactMethod;
    }

    public Object getContactTime() {
        return contactTime;
    }

    public void setContactTime(Object contactTime) {
        this.contactTime = contactTime;
    }

    public String getPostingTitle() {
        return postingTitle;
    }

    public void setPostingTitle(String postingTitle) {
        this.postingTitle = postingTitle;
    }

    public String getPostingDescription() {
        return postingDescription;
    }

    public void setPostingDescription(String postingDescription) {
        this.postingDescription = postingDescription;
    }

    public Object getPostingActive() {
        return postingActive;
    }

    public void setPostingActive(Object postingActive) {
        this.postingActive = postingActive;
    }

    public String getJobHired() {
        return jobHired;
    }

    public void setJobHired(String jobHired) {
        this.jobHired = jobHired;
    }

    public Object getJobClosed() {
        return jobClosed;
    }

    public void setJobClosed(Object jobClosed) {
        this.jobClosed = jobClosed;
    }

    public String getJobHiredDate() {
        return jobHiredDate;
    }

    public void setJobHiredDate(String jobHiredDate) {
        this.jobHiredDate = jobHiredDate;
    }

    public Object getJobClosedDate() {
        return jobClosedDate;
    }

    public void setJobClosedDate(Object jobClosedDate) {
        this.jobClosedDate = jobClosedDate;
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

}
