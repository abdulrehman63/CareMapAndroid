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
import com.square63.caremap.models.DayModel;
import com.square63.caremap.models.LanguageModel;
import com.square63.caremap.ui.adapters.DaysAdpater;
import com.square63.caremap.ui.adapters.LanguagesAdapater;
import com.square63.caremap.ui.providerModule.PersonalInfoActivity;
import com.square63.caremap.utils.UIHelper;
import com.square63.caremap.utils.Validations;

import java.util.ArrayList;

public class DaysSelectionActivity extends AppCompatActivity {

    private DaysAdpater daysAdapter;
    private RecyclerView recyclerView;
    private ImageButton imgBack;
    private TextView titileToolbar,toolbarTitleRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days_selection);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        ArrayList<DayModel> data = new ArrayList<>();
        for (int i= 1; i <=  28; i++){
            DayModel dayModel = new DayModel();
            data.add(dayModel);
        }
        setRecyclerView(data);
    }
    private void setRecyclerView(ArrayList<DayModel> data) {
        daysAdapter=new DaysAdpater(this, data);
        recyclerView.setAdapter(daysAdapter);
        RecyclerView.LayoutManager mManager =new GridLayoutManager(this, 7);
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
        titileToolbar.setText("Availability");
        toolbarTitleRight.setText("Next");
        toolbarTitleRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIHelper.openActivity(DaysSelectionActivity.this,SkillsActivity.class);
            }
        });
    }
}
