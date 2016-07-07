package com.example.spidey.myapplication.model;

import com.example.spidey.myapplication.model.json2java.Doc;
import com.example.spidey.myapplication.model.json2java.NYTimesResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class NYTimesServiceImpl implements NYTimesService{
    private final NYTimesAPI nyTimesAPI;
    public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";

    public NYTimesServiceImpl() {
        Gson gson = new GsonBuilder() //Local until further notice.
                .setDateFormat(DATE_FORMAT)
                .create();
        Retrofit retrofit = new Retrofit.Builder() //Local until further notice.
                .baseUrl(NYTimesAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        nyTimesAPI = retrofit.create(NYTimesAPI.class);
    }

    public List<Doc> getArticles() throws IOException {
        Call<NYTimesResponse> call = nyTimesAPI.getResponse();
        return call.execute().body().getResponse().getDocs();
    }
}
