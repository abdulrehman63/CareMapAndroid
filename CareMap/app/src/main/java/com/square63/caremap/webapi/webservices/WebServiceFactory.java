package com.square63.caremap.webapi.webservices;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;



public class WebServiceFactory {

    public static WebServiceFactory instance_;
    private Context context_;

    public synchronized static WebServiceFactory getInstance() {
        if (instance_ == null) {
            instance_ = new WebServiceFactory();
        }
        return instance_;
    }

    public void init(Context context) {
        context_ = context;
    }

    /*public void apiSignup(SignUpModel signUpModel, final ApiCallback apiCallback) {
        checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final ProgressDialog loading;
        loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse> signUpResponseCall = apiInterface.signUp(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, retrofit2.Response<MainResponse> response) {
                if (response.isSuccessful() && response.body().getStoreResponse().getCode().equalsIgnoreCase(Constants.SUCCESS_CODE)) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                }

                loading.dismiss();
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
                //  UIHelper.showLongToastInCenter(context_, t.getMessage());
                Log.d("fail", t.getMessage());
                loading.dismiss();

            }
        });

    }*/
   /* public void apiSignin(SignUpModel signUpModel, final ApiCallback apiCallback) {
        checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final ProgressDialog loading;
        loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse> signInResponseCall = apiInterface.signin(signUpModel);
        signInResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, Response<MainResponse> response) {
                if (response.isSuccessful() && response.body().getStoreResponse().getCode().equalsIgnoreCase(Constants.SUCCESS_CODE)) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());
                }else {
                    UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                }

                loading.dismiss();
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
                // UIHelper.showLongToastInCenter(context_, t.getMessage());
                Log.d("fail", t.getMessage());
                loading.dismiss();
            }
        });
    }

    public void apiForgot(String email, final ApiCallback apiCallback) {
        checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final ProgressDialog loading;
        loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);

        Map<String, Object> jsonParams = new ArrayMap<>();
        jsonParams.put("email", email);

        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), (new JSONObject(jsonParams)).toString());

        Call<MainResponse> forgotResponseCall = apiInterface.forgot(body);
        forgotResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, Response<MainResponse> response) {
                if (response.isSuccessful() && response.body().getStoreResponse().getCode().equalsIgnoreCase(Constants.SUCCESS_CODE)) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());
                }else {
                    UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                }

                loading.dismiss();
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
                UIHelper.showLongToastInCenter(context_, t.getMessage());
                Log.d("fail", t.getMessage());
                loading.dismiss();
            }
        });
    }
*/
    /*private void checkNetworkState(){
        if(!isNetworkAvailable(context_)) {
           showLongToastInCenter(context_,context_.getResources().getString(R.string.connectivity_msg));
            return;
        }
    }*/
    public static void showLongToastInCenter(Context ctx, String message) {
        //message = Strings.nullToEmpty( message );
        Toast toast = Toast.makeText(ctx, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
   /* public static  boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }*/
}
