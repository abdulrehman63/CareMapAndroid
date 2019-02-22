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

import com.square63.caremap.R;
import com.square63.caremap.constants.Constants;
import com.square63.caremap.databinding.ActivityCreateSeekerProfileBinding;
import com.square63.caremap.databinding.ActivityCreateSeniorProfileBinding;
import com.square63.caremap.dialoges.LanguageSelectionDialoge;
import com.square63.caremap.listeners.RecyclerItemClickListener;
import com.square63.caremap.models.InterestModel;
import com.square63.caremap.models.LanguageModel;
import com.square63.caremap.ui.adapters.CareListAdapter;
import com.square63.caremap.ui.adapters.ColorSchemeAdapter;
import com.square63.caremap.ui.adapters.InterestAdapter;
import com.square63.caremap.ui.adapters.LanguagesAdapater;
import com.square63.caremap.ui.adapters.MobilityAdapter;
import com.square63.caremap.ui.providerModule.PersonalInfoActivity;
import com.square63.caremap.ui.views.GetStartedActivity;
import com.square63.caremap.utils.UIHelper;
import com.square63.caremap.utils.Validations;

import java.util.ArrayList;

public class CreateSeniorProfileActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityCreateSeniorProfileBinding binding;
    TextView txtMail, txtFemail, txtBinary;
    private String reasonForCareArr[] = {"Old Age","Cancer","Alzheimers","Dementia","Stroke","Diabetes","Companionship","Post Surgical Care","Foster Independence","Loneliness","Hygiene/Grooming","Bathing/Toileting","Meal Preparation","Light Houskeeping","Medication Reminders","Dressing"};
    private String mobilityArr[] = {"Independent","Mobile + Cane","Mobility + Walker","Low Mobility","Wheelchair","Non Mobile"};
    private String interestArr[] = {"Arts & Crafts","Church Events","Cooking","Computers","Gardening","Movies","Pets","Playing Cards","Reading","Sewing","Shopping","Spiritualism","Sports","Travelling"};
    private Integer interestIcons[] = {R.drawable.artscrafts,R.drawable.churchactivities,R.drawable.cooking,R.drawable.computertech,R.drawable.gardening,R.drawable.movies,R.drawable.pets,R.drawable.playingcards,R.drawable.reading,R.drawable.sewing,R.drawable.shopping,R.drawable.spiritualism,R.drawable.sports,R.drawable.travelling};

    private Integer mobilityIconsArr[] ={R.drawable.independent_2x,R.drawable.cane_2x,R.drawable.walker_2x,R.drawable.lowmobility_2x,R.drawable.wheelchair_2x,R.drawable.nonmobile_2x};
     private CareListAdapter careListAdapter;
    private RecyclerView recyclerView,recyclerViewMobility,recyclerViewInterest,recyclerViewProfile;
    private MobilityAdapter mobilityAdapter;
    private InterestAdapter interestAdapter;
    private ColorSchemeAdapter colorSchemeAdapter;
    private ImageButton imgBack;
    private TextView titileToolbar,toolbarTitleRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_senior_profile);
        init();
    }

    private void init() {
        initToolBar();
        recyclerView = binding.getRoot().findViewById(R.id.recyclerView);
        recyclerViewMobility = binding.getRoot().findViewById(R.id.recyclerViewMobility);
        recyclerViewInterest = binding.getRoot().findViewById(R.id.recyclerViewInterest);
        recyclerViewProfile = binding.getRoot().findViewById(R.id.recyclerViewProfile);


        txtMail = binding.txtMale;
        txtFemail = binding.txtFemail;
        txtBinary = binding.txtBinary;
        txtMail.setOnClickListener(this);
        txtFemail.setOnClickListener(this);
        txtBinary.setOnClickListener(this);
        initCareList();
        initMobilityList();
        initInterestList();
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
                       binding.city,binding.province,binding.addres1,binding.unitNumber,binding.number,binding.txtName,binding.txtAge) == Constants.SUCCESS){
                    if(getIntent() != null && getIntent().getStringExtra(Constants.TYPE) != null){
                        if(getIntent().getStringExtra(Constants.TYPE).equalsIgnoreCase("Edit")){
                            finish();
                        }
                    }else {
                        UIHelper.openActivity(CreateSeniorProfileActivity.this,GetStartedActivity.class);
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

    private void initInterestList(){
        ArrayList<InterestModel> languageModelArrayList = new ArrayList<>();
        for (int i= 0; i < interestArr.length; i++){
            InterestModel languageModel = new InterestModel();
            languageModel.setName(interestArr[i]);
            languageModel.setIcone(interestIcons[i]);
            languageModelArrayList.add(languageModel);
        }
        setInterestRecyclerView(languageModelArrayList);
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
        colorSchemeAdapter=new ColorSchemeAdapter(this, data);
        recyclerViewProfile.setAdapter(colorSchemeAdapter);
        RecyclerView.LayoutManager mManager =new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerViewProfile.setLayoutManager(mManager);

    }
    private void setInterestRecyclerView(ArrayList<InterestModel> data) {
        interestAdapter=new InterestAdapter(this, data);
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
        String languageArr[] = {"English","Italian","Mandarin Chinese","Spanish","Punjabi"};
        ArrayList<LanguageModel> languageModelArrayList = new ArrayList<>();
        for (int i= 0; i < languageArr.length; i++){
            LanguageModel languageModel = new LanguageModel();
            languageModel.setName(languageArr[i]);
            languageModelArrayList.add(languageModel);
        }
        LanguageSelectionDialoge languageSelectionDialoge = LanguageSelectionDialoge.newInstance(languageModelArrayList);
        languageSelectionDialoge.setSelectedLanguages(new LanguagesAdapater.ISelectedLanguages() {
            @Override
            public void selectedLanguages(ArrayList<LanguageModel> languageModels) {
                String languages="";
                for (LanguageModel languageModel:languageModels){
                    if(languageModel.isSelected())
                        languages = languages+languageModel.getName()+",";
                }
                if (languages != null && languages.length() > 0 && languages.charAt(languages.length() - 1) == ',') {
                    languages = languages.substring(0, languages.length() - 1);
                }
                binding.txtLanguage.setText(languages);

            }
        });
        languageSelectionDialoge.show(getSupportFragmentManager(),"languageSelectionDialoge");

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
}
