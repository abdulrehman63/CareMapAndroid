package com.square63.caremap.ui;

import android.content.Intent;
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
        PreferenceHelper.getInstance().setString(Constants.TYPE,Constants.PROVIDER);
        Intent intent = new Intent(ConfirmationActivity.this,HomeActivity.class);
        intent.putExtra(Constants.TYPE,Constants.PROVIDER);
        intent.addFlags(  Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }

    public void onVettedClick(View view) {
        UIHelper.openLink(this,"https://www.sterlingtalentsolutions.ca/landing-pages/u/uCarenet/");
    }
}
