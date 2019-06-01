package com.example.d_pop.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.d_pop.R;
import com.example.d_pop.model.QueryAnswerModel;

import java.util.ArrayList;

public class QueryAnswerAdapter extends RecyclerView.Adapter<QueryAnswerAdapter.ViewHolder>{

    private Context context;
    private ArrayList<QueryAnswerModel> mQueryAnswerModel;

    public QueryAnswerAdapter(Context context, ArrayList<QueryAnswerModel> mQueryAnswerModel) {
        this.context = context;
        this.mQueryAnswerModel = mQueryAnswerModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.query_answer_item_layout, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.answerTextView.setText(mQueryAnswerModel.get(i).getAnswer());
        viewHolder.answerByTextView.setText(mQueryAnswerModel.get(i).getAnsweredBy());
    }

    @Override
    public int getItemCount() {
        return mQueryAnswerModel.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        TextView answerByTextView, answerTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            answerByTextView = itemView.findViewById(R.id.query_poster_name_text_view);
            answerTextView = itemView.findViewById(R.id.query_answer_text_view);
        }
    }

}
