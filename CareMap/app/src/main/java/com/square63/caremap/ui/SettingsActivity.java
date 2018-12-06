package com.square63.caremap.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.square63.caremap.R;
import com.square63.caremap.utils.UIHelper;

public class SettingsActivity extends AppCompatActivity {
    private TextView titileToolbar;
    private ImageButton imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
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
        UIHelper.openAndClearActivity(SettingsActivity.this,LoginActivity.class);
    }
}
