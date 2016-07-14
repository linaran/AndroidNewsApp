package com.example.spidey.myapplication.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.spidey.myapplication.R;
import com.example.spidey.myapplication.model.net.NYTimesAPI;
import com.example.spidey.myapplication.model.net.json2java.Doc;
import com.example.spidey.myapplication.model.net.json2java.Multimedium;
import com.example.spidey.myapplication.util.URLUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public final class NewsDetailFragment extends Fragment {

    public static final String DOC_KEY = "NewsDetailFragment.DOC_KEY";

    @BindView(R.id.news_detail_image)
    ImageView image;

    @BindView(R.id.news_detail_title)
    TextView title;

    @BindView(R.id.news_detail_text)
    TextView mainText;

    private Doc document;

    public static NewsDetailFragment newInstance(Doc document) {
        final NewsDetailFragment fragment = new NewsDetailFragment();

        Bundle args = new Bundle();
        args.putParcelable(DOC_KEY, document);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Bundle args = getArguments();
        document = args.getParcelable(DOC_KEY);
        if (document == null) {
            throw new IllegalArgumentException("This fragment requires a Doc object in order to work properly.");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_news_detail, container, false);
        ButterKnife.bind(this, view);

        final List<Multimedium> multimedia = document.getMultimedia();
        if (multimedia != null && multimedia.size() != 0) {
            final String imageRelativeURL = multimedia.get(0).getUrl();
            Picasso.with(getContext())
                    .load(URLUtils.makeURL(NYTimesAPI.BASE_WWW_URL, imageRelativeURL))
                    .placeholder(android.R.drawable.ic_menu_help)
                    .error(android.R.drawable.ic_menu_help)
                    .into(image);
        } else {
            Picasso.with(getContext())
                    .load(android.R.drawable.ic_menu_help)
                    .into(image);
        }
        title.setText(document.getHeadline().getMain());
        mainText.setText(document.getLeadParagraph());

        return view;
    }
}
