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
import com.square63.caremap.databinding.FragmentEducationDialogeBinding;
import com.square63.caremap.utils.UIHelper;


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
                UIHelper.showAlert(Constants.Success,Constants.education_added,getContext());
                dismiss();

            }
        });
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout. fragment_education_dialoge, null, false);
        initToolBar(binding.getRoot());
         return binding.getRoot();
    }


}
