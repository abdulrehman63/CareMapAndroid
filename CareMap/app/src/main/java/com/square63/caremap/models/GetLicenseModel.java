package com.square63.caremap.models;

import android.databinding.Bindable;

import com.google.gson.annotations.SerializedName;
import com.square63.caremap.BR;

public class GetLicenseModel {
    @SerializedName("license")
    private String licenseNo;
    @SerializedName("credantal")
    private String credentialName;
    @SerializedName("issueDate")
    private String issueDate;

    @SerializedName("expireDate")
    private String expDate;
    @SerializedName("documentfile")
    private String vettingDocuments;

    private String CaregiverID;

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getCredentialName() {
        return credentialName;
    }

    public void setCredentialName(String credentialName) {
        this.credentialName = credentialName;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getVettingDocuments() {
        return vettingDocuments;
    }

    public void setVettingDocuments(String vettingDocuments) {
        this.vettingDocuments = vettingDocuments;
    }

    public String getCaregiverID() {
        return CaregiverID;
    }

    public void setCaregiverID(String caregiverID) {
        CaregiverID = caregiverID;
    }

    public String getRequestdocument() {
        return Requestdocument;
    }

    public void setRequestdocument(String requestdocument) {
        Requestdocument = requestdocument;
    }

    private String Requestdocument ="YES";
}
