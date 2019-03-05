package com.square63.caremap.webapi.requests;

import com.square63.caremap.constants.Constants;
import com.square63.caremap.utils.PreferenceHelper;

public class InsertAvailabilityRequest {
    private String userId= PreferenceHelper.getInstance().getString(Constants.USER_ID,"");
    private int fromHour;
    private int toHour;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getFromHour() {
        return fromHour;
    }

    public void setFromHour(int fromHour) {
        this.fromHour = fromHour;
    }

    public int getToHour() {
        return toHour;
    }

    public void setToHour(int toHour) {
        this.toHour = toHour;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    private int dayOfWeek;
}
