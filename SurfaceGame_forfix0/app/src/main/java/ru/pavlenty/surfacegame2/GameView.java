package ru.pavlenty.surfacegame2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;

public class GameView extends SurfaceView implements Runnable {

    private static int lifes=2;

    private Friend friend;
    volatile boolean playing;
    private Thread gameThread = null;
    private Player player;

    private Paint paint;
    private Canvas canvas;
    private SurfaceHolder surfaceHolder;

    private ArrayList<Star> stars = new ArrayList<Star>();
    private ArrayList<Friend> friends = new ArrayList<Friend>();
    private ArrayList<Enemy> enemyes = new ArrayList<Enemy>();
    int screenX;
    int countMisses;

    boolean flag ;


   public boolean isGameOver;

    int score;


    int highScore[] = new int[4];

    SharedPreferences sharedPreferences;

    static MediaPlayer gameOnsound;
    final MediaPlayer killedEnemysound;
    final MediaPlayer gameOversound;

    Context context;

    public GameView(Context context, int screenX, int screenY) {
        super(context);
        player = new Player(context, screenX, screenY);
lifes=2;
        surfaceHolder = getHolder();
        paint = new Paint();

        int starNums = 100;
        for (int i = 0; i < starNums; i++) {
            Star s = new Star(screenX, screenY);
            stars.add(s);
        }

        int fNums = 2;
        for (int i = 0; i < fNums; i++) {
            Friend f = new Friend(this,screenX, screenY);
            friends.add(f);
        }
        int eNums = 2;
        for (int i = 0; i < eNums; i++) {
            Enemy e = new Enemy(this,screenX, screenY);
          enemyes.add(e);
        }


        this.screenX = screenX;
        countMisses = 0;
        isGameOver = false;


        score = 0;
        sharedPreferences = context.getSharedPreferences("SHAR_PREF_NAME", Context.MODE_PRIVATE);


        highScore[0] = sharedPreferences.getInt("score1", 0);
        highScore[1] = sharedPreferences.getInt("score2", 0);
        highScore[2] = sharedPreferences.getInt("score3", 0);
        highScore[3] = sharedPreferences.getInt("score4", 0);
        this.context = context;


        gameOnsound = MediaPlayer.create(context,R.raw.gameon);
        killedEnemysound = MediaPlayer.create(context,R.raw.killedenemy);
        gameOversound = MediaPlayer.create(context,R.raw.gameover);


        gameOnsound.start();

    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_UP:
                player.stopBoosting();
                for(Friend f:friends) {
                f.setBoosting();
            }
                for(Enemy e:enemyes) {
                    e.setBoosting();
                }
                break;
            case MotionEvent.ACTION_DOWN:
                for(Friend f:friends) {
                    f.stopBoosting();
                }
                for(Enemy e:enemyes) {
                    e.stopBoosting();
                }
                player.setBoosting();
                break;

        }

        if(isGameOver){
            if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                context.startActivity(new Intent(context,MainActivity.class));
            }
        }
        return true;
    }

public Canvas GetCanvas(){return(canvas);}

    @Override
    public void run() {
        while (playing) {
            update();
            draw();
            control();
        }
    }
public boolean Touched(Rect a, Rect b){
    return(a.contains(b) || b.contains(a));
}
    public void draw() {
        if (surfaceHolder.getSurface().isValid()) {
            canvas = surfaceHolder.lockCanvas();
            canvas.drawColor(Color.BLACK);


            paint.setColor(Color.WHITE);
            paint.setTextSize(20);

            for (Star s : stars) {
                paint.setStrokeWidth(s.getStarWidth());
                canvas.drawPoint(s.getX(), s.getY(), paint);

            }
            for (Enemy e : enemyes) {
                canvas.drawBitmap(e.getBitmap(),e.getX(),e.getY(),paint);

                if (Touched(player.getDetectCollision(), e.getDetectCollision())){
                    player.destroyed();
                 isGameOver=true;
                }
            }

            for (Friend f : friends) {
               canvas.drawBitmap(f.getBitmap(),f.getX(),f.getY(),paint);
                if (Touched(player.getDetectCollision(), f.getDetectCollision())){
                    f.destroyed();
                }
            }
            paint.setTextSize(30);
            canvas.drawText("Очки: "+score,100,50,paint);

            canvas.drawBitmap(
                    player.getBitmap(),
                    player.getX(),
                    player.getY(),
                    paint);


            if(isGameOver){
                paint.setTextSize(150);
                paint.setTextAlign(Paint.Align.CENTER);

                int yPos=(int) ((canvas.getHeight() / 2) - ((paint.descent() + paint.ascent()) / 2));
                canvas.drawText("Конец игры",canvas.getWidth()/2,yPos,paint);
            }

            surfaceHolder.unlockCanvasAndPost(canvas);

        }
    }


    public static void stopMusic(){
        gameOnsound.stop();
    }
public static void Ah(){
        lifes--;
}
    private void update() {
        score++;
if(lifes<=0)isGameOver=true;
        player.update();

        for (Friend f : friends) {
            f.update(f.getSpeed());
        }
        for (Enemy e : enemyes) {
            e.update(e.getSpeed());
        }




        for (Star s : stars) {
            s.update(player.getSpeed());
        }
    }

    private void control() {
        try {
            gameThread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void pause() {
        playing = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
        }
    }

    public void resume() {
        playing = true;
        gameThread = new Thread(this);
        gameThread.start();
    }



}