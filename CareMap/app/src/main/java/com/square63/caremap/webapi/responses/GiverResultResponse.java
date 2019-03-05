package com.square63.caremap.webapi.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.square63.caremap.models.InterestModel;
import com.square63.caremap.models.chatModule.Message;
import com.square63.caremap.models.seekerModels.CareSeeker;
import com.square63.caremap.models.seekerModels.Country;
import com.square63.caremap.models.seekerModels.Senior;

import java.util.ArrayList;
import java.util.List;

public class GiverResultResponse {
    private String status;
    private String msg;
    private String id;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId2() {
        return id2;
    }

    public void setId2(String id2) {
        this.id2 = id2;
    }

    private String id2;

    @SerializedName("userInterests")
    private ArrayList<InterestModel> interestModelArrayList;
    @SerializedName("messages")
    @Expose
    private ArrayList<Message> messages = new ArrayList<>();

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public ArrayList<InterestModel> getInterestModelArrayList() {
        return interestModelArrayList;
    }

    public void setInterestModelArrayList(ArrayList<InterestModel> interestModelArrayList) {
        this.interestModelArrayList = interestModelArrayList;
    }
    public ArrayList<Senior> getSeniors() {
        return seniors;
    }

    public void setSeniors(ArrayList<Senior> seniors) {
        this.seniors = seniors;
    }

    @SerializedName("seniors")
    @Expose
    private ArrayList<Senior> seniors = new ArrayList<>();
    @SerializedName("careseekers")
    @Expose
    private ArrayList<CareSeeker> careSeekerArrayList;

    public ArrayList<CareSeeker> getCareSeekerArrayList() {
        return careSeekerArrayList;
    }

    public void setCareSeekerArrayList(ArrayList<CareSeeker> careSeekerArrayList) {
        this.careSeekerArrayList = careSeekerArrayList;
    }

    @SerializedName("careSeekerID")
    @Expose
    private String careSeekerID;
    @SerializedName("name")
    @Expose
    private String name;

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

    public Object getMobility() {
        return mobility;
    }

    public void setMobility(Object mobility) {
        this.mobility = mobility;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Boolean getShareLocation() {
        return shareLocation;
    }

    public void setShareLocation(Boolean shareLocation) {
        this.shareLocation = shareLocation;
    }

    public Integer getColourScheme() {
        return colourScheme;
    }

    public void setColourScheme(Integer colourScheme) {
        this.colourScheme = colourScheme;
    }

    @SerializedName("age")
    @Expose
    private String age;
    @SerializedName("sex")
    @Expose
    private String sex;
    @SerializedName("mobilityID")
    @Expose
    private String mobilityID;
    @SerializedName("mobility")
    @Expose
    private Object mobility;
    @SerializedName("houseNumber")
    @Expose
    private String houseNumber;
    @SerializedName("unitNumber")
    @Expose
    private String unitNumber;
    @SerializedName("street")
    @Expose
    private String street;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("province")
    @Expose
    private String province;
    @SerializedName("postalCode")
    @Expose
    private String postalCode;
    @SerializedName("countryID")
    @Expose
    private String countryID;
    @SerializedName("country")
    @Expose
    private Country country;
    @SerializedName("shareLocation")
    @Expose
    private Boolean shareLocation;
    @SerializedName("colourScheme")
    @Expose
    private Integer colourScheme;

}
