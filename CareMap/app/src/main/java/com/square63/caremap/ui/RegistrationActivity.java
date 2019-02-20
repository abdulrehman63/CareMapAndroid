package com.square63.caremap.ui;

import android.content.Intent;
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
import com.square63.caremap.ui.providerModule.CreateProviderProfileActivity;
import com.square63.caremap.utils.UIHelper;
import com.square63.caremap.utils.Validations;
import com.square63.caremap.webapi.Apiinterface.ApiCallback;
import com.square63.caremap.webapi.responses.MainResponse;
import com.square63.caremap.webapi.webservices.WebServiceFactory;

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
        if(validations.validateSignup(binding.textView1,binding.textView2,binding.textView3,binding.imageViewError) == Constants.SUCCESS ){
           // UIHelper.openActivity(RegistrationActivity.this,WelcomeActivity.class);
            apiEmailValidation(binding.getRegisterModel().getEmail());
        }

    }
    private void apiEmailValidation(String email){
        WebServiceFactory.getInstance().init(this);
        WebServiceFactory.getInstance().apiEmailValidations(email, new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {
                if(!mainResponse.getResultResponse().getStatus().equalsIgnoreCase(Constants.error)){
                    Intent intent = new Intent(RegistrationActivity.this, CreateProviderProfileActivity.class);
                    intent.putExtra(Constants.DATA,binding.getRegisterModel());
                    UIHelper.openActivity(RegistrationActivity.this,WelcomeActivity.class);
                }else {
                    UIHelper.showAlert(Constants.error,mainResponse.getResultResponse().getMsg(),RegistrationActivity.this);
                }
            }
        });
    }
}
