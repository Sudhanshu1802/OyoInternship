package com.example.oyo.myapplication;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ExampleActivity extends AppCompatActivity {
    MyService mService;
    boolean mBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_activity);
        Intent intent = getIntent();
        String message = "Hello, " + intent.getStringExtra(MainActivity.MESSAGE);

        TextView textView = findViewById(R.id.textView);
        textView.setText(message);
    }
    public void goToRecycler(View v){
        Intent intent = new Intent(this,MyRecyclerView.class);
        startActivity(intent);
    }

    public void startService(View v){
        Intent intent = new Intent(this, MyService.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);

    }

    private void setContext(Context context) {

    }

    public void stopService(View v){
        Intent intent = new Intent(this,MyService.class);
        stopService(intent);

    }
    public void onButtonClick(View v) {
        if (mBound) {
            // Call a method from the LocalService.
            // However, if this call were something that might hang, then this request should
            // occur in a separate thread to avoid slowing down the activity performance.
            int num = mService.getRandomNumber();
            Toast.makeText(this,"number: " + num,Toast.LENGTH_SHORT).show();
        }
    }
    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            MyService.MyBinder binder = (MyService.MyBinder) service;
            mService = binder.getService();

            mBound = true;
        }
        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            mBound = false;
        }
    };

}
