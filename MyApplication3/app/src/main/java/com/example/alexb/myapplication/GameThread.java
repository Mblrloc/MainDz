package com.example.alexb.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class GameThread extends Thread {


    private ArrayList<Element> elements=new ArrayList<>();
    private  Context context;
    private int Mode=0;
    private final SurfaceHolder surfaceHolder;

    private volatile boolean running=true;

    private Paint backpaint=new Paint();

    {//Блок инициализации дописывается во все контструкторы
        backpaint.setColor(Color.CYAN);
        backpaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }
    private Paint paint=new Paint();
    {
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
    }


    public  GameThread(SurfaceHolder surfaceHolder1, Context context1){
        this.surfaceHolder=surfaceHolder1;
        context=context1;
    }

    private Bitmap bitmap;

    public void doStop(){ this.running = false; }
    public void doRun(){ this.running = true; }



    @Override
    public void run(){

        while (running){
            bitmap=BitmapFactory.decodeResource(context.getResources(),R.drawable.floor);
            Canvas canvas=surfaceHolder.lockCanvas();

            if(canvas!=null){
                try {
                    //draw something

                    for (int i=0;i<canvas.getHeight()/bitmap.getHeight()+1;i++) {
                        for (int i2=0;i2<canvas.getWidth()/bitmap.getWidth()+1;i2++) {
                            canvas.drawBitmap(bitmap, bitmap.getWidth()*i2, bitmap.getHeight() * i, paint);
                        }
                    }
//Log.e("Help","Drawing");

                    switch (Mode){
                        case(0):
                            //Проектировка
                            try {
for (Element e:elements){

        canvas.drawBitmap(e.GetBitmap(), e.getX()-e.Xdifferent(), e.getY()-e.Ydifferent(), paint);
    }
                            }
    catch (  java.util.ConcurrentModificationException e1){
        Log.e("Help","Помедленнее уважаемый");
                       }



                            break;
                        case(1):
                            //Работа механизмов

                            break;
                    }


                    try {
                        sleep(40);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                } finally {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }

        }

    }





public void addElement(Element e){
        elements.add(e);
        Log.e("Help","Element added");
}

    public void setMode(){
        if (this.Mode==0) {
            Mode = 1;
            Log.e("Help","SetMod_1");
        }
        else {
            this.Mode = 0;
            Log.e("Help", "SetMod_0");
        }
    }

}
