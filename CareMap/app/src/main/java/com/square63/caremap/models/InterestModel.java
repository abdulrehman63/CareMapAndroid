package com.square63.caremap.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class InterestModel implements Serializable{
    private int icone;
    private String name;
    private String seniorID;
    private String interestID;
    @SerializedName("interest")
    private Interest interest;

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

    public int getIcone() {
        return icone;
    }

    public void setIcone(int icone) {
        this.icone = icone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    private boolean isSelected;
}
