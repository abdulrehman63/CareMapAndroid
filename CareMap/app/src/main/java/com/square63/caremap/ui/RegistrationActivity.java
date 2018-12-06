package com.square63.caremap.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.square63.caremap.R;
import com.square63.caremap.constants.Constants;
import com.square63.caremap.databinding.ActivityRegisterationBinding;
import com.square63.caremap.models.RegistrationModel;
import com.square63.caremap.utils.UIHelper;
import com.square63.caremap.utils.Validations;

public class RegistrationActivity extends AppCompatActivity {
    ActivityRegisterationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_registeration);
        binding.setRegisterModel(new RegistrationModel());
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
    public void onSubmitClick(View view){
        Validations validations = new Validations(this);
        if(validations.validateSignup(binding.textView1,binding.textView2,binding.textView3) == Constants.SUCCESS ){
            UIHelper.openActivity(RegistrationActivity.this,WelcomeActivity.class);
        }

    }
}
