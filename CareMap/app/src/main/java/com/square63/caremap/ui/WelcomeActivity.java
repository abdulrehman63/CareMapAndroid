package com.square63.caremap.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.square63.caremap.R;
import com.square63.caremap.ui.providerModule.CreateProviderProfileActivity;
import com.square63.caremap.ui.seekerModule.CreateSeekerProfileActivity;
import com.square63.caremap.utils.UIHelper;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        setTitleBar();
    }
    private void setTitleBar(){

        ImageButton imgBack = (ImageButton) findViewById(R.id.imgBackbtn);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void onSeekerClick(View view) {
        UIHelper.openActivity(WelcomeActivity.this, CreateSeekerProfileActivity.class);
    }

    public void onProviderClick(View view) {
        UIHelper.openActivity(WelcomeActivity.this, CreateProviderProfileActivity.class);
    }
}
