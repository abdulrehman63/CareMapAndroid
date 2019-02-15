package com.square63.caremap.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.square63.caremap.R;
import com.square63.caremap.listeners.RecyclerItemClickListener;
import com.square63.caremap.models.InterestModel;
import com.square63.caremap.models.SkillsModel;
import com.square63.caremap.ui.adapters.InterestAdapter;
import com.square63.caremap.ui.adapters.SkillsAdapter;
import com.square63.caremap.utils.UIHelper;

import java.util.ArrayList;

public class SkillsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SkillsAdapter daysAdapter;
    private RecyclerView recyclerViewServices;
    private ImageButton imgBack;
    private TextView titileToolbar,toolbarTitleRight;
    private RecyclerView recyclerViewSkills;
    private String credentialsArr[] = {"Volunteer", "Companion Keeper","Personal Support Worker (PSW)","Registered Nurse Practitioner (RNP)"};
    private String servicesArr[] = {"Bathing and Toileting","Transportation","Meal Preparation","Light HouseKeeping" };
    private String skillsArr[] ={"Old Age","Alzheimers","Dementia","Parkinsons","Pallative Care"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerViewServices = (RecyclerView) findViewById(R.id.recyclerViewServices);
        recyclerViewSkills = (RecyclerView) findViewById(R.id.recyclerViewSkills);
        initToolBar();
        ArrayList<SkillsModel> data = new ArrayList<>();
        for (int i= 0; i <  credentialsArr.length; i++){
            SkillsModel dayModel = new SkillsModel();
            dayModel.setName(credentialsArr[i]);
            data.add(dayModel);
        }
        ArrayList<SkillsModel> dataService = new ArrayList<>();
        for (int i= 0; i <  servicesArr.length; i++){
            SkillsModel dayModel = new SkillsModel();
            dayModel.setName(servicesArr[i]);
            dataService.add(dayModel);
        }
        ArrayList<SkillsModel> dataSkills = new ArrayList<>();
        for (int i= 0; i <  skillsArr.length; i++){
            SkillsModel dayModel = new SkillsModel();
            dayModel.setName(skillsArr[i]);
            dataSkills.add(dayModel);
        }
        setRecyclerView(data,dataService,dataSkills);
    }
    private void setRecyclerView(ArrayList<SkillsModel> data, ArrayList<SkillsModel> dataServices,ArrayList<SkillsModel> dataSkills) {
        daysAdapter=new SkillsAdapter(this,data);
        recyclerView.setAdapter(daysAdapter);
        daysAdapter=new SkillsAdapter(this,dataServices);
        recyclerViewServices.setAdapter(daysAdapter);
        daysAdapter=new SkillsAdapter(this,dataSkills);
        recyclerViewSkills.setAdapter(daysAdapter);
         recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));
        recyclerViewServices.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));
        recyclerViewSkills.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));
        //recyclerView.setLayoutManager(mManager);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
               /* Intent intent = new Intent(getActivity(), AgentDetailActivity.class);
                intent.putExtra(Constants.AGENT_ID,agentList.get(position).getId());

                startActivity(intent);*/
            }
        }));


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
        titileToolbar.setText("Skills");
        titileToolbar.setAllCaps(false);
        toolbarTitleRight.setText("Next");
        toolbarTitleRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIHelper.openActivity(SkillsActivity.this,InterestsActivity.class);
            }
        });
    }
}
