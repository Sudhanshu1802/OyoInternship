package com.example.oyo.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "MY_DATABASE";
    public static final String TABLE_NAME = "SAMPLE_TABLE";
    public static final String COL1 = "ID";
    public static final String COL2 = "FIRST_NAME";
    public static final String COL3 = "LAST_NAME";
    public static final String COL4 = "EMAIL";
    public static final String COL5 = "MOB";



    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " +TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,FIRST_NAME TEXT, LAST_NAME TEXT,EMAIL TEXT,MOB NUMBER )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+ TABLE_NAME);
        onCreate(db);
    }
}
