package com.square63.caremap.dialoges;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.square63.caremap.R;
import com.square63.caremap.constants.Constants;
import com.square63.caremap.databinding.FragmentEducationDialogeBinding;
import com.square63.caremap.models.EducationModel;
import com.square63.caremap.utils.PreferenceHelper;
import com.square63.caremap.webapi.Apiinterface.ApiCallback;
import com.square63.caremap.webapi.responses.MainResponse;
import com.square63.caremap.webapi.webservices.WebServiceFactory;


public class EducationDialoge extends DialogFragment {

    FragmentEducationDialogeBinding binding;
    private ImageButton imgBack;
    private TextView titileToolbar, toolbarTitleRight;

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
        setStyle(android.support.v4.app.DialogFragment.STYLE_NO_TITLE, R.style.AppTheme);

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
        titileToolbar.setText("Education");
        toolbarTitleRight.setText("Add");
        toolbarTitleRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertEducation();
                dismiss();

            }
        });
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout. fragment_education_dialoge, null, false);
       EducationModel educationModel = new EducationModel();
       binding.setEducationModel(educationModel);
        initToolBar(binding.getRoot());
         return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    private void insertEducation(){

        binding.getEducationModel().setCaregiverID(PreferenceHelper.getInstance().getString(Constants.GIVER_ID,""));
        WebServiceFactory.getInstance().apiAddEducation(binding.getEducationModel(), new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {

            }
        });

    }
}
