package com.example.oyo.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class Fragment2 extends Fragment {
    private android.support.v7.widget.RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private ArrayList<String> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        list.add("Sample");
        View rootView = inflater.inflate(R.layout.fragment_fragment2, container, false);
        mRecyclerView = rootView.findViewById(R.id.recyclerview);
        Context context = this.getContext();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mAdapter = new MyAdapter(list, context);
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }

    public void addData(String name) {
        list.add(name);
        mAdapter.notifyDataSetChanged();
//        list.add("2");
//        list.add("3");
//        list.add("4");
//        list.add("5");
//        list.add("6");
//        list.add("7");
    }

}
