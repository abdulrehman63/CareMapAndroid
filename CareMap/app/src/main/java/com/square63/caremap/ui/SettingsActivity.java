package com.square63.caremap.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.square63.caremap.R;
import com.square63.caremap.constants.Constants;
import com.square63.caremap.ui.providerModule.CreateProviderProfileActivity;
import com.square63.caremap.ui.seekerModule.CreateSeniorProfileActivity;
import com.square63.caremap.utils.PreferenceHelper;
import com.square63.caremap.utils.UIHelper;

public class SettingsActivity extends AppCompatActivity {
    private TextView titileToolbar;
    private ImageButton imgBack;
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        type = PreferenceHelper.getInstance().getAppString(Constants.TYPE,"");
        initToolBar();
    }
    private void initToolBar(){

        imgBack =(ImageButton) findViewById(R.id.imgBackbtn);
        imgBack.setVisibility(View.VISIBLE);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        titileToolbar = (TextView)findViewById(R.id.toolbarTittle);
        titileToolbar.setText("Settings");

    }
    public void onTermsClick(View view){
        UIHelper.openLink(this);
    }
    public void onShareAppClick(View view){
        UIHelper.shareApp(this,"Coming soon");

    }
    public void onHelpClick(View view){
        UIHelper.openLink(this);
    }
    public void onLogoutClick(View view){
        PreferenceHelper.getInstance().setString(Constants.ID,"");
        PreferenceHelper.getInstance().setString(Constants.TYPE,"");
        UIHelper.openAndClearActivity(SettingsActivity.this,LoginActivity.class);
    }

    public void onEditProfileClick(View view) {
        if(type.equalsIgnoreCase(Constants.PROVIDER)){
            Intent intent = new Intent(SettingsActivity.this,CreateProviderProfileActivity.class);
            intent.putExtra(Constants.TYPE,"Edit");
            startActivity(intent);
           // UIHelper.openActivity(SettingsActivity.this, CreateProviderProfileActivity.class);
        }else {
            Intent intent = new Intent(SettingsActivity.this,CreateSeniorProfileActivity.class);
            intent.putExtra(Constants.TYPE,"Edit");
            startActivity(intent);
            //UIHelper.openActivity(SettingsActivity.this, CreateSeniorProfileActivity.class);
        }
    }

    public void onChangePasswordAppClick(View view) {
        UIHelper.openActivity(SettingsActivity.this,ForgotPasswordActivity.class);
    }
}
