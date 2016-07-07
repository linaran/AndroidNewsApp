package com.example.spidey.myapplication;

import com.example.spidey.myapplication.model.json2java.Doc;
import com.example.spidey.myapplication.presenter.NewsListPresenter;
import com.example.spidey.myapplication.presenter.NewsListPresenterImpl;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Disclaimer: I'm not fancy with writing unit test.
 */
public class ExampleUnitTest {
    @Test
    public void connectionIsCorrect() throws Exception {
        NewsListPresenter presenter = new NewsListPresenterImpl();
        List<Doc> docs = presenter.getDocs();
        Assert.assertEquals(docs.size(), 10);
    }
}