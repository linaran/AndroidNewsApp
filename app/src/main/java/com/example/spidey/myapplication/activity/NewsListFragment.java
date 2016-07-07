package com.example.spidey.myapplication.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.spidey.myapplication.R;
import com.example.spidey.myapplication.presenter.NewsListPresenter;
import com.example.spidey.myapplication.presenter.NewsListPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

public final class NewsListFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, NewsListView {

    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.newsList)
    ListView listView;

    private NewsListPresenter newsListPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (newsListPresenter == null) {
            newsListPresenter = new NewsListPresenterImpl(this);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_list, container, false);
        ButterKnife.bind(this, view);

        swipeRefreshLayout.setOnRefreshListener(this);

        newsListPresenter.getDocs();

        return view;
    }

//    public static NewsListFragment newInstance() {
////        Bundle action.
//        NewsListFragment fragment = new NewsListFragment();
////        fragment.setArguments();
//
//        return fragment;
//    }

    @Override
    public void onRefresh() {
        Log.d("Events", "Refresh!");
        newsListPresenter.getDocs();
    }

    @Override
    public void startRefresh() {
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
            }
        });
    }

    @Override
    public void stopRefresh() {
        swipeRefreshLayout.setRefreshing(false);
    }
}
