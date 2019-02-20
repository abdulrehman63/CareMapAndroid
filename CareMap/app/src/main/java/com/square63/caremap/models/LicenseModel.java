package com.square63.caremap.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;
import com.square63.caremap.BR;
public class LicenseModel extends BaseObservable implements Serializable {
    @SerializedName("License")
    private String licenseNo;
    @SerializedName("Credantal")
    private String credentialName;
    @SerializedName("IssueDate")
    private String issueDate;

    public String getLicenseNo() {
        return licenseNo;
    }
    @Bindable
    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
        notifyPropertyChanged(BR.licenseNo);
    }

    public String getCredentialName() {
        return credentialName;
    }
    @Bindable
    public void setCredentialName(String credentialName) {
        this.credentialName = credentialName;
        notifyPropertyChanged(BR.credentialName);
    }

    public String getIssueDate() {
        return issueDate;
    }
    @Bindable
    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
        notifyPropertyChanged(BR.issueDate);
    }

    public String getExpDate() {
        return expDate;
    }
    @Bindable
    public void setExpDate(String expDate) {
        this.expDate = expDate;
        notifyPropertyChanged(BR.expDate);
    }

    public String getVettingDocuments() {
        return vettingDocuments;
    }
    @Bindable
    public void setVettingDocuments(String vettingDocuments) {
        this.vettingDocuments = vettingDocuments;
        notifyPropertyChanged(BR.vettingDocuments);
    }
    @SerializedName("ExpireDate")
    private String expDate;
    @SerializedName("Documentfile")
    private String vettingDocuments;

    private String CaregiverID;

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

    private String Requestdocument ="fgkjhfg";


}
