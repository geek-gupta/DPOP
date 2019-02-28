package com.example.d_pop.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.d_pop.R;
import com.example.d_pop.adapter.ProjectBaseAdapter;
import com.example.d_pop.model.ProjectBaseModel;
import com.example.d_pop.network.GetAPIServices;
import com.example.d_pop.network.RetrofitAPIClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeTabFragFour extends Fragment implements AdapterView.OnItemSelectedListener {

    private Spinner spinner = null;
    private ProjectBaseAdapter mProjectBaseAdapter;
    private ArrayList<ProjectBaseModel> mProjectBaseModelArraList;
    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.home_tab_frag_four, container, false);
        spinner = view.findViewById(R.id.project_spinner);
        List<String> categories = new ArrayList<>();
        categories.add("All");
        categories.add("Big Data");
        categories.add("Android");
        categories.add("Web Technology");
        categories.add("AI");
        categories.add("Data Science");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(this);
        mProjectBaseModelArraList = new ArrayList<>();
        mRecyclerView = view.findViewById(R.id.project_recyclerview);


//        GetAPIServices service = RetrofitAPIClient.getRetrofitInstance().create(GetAPIServices.class);
//        Call<ArrayList<ProjectBaseModel>> call = service.getAllProjects();
//        call.enqueue(new Callback<ArrayList<ProjectBaseModel>>() {
//            @Override
//            public void onResponse(Call<ArrayList<ProjectBaseModel>> call, Response<ArrayList<ProjectBaseModel>> response) {
//                Log.i("Projects", "onResponse: " + response.body());
//                mProjectBaseModelArraList = response.body();
//                mProjectBaseAdapter = new ProjectBaseAdapter(mProjectBaseModelArraList, getContext());
//                mRecyclerView.setAdapter(mProjectBaseAdapter);
//                mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<ProjectBaseModel>> call, Throwable t) {
//                Toast.makeText(getContext(), "Retrofit Failure", Toast.LENGTH_SHORT).show();
//            }
//        });

        mProjectBaseModelArraList.add(new ProjectBaseModel("Department App",
                "Owned By: Gaurav & Lokesh", "27/02/19",
                "This is the short description of the project.",75, true, "Android"));
        mProjectBaseModelArraList.add(new ProjectBaseModel("Emotion Calculator",
                "Owned By: Gaurav", "27/02/19",
                "This is the short description of the project.",50, true, "Android"));
        mProjectBaseModelArraList.add(new ProjectBaseModel("Traffic Manager",
                "Owned By: Lokesh", "27/02/19",
                "This is the short description of the project.",21, true, "Android"));
        mProjectBaseModelArraList.add(new ProjectBaseModel("Music App",
                "Owned By: Gaurav & Lokesh", "27/02/19",
                "This is the short description of the project.",10, true, "Android"));
        mProjectBaseModelArraList.add(new ProjectBaseModel("Department App",
                "Owned By: Gaurav & Lokesh", "27/02/19",
                "This is the short description of the project.",95, true, "Android"));
        mProjectBaseModelArraList.add(new ProjectBaseModel("Department App",
                "Owned By: Gaurav & Lokesh", "27/02/19",
                "This is the short description of the project.",75, true, "Android"));

        mProjectBaseAdapter = new ProjectBaseAdapter(mProjectBaseModelArraList, getContext());
                mRecyclerView.setAdapter(mProjectBaseAdapter);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
