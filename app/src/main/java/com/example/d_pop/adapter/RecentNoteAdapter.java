package com.example.d_pop.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.d_pop.R;

import java.util.ArrayList;

public class RecentNoteAdapter extends RecyclerView.Adapter<RecentNoteAdapter.ViewHolder>{

    private ArrayList<String> mRecentNotesModel;
    private Context context;

    public RecentNoteAdapter(ArrayList<String> mRecentNotesModel, Context context) {
        this.mRecentNotesModel = mRecentNotesModel;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.recent_note_item_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.mRecentNotesTextView.setText(mRecentNotesModel.get(i));
    }

    @Override
    public int getItemCount() {
        return mRecentNotesModel.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        TextView mRecentNotesTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mRecentNotesTextView = itemView.findViewById(R.id.recent_notes_pdf_name_text_view);
        }
    }
}
