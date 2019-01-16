package com.example.oyo.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends Activity {
    public static final String MESSAGE = "hello";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
    }
    public void getData(View v){
        Toast.makeText(MainActivity.this, "Method Called", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this,GlideNApiCall.class);
        startActivity(intent);
    }
    public void SendName(View v) {
        Intent intent = new Intent(this, ExampleActivity.class);
        EditText e = findViewById(R.id.editText);
        String message = e.getText().toString();
        intent.putExtra(MESSAGE, message);
        startActivity(intent);
    }

    // ...
}