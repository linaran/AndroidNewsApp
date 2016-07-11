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
import android.widget.TextView;

import com.example.spidey.myapplication.R;
import com.example.spidey.myapplication.model.json2java.Doc;
import com.example.spidey.myapplication.presenter.NewsListPresenter;
import com.example.spidey.myapplication.presenter.NewsListPresenterImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public final class NewsListFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, NewsListView {

    @BindView(R.id.newslist_swipe_refresh)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.newslist_listview)
    ListView listView;

    @BindView(R.id.newslist_feed_unavailable)
    TextView feedUnavailable;

    private NewsListPresenter newsListPresenter;
    private NewsListViewAdapter newsListViewAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (newsListPresenter == null) {
            newsListPresenter = new NewsListPresenterImpl(this);
        }

        newsListViewAdapter = new NewsListViewAdapter(getContext(), new ArrayList<Doc>());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_news_list, container, false);
        ButterKnife.bind(this, view);

        swipeRefreshLayout.setOnRefreshListener(this);

        newsListPresenter.getDocs();
        listView.setAdapter(newsListViewAdapter);

        return view;
    }

    @Override
    public void onRefresh() {
        Log.d("DOCS", "Refresh!");
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
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public void showFeedUnavailable() {
        newsListViewAdapter.clear();
        feedUnavailable.setVisibility(View.VISIBLE);
    }

//    I'm not calling this anywhere but it seems silly to have an interface
//    where you can show a message but can't hide it.
    @Override
    public void hideFeedUnavailable() {
        feedUnavailable.setVisibility(View.INVISIBLE);
    }

    @Override
    public void renderDocs(List<Doc> documents) {
//        I could call hideFeedUnavailable here.
        if (feedUnavailable.getVisibility() == View.VISIBLE) {
            swipeRefreshLayout.setVisibility(View.VISIBLE);
            feedUnavailable.setVisibility(View.INVISIBLE);
        }

        newsListViewAdapter.clear();
        newsListViewAdapter.addAll(documents);
        Log.d("DOCS", documents.toString());
    }
}
