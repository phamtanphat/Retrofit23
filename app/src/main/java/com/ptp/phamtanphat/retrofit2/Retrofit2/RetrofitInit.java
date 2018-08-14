package com.ptp.phamtanphat.retrofit2.Retrofit2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitInit {
    // Chuc nang class se cau hinh retrofit de cho nguoi dung su dung
    public static Retrofit retrofit = null;

    public static Retrofit getRetrofit(String url){

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                                    .readTimeout(10, TimeUnit.SECONDS)
                                    .writeTimeout(10,TimeUnit.SECONDS)
                                    .connectTimeout(10,TimeUnit.SECONDS)
                                    .retryOnConnectionFailure(true)
                                    .protocols(Arrays.asList(Protocol.HTTP_1_1))
                                    .build();
        // Bo chuyen doi json thanh gson
        Gson gson = new GsonBuilder().setLenient().create();

        retrofit = new  Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        return retrofit;
    }
}
