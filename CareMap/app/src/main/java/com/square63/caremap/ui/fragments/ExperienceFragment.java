package com.square63.caremap.ui.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.square63.caremap.R;


public class ExperienceFragment extends Fragment {


    public ExperienceFragment() {
        // Required empty public constructor
    }


    public static ExperienceFragment newInstance(String param1, String param2) {
        ExperienceFragment fragment = new ExperienceFragment();
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
        return inflater.inflate(R.layout.fragment_experience, container, false);
    }


}
