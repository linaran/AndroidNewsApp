package com.example.spidey.myapplication.model;

import com.example.spidey.myapplication.model.json2java.NYTimesResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class NYTimesServiceImpl implements NYTimesService{
    private final Callback<NYTimesResponse> callback;
    private final NYTimesAPI nyTimesAPI;
    public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";

    public NYTimesServiceImpl(Callback<NYTimesResponse> callback) {
        this.callback = callback;

        Gson gson = new GsonBuilder() //Local until further notice.
                .setDateFormat(DATE_FORMAT)
                .create();
        Retrofit retrofit = new Retrofit.Builder() //Local until further notice.
                .baseUrl(NYTimesAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        nyTimesAPI = retrofit.create(NYTimesAPI.class);
    }

    public void getArticles() {
        Call<NYTimesResponse> call = nyTimesAPI.getResponse();
        call.enqueue(callback);
    }
}
