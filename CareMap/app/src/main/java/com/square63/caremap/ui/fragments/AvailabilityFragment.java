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
import com.square63.caremap.models.DayModel;
import com.square63.caremap.ui.adapters.DaysAdpater;

import java.util.ArrayList;


public class AvailabilityFragment extends Fragment {


    private RecyclerView recyclerView;
    private DaysAdpater daysAdapter;

    public AvailabilityFragment() {
        // Required empty public constructor
    }



    public static AvailabilityFragment newInstance(String param1, String param2) {
        AvailabilityFragment fragment = new AvailabilityFragment();
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
        View view =  inflater.inflate(R.layout.fragment_availability, container, false);
        return  view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        ArrayList<DayModel> data = new ArrayList<>();
        for (int i= 1; i <=  28; i++){
            DayModel dayModel = new DayModel();
            data.add(dayModel);
        }
        setRecyclerView(data);
    }


    private void setRecyclerView(ArrayList<DayModel> data) {
        daysAdapter=new DaysAdpater(getActivity(), data);
        recyclerView.setAdapter(daysAdapter);
        RecyclerView.LayoutManager mManager =new GridLayoutManager(getContext(), 7);
        recyclerView.setLayoutManager(mManager);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
               /* Intent intent = new Intent(getActivity(), AgentDetailActivity.class);
                intent.putExtra(Constants.AGENT_ID,agentList.get(position).getId());

                startActivity(intent);*/
            }
        }));

    }

}
