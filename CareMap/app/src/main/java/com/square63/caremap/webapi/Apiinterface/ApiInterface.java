package com.square63.caremap.webapi.Apiinterface;


import com.square63.caremap.webapi.CreateGiverRequest;
import com.square63.caremap.webapi.responses.CreateCareGiverResponse;
import com.square63.caremap.webapi.responses.MainResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterface {

    interface Request {
        String REGISTER = "/api/services/app/caregiver/InsertCaregiver";
        String EMAIL_EXIST ="account/checkIfEmailExists";

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

    }
    @POST(Request.REGISTER)
    Call<CreateCareGiverResponse> apiRegister(CreateGiverRequest createGiverRequest);
    @POST(Request.EMAIL_EXIST)
    Call<MainResponse> apiEmailValidation(RequestBody requestBody);
}
