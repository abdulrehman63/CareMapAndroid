package com.square63.caremap.webapi.requests;

public class InsertAvailabilityRequest {
    private String userId;
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

    public int getDayOfWeekl() {
        return dayOfWeekl;
    }

    public void setDayOfWeekl(int dayOfWeekl) {
        this.dayOfWeekl = dayOfWeekl;
    }

    private int dayOfWeekl;
}
