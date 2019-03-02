package com.example.alexb.database;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText pas;
    EditText log;
    DBHelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=findViewById(R.id.button);
        log=findViewById(R.id.LogName);
        pas=findViewById(R.id.LogPas);
        dbhelper = new DBHelper(this,"dblog",null,1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbhelper.getWritableDatabase();

                String logS = log.getText().toString();
                String pasS = log.getText().toString();

                boolean logg=false;
                Cursor c = db.query("logins",new String[]{"log","password"},null, null,null,null,null);
 if(c.moveToFirst()) {

     do {

         Log.d("Help", c.getString(c.getColumnIndex("log")));
         Log.d("Help", c.getString(c.getColumnIndex("password")));
         if (c.getString(c.getColumnIndex("log")).equals(logS) && c.getString(c.getColumnIndex("password")).equals(pasS)) {
             logg = true;
             break;
         }

     } while (c.moveToNext());
 }
c.close();
db.close();

                Intent intent=new Intent( MainActivity.this,Registration.class);
                Toast.makeText(getApplicationContext(),logg ? "LOG AND PASSWORD IS CORRECT!" : "NOT FIND YOUR ACC, CREATING NEW...",Toast.LENGTH_LONG).show();
                startActivity(intent);

            }
        });
    }
}
