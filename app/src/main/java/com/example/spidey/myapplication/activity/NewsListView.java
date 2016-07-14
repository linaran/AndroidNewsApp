package com.example.spidey.myapplication.activity;

import com.example.spidey.myapplication.model.net.json2java.Doc;

import java.util.List;

public interface NewsListView {
    void startRefresh();

    void stopRefresh();

    void showFeedUnavailable();

    void hideFeedUnavailable();

    void renderDocs(List<Doc> documents);
}
