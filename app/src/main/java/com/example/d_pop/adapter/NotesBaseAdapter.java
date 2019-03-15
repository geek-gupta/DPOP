package com.example.d_pop.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.d_pop.R;
import com.example.d_pop.model.NotesBaseModel;

import java.util.ArrayList;

public class NotesBaseAdapter extends RecyclerView.Adapter<NotesBaseAdapter.ViewHolder> {

    ArrayList<NotesBaseModel> notesBaseModels;
    private Context context;

    public NotesBaseAdapter(ArrayList<NotesBaseModel> notesBaseModels, Context  context) {
        this.notesBaseModels = notesBaseModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.notes_base_item_layout, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.notesCategoryTextView.setText(notesBaseModels.get(i).getNotesCategoryName());
    }

    @Override
    public int getItemCount() {
        return notesBaseModels.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        TextView notesCategoryTextView;
        public ViewHolder (@NonNull View itemView) {
            super(itemView);
            notesCategoryTextView = itemView.findViewById(R.id.notes_base_item_text_view);

        }
    }
}
