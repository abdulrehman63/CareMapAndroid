package com.square63.caremap.ui.seekerModule;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestFutureTarget;
import com.square63.caremap.ApplicationState;
import com.square63.caremap.R;
import com.square63.caremap.constants.Constants;
import com.square63.caremap.databinding.ActivityCreateSeekerProfileBinding;
import com.square63.caremap.databinding.ActivityCreateSeniorProfileBinding;
import com.square63.caremap.dialoges.LanguageSelectionDialoge;
import com.square63.caremap.listeners.IPermissionsCallback;
import com.square63.caremap.listeners.IPickerCallBack;
import com.square63.caremap.listeners.RecyclerItemClickListener;
import com.square63.caremap.models.InterestModel;
import com.square63.caremap.models.LanguageModel;
import com.square63.caremap.models.RegistrationModel;
import com.square63.caremap.models.SkillsMainModel;
import com.square63.caremap.models.SkillsModel;
import com.square63.caremap.models.giverModels.UserLanguage;
import com.square63.caremap.models.seekerModels.CreateSeekerRequest;
import com.square63.caremap.models.seekerModels.CreateSeniorRequest;
import com.square63.caremap.models.seekerModels.SeniorLanguageModel;
import com.square63.caremap.ui.HomeActivity;
import com.square63.caremap.ui.SkillsActivity;
import com.square63.caremap.ui.adapters.CareListAdapter;
import com.square63.caremap.ui.adapters.ColorSchemeAdapter;
import com.square63.caremap.ui.adapters.InterestAdapter;
import com.square63.caremap.ui.adapters.LanguagesAdapater;
import com.square63.caremap.ui.adapters.MobilityAdapter;
import com.square63.caremap.ui.providerModule.CreateProviderProfileActivity;
import com.square63.caremap.ui.providerModule.PersonalInfoActivity;
import com.square63.caremap.ui.views.GetStartedActivity;
import com.square63.caremap.utils.CircleImageView;
import com.square63.caremap.utils.ImagePickerHelper;
import com.square63.caremap.utils.PermissionsHelper;
import com.square63.caremap.utils.PreferenceHelper;
import com.square63.caremap.utils.UIHelper;
import com.square63.caremap.utils.Validations;
import com.square63.caremap.webapi.Apiinterface.ApiCallback;
import com.square63.caremap.webapi.requests.GenericGetRequest;
import com.square63.caremap.webapi.requests.InsertGiverSkilsRequest;
import com.square63.caremap.webapi.requests.InsertUserInterestRequest;
import com.square63.caremap.webapi.requests.InsertUserLangRequest;
import com.square63.caremap.webapi.requests.UploadImageRequest;
import com.square63.caremap.webapi.responses.GiverResultResponse;
import com.square63.caremap.webapi.responses.MainResponse;
import com.square63.caremap.webapi.webservices.WebServiceFactory;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CreateSeniorProfileActivity extends AppCompatActivity implements View.OnClickListener, InterestAdapter.ISkills, ColorSchemeAdapter.ISkills , IPermissionsCallback {
    ActivityCreateSeniorProfileBinding binding;
    TextView txtMail, txtFemail, txtBinary;
    private PermissionsHelper permissionsHelper;
    private ImagePickerHelper imagePickerHelper;
    private String encodedImage;
    private RegistrationModel registrationModel;

    private String reasonForCareArr[] = {"Old Age", "Cancer", "Alzheimers", "Dementia", "Stroke", "Diabetes", "Companionship", "Post Surgical Care", "Foster Independence", "Loneliness", "Hygiene/Grooming", "Bathing/Toileting", "Meal Preparation", "Light Houskeeping", "Medication Reminders", "Dressing"};
    private String reasonForCareIdArr[] = {"2BAC0AD5-BADE-4D1E-A1D6-72CB2BB75E2D", "8E2FE73F-D5E3-40AE-8DF1-8B43ECE9205E", "F7D5D1FC-E360-4781-AC82-3A3D0124B785", "44104EB0-8E73-41D6-B61B-15347D6D7E94", "BF8FCCEB-B255-4EB4-AA33-75020B62E4D2", "F14C9654-F21D-4A1D-9A2D-8DC5FF104A68", "79A8DEFC-62C5-4595-BE76-A7F8C883A5BD"
            , "B18B125E-C802-409E-989B-726D620B8313", "56CC5D74-351E-4450-9B10-5C42E8C6FA1B", "821C7F52-B975-4D1C-B20E-A2DA3A41AAFF", "B1BE9698-8E88-4E97-9AFC-5E3F6479FB0B", "6CFA5486-1E7C-45FF-9E12-1AC93BB52B0C",
            "C7B6EA5F-007F-434C-B0F6-42CB62EC3C0D", "A2C59296-BEB5-4F8C-8715-940C09776E5A", "1D4C995D-378E-40FA-98D1-97A435EB8322", "6C126F35-1C37-4A8A-BE15-49C585732471"};

    private String mobilityArr[] = {"Independent", "Mobile + Cane", "Mobility + Walker", "Low Mobility", "Wheelchair", "Non Mobile"};
    private String mobilityIdArr[] = {"5D1214C1-12BA-47E8-BB4F-A78494380C94", "CFE24824-4702-4487-99B6-254777BCE18C", "0F599DB0-061F-450A-9329-CC8607C40BB1", "C566CD2C-51DC-443D-B354-0C5BFC7D7759", "0A43A4D7-CBBC-47D8-9504-2D4E2734E973", "D4E904E1-89D1-4D87-835C-D9E4EF65E528"};
    String interestArr[] = {"Arts & Crafts", "Church Events", "Cooking", "Computers", "Gardening", "Movies", "Pets", "Playing Cards", "Reading", "Sewing", "Shopping", "Spiritualism", "Exercise", "Travelling"};
    private String interestIds[] = {"bedb971f-c5e4-4aa1-9017-d8c1114186e5", "ff1e5484-c763-474e-a0a6-f7303025798c", "ad1590e6-264e-4cb5-ad48-9e1e7e484424", "45254526-b8b6-49d4-a396-bf3a2edae66f", "e9efd7a6-6e88-4954-a846-2885c334add6", "43c3627e-9505-4cfe-90dd-9a585b63b210", "943ed09f-775a-4d0d-a709-261edae15e2e", "791784a4-2004-43f2-94ff-e9caaf5e8dc6", "b83b1611-9107-43a6-83a8-06f10e416b32", "87c09be2-7c26-4cb9-814d-c927f0c465d4", "0e840008-311f-4d01-9a99-49a7063f6111", "8aa319a1-b941-425a-a9e2-5ea87620ce52", "b76b0867-75ba-4b44-9246-2a6e515f424d", "b76b0867-75ba-4b44-9246-2a6e515f424d"};

    private Integer interestIcons[] = {R.drawable.artscrafts, R.drawable.churchactivities, R.drawable.cooking, R.drawable.computertech, R.drawable.gardening, R.drawable.movies, R.drawable.pets, R.drawable.playingcards, R.drawable.reading, R.drawable.sewing, R.drawable.shopping, R.drawable.spiritualism, R.drawable.sports, R.drawable.travelling};

    private Integer mobilityIconsArr[] = {R.drawable.independent_2x, R.drawable.cane_2x, R.drawable.walker_2x, R.drawable.lowmobility_2x, R.drawable.wheelchair_2x, R.drawable.nonmobile_2x};
    private CareListAdapter careListAdapter;
    private RecyclerView recyclerView, recyclerViewMobility, recyclerViewInterest, recyclerViewProfile;
    private MobilityAdapter mobilityAdapter;
    private InterestAdapter interestAdapter;
    private ColorSchemeAdapter colorSchemeAdapter;
    private ImageButton imgBack;
    private TextView titileToolbar, toolbarTitleRight;
    private ArrayList<InterestModel> interestModelArrayList = new ArrayList<>();
    private ArrayList<LanguageModel> modelArrayList = new ArrayList<>();
    private ArrayList<LanguageModel> langArrayList = new ArrayList<>();
    private String gender = "Male";
    private int selectedColor;
    private CircleImageView imgProfile;
    private boolean isLocation;
    private ArrayList<LanguageModel> reasonForCareList = new ArrayList<>();
    private ConstraintLayout txtReason,txtInterest;
    private boolean isReasonChanged = false;
    private TextView txtReasonSelect,txtInterestSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_senior_profile);
        imgProfile = binding.getRoot().findViewById(R.id.imgProfile);
        txtReason = binding.getRoot().findViewById(R.id.selectAllReason);
        txtInterest = binding.getRoot().findViewById(R.id.selectAllInterest);
        txtReasonSelect = txtReason.findViewById(R.id.txtSelectAll);
        txtInterestSelect = txtInterest.findViewById(R.id.txtSelectAll);

        if(ApplicationState.getInstance().isFromEdit()) {
           /* Glide.with(this)
                    .load(Constants.BASE_IMAGE_URL_SENIOR + PreferenceHelper.getInstance().getString(Constants.SENIOR_ID, "") + ".png")
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
                    .fitCenter()
                    .placeholder(R.drawable.profile_default)
                    .error(R.drawable.profile_default)
                    .into(imgProfile);
        }*/
            Picasso.get()
                    .load(Constants.BASE_IMAGE_URL_SENIOR + PreferenceHelper.getInstance().getString(Constants.SENIOR_ID, "") + ".png")
                    .resize(50, 50)
                    .centerCrop()
                    .placeholder(R.drawable.profile_default)
                    .memoryPolicy(MemoryPolicy.NO_CACHE )
                    .networkPolicy(NetworkPolicy.NO_CACHE)
                    .into(imgProfile);
        }
        txtReason.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (careListAdapter != null) {
                    if(txtReasonSelect.getText().toString().equalsIgnoreCase( Constants.SELECT_ALL) ){
                        careListAdapter.setSelectedData();
                        txtReasonSelect.setText(Constants.UNSELECT_ALL);
                    }else {
                        careListAdapter.setUnSelectedData();
                        txtReasonSelect.setText(Constants.SELECT_ALL);
                    }

                }


            }
        });
        txtInterest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (interestAdapter != null) {
                    if(txtInterestSelect.getText().toString().equalsIgnoreCase( Constants.SELECT_ALL) ){
                        interestAdapter.setSelectedData();
                        txtInterestSelect.setText(Constants.UNSELECT_ALL);
                    }else {
                        interestAdapter.setUnSelectedData();
                        txtInterestSelect.setText(Constants.SELECT_ALL);
                    }

                }
            }
        });
        init();

    }
    public void onPickImageClick(View view) {
        selectImage();
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

                imgProfile.setImageBitmap(bitmap);
                encodedImage = Base64.encodeToString(bytes, Base64.DEFAULT);
            }
        });
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
    private void init() {

        initToolBar();
        recyclerView = binding.getRoot().findViewById(R.id.recyclerView);
        recyclerViewMobility = binding.getRoot().findViewById(R.id.recyclerViewMobility);
        recyclerViewInterest = binding.getRoot().findViewById(R.id.recyclerViewInterest);
        recyclerViewProfile = binding.getRoot().findViewById(R.id.recyclerViewProfile);
        selectedColor = -2;

        txtMail = binding.txtMale;
        txtFemail = binding.txtFemail;
        txtBinary = binding.txtBinary;
        txtMail.setOnClickListener(this);
        txtFemail.setOnClickListener(this);
        txtBinary.setOnClickListener(this);
        setSeniorData();
        getAllLang();
        initCareList();
        initMobilityList();
        //setData();
        setInterestData();
        initColorList();
        binding.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isLocation = isChecked;
            }
        });

    }


    private void initToolBar() {

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
        titileToolbar.setText("CREATE SENIOR PROFILE");
        toolbarTitleRight.setText("Done");
        toolbarTitleRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validations.validateSeekerProfile(binding.edtName, binding.edtAge, binding.edtCity, binding.edtProvince, binding.edtAddress1, binding.edtUnitNumber, binding.txtNumber,
                        binding.city, binding.province, binding.addres1, binding.unitNumber, binding.number, binding.txtName, binding.txtAge, binding.edtStreet, binding.street) == Constants.SUCCESS) {
                    if (getIntent() != null && getIntent().getStringExtra(Constants.TYPE) != null) {
                        if (getIntent().getStringExtra(Constants.TYPE).equalsIgnoreCase("Edit")) {
                            handleSelection();

                        }
                    } else {
                       if(encodedImage !=null){
                           handleSelection();

                        }else {
                           UIHelper.showAlert(Constants.PHOTO,Constants.PHOTO_SELECTION,CreateSeniorProfileActivity.this);
                       }


                    }

                }
                // UIHelper.openActivity(CreateProviderProfileActivity.this,);
            }
        });
        if (getIntent() != null && getIntent().getStringExtra(Constants.TYPE) != null) {
            if (getIntent().getStringExtra(Constants.TYPE).equalsIgnoreCase("Edit")) {
                titileToolbar.setText("EDIT SENIOR PROFILE");
            }
        }
    }

    private void setSeniorData() {
        CreateSeniorRequest createSeniorRequest = new CreateSeniorRequest();
        if (ApplicationState.getInstance().isFromEdit()) {
            GiverResultResponse giverResultResponse = ApplicationState.getInstance().getGiverResultResponse();
            if (giverResultResponse != null) {
                createSeniorRequest.setAge(giverResultResponse.getAge());
                createSeniorRequest.setName(giverResultResponse.getName());
                createSeniorRequest.setCity(giverResultResponse.getCity());
                createSeniorRequest.setPostalCode(giverResultResponse.getPostalCode());
                createSeniorRequest.setStreet(giverResultResponse.getStreet());
                createSeniorRequest.setHouseNumber(giverResultResponse.getHouseNumber());
                createSeniorRequest.setUnitNumber(giverResultResponse.getUnitNumber());
                createSeniorRequest.setProvince(giverResultResponse.getProvince());
            }

            setLanguageData();
            if (giverResultResponse != null) {
                if (giverResultResponse.getSex() != null) {
                    if (giverResultResponse.getSex().equalsIgnoreCase(Constants.S_MALE)) {
                        handleGender(Constants.MALE);
                        gender = Constants.S_MALE;
                    } else if (giverResultResponse.getSex().equalsIgnoreCase(Constants.FEMALE)) {
                        handleGender(Constants.FEMAIL);
                        gender = Constants.FEMALE;
                    } else {
                        handleGender(Constants.BINARY);
                        gender = Constants.S_BINARY;
                    }
                }
                if (giverResultResponse.getShareLocation()) {
                    binding.checkBox.setChecked(true);
                    isLocation =true;
                } else {
                    binding.checkBox.setChecked(false);
                }

            }
        }


        binding.setProfileModel(createSeniorRequest);

    }


    private void setLanguageData() {

        if (ApplicationState.getInstance().isFromEdit()) {

            ArrayList<SeniorLanguageModel> userLanguages = ApplicationState.getInstance().getSeniorLanguageModelArrayList();

            if (userLanguages != null) {
                String languages = "";
                modelArrayList = new ArrayList<>();
                for (SeniorLanguageModel languageModel : userLanguages) {
                    LanguageModel languageModel1 = new LanguageModel();
                    languageModel1.setId(languageModel.getLanguageModel().getId());
                    languageModel1.setName(languageModel.getLanguageModel().getName());
                    languageModel1.setSelected(true);
                    modelArrayList.add(languageModel1);
                    languages = languages + languageModel.getLanguageModel().getName() + ", ";
                }
                if (languages != null && languages.length() > 0 && languages.charAt(languages.length() - 1) == ',') {
                    languages = languages.substring(0, languages.length() - 1);
                }
                if(languages != null && languages.length() == 0){
                    languages = "Language(s)";
                }
                binding.txtLanguage.setText(languages);
            }
        }

    }

    private void insertSenior() {
        PreferenceHelper.getInstance().init(this);
        CreateSeniorRequest createSeniorRequest = new CreateSeniorRequest();
        createSeniorRequest.setCity(binding.getProfileModel().getCity());
        binding.getProfileModel().setColourScheme(selectedColor);
        binding.getProfileModel().setSex(gender);
        if (isLocation)
            binding.getProfileModel().setShareLocation("true");
        else
            binding.getProfileModel().setShareLocation("false");

        binding.getProfileModel().setCareSeekerID(PreferenceHelper.getInstance().getString(Constants.SEEKER_ID, ""));
        if (ApplicationState.getInstance().isFromEdit()) {

// Hide after some seconds
            final ProgressDialog loading;
            loading = ProgressDialog.show(this, "Updating Profile", "", true, false);

            final Handler handler  = new Handler();
            final Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    loading.dismiss();
                    Intent myIntent = new Intent(CreateSeniorProfileActivity.this, HomeActivity.class);
                    myIntent.putExtra(Constants.FORM,Constants.SENIOR_ID);
                    myIntent.addFlags(  Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(myIntent);
                }
            };
            handler.postDelayed(runnable, 5000);
            updateSeniorData();
        }
        else
            insertSeniorData();
    }

    private void insertReasons() {
        for (LanguageModel languageModel : reasonForCareList) {
            if (languageModel.isSelected()) {
                InsertGiverSkilsRequest skilsRequest = new InsertGiverSkilsRequest();
                skilsRequest.setSkillID(languageModel.getId());
                apiInsertSeniorSkills(skilsRequest);
            }
        }
    }

    private void insertSeniorData() {
        WebServiceFactory.getInstance().init(this);
        WebServiceFactory.getInstance().apiInsertSenior(binding.getProfileModel(), new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {
                PreferenceHelper.getInstance().setString(Constants.SENIOR_ID, mainResponse.getResultResponse().getId());
                insertData();
                if(encodedImage != null){
                    uploadImage(mainResponse.getResultResponse().getId());
                }
                UIHelper.openActivity(CreateSeniorProfileActivity.this, GetStartedActivity.class);
            }
        });
    }
    private void uploadImage(String id) {
        UploadImageRequest uploadImageRequest = new UploadImageRequest();
        uploadImageRequest.setImageData(encodedImage);
        uploadImageRequest.setTargetFilename(id + ".png");
        WebServiceFactory.getInstance().init(this);
        WebServiceFactory.getInstance().apiInsertSeniorImage(uploadImageRequest, new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {
                UIHelper.openActivity(CreateSeniorProfileActivity.this, PersonalInfoActivity.class);
            }
        });
    }

    private void updateSeniorData() {
        binding.getProfileModel().setId(PreferenceHelper.getInstance().getString(Constants.SENIOR_ID, ""));
        WebServiceFactory.getInstance().init(this);
        WebServiceFactory.getInstance().apiUpdateSenior(binding.getProfileModel(), new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {
                insertData();
                if(encodedImage != null){
                    uploadImage(PreferenceHelper.getInstance().getString(Constants.SENIOR_ID,""));
                }

                //UIHelper.openAndClearActivity(CreateSeniorProfileActivity.this, HomeActivity.class);
            }
        });
    }

    private void insertData() {

        if (ApplicationState.getInstance().isFromEdit()) {
            updateInterests();
            updateSkills();
            updateLanguages(modelArrayList);
        } else {
            addInterest();
            insertReasons();
            insertLangs(modelArrayList);
        }
    }

    private void addInterest() {
        for (InterestModel interestModel : interestModelArrayList) {
            InsertUserInterestRequest insertUserInterestRequest = new InsertUserInterestRequest();
            if (interestModel.isSelected()) {
                insertUserInterestRequest.setInterestID(interestModel.getInterestID());
                apiInsertSkills(insertUserInterestRequest);
            }
        }
    }

    private void initCareList() {
        ArrayList<LanguageModel> languageModelArrayList = new ArrayList<>();
        ArrayList<SkillsMainModel> skillsMainModels = ApplicationState.getInstance().getSeniorSkillsArrayList();
        boolean isSelected;
        boolean isAll =false;
        for (int i = 0; i < reasonForCareArr.length; i++) {
            isSelected = false;
            for (int j = 0; j < skillsMainModels.size(); j++) {
                if (skillsMainModels.get(j).getSkill() != null) {
                    if (reasonForCareIdArr[i].equalsIgnoreCase(skillsMainModels.get(j).getSkill().getId())) {
                        isSelected = true;
                    }
                }

            }

            LanguageModel languageModel = new LanguageModel();
            if (isSelected)
                languageModel.setSelected(true);
            else {
                isAll = true;
            }
            languageModel.setName(reasonForCareArr[i]);
            languageModel.setId(reasonForCareIdArr[i]);
            languageModelArrayList.add(languageModel);
        }
        if(!isAll){
            txtReasonSelect.setText(Constants.UNSELECT_ALL);
        }
        reasonForCareList = languageModelArrayList;
        setRecyclerView(languageModelArrayList);
    }

    private void initMobilityList() {

        ArrayList<InterestModel> languageModelArrayList = new ArrayList<>();
        for (int i = 0; i < mobilityArr.length; i++) {
            InterestModel languageModel = new InterestModel();
            if (ApplicationState.getInstance().getGiverResultResponse() != null) {
                if (ApplicationState.getInstance().getGiverResultResponse().getMobilityID() != null) {
                    if (ApplicationState.getInstance().getGiverResultResponse().getMobilityID().equalsIgnoreCase(mobilityIdArr[i])) {
                        languageModel.setSelected(true);
                        binding.getProfileModel().setMobilityID(mobilityIdArr[i]);
                    }
                }
            }
            languageModel.setName(mobilityArr[i]);
            languageModel.setIcone(mobilityIconsArr[i]);
            languageModel.setInterestID(mobilityIdArr[i]);
            languageModelArrayList.add(languageModel);
        }
        setMobilityRecyclerView(languageModelArrayList);
    }

    private void updateLanguages(ArrayList<LanguageModel> languageModelArrayList) {
        /*ArrayList<UserLanguage> userLanguages = ApplicationState.getInstance().getLanguageModelArrayList();
        if (userLanguages.size() > 0) {
            for (UserLanguage language : userLanguages) {
                for (LanguageModel language1 : langArrayList) {
                    if (language.getLanguageID().equalsIgnoreCase(language1.getId()) && !language1.isSelected()) {
                        InsertUserLangRequest langRequest = new InsertUserLangRequest();
                        langRequest.setLanguageID(language.getLanguageID());
                        apiDeleteLang(langRequest, languageModelArrayList);
                        break;
                    }
                }
            }
        } else {
            insertLangs(languageModelArrayList);
        }*/
        if(modelArrayList.size() > 0){
            InsertUserLangRequest langRequest = new InsertUserLangRequest();
            langRequest.setLanguageID(modelArrayList.get(0).getId());
            apiDeleteLang(langRequest, languageModelArrayList);
        }
    }

    private void apiDeleteLang(InsertUserLangRequest insertUserLangRequest, final ArrayList<LanguageModel> languageModelArrayList) {
        WebServiceFactory.getInstance().init(this);
        WebServiceFactory.getInstance().apiDeleteSeniorLanguages(insertUserLangRequest, new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {
                insertLangs(languageModelArrayList);
            }
        });

    }

    private void initColorList() {
        Integer colorArr[] = {getResources().getColor(R.color.colorschem_1), getResources().getColor(R.color.colorschem_2), getResources().getColor(R.color.colorschem_3), getResources().getColor(R.color.colorschem_4), getResources().getColor(R.color.colorschem_5)};
        if (ApplicationState.getInstance().isFromEdit()) {
            ArrayList<InterestModel> languageModelArrayList = new ArrayList<>();
            for (int i = 0; i < colorArr.length; i++) {
                InterestModel languageModel = new InterestModel();
                if (ApplicationState.getInstance().getGiverResultResponse() != null) {
                    if (ApplicationState.getInstance().getGiverResultResponse().getColourScheme() == i) {
                        languageModel.setSelected(true);
                        selectedColor = i;
                       // break;
                    }
                }
                languageModel.setIcone(colorArr[i]);
                languageModelArrayList.add(languageModel);
            }
            setColorsRecyclerView(languageModelArrayList);
        } else {
            ArrayList<InterestModel> languageModelArrayList = new ArrayList<>();
            for (int i = 0; i < colorArr.length; i++) {
                InterestModel languageModel = new InterestModel();
                languageModel.setIcone(colorArr[i]);
                languageModelArrayList.add(languageModel);
            }
            setColorsRecyclerView(languageModelArrayList);
        }

    }


    private void setRecyclerView(ArrayList<LanguageModel> data) {
        careListAdapter = new CareListAdapter(this, data, new CareListAdapter.ISelectedLanguages() {
            @Override
            public void selectedLanguages(ArrayList<LanguageModel> languageModels) {
                reasonForCareList = languageModels;
                isReasonChanged = true;
            }
        });
        recyclerView.setAdapter(careListAdapter);
        RecyclerView.LayoutManager mManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mManager);

    }

    private void setMobilityRecyclerView(ArrayList<InterestModel> data) {
        mobilityAdapter = new MobilityAdapter(this, data, new MobilityAdapter.ISkills() {
            @Override
            public void selectedSkills(String mobilityId) {
                binding.getProfileModel().setMobilityID(mobilityId);
            }
        });
        recyclerViewMobility.setAdapter(mobilityAdapter);
        RecyclerView.LayoutManager mManager = new GridLayoutManager(this, 3);
        recyclerViewMobility.setLayoutManager(mManager);

    }

    private void setColorsRecyclerView(ArrayList<InterestModel> data) {
        colorSchemeAdapter = new ColorSchemeAdapter(this, data, this);
        recyclerViewProfile.setAdapter(colorSchemeAdapter);
        RecyclerView.LayoutManager mManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewProfile.setLayoutManager(mManager);

    }

    private void setInterestRecyclerView(ArrayList<InterestModel> data) {
        interestAdapter = new InterestAdapter(this, data, this);
        recyclerViewInterest.setAdapter(interestAdapter);
        RecyclerView.LayoutManager mManager = new GridLayoutManager(this, 3);
        recyclerViewInterest.setLayoutManager(mManager);

    }

    private void handleGender(int GENDER_TYPE) {
        txtMail.setTextColor(getResources().getColor(R.color.text_grey));
        txtFemail.setTextColor(getResources().getColor(R.color.text_grey));
        txtBinary.setTextColor(getResources().getColor(R.color.text_grey));
        txtMail.setCompoundDrawablesRelativeWithIntrinsicBounds(0, R.drawable.femaledark_2x, 0, 0);
        txtFemail.setCompoundDrawablesRelativeWithIntrinsicBounds(0, R.drawable.maledark_2x, 0, 0);
        txtBinary.setCompoundDrawablesRelativeWithIntrinsicBounds(0, R.drawable.nonbinarydark_2x, 0, 0);
        txtMail.setBackgroundResource(R.drawable.rectangleshadow_2x);
        txtFemail.setBackgroundResource(R.drawable.rectangleshadow_2x);
        txtBinary.setBackgroundResource(R.drawable.rectangleshadow_2x);
        switch (GENDER_TYPE) {
            case Constants.MALE:
                gender = Constants.S_MALE;
                txtMail.setTextColor(getResources().getColor(R.color.white));
                txtMail.setCompoundDrawablesRelativeWithIntrinsicBounds(0, R.drawable.female_2x, 0, 0);
                txtMail.setBackgroundResource(R.drawable.rectangleshadowselected_2x);
                break;
            case Constants.FEMAIL:
                gender = Constants.FEMALE;
                txtFemail.setTextColor(getResources().getColor(R.color.white));
                txtFemail.setCompoundDrawablesRelativeWithIntrinsicBounds(0, R.drawable.male_2x, 0, 0);
                txtFemail.setBackgroundResource(R.drawable.rectangleshadowselected_2x);
                break;
            case Constants.BINARY:
                gender = Constants.S_BINARY;
                txtBinary.setTextColor(getResources().getColor(R.color.white));
                txtBinary.setCompoundDrawablesRelativeWithIntrinsicBounds(0, R.drawable.non_binary_2x, 0, 0);
                txtBinary.setBackgroundResource(R.drawable.rectangleshadowselected_2x);
                break;
            default:
                break;
        }

    }
    private void handleSelection(){
        boolean isSelected = false;
        for (LanguageModel skillsModel:reasonForCareList){
            if(skillsModel.isSelected()){
                isSelected = true;
                break;
            }
        }
        if(!isSelected){
            UIHelper.showAlert(Constants.FORM_TITLE,"Please select Reason for care",CreateSeniorProfileActivity.this);
            return;
        }
        if(binding.getProfileModel().getMobilityID() == null){
            UIHelper.showAlert(Constants.FORM_TITLE,"Please select Mobility",CreateSeniorProfileActivity.this);
            return;
        }
        isSelected = false;
        for (InterestModel skillsModel:interestModelArrayList){
            if(skillsModel.isSelected()){
                isSelected = true;
                break;
            }
        }
        if(!isSelected){
            UIHelper.showAlert(Constants.FORM_TITLE,"Please select Interest",CreateSeniorProfileActivity.this);
            return;
        }


        isSelected = false;
        for (LanguageModel skillsModel:modelArrayList){
            if(skillsModel.isSelected()){
                isSelected = true;
                break;
            }
        }
        if(!isSelected){
            UIHelper.showAlert(Constants.FORM_TITLE,"Please select language",CreateSeniorProfileActivity.this);
            return;
        }
        insertSenior();
    }

    public void onLanguageSelectionClick(View view) {

        LanguageSelectionDialoge languageSelectionDialoge = LanguageSelectionDialoge.newInstance(langArrayList);
        languageSelectionDialoge.setSelectedLanguages(new LanguagesAdapater.ISelectedLanguages() {
            @Override
            public void selectedLanguages(ArrayList<LanguageModel> languageModels) {
                String languages = "";
                modelArrayList = new ArrayList<>();
                for (LanguageModel languageModel : languageModels) {
                    if (languageModel.isSelected()) {
                        languages = languages + languageModel.getName() + ",";
                        modelArrayList.add(languageModel);
                    }

                }
                if (languages != null && languages.length() > 0 && languages.charAt(languages.length() - 1) == ',') {
                    languages = languages.substring(0, languages.length() - 1);
                }
                if(languages != null && languages.length() == 0){
                    languages = "Language(s)";
                }
                langArrayList = languageModels;

                binding.txtLanguage.setText(languages);

            }

        });

        languageSelectionDialoge.show(getSupportFragmentManager(), "languageSelectionDialoge");

    }

    private void insertLangs(ArrayList<LanguageModel> languageModelArrayList) {
        for (int i = 0; i < modelArrayList.size(); i++) {

            InsertUserLangRequest langRequest = new InsertUserLangRequest();
            langRequest.setLanguageID(modelArrayList.get(i).getId());
            apiInsertLang(langRequest);
        }
    }

    private void apiInsertLang(InsertUserLangRequest insertUserLangRequest) {
        WebServiceFactory.getInstance().init(this);
        WebServiceFactory.getInstance().apiInsertSeniorLanguages(insertUserLangRequest, new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {

            }
        });

    }

    private void apiInsertSkills(InsertUserInterestRequest interestRequest) {
        WebServiceFactory.getInstance().init(getApplicationContext());
        WebServiceFactory.getInstance().apiInsertSeniorInterest(interestRequest, new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {

            }
        });
    }

    private void getAllLang() {
        WebServiceFactory.getInstance().init(this);
        WebServiceFactory.getInstance().apiGetAllLang(new GenericGetRequest(), new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {
                langArrayList = mainResponse.getResultResponse().getLanguageModelArrayList();
                ArrayList<SeniorLanguageModel> userLanguages = ApplicationState.getInstance().getSeniorLanguageModelArrayList();
                if (userLanguages != null) {
                    String languages = "";
                    for (int i = 0; i < langArrayList.size(); i++) {
                        for (SeniorLanguageModel languageModel : userLanguages) {
                            if (langArrayList.get(i).getId().equalsIgnoreCase(languageModel.getLanguageModel().getId())) {
                                langArrayList.get(i).setSelected(true);
                                break;
                            }
                        }
                    }

                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txtMale:
                handleGender(Constants.MALE);
                break;
            case R.id.txtFemail:
                handleGender(Constants.FEMAIL);
                break;
            case R.id.txtBinary:
                handleGender(Constants.BINARY);
                break;
        }
    }

    private void setInterestData() {
        if (ApplicationState.getInstance().isFromEdit()) {
            ArrayList<InterestModel> interestModels = ApplicationState.getInstance().getInterestModelArrayList();
            boolean isSelected = false;
            boolean isAll = false;
            ArrayList<InterestModel> data = new ArrayList<>();
            for (int i = 0; i < interestArr.length; i++) {

                isSelected = false;
                for (int j = 0; j < interestModels.size(); j++) {

                    if (interestIds[i].equalsIgnoreCase(interestModels.get(j).getInterestID())) {
                        isSelected = true;
                    }

                }

                InterestModel dayModel = new InterestModel();
                if (isSelected) {
                    dayModel.setSelected(true);
                }else {
                    isAll = true;
                }
                dayModel.setInterestID(interestIds[i]);
                dayModel.setName(interestArr[i]);
                dayModel.setIcone(interestIcons[i]);
                data.add(dayModel);
            }
            if(!isAll){
                txtInterestSelect.setText(Constants.UNSELECT_ALL);
            }
            interestModelArrayList  =data;
            setInterestRecyclerView(data);
        } else {
            ArrayList<InterestModel> data = new ArrayList<>();
            for (int i = 0; i < interestArr.length; i++) {
                InterestModel dayModel = new InterestModel();
                dayModel.setInterestID(interestIds[i]);
                dayModel.setName(interestArr[i]);
                dayModel.setIcone(interestIcons[i]);
                data.add(dayModel);
            }
            setInterestRecyclerView(data);
        }
    }

    @Override
    public void selectedSkills(ArrayList<InterestModel> data) {
        interestModelArrayList = data;
    }

    @Override
    public void selectedColorScheme(int color) {
        selectedColor = color + 1;
    }

    private void updateInterests() {
        /*ArrayList<InterestModel> interestModels = ApplicationState.getInstance().getInterestModelArrayList();
        boolean isUnSelect = false;
        if (interestModels.size() > 0) {
            for (InterestModel interestModel : interestModels) {
                for (InterestModel interestModel1 : interestModelArrayList) {
                    if (interestModel.getInterestID().equalsIgnoreCase(interestModel1.getInterestID()) && !interestModel1.isSelected()) {
                        InsertUserInterestRequest insertUserInterestRequest = new InsertUserInterestRequest();
                        insertUserInterestRequest.setInterestID(interestModel.getInterestID());
                        apiDeleteSkills(insertUserInterestRequest);
                        isUnSelect = true;
                        break;
                    }
                }
            }
            if (!isUnSelect) {
                addInterest();
            }
        } else {
            addInterest();
        }*/
        if(interestModelArrayList.size() > 0){
            InsertUserInterestRequest insertUserInterestRequest = new InsertUserInterestRequest();
            insertUserInterestRequest.setInterestID(interestModelArrayList.get(0).getInterestID());
            apiDeleteSkills(insertUserInterestRequest);
        }
    }

    private void apiDeleteSkills(InsertUserInterestRequest interestRequest) {
        WebServiceFactory.getInstance().init(getApplicationContext());
        WebServiceFactory.getInstance().apiDleteSeniorInterest(interestRequest, new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {
                addInterest();
            }
        });
    }


    private void apiInsertSeniorSkills(InsertGiverSkilsRequest giverSkilsRequest) {
        WebServiceFactory.getInstance().init(getApplicationContext());
        WebServiceFactory.getInstance().apiInsertSeniorSkills(giverSkilsRequest, new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {

            }
        });
    }

    private void apiDeleteSeniorSkills(InsertGiverSkilsRequest giverSkilsRequest) {
        WebServiceFactory.getInstance().init(getApplicationContext());
        WebServiceFactory.getInstance().apiDeleteSeniorSkills(giverSkilsRequest, new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {
                insertReasons();
            }
        });
    }

    private void updateSkills() {
       /* ArrayList<SkillsMainModel> selectedSkills = ApplicationState.getInstance().getSeniorSkillsArrayList();
        boolean isUnSelect = false;
        if (selectedSkills.size() > 0) {
            for (SkillsMainModel skillsMainModel : selectedSkills) {
                for (LanguageModel skillsModel : reasonForCareList) {
                    if(skillsMainModel.getSkill() != null) {
                        if (skillsMainModel.getSkill().getId().equalsIgnoreCase(skillsModel.getId()) && !skillsModel.isSelected()) {
                            InsertGiverSkilsRequest skilsRequest = new InsertGiverSkilsRequest();
                            skilsRequest.setSkillID(skillsModel.getId());
                            apiDeleteSeniorSkills(skilsRequest);
                            isUnSelect = true;
                            break;
                        }
                    }
                }
            }
            if (!isUnSelect) {
                insertReasons();
            }
        } else {
            insertReasons();
        }*/
       if(reasonForCareList.size() > 0){
           InsertGiverSkilsRequest skilsRequest = new InsertGiverSkilsRequest();
           skilsRequest.setSkillID(reasonForCareList.get(0).getId());
           apiDeleteSeniorSkills(skilsRequest);
       }
    }


}
