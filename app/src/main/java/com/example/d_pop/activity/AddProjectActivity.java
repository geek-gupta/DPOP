package com.example.d_pop.activity;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.d_pop.R;
import com.example.d_pop.model.ProjectBaseModel;
import com.example.d_pop.model.QueryModel;
import com.example.d_pop.network.GetAPIServices;
import com.example.d_pop.network.RetrofitAPICalls;
import com.example.d_pop.network.RetrofitAPIClient;
import com.example.d_pop.utility.SaveSharedPreferences;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddProjectActivity extends AppCompatActivity {

    private Spinner mDomainNameSpinner, mNumberOfParticipants, mMentorNameSpinner;
    private TextView mProjectName, mProjecrShortDescription;
    private Button mAddProjectButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_project);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Add Project");
        init();

        fillData();

        mAddProjectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProjectData();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }


    private void init() {
        mDomainNameSpinner = (Spinner) findViewById(R.id.domain_name_spinner);
        mNumberOfParticipants = (Spinner) findViewById(R.id.number_of_participants);
        mProjecrShortDescription = findViewById(R.id.project_sub_description);
        mProjectName = findViewById(R.id.project_name_text_view);
        mMentorNameSpinner = findViewById(R.id.mentor_name_spinner);
        mAddProjectButton = findViewById(R.id.project_add_button    );
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

        List<String> mentorList = new ArrayList<>();
        mentorList.add("Mr. Anmol Tyagi");
        mentorList.add("Mr. Pradeep Malik");
        mentorList.add("Mrs. Pushpa Choudhary");


        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(AddProjectActivity.this, android.R.layout.simple_spinner_dropdown_item, mentorList);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mMentorNameSpinner.setAdapter(dataAdapter1);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(AddProjectActivity.this, android.R.layout.simple_spinner_dropdown_item, participantsList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mNumberOfParticipants.setAdapter(dataAdapter);

    }

    private void addProjectData() {
        String rollnumber = SaveSharedPreferences.getRollnumber(getApplicationContext());
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
        String formattedDate = df.format(c);
        String projectName = mProjectName.getText().toString();
        String mProjecrShortDesc = mProjecrShortDescription.getText().toString();
        ProjectBaseModel projectBaseModel = new ProjectBaseModel(projectName, "Gaurav Kumar", formattedDate, mProjecrShortDesc,0, true, mDomainNameSpinner.getSelectedItem().toString(), rollnumber);

        GetAPIServices service = RetrofitAPIClient.getRetrofitInstance().create(GetAPIServices.class);
        Call<ProjectBaseModel> call = service.addProjectData(projectBaseModel);
        call.enqueue(new Callback<ProjectBaseModel>() {
            @Override
            public void onResponse(Call<ProjectBaseModel> call, Response<ProjectBaseModel> response) {
                Toast.makeText(getBaseContext(), "Project Added", Toast.LENGTH_SHORT).show();
                onSupportNavigateUp();
            }

            @Override
            public void onFailure(Call<ProjectBaseModel> call, Throwable t) {
                Toast.makeText(getBaseContext(), "Project Not Added", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
