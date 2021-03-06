package com.example.spidey.myapplication.presenter;

import android.util.Log;

import com.example.spidey.myapplication.activity.NewsListView;
import com.example.spidey.myapplication.model.NYTimesService;
import com.example.spidey.myapplication.model.json2java.Doc;
import com.example.spidey.myapplication.model.json2java.NYTimesResponse;

import java.lang.ref.WeakReference;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public final class NewsListPresenterImpl implements NewsListPresenter, Callback<NYTimesResponse> {

    private final NYTimesService nyTimesService;
    private final WeakReference<NewsListView> newsListViewWeakReference;

    public NewsListPresenterImpl(NewsListView newsListView, NYTimesService nyTimesService) {
        this.nyTimesService = nyTimesService;
        newsListViewWeakReference = new WeakReference<>(newsListView);
    }

    public void getDocs() {
        final NewsListView view = newsListViewWeakReference.get();
        if (view != null) {
            view.startRefresh();
        }

        nyTimesService.getDocs(this); //Begin async call.
    }

    @Override
    public void onResponse(Call<NYTimesResponse> call, Response<NYTimesResponse> response) {
        final List<Doc> documents = response.body().getResponse().getDocs();
        final NewsListView view = newsListViewWeakReference.get();

        if (view != null) {
            view.stopRefresh();

            if (documents.size() == 0) {
                view.showFeedUnavailable();
            } else {
                view.renderDocs(documents);
            }
        }
    }

    @Override
    public void onFailure(Call<NYTimesResponse> call, Throwable t) {
        final NewsListView view = newsListViewWeakReference.get();
        if (view != null) {
            view.showFeedUnavailable();
            view.stopRefresh();
        }
        Log.d("DOCS", "Armageddon");
    }
}
