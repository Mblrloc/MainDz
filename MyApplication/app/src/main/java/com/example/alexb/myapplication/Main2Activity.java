package com.example.alexb.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = new Intent(this, MainActivity.class);
        setTitle("Регистрация");
        final Button b=(Button)findViewById(R.id.button2);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);











    }


    protected  void Second(View b) {
        Intent intent = new Intent(this, MainActivity.class);
        final EditText Et3 = (EditText) findViewById(R.id.editText3);
        final EditText Et4 = (EditText) findViewById(R.id.editText4);
        String password23, login23;
        if ((Et3.getText().toString().isEmpty() && Et4.getText().toString().isEmpty())) {

        } else {
            password23 = Et4.getText().toString();
            login23 = Et3.getText().toString();
            intent.putExtra("Password", password23);
            intent.putExtra("Login", login23);

            startActivity(intent);

        }

    }
}
