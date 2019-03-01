package com.square63.caremap.webapi.Apiinterface;


import com.square63.caremap.models.EducationModel;
import com.square63.caremap.models.LicenseModel;
import com.square63.caremap.models.LoginModel;
import com.square63.caremap.models.chatModule.CreateMessageRequest;
import com.square63.caremap.models.seekerModels.CreateSeekerRequest;
import com.square63.caremap.models.seekerModels.CreateSeniorRequest;
import com.square63.caremap.webapi.CreateGiverRequest;
import com.square63.caremap.webapi.requests.GenericGetRequest;
import com.square63.caremap.webapi.requests.GetGiverInterestById;
import com.square63.caremap.webapi.requests.GetGiverLanguageRequest;
import com.square63.caremap.webapi.requests.GetGiverProfileRequest;
import com.square63.caremap.webapi.requests.GetMaeesageByIdRequest;
import com.square63.caremap.webapi.requests.GiverRequest;
import com.square63.caremap.webapi.requests.InsertAvailabilityRequest;
import com.square63.caremap.webapi.requests.InsertGiverEducationRequest;
import com.square63.caremap.webapi.requests.InsertGiverExperienceRequest;
import com.square63.caremap.webapi.requests.InsertGiverLicenseRequest;
import com.square63.caremap.webapi.requests.InsertUserLangRequest;
import com.square63.caremap.webapi.requests.LoginRequest;
import com.square63.caremap.webapi.responses.CreateCareGiverResponse;
import com.square63.caremap.webapi.responses.MainResponse;
import com.square63.caremap.webapi.responses.MainResponse2;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterface {

    interface Request {
        String REGISTER = "/api/services/app/caregiver/InsertCaregiver";
        String LOGIN = "/account/login";
        String EMAIL_EXIST ="/account/checkIfEmailExists";

        String GET_ALL_LANGUAGES = "/api/services/app/language/GetAll";
        String GET_ALL_SKILLS = "/api/services/app/skill/GetAll";
        String GET_ALL_INTERESTS = "/api/services/app/userInterest/getAll";
        String INSERT_USER_LANG   ="api/services/app/userLanguage/InsertUserLanguage";
        String INSERT_USER_INTEREST ="api/services/app/userInterest/InsertUserInterest";
        String INSERT_CARE_GIVER_SKILLS = "/api/services/app/caregiverSkills/InsertCaregiverSkills";
        String INSERTS_GIVER_EDUCATION="/api/services/app/caregiverEducation/InsertCaregiverEducation";
        String INSERT_GIVER_EXPERIENCE = "api/services/app/caregiverExperience/InsertCaregiverExperience";
        String INSERT_GIVER_LICENSE ="/api/services/app/caregiverLicense/InsertCaregiverLicense";
        String INSERT_AVAILABILITY = "api/services/app/availability/InsertAvailability";
        String INSET_CARE_SEEKER ="api/services/app/careseeker/InsertCareseeker";
        String GET_CARE_GIVERS = "api/services/app/caregiver/GetCaregiversByFilter";
        String GET_GIVER_BY_ID ="api/services/app/user/GetUsersByFilter";
        String GET_GIVER_LANGUAGE_BY_ID ="api/services/app/userLanguage/GetUserLanguagesByFilter";
        String GET_GIVER_INTEREST_BY_ID = "api/services/app/userInterest/GetUserInterestsByFilter";
        String INSERT_SEEKER = " api/services/app/careseeker/InsertCareseeker";
        String INSERT_SENIOR = "api/services/app/senior/InsertSenior";
        String GET_MESSAGE_BY_ID = "api/services/app/message/GetMessagesByFilter";
        String GET_MESSAGE_THREAD_BY_ID = "api/services/app/message/GetMessageThreadsByUser";
        String INSERT_MESSAGE ="api/services/app/message/InsertMessage";



    }
    @POST(Request.REGISTER)
    Call<MainResponse> apiRegister(@Body CreateGiverRequest createGiverRequest);
    @POST(Request.LOGIN)
    Call<MainResponse> apiLogin(@Body LoginModel createGiverRequest);

    @POST(Request.EMAIL_EXIST)
    Call<MainResponse> apiEmailValidation(@Body RequestBody requestBody);
    @POST(Request.INSERT_USER_LANG)
    Call<MainResponse> apiInsertUserLanguage(@Body InsertUserLangRequest userLangRequest);
    @POST(Request.GET_ALL_LANGUAGES)
    Call<MainResponse> apiGetUserLanguage(@Body GenericGetRequest userLangRequest);
    @POST(Request.GET_ALL_INTERESTS)
    Call<MainResponse> apiGetUserInterests(@Body GenericGetRequest userLangRequest);

    @POST(Request.INSERTS_GIVER_EDUCATION)
    Call<MainResponse> apiInsertEducation(@Body EducationModel request);

    @POST(Request.INSERT_GIVER_LICENSE)
    Call<MainResponse> apiInsertLicense(@Body LicenseModel request);
    @POST(Request.INSERT_GIVER_EXPERIENCE)
    Call<MainResponse> apiInsertExperience(@Body InsertGiverExperienceRequest request);

    @POST(Request.INSERT_AVAILABILITY)
    Call<MainResponse> apiInsertAvailability(@Body InsertAvailabilityRequest request);
    @POST(Request.GET_ALL_SKILLS)
    Call<MainResponse> apiGetGiverSkills(@Body GenericGetRequest request);
    @POST(Request.GET_CARE_GIVERS)
    Call<MainResponse> apiGetAllGiver(@Body GiverRequest request);
    @POST(Request.GET_GIVER_BY_ID)
    Call<MainResponse> apiGetGiverById(@Body GetGiverProfileRequest request);
    @POST(Request.GET_GIVER_LANGUAGE_BY_ID)
    Call<MainResponse> apiGetGiverLanguageById(@Body GetGiverLanguageRequest request);
    @POST(Request.GET_GIVER_INTEREST_BY_ID)
    Call<MainResponse2> apiGetGiverInterestById(@Body GetGiverInterestById request);
    @POST(Request.INSERT_SEEKER)
    Call<MainResponse> apiInsertSeeker(@Body CreateSeekerRequest request);
    @POST(Request.INSERT_SENIOR)
    Call<MainResponse> apiInsertSenior(@Body CreateSeniorRequest request);

    @POST(Request.GET_MESSAGE_BY_ID)
    Call<MainResponse2> apiGetMessageById(@Body GetMaeesageByIdRequest request);
    @POST(Request.GET_MESSAGE_THREAD_BY_ID)
    Call<MainResponse> apiGetMessageThresdById(@Body GetMaeesageByIdRequest request);

    @POST(Request.INSERT_MESSAGE)
    Call<MainResponse> apiInsertMessage(@Body CreateMessageRequest request);



}
