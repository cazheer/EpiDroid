package com.example.sparkh.epiandroid.Adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sparkh.epiandroid.Data.ListLesson;
import com.example.sparkh.epiandroid.Fragment.PopUp.LessonPopUp;
import com.example.sparkh.epiandroid.Fragment.PopUp.TokenPopUp;
import com.example.sparkh.epiandroid.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
public class ListLessonAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    private final ListLesson lessons;
    private final FragmentActivity context;

    public ListLessonAdapter(FragmentActivity context, ListLesson lessons) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.lessons = lessons;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.lessons.day.size();
    }

    @Override
    public Object getItem(int position) {
        return this.lessons.day.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        if (convertView == null) {
            convertView = this.inflater.inflate(R.layout.list_planning, null);
            TextView name = (TextView) convertView.findViewById(R.id.textview_name);
            TextView module = (TextView) convertView.findViewById(R.id.textview_module);
            TextView date = (TextView) convertView.findViewById(R.id.textview_date);
            convertView.setTag(name);
            name.setText(lessons.day.get(position).name);
            module.setText(lessons.day.get(position).nameModule);
            date.setText(lessons.day.get(position).start);

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    Date date = new Date();
                    SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                    try {
                        if (lessons.day.get(position).start != null && date.compareTo(parser.parse(lessons.day.get(position).start)) > 0) {
                            final TokenPopUp popUp = new TokenPopUp();
                            popUp.setLesson(lessons.day.get(position));
                            popUp.show(context.getFragmentManager(), "token");
                        } else {
                            final LessonPopUp popUp = new LessonPopUp();
                            popUp.setLesson(lessons.day.get(position));
                            popUp.show(context.getFragmentManager(), "lesson");
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();

                        final LessonPopUp popUp = new LessonPopUp();
                        popUp.setLesson(lessons.day.get(position));
                        popUp.show(context.getFragmentManager(), "lesson");
                    }
                }
            });
        } else {
            TextView name = (TextView) convertView.findViewById(R.id.textview_name);
            TextView module = (TextView) convertView.findViewById(R.id.textview_module);
            TextView date = (TextView) convertView.findViewById(R.id.textview_date);
            name.setText(lessons.day.get(position).name);
            module.setText(lessons.day.get(position).nameModule);
            date.setText(lessons.day.get(position).start);
        }
        return convertView;
    }
}
