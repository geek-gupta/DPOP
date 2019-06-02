package com.example.d_pop.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.d_pop.R;
import com.example.d_pop.adapter.QueryAnswerAdapter;
import com.example.d_pop.model.AddQueryAnswerModel;
import com.example.d_pop.model.ProjectBaseModel;
import com.example.d_pop.model.QueryAnswerModel;
import com.example.d_pop.model.QueryModel;
import com.example.d_pop.network.GetAPIServices;
import com.example.d_pop.network.RetrofitAPIClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QueryAnswerActivity extends AppCompatActivity {

    private RecyclerView mQueryAnswerRecyclerView;
    private QueryAnswerAdapter mQueryAnswerAdapter;
    private ArrayList<QueryAnswerModel> mQueryAnswerModel;
    private String qId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_answer);

        getSupportActionBar().setTitle("Answers");

        Intent intent = getIntent();
        String queryId = intent.getStringExtra("QueryId");
        qId = queryId;
        mQueryAnswerRecyclerView = findViewById(R.id.query_answer_recycler_view);


        setAllAnswers(queryId);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_query_answer_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.add_query_answer_menu_button:
                addAnswer();
                break;

        }
        return true;
    }

    private void setAllAnswers(String queryId) {
        GetAPIServices service = RetrofitAPIClient.getRetrofitInstance().create(GetAPIServices.class);
        Call<ArrayList<QueryAnswerModel>> call = service.getAnswerByQueryId(queryId);
        call.enqueue(new Callback<ArrayList<QueryAnswerModel>>() {
            @Override
            public void onResponse(Call<ArrayList<QueryAnswerModel>> call, Response<ArrayList<QueryAnswerModel>> response) {
                if(response.body().size() > 0){
                    mQueryAnswerModel = response.body();
                    mQueryAnswerAdapter = new QueryAnswerAdapter(getBaseContext(), mQueryAnswerModel);
                    mQueryAnswerRecyclerView.setAdapter(mQueryAnswerAdapter);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseContext());
                    linearLayoutManager.setReverseLayout(true);
                    linearLayoutManager.setStackFromEnd(true);
                    mQueryAnswerRecyclerView.setLayoutManager(linearLayoutManager);
                }

            }

            @Override
            public void onFailure(Call<ArrayList<QueryAnswerModel>> call, Throwable t) {
                Toast.makeText(getBaseContext(), "Retrofit Failure in getting answers", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addAnswer() {
            final EditText queryEditText = new EditText(this);


            AlertDialog dialog = new AlertDialog.Builder(this)
                    .setTitle("Add a new Question")
                    .setMessage("   ")
                    .setView(queryEditText)
                    .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String answer = String.valueOf(queryEditText.getText());
                            addQueryAnswerToDB(answer);
                        }
                    })
                    .setNegativeButton("Cancel", null)
                    .create();
            dialog.show();
        }

        private void addQueryAnswerToDB(String answer) {
            AddQueryAnswerModel queryAnswerModel = new AddQueryAnswerModel(qId, "XYZ", answer);

            GetAPIServices service = RetrofitAPIClient.getRetrofitInstance().create(GetAPIServices.class);
            Call<AddQueryAnswerModel> call = service.addAnswerToQuery(queryAnswerModel);
            call.enqueue(new Callback<AddQueryAnswerModel>() {
                @Override
                public void onResponse(Call<AddQueryAnswerModel> call, Response<AddQueryAnswerModel> response) {
                    Toast.makeText(getApplicationContext(), "Query Answer Added", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<AddQueryAnswerModel> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Query Not Added", Toast.LENGTH_SHORT).show();
                }
            });
        }

}
