package com.example.alexb.recurtion;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

public class MyDraw extends View {
    public MyDraw(Context context) {
        super(context);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(15);
        paint.setStyle(Paint.Style.STROKE);

    }

    @Override
    protected void onDraw(Canvas canvas){
// drawCircles(canvas,w/2,h/2,100);
        recurtion(0,0,w,0,w/2,h,canvas,5);

    }

    int w,h;
    Paint paint=new Paint();

    protected void drawTriangle(float x1, float y1,float x2, float y2,float x3,float y3, Canvas canvas){
        canvas.drawLine(x1,y1,x2,y2,paint);
        canvas.drawLine(x1,y1,x3,y3,paint);
        canvas.drawLine(x3,y3,x2,y2,paint);
    }

    protected void recurtion(float x1, float y1, float x2,float y2,float x3,float y3, Canvas canvas,int razi){
        drawTriangle(x1,y1,x2,y2,x3,y3,canvas);
        if(razi>=2){
            Log.e("HALP","GG");
          recurtion((x1),y1,(x2+x1)/2, y2,(x1+x2)/2,y3/2,canvas, razi-1);
            recurtion((x1+x2)/2,y1,x2, y2,(x1+x2)/2,y3/2,canvas, razi-1);
        }

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        this.w=w;
        this.h=h;

    }
}
