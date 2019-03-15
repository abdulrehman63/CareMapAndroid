package com.square63.caremap.ui;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.square63.caremap.ApplicationState;
import com.square63.caremap.R;
import com.square63.caremap.constants.Constants;
import com.square63.caremap.models.InterestModel;
import com.square63.caremap.models.SkillsMainModel;
import com.square63.caremap.models.seekerModels.SeniorLanguageModel;
import com.square63.caremap.ui.adapters.SeniorInterestAdapter;
import com.square63.caremap.ui.fragments.SeniorProfileFragment;
import com.square63.caremap.utils.CircleImageView;
import com.square63.caremap.utils.PreferenceHelper;
import com.square63.caremap.webapi.Apiinterface.ApiCallBack2;
import com.square63.caremap.webapi.Apiinterface.ApiCallback;
import com.square63.caremap.webapi.requests.GetGiverInterestById;
import com.square63.caremap.webapi.requests.GetGiverLanguageRequest;
import com.square63.caremap.webapi.requests.GetGiverProfileRequest;
import com.square63.caremap.webapi.requests.GetSeekersRequest;
import com.square63.caremap.webapi.responses.MainResponse;
import com.square63.caremap.webapi.responses.MainResponse2;
import com.square63.caremap.webapi.webservices.WebServiceFactory;

import java.util.ArrayList;

public class SeekerProfileActivity extends AppCompatActivity {
    private String interestArr[] = {"Arts & Crafts", "Church Events", "Cooking", "Computers", "Gardening", "Movies"};
    private Integer interestIcons[] = {R.drawable.artscrafts,R.drawable.churchactivities,R.drawable.cooking,R.drawable.computertech,R.drawable.gardening,R.drawable.movies,R.drawable.pets,R.drawable.playingcards,R.drawable.reading,R.drawable.sewing,R.drawable.shopping,R.drawable.spiritualism,R.drawable.sports,R.drawable.travelling};
    private String interestIds[] = {"bedb971f-c5e4-4aa1-9017-d8c1114186e5","ff1e5484-c763-474e-a0a6-f7303025798c","ad1590e6-264e-4cb5-ad48-9e1e7e484424","45254526-b8b6-49d4-a396-bf3a2edae66f","e9efd7a6-6e88-4954-a846-2885c334add6","43c3627e-9505-4cfe-90dd-9a585b63b210","943ed09f-775a-4d0d-a709-261edae15e2e","791784a4-2004-43f2-94ff-e9caaf5e8dc6","b83b1611-9107-43a6-83a8-06f10e416b32","87c09be2-7c26-4cb9-814d-c927f0c465d4","0e840008-311f-4d01-9a99-49a7063f6111","8aa319a1-b941-425a-a9e2-5ea87620ce52","2773a487-69c8-4686-a94d-8c4888359ac2","b76b0867-75ba-4b44-9246-2a6e515f424d"};
    private String mobilityArr[] = {"Independent","Mobile + Cane","Mobility + Walker","Low Mobility","Wheelchair","Non Mobile"};
    private String mobilityIdArr[] = {"5D1214C1-12BA-47E8-BB4F-A78494380C94","CFE24824-4702-4487-99B6-254777BCE18C","0F599DB0-061F-450A-9329-CC8607C40BB1","C566CD2C-51DC-443D-B354-0C5BFC7D7759","0A43A4D7-CBBC-47D8-9504-2D4E2734E973","D4E904E1-89D1-4D87-835C-D9E4EF65E528"};
    private Integer mobilityIconsArr[] = {R.drawable.independent_2x, R.drawable.cane_2x, R.drawable.walker_2x, R.drawable.lowmobility_2x, R.drawable.wheelchair_2x, R.drawable.nonmobile_2x};

    private SeniorInterestAdapter interestAdapter;
    private RecyclerView recyclerViewInterest;
    private TextView txtAge;
    private ImageView imgGender;
    private TextView txtLanguage;
    private CircleImageView circleImageView;
    private ImageButton imgBack;
    private String seekerId,seniorId;
    private TextView titileToolbar,toolbarTitleRight;
    private TextView txtReason;
    private TextView txtMobility;
    private ImageView imgAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seeker_profile);
        recyclerViewInterest = findViewById(R.id.recyclerView);
        txtAge = findViewById(R.id.textView11);
        txtLanguage = findViewById(R.id.txtLanguage);
        circleImageView = findViewById(R.id.circleImageView);
        imgGender = findViewById(R.id.imageView4);
        txtReason = findViewById(R.id.txtReason);
        imgAvatar = findViewById(R.id.imgAvatar);
        txtMobility = findViewById(R.id.txtMobility);
        if(getIntent() != null){
            seekerId = getIntent().getStringExtra(Constants.SEEKER_ID);
            seniorId = getIntent().getStringExtra(Constants.SENIOR_ID);
        }
        initToolBar();
        getUserInterests();
        getSenior();
        getUserSkills();
        //getSeeker();
        getUserLanguages();
    }
    private void initToolBar(){

        imgBack =(ImageButton) findViewById(R.id.imgBackbtn);
        titileToolbar = (TextView)findViewById(R.id.toolbarTittle);
        toolbarTitleRight = (TextView)findViewById(R.id.toolbarTitleRight);
        //toolbarTitleRight.setText("Next");
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    private void setInterestRecyclerView(ArrayList<InterestModel> data) {
        interestAdapter = new SeniorInterestAdapter(this, data);
        recyclerViewInterest.setAdapter(interestAdapter);
        RecyclerView.LayoutManager mManager = new GridLayoutManager(this, 3);
        recyclerViewInterest.setLayoutManager(mManager);

    }

    private void getSenior() {
        GetSeekersRequest profileRequest = new GetSeekersRequest();
        profileRequest.getFilterSenior().setSeniorId(seniorId);
        WebServiceFactory.getInstance().init(this);
        WebServiceFactory.getInstance().apiSeniorById(profileRequest, new ApiCallBack2() {
            @Override
            public void onSuccess(MainResponse2 mainResponse) {
               // titileToolbar.setText(mainResponse.getResultResponse().getName());
                //if(mainResponse.getResultResponse().getSeniors().size() > 0) {
                txtAge.setText(mainResponse.getResultResponse().getAge());
                ApplicationState.getInstance().setGiverResultResponse(mainResponse.getResultResponse());
                if(mainResponse.getResultResponse().getSex() != null ) {
                    if (mainResponse.getResultResponse().getSex().equalsIgnoreCase(Constants.S_MALE)) {
                        imgGender.setImageResource(R.drawable.maledark_2x);
                    } else if (mainResponse.getResultResponse().getSex().equalsIgnoreCase(Constants.FEMALE)) {
                        imgGender.setImageResource(R.drawable.femaledark_2x);
                    }
                }
                if(mainResponse.getResultResponse().getColourScheme() != null ) {
                    circleImageView.setBorderColor(mainResponse.getResultResponse().getColourScheme());
                }
                if(mainResponse.getResultResponse().getMobilityID() != null) {
                    for (int i = 0; i < mobilityIdArr.length; i++) {
                        if (mobilityIdArr[i].equalsIgnoreCase(mainResponse.getResultResponse().getMobilityID())) {
                            txtMobility.setText(mobilityArr[i]);
                            imgAvatar.setImageResource(mobilityIconsArr[i]);
                            break;
                        }
                    }
                }
                // }

            }
        });
    }
    private void getSeeker() {
        GetSeekersRequest profileRequest = new GetSeekersRequest();
        profileRequest.getFilterSenior().setId(seekerId);
        WebServiceFactory.getInstance().init(this);
        WebServiceFactory.getInstance().apiGetSeekerById(profileRequest, new ApiCallBack2() {
            @Override
            public void onSuccess(MainResponse2 mainResponse) {
                //if(mainResponse.getResultResponse().getSeniors().size() > 0) {
                ApplicationState.getInstance().setCareSeeker(mainResponse.getResultResponse().getCareSeekerArrayList().get(0));

                // }

            }
        });
    }


  
    private void getUserLanguages() {
        GetGiverLanguageRequest profileRequest = new GetGiverLanguageRequest();
        profileRequest.getFilterSeniorLanguage().setSeniorId(seniorId);
        WebServiceFactory.getInstance().init(this);
        WebServiceFactory.getInstance().apiGetSeniorLanguageById(profileRequest, new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {
                ApplicationState.getInstance().setSeniorLanguageModelArrayList(mainResponse.getResultResponse().getSeniorLanguages());
                String languages = "";
                for (SeniorLanguageModel languageModel:mainResponse.getResultResponse().getSeniorLanguages()){

                    languages = languages+languageModel.getLanguageModel().getName()+", ";
                }
                if (languages != null && languages.length() > 0 && languages.charAt(languages.length() - 1) == ',') {
                    languages = languages.substring(0, languages.length() - 1);
                }
                txtLanguage.setText(languages);

            }
        });
    }
    private void getUserInterests() {
        WebServiceFactory.getInstance().init(this);
        GetSeekersRequest profileRequest = new GetSeekersRequest();
        profileRequest.getFilterSeniorInterest().setSeniorId(seniorId);

        WebServiceFactory.getInstance().apiGetSeniorInterestById(profileRequest, new ApiCallBack2() {
            @Override
            public void onSuccess(MainResponse2 mainResponse) {
                ArrayList<InterestModel> data = new ArrayList<>();
                ApplicationState.getInstance().setInterestModelArrayList(mainResponse.getResultResponse().getSeniorInterests());
                for (int i = 0; i < mainResponse.getResultResponse().getSeniorInterests().size(); i++) {
                    if (mainResponse.getResultResponse().getSeniorInterests().get(i).getInterest() != null) {
                        InterestModel dayModel = new InterestModel();

                        dayModel.setName(mainResponse.getResultResponse().getSeniorInterests().get(i).getInterest().getName());
                        dayModel.setSelected(true);
                        for (int j = 0; j < interestIcons.length; j++) {
                            if (interestIds[j].equalsIgnoreCase(mainResponse.getResultResponse().getSeniorInterests().get(i).getInterest().getId())) {
                                dayModel.setIcone(interestIcons[j]);
                                break;

                            }
                        }
                        data.add(dayModel);
                    }
                }

                setInterestRecyclerView(data);
            }
        });
    }
    private void getUserSkills(){
        WebServiceFactory.getInstance().init(this);
        GetGiverProfileRequest profileRequest = new GetGiverProfileRequest();
        profileRequest.getFilterSeniorSkills().setSeniorId(seniorId);

        WebServiceFactory.getInstance().apiGetSeniorSkills(profileRequest, new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {

             //   ApplicationState.getInstance().setSeniorSkillsArrayList(mainResponse.getResultResponse().getSeniorSkills());
                String languages ="";
                for (SkillsMainModel languageModel:mainResponse.getResultResponse().getSeniorSkills()){
                    if(languageModel.getSkill() != null)
                        languages = languages+languageModel.getSkill().getName()+"/ ";
                }
                if (languages != null && languages.length() > 0 && languages.charAt(languages.length() - 1) == '/') {
                    languages = languages.substring(0, languages.length() - 1);
                }
                txtReason.setText(languages);

            }

        });
    }
   
}
