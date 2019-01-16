package com.example.oyo.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class Fragment1 extends Fragment {

    private View view;
    OnListAddListener onListAddListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_fragment1, container, false);
        final EditText editText = view.findViewById(R.id.editText2);
        View button = view.findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                onListAddListener.addItem(name);
            }
        });
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity a = (Activity)context;
        try {
            onListAddListener = (OnListAddListener) a;
        }
        catch (Exception e){}
    }
    public interface OnListAddListener{
        public void addItem(String Item);
    }


    public void addToList(){
        EditText e = view.findViewById(R.id.editText2);
        String item = e.getText().toString();
        Fragment2 listItem = new Fragment2();
        Bundle args = new Bundle();
        args.putString("YourKey", "YourValue");
        listItem.setArguments(args);
        getFragmentManager().beginTransaction().add(R.id.fragment2, listItem).commit();
    }
}
