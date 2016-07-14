package com.example.spidey.myapplication.model.net;

import com.example.spidey.myapplication.model.net.json2java.NYTimesResponse;

import retrofit2.Callback;

public interface NYTimesService {
    void getDocs(Callback<NYTimesResponse> callback);
}
