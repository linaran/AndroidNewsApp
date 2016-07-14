package com.example.spidey.myapplication.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.spidey.myapplication.R;
import com.example.spidey.myapplication.model.net.json2java.Doc;
import com.example.spidey.myapplication.presenter.NewsListPresenter;
import com.example.spidey.myapplication.presenter.NewsListPresenterImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public final class NewsListFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, NewsListView, ListView.OnItemClickListener {

    public interface NewsListListener {
        void onDocSelected(Doc doc);
    }

    @BindView(R.id.newslist_swipe_refresh)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.newslist_listview)
    ListView listView;

    @BindView(R.id.newslist_feed_unavailable)
    TextView feedUnavailable;

    private NewsListPresenter newsListPresenter;
    private NewsListViewAdapter newsListViewAdapter;
    private NewsListListener listener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (newsListPresenter == null) {
            newsListPresenter = new NewsListPresenterImpl(this);
        }

        newsListViewAdapter = new NewsListViewAdapter(getContext(), new ArrayList<Doc>());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof NewsListListener) {
            listener = (NewsListListener) context;
        }
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
        if (feedUnavailable.getVisibility() == View.VISIBLE) {
            swipeRefreshLayout.setVisibility(View.VISIBLE);
            feedUnavailable.setVisibility(View.INVISIBLE);
        }

        newsListViewAdapter.clear();
        newsListViewAdapter.addAll(documents);
    }

    @OnItemClick(R.id.newslist_listview)
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Doc item = newsListViewAdapter.getItem(position);

        if (listener != null) {
            listener.onDocSelected(item);
        }
    }
}
