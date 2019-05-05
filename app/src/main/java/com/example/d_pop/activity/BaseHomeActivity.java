package com.example.d_pop.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.d_pop.R;
import com.example.d_pop.adapter.BaseHomeCountsViewAdapter;
import com.example.d_pop.adapter.ProjectBaseAdapter;
import com.example.d_pop.model.BaseHomeCountViewModel;
import com.example.d_pop.model.ProjectBaseModel;
import com.example.d_pop.utility.SaveSharedPreferences;
import com.leinardi.android.speeddial.SpeedDialActionItem;
import com.leinardi.android.speeddial.SpeedDialView;

import java.util.ArrayList;

public class BaseHomeActivity extends AppCompatActivity {
    private ScrollView mBaseHomeScrollView;
    private RecyclerView mProjectAssignedToMeRecyclerView, mBaseHomeCountRecyclerview;
    private ProjectBaseAdapter mProjectBaseAdapter;
    private ArrayList<ProjectBaseModel> mProjectAssignedToMeBaseModelList;
    private ArrayList<BaseHomeCountViewModel> mBaseHomeCountModelArrayList;
    private BaseHomeCountsViewAdapter mBaseHomeCountAdapter;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_home);

        getSupportActionBar().hide();
        final SpeedDialView speedDialView = findViewById(R.id.speedDial);
        mProjectAssignedToMeRecyclerView = findViewById(R.id.project_assigned_to_me_recycler_view);
        mBaseHomeCountRecyclerview = findViewById(R.id.base_home_count_recycler_view);
        mBaseHomeScrollView = findViewById(R.id.base_home_scroll_view);

        speedDialView.inflate(R.menu.base_home_menu);
        speedDialView.setOnActionSelectedListener(new SpeedDialView.OnActionSelectedListener() {
            @Override
            public boolean onActionSelected(SpeedDialActionItem actionItem) {
                switch (actionItem.getId()) {
                    case R.id.base_home_logout_item:
                        SaveSharedPreferences.setLoggedIn(getApplicationContext(), false);
                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                        return false;
                    case R.id.base_home_notes_item:
                        Intent intent1 = new Intent(getApplicationContext(), HomeActivity.class);
                        intent1.putExtra("indexPostion", 2);
                        startActivity(intent1);
                        return false;
                    case R.id.base_home_project_item:
                        Intent intent2 = new Intent(getApplicationContext(), HomeActivity.class);
                        intent2.putExtra("indexPostion", 1);
                        startActivity(intent2);
                        return false;
                    case R.id.base_home_query_item:
                        Intent intent3 = new Intent(getApplicationContext(), HomeActivity.class);
                        intent3.putExtra("indexPostion", 0);
                        startActivity(intent3);
                        return false;
                    default:
                        return false;

                }
            }
        });





        showProjectAssignedToMe();
        showBaseCountView();







    }

    private void showProjectAssignedToMe() {
        mProjectAssignedToMeBaseModelList = new ArrayList<>();
        mProjectAssignedToMeBaseModelList.add(new ProjectBaseModel("D-POP", "Gaurav", "24/01/19", "Hii I am Short Description.Hii I am Short Description.Hii I am Short Description.Hii I am Short Description.", 43, true, "Android" ));
        mProjectAssignedToMeBaseModelList.add(new ProjectBaseModel("APK Extractor", "Gaurav", "24/01/19", "Hii I am Short Description.Hii I am Short Description.Hii I am Short Description.Hii I am Short Description.", 100, true, "Android" ));
        mProjectBaseAdapter = new ProjectBaseAdapter(mProjectAssignedToMeBaseModelList, this);
        mProjectAssignedToMeRecyclerView.setAdapter(mProjectBaseAdapter);
        mProjectAssignedToMeRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    private void showBaseCountView() {
        mBaseHomeCountModelArrayList = new ArrayList<>();
        mBaseHomeCountModelArrayList.add(new BaseHomeCountViewModel("Atendance", "75"));
        mBaseHomeCountModelArrayList.add(new BaseHomeCountViewModel("Project Count", "03"));
        mBaseHomeCountModelArrayList.add(new BaseHomeCountViewModel("Notes Count", "12"));
        mBaseHomeCountModelArrayList.add(new BaseHomeCountViewModel("Query Raised", "26"));
        mBaseHomeCountAdapter =  new BaseHomeCountsViewAdapter(mBaseHomeCountModelArrayList, this);
        mBaseHomeCountRecyclerview.setAdapter(mBaseHomeCountAdapter);
        mBaseHomeCountRecyclerview.setLayoutManager(new GridLayoutManager(this, 2));
    }
}
