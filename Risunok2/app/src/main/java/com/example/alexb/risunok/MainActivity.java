package com.example.alexb.risunok;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.alexb.risunok.R;

public class MainActivity extends AppCompatActivity {
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView) findViewById(R.id.imageView);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        //720 1344  Toast.makeText(this,String.valueOf(width)+" "+String.valueOf(height),Toast.LENGTH_LONG).show();
        Bitmap bitmap = Bitmap.createBitmap(width,height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint p = new Paint();
        img.setImageBitmap(bitmap);
        p.setStyle(Paint.Style.FILL);

        p.setColor(Color.BLUE);
        canvas.drawPaint(p);
        p.setColor(Color.YELLOW);
        canvas.drawCircle(50,0,100,p);
        for (int i=0;i<=90;i+=15) {
            canvas.drawRect(0, 0, 10,200, p);
            canvas.rotate(-15);
        }
        canvas.rotate(105);
        p.setColor(Color.GREEN);
        canvas.drawRect(0, height-400, width,height, p);
        p.setColor(Color.parseColor("#4B2223"));
        canvas.drawRect(100,height-600,300,height-200,p);
        canvas.drawRect(500,height-450,600,height-200,p);

        p.setStrokeWidth(4);
        p.setAntiAlias(true);
        p.setStyle(Paint.Style.FILL_AND_STROKE);

        p.setColor(Color.parseColor("#4B2223"));
        int x1=0,x3=400,y1=height - 600,y2=height - 900;
        for(int i=0;i<=90;i++){
            Point a = new Point(x1, y1);
            Point b = new Point(200, y2);
            Point c = new Point(x3, y1);
            x1+=4;
            y2+=3;
            x3-=4;

            Path path = new Path();
            path.setFillType(Path.FillType.EVEN_ODD);
            path.moveTo(a.x, a.y);
            path.lineTo(b.x, b.y);
            path.moveTo(b.x, b.y);
            path.lineTo(c.x, c.y);
            path.moveTo(c.x, c.y);
            path.lineTo(a.x, a.y);
            path.close();

            canvas.drawPath(path, p);

        }
        p.setColor(Color.parseColor("#1C804B"));
        canvas.drawOval(400, height - 300, 700, height - 750, p);
        p.setColor(Color.BLACK);
        Path path2 = new Path();
        path2.setFillType(Path.FillType.EVEN_ODD);
        p.setStrokeWidth(20);
        path2.moveTo(125,height-625);
        path2.lineTo(125,height-325);
        path2.moveTo(125,height-325);
        path2.lineTo(275,height-325);
        path2.moveTo(275,height-325);
        path2.lineTo(275,height-625);
        path2.moveTo(275,height-625);
        path2.lineTo(125,height-625);
        path2.close();

        canvas.drawPath(path2, p);

        Path path3 = new Path();
        path3.setFillType(Path.FillType.EVEN_ODD);
        p.setStrokeWidth(20);
        x1=125;
        y1=height-625;
        for(int i=0;i<=5;i++){
            path3.moveTo(125,y1+50);
            path3.lineTo(275,y1);
            if (y1+50<=height-325) y1 += 50;


        }
        path3.close();

        canvas.drawPath(path3, p);
    }

}