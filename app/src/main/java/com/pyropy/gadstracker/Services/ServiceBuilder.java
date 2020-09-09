package com.pyropy.gadstracker.Services;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceBuilder {

    //Logger
    //private static HttpLoggingInterceptor sLoggingInterceptor = new HttpLoggingInterceptor()
            //.setLevel(HttpLoggingInterceptor.Level.BODY);


    private static final String URL = "https://gadsapi.herokuapp.com/";

    private static Retrofit.Builder sBuilder = new Retrofit.Builder().baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit sRetrofit = sBuilder.build();

    public static <S> S buildService(Class<S> serviceType){
        return sRetrofit.create(serviceType);
    }
}
