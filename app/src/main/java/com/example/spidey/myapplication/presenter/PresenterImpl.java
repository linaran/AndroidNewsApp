package com.example.spidey.myapplication.presenter;

import com.example.spidey.myapplication.model.json2java.Doc;
import com.example.spidey.myapplication.model.NYTimesDataHandle;

import java.io.IOException;
import java.util.List;

public class PresenterImpl implements Presenter {

    private NYTimesDataHandle dataHandle;

    public PresenterImpl() {
        dataHandle = new NYTimesDataHandle();
    }

    public List<Doc> getDocs() {

//        TODO: Start loading animation.

        List<Doc> retValue = null;
        try {
            retValue = dataHandle.getArticles();
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
