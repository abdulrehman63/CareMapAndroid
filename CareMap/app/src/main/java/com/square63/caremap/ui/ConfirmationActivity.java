package com.square63.caremap.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.square63.caremap.R;
import com.square63.caremap.constants.Constants;
import com.square63.caremap.utils.PreferenceHelper;
import com.square63.caremap.utils.UIHelper;

public class ConfirmationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
    }
    public void onContinueClick(View view){
        PreferenceHelper.getInstance().init(ConfirmationActivity.this);
        PreferenceHelper.getInstance().setString(Constants.ID,"1");
        UIHelper.openActivity(ConfirmationActivity.this,HomeActivity.class);

    }
}
