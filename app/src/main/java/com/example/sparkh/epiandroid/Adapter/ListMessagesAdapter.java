package com.example.sparkh.epiandroid.Adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sparkh.epiandroid.Data.ListMessage;
import com.example.sparkh.epiandroid.R;

import java.util.List;

/**
 *
 */
public class ListMessagesAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    private final ListMessage messages;

    public ListMessagesAdapter(FragmentActivity context, ListMessage messages) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.messages = messages;
    }

    @Override
    public int getCount() {
        return this.messages.listMessage.size();
    }

    @Override
    public Object getItem(int position) {
        return this.messages.listMessage.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = this.inflater.inflate(R.layout.list_messages, null);
            TextView date = (TextView) convertView.findViewById(R.id.textView_date);
            TextView text = (TextView) convertView.findViewById(R.id.textView_element);
            convertView.setTag(text);
            date.setText(Html.fromHtml(messages.listMessage.get(position).date));
            text.setText(Html.fromHtml(messages.listMessage.get(position).message));
        }
        else {
            TextView date = (TextView) convertView.findViewById(R.id.textView_date);
            TextView text = (TextView)convertView.getTag();
            date.setText(Html.fromHtml(messages.listMessage.get(position).date));
            text.setText(Html.fromHtml(messages.listMessage.get(position).message));
        }
        return convertView;
    }
}
