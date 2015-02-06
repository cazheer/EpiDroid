package com.example.sparkh.epiandroid.Adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sparkh.epiandroid.Data.ListProject;
import com.example.sparkh.epiandroid.Fragment.PopUp.RegisterProjectPopUp;
import com.example.sparkh.epiandroid.R;

/**
 * Created by root on 04/02/15.
 */
public class ListProjectAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    private final ListProject list;
    private final FragmentActivity context;

    public ListProjectAdapter(FragmentActivity context, ListProject list) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.list.listProject.size();
    }

    @Override
    public Object getItem(int position) {
        return this.list.listProject.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        if (convertView == null) {
            convertView = this.inflater.inflate(R.layout.list_project, null);
            TextView name = (TextView) convertView.findViewById(R.id.text_name);
            TextView module = (TextView) convertView.findViewById(R.id.text_module);
            TextView registered = (TextView) convertView.findViewById(R.id.text_registered);
            TextView date = (TextView) convertView.findViewById(R.id.text_time);
            convertView.setTag(name);
            name.setText(list.listProject.get(position).nameProject);
            module.setText(list.listProject.get(position).nameModule);
            registered.setText(list.listProject.get(position).isRegistered ? "Registered" : "Not registered");
            date.setText(list.listProject.get(position).startActivity + " - " + list.listProject.get(position).endActivity);

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    final RegisterProjectPopUp popUp = new RegisterProjectPopUp();
                    popUp.setInfo(list.listProject.get(position));
                    popUp.show(context.getFragmentManager(), "module");
                }
            });
        } else {
            TextView name = (TextView) convertView.findViewById(R.id.text_name);
            TextView module = (TextView) convertView.findViewById(R.id.text_module);
            TextView registered = (TextView) convertView.findViewById(R.id.text_registered);
            TextView date = (TextView) convertView.findViewById(R.id.text_time);
            name.setText(list.listProject.get(position).nameProject);
            module.setText(list.listProject.get(position).nameModule);
            registered.setText(list.listProject.get(position).isRegistered ? "Registered" : "Not registered");
            date.setText(list.listProject.get(position).startActivity + " - " + list.listProject.get(position).endActivity);
        }
        return convertView;
    }
}