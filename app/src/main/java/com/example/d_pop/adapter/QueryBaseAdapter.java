package com.example.d_pop.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.d_pop.R;
import com.example.d_pop.activity.ProjectDetailsAndAlter;
import com.example.d_pop.model.ProjectBaseModel;
import com.example.d_pop.model.QueryModel;

import java.util.ArrayList;

public class QueryBaseAdapter extends RecyclerView.Adapter<QueryBaseAdapter.ViewHolder> {



    private ArrayList<QueryModel> mQueryBaseModel;
    private Context context;

    public QueryBaseAdapter(ArrayList<QueryModel> mQueryBaseModel, Context context) {
        this.mQueryBaseModel = mQueryBaseModel;
        this.context = context;
    }

    @NonNull
    @Override
    public QueryBaseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.query_item_layout, viewGroup, false);
        return new QueryBaseAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.questionTextView.setText(mQueryBaseModel.get(i).getQuestion());
    }



    @Override
    public int getItemCount() {
        return mQueryBaseModel.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        private TextView questionTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            questionTextView = itemView.findViewById(R.id.query_item_question_text_view);
        }
    }
}
