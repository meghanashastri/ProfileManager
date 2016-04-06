package com.example.admin.profilemanager.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.admin.profilemanager.R;
import com.example.admin.profilemanager.models.TimeModel;
import com.example.admin.profilemanager.utilities.DatabaseManager;

import java.util.List;

/**
 * Created by Admin on 04-04-2016.
 */
public class TimeAdapter extends BaseAdapter {
    private ListView listView;
    private TextView tvFromTime, tvToTime, tvModeOfPhone;
    private Context context;
    private DatabaseManager databaseOperations;
    private List<TimeModel> items;

    public TimeAdapter(Context context, List<TimeModel> items) {
        this.items = items;
        this.context = context;
        databaseOperations = new DatabaseManager(context);
    }

    public List<TimeModel> getList(){
        return items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_view_row, null);
        }
        listView = (ListView) convertView.findViewById(R.id.lvTimeSetByUser);
        tvFromTime = (TextView) convertView.findViewById(R.id.tvFromTime);
        tvFromTime.setText(items.get(position).getFromTime());
        tvToTime = (TextView) convertView.findViewById(R.id.tvToTime);
        tvToTime.setText(items.get(position).getToTime());
        tvModeOfPhone = (TextView) convertView.findViewById(R.id.tvModeOfPhone);
        tvModeOfPhone.setText(items.get(position).getModeOfPhone());
        return convertView;
    }
}
