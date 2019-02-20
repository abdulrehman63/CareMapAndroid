package com.square63.caremap.webapi.responses;

import com.google.gson.annotations.SerializedName;
import com.square63.caremap.models.InterestModel;

import java.io.Serializable;
import java.util.ArrayList;

public class ResultResponse implements Serializable{
    private String status;
    private String msg;
    @SerializedName("userInterests")
    private ArrayList<InterestModel> interestModelArrayList;
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

    public ArrayList<InterestModel> getInterestModelArrayList() {
        return interestModelArrayList;
    }

    public void setInterestModelArrayList(ArrayList<InterestModel> interestModelArrayList) {
        this.interestModelArrayList = interestModelArrayList;
    }


}
