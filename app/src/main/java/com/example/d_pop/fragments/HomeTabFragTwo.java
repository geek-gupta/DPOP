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

import com.example.d_pop.R;
import com.example.d_pop.adapter.NotesBaseAdapter;
import com.example.d_pop.adapter.RecentNoteAdapter;
import com.example.d_pop.model.NotesBaseModel;
import com.example.d_pop.model.RecentNotesModel;

import java.util.ArrayList;

public class HomeTabFragTwo extends Fragment {

    private RecyclerView mNotesRecyclerView, mRecentNotesRecyclerView;
    private ArrayList<NotesBaseModel> mNotesBaseModel;
    private ArrayList<RecentNotesModel> mRecentNotesModel;
    private NotesBaseAdapter mNotesBaseAdapter;
    private RecentNoteAdapter mRecentNoteAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.home_tab_frag_two, container, false);

        mNotesRecyclerView = view.findViewById(R.id.notes_recycler_view);
        mRecentNotesRecyclerView = view.findViewById(R.id.recent_notes_recycler_view);
        mNotesBaseModel = new ArrayList<>();
        mNotesBaseModel.add(new NotesBaseModel("Android"));
        mNotesBaseModel.add(new NotesBaseModel("Big Data"));
        mNotesBaseModel.add(new NotesBaseModel("AI"));
        mNotesBaseModel.add(new NotesBaseModel("Data Science"));
        mNotesBaseModel.add(new NotesBaseModel("Machine Learning"));
        mNotesBaseModel.add(new NotesBaseModel("Data Mining"));
        mNotesBaseModel.add(new NotesBaseModel("Hadoop"));
        mNotesBaseModel.add(new NotesBaseModel("Web Technologies"));

        mNotesBaseAdapter = new NotesBaseAdapter(mNotesBaseModel, getContext());


//        mNotesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mNotesRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        mNotesRecyclerView.setAdapter(mNotesBaseAdapter);


        mRecentNotesModel = new ArrayList<>();
        mRecentNotesModel.add(new RecentNotesModel("Learn to Make Apps"));
        mRecentNotesModel.add(new RecentNotesModel("Build Games"));
        mRecentNotesModel.add(new RecentNotesModel("Learn Python"));
        mRecentNotesModel.add(new RecentNotesModel("Bits and Bytes"));
        mRecentNotesModel.add(new RecentNotesModel("Server Programming"));
        mRecentNotesModel.add(new RecentNotesModel("Pair Programming"));
        mRecentNotesModel.add(new RecentNotesModel("Learn Programming"));


        mRecentNoteAdapter = new RecentNoteAdapter(mRecentNotesModel, getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mRecentNotesRecyclerView.setLayoutManager(linearLayoutManager);
        mRecentNotesRecyclerView.setAdapter(mRecentNoteAdapter);

        return  view;
    }
}
