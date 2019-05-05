package com.example.d_pop.network;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.d_pop.activity.BaseHomeActivity;
import com.example.d_pop.activity.HomeActivity;
import com.example.d_pop.model.LoginModel;
import com.example.d_pop.model.ProjectCategoryBaseModel;
import com.example.d_pop.utility.SaveSharedPreferences;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitAPICalls {

    public static void AttemptLogin(final Context context, String userName, String password, final boolean isStudent){

        GetAPIServices service = RetrofitAPIClient.getRetrofitInstance().create(GetAPIServices.class);
        Call<LoginModel> call = service.attempLogin(userName, password, isStudent  );
        call.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {

                if(response.body().isLoginSuccess()) {
                    SaveSharedPreferences.setLoggedIn(context.getApplicationContext(), true);
                    Intent intent = new Intent(context.getApplicationContext(), BaseHomeActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    context.startActivity(intent);

                }else {
                    Toast.makeText( context , "Please Enter Valid Credentials", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                Toast.makeText(context, "Retrofit Failure in Login Screen", Toast.LENGTH_SHORT).show();
                Log.i("ResponseBody", "onResponse: " + t);
            }
        });
    }

    public static void getAllCategories(final ResultInterface resultInterface) {

        GetAPIServices service = RetrofitAPIClient.getRetrofitInstance().create(GetAPIServices.class);
        Call<ProjectCategoryBaseModel> call = service.getAllCategories();
        call.enqueue(new Callback<ProjectCategoryBaseModel>() {
            @Override
            public void onResponse(Call<ProjectCategoryBaseModel> call, Response<ProjectCategoryBaseModel> response) {

                List<String> categories = new ArrayList<>();
                categories.add("None");
                for(String ele: response.body().getCategories()){
                    categories.add(ele);
                }

                resultInterface.onCategoryDataLoad(categories);

            }

            @Override
            public void onFailure(Call<ProjectCategoryBaseModel> call, Throwable t) {

            }
        });
    }

    public interface ResultInterface {
        public void onCategoryDataLoad(List<String> data);
    }


}
