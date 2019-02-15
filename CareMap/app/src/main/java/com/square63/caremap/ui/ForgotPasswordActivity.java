package com.square63.caremap.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.square63.caremap.R;
import com.square63.caremap.constants.Constants;
import com.square63.caremap.utils.UIHelper;
import com.square63.caremap.utils.Validations;

public class ForgotPasswordActivity extends AppCompatActivity {

    private ImageView imageViewError;
    private EditText edtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        setTitleBar();
    }
    private void setTitleBar(){
        imageViewError = findViewById(R.id.imageViewError);
        edtEmail = findViewById(R.id.edtEmail);
        ImageButton imgBack = (ImageButton) findViewById(R.id.imgBackbtn);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void onForgotPasswordClick(View view){
        Validations validations = new Validations(this);
        if(validations.validateForgotPassword(edtEmail,imageViewError) == Constants.SUCCESS ){
           // UIHelper.openActivity(LoginActivity.this,WelcomeActivity.class);
        }

    }
}
