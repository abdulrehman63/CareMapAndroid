package com.square63.caremap.ui.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.square63.caremap.R;
import com.square63.caremap.listeners.RecyclerItemClickListener;
import com.square63.caremap.models.InterestModel;
import com.square63.caremap.models.SkillsModel;
import com.square63.caremap.ui.adapters.ExperienceAdapter;
import com.square63.caremap.ui.adapters.InterestAdapter;

import java.util.ArrayList;


public class ExperienceFragment extends Fragment {


    private ExperienceAdapter experienceAdapter;
    private RecyclerView recyclerView;

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
        View view = inflater.inflate(R.layout.fragment_experience, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        ArrayList<SkillsModel> skillsModelArrayList = new ArrayList<>();
        for(int i = 0;i < 5 ; i++){
            SkillsModel skillsModel = new SkillsModel();
            skillsModelArrayList.add(skillsModel);
        }
        setRecyclerView(skillsModelArrayList);
    }
    private void setRecyclerView(ArrayList<SkillsModel> data) {
        experienceAdapter=new ExperienceAdapter(getContext(), data);
        recyclerView.setAdapter(experienceAdapter);
        RecyclerView.LayoutManager mManager =new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(mManager);

    }
}
