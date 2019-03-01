
package com.square63.caremap.models.giverModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.square63.caremap.models.Interest;

public class UserInterest {

    @SerializedName("seniorID")
    @Expose
    private String seniorID;
    @SerializedName("interestID")
    @Expose
    private String interestID;
    @SerializedName("interest")
    @Expose
    private Interest interest;
    @SerializedName("id")
    @Expose
    private String id;

    public String getSeniorID() {
        return seniorID;
    }

    public void setSeniorID(String seniorID) {
        this.seniorID = seniorID;
    }

    public String getInterestID() {
        return interestID;
    }

    public void setInterestID(String interestID) {
        this.interestID = interestID;
    }

    public Interest getInterest() {
        return interest;
    }

    public void setInterest(Interest interest) {
        this.interest = interest;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
