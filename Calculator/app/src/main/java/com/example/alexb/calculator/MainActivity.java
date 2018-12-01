package com.example.alexb.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button umn = (Button) findViewById(R.id.umn);
        final Button del = (Button) findViewById(R.id.del);
        final Button plus = (Button) findViewById(R.id.plus);
        final Button minus = (Button) findViewById(R.id.minus);

    }



    public void umn(View umn){
final EditText Ed1=(EditText) findViewById(R.id.textView);
final TextView Otv=(TextView) findViewById(R.id.Otvet);

        final EditText Ed2=(EditText) findViewById(R.id.textView2);
        if(Ed1.getText().toString().isEmpty() && Ed2.getText().toString().isEmpty()) {
        } else {

            String a1, b1, c1;
            double a2, b2, c;
            a1 = Ed1.getText().toString();
            b1 = Ed2.getText().toString();
            a2 = Double.parseDouble(a1);
            b2 = Double.parseDouble(b1);
            c = a2 * b2;
            c1 = Double.toString(c);
            Otv.setText(c1);
        }
    }

    public void plus(View plus) {
        final EditText Ed1 = (EditText) findViewById(R.id.textView);
        final TextView Otv = (TextView) findViewById(R.id.Otvet);
        final EditText Ed2 = (EditText) findViewById(R.id.textView2);
        if (Ed1.getText().toString().isEmpty() && Ed2.getText().toString().isEmpty()) {
        } else {
            String a1, b1, c1;
            double a2, b2, c;
            a1 = Ed1.getText().toString();
            b1 = Ed2.getText().toString();
            a2 = Double.parseDouble(a1);
            b2 = Double.parseDouble(b1);
            c = a2 + b2;
            c1 = Double.toString(c);
            Otv.setText(c1);
        }
    }

    public void minus(View minus) {
        final EditText Ed1 = (EditText) findViewById(R.id.textView);
        final TextView Otv = (TextView) findViewById(R.id.Otvet);
        final EditText Ed2 = (EditText) findViewById(R.id.textView2);
        if (Ed1.getText().toString().isEmpty() && Ed2.getText().toString().isEmpty()) {
        } else {
            String a1, b1, c1;
            double a2, b2, c;
            a1 = Ed1.getText().toString();
            b1 = Ed2.getText().toString();
            a2 = Double.parseDouble(a1);
            b2 = Double.parseDouble(b1);
            c = a2 - b2;
            c1 = Double.toString(c);
            Otv.setText(c1);
        }
    }

    public void del(View del) {
        final EditText Ed1 = (EditText) findViewById(R.id.textView);
        final TextView Otv = (TextView) findViewById(R.id.Otvet);
        final EditText Ed2 = (EditText) findViewById(R.id.textView2);
        if (Ed1.getText().toString().isEmpty() && Ed2.getText().toString().isEmpty()) {
        } else {
            String a1, b1, c1;
            double a2, b2, c;
            a1 = Ed1.getText().toString();
            b1 = Ed2.getText().toString();
            a2 = Double.parseDouble(a1);
            b2 = Double.parseDouble(b1);
            if (b2 != 0) {
                c = a2 / b2;
                c1 = Double.toString(c);
            } else {
                c1 = "Err";
            }
            Otv.setText(c1);
        }
    }
}
