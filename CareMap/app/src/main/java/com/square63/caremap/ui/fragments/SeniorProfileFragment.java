package com.square63.caremap.ui.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.square63.caremap.R;
import com.square63.caremap.models.InterestModel;
import com.square63.caremap.ui.adapters.InterestAdapter;
import com.square63.caremap.ui.adapters.SeniorInterestAdapter;

import java.util.ArrayList;


public class SeniorProfileFragment extends Fragment {
    private String interestArr[] = {"Arts & Crafts","Church Events","Cooking","Computers","Gardening","Movies"};
    private Integer interestIcons[] = {R.drawable.artscrafts,R.drawable.churchactivities,R.drawable.cooking,R.drawable.computertech,R.drawable.gardening,R.drawable.movies};
    private SeniorInterestAdapter interestAdapter;
    private RecyclerView recyclerViewInterest;

    public SeniorProfileFragment() {
        // Required empty public constructor
    }

    public static SeniorProfileFragment newInstance() {
        SeniorProfileFragment fragment = new SeniorProfileFragment();
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
    private void initInterestList(){
        ArrayList<InterestModel> languageModelArrayList = new ArrayList<>();
        for (int i= 0; i < interestArr.length; i++){
            InterestModel languageModel = new InterestModel();
            languageModel.setName(interestArr[i]);
            languageModel.setIcone(interestIcons[i]);
            languageModelArrayList.add(languageModel);
        }
        setInterestRecyclerView(languageModelArrayList);
    }
    private void setInterestRecyclerView(ArrayList<InterestModel> data) {
        interestAdapter=new SeniorInterestAdapter(getContext(), data);
        recyclerViewInterest.setAdapter(interestAdapter);
        RecyclerView.LayoutManager mManager =new GridLayoutManager(getContext(), 3);
        recyclerViewInterest.setLayoutManager(mManager);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_senior_profile, container, false);
        recyclerViewInterest = view.findViewById(R.id.recyclerView);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initInterestList();
    }
}
