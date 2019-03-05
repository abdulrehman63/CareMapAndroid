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

import com.square63.caremap.ApplicationState;
import com.square63.caremap.R;
import com.square63.caremap.constants.Constants;
import com.square63.caremap.listeners.RecyclerItemClickListener;
import com.square63.caremap.models.DayModel;
import com.square63.caremap.models.Interest;
import com.square63.caremap.models.giverModels.Availability;
import com.square63.caremap.ui.adapters.DaysAdpater;
import com.square63.caremap.utils.PreferenceHelper;
import com.square63.caremap.webapi.Apiinterface.ApiCallback;
import com.square63.caremap.webapi.requests.GetGiverSkilsById;
import com.square63.caremap.webapi.requests.InsertAvailabilityRequest;
import com.square63.caremap.webapi.responses.MainResponse;
import com.square63.caremap.webapi.webservices.WebServiceFactory;

import java.util.ArrayList;


public class AvailabilityFragment extends Fragment {


    private RecyclerView recyclerView;
    private DaysAdpater daysAdapter;
    private ArrayList<DayModel> data;

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
        data = new ArrayList<>();
        for (int i= 1; i <=  7; i++){
            DayModel dayModel = new DayModel();
            dayModel.setDay(i);
            dayModel.setDayTime(1);
            data.add(dayModel);
        }
        for (int i= 1; i <=  7; i++){
            DayModel dayModel = new DayModel();
            dayModel.setDay(i);
            dayModel.setDayTime(2);
            data.add(dayModel);
        }
        for (int i= 1; i <=  7; i++){
            DayModel dayModel = new DayModel();
            dayModel.setDay(i);
            dayModel.setDayTime(3);
            data.add(dayModel);
        }
        for (int i= 1; i <=  7; i++){
            DayModel dayModel = new DayModel();
            dayModel.setDay(i);
            dayModel.setDayTime(4);
            data.add(dayModel);
        }
        setRecyclerView(data);
        GetGiverSkilsById giverSkilsById = new GetGiverSkilsById();
        PreferenceHelper.getInstance().init(getContext());
        giverSkilsById.getFilterAvailability().setUserId(PreferenceHelper.getInstance().getString(Constants.USER_ID,""));
        getAvailability(giverSkilsById);

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
    private void getAvailability(GetGiverSkilsById insertAvailabilityRequest){
        WebServiceFactory.getInstance().init(getContext());
        WebServiceFactory.getInstance().apiGetGiverAvailById(insertAvailabilityRequest, new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {
                ArrayList<Availability> dayModels = mainResponse.getResultResponse().getAvailabilities();
                ApplicationState.getInstance().setAvailabilityArrayList(dayModels);
                for (int i= 0; i < data.size(); i++){
                   for (int j =0 ; j < dayModels.size();j++){
                       if(data.get(i).getDayTime() == Integer.parseInt(dayModels.get(j).getFromHour()) && data.get(i).getDay() == dayModels.get(j).getDayOfWeek()){
                           data.get(i).setSelected(true);
                           break;
                       }
                   }
                }
                daysAdapter.setData(data);
            }
        });
    }

}
