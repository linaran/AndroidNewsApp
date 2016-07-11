package com.example.spidey.myapplication.activity;

import android.support.v4.app.Fragment;

public final class NewsListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new NewsListFragment();
    }
}
