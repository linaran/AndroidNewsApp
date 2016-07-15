package com.example.spidey.myapplication.model;

import com.example.spidey.myapplication.model.json2java.NYTimesResponse;

import retrofit2.Callback;

public interface NYTimesService {
    String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";
    
    void getDocs(Callback<NYTimesResponse> callback);
}
