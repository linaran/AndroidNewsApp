package com.example.spidey.myapplication.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;

import com.example.spidey.myapplication.model.net.json2java.Doc;

public final class NewsListActivity extends SingleFragmentActivity implements NewsListFragment.NewsListListener {
    @Override
    protected Fragment createFragment() {
        return new NewsListFragment();
    }

    @Override
    public void onDocSelected(Doc doc) {
        Intent newsDetailIntent = new Intent(this, NewsDetailActivity.class);
        newsDetailIntent.putExtra(NewsDetailActivity.DOC_KEY, doc);
        startActivity(newsDetailIntent);
    }
}
