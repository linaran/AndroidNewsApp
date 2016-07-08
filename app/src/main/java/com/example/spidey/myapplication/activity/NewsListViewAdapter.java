package com.example.spidey.myapplication.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.spidey.myapplication.R;
import com.example.spidey.myapplication.model.json2java.Doc;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public final class NewsListViewAdapter extends ArrayAdapter<Doc> {

    public static final class ViewHolder {
        @BindView(R.id.newslist_listview_item_printheadline)
        TextView printHeadline;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    public NewsListViewAdapter(Context context, List<Doc> objects) {
        super(context, R.layout.news_listview_item, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.news_listview_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Doc item = getItem(position);
        if (item != null) {
            String printHeadline = item.getHeadline().getPrintHeadline();
            if (printHeadline == null || printHeadline.equals("null")) {
                viewHolder.printHeadline.setText(R.string.no_headline);
            } else {
                viewHolder.printHeadline.setText(printHeadline);
            }
        }

        return convertView;
    }
}
