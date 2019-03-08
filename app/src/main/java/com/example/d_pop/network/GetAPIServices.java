package com.example.d_pop.network;

import com.example.d_pop.model.LoginModel;
import com.example.d_pop.model.ProjectBaseModel;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetAPIServices {


    @GET("/getallprojects")
    Call<ArrayList<ProjectBaseModel>> getAllProjects(@Query("projectType") String projectType);

    @GET("/attemptLogin")
    Call<LoginModel> attempLogin(@Query("userName") String userName, @Query("password") String password, @Query("isStudent") boolean isStudent);
}
