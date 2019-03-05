package com.square63.caremap.ui.seekerModule;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.square63.caremap.ApplicationState;
import com.square63.caremap.R;
import com.square63.caremap.constants.Constants;
import com.square63.caremap.databinding.ActivityCreateSeekerProfileBinding;
import com.square63.caremap.databinding.ActivityCreateSeniorProfileBinding;
import com.square63.caremap.dialoges.LanguageSelectionDialoge;
import com.square63.caremap.listeners.RecyclerItemClickListener;
import com.square63.caremap.models.InterestModel;
import com.square63.caremap.models.LanguageModel;
import com.square63.caremap.models.giverModels.UserLanguage;
import com.square63.caremap.models.seekerModels.CreateSeekerRequest;
import com.square63.caremap.models.seekerModels.CreateSeniorRequest;
import com.square63.caremap.models.seekerModels.SeniorLanguageModel;
import com.square63.caremap.ui.adapters.CareListAdapter;
import com.square63.caremap.ui.adapters.ColorSchemeAdapter;
import com.square63.caremap.ui.adapters.InterestAdapter;
import com.square63.caremap.ui.adapters.LanguagesAdapater;
import com.square63.caremap.ui.adapters.MobilityAdapter;
import com.square63.caremap.ui.providerModule.PersonalInfoActivity;
import com.square63.caremap.ui.views.GetStartedActivity;
import com.square63.caremap.utils.PreferenceHelper;
import com.square63.caremap.utils.UIHelper;
import com.square63.caremap.utils.Validations;
import com.square63.caremap.webapi.Apiinterface.ApiCallback;
import com.square63.caremap.webapi.requests.GenericGetRequest;
import com.square63.caremap.webapi.requests.InsertUserInterestRequest;
import com.square63.caremap.webapi.requests.InsertUserLangRequest;
import com.square63.caremap.webapi.responses.GiverResultResponse;
import com.square63.caremap.webapi.responses.MainResponse;
import com.square63.caremap.webapi.webservices.WebServiceFactory;

import java.util.ArrayList;

public class CreateSeniorProfileActivity extends AppCompatActivity implements View.OnClickListener,InterestAdapter.ISkills,ColorSchemeAdapter.ISkills{
    ActivityCreateSeniorProfileBinding binding;
    TextView txtMail, txtFemail, txtBinary;
    private String reasonForCareArr[] = {"Old Age","Cancer","Alzheimers","Dementia","Stroke","Diabetes","Companionship","Post Surgical Care","Foster Independence","Loneliness","Hygiene/Grooming","Bathing/Toileting","Meal Preparation","Light Houskeeping","Medication Reminders","Dressing"};
    private String mobilityArr[] = {"Independent","Mobile + Cane","Mobility + Walker","Low Mobility","Wheelchair","Non Mobile"};
    private String interestArr[] = {"Arts & Crafts","Church Events","Cooking","Computers","Gardening","Movies","Pets","Playing Cards","Reading","Sewing","Shopping","Spiritualism","Sports","Travelling"};
    private String interestIds[] = {"bedb971f-c5e4-4aa1-9017-d8c1114186e5","ff1e5484-c763-474e-a0a6-f7303025798c","ad1590e6-264e-4cb5-ad48-9e1e7e484424","45254526-b8b6-49d4-a396-bf3a2edae66f","e9efd7a6-6e88-4954-a846-2885c334add6","43c3627e-9505-4cfe-90dd-9a585b63b210","943ed09f-775a-4d0d-a709-261edae15e2e","791784a4-2004-43f2-94ff-e9caaf5e8dc6","b83b1611-9107-43a6-83a8-06f10e416b32","87c09be2-7c26-4cb9-814d-c927f0c465d4","0e840008-311f-4d01-9a99-49a7063f6111","8aa319a1-b941-425a-a9e2-5ea87620ce52","ff1e5484-c763-474e-a0a6-f7303025798c","b76b0867-75ba-4b44-9246-2a6e515f424d"};

    private Integer interestIcons[] = {R.drawable.artscrafts,R.drawable.churchactivities,R.drawable.cooking,R.drawable.computertech,R.drawable.gardening,R.drawable.movies,R.drawable.pets,R.drawable.playingcards,R.drawable.reading,R.drawable.sewing,R.drawable.shopping,R.drawable.spiritualism,R.drawable.sports,R.drawable.travelling};

    private Integer mobilityIconsArr[] ={R.drawable.independent_2x,R.drawable.cane_2x,R.drawable.walker_2x,R.drawable.lowmobility_2x,R.drawable.wheelchair_2x,R.drawable.nonmobile_2x};
     private CareListAdapter careListAdapter;
    private RecyclerView recyclerView,recyclerViewMobility,recyclerViewInterest,recyclerViewProfile;
    private MobilityAdapter mobilityAdapter;
    private InterestAdapter interestAdapter;
    private ColorSchemeAdapter colorSchemeAdapter;
    private ImageButton imgBack;
    private TextView titileToolbar,toolbarTitleRight;
    private ArrayList<InterestModel> interestModelArrayList = new ArrayList<>();
    private ArrayList<LanguageModel> modelArrayList = new ArrayList<>();
    private ArrayList<LanguageModel> langArrayList = new ArrayList<>();
    private int selectedColor ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_senior_profile);
        init();

    }

    private void init() {
       setSeniorData();
        initToolBar();
        recyclerView = binding.getRoot().findViewById(R.id.recyclerView);
        recyclerViewMobility = binding.getRoot().findViewById(R.id.recyclerViewMobility);
        recyclerViewInterest = binding.getRoot().findViewById(R.id.recyclerViewInterest);
        recyclerViewProfile = binding.getRoot().findViewById(R.id.recyclerViewProfile);
        selectedColor=selectedColor =getResources().getColor(R.color.colorschem_1);

        txtMail = binding.txtMale;
        txtFemail = binding.txtFemail;
        txtBinary = binding.txtBinary;
        txtMail.setOnClickListener(this);
        txtFemail.setOnClickListener(this);
        txtBinary.setOnClickListener(this);
        getAllLang();
        initCareList();
        initMobilityList();
        //setData();
        setInterestData();
        initColorList();
    }
    private void initToolBar(){

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
        titileToolbar.setText("CREATE SENIOR PROFILE");
        toolbarTitleRight.setText("Done");
        toolbarTitleRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validations.validateSeekerProfile(binding.edtName,binding.edtAge,binding.edtCity,binding.edtProvince,binding.edtAddress1,binding.edtUnitNumber,binding.txtNumber,
                       binding.city,binding.province,binding.addres1,binding.unitNumber,binding.number,binding.txtName,binding.txtAge,binding.edtStreet,binding.street) == Constants.SUCCESS){
                    if(getIntent() != null && getIntent().getStringExtra(Constants.TYPE) != null){
                        if(getIntent().getStringExtra(Constants.TYPE).equalsIgnoreCase("Edit")){
                            finish();
                        }
                    }else {
                        insertSenior();

                    }

                }
                // UIHelper.openActivity(CreateProviderProfileActivity.this,);
            }
        });
        if(getIntent() != null && getIntent().getStringExtra(Constants.TYPE) != null){
            if(getIntent().getStringExtra(Constants.TYPE).equalsIgnoreCase("Edit")){
                titileToolbar.setText("EDIT SENIOR PROFILE");
            }
        }
    }
    private void setSeniorData(){
       CreateSeniorRequest createSeniorRequest =  new CreateSeniorRequest();
        if(ApplicationState.getInstance().isFromEdit()){
            GiverResultResponse giverResultResponse =ApplicationState.getInstance().getGiverResultResponse();
            if(giverResultResponse !=null){
                createSeniorRequest.setAge(giverResultResponse.getAge());
                createSeniorRequest.setName(giverResultResponse.getName());
                createSeniorRequest.setCity(giverResultResponse.getCity());
                createSeniorRequest.setPostalCode(giverResultResponse.getPostalCode());
                createSeniorRequest.setUnitNumber(giverResultResponse.getUnitNumber());
            }
            setLanguageData();
        }
        binding.setProfileModel(createSeniorRequest);

    }
    private void setLanguageData(){

        if(ApplicationState.getInstance().isFromEdit()){
            ArrayList<SeniorLanguageModel> userLanguages = ApplicationState.getInstance().getSeniorLanguageModelArrayList();
            if(userLanguages !=null){
                String languages ="";
                for (SeniorLanguageModel languageModel:userLanguages){
                    languages = languages + languageModel.getLanguageModel().getName() + ", ";
                }
                if (languages != null && languages.length() > 0 && languages.charAt(languages.length() - 1) == ',') {
                    languages = languages.substring(0, languages.length() - 1);
                }
                binding.txtLanguage.setText(languages);
            }
        }

    }
    private void insertSenior(){
        PreferenceHelper.getInstance().init(this);
        CreateSeniorRequest createSeniorRequest = new CreateSeniorRequest();
        createSeniorRequest.setCity(binding.getProfileModel().getCity());
        binding.getProfileModel().setColourScheme(selectedColor);
        binding.getProfileModel().setCareSeekerID(PreferenceHelper.getInstance().getString(Constants.SEEKER_ID,""));
        WebServiceFactory.getInstance().init(this);
        WebServiceFactory.getInstance().apiInsertSenior(binding.getProfileModel(), new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {
                PreferenceHelper.getInstance().setString(Constants.SENIOR_ID,mainResponse.getResultResponse().getId());
                insertData();
                UIHelper.openActivity(CreateSeniorProfileActivity.this,GetStartedActivity.class);
            }
        });
    }
    private void insertData(){
        for (InterestModel interestModel : interestModelArrayList){
            InsertUserInterestRequest insertUserInterestRequest=new InsertUserInterestRequest();
            if(interestModel.isSelected()){
                insertUserInterestRequest.setInterestID(interestModel.getInterestID());
                apiInsertSkills(insertUserInterestRequest);
            }
        }
        insertLangs(modelArrayList);
    }

    private void initCareList(){
        ArrayList<LanguageModel> languageModelArrayList = new ArrayList<>();
        for (int i= 0; i < reasonForCareArr.length; i++){
            LanguageModel languageModel = new LanguageModel();
            languageModel.setName(reasonForCareArr[i]);
            languageModelArrayList.add(languageModel);
        }
        setRecyclerView(languageModelArrayList);
    }
    private void initMobilityList(){
        ArrayList<InterestModel> languageModelArrayList = new ArrayList<>();
        for (int i= 0; i < mobilityArr.length; i++){
            InterestModel languageModel = new InterestModel();
            languageModel.setName(mobilityArr[i]);
            languageModel.setIcone(mobilityIconsArr[i]);
            languageModelArrayList.add(languageModel);
        }
        setMobilityRecyclerView(languageModelArrayList);
    }
    private void initColorList(){
         Integer colorArr[]={getResources().getColor(R.color.colorschem_1),getResources().getColor(R.color.colorschem_2),getResources().getColor(R.color.colorschem_3),getResources().getColor(R.color.colorschem_4),getResources().getColor(R.color.colorschem_5)};

        ArrayList<InterestModel> languageModelArrayList = new ArrayList<>();
        for (int i= 0; i < colorArr.length; i++){
            InterestModel languageModel = new InterestModel();
            languageModel.setIcone(colorArr[i]);
            languageModelArrayList.add(languageModel);
        }
        setColorsRecyclerView(languageModelArrayList);
    }


    private void setRecyclerView(ArrayList<LanguageModel> data) {
        careListAdapter=new CareListAdapter(this, data, new CareListAdapter.ISelectedLanguages() {
            @Override
            public void selectedLanguages(ArrayList<LanguageModel> languageModels) {

            }
        });
        recyclerView.setAdapter(careListAdapter);
        RecyclerView.LayoutManager mManager =new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mManager);

    }
    private void setMobilityRecyclerView(ArrayList<InterestModel> data) {
        mobilityAdapter=new MobilityAdapter(this, data);
        recyclerViewMobility.setAdapter(mobilityAdapter);
        RecyclerView.LayoutManager mManager =new GridLayoutManager(this, 3);
        recyclerViewMobility.setLayoutManager(mManager);

    }
    private void setColorsRecyclerView(ArrayList<InterestModel> data) {
        colorSchemeAdapter=new ColorSchemeAdapter(this, data,this);
        recyclerViewProfile.setAdapter(colorSchemeAdapter);
        RecyclerView.LayoutManager mManager =new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerViewProfile.setLayoutManager(mManager);

    }
    private void setInterestRecyclerView(ArrayList<InterestModel> data) {
        interestAdapter=new InterestAdapter(this, data,this);
        recyclerViewInterest.setAdapter(interestAdapter);
        RecyclerView.LayoutManager mManager =new GridLayoutManager(this, 3);
        recyclerViewInterest.setLayoutManager(mManager);

    }
    private void handleGender( int GENDER_TYPE) {
        txtMail.setTextColor(getResources().getColor(R.color.text_grey));
        txtFemail.setTextColor(getResources().getColor(R.color.text_grey));
        txtBinary.setTextColor(getResources().getColor(R.color.text_grey));
        txtMail.setCompoundDrawablesRelativeWithIntrinsicBounds(0,R.drawable.femaledark_2x,0,0);
        txtFemail.setCompoundDrawablesRelativeWithIntrinsicBounds(0,R.drawable.maledark_2x,0,0);
        txtBinary.setCompoundDrawablesRelativeWithIntrinsicBounds(0,R.drawable.nonbinarydark_2x,0,0);
        txtMail.setBackgroundResource(R.drawable.rectangleshadow_2x);
        txtFemail.setBackgroundResource(R.drawable.rectangleshadow_2x);
        txtBinary.setBackgroundResource(R.drawable.rectangleshadow_2x);
        switch (GENDER_TYPE){
            case Constants.MALE:
                txtMail.setTextColor(getResources().getColor(R.color.white));
                txtMail.setCompoundDrawablesRelativeWithIntrinsicBounds(0,R.drawable.female_2x,0,0);
                txtMail.setBackgroundResource(R.drawable.rectangleshadowselected_2x);
                break;
            case Constants.FEMAIL:
                txtFemail.setTextColor(getResources().getColor(R.color.white));
                txtFemail.setCompoundDrawablesRelativeWithIntrinsicBounds(0,R.drawable.male_2x,0,0);
                txtFemail.setBackgroundResource(R.drawable.rectangleshadowselected_2x);
                break;
            case Constants.BINARY:
                txtBinary.setTextColor(getResources().getColor(R.color.white));
                txtBinary.setCompoundDrawablesRelativeWithIntrinsicBounds(0,R.drawable.non_binary_2x,0,0);
                txtBinary.setBackgroundResource(R.drawable.rectangleshadowselected_2x);
                break;
                default:
                    break;
        }

    }
    public void onLanguageSelectionClick(View view){

        LanguageSelectionDialoge languageSelectionDialoge = LanguageSelectionDialoge.newInstance(langArrayList);
        languageSelectionDialoge.setSelectedLanguages(new LanguagesAdapater.ISelectedLanguages() {
            @Override
            public void selectedLanguages(ArrayList<LanguageModel> languageModels) {
                String languages="";
               modelArrayList = new ArrayList<>();
                for (LanguageModel languageModel:languageModels){
                    if(languageModel.isSelected()) {
                        languages = languages + languageModel.getName() + ",";
                        modelArrayList.add(languageModel);
                    }

                }
                if (languages != null && languages.length() > 0 && languages.charAt(languages.length() - 1) == ',') {
                    languages = languages.substring(0, languages.length() - 1);
                }
                binding.txtLanguage.setText(languages);

            }

        });

        languageSelectionDialoge.show(getSupportFragmentManager(),"languageSelectionDialoge");

    }
    private void insertLangs(ArrayList<LanguageModel> languageModelArrayList){
        for (int i =0; i < languageModelArrayList.size(); i++){
            InsertUserLangRequest langRequest = new InsertUserLangRequest();
            langRequest.setLanguageID(languageModelArrayList.get(i).getId());
            apiInsertLang(langRequest);
        }
    }
    private void apiInsertLang(InsertUserLangRequest insertUserLangRequest ){
        WebServiceFactory.getInstance().init(this);
        WebServiceFactory.getInstance().apiInsertSeniorLanguages(insertUserLangRequest, new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {

            }
        });

    }
    private void apiInsertSkills(InsertUserInterestRequest interestRequest){
        WebServiceFactory.getInstance().init(getApplicationContext());
        WebServiceFactory.getInstance().apiInsertSeniorInterest(interestRequest, new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {

            }
        });
    }
    private void getAllLang(){
        WebServiceFactory.getInstance().init(this);
        WebServiceFactory.getInstance().apiGetAllLang(new GenericGetRequest(), new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {
                langArrayList = mainResponse.getResultResponse().getLanguageModelArrayList();
            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
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

    private void setInterestData(){
        if(ApplicationState.getInstance().isFromEdit()) {
            ArrayList<InterestModel> interestModels =ApplicationState.getInstance().getInterestModelArrayList();
            boolean isSelected =false;
            ArrayList<InterestModel> data = new ArrayList<>();
            for (int i = 0; i < interestArr.length; i++) {

                isSelected = false;
                for (int j= 0; j <  interestModels.size(); j++){

                    if(interestIds[i].equalsIgnoreCase(interestModels.get(j).getInterestID())){
                        isSelected =true;
                    }

                }

                InterestModel dayModel = new InterestModel();
                if(isSelected){
                    dayModel.setSelected(true);
                }
                dayModel.setInterestID(interestIds[i]);
                dayModel.setName(interestArr[i]);
                dayModel.setIcone(interestIcons[i]);
                data.add(dayModel);
            }
            setInterestRecyclerView(data);
        }else {
            ArrayList<InterestModel> data = new ArrayList<>();
            for (int i= 0; i <  interestArr.length; i++){
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
        selectedColor = color;
    }
}
