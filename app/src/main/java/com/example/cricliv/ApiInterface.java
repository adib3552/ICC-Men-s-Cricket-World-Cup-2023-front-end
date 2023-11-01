package com.example.cricliv;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
     @FormUrlEncoded
     @POST("/auth/save")
     Call<String> saveuser(@Field("first_name") String first_name,
                           @Field("last_name") String last_name,
                           @Field("email") String email,
                           @Field("password") String password,
                           @Field("mobile_no") long mobile_no);




}
