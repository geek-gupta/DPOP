package com.example.d_pop.network;

import com.example.d_pop.model.ProjectBaseModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetAPIServices {


    @GET("/getallprojects")
    Call<ArrayList<ProjectBaseModel>> getAllProjects();
}
