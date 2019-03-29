package com.example.alexb.myapplication;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Constraints;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Attr;
import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);
        final ImageView imageView=findViewById(R.id.Background);
        imageView.setImageResource(R.drawable.cobblestone);
        XmlPullParser parser = getResources().getXml(R.xml.a);
        Button mode=findViewById(R.id.ChangeMode);
        mode.setOnClickListener(this);
        try {
            parser.next();
            parser.nextTag();
        } catch (Exception e) {
            e.printStackTrace();
        }
        AttributeSet attr= Xml.asAttributeSet(parser);
        gameView=new GameView(this,attr);
        Log.e("Help","ActivityCreated...");




        //GetLvl
        //      Зависимл от уровня даем материалы





        StartItems.add("10");
        StartItems.add("20");
        StartItems.add("560");

        ListView listView;
        String[] stz=new String[StartItems.size()];

        stz=StartItems.toArray(stz);


        listView = findViewById(R.id.StartItems);

        listView.setAdapter(new ArrayAdapter<String>(this, R.layout.customlist,R.id.textList,stz) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView cost = (TextView) view.findViewById(R.id.textList);
                ImageView listImage=view.findViewById(R.id.imageList);
listImage.setImageResource(R.drawable.iron);
//listImage.setScaleX(2);
//listImage.setScaleY(2);
                return view;
            }
        });




listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public synchronized void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        gameView.selectNewItem((int)id);
    }
});




    }

    @Override
    public void onRestart() {
        super.onRestart();
        Intent intent = new Intent(GameActivity.this, GameActivity.class);
        startActivity(intent);
    }
    private ArrayList<String> StartItems=new ArrayList<String>();


    int lvl=1;



    GameView gameView;



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ChangeMode:
                Log.e("Help","Tapped");
                gameView.setMode2();
                break;
        }
    }


}
