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

import com.square63.caremap.ApplicationState;
import com.square63.caremap.R;
import com.square63.caremap.constants.Constants;
import com.square63.caremap.models.LanguageModel;
import com.square63.caremap.models.giverModels.UserLanguage;
import com.square63.caremap.ui.adapters.TabAvailabilityAdapter;
import com.square63.caremap.utils.PreferenceHelper;
import com.square63.caremap.webapi.Apiinterface.ApiCallback;
import com.square63.caremap.webapi.requests.GetGiverLanguageRequest;
import com.square63.caremap.webapi.requests.GetGiverProfileRequest;
import com.square63.caremap.webapi.requests.GiverRequest;
import com.square63.caremap.webapi.responses.MainResponse;
import com.square63.caremap.webapi.webservices.WebServiceFactory;


public class ProfileFragment extends Fragment {


    private ViewPager viewPager;
    private TabLayout tabLayout, tabLayoutSkills;
    private TabAvailabilityAdapter adapter;
    private ViewPager viewPagerSkills;
    private TabAvailabilityAdapter adapterSkills;
    private TextView txtName;
    private TextView txtLanguage;

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
        getGiver();
        getUserLanguages();
    }

    private void initTabs(View view) {
        txtName = (TextView) view.findViewById(R.id.textView14);
        txtLanguage = (TextView) view.findViewById(R.id.txtLanguage);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        viewPagerSkills = (ViewPager) view.findViewById(R.id.viewPagerSkills);
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
                ApplicationState.getInstance().setCaregiver(mainResponse.getResultResponse().getCaregivers().get(0));
                txtName.setText(mainResponse.getResultResponse().getCaregivers().get(0).getUser().getFirstName() + " " + mainResponse.getResultResponse().getCaregivers().get(0).getUser().getLastName());
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
                    ApplicationState.getInstance().setLanguageModelArrayList(mainResponse.getResultResponse().getUserLanguages());
                   String languages = "";
                        for (UserLanguage languageModel:mainResponse.getResultResponse().getUserLanguages()){

                                languages = languages+languageModel.getLanguage().getName()+", ";
                        }
                        if (languages != null && languages.length() > 0 && languages.charAt(languages.length() - 1) == ',') {
                            languages = languages.substring(0, languages.length() - 1);
                        }
                        txtLanguage.setText(languages);

            }
        });
    }


}
