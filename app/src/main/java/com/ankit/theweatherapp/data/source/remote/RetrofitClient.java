package com.ankit.theweatherapp.data.source.remote;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
    static OkHttpClient client =  new OkHttpClient.Builder()
            .addInterceptor(logging)
            .build();

    private static Retrofit retrofit = null;

    private static String BASE_URL = "https://api.openweathermap.org/";

    public static Retrofit getClient(){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
