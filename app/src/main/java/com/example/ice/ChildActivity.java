package com.example.ice;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class ChildActivity extends AppCompatActivity {

    public static class CustomView extends View {
        Paint paint;
        private Object StateUtils;

        public CustomView(Context context){
            super(context);
            paint= new Paint();
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @SuppressLint("DrawAllocation")

        //layout of childActivity
        protected void onDraw(Canvas canvas){
            int x=getWidth()/2, y=2*getHeight()/3;
            int imgx=800, imgy=1000;
            int radius= 200;
            //monster
            @SuppressLint("DrawAllocation") Bitmap monster2= BitmapFactory.decodeResource(getResources(), R.drawable.monster2);
            @SuppressLint("DrawAllocation") Bitmap monster= BitmapFactory.decodeResource(getResources(), R.drawable.monster);
            monster2 = Bitmap.createScaledBitmap(monster2, imgx, imgy, true);
            monster = Bitmap.createScaledBitmap(monster, imgx, imgy, true);
            canvas.drawBitmap(monster2, x-imgx/2 , y-2*imgy/3, paint);
            canvas.drawBitmap(monster, x-imgx/2 , y-2*imgy/3, paint);

            //circle
            paint.setColor(Color.rgb(198, 180, 217));
            canvas.drawCircle(x, y, radius, paint);

            //arc
            paint.setColor(Color.rgb(221, 221, 135));
            canvas.drawArc(x-200, y-200, x+200, y+200, 0, 140, true, paint);

            //circle2
            paint.setColor(Color.rgb(85, 92, 106));
            paint.setStrokeWidth(6);
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(x, y, radius, paint);

            //button
            int buttonWidth= 300, buttonHeight= 200;
            paint.setColor(Color.rgb(151, 68, 68));
            paint.setStyle(Paint.Style.FILL);
            Rect button_finish = new Rect(x-buttonWidth/2, y/3-buttonHeight/2, x+buttonWidth/2, y/3+buttonHeight/2);
            canvas.drawRect(button_finish, paint);

            //string on button
            paint.setColor(Color.WHITE);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTextSize(60);
            canvas.drawText("finish", x, y/3, paint);

        }

        //event of childActivity
//        public boolean onTouch(View view, MotionEvent event)
//        {
//
//        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        setContentView(new CustomView(this));
    }
}