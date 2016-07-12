package com.example.spidey.myapplication.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.spidey.myapplication.R;
import com.example.spidey.myapplication.model.json2java.Doc;

public final class NewsDetailFragment extends Fragment {

    public static final String DOC_KEY = "NewsDetailFragment.DOC_KEY";

    private Doc document;

    public static NewsDetailFragment newInstance(Doc document) {
        NewsDetailFragment fragment = new NewsDetailFragment();

        Bundle args = new Bundle();
        args.putParcelable(DOC_KEY, document);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        document = args.getParcelable(DOC_KEY);
        if (document == null) {
            throw new NullPointerException("This fragment requires a Doc object in order to work properly.");
        }

        Log.d("DEBUG", "Loaded: " + document.toString());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_news_detail, container, false);
        return view;
    }
}
