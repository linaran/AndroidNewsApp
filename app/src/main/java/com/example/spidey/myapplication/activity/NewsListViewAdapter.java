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

public final class NewsListViewAdapter extends ArrayAdapter<Doc> {

    private static final class ViewHolder {
        private TextView itemView;
    }

    public NewsListViewAdapter(Context context, int resource, List<Doc> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.news_list_item_view, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.itemView = (TextView) convertView.findViewById(R.id.newsListItemView);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Doc item = getItem(position);
        if (item != null) {
            viewHolder.itemView.setText(item.getHeadline().getPrintHeadline());
        }

        return convertView;
    }
}
