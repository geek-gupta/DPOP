package com.example.d_pop.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.d_pop.R;
import com.example.d_pop.adapter.QueryAnswerAdapter;
import com.example.d_pop.model.ProjectBaseModel;
import com.example.d_pop.model.QueryAnswerModel;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_answer);

        Intent intent = getIntent();
        String queryId = intent.getStringExtra("QueryId");

        mQueryAnswerRecyclerView = findViewById(R.id.query_answer_recycler_view);


        setAllAnswers(queryId);

    }

    private void setAllAnswers(String queryId){
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
}
