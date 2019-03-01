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
import android.widget.ImageButton;
import android.widget.TextView;

import com.square63.caremap.R;
import com.square63.caremap.constants.Constants;
import com.square63.caremap.databinding.FragmentLicenseDialogeBinding;
import com.square63.caremap.models.LicenseModel;
import com.square63.caremap.utils.PreferenceHelper;
import com.square63.caremap.webapi.Apiinterface.ApiCallback;
import com.square63.caremap.webapi.responses.MainResponse;
import com.square63.caremap.webapi.webservices.WebServiceFactory;

import com.square63.caremap.utils.UIHelper;

import retrofit2.http.HEAD;


public class LicenseDialoge extends DialogFragment {
    FragmentLicenseDialogeBinding binding;
    private ImageButton imgBack;
    private TextView titileToolbar,toolbarTitleRight;

    public LicenseDialoge() {
        // Required empty public constructor
    }


    public static LicenseDialoge newInstance() {
        LicenseDialoge fragment = new LicenseDialoge();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(android.support.v4.app.DialogFragment.STYLE_NO_TITLE, R.style.AppTheme);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout. fragment_license_dialoge, null, false);
        initToolBar(binding.getRoot());
        LicenseModel licenseModel= new LicenseModel();
        binding.setLicenseModel(licenseModel);
        return binding.getRoot();

    }

    private void initToolBar(View view){

        imgBack =(ImageButton) view.findViewById(R.id.imgBackbtn);
        imgBack.setVisibility(View.VISIBLE);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        titileToolbar = (TextView)view.findViewById(R.id.toolbarTittle);
        toolbarTitleRight = (TextView)view.findViewById(R.id.toolbarTitleRight);
        titileToolbar.setText("License");
        toolbarTitleRight.setText("Add");
        toolbarTitleRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addLicense();

                dismiss();

            }
        });
    }
    private void addLicense(){
        WebServiceFactory.getInstance().init(getContext());
        binding.getLicenseModel().setCaregiverID(PreferenceHelper.getInstance().getString(Constants.GIVER_ID,""));
        WebServiceFactory.getInstance().apiAddLicense(binding.getLicenseModel(), new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {
                UIHelper.showAlert(Constants.Success,Constants.license_added,getContext());
            }
        });
    }


}
