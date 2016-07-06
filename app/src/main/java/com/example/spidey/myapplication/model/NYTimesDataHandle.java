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

public class NYTimesDataHandle {
    private NYTimesAPI NYApiService;

    public NYTimesDataHandle() {
        Gson gson = new GsonBuilder() //Local until further notice.
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
        Retrofit retrofit = new Retrofit.Builder() //Local until further notice.
                .baseUrl(NYTimesAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        NYApiService = retrofit.create(NYTimesAPI.class);
    }

    public List<Doc> getArticles() throws IOException {
        Call<NYTimesResponse> call = NYApiService.getResponse();
        return call.execute().body().getResponse().getDocs();
    }
}
