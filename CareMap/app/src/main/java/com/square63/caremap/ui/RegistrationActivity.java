package com.square63.caremap.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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
    }
    public void onSubmitClick(View view){
        Validations validations = new Validations(this);
        if(validations.validateSignup(binding.textView1,binding.textView2,binding.textView3) == Constants.SUCCESS ){
            UIHelper.openActivity(RegistrationActivity.this,LoginActivity.class);
        }

    }
}
