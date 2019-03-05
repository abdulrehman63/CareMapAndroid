
package com.square63.caremap.webapi.requests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FilterSenior {

    @SerializedName("SeniorId")
    @Expose
    private String seniorId ="";
    @SerializedName("Id")
    @Expose
    private String id ="";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @SerializedName("CareseekerId")
    @Expose
    private String careseekerId="";
    @SerializedName("City")
    @Expose
    private String city="";
    @SerializedName("Province")
    @Expose
    private String province ="";

    public String getSeniorId() {
        return seniorId;
    }

    public void setSeniorId(String seniorId) {
        this.seniorId = seniorId;
    }

    public String getCareseekerId() {
        return careseekerId;
    }

    public void setCareseekerId(String careseekerId) {
        this.careseekerId = careseekerId;
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

}
