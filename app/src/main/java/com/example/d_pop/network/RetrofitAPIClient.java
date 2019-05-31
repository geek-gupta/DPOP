package com.example.d_pop.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitAPIClient {

    private static Retrofit retrofit;
    //private static final String BASE_URL = "http://192.168.43.116:9000";
    //private static final String BASE_URL = "http://192.168.43.178:9000";
    //private static final String BASE_URL = "http://192.168.43.116:9000";
    private static final String BASE_URL = "http://192.168.1.12:9000";




    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
