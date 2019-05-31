package com.example.d_pop.network;

import com.example.d_pop.model.LoginModel;
import com.example.d_pop.model.NotesBaseCategoryModel;
import com.example.d_pop.model.NotesSubCategoryModel;
import com.example.d_pop.model.ProjectBaseModel;
import com.example.d_pop.model.ProjectCategoryBaseModel;
import com.example.d_pop.model.QueryModel;
import com.example.d_pop.model.RecentNotesModel;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetAPIServices {

    @GET("/getAllCategories")
    Call<ProjectCategoryBaseModel> getAllCategories();

    @GET("/getallprojects")
    Call<ArrayList<ProjectBaseModel>> getAllProjects(@Query("projectType") String projectType);

    @GET("/attemptLogin")
    Call<LoginModel> attempLogin(@Query("userName") String userName, @Query("password") String password, @Query("isStudent") boolean isStudent);

    @GET("/getNotesBaseCategories")
    Call<NotesBaseCategoryModel> getNotesBaseCategories();

    @GET("/getRecentNotesList")
    Call<RecentNotesModel> getRecentNotesList();

    @GET("/getNotes")
    Call<ArrayList<NotesSubCategoryModel>> getNotes(@Query("category") String categoryType);

    @GET("/getPDF")
    Call<ResponseBody> getPDF(@Query("pdfName") String pdfName);

    @GET("/getQueries")
    Call<ArrayList<QueryModel>> getAllQueries();
}
