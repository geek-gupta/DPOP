package com.example.d_pop.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.d_pop.R;
import com.example.d_pop.adapter.NotesSubCategoryAdapter;
import com.example.d_pop.model.NotesSubCategoryModel;
import com.example.d_pop.network.GetAPIServices;
import com.example.d_pop.network.RetrofitAPIClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotesSubCategoryActivity extends AppCompatActivity {

    private RecyclerView mSubNotesRecyclerView;
    private ArrayList<NotesSubCategoryModel> mNotesSubCategoryModel;
    private NotesSubCategoryAdapter mNotesSubCategoryAdapter;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_sub_category);

        mSubNotesRecyclerView = findViewById(R.id.notes_sub_category_recycler_view);
        mNotesSubCategoryModel = new ArrayList<>();
        intent = getIntent();
        String categoryType = intent.getStringExtra("categoryType");
        getSupportActionBar().setTitle(categoryType + " Notes");

        getNotes(categoryType);

    }

    private void getNotes(String categoryType) {
        GetAPIServices service = RetrofitAPIClient.getRetrofitInstance().create(GetAPIServices.class);
        Call<ArrayList<NotesSubCategoryModel>> call = service.getNotes(categoryType);
        call.enqueue(new Callback<ArrayList<NotesSubCategoryModel>>() {
            @Override
            public void onResponse(Call<ArrayList<NotesSubCategoryModel>> call, Response<ArrayList<NotesSubCategoryModel>> response) {

                mNotesSubCategoryModel = response.body();
                Log.i("ResponseNotes", "onResponse: "+response.body().get(0));
                mNotesSubCategoryAdapter = new NotesSubCategoryAdapter(mNotesSubCategoryModel, getBaseContext());
                mSubNotesRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                mSubNotesRecyclerView.setAdapter(mNotesSubCategoryAdapter);

            }

            @Override
            public void onFailure(Call<ArrayList<NotesSubCategoryModel>> call, Throwable t) {
                Toast.makeText(getBaseContext(), "Retrofit Failure", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
