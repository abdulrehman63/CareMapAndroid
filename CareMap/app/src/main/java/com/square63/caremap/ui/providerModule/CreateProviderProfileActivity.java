package com.square63.caremap.ui.providerModule;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.square63.caremap.ApplicationState;
import com.square63.caremap.R;
import com.square63.caremap.constants.Constants;
import com.square63.caremap.databinding.ActivityCreateProviderProfileBinding;
import com.square63.caremap.listeners.IPermissionsCallback;
import com.square63.caremap.listeners.IPickerCallBack;
import com.square63.caremap.models.ProfileModel;
import com.square63.caremap.models.RegistrationModel;
import com.square63.caremap.models.giverModels.Caregiver;
import com.square63.caremap.utils.ImagePickerHelper;
import com.square63.caremap.utils.PermissionsHelper;
import com.square63.caremap.utils.PreferenceHelper;
import com.square63.caremap.utils.UIHelper;
import com.square63.caremap.utils.Validations;
import com.square63.caremap.webapi.Apiinterface.ApiCallback;
import com.square63.caremap.webapi.CreateGiverRequest;
import com.square63.caremap.webapi.requests.UploadImageRequest;
import com.square63.caremap.webapi.responses.MainResponse;
import com.square63.caremap.webapi.webservices.WebServiceFactory;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

public class CreateProviderProfileActivity extends AppCompatActivity implements IPermissionsCallback {
    ActivityCreateProviderProfileBinding binding;
    private ImageButton imgBack;
    private TextView titileToolbar;
    private TextView toolbarTitleRight;
    private PermissionsHelper permissionsHelper;
    private ImagePickerHelper imagePickerHelper;
    private RegistrationModel registrationModel;
    private String encodedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_provider_profile);
        registrationModel = (RegistrationModel) getIntent().getSerializableExtra(Constants.DATA);
        PreferenceHelper.getInstance().init(this);
        if (ApplicationState.getInstance().isFromEdit()) {
            Picasso.get()
                    .load(Constants.BASE_IMAGE_URL + PreferenceHelper.getInstance().getString(Constants.USER_ID, "") + ".png")
                    .resize(50, 50)
                    .centerCrop()
                    .placeholder(R.drawable.profile_default)
                    .memoryPolicy(MemoryPolicy.NO_CACHE)
                    .networkPolicy(NetworkPolicy.NO_CACHE)
                    .into(binding.imgProfile);
        }

        initToolBar();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    private void initToolBar() {
        setData();
        final Validations validations = new Validations(this);
        imgBack = (ImageButton) findViewById(R.id.imgBackbtn);
        imgBack.setVisibility(View.VISIBLE);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        titileToolbar = (TextView) findViewById(R.id.toolbarTittle);
        toolbarTitleRight = (TextView) findViewById(R.id.toolbarTitleRight);
        titileToolbar.setText("Create Profile");
        if (getIntent() != null && getIntent().getStringExtra(Constants.TYPE) != null) {
            if (getIntent().getStringExtra(Constants.TYPE).equalsIgnoreCase("Edit")) {
                titileToolbar.setText("Create Profile");
            }
        }
        toolbarTitleRight.setText("Next");
        toolbarTitleRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validations.validateCreateProfile(binding.txtFirstName, binding.edtLastName, binding.edtDob, binding.edtPhone, binding.edtCity, binding.edtProvince, binding.edtAddress1
                        , binding.fName, binding.lName, binding.dob, binding.pNumber, binding.city, binding.province, binding.addres1) == Constants.SUCCESS) {

                    if (ApplicationState.getInstance().isFromEdit()) {
                        apiUpdateGiver();
                    } else {
                        registrationModel.setCity(binding.getProfileModel().getCity());
                        registrationModel.setFirstName(binding.getProfileModel().getFirstName());
                        registrationModel.setLastName(binding.getProfileModel().getLastName());
                        registrationModel.setGender("Male");
                        registrationModel.setPostalCode(binding.getProfileModel().getPostalCode());
                        registrationModel.setDateOfBirth(binding.getProfileModel().getDob());
                        registrationModel.setState(binding.getProfileModel().getProvince());
                        registrationModel.setAddress(binding.getProfileModel().getAddress1());
                        registrationModel.setAddress2(binding.getProfileModel().getAddress2());
                        registrationModel.setPhone(binding.getProfileModel().getPhoneNumber());
                        if(encodedImage !=null){
                            apiCreateGiver();

                        }else {
                            UIHelper.showAlert(Constants.PHOTO,Constants.PHOTO_SELECTION,CreateProviderProfileActivity.this);
                        }
                    }

                    // UIHelper.openActivity(CreateProviderProfileActivity.this,PersonalInfoActivity.class);
                } else {

                }
                // UIHelper.openActivity(CreateProviderProfileActivity.this,);
            }
        });
    }

    private void setData() {
        PreferenceHelper.getInstance().init(this);
        final ProfileModel profileModel = new ProfileModel();
        if (ApplicationState.getInstance().isFromEdit()) {
            Caregiver caregiver = ApplicationState.getInstance().getCaregiver();
            if (caregiver != null && caregiver.getUser().getFirstName() != null) {
                profileModel.setFirstName(caregiver.getUser().getFirstName());
                profileModel.setLastName(caregiver.getUser().getLastName());
                profileModel.setDob(caregiver.getUser().getDateOfBirth());
                profileModel.setCity(caregiver.getUser().getCity());
                profileModel.setProvince(caregiver.getUser().getState());
                profileModel.setPhoneNumber(caregiver.getUser().getPhone());
                profileModel.setAddress1(caregiver.getUser().getAddress());
                profileModel.setAddress2(caregiver.getUser().getAddress2());
                profileModel.setDob(PreferenceHelper.getInstance().getString(Constants.dob, ""));
                profileModel.setProvince(PreferenceHelper.getInstance().getString(Constants.province, ""));
                profileModel.setAddress2(caregiver.getUser().getAddress2());

            }
        }
        binding.setProfileModel(profileModel);
    }

    public void onPickImageClick(View view) {
        selectImage();
    }

    private void apiCreateGiver() {
        PreferenceHelper.getInstance().init(this);
        CreateGiverRequest createGiverRequest = new CreateGiverRequest();
        createGiverRequest.setRegistrationModel(registrationModel);
        PreferenceHelper.getInstance().setString(Constants.dob, registrationModel.getDateOfBirth());
        PreferenceHelper.getInstance().setString(Constants.province, registrationModel.getState());
        WebServiceFactory.getInstance().init(this);
        PreferenceHelper.getInstance().init(this);
        WebServiceFactory.getInstance().apiSignup(createGiverRequest, new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {
                PreferenceHelper.getInstance().setString(Constants.GIVER_ID, mainResponse.getResultResponse().getId());
                PreferenceHelper.getInstance().setString(Constants.USER_ID, mainResponse.getResultResponse().getId2());
                if (encodedImage != null) {
                    uploadImage(mainResponse.getResultResponse().getId2());
                }
                UIHelper.openActivity(CreateProviderProfileActivity.this, PersonalInfoActivity.class);
            }
        });
    }

    private void apiUpdateGiver() {
        PreferenceHelper.getInstance().init(this);
        final RegistrationModel registrationModel = new RegistrationModel();
        registrationModel.setCity(binding.getProfileModel().getCity());
        registrationModel.setFirstName(binding.getProfileModel().getFirstName());
        registrationModel.setLastName(binding.getProfileModel().getLastName());
        registrationModel.setGender("Male");
        registrationModel.setPostalCode(binding.getProfileModel().getPostalCode());
        registrationModel.setDateOfBirth(binding.getProfileModel().getDob());
        registrationModel.setState(binding.getProfileModel().getProvince());
        registrationModel.setAddress(binding.getProfileModel().getAddress1());
        registrationModel.setAddress2(binding.getProfileModel().getAddress2());
        registrationModel.setPhone(binding.getProfileModel().getPhoneNumber());
        CreateGiverRequest createGiverRequest = new CreateGiverRequest();
        Caregiver caregiver = ApplicationState.getInstance().getCaregiver();
        createGiverRequest.setId(PreferenceHelper.getInstance().getString(Constants.GIVER_ID, ""));
        createGiverRequest.setDescription(caregiver.getDescription());
        createGiverRequest.setProfileTitle(caregiver.getProfileTitle());
        createGiverRequest.setYearsOfExperience(caregiver.getYearsOfExperience());
        createGiverRequest.setDesiredWage(caregiver.getDesiredWage());
        createGiverRequest.setAvailabilityDistance(caregiver.getAvailabilityDistance());
        createGiverRequest.setRegistrationModel(registrationModel);
        WebServiceFactory.getInstance().init(this);
        WebServiceFactory.getInstance().apiUpdateGiver(createGiverRequest, new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {
                PreferenceHelper.getInstance().setString(Constants.dob, "");
                PreferenceHelper.getInstance().setString(Constants.province, "");
                PreferenceHelper.getInstance().setString(Constants.dob, registrationModel.getDateOfBirth());
                PreferenceHelper.getInstance().setString(Constants.province, registrationModel.getState());
                if (encodedImage != null) {
                    uploadImage(PreferenceHelper.getInstance().getString(Constants.USER_ID, ""));
                }
                UIHelper.openActivity(CreateProviderProfileActivity.this, PersonalInfoActivity.class);
            }
        });
    }


    private void selectImage() {
        permissionsHelper = new PermissionsHelper(this);
        permissionsHelper.checkCameraMultiplePermissions(this);
    }

    @Override
    public void onPermissionsGranted() {
        imagePickerHelper = new ImagePickerHelper(this);
        imagePickerHelper.selectImage(new IPickerCallBack() {
            @Override
            public void onImageSelected(Bitmap bitmap) {


            }

            @Override
            public void onImageSelected(Bitmap bitmap, byte[] bytes) {
                binding.imgProfile.setImageBitmap(bitmap);
                encodedImage = Base64.encodeToString(bytes, Base64.DEFAULT);
            }
        });
    }

    private void uploadImage(String id) {
        UploadImageRequest uploadImageRequest = new UploadImageRequest();
        uploadImageRequest.setImageData(encodedImage);
        uploadImageRequest.setTargetFilename(id + ".png");
        WebServiceFactory.getInstance().init(this);
        WebServiceFactory.getInstance().apiInsertUserImage(uploadImageRequest, new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {
                UIHelper.openActivity(CreateProviderProfileActivity.this, PersonalInfoActivity.class);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("helo", "On Destroy");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        imagePickerHelper.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (permissionsHelper != null) {
            permissionsHelper.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
        }

    }


}
