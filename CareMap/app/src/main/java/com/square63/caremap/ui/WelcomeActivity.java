package com.square63.caremap.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.square63.caremap.R;
import com.square63.caremap.constants.Constants;
import com.square63.caremap.models.RegistrationModel;
import com.square63.caremap.ui.providerModule.CreateProviderProfileActivity;
import com.square63.caremap.ui.seekerModule.CreateSeekerProfileActivity;
import com.square63.caremap.utils.UIHelper;

public class WelcomeActivity extends AppCompatActivity {

    private RegistrationModel registrationModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        setTitleBar();
        registrationModel =(RegistrationModel)getIntent().getSerializableExtra(Constants.DATA);
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
        Intent intent = new Intent(WelcomeActivity.this, CreateSeekerProfileActivity.class);
        intent.putExtra(Constants.DATA,registrationModel);
        startActivity(intent);
    }

    public void onProviderClick(View view) {
        Intent intent = new Intent(WelcomeActivity.this, CreateProviderProfileActivity.class);
        intent.putExtra(Constants.DATA,registrationModel);
        startActivity(intent);
    }
}
