package com.example.spidey.myapplication.presenter;

import android.util.Log;

import com.example.spidey.myapplication.model.NYTimesService;
import com.example.spidey.myapplication.model.NYTimesServiceImpl;
import com.example.spidey.myapplication.model.json2java.Doc;
import com.example.spidey.myapplication.model.json2java.NYTimesResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public final class NewsListPresenterImpl implements NewsListPresenter, Callback<NYTimesResponse> {

    private final NYTimesService nyTimesService;

    public NewsListPresenterImpl() {
        nyTimesService = new NYTimesServiceImpl();
    }

    public void getDocs() {
//        TODO: Start loading animation.
        nyTimesService.getArticles(this); //Begin async call.
//        TODO: End loading animation.
    }

    @Override
    public void onResponse(Call<NYTimesResponse> call, Response<NYTimesResponse> response) {
        final List<Doc> documents = response.body().getResponse().getDocs();
        Log.d("DOCS", documents.toString());
//        if (documents.size() == 0) {
////            TODO: Do something GUI.
//        }
//        TODO: Do something GUI.
    }

    @Override
    public void onFailure(Call<NYTimesResponse> call, Throwable t) {
//        TODO: Do something GUI.
    }
}
