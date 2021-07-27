package com.myapplicationdev.android.demoservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private static final String DEBUG_TAG = MyService.class.getSimpleName();

    private DownloadBinder mBinder = new DownloadBinder();
    private boolean started;


    public MyService() {}

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public void onCreate() {
        Log.d(DEBUG_TAG, "Service created");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        started = true;
        Log.d(DEBUG_TAG, started ? "Service started" : "Service is still running");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d(DEBUG_TAG, "Service stopped");
        super.onDestroy();
    }

    static class DownloadBinder extends Binder {
        public void startDownload() {
            Log.d(DEBUG_TAG, "startDownload executed");
        }
        public int getProgress() {
            Log.d(DEBUG_TAG, "getProgress executed");
            return 0;
        }
    }
}

