package com.square63.caremap.ui.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.square63.caremap.R;
import com.square63.caremap.ui.adapters.TabAvailabilityAdapter;


public class ProfileFragment extends Fragment {


    private ViewPager viewPager;
    private TabLayout tabLayout,tabLayoutSkills;
    private TabAvailabilityAdapter adapter;
    private ViewPager viewPagerSkills;
    private TabAvailabilityAdapter adapterSkills;

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
        View view =  inflater.inflate(R.layout.fragment_profile, container, false);
        initTabs(view);
        return view;
    }
    private void initTabs(View view){
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        viewPagerSkills = (ViewPager) view.findViewById(R.id.viewPagerSkills);
        tabLayoutSkills = (TabLayout) view.findViewById(R.id.tabLayoutSkills);
        adapter = new TabAvailabilityAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(new AvailabilityFragment(), "Availability");
        adapter.addFragment(new ExperienceFragment(), "Experience");
        adapterSkills = new TabAvailabilityAdapter(getActivity().getSupportFragmentManager());
        adapterSkills.addFragment(new AvailabilityFragment(), "Skills");
        adapterSkills.addFragment(new ExperienceFragment(), "Interests");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPagerSkills.setAdapter(adapterSkills);
        tabLayoutSkills.setupWithViewPager(viewPagerSkills);
    }



}
