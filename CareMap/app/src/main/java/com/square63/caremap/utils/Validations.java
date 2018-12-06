package com.square63.caremap.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import com.square63.caremap.R;
import com.square63.caremap.constants.Constants;


public class Validations {
    private Context context;
    public Validations(Context context){
        this.context = context;

    }

    public int validateLogin(EditText edtEmail, EditText edtPassword){

        Resources res = context.getResources();
        String text;

        if (edtEmail.getText().toString().trim().length() == 0) {
            text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.email));
            edtEmail.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));
            return Constants.EMPTY_EMAIL_FIELD;
        }
        if (edtPassword.getText().toString().trim().length() == 0) {
            text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.password));
            edtPassword.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));
            return Constants.EMPTY_EMAIL_FIELD;
        }
        if (!UIHelper.isValidEmail(edtEmail.getText().toString())) {
            text = String.format(res.getString(R.string.email_field_error), context.getString(R.string.email));
            edtEmail.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));
            return Constants.EMPTY_EMAIL_FIELD;
        }

        return Constants.SUCCESS;
    }
    public int validateForgotPassword(EditText edtEmail){

        Resources res = context.getResources();
        String text;

        if (edtEmail.getText().toString().trim().length() == 0) {
            text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.email));
            edtEmail.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));
            return Constants.EMPTY_EMAIL_FIELD;
        }

        if (!UIHelper.isValidEmail(edtEmail.getText().toString())) {
            text = String.format(res.getString(R.string.email_field_error), context.getString(R.string.email));
            edtEmail.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));
            return Constants.EMPTY_EMAIL_FIELD;
        }

        return Constants.SUCCESS;
    }


    public int validateSignup(EditText edtName, EditText edtEmail, EditText edtPassword) {
        Resources res = context.getResources();
        String text;

        if (edtName.getText().toString().trim().length() == 0) {
            text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.user_name));
            edtName.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));
            return Constants.EMPTY_EMAIL_FIELD;
        }
        if (edtEmail.getText().toString().trim().length() == 0) {
            text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.email));
            edtEmail.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));
            return Constants.EMPTY_EMAIL_FIELD;
        }
        if (edtPassword.getText().toString().trim().length() == 0) {
            text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.password));
            edtPassword.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));
            return Constants.EMPTY_EMAIL_FIELD;
        }
        if (!UIHelper.isValidEmail(edtEmail.getText().toString())) {
            text = String.format(res.getString(R.string.email_field_error), context.getString(R.string.email));
            edtEmail.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));
            return Constants.EMPTY_EMAIL_FIELD;
        }



        return Constants.SUCCESS;
    }
    public int validateCreateProfile(EditText edtFirstName, EditText edtLastName, EditText edtDob, EditText phoneNumber,EditText edtCity,EditText edtProvince, EditText edtAddress1) {
        Resources res = context.getResources();
        String text;

        if (edtFirstName.getText().toString().trim().length() == 0) {
            text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.first_name));
            edtFirstName.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));
            return Constants.EMPTY_EMAIL_FIELD;
        }
        if (edtLastName.getText().toString().trim().length() == 0) {
            text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.last_name));
            edtLastName.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));
            return Constants.EMPTY_EMAIL_FIELD;
        }
        if (edtDob.getText().toString().trim().length() == 0) {
            text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.date_of_brith));
            edtDob.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));
            return Constants.EMPTY_EMAIL_FIELD;
        }
        if (phoneNumber.getText().toString().trim().length() == 0) {
            text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.phone_number));
            phoneNumber.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));
            return Constants.EMPTY_EMAIL_FIELD;
        }
        if (edtCity.getText().toString().trim().length() == 0) {
            text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.city));
            edtCity.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));
            return Constants.EMPTY_EMAIL_FIELD;
        }
        if (edtProvince.getText().toString().trim().length() == 0) {
            text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.province));
            edtProvince.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));
            return Constants.EMPTY_EMAIL_FIELD;
        }
        if (edtAddress1.getText().toString().trim().length() == 0) {
            text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.address_1));
            edtAddress1.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));
            return Constants.EMPTY_EMAIL_FIELD;
        }

        return Constants.SUCCESS;
    }



}
