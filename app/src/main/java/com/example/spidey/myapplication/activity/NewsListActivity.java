package com.example.spidey.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.spidey.myapplication.R;
import com.example.spidey.myapplication.model.NYTimesDataHandle;
import com.example.spidey.myapplication.presenter.Presenter;
import com.example.spidey.myapplication.presenter.PresenterImpl;

import java.io.IOException;

public class NewsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
    }

}
