package com.example.oyo.myapplication;

import android.os.AsyncTask;

class MyTask extends AsyncTask<String, String, Void> {

    @Override
    protected Void doInBackground(String... uri) {

        return null;
    }
    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
        //Do anything with response..
    }
}