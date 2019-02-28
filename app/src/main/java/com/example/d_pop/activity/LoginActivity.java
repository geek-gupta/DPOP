package com.example.d_pop.activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.d_pop.R;
import com.example.d_pop.activity.HomeActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ActionBar mActionBar;
    private Button mLoginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        mLoginButton = (Button)findViewById(R.id.login_button);
        mLoginButton.setOnClickListener(this);
    }

    private void init() {
        mActionBar = getSupportActionBar();
        mActionBar.hide();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.login_button){
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
            finish();
        }

    }
}
