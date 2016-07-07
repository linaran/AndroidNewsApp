package com.example.spidey.myapplication.model;

import com.example.spidey.myapplication.model.json2java.NYTimesResponse;

import retrofit2.Callback;

public interface NYTimesService {
    void getDocs(Callback<NYTimesResponse> callback);
}
