package com.square63.caremap.webapi.webservices;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.square63.caremap.R;
import com.square63.caremap.listeners.RegisterApiCallBack;
import com.square63.caremap.models.RegistrationModel;
import com.square63.caremap.utils.UIHelper;
import com.square63.caremap.webapi.ApiClient;
import com.square63.caremap.webapi.Apiinterface.ApiCallback;
import com.square63.caremap.webapi.Apiinterface.ApiInterface;
import com.square63.caremap.webapi.CreateGiverRequest;
import com.square63.caremap.webapi.responses.CreateCareGiverResponse;
import com.square63.caremap.webapi.responses.MainResponse;

import org.json.JSONObject;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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

    public void apiSignup(CreateGiverRequest signUpModel, final RegisterApiCallBack apiCallback) {
        checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final ProgressDialog loading;
        loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<CreateCareGiverResponse> signUpResponseCall = apiInterface.apiRegister(signUpModel);
        signUpResponseCall.enqueue(new Callback<CreateCareGiverResponse>() {
            @Override
            public void onResponse(Call<CreateCareGiverResponse> call, retrofit2.Response<CreateCareGiverResponse> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                 //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                }

                loading.dismiss();
            }

            @Override
            public void onFailure(Call<CreateCareGiverResponse> call, Throwable t) {
                //  UIHelper.showLongToastInCenter(context_, t.getMessage());
                Log.d("fail", t.getMessage());
                loading.dismiss();

            }
        });

    }
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

    public void apiEmailValidations(String emailId, final ApiCallback apiCallback){
        checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final ProgressDialog loading;
        loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        JsonObject paramObject = new JsonObject();

        Map<String, Object> jsonParams = new ArrayMap<>();
        jsonParams.put("email", emailId);

        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), (new JSONObject(jsonParams)).toString());

        Call<MainResponse> _deviceToken = apiInterface.apiEmailValidation(body);
        _deviceToken.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, Response<MainResponse> response) {
                if (response.isSuccessful()) {
                    apiCallback.onSuccess(response.body());
                }
                loading.dismiss();
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {

            }
        });
    }

    private void checkNetworkState(){
        if(!isNetworkAvailable(context_)) {
           showLongToastInCenter(context_,context_.getResources().getString(R.string.connectivity_msg));
            return;
        }
    }
    public static void showLongToastInCenter(Context ctx, String message) {
        //message = Strings.nullToEmpty( message );
        Toast toast = Toast.makeText(ctx, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
   public static  boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
