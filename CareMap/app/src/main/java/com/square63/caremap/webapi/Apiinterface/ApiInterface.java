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
import com.square63.caremap.webapi.requests.GetGiverSkilsById;
import com.square63.caremap.webapi.requests.GetMaeesageByIdRequest;
import com.square63.caremap.webapi.requests.GetSeekersRequest;
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
import com.square63.caremap.webapi.responses.GiverResultResponse;
import com.square63.caremap.webapi.responses.MainResponse;
import com.square63.caremap.webapi.responses.MainResponse2;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

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
        String GET_ALL_SEEKERS = "api/services/app/senior/GetSeniorsByFilter";
        String GET_SENIOR_BY_ID = "api/services/app/senior/GetSeniorById";
        String INSERT_GIVER_LANGUAGES = "api/services/app/userLanguage/InsertUserLanguage";
        String GET_GIVER_SKILLS = "api/services/app/caregiverSkills/GetCaregiverSkillsByFilter";
        String INSERT_SENIOR_LANGUAGES ="api/services/app/seniorLanguage/InsertSeniorLanguage";
        String INSERT_SENIOR_INTEREST ="api/services/app/seniorInterest/InsertSeniorInterest";
        String INSERT_SENIOR_SKILLS = "api/services/app/seniorSkills/InsertSeniorSkills";
        String GET_SENIOR_LANGUAGE_BY_ID = "api/services/app/seniorLanguage/getSeniorLanguagesByFilter";
        String SAVE_USER_IMAGE = "home/saveProfileImage";
        String GET_SEEKER_BY_FILTER = "api/services/app/careseeker/GetCareseekersByFilter";
        String GET_AVAILABILITY_BY_FILTER = " api/services/app/availability/GetAvailabilitiesByFilter";




    }
    @POST(Request.REGISTER)
    Call<MainResponse> apiRegister(@Body CreateGiverRequest createGiverRequest);
    @POST(Request.LOGIN)
    Call<MainResponse> apiLogin(@Body LoginModel createGiverRequest);

    @POST(Request.EMAIL_EXIST)
    Call<MainResponse> apiEmailValidation(@Body RequestBody requestBody);
    @POST(Request.INSERT_USER_LANG)
    Call<MainResponse> apiInsertUserLanguage(@Body InsertUserLangRequest userLangRequest);
    @POST(Request.INSERT_CARE_GIVER_SKILLS)
    Call<MainResponse> apiInsertUserSkills(@Body InsertGiverSkilsRequest userLangRequest);

    @POST(Request.INSERT_USER_INTEREST)
    Call<MainResponse> apiInsertUserInterest(@Body InsertUserInterestRequest userLangRequest);

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
    @POST(Request.GET_GIVER_SKILLS)
    Call<MainResponse> apiGetGiverSkillsByFilter(@Body GenericGetRequest request);
    @POST(Request.GET_CARE_GIVERS)
    Call<MainResponse> apiGetAllGiver(@Body GiverRequest request);
    @POST(Request.GET_GIVER_BY_ID)
    Call<MainResponse> apiGetGiverById(@Body GetGiverProfileRequest request);
    @POST(Request.GET_GIVER_LANGUAGE_BY_ID)
    Call<MainResponse> apiGetGiverLanguageById(@Body GetGiverLanguageRequest request);
    @POST(Request.GET_SENIOR_LANGUAGE_BY_ID)
    Call<MainResponse> apiGetSeniorLanguageById(@Body GetGiverLanguageRequest request);
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
    @POST(Request.GET_ALL_SEEKERS)
    Call<MainResponse2> apiGetAllSeekers(@Body GetSeekersRequest request);

    @POST(Request.GET_SEEKER_BY_FILTER)
    Call<MainResponse2> apiGetSeekerById(@Body GetSeekersRequest request);
    @POST(Request.GET_SENIOR_BY_ID)
    Call<MainResponse2> apiGetSeniorById(@Body GetSeekersRequest request);

    @POST(Request.GET_GIVER_SKILLS)
    Call<MainResponse> apiGetGiverSkillsById(@Body GetGiverSkilsById request);
    @POST(Request.GET_AVAILABILITY_BY_FILTER)
    Call<MainResponse> apiGetGiverAvailabilityById(@Body GetGiverSkilsById request);
    //Senior

    @POST(Request.INSERT_SENIOR_LANGUAGES)
    Call<MainResponse> apiInsertSeniorLanguage(@Body InsertUserLangRequest userLangRequest);
    @POST(Request.INSERT_SENIOR_SKILLS)
    Call<MainResponse> apiInsertSeniorSkills(@Body InsertGiverSkilsRequest userLangRequest);

    @POST(Request.INSERT_SENIOR_INTEREST)
    Call<MainResponse> apiInsertSeniorInterest(@Body InsertUserInterestRequest userLangRequest);

    @POST(Request.SAVE_USER_IMAGE)
    //@Headers("Content-Type: application/x-www-form-urlencoded")
    Call<MainResponse> apiSaveUserImage(@Body  UploadImageRequest uploadImageRequest
    );

}
