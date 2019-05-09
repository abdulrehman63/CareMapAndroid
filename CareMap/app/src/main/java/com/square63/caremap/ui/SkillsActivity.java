package com.square63.caremap.ui;

import android.support.constraint.ConstraintLayout;
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
import com.square63.caremap.models.InterestModel;
import com.square63.caremap.models.LanguageModel;
import com.square63.caremap.models.SkillsMainModel;
import com.square63.caremap.models.SkillsModel;
import com.square63.caremap.models.giverModels.UserLanguage;
import com.square63.caremap.ui.adapters.InterestAdapter;
import com.square63.caremap.ui.adapters.SkillsAdapter;
import com.square63.caremap.utils.PreferenceHelper;
import com.square63.caremap.utils.UIHelper;
import com.square63.caremap.webapi.Apiinterface.ApiCallback;
import com.square63.caremap.webapi.requests.GenericGetRequest;
import com.square63.caremap.webapi.requests.InsertGiverSkilsRequest;
import com.square63.caremap.webapi.requests.InsertUserLangRequest;
import com.square63.caremap.webapi.responses.MainResponse;
import com.square63.caremap.webapi.webservices.WebServiceFactory;

import java.util.ArrayList;

public class SkillsActivity extends AppCompatActivity implements SkillsAdapter.ISkills {

    private RecyclerView recyclerView;
    private SkillsAdapter daysAdapter, skillsAdapter, serviceAdapter, credentialsAdapter;
    private RecyclerView recyclerViewServices;
    private ImageButton imgBack;
    private TextView titileToolbar, toolbarTitleRight;
    private RecyclerView recyclerViewSkills;
    private ArrayList<SkillsModel> skillsMainArrayList = new ArrayList<>();
    private ArrayList<SkillsModel> skillsModelArrayList = new ArrayList<>();
    private ArrayList<SkillsModel> skillsServiceArrayList = new ArrayList<>();
    private ArrayList<SkillsModel> skillsDataArrayList = new ArrayList<>();
    private String credentialsArr[] = {"Volunteer", "Companion Keeper", "Personal Support Worker (PSW)", "Registered Nurse Practitioner (RNP)"};
    private String servicesArr[] = {"Bathing and Toileting", "Transportation", "Meal Preparation", "Light HouseKeeping"};
    private String skillsArr[] = {"Old Age", "Alzheimers", "Dementia", "Parkinsons", "Pallative Care"};
    private ConstraintLayout selectAllService, selectAllSkills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        selectAllService = findViewById(R.id.selectAllService);
        selectAllSkills = findViewById(R.id.selectAllSkills);
        recyclerViewServices = (RecyclerView) findViewById(R.id.recyclerViewServices);
        recyclerViewSkills = (RecyclerView) findViewById(R.id.recyclerViewSkills);
        PreferenceHelper.getInstance().init(this);
        initToolBar();
        apiGetSkills();

        selectAllService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                serviceAdapter.setSelectAll();
            }
        });
        selectAllSkills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skillsAdapter.setSelectAll();
            }
        });
    }

    private void setRecyclerView(ArrayList<SkillsModel> data, ArrayList<SkillsModel> dataServices, final ArrayList<SkillsModel> dataSkills) {
        credentialsAdapter = new SkillsAdapter(this, data, new SkillsAdapter.ISkills() {
            @Override
            public void selectedSkills(ArrayList<SkillsModel> data) {
                skillsMainArrayList = data;
            }
        }, true);
        recyclerView.setAdapter(credentialsAdapter);
        serviceAdapter = new SkillsAdapter(this, dataServices, new SkillsAdapter.ISkills() {
            @Override
            public void selectedSkills(ArrayList<SkillsModel> data) {
                skillsServiceArrayList = data;
            }
        });
        recyclerViewServices.setAdapter(serviceAdapter);
        skillsAdapter = new SkillsAdapter(this, dataSkills, new SkillsAdapter.ISkills() {
            @Override
            public void selectedSkills(ArrayList<SkillsModel> data) {
                skillsDataArrayList = data;
            }
        });
        recyclerViewSkills.setAdapter(skillsAdapter);
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

    private void apiGetSkills() {
        WebServiceFactory.getInstance().init(this);
        WebServiceFactory.getInstance().apiGetGiverSkills(new GenericGetRequest(), new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {
                setData(mainResponse.getResultResponse().getSkillsModelArrayList());
            }
        });
    }

    private void updateSkills() {
        boolean isSelected = false;
        for (SkillsModel skillsModel : skillsMainArrayList) {
            if (skillsModel.isSelected()) {
                isSelected = true;
            }
        }
        if (!isSelected) {
            UIHelper.showAlert(Constants.FORM_TITLE, "Please select credential", SkillsActivity.this);
            return;
        }
        isSelected = false;
        for (SkillsModel skillsModel : skillsServiceArrayList) {
            if (skillsModel.isSelected()) {
                isSelected = true;
            }
        }
        if (!isSelected) {
            UIHelper.showAlert(Constants.FORM_TITLE, "Please select service", SkillsActivity.this);
            return;
        }
        isSelected = false;
        for (SkillsModel skillsModel : skillsDataArrayList) {
            if (skillsModel.isSelected()) {
                isSelected = true;
            }
        }
        if (!isSelected) {
            UIHelper.showAlert(Constants.FORM_TITLE, "Please select skill", SkillsActivity.this);
            return;
        }
        if(ApplicationState.getInstance().isFromEdit()){
            skillsModelArrayList.clear();
            skillsModelArrayList.addAll(skillsMainArrayList);
            skillsModelArrayList.addAll(skillsServiceArrayList);
            skillsModelArrayList.addAll(skillsDataArrayList);
            if (skillsModelArrayList.size() > 0) {
                InsertGiverSkilsRequest skilsRequest = new InsertGiverSkilsRequest();
                skilsRequest.setSkillID(skillsModelArrayList.get(0).getId());
                apiDeleteSkills(skilsRequest);
            }
        }

    }

    private void insertSkills() {

        handleSelection();

    }

    private void handleSelection() {
        if(!ApplicationState.getInstance().isFromEdit()) {
            boolean isSelected = false;
            for (SkillsModel skillsModel : skillsMainArrayList) {
                if (skillsModel.isSelected()) {
                    isSelected = true;
                }
            }
            if (!isSelected) {
                UIHelper.showAlert(Constants.FORM_TITLE, "Please select credential", SkillsActivity.this);
                return;
            }
            isSelected = false;
            for (SkillsModel skillsModel : skillsServiceArrayList) {
                if (skillsModel.isSelected()) {
                    isSelected = true;
                }
            }
            if (!isSelected) {
                UIHelper.showAlert(Constants.FORM_TITLE, "Please select service", SkillsActivity.this);
                return;
            }
            isSelected = false;
            for (SkillsModel skillsModel : skillsDataArrayList) {
                if (skillsModel.isSelected()) {
                    isSelected = true;
                }
            }
            if (!isSelected) {
                UIHelper.showAlert(Constants.FORM_TITLE, "Please select skill", SkillsActivity.this);
                return;
            }
        }

        skillsModelArrayList.clear();
        skillsModelArrayList.addAll(skillsMainArrayList);
        skillsModelArrayList.addAll(skillsServiceArrayList);
        skillsModelArrayList.addAll(skillsDataArrayList);
        for (SkillsModel skillsModel : skillsModelArrayList) {
            if (skillsModel.isSelected()) {
                InsertGiverSkilsRequest skilsRequest = new InsertGiverSkilsRequest();
                skilsRequest.setSkillID(skillsModel.getId());
                apiInsertSkills(skilsRequest);
            }
        }
        UIHelper.openActivity(SkillsActivity.this, InterestsActivity.class);

    }

    private void setData(ArrayList<SkillsModel> skillsModelArrayList) {
        if (ApplicationState.getInstance().isFromEdit()) {
            ArrayList<SkillsModel> data = new ArrayList<>();
            ArrayList<SkillsModel> dataService = new ArrayList<>();
            ArrayList<SkillsModel> dataSkills = new ArrayList<>();
            ArrayList<SkillsMainModel> selectedSkills = ApplicationState.getInstance().getSkillsModelArrayList();
            boolean isSelected = false;
            for (int i = 0; i < skillsModelArrayList.size(); i++) {
                isSelected = false;
                for (int j = 0; j < selectedSkills.size(); j++) {
                    if (skillsModelArrayList.get(i).getId().equalsIgnoreCase(selectedSkills.get(j).getSkill().getId())) {
                        isSelected = true;
                    }
                }

                if (skillsModelArrayList.get(i).getCategory() == 0) {
                    if (isSelected)
                        skillsModelArrayList.get(i).setSelected(true);
                    data.add(skillsModelArrayList.get(i));
                } else if (skillsModelArrayList.get(i).getCategory() == 2) {
                    if (isSelected)
                        skillsModelArrayList.get(i).setSelected(true);
                    dataService.add(skillsModelArrayList.get(i));
                } else if (skillsModelArrayList.get(i).getCategory() == 1) {
                    if (isSelected)
                        skillsModelArrayList.get(i).setSelected(true);
                    dataSkills.add(skillsModelArrayList.get(i));
                }
            }

            skillsMainArrayList = data;
            skillsServiceArrayList = dataService;
            skillsDataArrayList = dataSkills;

            setRecyclerView(data, dataService, dataSkills);
        } else {
            ArrayList<SkillsModel> data = new ArrayList<>();
            ArrayList<SkillsModel> dataService = new ArrayList<>();
            ArrayList<SkillsModel> dataSkills = new ArrayList<>();
            for (int i = 0; i < skillsModelArrayList.size(); i++) {
                if (skillsModelArrayList.get(i).getCategory() == 0) {
                    data.add(skillsModelArrayList.get(i));
                } else if (skillsModelArrayList.get(i).getCategory() == 2) {
                    dataService.add(skillsModelArrayList.get(i));
                } else if (skillsModelArrayList.get(i).getCategory() == 1) {
                    dataSkills.add(skillsModelArrayList.get(i));
                }
            }

            setRecyclerView(data, dataService, dataSkills);
        }
    }

    private void initToolBar() {

        imgBack = (ImageButton) findViewById(R.id.imgBackbtn);
        imgBack.setVisibility(View.VISIBLE);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        titileToolbar = (TextView) findViewById(R.id.toolbarTittle);
        toolbarTitleRight = (TextView) findViewById(R.id.toolbarTitleRight);
        titileToolbar.setText("Skills");
        titileToolbar.setAllCaps(false);
        toolbarTitleRight.setText("Next");
        toolbarTitleRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ApplicationState.getInstance().isFromEdit()) {
                    updateSkills();
                } else {
                    insertSkills();
                }


            }
        });
    }

    private void apiInsertSkills(InsertGiverSkilsRequest giverSkilsRequest) {
        WebServiceFactory.getInstance().init(getApplicationContext());
        WebServiceFactory.getInstance().apiInsertUserSkills(giverSkilsRequest, new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {

            }
        });
    }

    private void apiDeleteSkills(InsertGiverSkilsRequest giverSkilsRequest) {
        WebServiceFactory.getInstance().init(getApplicationContext());
        WebServiceFactory.getInstance().apiDeleteUserSkills(giverSkilsRequest, new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {
                insertSkills();
            }
        });
    }

    @Override
    public void selectedSkills(ArrayList<SkillsModel> data) {


    }
}
