package com.example.spidey.myapplication.activity.dagger;

import android.support.v4.app.Fragment;

import com.example.spidey.myapplication.activity.NewsListView;
import com.example.spidey.myapplication.presenter.NewsListPresenter;
import com.example.spidey.myapplication.presenter.NewsListPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {

    private final Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    NewsListPresenter provideNewsListPresenter() {
        return new NewsListPresenterImpl((NewsListView) fragment);
    }
}
