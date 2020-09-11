package com.pyropy.gadstracker;

import com.pyropy.gadstracker.Services.UserService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit getRetrofit(){
        //HttpLoggingInterceptor uInterceptor =  new HttpLoggingInterceptor();
        //uInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        //OkHttpClient uOkHttpClient = new OkHttpClient.Builder().addInterceptor(uInterceptor).build();

        Retrofit uRetrofit = new Retrofit.Builder()
                .baseUrl("https://docs.google.com/forms/d/e/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return uRetrofit;
    }

    public static UserService getUserService(){
        UserService uUserService = getRetrofit().create(UserService.class);
        return uUserService;
    }

}
