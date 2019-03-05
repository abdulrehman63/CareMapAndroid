package com.square63.caremap.listeners;

import android.graphics.Bitmap;

public interface IPickerCallBack {
    void onImageSelected(Bitmap bitmap);
    void onImageSelected(Bitmap bitmap,byte[] bytes);
}
