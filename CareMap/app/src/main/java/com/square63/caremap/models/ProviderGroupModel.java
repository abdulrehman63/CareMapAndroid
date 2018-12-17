package com.square63.caremap.models;

import com.bignerdranch.expandablerecyclerview.model.Parent;

import java.util.List;

public class ProviderGroupModel implements Parent<ProviderChildModel> {

    private List<ProviderChildModel> mIngredients;

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
