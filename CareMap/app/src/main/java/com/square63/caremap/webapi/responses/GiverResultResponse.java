package com.square63.caremap.webapi.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.square63.caremap.models.InterestModel;
import com.square63.caremap.models.chatModule.Message;

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
}
