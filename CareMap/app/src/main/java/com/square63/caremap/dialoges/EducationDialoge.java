package com.square63.caremap.dialoges;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.square63.caremap.R;
import com.square63.caremap.databinding.FragmentEducationDialogeBinding;


public class EducationDialoge extends DialogFragment {

    FragmentEducationDialogeBinding binding;
    public EducationDialoge() {
        // Required empty public constructor
    }


    public static EducationDialoge newInstance() {
        EducationDialoge fragment = new EducationDialoge();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout. fragment_education_dialoge, null, false);
         return binding.getRoot();
    }


}
