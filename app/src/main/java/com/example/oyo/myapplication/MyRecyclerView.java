package com.example.oyo.myapplication;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MyRecyclerView extends AppCompatActivity implements Fragment1.OnListAddListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
    }


    @Override
    public void addItem(String item) {
        Fragment2 ff = (Fragment2) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        ff.addData(item);
    }
}
