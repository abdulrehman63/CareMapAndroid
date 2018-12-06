package com.square63.caremap.ui;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;


import com.square63.caremap.R;
import com.square63.caremap.constants.Constants;
import com.square63.caremap.utils.PreferenceHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplashActivity extends FragmentActivity {
    private static int SPLASH_TIME_OUT = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        PreferenceHelper.getInstance().init(this);


            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    if(PreferenceHelper.getInstance().getString(Constants.ID,"").length() > 0) {
                        Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                        startActivity(intent);
                        finish();
                    }else {
                        Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                        startActivity(intent);
                        finish();
                    }

                }
            }, SPLASH_TIME_OUT);
        }




}
