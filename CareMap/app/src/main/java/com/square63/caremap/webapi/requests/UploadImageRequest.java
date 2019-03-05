package com.square63.caremap.webapi.requests;

import retrofit2.http.Field;
import retrofit2.http.Query;

public class UploadImageRequest {
    private String imageData;
    private String targetFilename;

    public String getImageData() {
        return imageData;
    }

    public void setImageData(String imageData) {
        this.imageData = imageData;
    }

    public String getTargetFilename() {
        return targetFilename;
    }

    public void setTargetFilename(String targetFilename) {
        this.targetFilename = targetFilename;
    }
}
