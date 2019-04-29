package com.example.d_pop.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.d_pop.R;

public class ProjectDetailsAndAlter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_project_data);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
