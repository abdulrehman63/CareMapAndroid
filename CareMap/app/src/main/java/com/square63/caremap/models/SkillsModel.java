package com.square63.caremap.models;

import java.io.Serializable;

public class SkillsModel implements Serializable{
    private String name;
    private boolean isSelected;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
