package com.square63.caremap.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.square63.caremap.R;
import com.square63.caremap.constants.Constants;
import com.square63.caremap.listeners.RecyclerItemClickListener;
import com.square63.caremap.models.DayModel;
import com.square63.caremap.models.InterestModel;
import com.square63.caremap.ui.adapters.DaysAdpater;
import com.square63.caremap.ui.adapters.InterestAdapter;
import com.square63.caremap.utils.PreferenceHelper;
import com.square63.caremap.utils.UIHelper;
import com.square63.caremap.webapi.Apiinterface.ApiCallback;
import com.square63.caremap.webapi.requests.GenericGetRequest;
import com.square63.caremap.webapi.responses.MainResponse;
import com.square63.caremap.webapi.webservices.WebServiceFactory;

import java.util.ArrayList;

public class InterestsActivity extends AppCompatActivity {

    private InterestAdapter daysAdapter;
    private RecyclerView recyclerView;
    private String interestArr[] = {"Arts & Crafts","Church Events","Cooking","Computers","Gardening","Movies","Pets","Playing Cards","Reading","Sewing","Shopping","Spiritualism","Sports","Travelling"};
    private Integer interestIcons[] = {R.drawable.artscrafts,R.drawable.churchactivities,R.drawable.cooking,R.drawable.computertech,R.drawable.gardening,R.drawable.movies,R.drawable.pets,R.drawable.playingcards,R.drawable.reading,R.drawable.sewing,R.drawable.shopping,R.drawable.spiritualism,R.drawable.sports,R.drawable.travelling};
    private ImageButton imgBack;
    private TextView titileToolbar,toolbarTitleRight;

    private String interestIds[] = {"bedb971f-c5e4-4aa1-9017-d8c1114186e5","ff1e5484-c763-474e-a0a6-f7303025798c","ad1590e6-264e-4cb5-ad48-9e1e7e484424","45254526-b8b6-49d4-a396-bf3a2edae66f","e9efd7a6-6e88-4954-a846-2885c334add6","43c3627e-9505-4cfe-90dd-9a585b63b210","943ed09f-775a-4d0d-a709-261edae15e2e","791784a4-2004-43f2-94ff-e9caaf5e8dc6","b83b1611-9107-43a6-83a8-06f10e416b32","87c09be2-7c26-4cb9-814d-c927f0c465d4","0e840008-311f-4d01-9a99-49a7063f6111","8aa319a1-b941-425a-a9e2-5ea87620ce52","ff1e5484-c763-474e-a0a6-f7303025798c","b76b0867-75ba-4b44-9246-2a6e515f424d"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interests);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        ArrayList<InterestModel> data = new ArrayList<>();
        for (int i= 0; i <  interestArr.length; i++){
            InterestModel dayModel = new InterestModel();
            dayModel.setInterestID(interestIds[i]);
            dayModel.setName(interestArr[i]);
            dayModel.setIcone(interestIcons[i]);
            data.add(dayModel);
        }
        setRecyclerView(data);
    }
    private void setRecyclerView(ArrayList<InterestModel> data) {
        daysAdapter=new InterestAdapter(this, data);
        recyclerView.setAdapter(daysAdapter);
        RecyclerView.LayoutManager mManager =new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(mManager);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
               /* Intent intent = new Intent(getActivity(), AgentDetailActivity.class);
                intent.putExtra(Constants.AGENT_ID,agentList.get(position).getId());

                startActivity(intent);*/
            }
        }));
        initToolBar();
    }
    private void apiUserInterests(){
        WebServiceFactory.getInstance().init(this);
        WebServiceFactory.getInstance().apiGetAllInterests(new GenericGetRequest(), new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {

            }
        });
    }
    private void initToolBar(){

        imgBack =(ImageButton) findViewById(R.id.imgBackbtn);
        imgBack.setVisibility(View.VISIBLE);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        titileToolbar = (TextView)findViewById(R.id.toolbarTittle);
        toolbarTitleRight = (TextView)findViewById(R.id.toolbarTitleRight);
        titileToolbar.setText("Interests");
        toolbarTitleRight.setText("Next");
        toolbarTitleRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UIHelper.openActivity(InterestsActivity.this,ConfirmationActivity.class);
            }
        });
    }
}
