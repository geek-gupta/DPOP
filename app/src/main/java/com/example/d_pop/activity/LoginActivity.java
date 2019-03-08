package com.example.d_pop.activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.d_pop.R;
import com.example.d_pop.activity.HomeActivity;
import com.example.d_pop.model.LoginModel;
import com.example.d_pop.network.GetAPIServices;
import com.example.d_pop.network.RetrofitAPIClient;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ActionBar mActionBar;
    private Button mLoginButton;
    private EditText userNameEditText, passwordEditText;
    private boolean isStudent = false;
    private ImageButton studentImageButton, teacherImageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        mLoginButton = (Button)findViewById(R.id.login_button);
        userNameEditText = findViewById(R.id.username_login);
        passwordEditText = findViewById(R.id.password_login);
        studentImageButton = findViewById(R.id.student_button_login);
        teacherImageButton = findViewById(R.id.teacher_button_login);


        studentImageButton.setOnClickListener(this);
        mLoginButton.setOnClickListener(this);


        teacherImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isStudent = false;
                teacherImageButton.setImageResource(R.drawable.professor_blue);
                studentImageButton.setImageResource(R.drawable.student);
            }
        });


    }

    private void init() {
        mActionBar = getSupportActionBar();
        mActionBar.hide();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){

            case R.id.student_button_login:
                isStudent = true;
                studentImageButton.setImageResource(R.drawable.student_blue);
                teacherImageButton.setImageResource(R.drawable.teacher);
                break;

            case R.id.login_button:
                GetAPIServices service = RetrofitAPIClient.getRetrofitInstance().create(GetAPIServices.class);
                Call<LoginModel> call = service.attempLogin(userNameEditText.getText().toString(), passwordEditText.getText().toString(), isStudent  );
                call.enqueue(new Callback<LoginModel>() {
                    @Override
                    public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {

                        if(response.body().isLoginSuccess()) {
                            Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                            startActivity(intent);
                            finish();
                        }else {
                            Toast.makeText(LoginActivity.this, "Please Enter Valid Credentials", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginModel> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "Retrofit Failure in Login Screen", Toast.LENGTH_SHORT).show();
                        Log.i("ResponseBody", "onResponse: " + t);
                    }
                });
                break;
        }

    }
}
