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
import com.square63.caremap.webapi.Apiinterface.ApiCallBack2;
import com.square63.caremap.webapi.Apiinterface.ApiCallback;
import com.square63.caremap.webapi.requests.GetGiverProfileRequest;
import com.square63.caremap.webapi.requests.GetSeekersRequest;
import com.square63.caremap.webapi.requests.GiverRequest;
import com.square63.caremap.webapi.responses.MainResponse;
import com.square63.caremap.webapi.responses.MainResponse2;
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
                if(mainResponse.getResultResponse().getStatus().equalsIgnoreCase(Constants.error)){
                    UIHelper.showAlert("Login Failed","Please check your login credentials and try again",LoginActivity.this);
                }
                else {
                    if (mainResponse.getResultResponse().getData().getUserRole().equalsIgnoreCase(Constants.caregiver)) {
                        PreferenceHelper.getInstance().setString(Constants.USER_ID, mainResponse.getResultResponse().getData().getId());
                        getCareGiver(mainResponse.getResultResponse().getData().getId());

                    }else {
                        PreferenceHelper.getInstance().setString(Constants.SENIOR_ID, mainResponse.getResultResponse().getData().getId());
                        getCareSeeker(mainResponse.getResultResponse().getData().getId());
                    }
                }
            }
        });
    }
    private void getCareGiver(String id){
        WebServiceFactory.getInstance().init(this);
        GiverRequest giverProfileRequest = new GiverRequest();
        giverProfileRequest.getFilterCaregiver().setId(id);
        giverProfileRequest.getFilterCaregiver().setCity("/caregiver_userid/");
        WebServiceFactory.getInstance().apiGetAllCareGivers(giverProfileRequest, new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {
                if(mainResponse.getResultResponse().getCaregivers().size() > 0)
                PreferenceHelper.getInstance().setString(Constants.GIVER_ID, mainResponse.getResultResponse().getCaregivers().get(0).getId());
                PreferenceHelper.getInstance().setString(Constants.ID, "1");
                PreferenceHelper.getInstance().setString(Constants.TYPE, Constants.PROVIDER);
                UIHelper.openActivity(LoginActivity.this, HomeActivity.class);
            }
        });
    }
    private void getCareSeeker(String id){
        WebServiceFactory.getInstance().init(this);
        GetSeekersRequest giverProfileRequest = new GetSeekersRequest();
        giverProfileRequest.getFilterCareseeker().setId(id);
        giverProfileRequest.getFilterCareseeker().setCity("/careseeker_userid/");
        WebServiceFactory.getInstance().apiGetSeekerById(giverProfileRequest, new ApiCallBack2() {
            @Override
            public void onSuccess(MainResponse2 mainResponse) {
                if(mainResponse.getResultResponse().getCareSeekerArrayList().size() > 0)
                PreferenceHelper.getInstance().setString(Constants.SEEKER_ID, mainResponse.getResultResponse().getCareSeekerArrayList().get(0).getId());
                PreferenceHelper.getInstance().setString(Constants.ID, "1");
                PreferenceHelper.getInstance().setString(Constants.TYPE, Constants.PROVIDER);
                UIHelper.openActivity(LoginActivity.this, HomeActivity.class);
            }
        });
    }



}
