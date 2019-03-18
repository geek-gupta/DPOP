package com.example.d_pop.adapter;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.d_pop.R;
import com.example.d_pop.model.NotesSubCategoryModel;
import com.example.d_pop.network.GetAPIServices;
import com.example.d_pop.network.RetrofitAPIClient;
import com.example.d_pop.utility.Utility;

import java.io.File;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
       viewHolder.mPDFNameTextView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               getPDF();
           }
       });
    }

    @Override
    public int getItemCount() {
        return mNotesSubCategoryModel.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        TextView mPDFNameTextView, mAddedByName, mAddedOnTime;
        ImageView mRatingImageView;
        LinearLayout mOpenPdfFileLinearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mAddedByName = itemView.findViewById(R.id.notes_added_by_text_view);
            mAddedOnTime = itemView.findViewById(R.id.notes_added_on_text_view);
            mPDFNameTextView = itemView.findViewById(R.id.notes_pdf_name_text_View);
            mRatingImageView = itemView.findViewById(R.id.notes_rating_image_view);
            mOpenPdfFileLinearLayout = itemView.findViewById(R.id.show_pdf_file_linear_layout);
        }
    }


    public void getPDF() {
        GetAPIServices service = RetrofitAPIClient.getRetrofitInstance().create(GetAPIServices.class);
        retrofit2.Call<ResponseBody> call = service.getPDF("eglu");

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                File file;
                file = Utility.writeResponseBodyToDisk(response.body());

                Intent sharingIntent = new Intent(Intent.ACTION_VIEW);
                sharingIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                sharingIntent.setDataAndType(Uri.fromFile(file), "application/pdf");
                Intent chooserIntent = Intent.createChooser(sharingIntent, "Open With");
                chooserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(chooserIntent);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(context, "Retrofit Failure", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
