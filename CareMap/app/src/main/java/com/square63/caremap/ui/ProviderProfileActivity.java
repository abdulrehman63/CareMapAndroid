package com.square63.caremap.ui;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.square63.caremap.ApplicationState;
import com.square63.caremap.R;
import com.square63.caremap.constants.Constants;
import com.square63.caremap.models.SkillsMainModel;
import com.square63.caremap.models.giverModels.Caregiver;
import com.square63.caremap.models.giverModels.UserLanguage;
import com.square63.caremap.ui.adapters.TabAvailabilityAdapter;
import com.square63.caremap.ui.fragments.AvailabilityFragment;
import com.square63.caremap.ui.fragments.ExperienceFragment;
import com.square63.caremap.ui.fragments.InterestsFragment;
import com.square63.caremap.ui.fragments.ProfileFragment;
import com.square63.caremap.ui.fragments.SkillsFragment;
import com.square63.caremap.utils.CircleImageView;
import com.square63.caremap.utils.PreferenceHelper;
import com.square63.caremap.utils.UIHelper;
import com.square63.caremap.webapi.Apiinterface.ApiCallback;
import com.square63.caremap.webapi.requests.GetGiverLanguageRequest;
import com.square63.caremap.webapi.requests.GetGiverSkilsById;
import com.square63.caremap.webapi.requests.GiverRequest;
import com.square63.caremap.webapi.responses.MainResponse;
import com.square63.caremap.webapi.webservices.WebServiceFactory;

import java.util.ArrayList;

public class ProviderProfileActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout, tabLayoutSkills;
    private TabAvailabilityAdapter adapter;
    private ViewPager viewPagerSkills;
    private TabAvailabilityAdapter adapterSkills;
    private TextView txtName;
    private TextView txtLanguage;
    private ImageButton imgBack;
    private TextView titileToolbar,toolbarTitleRight,txtExperience,txtPrice,txtDistance,txtTitle,txtDesc;
    private String userId,giverId;
    private NestedScrollView scrollView;
    private CircleImageView circleImageView;
    private TextView txtCredential;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_profile);
        if(getIntent() != null){
            userId = getIntent().getStringExtra(Constants.USER_ID);
            giverId = getIntent().getStringExtra(Constants.GIVER_ID);
            circleImageView = findViewById(R.id.circleImageView);
            Glide.with(this)
                    .load(Constants.BASE_IMAGE_URL + userId + ".png")
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
                    .placeholder(R.drawable.profile_default)
                    .into(circleImageView);
        }
        initTabs();
        initToolBar();
        getGiver();
        getUserLanguages();
        apiGetGiverSkills();
    }
    private void initToolBar(){

        imgBack =(ImageButton) findViewById(R.id.imgBackbtn);
        scrollView =(NestedScrollView) findViewById(R.id.scrollView);
        titileToolbar = (TextView)findViewById(R.id.toolbarTittle);
        toolbarTitleRight = (TextView)findViewById(R.id.toolbarTitleRight);
        scrollView.scrollTo(0,0);
        //scrollView.fullScroll(View.FOCUS_UP);
        //toolbarTitleRight.setText("Next");
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
    }

    private void initTabs() {
        txtName = (TextView) findViewById(R.id.textView14);
        txtExperience = (TextView) findViewById(R.id.txtExperience);
        txtPrice = (TextView) findViewById(R.id.txtPrice);
        txtDistance = (TextView) findViewById(R.id.txtDistance);
        txtLanguage = (TextView) findViewById(R.id.txtLanguage);
        txtCredential = (TextView) findViewById(R.id.textView15);
        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtDesc = (TextView) findViewById(R.id.txtDesc);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPagerSkills = (ViewPager) findViewById(R.id.viewPagerSkills);
        tabLayoutSkills = (TabLayout) findViewById(R.id.tabLayoutSkills);
        adapter = new TabAvailabilityAdapter(this.getSupportFragmentManager());
        adapter.addFragment(new AvailabilityFragment(userId), "Availability");
        adapter.addFragment(new ExperienceFragment(giverId), "Experience");
        adapterSkills = new TabAvailabilityAdapter(this.getSupportFragmentManager());
        adapterSkills.addFragment(new SkillsFragment(giverId), "Skills");
        adapterSkills.addFragment(new InterestsFragment(), "Interests");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPagerSkills.setAdapter(adapterSkills);
        tabLayoutSkills.setupWithViewPager(viewPagerSkills);
    }

    private void getGiver() {
        GiverRequest profileRequest = new GiverRequest();
        profileRequest.getFilterCaregiver().setId(giverId);
        WebServiceFactory.getInstance().init(this);
        WebServiceFactory.getInstance().apiGetAllCareGivers(profileRequest, new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {
                ApplicationState.getInstance().setCaregiver(mainResponse.getResultResponse().getCaregivers().get(0));

               // titileToolbar.setText(mainResponse.getResultResponse().getCaregivers().get(0).getUser().getFirstName() + " " + mainResponse.getResultResponse().getCaregivers().get(0).getUser().getLastName());
                txtName.setText(mainResponse.getResultResponse().getCaregivers().get(0).getUser().getFirstName() + " " + mainResponse.getResultResponse().getCaregivers().get(0).getUser().getLastName());
                Caregiver caregiver = mainResponse.getResultResponse().getCaregivers().get(0);
                if (caregiver.getYearsOfExperience() != null)
                    txtExperience.setText(mainResponse.getResultResponse().getCaregivers().get(0).getYearsOfExperience());
                if (caregiver.getAvailabilityDistance() != null)
                    txtDistance.setText(mainResponse.getResultResponse().getCaregivers().get(0).getAvailabilityDistance());
                if (caregiver.getDesiredWage() != null)
                    txtPrice.setText("$"+ mainResponse.getResultResponse().getCaregivers().get(0).getDesiredWage() );

                if (caregiver.getProfileTitle() != null)
                    txtTitle.setText(caregiver.getProfileTitle());
                if (caregiver.getDescription() != null)
                    txtDesc.setText(caregiver.getDescription());
            }
        });
    }

    private void getUserLanguages() {
        GetGiverLanguageRequest profileRequest = new GetGiverLanguageRequest();
        profileRequest.getFilterCaregiver().setUserId(userId);
        WebServiceFactory.getInstance().init(this);
        WebServiceFactory.getInstance().apiGetGiverLanguageById(profileRequest, new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {
                ApplicationState.getInstance().setLanguageModelArrayList(mainResponse.getResultResponse().getUserLanguages());
                String languages = "";
                for (UserLanguage languageModel:mainResponse.getResultResponse().getUserLanguages()){

                    languages = languages+languageModel.getLanguage().getName()+",";
                }
                if (languages != null && languages.length() > 0 && languages.charAt(languages.length() - 1) == ',') {
                    languages = languages.substring(0, languages.length() - 1);
                }
                txtLanguage.setText(languages);

            }
        });
    }
    private void apiGetGiverSkills() {
        GetGiverSkilsById giverSkilsById = new GetGiverSkilsById();
        giverSkilsById.getFilterCaregiver().setCaregiverId(giverId);
        WebServiceFactory.getInstance().init(this);
        WebServiceFactory.getInstance().apiGetGiverSkillsById(giverSkilsById, new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {
                if (mainResponse.getResultResponse().getCaregiverSkills() != null) {
                    boolean isExist = false;
                    ArrayList<String> tagsList = new ArrayList<>();
                    ApplicationState.getInstance().setSkillsModelArrayList(mainResponse.getResultResponse().getCaregiverSkills());
                    for (SkillsMainModel skillsModel : mainResponse.getResultResponse().getCaregiverSkills()) {
                        if (skillsModel.getSkill().getCategory() == 0) {
                            txtCredential.setText(skillsModel.getSkill().getName());
                            isExist = true;
                        }
                    }
                    if (!isExist) {
                        txtCredential.setText("caregiver");
                    }

                }

            }
        });
    }



}
