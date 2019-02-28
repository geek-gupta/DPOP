package com.example.d_pop.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.d_pop.R;
import com.example.d_pop.fragments.HomeTabFragFour;
import com.example.d_pop.model.ProjectBaseModel;

import java.util.ArrayList;

public class ProjectBaseAdapter extends RecyclerView.Adapter<ProjectBaseAdapter.ViewHolder> {

    private ArrayList<ProjectBaseModel> mProjectBaseAdapterArrayList;
    private Context context;

    public ProjectBaseAdapter(ArrayList<ProjectBaseModel> projectBaseAdapterArrayList, Context context) {
        this.mProjectBaseAdapterArrayList = projectBaseAdapterArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View itemView = LayoutInflater.from(context).inflate(R.layout.project_item_layout, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.projectNameTextView.setText(mProjectBaseAdapterArrayList.get(position).getProjectName());
        viewHolder.ownerNameTextView.setText(mProjectBaseAdapterArrayList.get(position).getOwnerName());
        viewHolder.shortDescTextView.setText(mProjectBaseAdapterArrayList.get(position).getShortDescription());
        viewHolder.projectProgress.setProgress(mProjectBaseAdapterArrayList.get(position).getProgress());
    }

    @Override
    public int getItemCount() {
        return mProjectBaseAdapterArrayList.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        private TextView projectNameTextView, shortDescTextView, ownerNameTextView;
        private ProgressBar projectProgress;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            projectNameTextView = itemView.findViewById(R.id.project_name_text_view);
            shortDescTextView = itemView.findViewById(R.id.project_short_desc_text_view);
            ownerNameTextView = itemView.findViewById(R.id.project_owner_text_view);
            projectProgress = itemView.findViewById(R.id.progressbar_project);
        }
    }


}
