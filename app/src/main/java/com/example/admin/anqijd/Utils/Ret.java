package com.example.admin.anqijd.Utils;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author:Created by WangZhiQiang on 2018-6-14.
 */
public class Ret {

    private String getBaseUrl = "https://www.zhaoapi.cn/";
    private static Ret ret;

    public static Ret getInstance(){
        if(ret==null){
            ret = new Ret();
        }
        return  ret;

    }

               OkHttpClient okHttpClient = new OkHttpClient.Builder()
              .connectTimeout(5000, TimeUnit.MILLISECONDS)
              .readTimeout(5000,TimeUnit.MILLISECONDS)
              .build();


               Retrofit retrofit=new Retrofit.Builder()
               .baseUrl(getBaseUrl)
               .addConverterFactory(GsonConverterFactory.create())
               .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
               .client(okHttpClient)
               .build();

    public Retrofit getRetrofit() {

        return retrofit;
    }
}