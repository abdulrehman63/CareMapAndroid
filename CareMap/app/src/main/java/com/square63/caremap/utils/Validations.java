package com.square63.caremap.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.square63.caremap.R;
import com.square63.caremap.constants.Constants;
import com.square63.caremap.databinding.ActivityCreateProviderProfileBinding;
import com.square63.caremap.models.ProfileModel;
import com.square63.caremap.ui.providerModule.CreateProviderProfileActivity;


public class Validations {
    private Context context;
    public Validations(Context context){
        this.context = context;

    }

    public int validateLogin(EditText edtEmail, EditText edtPassword, ImageView imageView){

        Resources res = context.getResources();
        String text;
        int isValidate = Constants.SUCCESS;
        if (edtEmail.getText().toString().trim().length() == 0) {
         /*   text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.email));
            edtEmail.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));*/
          imageView.setVisibility(View.VISIBLE);
          edtEmail.setBackgroundResource(R.drawable.red_rectangle);
            isValidate =  Constants.EMPTY_EMAIL_FIELD;
        }
        if (edtPassword.getText().toString().trim().length() == 0) {
            imageView.setVisibility(View.VISIBLE);
            edtPassword.setBackgroundResource(R.drawable.red_rectangle);
           /* text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.password));
            edtPassword.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));*/
            isValidate = Constants.EMPTY_EMAIL_FIELD;
        }
        if (!UIHelper.isValidEmail(edtEmail.getText().toString().trim())) {
           /* text = String.format(res.getString(R.string.email_field_error), context.getString(R.string.email));
            edtEmail.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));*/
            imageView.setVisibility(View.VISIBLE);
            edtEmail.setBackgroundResource(R.drawable.red_rectangle);
            isValidate = Constants.EMPTY_EMAIL_FIELD;
            UIHelper.showAlert(Constants.FORM,Constants.INVALID_EMAIL,context);
            return isValidate;
        }
        if(isValidate != Constants.SUCCESS){
            UIHelper.showAlert(Constants.FORM,Constants.MSG,context);
        }

        return isValidate;
    }

    public int validateForgotPassword(EditText edtEmail,ImageView imageView){

        Resources res = context.getResources();
        String text;
        int isValidate = Constants.SUCCESS;
        if (edtEmail.getText().toString().trim().length() == 0) {
            imageView.setVisibility(View.VISIBLE);
            edtEmail.setBackgroundResource(R.drawable.red_rectangle);
         /*   text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.email));
            edtEmail.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));*/
            isValidate =  Constants.EMPTY_EMAIL_FIELD;
        }

        if (!UIHelper.isValidEmail(edtEmail.getText().toString().trim())) {
            imageView.setVisibility(View.VISIBLE);
            edtEmail.setBackgroundResource(R.drawable.red_rectangle);
           /* text = String.format(res.getString(R.string.email_field_error), context.getString(R.string.email));
            edtEmail.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));*/
            isValidate =  Constants.EMPTY_EMAIL_FIELD;
            UIHelper.showAlert(Constants.FORM,Constants.INVALID_EMAIL,context);
            return isValidate;
        }
        if(isValidate != Constants.SUCCESS){
            UIHelper.showAlert(Constants.FORM,Constants.MSG,context);
        }
        return isValidate;
    }
    public int validateTagline(EditText edtEmail){

        Resources res = context.getResources();
        String text;
        int isValidate = Constants.SUCCESS;
        /*if (edtEmail.getText().toString().trim().length() == 0) {

            text = String.format(res.getString(R.string.empty_field_error), "Tag Line");
            edtEmail.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));
            isValidate =  Constants.EMPTY_EMAIL_FIELD;
        }*/
        if (edtEmail.getText().toString().trim().length() < 35) {

            text = res.getString(R.string.minimum_field_error);
            edtEmail.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));
            isValidate =  Constants.EMPTY_EMAIL_FIELD;
        }
        /*if (edtEmail.getText().toString().trim().length() > 30) {
            UIHelper.showAlert(Constants.FORM,Constants.MSG,context);
        }*/


        return isValidate;
    }


    public int validateSignup(EditText edtName, EditText edtEmail, EditText edtPassword,ImageView imageView) {
        Resources res = context.getResources();
        String text;
        int isValidate = Constants.SUCCESS;
        if (edtName.getText().toString().trim().length() == 0) {
          /*  text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.user_name));
            edtName.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));*/
            imageView.setVisibility(View.VISIBLE);
            edtName.setBackgroundResource(R.drawable.red_rectangle);
            isValidate = Constants.EMPTY_EMAIL_FIELD;
        }
        if (edtEmail.getText().toString().trim().length() == 0) {
            /*text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.email));
            edtEmail.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));*/
            imageView.setVisibility(View.VISIBLE);
            edtEmail.setBackgroundResource(R.drawable.red_rectangle);
            isValidate =  Constants.EMPTY_EMAIL_FIELD;
        }
        if (edtPassword.getText().toString().trim().length() == 0) {
          /*  text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.password));
            edtPassword.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));*/
            imageView.setVisibility(View.VISIBLE);
            edtPassword.setBackgroundResource(R.drawable.red_rectangle);
            isValidate =  Constants.EMPTY_EMAIL_FIELD;
        }
        if (!UIHelper.isValidEmail(edtEmail.getText().toString().trim())) {
           /* text = String.format(res.getString(R.string.email_field_error), context.getString(R.string.email));
            edtEmail.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));*/
            imageView.setVisibility(View.VISIBLE);
            edtEmail.setBackgroundResource(R.drawable.red_rectangle);
            isValidate = Constants.EMPTY_EMAIL_FIELD;
            UIHelper.showAlert(Constants.FORM,Constants.INVALID_EMAIL,context);
            return isValidate;
        }

        if(isValidate != Constants.SUCCESS){
            UIHelper.showAlert(Constants.FORM,Constants.MSG,context);
        }

        return isValidate;
    }
    public int validateCreateProfile(EditText edtFirstName, EditText edtLastName, EditText edtPostalCode, EditText phoneNumber, EditText edtCity, EditText edtProvince, EditText edtAddress1,
                                     TextView fName, TextView lName,  TextView txtPostalCode,  TextView pNumber,  TextView city, TextView province, TextView address) {
        Resources res = context.getResources();
        String text;
        int isValidate = Constants.SUCCESS;

        if (edtFirstName.getText().toString().trim().length() == 0) {
             /*text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.first_name));
            edtFirstName.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));*/
             setDrawableEnd(fName);
             isValidate = Constants.EMPTY_EMAIL_FIELD;

        }
        if (edtLastName.getText().toString().trim().length() == 0) {
          /*  text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.last_name));
            edtLastName.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));*/
            setDrawableEnd(lName);
            isValidate = Constants.EMPTY_EMAIL_FIELD;
        }
        /*if (edtDob.getText().toString().trim().length() == 0) {
           *//* text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.date_of_brith));
            edtDob.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));*//*
            setDrawableEnd(dob);
            isValidate = Constants.EMPTY_EMAIL_FIELD;
        }*/
        if (phoneNumber.getText().toString().trim().length() == 0) {
           // text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.phone_number));
            //phoneNumber.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));
            setDrawableEnd(pNumber);
            isValidate = Constants.EMPTY_EMAIL_FIELD;
        }
        if (edtCity.getText().toString().trim().length() == 0) {
           /* text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.city));
            edtCity.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));*/
            setDrawableEnd(city);
            isValidate = Constants.EMPTY_EMAIL_FIELD;
        }
        if (edtProvince.getText().toString().trim().length() == 0) {
           /* text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.province));
            edtProvince.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));*/
            setDrawableEnd(province);
            isValidate = Constants.EMPTY_EMAIL_FIELD;
        }
       /* if (edtAddress1.getText().toString().trim().length() == 0) {
           *//* text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.address_1));
            edtAddress1.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));*//*
            setDrawableEnd(address);
            isValidate = Constants.EMPTY_EMAIL_FIELD;
        }*/
        if(isValidate != Constants.SUCCESS){
            UIHelper.showAlert(Constants.FORM,Constants.MSG,context);
        }
        return isValidate;
    }
    public int validatePersonelProfile(EditText edtFirstName, EditText edtLastName,
                                     TextView fName, TextView lName) {
        Resources res = context.getResources();
        String text;
        int isValidate = Constants.SUCCESS;

        if (edtFirstName.getText().toString().trim().length() == 0) {
             /*text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.first_name));
            edtFirstName.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));*/
            setDrawableEnd(fName);
            isValidate = Constants.EMPTY_EMAIL_FIELD;

        }
        if (edtLastName.getText().toString().trim().length() == 0) {
          /*  text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.last_name));
            edtLastName.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));*/
            setDrawableEnd(lName);
            isValidate = Constants.EMPTY_EMAIL_FIELD;
        }
        /*if (edtDob.getText().toString().trim().length() == 0) {
         *//* text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.date_of_brith));
            edtDob.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));*//*
            setDrawableEnd(dob);
            isValidate = Constants.EMPTY_EMAIL_FIELD;
        }*/

        if(isValidate != Constants.SUCCESS){
            UIHelper.showAlert(Constants.FORM,Constants.MSG,context);
        }
        return isValidate;
    }
    public int validateCreateProfileText(TextView edtFirstName, TextView edtLastName, TextView edtDob, TextView phoneNumber,TextView edtCity,TextView edtProvince, TextView edtAddress1) {
        Resources res = context.getResources();
        String text;

        if (edtFirstName.getText().toString().trim().length() == 0) {
            setDrawableEnd(edtFirstName);
            return Constants.EMPTY_EMAIL_FIELD;
        }
        if (edtLastName.getText().toString().trim().length() == 0) {
            setDrawableEnd(edtLastName);
            return Constants.EMPTY_EMAIL_FIELD;
        }
        if (edtDob.getText().toString().trim().length() == 0) {
            setDrawableEnd(edtDob);
            return Constants.EMPTY_EMAIL_FIELD;
        }
        if (phoneNumber.getText().toString().trim().length() == 0) {
            setDrawableEnd(phoneNumber);
            return Constants.EMPTY_EMAIL_FIELD;
        }
        if (edtCity.getText().toString().trim().length() == 0) {
            setDrawableEnd(edtCity);
            return Constants.EMPTY_EMAIL_FIELD;
        }
        if (edtProvince.getText().toString().trim().length() == 0) {
            setDrawableEnd(edtProvince);
            return Constants.EMPTY_EMAIL_FIELD;
        }
        if (edtAddress1.getText().toString().trim().length() == 0) {
            setDrawableEnd(edtAddress1);
            return Constants.EMPTY_EMAIL_FIELD;
        }

        return Constants.SUCCESS;
    }

    private void setDrawableEnd(TextView textView){
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.error_small,0);

    }

    public int validateSeekerProfile(EditText edtFirstName, EditText edtLastName, EditText edtEmergencyNumber, EditText phoneNumber,EditText edtCity,EditText edtProvince, EditText edtAddress1,EditText number, EditText unitNumber,
                                     TextView txtFirstName, TextView txtLastName, TextView txtEmergencyNumber, TextView txtPhoneNumber,TextView txtCity,TextView txtProvince, TextView txtAddress1,TextView txtNumber, TextView txtUnitNumber) {
        Resources res = context.getResources();
        String text;
        int isValidate = Constants.SUCCESS;

        if (edtFirstName.getText().toString().trim().length() == 0) {
           /* text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.first_name));
            edtFirstName.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));*/
            setDrawableEnd(txtFirstName);
            isValidate = Constants.EMPTY_EMAIL_FIELD;
            //return Constants.EMPTY_EMAIL_FIELD;
        }
        if (edtLastName.getText().toString().trim().length() == 0) {
          /*  text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.last_name));
            edtLastName.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));*/
            setDrawableEnd(txtLastName);
            isValidate = Constants.EMPTY_EMAIL_FIELD;
            //return Constants.EMPTY_EMAIL_FIELD;
        }
        if (phoneNumber.getText().toString().trim().length() == 0) {
            setDrawableEnd(txtPhoneNumber);
            isValidate = Constants.EMPTY_EMAIL_FIELD;
            // return Constants.EMPTY_EMAIL_FIELD;
        }
      /*  if (edtEmergencyNumber.getText().toString().trim().length() == 0) {
          *//*  text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.emergency_number));
            edtEmergencyNumber.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));*//*
            setDrawableEnd(txtEmergencyNumber);
            isValidate = Constants.EMPTY_EMAIL_FIELD;
            //return Constants.EMPTY_EMAIL_FIELD;
        }
        if (phoneNumber.getText().toString().trim().length() == 0) {
           *//* text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.phone_number));
            phoneNumber.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));*//*
            setDrawableEnd(txtPhoneNumber);
            isValidate = Constants.EMPTY_EMAIL_FIELD;
           // return Constants.EMPTY_EMAIL_FIELD;
        }
        if (edtCity.getText().toString().trim().length() == 0) {
            *//*text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.city));
            edtCity.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));*//*
            setDrawableEnd(txtCity);
            isValidate = Constants.EMPTY_EMAIL_FIELD;
            //return Constants.EMPTY_EMAIL_FIELD;
        }
        if (edtProvince.getText().toString().trim().length() == 0) {
           *//* text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.province));
            edtProvince.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));*//*
            setDrawableEnd(txtProvince);
            isValidate = Constants.EMPTY_EMAIL_FIELD;
            //return Constants.EMPTY_EMAIL_FIELD;
        }
        if (edtAddress1.getText().toString().trim().length() == 0) {
           *//* text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.address_1));
            edtAddress1.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));*//*
            setDrawableEnd(txtAddress1);
            isValidate = Constants.EMPTY_EMAIL_FIELD;


        }
        if (number.getText().toString().trim().length() == 0) {
           *//* text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.number));
            number.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));*//*
            setDrawableEnd(txtNumber);
            isValidate = Constants.EMPTY_EMAIL_FIELD;
        }
        if (unitNumber.getText().toString().trim().length() == 0) {
           *//* text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.unit_number));
            unitNumber.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));
            return Constants.EMPTY_EMAIL_FIELD;*//*
            setDrawableEnd(txtUnitNumber);
            isValidate = Constants.EMPTY_EMAIL_FIELD;
        }*/
        if(isValidate != Constants.SUCCESS){
            UIHelper.showAlert(Constants.FORM,Constants.MSG,context);
        }
         return isValidate;
    }

    public int validateSeekerProfile(EditText edtName,EditText edtAge,EditText edtCity,EditText edtProvince, EditText edtAddress1,EditText number, EditText unitNumber,
                                     TextView txtCity,TextView txtProvince, TextView txtAddress1,TextView txtNumber, TextView txtUnitNumber,TextView txtName,TextView txtAge,EditText edtStreet, TextView street) {
        Resources res = context.getResources();
        String text;
        int isValidate = Constants.SUCCESS;
        if (edtName.getText().toString().trim().length() == 0) {
            /*text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.city));
            edtCity.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));*/
            setDrawableEnd(txtName);
            isValidate = Constants.EMPTY_EMAIL_FIELD;
            //return Constants.EMPTY_EMAIL_FIELD;
        }
        if (edtStreet.getText().toString().trim().length() == 0) {
            /*text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.city));
            edtCity.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));*/
            setDrawableEnd(street);
            isValidate = Constants.EMPTY_EMAIL_FIELD;
            //return Constants.EMPTY_EMAIL_FIELD;
        }
        if (edtAge.getText().toString().trim().length() == 0) {
           /* text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.province));
            edtProvince.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));*/
            setDrawableEnd(txtAge);
            isValidate = Constants.EMPTY_EMAIL_FIELD;
            //return Constants.EMPTY_EMAIL_FIELD;
        }

        if (edtCity.getText().toString().trim().length() == 0) {
            /*text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.city));
            edtCity.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));*/
            setDrawableEnd(txtCity);
            isValidate = Constants.EMPTY_EMAIL_FIELD;
            //return Constants.EMPTY_EMAIL_FIELD;
        }
        if (edtProvince.getText().toString().trim().length() == 0) {
           /* text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.province));
            edtProvince.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));*/
            setDrawableEnd(txtProvince);
            isValidate = Constants.EMPTY_EMAIL_FIELD;
            //return Constants.EMPTY_EMAIL_FIELD;
        }
        if (edtAddress1.getText().toString().trim().length() == 0) {
           /* text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.address_1));
            edtAddress1.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));*/
            setDrawableEnd(txtAddress1);
            isValidate = Constants.EMPTY_EMAIL_FIELD;


        }
        /*if (number.getText().toString().trim().length() == 0) {
           *//* text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.number));
            number.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));*//*
            setDrawableEnd(txtNumber);
            isValidate = Constants.EMPTY_EMAIL_FIELD;
        }*/
        if (unitNumber.getText().toString().trim().length() == 0) {
           /* text = String.format(res.getString(R.string.empty_field_error), context.getString(R.string.unit_number));
            unitNumber.setError(Html.fromHtml("<font color='red'>" + text + "</font>"));
            return Constants.EMPTY_EMAIL_FIELD;*/
            setDrawableEnd(txtUnitNumber);
            isValidate = Constants.EMPTY_EMAIL_FIELD;
        }
        if(isValidate != Constants.SUCCESS){
            UIHelper.showAlert(Constants.FORM,Constants.MSG,context);
        }
        return isValidate;
    }

}
