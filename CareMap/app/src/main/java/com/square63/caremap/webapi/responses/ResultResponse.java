package com.square63.caremap.webapi.responses;

import com.google.gson.annotations.SerializedName;
import com.square63.caremap.models.InterestModel;
import com.square63.caremap.models.LanguageModel;

import java.io.Serializable;
import java.util.ArrayList;

public class ResultResponse implements Serializable{
    private String status;
    private String msg;
    private String id;
    private String id2;

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

    @SerializedName("userInterests")
    private ArrayList<InterestModel> interestModelArrayList;

    public ArrayList<LanguageModel> getLanguageModelArrayList() {
        return languageModelArrayList;
    }

    public void setLanguageModelArrayList(ArrayList<LanguageModel> languageModelArrayList) {
        this.languageModelArrayList = languageModelArrayList;
    }

    @SerializedName("languages")

    private ArrayList<LanguageModel> languageModelArrayList;
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
