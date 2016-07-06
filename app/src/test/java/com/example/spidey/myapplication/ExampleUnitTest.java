package com.example.spidey.myapplication;

import com.example.spidey.myapplication.model.json2java.Doc;
import com.example.spidey.myapplication.presenter.Presenter;
import com.example.spidey.myapplication.presenter.PresenterImpl;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Disclaimer: I'm not fancy with writing unit test.
 */
public class ExampleUnitTest {
    @Test
    public void connectionIsCorrect() throws Exception {
        Presenter presenter = new PresenterImpl();
        List<Doc> docs = presenter.getDocs();
        Assert.assertEquals(docs.size(), 10);
    }
}