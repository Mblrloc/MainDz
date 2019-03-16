package com.example.alexb.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.Size;

import com.example.alexb.myapplication.R;


public class Element {
    Element(Context context1,int x1,int y1, float rotation1,int type1){
        this.type=type1;
        this.rotation=rotation1;
        this.x=x1;
        this.y=y1;
        bitmap= BitmapFactory.decodeResource(context1.getResources(), R.drawable.iron);
        bitmap = Bitmap.createScaledBitmap(bitmap, 200, 200, false);
        bitmap=RotateBitmap(bitmap, rotation);

    }
    private float rotation;
    private int type=0;//Тип элемента, через эту переменную настраивается bitmap
    private Bitmap bitmap;
    private int x;
    private int y;


    public Bitmap GetBitmap(){
        return bitmap;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }



    public static Bitmap RotateBitmap(Bitmap source, float angle)
    {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);
    }




 public float  Xdifferent(){
   return (this.bitmap.getWidth())/2;
 }

    public float  Ydifferent(){
        return (this.bitmap.getHeight())/2;
    }


}
