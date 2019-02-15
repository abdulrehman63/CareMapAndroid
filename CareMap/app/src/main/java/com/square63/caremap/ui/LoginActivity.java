package com.square63.caremap.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.square63.caremap.R;
import com.square63.caremap.constants.Constants;
import com.square63.caremap.databinding.ActivityLoginBinding;
import com.square63.caremap.models.LoginModel;
import com.square63.caremap.utils.UIHelper;
import com.square63.caremap.utils.Validations;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        binding.setLoginModel(new LoginModel());
    }
    public void onLoginClicked(View view){
        Validations validations = new Validations(this);
        if(validations.validateLogin(binding.textView2,binding.textView3,binding.imageViewError) == Constants.SUCCESS ){
            UIHelper.openActivity(LoginActivity.this,WelcomeActivity.class);
        }

    }
    public void onSignupClicked(View view){
             UIHelper.openActivity(LoginActivity.this,RegistrationActivity.class);

    }
    public void onForgotPasswordClick(View view){
        UIHelper.openActivity(LoginActivity.this,ForgotPasswordActivity.class);

    }


}
