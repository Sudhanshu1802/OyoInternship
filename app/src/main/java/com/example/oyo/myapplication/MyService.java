package com.example.oyo.myapplication;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static java.lang.Thread.sleep;

public class MyService extends Service {

    int currentRandomNumber =0;
    private final Random mGenerator = new Random();
    public IBinder myBinder = new MyBinder();
    final class TheThread implements Runnable {
        int serviceId;

        TheThread(int serviceId) {
            this.serviceId = serviceId;
        }

        @Override
        public void run() {

            while(true)
            {
                currentRandomNumber = mGenerator.nextInt(100);
                Log.d("MyService",""+currentRandomNumber);
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public class MyBinder extends Binder{
        MyService getService(){
            return MyService.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Thread thread = new Thread(new TheThread(startId));
        thread.start();
        Toast.makeText(MyService.this, "Service Started", Toast.LENGTH_LONG).show();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(MyService.this, "Service Stopped", Toast.LENGTH_LONG).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    public int getRandomNumber() {
        return currentRandomNumber;
    }
}
