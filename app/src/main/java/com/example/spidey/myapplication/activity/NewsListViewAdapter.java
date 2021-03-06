package com.example.spidey.myapplication.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.spidey.myapplication.R;
import com.example.spidey.myapplication.model.NYTimesAPI;
import com.example.spidey.myapplication.model.json2java.Doc;
import com.example.spidey.myapplication.model.json2java.Multimedium;
import com.example.spidey.myapplication.util.URLUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public final class NewsListViewAdapter extends ArrayAdapter<Doc> {

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
        viewHolder.fillView(getContext(), item);

        return convertView;
    }

    public static final class ViewHolder {
        @BindView(R.id.newslist_listview_item_printheadline)
        TextView printHeadline;

        @BindView(R.id.newslist_listview_item_image)
        ImageView image;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

        public void fillView(Context context, Doc item) {
            if (item != null) {
                printHeadline.setText(item.getHeadline().getMain());

                final List<Multimedium> multimedia = item.getMultimedia();
                if (multimedia != null && multimedia.size() != 0) {
                    final String imageRelativeURL = multimedia.get(0).getUrl();
                    Picasso.with(context)
                            .load(URLUtils.makeURL(NYTimesAPI.BASE_WWW_URL, imageRelativeURL))
                            .placeholder(android.R.drawable.ic_menu_help)
                            .error(android.R.drawable.ic_menu_help)
                            .into(image);
                } else {
                    Picasso.with(context).load(android.R.drawable.ic_menu_help).into(image);
                }
            } else {
                Picasso.with(context).load(android.R.drawable.ic_menu_help).into(image);
            }
        }
    }
}
