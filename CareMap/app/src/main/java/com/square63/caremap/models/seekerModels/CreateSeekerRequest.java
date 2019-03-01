
package com.square63.caremap.models.seekerModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.square63.caremap.models.RegistrationModel;

public class CreateSeekerRequest {

    @SerializedName("NextOfKin")
    @Expose
    private String nextOfKin;
    @SerializedName("SpecialRequirements")
    @Expose
    private Object specialRequirements;
    @SerializedName("PhysicalCondition")
    @Expose
    private Object physicalCondition;
    @SerializedName("AvailabilityNeeded")
    @Expose
    private Object availabilityNeeded;
    @SerializedName("Urgency")
    @Expose
    private String urgency;
    @SerializedName("CareForMe")
    @Expose
    private String careForMe;
    @SerializedName("Transportation")
    @Expose
    private String transportation;
    @SerializedName("RateFrom")
    @Expose
    private String rateFrom;
    @SerializedName("RateTo")
    @Expose
    private String rateTo;
    @SerializedName("FirstTime")
    @Expose
    private String firstTime;
    @SerializedName("ContactMethod")
    @Expose
    private String contactMethod;
    @SerializedName("ContactTime")
    @Expose
    private String contactTime;
    @SerializedName("PostingTitle")
    @Expose
    private String postingTitle;
    @SerializedName("PostingDescription")
    @Expose
    private String postingDescription;
    @SerializedName("PostingActive")
    @Expose
    private Object postingActive;
    @SerializedName("JobHired")
    @Expose
    private String jobHired;
    @SerializedName("JobClosed")
    @Expose
    private Object jobClosed;
    @SerializedName("JobHiredDate")
    @Expose
    private String jobHiredDate;
    @SerializedName("JobClosedDate")
    @Expose
    private String jobClosedDate;
    @SerializedName("OtherSkill")
    @Expose
    private Object otherSkill;
    @SerializedName("OtherInterest")
    @Expose
    private Object otherInterest;
    @SerializedName("User")
    @Expose
    private RegistrationModel user = new RegistrationModel();

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

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
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

    public String getRateFrom() {
        return rateFrom;
    }

    public void setRateFrom(String rateFrom) {
        this.rateFrom = rateFrom;
    }

    public String getRateTo() {
        return rateTo;
    }

    public void setRateTo(String rateTo) {
        this.rateTo = rateTo;
    }

    public String getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(String firstTime) {
        this.firstTime = firstTime;
    }

    public String getContactMethod() {
        return contactMethod;
    }

    public void setContactMethod(String contactMethod) {
        this.contactMethod = contactMethod;
    }

    public String getContactTime() {
        return contactTime;
    }

    public void setContactTime(String contactTime) {
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

    public String getJobClosedDate() {
        return jobClosedDate;
    }

    public RegistrationModel getUser() {
        return user;
    }

    public void setUser(RegistrationModel user) {
        this.user = user;
    }

    public void setJobClosedDate(String jobClosedDate) {
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



}
