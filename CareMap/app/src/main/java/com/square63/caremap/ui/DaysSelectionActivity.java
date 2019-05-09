package com.square63.caremap.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.square63.caremap.ApplicationState;
import com.square63.caremap.R;
import com.square63.caremap.constants.Constants;
import com.square63.caremap.listeners.RecyclerItemClickListener;
import com.square63.caremap.models.DayModel;
import com.square63.caremap.models.InterestModel;
import com.square63.caremap.models.LanguageModel;
import com.square63.caremap.models.giverModels.Availability;
import com.square63.caremap.ui.adapters.DaysAdpater;
import com.square63.caremap.ui.adapters.LanguagesAdapater;
import com.square63.caremap.ui.providerModule.PersonalInfoActivity;
import com.square63.caremap.utils.PreferenceHelper;
import com.square63.caremap.utils.UIHelper;
import com.square63.caremap.utils.Validations;
import com.square63.caremap.webapi.Apiinterface.ApiCallback;
import com.square63.caremap.webapi.requests.InsertAvailabilityRequest;
import com.square63.caremap.webapi.requests.InsertUserInterestRequest;
import com.square63.caremap.webapi.responses.MainResponse;
import com.square63.caremap.webapi.webservices.WebServiceFactory;

import java.util.ArrayList;

public class DaysSelectionActivity extends AppCompatActivity implements DaysAdpater.ISkills {

    private DaysAdpater daysAdapter;
    private RecyclerView recyclerView;
    private ImageButton imgBack;
    private TextView titileToolbar,toolbarTitleRight;
    private ArrayList<DayModel> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days_selection);
        PreferenceHelper.getInstance().init(this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        ArrayList<DayModel> data = new ArrayList<>();
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
        if(ApplicationState.getInstance().isFromEdit()){
            ArrayList<Availability> dayModels =ApplicationState.getInstance().getAvailabilityArrayList();
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
    }
    private void updateInterests() {
      /*  ArrayList<Availability> dayModels = ApplicationState.getInstance().getAvailabilityArrayList();
        boolean isUnSelect = false;
        if (dayModels.size() > 0) {
            for (int i= 0; i < dayModels.size(); i++){
                for (int j =0 ; j < data.size();j++){
                    if(data.get(j).getDayTime() == Integer.parseInt(dayModels.get(i).getFromHour()) && data.get(j).getDay() == dayModels.get(i).getDayOfWeek() && !data.get(j).isSelected()){
                        InsertAvailabilityRequest insertUserInterestRequest = new InsertAvailabilityRequest();
                        insertUserInterestRequest.setDayOfWeek(data.get(j).getDayTime());
                        deleteAvailability(insertUserInterestRequest);
                        isUnSelect = true;
                        break;
                    }
                }
            }

            if (!isUnSelect) {
                insertAvailabilities();
            }
        } else {
            insertAvailabilities();
        }*/
      if(data.size() > 0){
          InsertAvailabilityRequest insertUserInterestRequest = new InsertAvailabilityRequest();
          insertUserInterestRequest.setDayOfWeek(data.get(0).getDayTime());
          deleteAvailability(insertUserInterestRequest);
      }else {
          UIHelper.openActivity(DaysSelectionActivity.this,SkillsActivity.class);
      }
    }
    private void setRecyclerView(ArrayList<DayModel> data) {
        daysAdapter=new DaysAdpater(this, data,this);
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
    private void insertAvailability(InsertAvailabilityRequest interestRequest){
        WebServiceFactory.getInstance().init(this);
        WebServiceFactory.getInstance().apiAddAvailability(interestRequest, new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {

            }
        });
    }
    private void deleteAvailability(InsertAvailabilityRequest interestRequest){
        WebServiceFactory.getInstance().init(this);
        WebServiceFactory.getInstance().apiDeleteAvailability(interestRequest, new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {
                insertAvailabilities();
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
        titileToolbar.setText("Your Availability");
        toolbarTitleRight.setText("Next");
        toolbarTitleRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(ApplicationState.getInstance().isFromEdit()){
                   updateInterests();
               }else {
                   insertAvailabilities();
               }

            }
        });
    }
    private void insertAvailabilities(){
        boolean isSelected = false;
        for (DayModel dayModel : data){
            if(dayModel.isSelected()) {
                isSelected = true;
                InsertAvailabilityRequest insertAvailabilityRequest = new InsertAvailabilityRequest();
                insertAvailabilityRequest.setFromHour(dayModel.getDayTime());
                insertAvailabilityRequest.setToHour(dayModel.getDayTime());
                insertAvailabilityRequest.setDayOfWeek(dayModel.getDay());
                insertAvailability(insertAvailabilityRequest);
            }
        }
        if(isSelected){
            UIHelper.openActivity(DaysSelectionActivity.this,SkillsActivity.class);
        }else {
            UIHelper.showAlert(Constants.FORM_TITLE, Constants.MANDATORY_MSG,this);
        }
    }

    @Override
    public void selectedSkills(ArrayList<DayModel> data) {
       this.data =data;
    }
}
