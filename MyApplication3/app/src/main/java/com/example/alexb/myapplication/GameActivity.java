package com.example.alexb.myapplication;


import android.annotation.SuppressLint;
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
        ImageView imageView=findViewById(R.id.Background);
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
        String moneys= "5600";
        TextView textView=findViewById(R.id.Moneys);
        textView.setText(String.valueOf(moneys+"$"));



        StartItems.add("10");
        StartItems.add("20");
        StartItems.add("560");

        ListView listView=findViewById(R.id.StartItems);
        String[] stz=new String[StartItems.size()];

        stz=StartItems.toArray(stz);

        ArrayAdapter adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, stz);

        listView.setAdapter(adapter);




listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public synchronized void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        gameView.selectNewItem((int)id);
    }
});




    }

    private ArrayList<String> StartItems=new ArrayList<String>();
    int lvl=1;







    GameView gameView;




    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ChangeMode:
                gameView.getGameThread().setMode();
                break;


        }
    }


}
