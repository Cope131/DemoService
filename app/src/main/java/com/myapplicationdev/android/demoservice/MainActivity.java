package com.myapplicationdev.android.demoservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Intent serviceIntent;
    private MyServiceConnection myServiceConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        serviceIntent = new Intent(this, MyService.class);;
        myServiceConnection = new MyServiceConnection();
    }

    private void initViews() {
        Button startBtn, stopBtn, bindBtn, unbindBtn;
        startBtn = findViewById(R.id.start_button);
        stopBtn = findViewById(R.id.stop_button);
        bindBtn = findViewById(R.id.bind_sevice_button);
        unbindBtn = findViewById(R.id.unbind_service_button);

        startBtn.setOnClickListener(this);
        stopBtn.setOnClickListener(this);
        bindBtn.setOnClickListener(this);
        unbindBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (serviceIntent == null) return;
        switch (v.getId()) {
            case R.id.start_button:     
                startService();
                break;
            case R.id.stop_button:
                stopService();
                break;
            case R.id.bind_sevice_button:
                bindService();
                break;
            case R.id.unbind_service_button:
                unbindService();
        }
    }

    private void unbindService() {
        unbindService(myServiceConnection);
    }

    private void bindService() {
        bindService(serviceIntent, myServiceConnection, BIND_AUTO_CREATE);
    }

    private void stopService() {
        stopService(serviceIntent);
    }

    private void startService() {
        startService(serviceIntent);
    }

}