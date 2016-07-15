package com.example.spidey.myapplication.model;

import com.example.spidey.myapplication.model.json2java.NYTimesResponse;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public final class NYTimesServiceImpl implements NYTimesService {

    @Inject
    Retrofit retrofit;

    private final NYTimesAPI nyTimesAPI;

    public NYTimesServiceImpl() {
        DaggerNetComponent.builder()
                .netModule(new NetModule(NYTimesAPI.BASE_API_URL, DATE_FORMAT))
                .build()
                .inject(this);

        nyTimesAPI = retrofit.create(NYTimesAPI.class);
    }

    @Override
    public void getDocs(final Callback<NYTimesResponse> callback) {
        final Call<NYTimesResponse> call = nyTimesAPI.getResponse();
        call.enqueue(callback);
    }
}
