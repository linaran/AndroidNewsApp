package com.example.spidey.myapplication.model;

import com.example.spidey.myapplication.model.json2java.NYTimesResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public final class NYTimesServiceImpl implements NYTimesService {

    private final NYTimesAPI nyTimesAPI;

    public NYTimesServiceImpl(Retrofit retrofit) {
        nyTimesAPI = retrofit.create(NYTimesAPI.class);
    }

    @Override
    public void getDocs(final Callback<NYTimesResponse> callback) {
        final Call<NYTimesResponse> call = nyTimesAPI.getResponse();
        call.enqueue(callback);
    }
}

