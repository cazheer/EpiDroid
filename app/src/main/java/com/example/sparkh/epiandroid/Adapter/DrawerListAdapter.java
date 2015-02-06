package com.example.sparkh.epiandroid.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sparkh.epiandroid.Data.User;
import com.example.sparkh.epiandroid.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 29/01/15.
 */
public class DrawerListAdapter extends BaseAdapter {
    private static final int CONTENT = 0;
    private static final int HEADER = 1;

    private LayoutInflater myInflater;

    private class itemInfo {
        public String value = null;
        public int type = CONTENT;
    }

    private List<itemInfo> data = new ArrayList<>();

    public DrawerListAdapter(Context context) {
        myInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    public void addContentItem(final String value) {
        itemInfo tmp = new itemInfo();

        tmp.value = value;
        tmp.type = CONTENT;

        data.add(tmp);

        notifyDataSetChanged();
    }

    public void addHeaderItem(final String value) {
        itemInfo tmp = new itemInfo();

        tmp.value = value;
        tmp.type = HEADER;

        data.add(tmp);

        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        if (position < data.size())
            return data.get(position).value;
        return null;
    }

    public Integer getItemType(int position) {
        return data.get(position).type;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            switch (getItemType(position)) {
                case CONTENT:
                    convertView = myInflater.inflate(R.layout.content_menu, null);
                    TextView holder = (TextView) convertView.findViewById(R.id.content_item);
                    convertView.setTag(holder);
                    holder.setText(data.get(position).value);
                    break;
                case HEADER:
                    convertView = myInflater.inflate(R.layout.header_menu, null);
                    TextView header = (TextView) convertView.findViewById(R.id.header_menu);
                    convertView.setTag(header);
                    header.setText(data.get(position).value);
                    break;
            }
        } else {
            TextView holder = (TextView) convertView.getTag();
            holder.setText(data.get(position).value);
        }
        return convertView;
    }
}
