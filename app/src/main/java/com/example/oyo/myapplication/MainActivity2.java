package com.example.oyo.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends Activity {
    public int t = 3;
    public static final String URL = "https://api.github.com/users";
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button button = findViewById(R.id.button8);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getApplicationContext().getSharedPreferences(Config.SHARED_PREF, 0);
                String token = prefs.getString("regId", null);

                if(!TextUtils.isEmpty(token)){
                Toast.makeText(MainActivity2.this,"FCM Token: "+token,Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity2.this,"FCM Token NULL",Toast.LENGTH_LONG).show();
                }
                Log.i("Token is ", "Token: "+ token);
            }
        });
//        final Handler myHandler = new Handler();
//        myHandler.post(new Runnable() {
//            @Override
//            public void run() {
//                if(t>0){
//                    t--;
//                    myHandler.postDelayed(this,1000);
//                }
//                else{
//                    Toast.makeText(MainActivity2.this,"Timer Stopped",Toast.LENGTH_LONG).show();
//                }
//            }
//        });


    }

    private void storeRegIdInPref(String token) {
        SharedPreferences pref = getSharedPreferences(Config.SHARED_PREF, 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("regId", token);
        editor.commit();
    }


}