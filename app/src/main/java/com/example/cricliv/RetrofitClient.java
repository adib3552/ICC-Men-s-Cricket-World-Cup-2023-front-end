package com.example.cricliv;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static Retrofit retrofit;
    private static final String base_url = "http://192.168.0.104:4006/";


    public static Retrofit getretrofit()
    {
       if (retrofit==null)
       {
           retrofit= new Retrofit.Builder().baseUrl("base_url").addConverterFactory(GsonConverterFactory.create()).build();
       }
       return retrofit;
    }
}
