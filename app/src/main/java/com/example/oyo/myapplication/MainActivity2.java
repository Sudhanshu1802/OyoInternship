package com.example.oyo.myapplication;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends Activity {
    public int t = 3;
    public static final String URL = "https://api.github.com/users";
    private Context mContext;
    public EditText editFname,editLname,editEmail,editMob,editID;
    public Button btn,view_btn,update_btn,delete_btn;
    public MyDatabase myDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        myDatabase = new MyDatabase(this);
        editFname = findViewById(R.id.editText3);
        editLname = findViewById(R.id.editText4);
        editEmail = findViewById(R.id.editText5);
        editMob = findViewById(R.id.editText6);
        editID = findViewById(R.id.editText7);
        btn = findViewById(R.id.button8);
        view_btn = findViewById(R.id.view_data);
        update_btn = findViewById(R.id.update_data);
        delete_btn = findViewById(R.id.delete_data);
        setListener();
        viewData();
        updateData();

        deleteData();

//        Button button = findViewById(R.id.button8);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SharedPreferences prefs = getApplicationContext().getSharedPreferences(Config.SHARED_PREF, 0);
//                String token = prefs.getString("regId", null);
//
//                if(!TextUtils.isEmpty(token)){
//                Toast.makeText(MainActivity2.this,"FCM Token: "+token,Toast.LENGTH_LONG).show();
//                }else{
//                    Toast.makeText(MainActivity2.this,"FCM Token NULL",Toast.LENGTH_LONG).show();
//                }
//                Log.i("Token is ", "Token: "+ token);
//            }
//        });
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

    private void deleteData() {
        delete_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myDatabase.DeleteEntry(editID.getText().toString());
                    }
                }
        );
    }

    private void viewData() {
        view_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDatabase.viewData();
                        if(res.getCount()==0) return;
                        StringBuffer stringBuffer = new StringBuffer();
                        while(res.moveToNext()){
                            stringBuffer.append("Id : "+ res.getString(0)+"\n");
                            stringBuffer.append("First Name : "+ res.getString(1)+"\n");
                            stringBuffer.append("Last Name : "+ res.getString(2)+"\n");
                            stringBuffer.append("Email : "+ res.getString(3)+"\n");
                            stringBuffer.append("Mobile : "+ res.getString(4)+"\n\n");
                        }
                        showFetchedData("DATA", stringBuffer.toString());
                    }
                }
        );
    }
    public void showFetchedData(String title,String text){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(text);
        builder.show();

    }
    private void updateData(){
        update_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            myDatabase.UpdateData(editID.getText().toString(),
                                    editFname.getText().toString(),
                                    editLname.getText().toString(),
                                    editEmail.getText().toString(),
                                    editMob.getText().toString()
                            );
                    }
                }
        );

    }

    private void setListener() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDatabase.insertData(editFname.getText().toString(),
                        editLname.getText().toString(),
                        editEmail.getText().toString(),
                        editMob.getText().toString());
                if(isInserted==true) Toast.makeText(MainActivity2.this,"Data Added",Toast.LENGTH_LONG).show();
                else  Toast.makeText(MainActivity2.this,"Error",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void storeRegIdInPref(String token) {
        SharedPreferences pref = getSharedPreferences(Config.SHARED_PREF, 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("regId", token);
        editor.commit();
    }


}