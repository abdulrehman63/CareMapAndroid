package com.square63.caremap.webapi;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Samran on 2/17/2017.
 */



public class ApiClient  {

    //public static final String BASE_URL = "https://www.ucarenet.com/";
    public static final String BASE_URL = "http://ucarenet-staging.azurewebsites.net/";

    private static Retrofit retrofit = null;
    public static Retrofit getClient() {

        if (retrofit==null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor)
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .readTimeout(100,TimeUnit.SECONDS).build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).client(client)

                    .build();
        }

        return retrofit;
    }


}
