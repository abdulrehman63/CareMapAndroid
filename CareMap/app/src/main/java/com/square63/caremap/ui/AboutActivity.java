package com.square63.caremap.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.square63.caremap.ApplicationState;
import com.square63.caremap.R;
import com.square63.caremap.constants.Constants;
import com.square63.caremap.models.giverModels.Caregiver;
import com.square63.caremap.ui.providerModule.CreateProviderProfileActivity;
import com.square63.caremap.ui.providerModule.PersonalInfoActivity;
import com.square63.caremap.utils.PreferenceHelper;
import com.square63.caremap.utils.UIHelper;
import com.square63.caremap.utils.Validations;
import com.square63.caremap.webapi.Apiinterface.ApiCallback;
import com.square63.caremap.webapi.CreateGiverRequest;
import com.square63.caremap.webapi.responses.MainResponse;
import com.square63.caremap.webapi.webservices.WebServiceFactory;

public class AboutActivity extends AppCompatActivity {

    private ImageButton imgBack;
    private TextView titileToolbar, toolbarTitleRight;
    private EditText txtTagLine;
    private TextView txtDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        txtTagLine = findViewById(R.id.textView21);
        txtDesc = findViewById(R.id.txtDesc);
        if (ApplicationState.getInstance().isFromEdit()) {
            Caregiver caregiver = ApplicationState.getInstance().getCaregiver();
            if (caregiver.getProfileTitle() != null)
                txtTagLine.setText(caregiver.getProfileTitle());
            if (caregiver.getDescription() != null)
                txtDesc.setText(caregiver.getDescription());
        }
        initToolBar();
    }

    private void initToolBar() {
        final Validations validations = new Validations(this);
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
        titileToolbar.setText("About Me");
        toolbarTitleRight.setText("Next");
        toolbarTitleRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ApplicationState.getInstance().isFromEdit()) {
                    if (validations.validateTagline(txtTagLine) == Constants.SUCCESS) {
                        UIHelper.openActivity(AboutActivity.this, DaysSelectionActivity.class);
                        insertAbout();
                    }
                    //UIHelper.openActivity(AboutActivity.this, DaysSelectionActivity.class);
                } else {
                    if (validations.validateTagline(txtTagLine) == Constants.SUCCESS) {
                        UIHelper.openActivity(AboutActivity.this, DaysSelectionActivity.class);
                        insertAbout();

                    }
                }


            }
        });

    }

    private void insertAbout() {
        CreateGiverRequest createGiverRequest = new CreateGiverRequest();
        PreferenceHelper.getInstance().init(this);
        Caregiver caregiver = ApplicationState.getInstance().getCaregiver();
        createGiverRequest.setId(PreferenceHelper.getInstance().getString(Constants.GIVER_ID, ""));
        createGiverRequest.setYearsOfExperience(caregiver.getYearsOfExperience());
        createGiverRequest.setDesiredWage(caregiver.getDesiredWage());
        createGiverRequest.setAvailabilityDistance(caregiver.getAvailabilityDistance());
        caregiver.setProfileTitle(txtTagLine.getText().toString());
        caregiver.setDescription(txtDesc.getText().toString());
        ApplicationState.getInstance().setCaregiver(caregiver);
        createGiverRequest.setProfileTitle(txtTagLine.getText().toString());
        createGiverRequest.setDescription(txtDesc.getText().toString());
        WebServiceFactory.getInstance().apiUpdateGiver(createGiverRequest, new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {

            }
        });
    }
}
