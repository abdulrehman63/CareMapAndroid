package com.square63.caremap.ui.providerModule;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.square63.caremap.R;
import com.square63.caremap.constants.Constants;
import com.square63.caremap.databinding.ActivityPersonalInfoBinding;
import com.square63.caremap.dialoges.EducationDialoge;
import com.square63.caremap.dialoges.LanguageSelectionDialoge;
import com.square63.caremap.dialoges.LicenseDialoge;
import com.square63.caremap.models.LanguageModel;
import com.square63.caremap.models.SkillsModel;
import com.square63.caremap.ui.DaysSelectionActivity;
import com.square63.caremap.ui.adapters.LanguagesAdapater;
import com.square63.caremap.utils.UIHelper;
import com.square63.caremap.utils.Validations;

import java.util.ArrayList;

public class PersonalInfoActivity extends AppCompatActivity {

    private ImageButton imgBack;
    private TextView titileToolbar,toolbarTitleRight;
    ActivityPersonalInfoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_personal_info);
       init();
    }
    private void  init(){
        initToolBar();
        initSeekBar();
    }
    private void initSeekBar(){
        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                binding.txtDistance.setText(""+progress+" KM");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
    private void initToolBar(){
        final Validations validations = new Validations(this);
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
        titileToolbar.setText("Personal Info");
        toolbarTitleRight.setText("Next");
        toolbarTitleRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIHelper.openActivity(PersonalInfoActivity.this,DaysSelectionActivity.class);
                     }
        });
    }
    public void onLanguageSelectionClick(View view){
         String languageArr[] = {"English","Italian","Mandarin Chinese","Spanish","Punjabi"};
        ArrayList<LanguageModel> languageModelArrayList = new ArrayList<>();
         for (int i= 0; i < languageArr.length; i++){
             LanguageModel languageModel = new LanguageModel();
             languageModel.setName(languageArr[i]);
             languageModelArrayList.add(languageModel);
         }
        LanguageSelectionDialoge languageSelectionDialoge = LanguageSelectionDialoge.newInstance(languageModelArrayList);
         languageSelectionDialoge.setSelectedLanguages(new LanguagesAdapater.ISelectedLanguages() {
             @Override
             public void selectedLanguages(ArrayList<LanguageModel> languageModels) {
                 String languages="";
                 for (LanguageModel languageModel:languageModels){
                     if(languageModel.isSelected())
                         languages = languages+languageModel.getName()+",";
                 }
                 if (languages != null && languages.length() > 0 && languages.charAt(languages.length() - 1) == ',') {
                     languages = languages.substring(0, languages.length() - 1);
                 }
                 binding.txtLanguage.setText(languages);

             }
         });
        languageSelectionDialoge.show(getSupportFragmentManager(),"languageSelectionDialoge");

    }
    public void onAddEducationClick(View view){
        EducationDialoge educationDialoge = EducationDialoge.newInstance();
        educationDialoge.show(getSupportFragmentManager(),"educationDialoge");
    }
    public void onAddLicenseClick(View view){
        LicenseDialoge licenseDialoge = LicenseDialoge.newInstance();
        licenseDialoge.show(getSupportFragmentManager(),"licenseDialoge");
    }
}
