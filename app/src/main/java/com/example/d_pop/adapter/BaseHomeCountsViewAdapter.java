package com.example.d_pop.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.d_pop.R;
import com.example.d_pop.model.BaseHomeCountViewModel;

import java.util.ArrayList;

public class BaseHomeCountsViewAdapter extends RecyclerView.Adapter<BaseHomeCountsViewAdapter.ViewHolder> {

    private ArrayList<BaseHomeCountViewModel> mBaseHomeCountViewModelArrayList;
    private Context context;

    public BaseHomeCountsViewAdapter(ArrayList<BaseHomeCountViewModel> mBaseHomeCountViewModelArrayList, Context context) {
        this.mBaseHomeCountViewModelArrayList = mBaseHomeCountViewModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.count_base_home_item_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        switch (i){
            case 0:
                viewHolder.countBaseHomeLinearLauout.setBackgroundColor(Color.parseColor("#1b6080"));
                break;
            case 1:
                viewHolder.countBaseHomeLinearLauout.setBackgroundColor(Color.parseColor("#dd193a"));
                break;
            case 2:
                viewHolder.countBaseHomeLinearLauout.setBackgroundColor(Color.parseColor("#d99e02"));
                break;
            case 3:
                viewHolder.countBaseHomeLinearLauout.setBackgroundColor(Color.parseColor("#26890b"));
                break;
        }
        viewHolder.countTextView.setText(mBaseHomeCountViewModelArrayList.get(i).getCountItemtext());
        viewHolder.countNameTextView.setText(mBaseHomeCountViewModelArrayList.get(i).getCountItemNameText());
    }

    @Override
    public int getItemCount() {
        return mBaseHomeCountViewModelArrayList.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        TextView countNameTextView, countTextView;
        LinearLayout countBaseHomeLinearLauout;
        public ViewHolder (@NonNull View itemView) {
            super(itemView);
            countNameTextView = itemView.findViewById(R.id.count_name_text_view);
            countTextView = itemView.findViewById(R.id.count_count_text_view);
            countBaseHomeLinearLauout = itemView.findViewById(R.id.count_base_home_linear_layout);

        }
    }
}
