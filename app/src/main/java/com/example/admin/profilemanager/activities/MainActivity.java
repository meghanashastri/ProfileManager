package com.example.admin.profilemanager.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.admin.profilemanager.R;

/**
 * Created by Admin on 27-03-2016.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RelativeLayout tvMovementOfUser,tvTimer,tvBatteryOfPhone,tvLocationOfUser;
    private android.support.v7.widget.Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialseToolbar();
        initialiseViews();
    }
    public void initialiseViews(){

        tvLocationOfUser=(RelativeLayout) findViewById(R.id.location);
        tvLocationOfUser.setOnClickListener(this);
        tvMovementOfUser=(RelativeLayout) findViewById(R.id.movement);
        tvMovementOfUser.setOnClickListener(this);
        tvTimer=(RelativeLayout) findViewById(R.id.timer);
        tvTimer.setOnClickListener(this);
        tvBatteryOfPhone=(RelativeLayout) findViewById(R.id.battery);
        tvBatteryOfPhone.setOnClickListener(this);
    }

    private void initialseToolbar(){
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.timer:
                goToNextActivity(TimeActivity.class);
                break;
            case R.id.movement:
               goToNextActivity(MovementActivity.class);
                break;
            case R.id.battery:
                goToNextActivity(BatteryActivity.class);
                break;
            case R.id.location:
                goToNextActivity(LocationActivity.class);
                break;
        }

    }

    protected void goToNextActivity(Class nextActivity) {
        Intent intent = new Intent();
        intent.setClass(this, nextActivity);
        startActivity(intent);
    }

}
