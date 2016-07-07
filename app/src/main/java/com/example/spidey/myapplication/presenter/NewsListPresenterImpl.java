package com.example.spidey.myapplication.presenter;

import com.example.spidey.myapplication.model.NYTimesService;
import com.example.spidey.myapplication.model.json2java.Doc;
import com.example.spidey.myapplication.model.NYTimesServiceImpl;

import java.io.IOException;
import java.util.List;

public final class NewsListPresenterImpl implements NewsListPresenter {

    private NYTimesService nyTimesService;

    public NewsListPresenterImpl() {
        nyTimesService = new NYTimesServiceImpl();
    }

    public List<Doc> getDocs() {

//        TODO: Start loading animation.

        List<Doc> documents = null;
        try {
            documents = nyTimesService.getArticles();
        } catch (IOException e) {
            //        TODO: GUI handle IOException.
            e.printStackTrace();
        }

        if (documents == null || documents.size() == 0) {
            throw new NullPointerException("No data to be pulled from the endpoint.");
        }
//        Log.d("DATA", documents.toString());

//        TODO: End loading animation.

        return documents;
    }
}
