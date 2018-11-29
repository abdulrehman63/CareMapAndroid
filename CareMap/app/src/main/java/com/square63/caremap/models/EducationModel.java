package com.square63.caremap.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.square63.caremap.BR;
import java.io.Serializable;

public class EducationModel extends BaseObservable implements Serializable{
    private String study;
    private String college;
    private String degree;

    public String getStudy() {
        return study;
    }
    @Bindable
    public void setStudy(String study) {
        this.study = study;
        notifyPropertyChanged(BR.study);
    }

    public String getCollege() {
        return college;
    }
    @Bindable
    public void setCollege(String college) {
        this.college = college;
        notifyPropertyChanged(BR.college);
    }

    public String getDegree() {
        return degree;
    }
    @Bindable
    public void setDegree(String degree) {
        this.degree = degree;
        notifyPropertyChanged(BR.degree);
    }

    public String getStartDate() {
        return startDate;
    }
    @Bindable
    public void setStartDate(String startDate) {
        this.startDate = startDate;
        notifyPropertyChanged(BR.startDate);
    }

    public String getEndDate() {
        return endDate;
    }
    @Bindable
    public void setEndDate(String endDate) {
        this.endDate = endDate;
        notifyPropertyChanged(BR.endDate);
    }

    private String startDate;
    private String endDate;
}
