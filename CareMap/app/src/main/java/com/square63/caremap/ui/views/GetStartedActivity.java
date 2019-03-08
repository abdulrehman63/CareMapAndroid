package com.square63.caremap.ui.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.square63.caremap.R;
import com.square63.caremap.constants.Constants;
import com.square63.caremap.ui.ConfirmationActivity;
import com.square63.caremap.ui.HomeActivity;
import com.square63.caremap.utils.PreferenceHelper;

public class GetStartedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);
    }
    public void onContinueClick(View view){
        PreferenceHelper.getInstance().init(GetStartedActivity.this);
        PreferenceHelper.getInstance().setString(Constants.ID,"1");
        PreferenceHelper.getInstance().setString(Constants.TYPE,Constants.SEEKER);
        Intent intent = new Intent(GetStartedActivity.this,HomeActivity.class);
        intent.putExtra(Constants.TYPE,Constants.SEEKER);
        intent.addFlags(  Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }
}
