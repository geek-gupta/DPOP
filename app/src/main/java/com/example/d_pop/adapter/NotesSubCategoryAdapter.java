package com.example.d_pop.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.d_pop.R;
import com.example.d_pop.model.NotesSubCategoryModel;

import java.util.ArrayList;

public class NotesSubCategoryAdapter extends RecyclerView.Adapter<NotesSubCategoryAdapter.ViewHolder> {
    private ArrayList<NotesSubCategoryModel> mNotesSubCategoryModel;
    private Context context;

    public NotesSubCategoryAdapter(ArrayList<NotesSubCategoryModel> mNotesSubCategoryModel, Context context) {
        this.mNotesSubCategoryModel = mNotesSubCategoryModel;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.notes_category_item_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.mRatingImageView.setImageResource(R.drawable.star);
        viewHolder.mPDFNameTextView.setText(mNotesSubCategoryModel.get(i).getName());
        viewHolder.mAddedOnTime.setText(mNotesSubCategoryModel.get(i).getAddedOn());
        viewHolder.mAddedByName.setText(mNotesSubCategoryModel.get(i).getAddedBy());
        // viewHolder.mRatingImageView.setImageResource(mNotesSubCategoryModel.get(i).getRating());
    }

    @Override
    public int getItemCount() {
        return mNotesSubCategoryModel.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        TextView mPDFNameTextView, mAddedByName, mAddedOnTime;
        ImageView mRatingImageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mAddedByName = itemView.findViewById(R.id.notes_added_by_text_view);
            mAddedOnTime = itemView.findViewById(R.id.notes_added_on_text_view);
            mPDFNameTextView = itemView.findViewById(R.id.notes_pdf_name_text_View);
            mRatingImageView = itemView.findViewById(R.id.notes_rating_image_view);
        }
    }
}
