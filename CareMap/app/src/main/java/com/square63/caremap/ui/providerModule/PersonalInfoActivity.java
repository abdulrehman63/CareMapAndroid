package com.square63.caremap.ui.providerModule;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.square63.caremap.ApplicationState;
import com.square63.caremap.R;
import com.square63.caremap.constants.Constants;
import com.square63.caremap.databinding.ActivityPersonalInfoBinding;
import com.square63.caremap.dialoges.EducationDialoge;
import com.square63.caremap.dialoges.LanguageSelectionDialoge;
import com.square63.caremap.dialoges.LicenseDialoge;
import com.square63.caremap.models.LanguageModel;
import com.square63.caremap.models.ProfileModel;
import com.square63.caremap.models.SkillsModel;
import com.square63.caremap.models.giverModels.Caregiver;
import com.square63.caremap.models.giverModels.User;
import com.square63.caremap.models.giverModels.UserLanguage;
import com.square63.caremap.ui.AboutActivity;
import com.square63.caremap.ui.DaysSelectionActivity;
import com.square63.caremap.ui.adapters.LanguagesAdapater;
import com.square63.caremap.utils.PreferenceHelper;
import com.square63.caremap.utils.UIHelper;
import com.square63.caremap.utils.Validations;
import com.square63.caremap.webapi.Apiinterface.ApiCallback;
import com.square63.caremap.webapi.requests.GenericGetRequest;
import com.square63.caremap.webapi.requests.InsertGiverExperienceRequest;
import com.square63.caremap.webapi.requests.InsertUserLangRequest;
import com.square63.caremap.webapi.responses.MainResponse;
import com.square63.caremap.webapi.webservices.WebServiceFactory;

import java.util.ArrayList;

public class PersonalInfoActivity extends AppCompatActivity {

    private ImageButton imgBack;
    private TextView titileToolbar, toolbarTitleRight;
    ActivityPersonalInfoBinding binding;
    private ArrayList<LanguageModel> langArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_personal_info);
        PreferenceHelper.getInstance().init(this);
        init();
    }

    private void init() {
        setData();
        initToolBar();
        initSeekBar();
        getAllLang();
    }

    private void setData() {

        if (ApplicationState.getInstance().isFromEdit()) {
            ArrayList<UserLanguage> userLanguages = ApplicationState.getInstance().getLanguageModelArrayList();
            if (userLanguages != null) {
                String languages = "";
                for (UserLanguage languageModel : userLanguages) {
                    languages = languages + languageModel.getLanguage().getName() + ", ";
                }
                if (languages != null && languages.length() > 0 && languages.charAt(languages.length() - 1) == ',') {
                    languages = languages.substring(0, languages.length() - 1);
                }
                binding.txtLanguage.setText(languages);
            }
        }

    }

    private void updateLanguages(ArrayList<LanguageModel> languageModelArrayList) {
        ArrayList<UserLanguage> userLanguages = ApplicationState.getInstance().getLanguageModelArrayList();
        if(userLanguages.size() > 0) {
            for (UserLanguage language : userLanguages) {
                for (LanguageModel language1 : langArrayList) {
                    if (language.getLanguageID().equalsIgnoreCase(language1.getId()) && !language1.isSelected()) {
                        InsertUserLangRequest langRequest = new InsertUserLangRequest();
                        langRequest.setLanguageID(language.getLanguageID());
                        apiDeleteLang(langRequest, languageModelArrayList);
                        break;
                    }
                }
            }
        }else {
            insertLangs(languageModelArrayList);
        }
    }

    private void initSeekBar() {
        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress > 0)
                    binding.txtDistance.setText("" + progress + " km");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

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
        titileToolbar.setText("Personal Info");
        toolbarTitleRight.setText("Next");
        toolbarTitleRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                insertExperience();
                UIHelper.openActivity(PersonalInfoActivity.this, AboutActivity.class);
            }
        });
    }

    public void onLanguageSelectionClick(View view) {
        if (ApplicationState.getInstance().isFromEdit()) {
            ArrayList<UserLanguage> userLanguages = ApplicationState.getInstance().getLanguageModelArrayList();
            if (userLanguages != null) {
                String languages = "";
                for (int i = 0; i < langArrayList.size(); i++) {
                    for (UserLanguage languageModel : userLanguages) {
                        if (langArrayList.get(i).getId().equalsIgnoreCase(languageModel.getLanguageID())) {
                            langArrayList.get(i).setSelected(true);
                            break;
                        }
                    }
                }

            }
        }

        LanguageSelectionDialoge languageSelectionDialoge = LanguageSelectionDialoge.newInstance(langArrayList);
        languageSelectionDialoge.setSelectedLanguages(new LanguagesAdapater.ISelectedLanguages() {
            @Override
            public void selectedLanguages(ArrayList<LanguageModel> languageModels) {
                String languages = "";
                ArrayList<LanguageModel> languageModelArrayList = new ArrayList<>();
                for (LanguageModel languageModel : languageModels) {
                    if (languageModel.isSelected()) {
                        languages = languages + languageModel.getName() + ", ";
                        languageModelArrayList.add(languageModel);
                    }
                }
                if (languages != null && languages.length() > 0 && languages.charAt(languages.length() - 1) == ',') {
                    languages = languages.substring(0, languages.length() - 1);
                }
                binding.txtLanguage.setText(languages);
                if (ApplicationState.getInstance().isFromEdit()) {
                    updateLanguages(languageModelArrayList);
                } else
                    insertLangs(languageModelArrayList);

            }
        });
        languageSelectionDialoge.show(getSupportFragmentManager(), "languageSelectionDialoge");

    }

    private void insertLangs(ArrayList<LanguageModel> languageModelArrayList) {
        for (int i = 0; i < languageModelArrayList.size(); i++) {
            InsertUserLangRequest langRequest = new InsertUserLangRequest();
            langRequest.setLanguageID(languageModelArrayList.get(i).getId());
            apiInsertLang(langRequest);
        }
    }

    private void apiInsertLang(InsertUserLangRequest insertUserLangRequest) {
        WebServiceFactory.getInstance().init(this);
        WebServiceFactory.getInstance().apiInsertLanguages(insertUserLangRequest, new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {

            }
        });

    }

    private void apiDeleteLang(InsertUserLangRequest insertUserLangRequest, final ArrayList<LanguageModel> languageModelArrayList) {
        WebServiceFactory.getInstance().init(this);
        WebServiceFactory.getInstance().apiDeleteLanguages(insertUserLangRequest, new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {
                insertLangs(languageModelArrayList);
            }
        });

    }

    private void insertExperience() {
        InsertGiverExperienceRequest experienceRequest = new InsertGiverExperienceRequest();
        PreferenceHelper.getInstance().init(this);
        experienceRequest.setCaregiverID(PreferenceHelper.getInstance().getString(Constants.GIVER_ID, ""));
        experienceRequest.setYears(binding.edtExperience.getText().toString());
        experienceRequest.setDesiredWage(binding.edtHourlyRate.getText().toString());
        experienceRequest.setAvailabilityDistance(binding.txtDistance.getText().toString());
        WebServiceFactory.getInstance().init(this);
        WebServiceFactory.getInstance().apiAddExperience(experienceRequest, new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {

            }
        });
    }

    private void getAllLang() {
        WebServiceFactory.getInstance().init(this);
        WebServiceFactory.getInstance().apiGetAllLang(new GenericGetRequest(), new ApiCallback() {
            @Override
            public void onSuccess(MainResponse mainResponse) {
                langArrayList = mainResponse.getResultResponse().getLanguageModelArrayList();
            }
        });
    }

    public void onAddEducationClick(View view) {
        EducationDialoge educationDialoge = EducationDialoge.newInstance();
        educationDialoge.show(getSupportFragmentManager(), "educationDialoge");
    }

    public void onAddLicenseClick(View view) {
        LicenseDialoge licenseDialoge = LicenseDialoge.newInstance();
        licenseDialoge.show(getSupportFragmentManager(), "licenseDialoge");
    }
}
