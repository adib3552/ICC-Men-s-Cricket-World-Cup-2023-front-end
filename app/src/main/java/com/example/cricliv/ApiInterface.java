package com.example.cricliv;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
     @POST("/auth/save")
     Call<User> saveuser(@Body User user);//direct class akare nibi code kom lage




}
