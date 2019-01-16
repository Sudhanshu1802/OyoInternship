package com.example.oyo.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import static java.lang.Thread.sleep;

public class GlideNApiCall extends AppCompatActivity {
    public static final String URL = "https://jsonplaceholder.typicode.com/todos/";
    private User[] users;
    RecyclerView view;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_napi_call);
        view = findViewById(R.id.glide_recycle);
        callAPI();
    }

    private void callAPI() {

        RequestQueue qu = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(GlideNApiCall.this, "Data Fetched", Toast.LENGTH_LONG).show();
                Log.i("Response : ", response);
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                users = gson.fromJson(response, User[].class);
                Log.d("Uss", "onCreate: "+users[1].getId());
                setLayout();
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(GlideNApiCall.this, "Some Error is there", Toast.LENGTH_LONG).show();
            }
        });
        qu.add(request);

    }
    public void setLayout(){
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(new GlideAdapter(users,context));
    }
}
