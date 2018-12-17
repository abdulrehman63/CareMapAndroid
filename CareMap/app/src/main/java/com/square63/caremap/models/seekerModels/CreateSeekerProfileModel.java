package com.square63.caremap.models.seekerModels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.square63.caremap.BR;

import java.io.Serializable;


public class CreateSeekerProfileModel extends BaseObservable implements Serializable {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String city;
    private String emergencyNumber;
    private String number;

    public String getEmergencyNumber() {
        return emergencyNumber;
    }

    public void setEmergencyNumber(String emergencyNumber) {
        this.emergencyNumber = emergencyNumber;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    private String unitNumber;
    private String hourlyRate;
    private String experience;

    public String getHourlyRate() {
        return hourlyRate;
    }
    @Bindable
    public void setHourlyRate(String hourlyRate) {
        this.hourlyRate = hourlyRate;
        notifyPropertyChanged(BR.hourlyRate);
    }

    public String getExperience() {
        return experience;
    }
    @Bindable
    public void setExperience(String experience) {
        this.experience = experience;
        notifyPropertyChanged(BR.experience);
    }

    public String getDistance() {
        return distance;
    }
    @Bindable
    public void setDistance(String distance) {
        this.distance = distance;
        notifyPropertyChanged(BR.distance);
    }

    public String getLanguage() {
        return language;
    }
    @Bindable
    public void setLanguage(String language) {
        this.language = language;
        notifyPropertyChanged(BR.language);
    }

    private String distance;
    private String language;

    private String province;
    private String address1;
    private String address2;
    public String getFirstName() {
        return firstName;
    }
    @Bindable
    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    public String getLastName() {
        return lastName;
    }
    @Bindable
    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    @Bindable
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        notifyPropertyChanged(BR.phoneNumber);
    }

    public String getCity() {
        return city;
    }
    @Bindable
    public void setCity(String city) {
        this.city = city;
        notifyPropertyChanged(BR.city);
    }

    public String getProvince() {
        return province;
    }
    @Bindable
    public void setProvince(String province) {
        this.province = province;
        notifyPropertyChanged(BR.province);
    }

    public String getAddress1() {
        return address1;
    }
    @Bindable
    public void setAddress1(String address1) {
        this.address1 = address1;
        notifyPropertyChanged(BR.address1);
    }

    public String getAddress2() {
        return address2;
    }
    @Bindable
    public void setAddress2(String address2) {
        this.address2 = address2;
        notifyPropertyChanged(BR.address2);
    }




}
