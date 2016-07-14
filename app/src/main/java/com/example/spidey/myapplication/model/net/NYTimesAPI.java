package com.example.spidey.myapplication.model.net;

import com.example.spidey.myapplication.model.net.json2java.NYTimesResponse;

import retrofit2.Call;
import retrofit2.http.GET;

//http://api.nytimes.com/svc/search/v2/articlesearch.json?q=new+york+times&sort=newest&api-key=3004f196a796792d1014c857af657567:11:72277667

public interface NYTimesAPI {
    String BASE_API_URL = "http://api.nytimes.com";
    String BASE_WWW_URL = "http://www.nytimes.com";

    @GET("/svc/search/v2/articlesearch.json?q=new+york+times&sort=newest&api-key=3004f196a796792d1014c857af657567:11:72277667")
    Call<NYTimesResponse> getResponse();
}
