package com.square63.caremap.ui.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.square63.caremap.R;
import com.square63.caremap.constants.Constants;
import com.square63.caremap.listeners.RecyclerItemClickListener;
import com.square63.caremap.models.SkillsModel;
import com.square63.caremap.models.chatModule.Thread;
import com.square63.caremap.ui.ChatActivity;
import com.square63.caremap.ui.adapters.ExperienceAdapter;
import com.square63.caremap.ui.adapters.ThreadAdapter;
import com.square63.caremap.utils.PreferenceHelper;
import com.square63.caremap.utils.UIHelper;
import com.square63.caremap.webapi.Apiinterface.ApiCallBack2;
import com.square63.caremap.webapi.Apiinterface.ApiCallback;
import com.square63.caremap.webapi.requests.GetUserThread;
import com.square63.caremap.webapi.responses.MainResponse;
import com.square63.caremap.webapi.responses.MainResponse2;
import com.square63.caremap.webapi.webservices.WebServiceFactory;

import java.util.ArrayList;


public class MessagesFragment extends Fragment {

    private ConstraintLayout layoutMain;
    private RecyclerView recyclerView;
    private ThreadAdapter threadAdapter;
    private String type = "";

    public MessagesFragment() {
        // Required empty public constructor
    }


    public static MessagesFragment newInstance() {
        MessagesFragment fragment = new MessagesFragment();
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
        View view = inflater.inflate(R.layout.fragment_messages, container, false);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        type = PreferenceHelper.getInstance().getString(Constants.TYPE,"");
        layoutMain = (ConstraintLayout) view.findViewById(R.id.layoutMain);

        layoutMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        getThreads();
    }

    private void setRecyclerView(ArrayList<Thread> data) {
        threadAdapter=new ThreadAdapter(getContext(), data);
        recyclerView.setAdapter(threadAdapter);
        RecyclerView.LayoutManager mManager =new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(mManager);


    }
    private void getThreads(){
        WebServiceFactory.getInstance().init(getContext());
        GetUserThread userThread = new GetUserThread();
        userThread.setOption("10");
        if(type.equalsIgnoreCase(Constants.PROVIDER)) {
            userThread.setUserId(PreferenceHelper.getInstance().getString(Constants.USER_ID,""));
        }else {
            userThread.setUserId(PreferenceHelper.getInstance().getString(Constants.SEEKER_ID,""));
        }

        WebServiceFactory.getInstance().apiGetThreads(userThread,new ApiCallBack2() {
            @Override
            public void onSuccess(MainResponse2 mainResponse) {
                if(mainResponse.getResultResponse().getThreadArrayList().size() >0){
                    setRecyclerView(mainResponse.getResultResponse().getThreadArrayList());
                    layoutMain.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                }else {
                    layoutMain.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.GONE);
                }
            }
        });
    }


}
