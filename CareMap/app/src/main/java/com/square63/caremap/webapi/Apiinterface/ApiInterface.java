package com.square63.caremap.webapi.Apiinterface;


import com.square63.caremap.models.EducationModel;
import com.square63.caremap.models.LicenseModel;
import com.square63.caremap.models.LoginModel;
import com.square63.caremap.models.ResetPassModel;
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
import com.square63.caremap.webapi.responses.GiverResultResponse;
import com.square63.caremap.webapi.responses.MainResponse;
import com.square63.caremap.webapi.responses.MainResponse2;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ApiInterface {

    interface Request {
        String REGISTER = "api/services/app/caregiver/InsertCaregiver";
        String LOGIN = "account/login";
        String EMAIL_EXIST = "account/checkIfEmailExists";

        String GET_ALL_LANGUAGES = "api/services/app/language/GetAll";
        String GET_ALL_SKILLS = "api/services/app/skill/GetAll";
        String GET_ALL_INTERESTS = "/api/services/app/userInterest/getAll";
        String INSERT_USER_LANG = "api/services/app/userLanguage/InsertUserLanguage";
        String INSERT_USER_INTEREST = "api/services/app/userInterest/InsertUserInterest";
        String INSERT_CARE_GIVER_SKILLS = "api/services/app/caregiverSkills/InsertCaregiverSkills";
        String INSERTS_GIVER_EDUCATION = "api/services/app/caregiverEducation/InsertCaregiverEducation";
        String INSERT_GIVER_EXPERIENCE = "api/services/app/caregiverExperience/InsertCaregiverExperience";
        String INSERT_GIVER_LICENSE = "api/services/app/caregiverLicense/InsertCaregiverLicense";
        String INSERT_AVAILABILITY = "api/services/app/availability/InsertAvailability";
        String INSET_CARE_SEEKER = "api/services/app/careseeker/InsertCareseeker";
        String GET_CARE_GIVERS = "api/services/app/caregiver/GetCaregiversByFilter";
        String GET_GIVER_BY_ID = "api/services/app/user/GetUsersByFilter";
        String GET_GIVER_LANGUAGE_BY_ID = "api/services/app/userLanguage/GetUserLanguagesByFilter";
        String GET_GIVER_INTEREST_BY_ID = "api/services/app/userInterest/GetUserInterestsByFilter";
        String INSERT_SEEKER = " api/services/app/careseeker/InsertCareseeker";
        String INSERT_SENIOR = "api/services/app/senior/InsertSenior";
        String GET_MESSAGE_BY_ID = "api/services/app/message/GetMessagesByFilter";
        String GET_MESSAGE_THREAD_BY_ID = "api/services/app/message/GetMessageThreadsByUser";
        String INSERT_MESSAGE = "api/services/app/message/InsertMessage";
        String GET_ALL_SEEKERS = "api/services/app/senior/GetSeniorsByFilter";
        String GET_SENIOR_BY_ID = "api/services/app/senior/GetSeniorById";
        String INSERT_GIVER_LANGUAGES = "api/services/app/userLanguage/InsertUserLanguage";
        String GET_GIVER_SKILLS = "api/services/app/caregiverSkills/GetCaregiverSkillsByFilter";

        String GET_SENIOR_SKILLS = " api/services/app/seniorSkills/GetSeniorSkillsByFilter";


        String INSERT_SENIOR_LANGUAGES = "api/services/app/seniorLanguage/InsertSeniorLanguage";
        String INSERT_SENIOR_INTEREST = "api/services/app/seniorInterest/InsertSeniorInterest";
        String INSERT_SENIOR_SKILLS = "api/services/app/seniorSkills/InsertSeniorSkills";
        String GET_SENIOR_LANGUAGE_BY_ID = "api/services/app/seniorLanguage/getSeniorLanguagesByFilter";
        String SAVE_USER_IMAGE = "home/saveProfileImage";
        String SAVE_SENIOR_IMAGE = "/home/saveSeniorImage";
        String GET_SEEKER_BY_FILTER = "api/services/app/careseeker/GetCareseekersByFilter";
        String GET_SENIOR_BY_FILTER = "api/services/app/senior/GetSeniorsByFilter";
        String GET_AVAILABILITY_BY_FILTER = " api/services/app/availability/GetAvailabilitiesByFilter";
        String GET_SENIOR_INTEREST = "api/services/app/seniorInterest/GetSeniorInterestsByFilter";

        String UPDATE_CARE_GIVER = "api/services/app/caregiver/UpdateCaregiver";
        String DELETE_USER_INTERESTS = "api/services/app/userInterest/DeleteUserInterest";
        String DELETE_GIVER_SKILLS = "api/services/app/caregiverSkills/DeleteCaregiverSkills";
        String DELETE_AVAILABILITY = "api/services/app/availability/DeleteAvailability";
        String DELETE_GIVER_EDUCATION = "api/services/app/caregiverEducation/DeleteCaregiverEducation";
        String DELETE_GIVER_LICENSE = "api/services/app/caregiverLicense/DeleteCaregiverLicense";
        String GET_GIVER_EDUCATION = "api/services/app/caregiverEducation/GetCaregiverEducationsByFilter";
        String GET_GIVER_LICENSE = "api/services/app/caregiverLicense/GetCaregiverLicensesByFilter";

        String UPDATE_SENIOR = "api/services/app/senior/UpdateSenior";
        String DELETE_SENIOR_INTEREST = "api/services/app/seniorInterest/DeleteSeniorInterest";
        String DELETE_SENIOR_LANGUAGE = "api/services/app/seniorLanguage/DeleteSeniorLanguage";
        String DELETE_USER_LANGUAGE = "api/services/app/userLanguage/DeleteUserLanguage";
        String DELETE_SENIOR_SKILLS = "api/services/app/seniorSkills/DeleteSeniorSkills";
        String RESET_PASSWORD = "api/services/app/user/ResetpassUser";




    }

    @POST(Request.REGISTER)
    Call<MainResponse> apiRegister(@Body CreateGiverRequest createGiverRequest);

    @POST(Request.UPDATE_CARE_GIVER)
    Call<MainResponse> apiUpdateGiver(@Body CreateGiverRequest createGiverRequest);

    @POST(Request.LOGIN)
    Call<MainResponse> apiLogin(@Body LoginModel createGiverRequest);

    @POST(Request.EMAIL_EXIST)
    Call<MainResponse> apiEmailValidation(@Body RequestBody requestBody);

    @POST(Request.INSERT_USER_LANG)
    Call<MainResponse> apiInsertUserLanguage(@Body InsertUserLangRequest userLangRequest);
    @HTTP(method = "DELETE", path = Request.DELETE_USER_LANGUAGE, hasBody = true)
    Call<MainResponse> apiDeleteUserLanguage(@Body InsertUserLangRequest userLangRequest);

    @POST(Request.INSERT_CARE_GIVER_SKILLS)
    Call<MainResponse> apiInsertUserSkills(@Body InsertGiverSkilsRequest userLangRequest);

    @HTTP(method = "DELETE", path = Request.DELETE_GIVER_SKILLS, hasBody = true)
    Call<MainResponse> apiDeleteUserSkills(@Body InsertGiverSkilsRequest userLangRequest);
    @HTTP(method = "DELETE", path = Request.DELETE_SENIOR_SKILLS, hasBody = true)
    Call<MainResponse> apiDeleteSeniorSkills(@Body InsertGiverSkilsRequest userLangRequest);

    @POST(Request.INSERT_USER_INTEREST)
    Call<MainResponse> apiInsertUserInterest(@Body InsertUserInterestRequest userLangRequest);

    @HTTP(method = "DELETE", path = Request.DELETE_USER_INTERESTS, hasBody = true)
    Call<MainResponse> apiDeleteUserInterest(@Body InsertUserInterestRequest userLangRequest);

    @POST(Request.GET_ALL_LANGUAGES)
    Call<MainResponse> apiGetUserLanguage(@Body GenericGetRequest userLangRequest);

    @POST(Request.GET_ALL_INTERESTS)
    Call<MainResponse> apiGetUserInterests(@Body GenericGetRequest userLangRequest);

    @POST(Request.INSERTS_GIVER_EDUCATION)
    Call<MainResponse> apiInsertEducation(@Body EducationModel request);

    @HTTP(method = "DELETE", path = Request.DELETE_GIVER_EDUCATION, hasBody = true)
    Call<MainResponse> apiDeleteEducation(@Body EducationModel request);

    @POST(Request.INSERT_GIVER_LICENSE)
    Call<MainResponse> apiInsertLicense(@Body LicenseModel request);

    @HTTP(method = "DELETE", path = Request.DELETE_GIVER_LICENSE, hasBody = true)
    Call<MainResponse> apiDeleteLicense(@Body LicenseModel request);

    @POST(Request.INSERT_GIVER_EXPERIENCE)
    Call<MainResponse> apiInsertExperience(@Body InsertGiverExperienceRequest request);

    @POST(Request.INSERT_AVAILABILITY)
    Call<MainResponse> apiInsertAvailability(@Body InsertAvailabilityRequest request);

    @POST(Request.DELETE_AVAILABILITY)
    Call<MainResponse> apiDeleteAvailability(@Body InsertAvailabilityRequest request);

    @POST(Request.GET_ALL_SKILLS)
    Call<MainResponse> apiGetGiverSkills(@Body GenericGetRequest request);

    @POST(Request.GET_GIVER_SKILLS)
    Call<MainResponse> apiGetGiverSkillsByFilter(@Body GenericGetRequest request);
    @POST(Request.GET_SENIOR_SKILLS)
    Call<MainResponse> apiGetSeniorSkillsByFilter(@Body GetGiverProfileRequest request);

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

    @POST(Request.UPDATE_SENIOR)
    Call<MainResponse> apiUpdateSenior(@Body CreateSeniorRequest request);

    @POST(Request.GET_MESSAGE_BY_ID)
    Call<MainResponse2> apiGetMessageById(@Body GetMaeesageByIdRequest request);

    @POST(Request.GET_MESSAGE_THREAD_BY_ID)
    Call<MainResponse2> apiGetMessageThresdById(@Body GetUserThread request);

    @POST(Request.INSERT_MESSAGE)
    Call<MainResponse> apiInsertMessage(@Body CreateMessageRequest request);

    @POST(Request.GET_ALL_SEEKERS)
    Call<MainResponse2> apiGetAllSeekers(@Body GetSeekersRequest request);

    @POST(Request.GET_SEEKER_BY_FILTER)
    Call<MainResponse2> apiGetSeekerById(@Body GetSeekersRequest request);

    @POST(Request.GET_SENIOR_BY_FILTER)
    Call<MainResponse2> apiGetSeniorByFilter(@Body GetSeekersRequest request);

    @POST(Request.GET_SENIOR_BY_ID)
    Call<MainResponse2> apiGetSeniorById(@Body GetSeekersRequest request);

    @POST(Request.GET_GIVER_SKILLS)
    Call<MainResponse> apiGetGiverSkillsById(@Body GetGiverSkilsById request);

    @POST(Request.GET_AVAILABILITY_BY_FILTER)
    Call<MainResponse> apiGetGiverAvailabilityById(@Body GetGiverSkilsById request);
    //Senior

    @POST(Request.INSERT_SENIOR_LANGUAGES)
    Call<MainResponse> apiInsertSeniorLanguage(@Body InsertUserLangRequest userLangRequest);

    @HTTP(method = "DELETE", path = Request.DELETE_SENIOR_LANGUAGE, hasBody = true)
    Call<MainResponse> apiDeleteSeniorLanguage(@Body InsertUserLangRequest userLangRequest);

    @POST(Request.INSERT_SENIOR_SKILLS)
    Call<MainResponse> apiInsertSeniorSkills(@Body InsertGiverSkilsRequest userLangRequest);

    @POST(Request.INSERT_SENIOR_INTEREST)
    Call<MainResponse> apiInsertSeniorInterest(@Body InsertUserInterestRequest userLangRequest);

    @HTTP(method = "DELETE", path = Request.DELETE_SENIOR_INTEREST, hasBody = true)
    Call<MainResponse> apiDeleteSeniorInterest(@Body InsertUserInterestRequest userLangRequest);

    @POST(Request.SAVE_USER_IMAGE)
        //@Headers("Content-Type: application/x-www-form-urlencoded")
    Call<MainResponse> apiSaveUserImage(@Body UploadImageRequest uploadImageRequest
    );
    @POST(Request.SAVE_SENIOR_IMAGE)
        //@Headers("Content-Type: application/x-www-form-urlencoded")
    Call<MainResponse> apiSaveSeniorImage(@Body UploadImageRequest uploadImageRequest
    );

    @POST(Request.GET_SENIOR_INTEREST)
    Call<MainResponse2> apiGetSeniorInterests(@Body GetSeekersRequest userLangRequest);
    @POST(Request.RESET_PASSWORD)
    Call<MainResponse2> apiResetPassword(@Body ResetPassModel userLangRequest);

    @POST(Request.GET_GIVER_EDUCATION)
    Call<MainResponse2> apiGetGiverEducation(@Body GetGiverProfileRequest request);
    @POST(Request.GET_GIVER_LICENSE)
    Call<MainResponse2> apiGetGiverLicense(@Body GetGiverProfileRequest request);

}
