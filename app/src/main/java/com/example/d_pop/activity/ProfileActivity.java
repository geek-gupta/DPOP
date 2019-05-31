package com.example.d_pop.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.d_pop.R;

public class ProfileActivity extends AppCompatActivity {

    private ImageView mProfileImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        mProfileImageView = findViewById(R.id.profile_image_view);

        Glide.with(this).load(R.drawable.me).apply(RequestOptions.circleCropTransform()).into(mProfileImageView);
        getSupportActionBar().hide();
    }
}
