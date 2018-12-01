package com.example.alexb.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        final TextView Tx1=(TextView)findViewById(R.id.textView);
        Button b=(Button)findViewById(R.id.button);
        setTitle("Авторизация");
        Intent intent1 = new Intent(this, Main2Activity.class);

        if (getIntent().getStringExtra("Login")==null) {
        }else {
            String a=getIntent().getStringExtra("Login");
            Tx1.setText(a);
        }


    }





    protected void First(View button){
        final TextView Tx1=(TextView)findViewById(R.id.textView);
        Intent intent1 = new Intent(this, Main2Activity.class);
        final EditText Et1=(EditText)findViewById(R.id.editText);
        final  EditText Et2=(EditText)findViewById(R.id.editText2);

        String Password, Login, NowPassword="",NowLogin="";





        if (getIntent().getStringExtra("Password")==null && getIntent().getStringExtra("Login")==null){
            NowPassword="qwerty";

            NowLogin="login";
        } else {
            NowLogin=getIntent().getStringExtra("Login");

            NowPassword=getIntent().getStringExtra("Password");
        }




        if ((Et1.getText().toString().equals("") && Et2.getText().toString().equals(""))) {

        } else {

            Password = Et2.getText().toString();
            Login = Et1.getText().toString();

            if (Password.equals(NowPassword) && Login.equals(NowLogin)) {
                Tx1.setText("Ok");

            } else {

                startActivity(intent1);
            }

        }
    }
}
