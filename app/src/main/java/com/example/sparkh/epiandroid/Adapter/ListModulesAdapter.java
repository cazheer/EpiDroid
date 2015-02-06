package com.example.sparkh.epiandroid.Adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sparkh.epiandroid.Data.ListUserModuleInfo;
import com.example.sparkh.epiandroid.Fragment.PopUp.UnregisterModulePopUp;
import com.example.sparkh.epiandroid.R;

/**
 *
 */
public class ListModulesAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    private final ListUserModuleInfo list;
    private final FragmentActivity context;

    public ListModulesAdapter(FragmentActivity context, ListUserModuleInfo list) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.list.listUserModule.size();
    }

    @Override
    public Object getItem(int position) {
        return this.list.listUserModule.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        if (convertView == null) {
            convertView = this.inflater.inflate(R.layout.list_modules, null);
            TextView name = (TextView) convertView.findViewById(R.id.text_name);
            TextView credit = (TextView) convertView.findViewById(R.id.text_credit);
            TextView grade = (TextView) convertView.findViewById(R.id.text_grade);
            TextView date = (TextView) convertView.findViewById(R.id.text_time);
            convertView.setTag(name);
            name.setText(list.listUserModule.get(position).name);
            credit.setText("crédits : " + list.listUserModule.get(position).credit);
            grade.setText(list.listUserModule.get(position).grade);
            date.setText(list.listUserModule.get(position).semester);

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    final UnregisterModulePopUp popUp = new UnregisterModulePopUp();
                    popUp.setInfo(list.listUserModule.get(position));
                    popUp.show(context.getFragmentManager(), "module");
                }
            });
        } else {
            TextView name = (TextView) convertView.findViewById(R.id.text_name);
            TextView credit = (TextView) convertView.findViewById(R.id.text_credit);
            TextView grade = (TextView) convertView.findViewById(R.id.text_grade);
            TextView date = (TextView) convertView.findViewById(R.id.text_time);
            name.setText(list.listUserModule.get(position).name);
            credit.setText("crédits : " + list.listUserModule.get(position).credit);
            grade.setText(list.listUserModule.get(position).grade);
            date.setText(list.listUserModule.get(position).semester);
        }
        return convertView;
    }
}
