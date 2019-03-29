package com.square63.caremap;

import android.content.Context;

import com.square63.caremap.models.InterestModel;
import com.square63.caremap.models.LanguageModel;
import com.square63.caremap.models.SkillsMainModel;
import com.square63.caremap.models.SkillsModel;
import com.square63.caremap.models.giverModels.Availability;
import com.square63.caremap.models.giverModels.Caregiver;
import com.square63.caremap.models.giverModels.UserLanguage;
import com.square63.caremap.models.seekerModels.CareSeeker;
import com.square63.caremap.models.seekerModels.Senior;
import com.square63.caremap.models.seekerModels.SeniorLanguageModel;
import com.square63.caremap.webapi.responses.GiverResultResponse;

import java.util.ArrayList;

public class ApplicationState {
    private static  ApplicationState instance = null;
    private Context context;
    public static ApplicationState getInstance(){
        if(instance == null)
            instance = new ApplicationState();
        return instance;
    }
    public void clearInstance(){
        instance =null;
    }
    public  void init(Context context){
        this.context = context;
    }
    private Caregiver caregiver = new Caregiver();

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    private boolean isFromEdit =false;
    private ArrayList<UserLanguage> languageModelArrayList=new ArrayList<>();

    public ArrayList<SeniorLanguageModel> getSeniorLanguageModelArrayList() {
        return seniorLanguageModelArrayList;
    }

    public void setSeniorLanguageModelArrayList(ArrayList<SeniorLanguageModel> seniorLanguageModelArrayList) {
        this.seniorLanguageModelArrayList = seniorLanguageModelArrayList;
    }

    private ArrayList<SeniorLanguageModel> seniorLanguageModelArrayList=new ArrayList<>();
    private ArrayList<InterestModel> interestModelArrayList=new ArrayList<>();
    private ArrayList<SkillsMainModel> skillsModelArrayList=new ArrayList<>();
    private ArrayList<SkillsMainModel> seniorSkillsArrayList=new ArrayList<>();
    private ArrayList<Availability> availabilityArrayList=new ArrayList<>();

    public ArrayList<SkillsMainModel> getSeniorSkillsArrayList() {
        return seniorSkillsArrayList;
    }

    public void setSeniorSkillsArrayList(ArrayList<SkillsMainModel> seniorSkillsArrayList) {
        this.seniorSkillsArrayList = seniorSkillsArrayList;
    }

    public static void setInstance(ApplicationState instance) {

        ApplicationState.instance = instance;
    }

    public ArrayList<Availability> getAvailabilityArrayList() {
        return availabilityArrayList;
    }

    public void setAvailabilityArrayList(ArrayList<Availability> availabilityArrayList) {
        this.availabilityArrayList = availabilityArrayList;
    }

    public CareSeeker getCareSeeker() {
        return careSeeker;
    }

    public void setCareSeeker(CareSeeker careSeeker) {
        this.careSeeker = careSeeker;
    }

    private CareSeeker careSeeker;

    public Senior getSenior() {
        return senior;
    }

    public void setSenior(Senior senior) {
        this.senior = senior;
    }

    private Senior senior;
    private GiverResultResponse giverResultResponse;

    public GiverResultResponse getGiverResultResponse() {
        return giverResultResponse;
    }

    public void setGiverResultResponse(GiverResultResponse giverResultResponse) {
        this.giverResultResponse = giverResultResponse;
    }

    public ArrayList<SkillsMainModel> getSkillsModelArrayList() {
        return skillsModelArrayList;
    }

    public void setSkillsModelArrayList(ArrayList<SkillsMainModel> skillsModelArrayList) {
        this.skillsModelArrayList = skillsModelArrayList;
    }

    public ArrayList<InterestModel> getInterestModelArrayList() {
        return interestModelArrayList;
    }

    public void setInterestModelArrayList(ArrayList<InterestModel> interestModelArrayList) {
        this.interestModelArrayList = interestModelArrayList;
    }

    public boolean isFromEdit() {
        return isFromEdit;
    }

    public ArrayList<UserLanguage> getLanguageModelArrayList() {
        return languageModelArrayList;
    }

    public void setLanguageModelArrayList(ArrayList<UserLanguage> languageModelArrayList) {
        this.languageModelArrayList = languageModelArrayList;
    }

    public void setFromEdit(boolean fromEdit) {

        isFromEdit = fromEdit;
    }

    public Caregiver getCaregiver() {
        return caregiver ;
    }

    public void setCaregiver(Caregiver caregiver) {
        this.caregiver = caregiver;
    }
}
