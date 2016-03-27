package com.example.admin.profilemanager.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.admin.profilemanager.R;

/**
 * Created by Admin on 27-03-2016.
 */
public class SplashScreen extends AppCompatActivity {
    private boolean isActivityStopped = false;
    private static final int THREAD_SLEEP_TIME = 1200;//in milliseconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_sreen);
        startThread();
    }

    public Runnable sleepRunnable = new Runnable() {
        public void run() {
            try {
                Thread.sleep(THREAD_SLEEP_TIME);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!isActivityStopped) {
                goToNextActivity();
            }
        }
    };

    protected void goToNextActivity() {
        Intent intent = new Intent();
        intent.setClass(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        isActivityStopped = true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        isActivityStopped = false;

    }

    private void startThread() {
        Thread sleeper = new Thread(sleepRunnable);
        sleeper.start();
    }
}
