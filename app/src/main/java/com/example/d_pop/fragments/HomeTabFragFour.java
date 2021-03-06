package com.example.d_pop.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
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
import com.example.d_pop.activity.AddProjectActivity;
import com.example.d_pop.adapter.ProjectBaseAdapter;
import com.example.d_pop.model.ProjectBaseModel;
import com.example.d_pop.model.ProjectCategoryBaseModel;
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
    private ArrayList<ProjectBaseModel> mProjectBaseModelArrayList;
    private RecyclerView mRecyclerView;
    private FloatingActionButton mFloatingButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.home_tab_frag_four, container, false);
        spinner = view.findViewById(R.id.project_spinner);
        mFloatingButton = view.findViewById(R.id.add_project_button);

        this.getAllCategories();
        spinner.setOnItemSelectedListener(this);

        mProjectBaseModelArrayList = new ArrayList<>();
        mRecyclerView = view.findViewById(R.id.project_recyclerview);

        mFloatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddProjectActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        getAllProjects(item);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void getAllProjects(String item) {
        GetAPIServices service = RetrofitAPIClient.getRetrofitInstance().create(GetAPIServices.class);
        Call<ArrayList<ProjectBaseModel>> call = service.getAllProjects(item);
        call.enqueue(new Callback<ArrayList<ProjectBaseModel>>() {
            @Override
            public void onResponse(Call<ArrayList<ProjectBaseModel>> call, Response<ArrayList<ProjectBaseModel>> response) {

                if(response.body().size() < 1){
                    Toast.makeText(getContext(), "No Project found!!", Toast.LENGTH_SHORT).show();
                    getAllProjects("All");
                    spinner.setSelection(0);
                }else {
                    mProjectBaseModelArrayList = response.body();
                    mProjectBaseAdapter = new ProjectBaseAdapter(mProjectBaseModelArrayList, getContext());
                    mRecyclerView.setAdapter(mProjectBaseAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ProjectBaseModel>> call, Throwable t) {
                Toast.makeText(getContext(), "Retrofit Failure", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getAllCategories() {
        GetAPIServices service = RetrofitAPIClient.getRetrofitInstance().create(GetAPIServices.class);
        Call<ProjectCategoryBaseModel> call = service.getAllCategories();
        call.enqueue(new Callback<ProjectCategoryBaseModel>() {
            @Override
            public void onResponse(Call<ProjectCategoryBaseModel> call, Response<ProjectCategoryBaseModel> response) {

                List<String> categories = new ArrayList<>();
                categories.add("All");
                for(String ele: response.body().getCategories()){
                    categories.add(ele);
                }
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, categories);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(dataAdapter);


            }

            @Override
            public void onFailure(Call<ProjectCategoryBaseModel> call, Throwable t) {
                Toast.makeText(getContext(), "Retrofit Failure", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
