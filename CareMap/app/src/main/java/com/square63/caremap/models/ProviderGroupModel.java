package com.square63.caremap.models;

import com.bignerdranch.expandablerecyclerview.model.Parent;

import java.util.List;

public class ProviderGroupModel implements Parent<ProviderChildModel> {

    private List<ProviderChildModel> mIngredients;
    private boolean isExpanded = false;
    private String name;
    private String id;
    private String desc;

    public List<ProviderChildModel> getmIngredients() {
        return mIngredients;
    }

    public void setmIngredients(List<ProviderChildModel> mIngredients) {
        this.mIngredients = mIngredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    public ProviderGroupModel(String name, List<ProviderChildModel> ingredients) {
        mIngredients = ingredients;
    }

    @Override
    public List<ProviderChildModel> getChildList() {
        return mIngredients;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }
}
