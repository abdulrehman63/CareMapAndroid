package com.square63.caremap.dialoges;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.square63.caremap.R;
import com.square63.caremap.databinding.FragmentLicenseDialogeBinding;


public class LicenseDialoge extends Fragment {
    FragmentLicenseDialogeBinding binding;
    public LicenseDialoge() {
        // Required empty public constructor
    }


    public static LicenseDialoge newInstance(String param1, String param2) {
        LicenseDialoge fragment = new LicenseDialoge();
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
        binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout. fragment_license_dialoge, null, false);
        return binding.getRoot();

    }


}
