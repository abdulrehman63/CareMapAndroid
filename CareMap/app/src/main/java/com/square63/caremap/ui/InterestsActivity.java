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

import java.util.ArrayList;

public class InterestsActivity extends AppCompatActivity {

    private InterestAdapter daysAdapter;
    private RecyclerView recyclerView;
    private String interestArr[] = {"Arts & Crafts","Church Events","Cooking","Computers","Gardening","Movies","Pets","Playing Cards","Reading","Sewing","Shopping","Spiritualism","Sports","Travelling"};
    private ImageButton imgBack;
    private TextView titileToolbar,toolbarTitleRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interests);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        ArrayList<InterestModel> data = new ArrayList<>();
        for (int i= 0; i <  interestArr.length; i++){
            InterestModel dayModel = new InterestModel();
            dayModel.setName(interestArr[i]);
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
