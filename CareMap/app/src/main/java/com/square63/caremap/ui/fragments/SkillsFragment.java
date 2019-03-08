package com.square63.caremap.ui.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.square63.caremap.ApplicationState;
import com.square63.caremap.R;
import com.square63.caremap.constants.Constants;
import com.square63.caremap.models.SkillsMainModel;
import com.square63.caremap.models.SkillsModel;
import com.square63.caremap.utils.PreferenceHelper;
import com.square63.caremap.webapi.Apiinterface.ApiCallback;
import com.square63.caremap.webapi.requests.FilterCaregiver;
import com.square63.caremap.webapi.requests.GetGiverSkilsById;
import com.square63.caremap.webapi.responses.MainResponse;
import com.square63.caremap.webapi.webservices.WebServiceFactory;

import java.util.ArrayList;

import me.gujun.android.taggroup.TagGroup;


public class SkillsFragment extends Fragment {


    private TagGroup mTagGroup;
    private String giverId;

    public SkillsFragment() {
        // Required empty public constructor
    }

    public SkillsFragment(String giverId) {
        this.giverId = giverId;
        // Required empty public constructor
    }


    public static SkillsFragment newInstance(String param1, String param2) {
        SkillsFragment fragment = new SkillsFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_skills, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTagGroup = (TagGroup) view.findViewById(R.id.tag_group);
        mTagGroup.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });


        apiGetGiverSkills();

    }

    private void apiGetGiverSkills() {
        GetGiverSkilsById giverSkilsById = new GetGiverSkilsById();
        if (giverId != null)
            giverSkilsById.getFilterCaregiver().setCaregiverId(giverId);
        else
            giverSkilsById.getFilterCaregiver().setCaregiverId(PreferenceHelper.getInstance().getString(Constants.GIVER_ID, ""));
        WebServiceFactory.getInstance().init(getContext());
        WebServiceFactory.getInstance().apiGetGiverSkillsById(giverSkilsById, new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {
                if(mainResponse.getResultResponse().getCaregiverSkills() != null) {
                    ArrayList<String> tagsList = new ArrayList<>();
                    ApplicationState.getInstance().setSkillsModelArrayList(mainResponse.getResultResponse().getCaregiverSkills());
                    for (SkillsMainModel skillsModel : mainResponse.getResultResponse().getCaregiverSkills()) {
                        tagsList.add(skillsModel.getSkill().getName());
                    }
                    mTagGroup.setTags(tagsList);
                }

            }
        });
    }
}
