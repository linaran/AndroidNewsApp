package com.example.spidey.myapplication.activity;

import android.support.v4.app.Fragment;

import com.example.spidey.myapplication.model.json2java.Doc;

// Reused!
public final class NewsDetailActivity extends SingleFragmentActivity {

    public static final String DOC_KEY = "NewsDetailActivity.DOC_KEY";

    @Override
    protected Fragment createFragment() {
        Doc item = getIntent().getParcelableExtra(DOC_KEY);
        return NewsDetailFragment.newInstance(item);
    }
}
