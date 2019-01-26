package ru.pavlenty.surfacegame2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // play image button
    private ImageButton buttonPlay;
    //high score button
    private ImageButton buttonScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        buttonPlay = (ImageButton) findViewById(R.id.buttonPlay);
        buttonScore = (ImageButton) findViewById(R.id.buttonScore);


        buttonPlay.setOnClickListener(this);
        buttonScore.setOnClickListener(this);
        DisplayMetrics displaymetrics = getResources().getDisplayMetrics();

// узнаем размеры экрана из класса Display
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics metricsB = new DisplayMetrics();
        display.getMetrics(metricsB);
        int W;
        W = displaymetrics.widthPixels;
        int H=displaymetrics.heightPixels;

    }


    @Override
    public void onClick(View v) {

        if (v == buttonPlay) {

            startActivity(new Intent(MainActivity.this, GameActivity.class));
        }

        if (v == buttonScore) {


            startActivity(new Intent(MainActivity.this, HightScore.class));
        }



    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Вы хотите выйти?")
                .setCancelable(false)
                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        GameView.stopMusic();
                        Intent startMain = new Intent(Intent.ACTION_MAIN);
                        startMain.addCategory(Intent.CATEGORY_HOME);
                        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(startMain);
                        finish();
                    }
                })
                .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }

 }
