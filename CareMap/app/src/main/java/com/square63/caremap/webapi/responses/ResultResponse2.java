package com.square63.caremap.webapi.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.square63.caremap.models.Data;
import com.square63.caremap.models.InterestModel;
import com.square63.caremap.models.LanguageModel;
import com.square63.caremap.models.SkillsModel;
import com.square63.caremap.models.giverModels.Caregiver;
import com.square63.caremap.models.giverModels.UserInterest;
import com.square63.caremap.models.giverModels.UserLanguage;
import com.square63.caremap.models.seekerModels.Senior;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResultResponse2 implements Serializable{
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

    public ArrayList<SkillsModel> getSkillsModelArrayList() {
        return skillsModelArrayList;
    }

    public void setSkillsModelArrayList(ArrayList<SkillsModel> skillsModelArrayList) {
        this.skillsModelArrayList = skillsModelArrayList;
    }
    @SerializedName("userLanguages")
    @Expose
    private ArrayList<UserLanguage> userLanguages = null;

    public ArrayList<UserLanguage> getUserLanguages() {
        return userLanguages;
    }

    public void setUserLanguages(ArrayList<UserLanguage> userLanguages) {
        this.userLanguages = userLanguages;
    }
    @SerializedName("skills")
    private ArrayList<SkillsModel> skillsModelArrayList;

    @SerializedName("caregivers")
    @Expose
    private ArrayList<Caregiver> caregivers = new ArrayList<>();

    public ArrayList<Caregiver> getCaregiver() {
        return caregiver;
    }

    public void setCaregiver(ArrayList<Caregiver> caregiver) {
        this.caregiver = caregiver;
    }

    @SerializedName("users")
    @Expose
    private ArrayList<Caregiver> caregiver = new ArrayList<>();
    @SerializedName("userInterests")
    @Expose
    private ArrayList<UserInterest> userInterests = null;
    @SerializedName("threads")
    @Expose
    private ArrayList<Thread> threads = null;

    public ArrayList<Thread> getThreads() {
        return threads;
    }

    public void setThreads(ArrayList<Thread> threads) {
        this.threads = threads;
    }

    public List<UserInterest> getUserInterests() {
        return userInterests;
    }

    public void setUserInterests(ArrayList<UserInterest> userInterests) {
        this.userInterests = userInterests;
    }


    @SerializedName("token")
    @Expose
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @SerializedName("data")
    @Expose

    private Data data;

    public ArrayList<Senior> getSeniors() {
        return seniors;
    }

    public void setSeniors(ArrayList<Senior> seniors) {
        this.seniors = seniors;
    }

    @SerializedName("seniors")
    @Expose
    private ArrayList<Senior> seniors = new ArrayList<>();

    public ArrayList<Caregiver> getCaregivers() {
        return caregivers;
    }

    public void setCaregivers(ArrayList<Caregiver> caregivers) {
        this.caregivers = caregivers;
    }

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
