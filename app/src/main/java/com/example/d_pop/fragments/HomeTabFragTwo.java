package com.example.d_pop.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.d_pop.R;
import com.example.d_pop.adapter.NotesBaseAdapter;
import com.example.d_pop.adapter.RecentNoteAdapter;
import com.example.d_pop.model.NotesBaseCategoryModel;
import com.example.d_pop.model.RecentNotesModel;
import com.example.d_pop.network.GetAPIServices;
import com.example.d_pop.network.RetrofitAPIClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeTabFragTwo extends Fragment {

    private RecyclerView mNotesRecyclerView, mRecentNotesRecyclerView;
    private NotesBaseAdapter mNotesBaseAdapter;
    private RecentNoteAdapter mRecentNoteAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.home_tab_frag_two, container, false);

        mNotesRecyclerView = view.findViewById(R.id.notes_recycler_view);
        mRecentNotesRecyclerView = view.findViewById(R.id.recent_notes_recycler_view);

        getNotesBaseCategories();
        getRecentNotesList();

        return  view;
    }

    private void getNotesBaseCategories() {
        GetAPIServices service = RetrofitAPIClient.getRetrofitInstance().create(GetAPIServices.class);
        Call<NotesBaseCategoryModel> call = service.getNotesBaseCategories();
        call.enqueue(new Callback<NotesBaseCategoryModel>() {
            @Override
            public void onResponse(Call<NotesBaseCategoryModel> call, Response<NotesBaseCategoryModel> response) {

                ArrayList<String> categories = new ArrayList<>();
                for(String ele: response.body().getBaseCategories()){
                    categories.add(ele);
                }

                mNotesBaseAdapter = new NotesBaseAdapter(categories, getContext());

                mNotesRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
                mNotesRecyclerView.setAdapter(mNotesBaseAdapter);

            }

            @Override
            public void onFailure(Call<NotesBaseCategoryModel> call, Throwable t) {
                Toast.makeText(getContext(), "Retrofit Failure", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getRecentNotesList() {
        GetAPIServices service = RetrofitAPIClient.getRetrofitInstance().create(GetAPIServices.class);
        Call<RecentNotesModel> call = service.getRecentNotesList();
        call.enqueue(new Callback<RecentNotesModel>() {
            @Override
            public void onResponse(Call<RecentNotesModel> call, Response<RecentNotesModel> response) {

                ArrayList<String> recentNotesList = new ArrayList<>();
                for(String ele: response.body().getRecentNoteName()){
                    recentNotesList.add(ele);
                }

                mRecentNoteAdapter = new RecentNoteAdapter(recentNotesList, getContext());
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
                mRecentNotesRecyclerView.setLayoutManager(linearLayoutManager);
                mRecentNotesRecyclerView.setAdapter(mRecentNoteAdapter);
            }

            @Override
            public void onFailure(Call<RecentNotesModel> call, Throwable t) {
                Toast.makeText(getContext(), "Retrofit Failure", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
