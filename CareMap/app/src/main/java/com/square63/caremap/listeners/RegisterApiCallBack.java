package com.square63.caremap.listeners;

import com.square63.caremap.webapi.responses.CreateCareGiverResponse;

public interface RegisterApiCallBack {
    void onSuccess(CreateCareGiverResponse careGiverResponse);
}
