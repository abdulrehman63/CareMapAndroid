
package com.square63.caremap.webapi.requests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetSeekersRequest {

    @SerializedName("filterSenior")
    @Expose
    private FilterSenior filterSenior = new FilterSenior();
    @SerializedName("filterCareseeker")
    @Expose
    private FilterSenior filterCareseeker = new FilterSenior();

    public FilterSenior getFilterCareseeker() {
        return filterCareseeker;
    }

    public void setFilterCareseeker(FilterSenior filterCareseeker) {
        this.filterCareseeker = filterCareseeker;
    }

    @SerializedName("offset")
    @Expose
    private String offset ="0";
    @SerializedName("pagesize")
    @Expose
    private String pagesize = "10";

    public FilterSenior getFilterSenior() {
        return filterSenior;
    }

    public void setFilterSenior(FilterSenior filterSenior) {
        this.filterSenior = filterSenior;
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
