package com.example.spidey.myapplication.presenter;

import com.example.spidey.myapplication.model.NYTimesService;
import com.example.spidey.myapplication.model.json2java.Doc;
import com.example.spidey.myapplication.model.NYTimesServiceImpl;

import java.io.IOException;
import java.util.List;

public class NewsListPresenterImpl implements NewsListPresenter {

    private NYTimesService nyTimesService;

    public NewsListPresenterImpl() {
        nyTimesService = new NYTimesServiceImpl();
    }

    public List<Doc> getDocs() {

//        TODO: Start loading animation.

        List<Doc> retValue = null;
        try {
            retValue = nyTimesService.getArticles();
        } catch (IOException e) {
            //        TODO: GUI handle IOException.
            e.printStackTrace();
        }

//        assert retValue != null;
//        Log.d("DATA", retValue.toString());

//        TODO: End loading animation.

        return retValue;
    }
}
