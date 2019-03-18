package com.example.d_pop.adapter;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.d_pop.R;
import com.example.d_pop.network.GetAPIServices;
import com.example.d_pop.network.RetrofitAPIClient;
import com.example.d_pop.utility.Utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        viewHolder.mRecentNotesTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPDF();
            }
        });
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

    public void getPDF() {
        GetAPIServices service = RetrofitAPIClient.getRetrofitInstance().create(GetAPIServices.class);
        retrofit2.Call<ResponseBody> call = service.getPDF("eglu");

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                File file;
                file = Utility.writeResponseBodyToDisk(response.body());

                Intent target = new Intent(Intent.ACTION_VIEW);
                target.setDataAndType(Uri.fromFile(file), "application/pdf");
                target.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

                Intent intent = Intent.createChooser(target, "Open File");
                try {
                    context.startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Log.e("Error", "onResponse: ", e);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(context, "Retrofit Failure", Toast.LENGTH_SHORT).show();
            }
        });
    }




}
