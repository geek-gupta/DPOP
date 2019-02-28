package com.example.d_pop;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActionBar mActionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();




    }

    private void init() {
        mActionBar = getSupportActionBar();
        mActionBar.hide();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

    }
}
