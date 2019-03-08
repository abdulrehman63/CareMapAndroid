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
import android.widget.ImageButton;
import android.widget.TextView;

import com.square63.caremap.ApplicationState;
import com.square63.caremap.R;
import com.square63.caremap.constants.Constants;
import com.square63.caremap.listeners.RecyclerItemClickListener;
import com.square63.caremap.models.InterestModel;
import com.square63.caremap.ui.adapters.InterestAdapter;
import com.square63.caremap.ui.adapters.SeniorInterestAdapter;
import com.square63.caremap.utils.PreferenceHelper;
import com.square63.caremap.webapi.Apiinterface.ApiCallBack2;
import com.square63.caremap.webapi.Apiinterface.ApiCallback;
import com.square63.caremap.webapi.requests.GetGiverInterestById;
import com.square63.caremap.webapi.requests.GetGiverLanguageRequest;
import com.square63.caremap.webapi.responses.MainResponse;
import com.square63.caremap.webapi.responses.MainResponse2;
import com.square63.caremap.webapi.webservices.WebServiceFactory;

import java.util.ArrayList;


public class InterestsFragment extends Fragment {


    private RecyclerView recyclerView;
    private String interestArr[] = {"Arts & Crafts", "Church Events", "Cooking", "Computers", "Gardening", "Movies", "Pets", "Playing Cards", "Reading", "Sewing", "Shopping", "Spiritualism", "Sports", "Travelling"};
    private Integer interestIcons[] = {R.drawable.artscrafts, R.drawable.churchactivities, R.drawable.cooking, R.drawable.computertech, R.drawable.gardening, R.drawable.movies, R.drawable.pets, R.drawable.playingcards, R.drawable.reading, R.drawable.sewing, R.drawable.shopping, R.drawable.spiritualism, R.drawable.sports, R.drawable.travelling};
    private String interestIds[] = {"bedb971f-c5e4-4aa1-9017-d8c1114186e5", "ff1e5484-c763-474e-a0a6-f7303025798c", "ad1590e6-264e-4cb5-ad48-9e1e7e484424", "45254526-b8b6-49d4-a396-bf3a2edae66f", "e9efd7a6-6e88-4954-a846-2885c334add6", "43c3627e-9505-4cfe-90dd-9a585b63b210", "943ed09f-775a-4d0d-a709-261edae15e2e", "791784a4-2004-43f2-94ff-e9caaf5e8dc6", "b83b1611-9107-43a6-83a8-06f10e416b32", "87c09be2-7c26-4cb9-814d-c927f0c465d4", "0e840008-311f-4d01-9a99-49a7063f6111", "8aa319a1-b941-425a-a9e2-5ea87620ce52", "2773a487-69c8-4686-a94d-8c4888359ac2", "b76b0867-75ba-4b44-9246-2a6e515f424d"};
    private SeniorInterestAdapter interestAdapter;
    private String userId;

    public InterestsFragment() {
        // Required empty public constructor
    }

    public InterestsFragment(String userId) {
        this.userId = userId;
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
        View view = inflater.inflate(R.layout.fragment_interests, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        getUserInterests();
    }

    private void getUserInterests() {
        WebServiceFactory.getInstance().init(getActivity());
        GetGiverInterestById profileRequest = new GetGiverInterestById();
        if (userId != null)
            profileRequest.getFilterCaregiver().setUserId(userId);
        else
            profileRequest.getFilterCaregiver().setUserId(PreferenceHelper.getInstance().getString(Constants.USER_ID, ""));

        WebServiceFactory.getInstance().apiGetGiverInterestById(profileRequest, new ApiCallBack2() {
            @Override
            public void onSuccess(MainResponse2 mainResponse) {
                if(mainResponse.getResultResponse().getInterestModelArrayList()!=null) {
                     if (mainResponse.getResultResponse().getInterestModelArrayList() != null) {
                         ArrayList<InterestModel> data = new ArrayList<>();
                         ApplicationState.getInstance().setInterestModelArrayList(mainResponse.getResultResponse().getInterestModelArrayList());

                         for (int i = 0; i < mainResponse.getResultResponse().getInterestModelArrayList().size(); i++) {
                            InterestModel dayModel = new InterestModel();

                            dayModel.setName(mainResponse.getResultResponse().getInterestModelArrayList().get(i).getInterest().getName());
                            dayModel.setSelected(true);
                            for (int j = 0; j < interestIcons.length; j++) {
                                if (interestIds[j].equalsIgnoreCase(mainResponse.getResultResponse().getInterestModelArrayList().get(i).getInterest().getId())) {
                                    dayModel.setIcone(interestIcons[j]);
                                    break;

                                }
                            }
                            data.add(dayModel);
                        }
                        setRecyclerView(data);
                    }
                }
            }

        });
    }

    private void setRecyclerView(ArrayList<InterestModel> data) {
        interestAdapter = new SeniorInterestAdapter(getContext(), data);
        recyclerView.setAdapter(interestAdapter);
        RecyclerView.LayoutManager mManager = new GridLayoutManager(getContext(), 3);
        recyclerView.setLayoutManager(mManager);

    }
}
