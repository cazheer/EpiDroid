package com.example.sparkh.epiandroid.Adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sparkh.epiandroid.Data.ListMark;
import com.example.sparkh.epiandroid.R;

/**
 *
 */
public class ListMarksAdapter  extends BaseAdapter {
    private final LayoutInflater inflater;
    private final ListMark marks;

    public ListMarksAdapter(FragmentActivity context, ListMark marks) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.marks = marks;
    }

    @Override
    public int getCount() {
        return this.marks.listMark.size();
    }

    @Override
    public Object getItem(int position) {
        return this.marks.listMark.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = this.inflater.inflate(R.layout.list_marks, null);
            TextView name = (TextView) convertView.findViewById(R.id.textView_name);
            TextView date = (TextView) convertView.findViewById(R.id.textView_date);
            TextView mark = (TextView) convertView.findViewById(R.id.textView_mark);
            convertView.setTag(name);
            name.setText(marks.listMark.get(position).name);
            date.setText(marks.listMark.get(position).date);
            mark.setText(String.valueOf(marks.listMark.get(position).note));
        }
        else {
            TextView name = (TextView) convertView.findViewById(R.id.textView_name);
            TextView date = (TextView) convertView.findViewById(R.id.textView_date);
            TextView mark = (TextView) convertView.findViewById(R.id.textView_mark);
            name.setText(marks.listMark.get(position).name);
            date.setText(marks.listMark.get(position).date);
            mark.setText(String.valueOf(marks.listMark.get(position).note));
        }
        return convertView;
    }
}
