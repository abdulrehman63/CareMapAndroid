package com.square63.caremap.webapi.requests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetGiverSkilsById {

    @SerializedName("filterCareGiverSkill")
    @Expose
    private FilterCaregiver filterCaregiver = new FilterCaregiver();
    @SerializedName("filterAvailability")
    @Expose
    private FilterCaregiver filterAvailability = new FilterCaregiver();

    public FilterCaregiver getFilterAvailability() {
        return filterAvailability;
    }

    public void setFilterAvailability(FilterCaregiver filterAvailability) {
        this.filterAvailability = filterAvailability;
    }

    @SerializedName("offset")
    @Expose
    private String offset = "0";
    @SerializedName("pagesize")
    @Expose
    private String pagesize ="10";

    public FilterCaregiver getFilterCaregiver() {
        return filterCaregiver;
    }

    public void setFilterCaregiver(FilterCaregiver filterCaregiver) {
        this.filterCaregiver = filterCaregiver;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getPagesize() {
        return pagesize;
    }

    public void setPagesize(String pagesize) {
        this.pagesize = pagesize;
    }
}
