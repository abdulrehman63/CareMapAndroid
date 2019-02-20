package com.square63.caremap.ui.providerModule;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.square63.caremap.R;
import com.square63.caremap.constants.Constants;
import com.square63.caremap.databinding.ActivityCreateProviderProfileBinding;
import com.square63.caremap.listeners.IPermissionsCallback;
import com.square63.caremap.listeners.IPickerCallBack;
import com.square63.caremap.models.ProfileModel;
import com.square63.caremap.models.RegistrationModel;
import com.square63.caremap.utils.ImagePickerHelper;
import com.square63.caremap.utils.PermissionsHelper;
import com.square63.caremap.utils.PreferenceHelper;
import com.square63.caremap.utils.UIHelper;
import com.square63.caremap.utils.Validations;
import com.square63.caremap.webapi.Apiinterface.ApiCallback;
import com.square63.caremap.webapi.CreateGiverRequest;
import com.square63.caremap.webapi.responses.MainResponse;
import com.square63.caremap.webapi.webservices.WebServiceFactory;

public class CreateProviderProfileActivity extends AppCompatActivity implements IPermissionsCallback {
    ActivityCreateProviderProfileBinding binding;
    private ImageButton imgBack;
    private TextView titileToolbar;
    private TextView toolbarTitleRight;
    private PermissionsHelper permissionsHelper;
    private ImagePickerHelper imagePickerHelper;
    private RegistrationModel registrationModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_create_provider_profile);
        registrationModel = (RegistrationModel) getIntent().getSerializableExtra(Constants.DATA);
        initToolBar();
    }
    private void initToolBar(){
        final ProfileModel profileModel = new ProfileModel();
        binding.setProfileModel(profileModel);

        final Validations validations = new Validations(this);
        imgBack =(ImageButton) findViewById(R.id.imgBackbtn);
        imgBack.setVisibility(View.VISIBLE);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        titileToolbar = (TextView)findViewById(R.id.toolbarTittle);
        toolbarTitleRight = (TextView)findViewById(R.id.toolbarTitleRight);
        titileToolbar.setText("Create Profile");
        toolbarTitleRight.setText("Next");
        toolbarTitleRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(validations.validateCreateProfile(binding.txtFirstName,binding.edtLastName,binding.edtDob,binding.edtPhone,binding.edtCity,binding.edtProvince,binding.edtAddress1
                      ,binding.fName,binding.lName,binding.dob,binding.pNumber,binding.city,binding.province,binding.addres1 ) == Constants.SUCCESS){
                    registrationModel.setCity(profileModel.getCity());
                    registrationModel.setFirstName(profileModel.getFirstName());
                    registrationModel.setLastName(profileModel.getLastName());
                    registrationModel.setGender("Male");
                    registrationModel.setPostalCode("1234");
                    apiCreateGiver();
                   // UIHelper.openActivity(CreateProviderProfileActivity.this,PersonalInfoActivity.class);
                }else {

                }
               // UIHelper.openActivity(CreateProviderProfileActivity.this,);
            }
        });
    }
    public void onPickImageClick(View view){
        selectImage();
    }
    private void apiCreateGiver(){
        CreateGiverRequest createGiverRequest = new CreateGiverRequest();
        createGiverRequest.setRegistrationModel(registrationModel);
        WebServiceFactory.getInstance().init(this);
        WebServiceFactory.getInstance().apiSignup(createGiverRequest, new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {
                PreferenceHelper.getInstance().setString(Constants.GIVER_ID,mainResponse.getResultResponse().getId());
                UIHelper.openActivity(CreateProviderProfileActivity.this,PersonalInfoActivity.class);
            }
        });
    }



    private void selectImage(){
        permissionsHelper = new PermissionsHelper(this);
        permissionsHelper.checkCameraMultiplePermissions(this);
    }

    @Override
    public void onPermissionsGranted() {
        imagePickerHelper = new ImagePickerHelper(this);
        imagePickerHelper.selectImage(new IPickerCallBack() {
            @Override
            public void onImageSelected(Bitmap bitmap) {
                binding.imgProfile.setImageBitmap(bitmap);

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("helo","On Destroy");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        imagePickerHelper.onActivityResult(requestCode,resultCode,data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(permissionsHelper != null){
            permissionsHelper.onRequestPermissionsResult(requestCode,permissions,grantResults,this);
        }

    }


}
