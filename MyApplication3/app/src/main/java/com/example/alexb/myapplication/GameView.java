package com.example.alexb.myapplication;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    public GameView(Context context1, AttributeSet attrs) {
        super(context1, attrs);
        getHolder().addCallback(this);
        gameThread=new GameThread(getHolder(),context1);



    }

    private int PlaceOrRotate=0;
    public GameThread getGameThread() {
        return gameThread;
    }
    private int selected;
    private GameThread gameThread;


    public synchronized void selectNewItem(int a) {
        this.selected=a;
         Log.e("Help","New item "+ selected+ " selected");
    }



    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        try {
            gameThread.start();
        } catch ( java.lang.IllegalThreadStateException e){

        }
    }
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        gameThread.doStop();
        boolean retry=true;
        while (retry) {
            try {
                gameThread.join();
                retry=false;
            } catch (InterruptedException e) {
//Цикл нужен для исключения ошибок
            }
        }
    }


    float FX;
    float FY;
    float F2X;
    float F2Y;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        synchronized (getHolder()) {
            if (event.getAction()==MotionEvent.ACTION_DOWN) {
                Log.e("Help", "Touched");
                Log.e("Help",selected+"");
                //ADDING
                if (selected != -1) {//Первое касание находит изначальные координаты
                    if (PlaceOrRotate==0) {
                        FX=event.getX();
                        FY=event.getY();
                        PlaceOrRotate=1;
                    } else{//второе угол
                        F2X=event.getX();
                        F2Y=event.getY();
                        PlaceOrRotate=0;

                        gameThread.addElement(new Element(getContext(), (int)FX, (int) FY, getRotation(FX,F2X,FY,F2Y), selected));
                        Log.e("Help", "add new Element:" + event.getX() + " " + event.getY() + " " + getRotation(FX,F2X,FY,F2Y) + " " + selected);
                    }



                }
            }

            return true;
        }
    }








    @Override
    public boolean performClick() {
        super.performClick();

// Handle the action for the custom click here

        return true;
    }





    public float getRotation(float x1,float x2,float y1, float y2){
        float rotate= (float)(Math.atan((F2Y-FY)/(F2X-FX))*57.3)+90;
if (x2<=x1 && y2<=y1) rotate+=180;
if (x2<x1 && y2>y1) rotate+=180;


        return rotate;
    }
}









