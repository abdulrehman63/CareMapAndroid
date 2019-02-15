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
import com.square63.caremap.listeners.RecyclerItemClickListener;
import com.square63.caremap.models.InterestModel;
import com.square63.caremap.ui.adapters.InterestAdapter;
import com.square63.caremap.ui.adapters.SeniorInterestAdapter;

import java.util.ArrayList;


public class InterestsFragment extends Fragment {


    private RecyclerView recyclerView;
    private String interestArr[] = {"Arts & Crafts","Church Events","Cooking","Computers"};
    private Integer interestIcons[] = {R.drawable.artscrafts,R.drawable.churchactivities,R.drawable.cooking,R.drawable.computertech};
    private SeniorInterestAdapter interestAdapter;

    public InterestsFragment() {
        // Required empty public constructor
    }


    public static InterestsFragment newInstance(String param1, String param2) {
        InterestsFragment fragment = new InterestsFragment();
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
        View view =  inflater.inflate(R.layout.fragment_interests, container, false);
        return  view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        ArrayList<InterestModel> data = new ArrayList<>();
        for (int i= 0; i <  interestArr.length; i++){
            InterestModel dayModel = new InterestModel();
            dayModel.setName(interestArr[i]);
            dayModel.setSelected(true);
            dayModel.setIcone(interestIcons[i]);
            data.add(dayModel);
        }
        setRecyclerView(data);
    }
    
    private void setRecyclerView(ArrayList<InterestModel> data) {
        interestAdapter=new SeniorInterestAdapter(getContext(), data);
        recyclerView.setAdapter(interestAdapter);
        RecyclerView.LayoutManager mManager =new GridLayoutManager(getContext(), 3);
        recyclerView.setLayoutManager(mManager);
       
    }
}
