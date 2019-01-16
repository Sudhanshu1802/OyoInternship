package com.example.oyo.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
        db.execSQL("create table " +TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,FIRST_NAME TEXT, LAST_NAME TEXT,EMAIL TEXT,MOB TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+ TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String fname, String lname, String email, String Mob){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,fname);
        contentValues.put(COL3,lname);
        contentValues.put(COL4,email);
        contentValues.put(COL5, Mob);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result==-1) return false;
        else return true;
    }
    public Cursor viewData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("select * from " + TABLE_NAME,null);
        return data;
    }
    public void UpdateData(String id,String fname, String lname, String email, String Mob){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1,id);
        contentValues.put(COL2,fname);
        contentValues.put(COL3,lname);
        contentValues.put(COL4,email);
        contentValues.put(COL5, Mob);
        db.update(TABLE_NAME,contentValues,"id=?",new String[] {id});

    }
    public void DeleteEntry(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME,"ID = ?",new String[] {id});

    }
}
