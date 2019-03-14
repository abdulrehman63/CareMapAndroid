
package com.square63.caremap.models.seekerModels;

import android.databinding.BaseObservable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateSeniorRequest extends BaseObservable {

    @SerializedName("CareSeekerID")
    @Expose
    private String careSeekerID;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @SerializedName("Id")
    @Expose

    private String id;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Age")
    @Expose
    private String age;
    @SerializedName("Sex")
    @Expose
    private String sex;
    @SerializedName("MobilityID")
    @Expose
    private String mobilityID;
    @SerializedName("HouseNumber")
    @Expose
    private String houseNumber;
    @SerializedName("UnitNumber")
    @Expose
    private String unitNumber;
    @SerializedName("Street")
    @Expose
    private String street;
    @SerializedName("City")
    @Expose
    private String city;
    @SerializedName("Province")
    @Expose
    private String province;
    @SerializedName("PostalCode")
    @Expose
    private String postalCode;
    @SerializedName("CountryID")
    @Expose
    private String countryID;
    @SerializedName("ShareLocation")
    @Expose
    private String shareLocation;
    @SerializedName("ColourScheme")
    @Expose
    private Integer colourScheme;

    public String getCareSeekerID() {
        return careSeekerID;
    }

    public void setCareSeekerID(String careSeekerID) {
        this.careSeekerID = careSeekerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMobilityID() {
        return mobilityID;
    }

    public void setMobilityID(String mobilityID) {
        this.mobilityID = mobilityID;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountryID() {
        return countryID;
    }

    public void setCountryID(String countryID) {
        this.countryID = countryID;
    }

    public String getShareLocation() {
        return shareLocation;
    }

    public void setShareLocation(String shareLocation) {
        this.shareLocation = shareLocation;
    }

    public Integer getColourScheme() {
        return colourScheme;
    }

    public void setColourScheme(Integer colourScheme) {
        this.colourScheme = colourScheme;
    }

}
