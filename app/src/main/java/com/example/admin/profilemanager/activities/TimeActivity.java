package com.example.admin.profilemanager.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.admin.profilemanager.R;
import com.example.admin.profilemanager.adapters.TimeAdapter;
import com.example.admin.profilemanager.utilities.DatabaseManager;

/**
 * Created by Admin on 03-04-2016.
 */
public class TimeActivity extends AppCompatActivity implements View.OnClickListener{

    private TimeAdapter adapter;
    private DatabaseManager databaseManager;
    private ListView listView;
    private RelativeLayout noEvents;
    private android.support.v7.widget.Toolbar toolbar;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        initialiseToolBar();
        initialiseViews();
    }

    private void initialiseToolBar() {
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.TimerColor));
        TextView textView = (TextView) findViewById(R.id.tvTitle);
        textView.setText(R.string.tvSetTime);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initialiseViews() {
        databaseManager = new DatabaseManager(this);
        listView = (ListView) findViewById(R.id.lvTimeSetByUser);
        noEvents = (RelativeLayout) findViewById(R.id.noEvents);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btnAdd:
                goToNextActivity(SetTimerActivity.class);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        showData();
    }

    protected void goToNextActivity(Class nextActivity) {
        Intent intent = new Intent();
        intent.setClass(this, nextActivity);
        startActivity(intent);
    }

    private void showData() {

        if (adapter == null) {
            adapter = new TimeAdapter(TimeActivity.this, databaseManager.getDetailsFromTimeTable());
            listView.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }

        if (adapter != null && adapter.getList().size() > 0) {
            listView.setVisibility(View.VISIBLE);
            noEvents.setVisibility(View.GONE);
        } else {
            listView.setVisibility(View.GONE);
            noEvents.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btnAdd : goToNextActivity(SetTimerActivity.class);
                break;
        }
    }
}
