package com.square63.caremap.ui.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.square63.caremap.ApplicationState;
import com.square63.caremap.R;
import com.square63.caremap.constants.Constants;
import com.square63.caremap.models.LanguageModel;
import com.square63.caremap.models.SkillsMainModel;
import com.square63.caremap.models.giverModels.UserLanguage;
import com.square63.caremap.ui.adapters.TabAvailabilityAdapter;
import com.square63.caremap.utils.CircleImageView;
import com.square63.caremap.utils.PreferenceHelper;
import com.square63.caremap.webapi.Apiinterface.ApiCallback;
import com.square63.caremap.webapi.requests.GetGiverLanguageRequest;
import com.square63.caremap.webapi.requests.GetGiverProfileRequest;
import com.square63.caremap.webapi.requests.GetGiverSkilsById;
import com.square63.caremap.webapi.requests.GiverRequest;
import com.square63.caremap.webapi.responses.MainResponse;
import com.square63.caremap.webapi.webservices.WebServiceFactory;

import java.util.ArrayList;


public class ProfileFragment extends Fragment {


    private ViewPager viewPager;
    private TabLayout tabLayout, tabLayoutSkills;
    private TabAvailabilityAdapter adapter;
    private ViewPager viewPagerSkills;
    private TabAvailabilityAdapter adapterSkills;
    private TextView txtName;
    private TextView txtLanguage, txtExperience, txtPrice, txtDistance;
    private TextView txtCredential;
    private CircleImageView circleImageView;

    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        initTabs(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Glide.with(this).load(Constants.BASE_IMAGE_URL + PreferenceHelper.getInstance().getString(Constants.USER_ID, "") + ".png").into(circleImageView);
        Glide.with(this)
                .load(Constants.BASE_IMAGE_URL + PreferenceHelper.getInstance().getString(Constants.USER_ID, "") + ".png")
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .placeholder(R.drawable.profile_default)
                .into(circleImageView);
        getGiver();
        getUserLanguages();
        apiGetGiverSkills();
    }

    private void initTabs(View view) {
        txtName = (TextView) view.findViewById(R.id.textView14);
        txtCredential = (TextView) view.findViewById(R.id.textView15);
        txtExperience = (TextView) view.findViewById(R.id.txtExperience);
        txtPrice = (TextView) view.findViewById(R.id.txtPrice);
        txtDistance = (TextView) view.findViewById(R.id.txtDistance);
        txtLanguage = (TextView) view.findViewById(R.id.txtLanguage);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        viewPagerSkills = (ViewPager) view.findViewById(R.id.viewPagerSkills);
        circleImageView = view.findViewById(R.id.circleImageView);
        tabLayoutSkills = (TabLayout) view.findViewById(R.id.tabLayoutSkills);
        adapter = new TabAvailabilityAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(new AvailabilityFragment(), "Availability");
        adapter.addFragment(new ExperienceFragment(), "Experience");
        adapterSkills = new TabAvailabilityAdapter(getActivity().getSupportFragmentManager());
        adapterSkills.addFragment(new SkillsFragment(), "Skills");
        adapterSkills.addFragment(new InterestsFragment(), "Interests");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPagerSkills.setAdapter(adapterSkills);
        tabLayoutSkills.setupWithViewPager(viewPagerSkills);
    }

    private void getGiver() {
        GiverRequest profileRequest = new GiverRequest();
        profileRequest.getFilterCaregiver().setId(PreferenceHelper.getInstance().getString(Constants.GIVER_ID, ""));
        WebServiceFactory.getInstance().init(getActivity());
        WebServiceFactory.getInstance().apiGetAllCareGivers(profileRequest, new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {
                if (mainResponse.getResultResponse() != null && mainResponse.getResultResponse().getCaregivers().size() > 0) {
                    ApplicationState.getInstance().setCaregiver(mainResponse.getResultResponse().getCaregivers().get(0));
                    txtName.setText(mainResponse.getResultResponse().getCaregivers().get(0).getUser().getFirstName() + " " + mainResponse.getResultResponse().getCaregivers().get(0).getUser().getLastName());
                }
               /* txtExperience.setText(mainResponse.getResultResponse().getCaregivers().get(0).getYearsOfExperience());
                txtDistance.setText(mainResponse.getResultResponse().getCaregivers().get(0).getAvailabilityDistance());
                txtPrice.setText(mainResponse.getResultResponse().getCaregivers().get(0).getDesiredWage());*/
            }
        });
    }

    private void getUserLanguages() {
        GetGiverLanguageRequest profileRequest = new GetGiverLanguageRequest();
        profileRequest.getFilterCaregiver().setUserId(PreferenceHelper.getInstance().getString(Constants.USER_ID, ""));
        WebServiceFactory.getInstance().init(getActivity());
        WebServiceFactory.getInstance().apiGetGiverLanguageById(profileRequest, new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {
                if (mainResponse.getResultResponse().getUserLanguages() != null) {
                    ApplicationState.getInstance().setLanguageModelArrayList(mainResponse.getResultResponse().getUserLanguages());
                    String languages = "";
                    for (UserLanguage languageModel : mainResponse.getResultResponse().getUserLanguages()) {

                        languages = languages + languageModel.getLanguage().getName() + ", ";
                    }
                    if (languages != null && languages.length() > 0 && languages.charAt(languages.length() - 1) == ',') {
                        languages = languages.substring(0, languages.length() - 1);
                    }
                    txtLanguage.setText(languages);
                }
            }
        });
    }

    private void apiGetGiverSkills() {
        GetGiverSkilsById giverSkilsById = new GetGiverSkilsById();
        giverSkilsById.getFilterCaregiver().setCaregiverId(PreferenceHelper.getInstance().getString(Constants.GIVER_ID, ""));
        WebServiceFactory.getInstance().init(getContext());
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
