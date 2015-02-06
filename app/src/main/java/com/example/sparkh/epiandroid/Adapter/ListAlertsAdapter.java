package com.example.sparkh.epiandroid.Adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sparkh.epiandroid.Data.ListAlert;
import com.example.sparkh.epiandroid.R;

/**
 *
 */
public class ListAlertsAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    private final ListAlert alerts;

    public ListAlertsAdapter(FragmentActivity context, ListAlert alerts) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.alerts = alerts;
    }

    @Override
    public int getCount() {
        return this.alerts.listAlert.size();
    }

    @Override
    public Object getItem(int position) {
        return this.alerts.listAlert.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = this.inflater.inflate(R.layout.list_alerts, null);
            TextView text = (TextView) convertView.findViewById(R.id.textView_element);
            convertView.setTag(text);
            text.setText(Html.fromHtml(alerts.listAlert.get(position)));
        }
        else {
            TextView text = (TextView)convertView.getTag();
            text.setText(Html.fromHtml(alerts.listAlert.get(position)));
        }
        return convertView;
    }
}
