package com.example.alexb.kvadratnii_uravnenia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button b = (Button) findViewById(R.id.button);









        }


        public void Button(View Button) {

            final EditText Ed1 = (EditText) findViewById(R.id.etxt11);
            final EditText Ed2 = (EditText) findViewById(R.id.etxt21);
            final EditText Ed3 = (EditText) findViewById(R.id.etxt31);
            String otvet, a1, b1, c1;
            if (Ed1.getText().toString().isEmpty() && Ed2.getText().toString().isEmpty() && Ed3.getText().toString().isEmpty()) {

            } else {
                a1 = Ed1.getText().toString();
                b1 = Ed2.getText().toString();
                c1 = Ed3.getText().toString();

                double a = 0, b = 0, c = 0;
                a = Double.parseDouble(a1);
                b = Double.parseDouble(b1);
                c = Double.parseDouble(c1);
                if (b * b >= 4 * a * c) {
                    otvet = ("Ваши ответы" + ((-b + Math.sqrt(b * b - 4 * a * c)) / 2 * a) + " " + ((-b - Math.sqrt(b * b - 4 * a * c)) / 2 * a));
                } else {
                    otvet = "Корней нет";
                }
                Toast.makeText(getApplicationContext(), otvet, Toast.LENGTH_LONG).show();
            }
        }

    }
