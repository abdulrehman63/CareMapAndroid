package com.square63.caremap.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.square63.caremap.R;
import com.square63.caremap.constants.Constants;
import com.square63.caremap.databinding.ActivityLoginBinding;
import com.square63.caremap.models.LoginModel;
import com.square63.caremap.utils.PreferenceHelper;
import com.square63.caremap.utils.UIHelper;
import com.square63.caremap.utils.Validations;
import com.square63.caremap.webapi.Apiinterface.ApiCallback;
import com.square63.caremap.webapi.responses.MainResponse;
import com.square63.caremap.webapi.webservices.WebServiceFactory;

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
            login();
        }

    }
    public void onSignupClicked(View view){
             UIHelper.openActivity(LoginActivity.this,RegistrationActivity.class);

    }
    public void onForgotPasswordClick(View view){
        UIHelper.openActivity(LoginActivity.this,ForgotPasswordActivity.class);

    }
    private void login(){
        WebServiceFactory.getInstance().init(this);
        WebServiceFactory.getInstance().apiLogin(binding.getLoginModel(), new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {
                if(mainResponse.getResultResponse().getData().getUserRole().equalsIgnoreCase(Constants.caregiver)){
                    PreferenceHelper.getInstance().setString(Constants.GIVER_ID,mainResponse.getResultResponse().getData().getId());
                    PreferenceHelper.getInstance().setString(Constants.ID,"1");
                    PreferenceHelper.getInstance().setString(Constants.TYPE,Constants.PROVIDER);
                    UIHelper.openActivity(LoginActivity.this,HomeActivity.class);
                }
            }
        });
    }


}
