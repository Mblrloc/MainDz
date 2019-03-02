package com.example.alexb.database;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registration extends AppCompatActivity {
    DBHelper dbhelper;
    EditText pas;
    EditText log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        Button button=findViewById(R.id.button2);
        log=findViewById(R.id.RegName);
        pas=findViewById(R.id.RegPas);
        dbhelper=new DBHelper(this,"dblog",null,1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String logS=log.getText().toString();
                String pasS=pas.getText().toString();
                ContentValues cv = new ContentValues();
                SQLiteDatabase db = dbhelper.getWritableDatabase();
                cv.put("log",logS);
                cv.put("password",pasS);
                db.insert("logins",null,cv);
                dbhelper.close();
                Intent intent=new Intent(Registration.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

