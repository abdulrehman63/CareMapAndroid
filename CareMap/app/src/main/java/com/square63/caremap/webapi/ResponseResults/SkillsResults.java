package com.square63.caremap.webapi.ResponseResults;

import com.google.gson.annotations.SerializedName;
import com.square63.caremap.models.SkillsModel;

import java.io.Serializable;
import java.util.ArrayList;

public class SkillsResults implements Serializable {
    @SerializedName("skills")
    private ArrayList<SkillsModel> skillsModelArrayList;

    public ArrayList<SkillsModel> getSkillsModelArrayList() {
        return skillsModelArrayList;
    }

    public void setSkillsModelArrayList(ArrayList<SkillsModel> skillsModelArrayList) {
        this.skillsModelArrayList = skillsModelArrayList;
    }
}
