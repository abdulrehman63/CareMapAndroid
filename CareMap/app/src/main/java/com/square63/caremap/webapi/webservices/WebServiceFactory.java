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
import com.square63.caremap.constants.Constants;
import com.square63.caremap.listeners.RegisterApiCallBack;
import com.square63.caremap.models.EducationModel;
import com.square63.caremap.models.LicenseModel;
import com.square63.caremap.models.LoginModel;
import com.square63.caremap.models.RegistrationModel;
import com.square63.caremap.models.ResetPassModel;
import com.square63.caremap.models.chatModule.CreateMessageRequest;
import com.square63.caremap.models.seekerModels.CreateSeekerRequest;
import com.square63.caremap.models.seekerModels.CreateSeniorRequest;
import com.square63.caremap.utils.PreferenceHelper;
import com.square63.caremap.utils.UIHelper;
import com.square63.caremap.webapi.ApiClient;
import com.square63.caremap.webapi.Apiinterface.ApiCallBack2;
import com.square63.caremap.webapi.Apiinterface.ApiCallback;
import com.square63.caremap.webapi.Apiinterface.ApiInterface;
import com.square63.caremap.webapi.CreateGiverRequest;
import com.square63.caremap.webapi.requests.GenericGetRequest;
import com.square63.caremap.webapi.requests.GetGiverInterestById;
import com.square63.caremap.webapi.requests.GetGiverLanguageRequest;
import com.square63.caremap.webapi.requests.GetGiverProfileRequest;
import com.square63.caremap.webapi.requests.GetGiverSkilsById;
import com.square63.caremap.webapi.requests.GetMaeesageByIdRequest;
import com.square63.caremap.webapi.requests.GetSeekersRequest;
import com.square63.caremap.webapi.requests.GetUserThread;
import com.square63.caremap.webapi.requests.GiverRequest;
import com.square63.caremap.webapi.requests.InsertAvailabilityRequest;
import com.square63.caremap.webapi.requests.InsertGiverEducationRequest;
import com.square63.caremap.webapi.requests.InsertGiverExperienceRequest;
import com.square63.caremap.webapi.requests.InsertGiverLicenseRequest;
import com.square63.caremap.webapi.requests.InsertGiverSkilsRequest;
import com.square63.caremap.webapi.requests.InsertUserInterestRequest;
import com.square63.caremap.webapi.requests.InsertUserLangRequest;
import com.square63.caremap.webapi.requests.LoginRequest;
import com.square63.caremap.webapi.requests.UploadImageRequest;
import com.square63.caremap.webapi.responses.CreateCareGiverResponse;
import com.square63.caremap.webapi.responses.MainResponse;
import com.square63.caremap.webapi.responses.MainResponse2;

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

    public void apiSignup(CreateGiverRequest signUpModel, final ApiCallback apiCallback) {
        checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final ProgressDialog loading;
        loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse> signUpResponseCall = apiInterface.apiRegister(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, retrofit2.Response<MainResponse> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                 //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
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

    }
    public void apiUpdateGiver(CreateGiverRequest signUpModel, final ApiCallback apiCallback) {
        checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final ProgressDialog loading;
        loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse> signUpResponseCall = apiInterface.apiUpdateGiver(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, retrofit2.Response<MainResponse> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
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

    }
    public void apiLogin(LoginModel signUpModel, final ApiCallback apiCallback) {
        checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final ProgressDialog loading;
        loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse> signUpResponseCall = apiInterface.apiLogin(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, retrofit2.Response<MainResponse> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
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

    }
    public void apiGetAllLang(GenericGetRequest signUpModel, final ApiCallback apiCallback) {
        checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final ProgressDialog loading;
        loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse> signUpResponseCall = apiInterface.apiGetUserLanguage(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, retrofit2.Response<MainResponse> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
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
    public void apiAddEducation(EducationModel signUpModel, final ApiCallback apiCallback) {
        checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final ProgressDialog loading;
        loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse> signUpResponseCall = apiInterface.apiInsertEducation(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, retrofit2.Response<MainResponse> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
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

    }
    public void apiGetEducation( final ApiCallBack2 apiCallback) {
        checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final ProgressDialog loading;
        loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);
        GetGiverProfileRequest giverProfileRequest = new GetGiverProfileRequest();
        giverProfileRequest.getFilterCaregiverEducation().setCaregiverId(PreferenceHelper.getInstance().getString(Constants.GIVER_ID,""));

        Call<MainResponse2> signUpResponseCall = apiInterface.apiGetGiverEducation(giverProfileRequest);
        signUpResponseCall.enqueue(new Callback<MainResponse2>() {
            @Override
            public void onResponse(Call<MainResponse2> call, retrofit2.Response<MainResponse2> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                }

                loading.dismiss();
            }

            @Override
            public void onFailure(Call<MainResponse2> call, Throwable t) {
                //  UIHelper.showLongToastInCenter(context_, t.getMessage());
                Log.d("fail", t.getMessage());
                loading.dismiss();

            }
        });

    }
    public void apiGetLicense( final ApiCallBack2 apiCallback) {
        checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final ProgressDialog loading;
        loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);
        GetGiverProfileRequest giverProfileRequest = new GetGiverProfileRequest();
        giverProfileRequest.getFilterCaregiverLicense().setCaregiverId(PreferenceHelper.getInstance().getString(Constants.USER_ID,""));

        Call<MainResponse2> signUpResponseCall = apiInterface.apiGetGiverLicense(giverProfileRequest);
        signUpResponseCall.enqueue(new Callback<MainResponse2>() {
            @Override
            public void onResponse(Call<MainResponse2> call, retrofit2.Response<MainResponse2> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                }

                loading.dismiss();
            }

            @Override
            public void onFailure(Call<MainResponse2> call, Throwable t) {
                //  UIHelper.showLongToastInCenter(context_, t.getMessage());
                Log.d("fail", t.getMessage());
                loading.dismiss();

            }
        });

    }
    public void apiDeleteEducation(EducationModel signUpModel, final ApiCallback apiCallback) {
        checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final ProgressDialog loading;
        loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse> signUpResponseCall = apiInterface.apiDeleteEducation(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, retrofit2.Response<MainResponse> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
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

    }
    public void apiAddLicense(LicenseModel signUpModel, final ApiCallback apiCallback) {
        checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final ProgressDialog loading;
        loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse> signUpResponseCall = apiInterface.apiInsertLicense(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, retrofit2.Response<MainResponse> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
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

    }
    public void apiDeleteLicense(LicenseModel signUpModel, final ApiCallback apiCallback) {
        checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final ProgressDialog loading;
        loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse> signUpResponseCall = apiInterface.apiDeleteLicense(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, retrofit2.Response<MainResponse> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
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

    }
    public void apiAddExperience(InsertGiverExperienceRequest signUpModel, final ApiCallback apiCallback) {
        checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        //final ProgressDialog loading;
        //loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse> signUpResponseCall = apiInterface.apiInsertExperience(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, retrofit2.Response<MainResponse> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                }

                //loading.dismiss();
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
                //  UIHelper.showLongToastInCenter(context_, t.getMessage());
                Log.d("fail", t.getMessage());
                //loading.dismiss();

            }
        });

    }
    public void apiAddAvailability(InsertAvailabilityRequest signUpModel, final ApiCallback apiCallback) {
      //  checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final ProgressDialog loading;
       // loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse> signUpResponseCall = apiInterface.apiInsertAvailability(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, retrofit2.Response<MainResponse> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                }

               // loading.dismiss();
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
                //  UIHelper.showLongToastInCenter(context_, t.getMessage());
                Log.d("fail", t.getMessage());
                //loading.dismiss();

            }
        });

    }
    public void apiDeleteAvailability(InsertAvailabilityRequest signUpModel, final ApiCallback apiCallback) {
        //  checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final ProgressDialog loading;
        // loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse> signUpResponseCall = apiInterface.apiDeleteAvailability(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, retrofit2.Response<MainResponse> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                }

                // loading.dismiss();
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
                //  UIHelper.showLongToastInCenter(context_, t.getMessage());
                Log.d("fail", t.getMessage());
                //loading.dismiss();

            }
        });

    }

    public void apiGetAllInterests(GenericGetRequest signUpModel, final ApiCallback apiCallback) {
        checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final ProgressDialog loading;
        loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse> signUpResponseCall = apiInterface.apiGetUserInterests(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, retrofit2.Response<MainResponse> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
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

    }
    public void apiGetAllCareGivers(GiverRequest signUpModel, final ApiCallback apiCallback) {
        checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
       final ProgressDialog loading;
        loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse> signUpResponseCall = apiInterface.apiGetAllGiver(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, retrofit2.Response<MainResponse> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
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

    }
    public void apiGetCareGivers(GiverRequest signUpModel, final ApiCallback apiCallback) {
        checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
       // final ProgressDialog loading;
        //loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse> signUpResponseCall = apiInterface.apiGetAllGiver(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, retrofit2.Response<MainResponse> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                }

                //loading.dismiss();
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
                //  UIHelper.showLongToastInCenter(context_, t.getMessage());
                Log.d("fail", t.getMessage());
               // loading.dismiss();

            }
        });

    }
    public void apiGetGiverById(GetGiverProfileRequest signUpModel, final ApiCallback apiCallback) {
        checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final ProgressDialog loading;
        loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse> signUpResponseCall = apiInterface.apiGetGiverById(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, retrofit2.Response<MainResponse> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
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

    }
    public void apiGetGiverLanguageById(GetGiverLanguageRequest signUpModel, final ApiCallback apiCallback) {
        checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        //final ProgressDialog loading;
        //loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse> signUpResponseCall = apiInterface.apiGetGiverLanguageById(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, retrofit2.Response<MainResponse> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                }

               // loading.dismiss();
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
                //  UIHelper.showLongToastInCenter(context_, t.getMessage());
                Log.d("fail", t.getMessage());
               // loading.dismiss();

            }
        });

    }
    public void apiGetSeniorLanguageById(GetGiverLanguageRequest signUpModel, final ApiCallback apiCallback) {
        checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final ProgressDialog loading;
        loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse> signUpResponseCall = apiInterface.apiGetSeniorLanguageById(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, retrofit2.Response<MainResponse> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
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

    }
    public void apiGetGiverInterestById(GetGiverInterestById signUpModel, final ApiCallBack2 apiCallback) {
        checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
       // final ProgressDialog loading;
        //loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse2> signUpResponseCall = apiInterface.apiGetGiverInterestById(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse2>() {
            @Override
            public void onResponse(Call<MainResponse2> call, retrofit2.Response<MainResponse2> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                }

               // loading.dismiss();
            }

            @Override
            public void onFailure(Call<MainResponse2> call, Throwable t) {
                //  UIHelper.showLongToastInCenter(context_, t.getMessage());
                Log.d("fail", t.getMessage());
             //   loading.dismiss();

            }
        });

    }
    public void apiGetSeniorInterestById(GetSeekersRequest signUpModel, final ApiCallBack2 apiCallback) {
        checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final ProgressDialog loading;
        loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse2> signUpResponseCall = apiInterface.apiGetSeniorInterests(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse2>() {
            @Override
            public void onResponse(Call<MainResponse2> call, retrofit2.Response<MainResponse2> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                }

                loading.dismiss();
            }

            @Override
            public void onFailure(Call<MainResponse2> call, Throwable t) {
                //  UIHelper.showLongToastInCenter(context_, t.getMessage());
                Log.d("fail", t.getMessage());
                loading.dismiss();

            }
        });

    }
    public void apiResetPass(ResetPassModel signUpModel, final ApiCallBack2 apiCallback) {
        checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final ProgressDialog loading;
        loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse2> signUpResponseCall = apiInterface.apiResetPassword(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse2>() {
            @Override
            public void onResponse(Call<MainResponse2> call, retrofit2.Response<MainResponse2> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                }

                loading.dismiss();
            }

            @Override
            public void onFailure(Call<MainResponse2> call, Throwable t) {
                //  UIHelper.showLongToastInCenter(context_, t.getMessage());
                Log.d("fail", t.getMessage());
                loading.dismiss();

            }
        });

    }
    public void apiGetGiverSkills(GenericGetRequest signUpModel, final ApiCallback apiCallback) {
        checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final ProgressDialog loading;
        loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse> signUpResponseCall = apiInterface.apiGetGiverSkills(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, retrofit2.Response<MainResponse> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
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

    }
    public void apiGetSeniorSkills(GetGiverProfileRequest signUpModel, final ApiCallback apiCallback) {
        checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final ProgressDialog loading;
        loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse> signUpResponseCall = apiInterface.apiGetSeniorSkillsByFilter(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, retrofit2.Response<MainResponse> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
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

    }
    public void apiInsertSeeker(CreateSeekerRequest signUpModel, final ApiCallback apiCallback) {
        checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final ProgressDialog loading;
        loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse> signUpResponseCall = apiInterface.apiInsertSeeker(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, retrofit2.Response<MainResponse> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
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

    }
    public void apiInsertSenior(CreateSeniorRequest signUpModel, final ApiCallback apiCallback) {

        checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final ProgressDialog loading;
        loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse> signUpResponseCall = apiInterface.apiInsertSenior(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, retrofit2.Response<MainResponse> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
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

    }
    public void apiUpdateSenior(CreateSeniorRequest signUpModel, final ApiCallback apiCallback) {

        checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final ProgressDialog loading;
        loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse> signUpResponseCall = apiInterface.apiUpdateSenior(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, retrofit2.Response<MainResponse> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
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

    }
    public void apiGetMessages(GetMaeesageByIdRequest signUpModel, final ApiCallBack2 apiCallback) {
        checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final ProgressDialog loading;
        loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse2> signUpResponseCall = apiInterface.apiGetMessageById(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse2>() {
            @Override
            public void onResponse(Call<MainResponse2> call, retrofit2.Response<MainResponse2> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                }

                loading.dismiss();
            }

            @Override
            public void onFailure(Call<MainResponse2> call, Throwable t) {
                //  UIHelper.showLongToastInCenter(context_, t.getMessage());
                Log.d("fail", t.getMessage());
                loading.dismiss();

            }
        });

    }
    public void apiInsertMessage(CreateMessageRequest signUpModel, final ApiCallback apiCallback) {
        checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
      //  final ProgressDialog loading;
        //loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse> signUpResponseCall = apiInterface.apiInsertMessage(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, retrofit2.Response<MainResponse> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                }

              //  loading.dismiss();
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
                //  UIHelper.showLongToastInCenter(context_, t.getMessage());
                Log.d("fail", t.getMessage());
              //  loading.dismiss();

            }
        });

    }
    public void apiInsertUserImage(UploadImageRequest signUpModel, final ApiCallback apiCallback) {
        checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
       // final ProgressDialog loading;
        //loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse> signUpResponseCall = apiInterface.apiSaveUserImage(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, retrofit2.Response<MainResponse> response) {
                if (response.isSuccessful()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                }

              //  loading.dismiss();
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
                //  UIHelper.showLongToastInCenter(context_, t.getMessage());
                Log.d("fail", t.getMessage());
               // loading.dismiss();

            }
        });

    }
    public void apiInsertSeniorImage(UploadImageRequest signUpModel, final ApiCallback apiCallback) {
        checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
       // final ProgressDialog loading;
        //loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse> signUpResponseCall = apiInterface.apiSaveSeniorImage(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, retrofit2.Response<MainResponse> response) {
                if (response.isSuccessful()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                }

              //  loading.dismiss();
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
                //  UIHelper.showLongToastInCenter(context_, t.getMessage());
                Log.d("fail", t.getMessage());
               // loading.dismiss();

            }
        });

    }

    public void apiGetAllSeekers(GetSeekersRequest signUpModel, final ApiCallBack2 apiCallback) {
        checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final ProgressDialog loading;
        loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse2> signUpResponseCall = apiInterface.apiGetAllSeekers(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse2>() {
            @Override
            public void onResponse(Call<MainResponse2> call, retrofit2.Response<MainResponse2> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                }

                loading.dismiss();
            }

            @Override
            public void onFailure(Call<MainResponse2> call, Throwable t) {
                //  UIHelper.showLongToastInCenter(context_, t.getMessage());
                Log.d("fail", t.getMessage());
                loading.dismiss();

            }
        });

    }
    public void apiGetSeekerById(GetSeekersRequest signUpModel, final ApiCallBack2 apiCallback) {
        checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final ProgressDialog loading;
        loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse2> signUpResponseCall = apiInterface.apiGetSeekerById(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse2>() {
            @Override
            public void onResponse(Call<MainResponse2> call, retrofit2.Response<MainResponse2> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                }

                loading.dismiss();
            }

            @Override
            public void onFailure(Call<MainResponse2> call, Throwable t) {
                //  UIHelper.showLongToastInCenter(context_, t.getMessage());
                Log.d("fail", t.getMessage());
                loading.dismiss();

            }
        });

    }
    public void apiSeniorById(GetSeekersRequest signUpModel, final ApiCallBack2 apiCallback) {
        checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final ProgressDialog loading;
        loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse2> signUpResponseCall = apiInterface.apiGetSeniorById(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse2>() {
            @Override
            public void onResponse(Call<MainResponse2> call, retrofit2.Response<MainResponse2> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                }

                loading.dismiss();
            }

            @Override
            public void onFailure(Call<MainResponse2> call, Throwable t) {
                //  UIHelper.showLongToastInCenter(context_, t.getMessage());
                Log.d("fail", t.getMessage());
                loading.dismiss();

            }
        });

    }
    public void apiSeniorByFilter(GetSeekersRequest signUpModel, final ApiCallBack2 apiCallback) {
        checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final ProgressDialog loading;
        loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse2> signUpResponseCall = apiInterface.apiGetSeniorByFilter(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse2>() {
            @Override
            public void onResponse(Call<MainResponse2> call, retrofit2.Response<MainResponse2> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                }

                loading.dismiss();
            }

            @Override
            public void onFailure(Call<MainResponse2> call, Throwable t) {
                //  UIHelper.showLongToastInCenter(context_, t.getMessage());
                Log.d("fail", t.getMessage());
                loading.dismiss();

            }
        });

    }
    public void apiInsertLanguages(InsertUserLangRequest signUpModel, final ApiCallback apiCallback) {
        //checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
      //  final ProgressDialog loading;
        //loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse> signUpResponseCall = apiInterface.apiInsertUserLanguage(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, retrofit2.Response<MainResponse> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                }

               // loading.dismiss();
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
                //  UIHelper.showLongToastInCenter(context_, t.getMessage());
                Log.d("fail", t.getMessage());
                //loading.dismiss();

            }
        });

    }
    public void apiDeleteLanguages(InsertUserLangRequest signUpModel, final ApiCallback apiCallback) {
        //checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        //  final ProgressDialog loading;
        //loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse> signUpResponseCall = apiInterface.apiDeleteUserLanguage(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, retrofit2.Response<MainResponse> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                }

                // loading.dismiss();
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
                //  UIHelper.showLongToastInCenter(context_, t.getMessage());
                Log.d("fail", t.getMessage());
                //loading.dismiss();

            }
        });

    }
    public void apiInsertSeniorLanguages(InsertUserLangRequest signUpModel, final ApiCallback apiCallback) {
        //checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        //  final ProgressDialog loading;
        //loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse> signUpResponseCall = apiInterface.apiInsertSeniorLanguage(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, retrofit2.Response<MainResponse> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                }

                // loading.dismiss();
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
                //  UIHelper.showLongToastInCenter(context_, t.getMessage());
                Log.d("fail", t.getMessage());
                //loading.dismiss();

            }
        });

    }
    public void apiDeleteSeniorLanguages(InsertUserLangRequest signUpModel, final ApiCallback apiCallback) {
        //checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        //  final ProgressDialog loading;
        //loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse> signUpResponseCall = apiInterface.apiDeleteSeniorLanguage(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, retrofit2.Response<MainResponse> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                }

                // loading.dismiss();
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
                //  UIHelper.showLongToastInCenter(context_, t.getMessage());
                Log.d("fail", t.getMessage());
                //loading.dismiss();

            }
        });

    }
    public void apiInsertUserSkills(InsertGiverSkilsRequest signUpModel, final ApiCallback apiCallback) {
        //checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        //  final ProgressDialog loading;
        //loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse> signUpResponseCall = apiInterface.apiInsertUserSkills(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, retrofit2.Response<MainResponse> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                }

                // loading.dismiss();
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
                //  UIHelper.showLongToastInCenter(context_, t.getMessage());
                Log.d("fail", t.getMessage());
                //loading.dismiss();

            }
        });

    }
    public void apiInsertSeniorSkills(InsertGiverSkilsRequest signUpModel, final ApiCallback apiCallback) {
        //checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        //  final ProgressDialog loading;
        //loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse> signUpResponseCall = apiInterface.apiInsertSeniorSkills(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, retrofit2.Response<MainResponse> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                }

                // loading.dismiss();
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
                //  UIHelper.showLongToastInCenter(context_, t.getMessage());
                Log.d("fail", t.getMessage());
                //loading.dismiss();

            }
        });

    }
    public void apiDeleteUserSkills(InsertGiverSkilsRequest signUpModel, final ApiCallback apiCallback) {
        //checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        //  final ProgressDialog loading;
        //loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse> signUpResponseCall = apiInterface.apiDeleteUserSkills(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, retrofit2.Response<MainResponse> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                }

                // loading.dismiss();
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
                //  UIHelper.showLongToastInCenter(context_, t.getMessage());
                Log.d("fail", t.getMessage());
                //loading.dismiss();

            }
        });

    }
    public void apiDeleteSeniorSkills(InsertGiverSkilsRequest signUpModel, final ApiCallback apiCallback) {
        //checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        //  final ProgressDialog loading;
        //loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse> signUpResponseCall = apiInterface.apiDeleteSeniorSkills(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, retrofit2.Response<MainResponse> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                }

                // loading.dismiss();
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
                //  UIHelper.showLongToastInCenter(context_, t.getMessage());
                Log.d("fail", t.getMessage());
                //loading.dismiss();

            }
        });

    }
    public void apiInsertUserInterest(InsertUserInterestRequest signUpModel, final ApiCallback apiCallback) {
        //checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        //  final ProgressDialog loading;
        //loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse> signUpResponseCall = apiInterface.apiInsertUserInterest(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, retrofit2.Response<MainResponse> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                }

                // loading.dismiss();
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
                //  UIHelper.showLongToastInCenter(context_, t.getMessage());
                Log.d("fail", t.getMessage());
                //loading.dismiss();

            }
        });

    }
    public void apiDeleteInterest(InsertUserInterestRequest signUpModel, final ApiCallback apiCallback) {
        //checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        //  final ProgressDialog loading;
        //loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse> signUpResponseCall = apiInterface.apiDeleteUserInterest(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, retrofit2.Response<MainResponse> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                }

                // loading.dismiss();
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
                //  UIHelper.showLongToastInCenter(context_, t.getMessage());
                Log.d("fail", t.getMessage());
                //loading.dismiss();

            }
        });

    }
    public void apiInsertSeniorInterest(InsertUserInterestRequest signUpModel, final ApiCallback apiCallback) {
        //checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        //  final ProgressDialog loading;
        //loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse> signUpResponseCall = apiInterface.apiInsertSeniorInterest(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, retrofit2.Response<MainResponse> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                }

                // loading.dismiss();
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
                //  UIHelper.showLongToastInCenter(context_, t.getMessage());
                Log.d("fail", t.getMessage());
                //loading.dismiss();

            }
        });

    }
    public void apiDleteSeniorInterest(InsertUserInterestRequest signUpModel, final ApiCallback apiCallback) {
        //checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        //  final ProgressDialog loading;
        //loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse> signUpResponseCall = apiInterface.apiDeleteSeniorInterest(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, retrofit2.Response<MainResponse> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                }

                // loading.dismiss();
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
                //  UIHelper.showLongToastInCenter(context_, t.getMessage());
                Log.d("fail", t.getMessage());
                //loading.dismiss();

            }
        });

    }
    public void apiGetGiverSkillsById(GetGiverSkilsById signUpModel, final ApiCallback apiCallback) {
        checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
       // final ProgressDialog loading;
        //loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse> signUpResponseCall = apiInterface.apiGetGiverSkillsById(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, retrofit2.Response<MainResponse> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                }

                //loading.dismiss();
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
                //  UIHelper.showLongToastInCenter(context_, t.getMessage());
                Log.d("fail", t.getMessage());
              //  loading.dismiss();

            }
        });

    }
    public void apiGetGiverAvailById(GetGiverSkilsById signUpModel, final ApiCallback apiCallback) {
        checkNetworkState();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
      //  final ProgressDialog loading;
       // loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse> signUpResponseCall = apiInterface.apiGetGiverAvailabilityById(signUpModel);
        signUpResponseCall.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, retrofit2.Response<MainResponse> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                }

             //   loading.dismiss();
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
                //  UIHelper.showLongToastInCenter(context_, t.getMessage());
                Log.d("fail", t.getMessage());
               // loading.dismiss();

            }
        });

    }
    public void apiGetThreads( GetUserThread userThread, final ApiCallBack2 apiCallback) {
        checkNetworkState();

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final ProgressDialog loading;
        loading = ProgressDialog.show(context_, context_.getResources().getString(R.string.loading), "", true, false);


        Call<MainResponse2> signUpResponseCall = apiInterface.apiGetMessageThresdById(userThread);
        signUpResponseCall.enqueue(new Callback<MainResponse2>() {
            @Override
            public void onResponse(Call<MainResponse2> call, retrofit2.Response<MainResponse2> response) {
                if (response.isSuccessful() && response.body().isStatus()) {
                    // UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                    apiCallback.onSuccess(response.body());

                }else {
                    //   UIHelper.showLongToastInCenter(context_, response.body().getStoreResponse().getMessage());
                }

                loading.dismiss();
            }

            @Override
            public void onFailure(Call<MainResponse2> call, Throwable t) {
                //  UIHelper.showLongToastInCenter(context_, t.getMessage());
                Log.d("fail", t.getMessage());
                loading.dismiss();

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
