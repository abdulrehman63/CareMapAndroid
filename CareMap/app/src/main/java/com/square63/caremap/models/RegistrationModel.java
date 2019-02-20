package com.square63.caremap.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.annotations.SerializedName;
import com.square63.caremap.BR;

import java.io.Serializable;

public class RegistrationModel extends BaseObservable implements Serializable {
    @SerializedName("Email")
    private String email;
    @SerializedName("Password")
    private String password;
    @SerializedName("Username")
    private String userName;
    @SerializedName("Gender")
    private  String gender;
    @SerializedName("FirstName")
    private String firstName;
    @SerializedName("LastName")
    private String lastName;
    @SerializedName("RegistrationDate")
    private String registrationDate;
    @SerializedName("city")
    private String City;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }

    public String getUserRoleID() {
        return UserRoleID;
    }

    public void setUserRoleID(String userRoleID) {
        UserRoleID = userRoleID;
    }

    @SerializedName("postalCode")
    private String PostalCode;
    @SerializedName("userRoleID")
    private String UserRoleID;
    @SerializedName("Username")
    public String getUserName() {
        return userName;
    }
    @Bindable
    public void setUserName(String userName) {
        this.userName = userName;
        notifyPropertyChanged(BR.userName);
    }

    public String getEmail() {
        return email;
    }
    @Bindable
    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);

    }

    public String getPassword() {
        return password;
    }
    @Bindable
    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }
}
