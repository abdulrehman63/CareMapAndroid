package com.square63.caremap.webapi.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.square63.caremap.models.Data;
import com.square63.caremap.models.InterestModel;
import com.square63.caremap.models.LanguageModel;
import com.square63.caremap.models.SkillsMainModel;
import com.square63.caremap.models.SkillsModel;
import com.square63.caremap.models.giverModels.Availability;
import com.square63.caremap.models.giverModels.Caregiver;
import com.square63.caremap.models.giverModels.User;
import com.square63.caremap.models.giverModels.UserLanguage;
import com.square63.caremap.models.seekerModels.Senior;
import com.square63.caremap.models.seekerModels.SeniorLanguageModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    public ArrayList<SkillsModel> getSkillsModelArrayList() {
        return skillsModelArrayList;
    }

    public void setSkillsModelArrayList(ArrayList<SkillsModel> skillsModelArrayList) {
        this.skillsModelArrayList = skillsModelArrayList;
    }

    @SerializedName("skills")
    private ArrayList<SkillsModel> skillsModelArrayList;

    @SerializedName("caregiverSkills")
    private ArrayList<SkillsMainModel> caregiverSkills;

    public ArrayList<SkillsMainModel> getSeniorSkills() {
        return seniorSkills;
    }

    public void setSeniorSkills(ArrayList<SkillsMainModel> seniorSkills) {
        this.seniorSkills = seniorSkills;
    }

    @SerializedName("seniorSkills")

    private ArrayList<SkillsMainModel> seniorSkills;

    public ArrayList<SkillsMainModel> getCaregiverSkills() {
        return caregiverSkills;
    }

    public void setCaregiverSkills(ArrayList<SkillsMainModel> caregiverSkills) {
        this.caregiverSkills = caregiverSkills;
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

    @SerializedName("caregivers")
    @Expose
    private ArrayList<Caregiver> caregivers = new ArrayList<>();

    @SerializedName("data")
    @Expose
    private Data data;

    public ArrayList<Caregiver> getCaregivers() {
        return caregivers;
    }

    public void setCaregivers(ArrayList<Caregiver> caregivers) {
        this.caregivers = caregivers;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public ArrayList<User> getCaregiver() {
        return caregiver;
    }

    public void setCaregiver(ArrayList<User> caregiver) {
        this.caregiver = caregiver;
    }

    @SerializedName("users")
    @Expose
    private ArrayList<User> caregiver = new ArrayList<>();

    public ArrayList<UserLanguage> getUserLanguages() {
        return userLanguages;
    }

    public void setUserLanguages(ArrayList<UserLanguage> userLanguages) {
        this.userLanguages = userLanguages;
    }

    @SerializedName("userLanguages")
    @Expose
    private ArrayList<UserLanguage> userLanguages = new ArrayList<>();


    public ArrayList<SeniorLanguageModel> getSeniorLanguages() {
        return seniorLanguages;
    }

    public void setSeniorLanguages(ArrayList<SeniorLanguageModel> seniorLanguages) {
        this.seniorLanguages = seniorLanguages;
    }

    @SerializedName("seniorLanguages")
    @Expose
    private ArrayList<SeniorLanguageModel> seniorLanguages = new ArrayList<>();
    @SerializedName("availabilities")
    @Expose
    private ArrayList<Availability> availabilities = null;

    public ArrayList<Availability> getAvailabilities() {
        return availabilities;
    }

    public void setAvailabilities(ArrayList<Availability> availabilities) {
        this.availabilities = availabilities;
    }

}
