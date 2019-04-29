package com.example.d_pop.activity;

import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.d_pop.R;
import com.example.d_pop.network.RetrofitAPICalls;

import java.util.ArrayList;
import java.util.List;

public class AddProjectActivity extends AppCompatActivity {

    private Spinner mDomainNameSpinner, mNumberOfParticipants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_project);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Add Project");
        init();

        fillData();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }


    private void init() {
        mDomainNameSpinner = (Spinner) findViewById(R.id.domain_name_spinner);
        mNumberOfParticipants = (Spinner) findViewById(R.id.number_of_participants);
    }

    private void fillData() {
        RetrofitAPICalls.getAllCategories(new RetrofitAPICalls.ResultInterface() {
            @Override
            public void onCategoryDataLoad(List<String> data) {
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(AddProjectActivity.this, android.R.layout.simple_spinner_dropdown_item, data);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mDomainNameSpinner.setAdapter(dataAdapter);
            }


        });

        List<String> participantsList = new ArrayList<>();
        participantsList.add("1");
        participantsList.add("2");
        participantsList.add("3");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(AddProjectActivity.this, android.R.layout.simple_spinner_dropdown_item, participantsList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mNumberOfParticipants.setAdapter(dataAdapter);

    }
}
