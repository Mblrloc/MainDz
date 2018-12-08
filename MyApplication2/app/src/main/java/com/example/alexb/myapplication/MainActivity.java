package com.example.alexb.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
public int Boy=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b=(Button)findViewById(R.id.button);
        Button b2=(Button)findViewById(R.id.button2);
        b.setOnClickListener(this);
        b2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
    Boy++;

                Toast.makeText(getApplicationContext(), String.valueOf(Boy), Toast.LENGTH_LONG).show();
                break;
            case  R.id.button2:
                Toast.makeText(getApplicationContext(),"2", Toast.LENGTH_LONG).show();
                break;
default:
        }









//        TextView Tx1=(TextView) findViewById(R.id.textView2);
  //      EditText Ed1=(EditText)findViewById(R.id.Ed);
       // Toast.makeText(getApplicationContext(),"",Toast.LENGTH_LONG).show();

    }
}
