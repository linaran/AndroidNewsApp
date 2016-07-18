package com.example.spidey.myapplication.activity.dagger;

import android.support.v4.app.Fragment;

import com.example.spidey.myapplication.activity.NewsListView;
import com.example.spidey.myapplication.activity.NewsListViewAdapter;
import com.example.spidey.myapplication.model.NYTimesService;
import com.example.spidey.myapplication.model.json2java.Doc;
import com.example.spidey.myapplication.presenter.NewsListPresenter;
import com.example.spidey.myapplication.presenter.NewsListPresenterImpl;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public final class FragmentModule {

    private final Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    NewsListPresenter provideNewsListPresenter(NYTimesService nyTimesService) {
        if (fragment instanceof NewsListView) {
            return new NewsListPresenterImpl((NewsListView) fragment, nyTimesService);
        } else {
            throw new IllegalArgumentException("Make sure fragment implements NewsListView before creating NewsListPresenter.");
        }
    }

    @Provides
    @FragmentScope
    NewsListViewAdapter provideNewsListViewAdapter() {
        return new NewsListViewAdapter(fragment.getContext(), new ArrayList<Doc>());
    }
}
