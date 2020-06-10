package com.example.ice.Views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.ice.ChildActivity;
import com.example.ice.R;

public class ChildView extends View {
    public ChildView(Context context){
        super(context);

        init(null);
    }

    public ChildView(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        init(attrs);
    }

    public ChildView(Context context, AttributeSet attrs, int defStyleAttrs){
        super(context, attrs, defStyleAttrs);

        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ChildView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes){
        super(context, attrs, defStyleAttr, defStyleRes);

        init(attrs);
    }

    private void init(@Nullable AttributeSet set){

    }

    @SuppressLint("DrawAllocation")
    protected void onDraw(Canvas canvas){


        Paint paint;
        paint= new Paint();

        int x=getWidth()/2, y=2*getHeight()/3;
        int imgXmonster=800, imgYmonster=1000;
        int radius= 200;

        //background
        @SuppressLint("DrawAllocation") Bitmap child_background= BitmapFactory.decodeResource(getResources(), R.drawable.child_background);
        child_background = Bitmap.createScaledBitmap(child_background, getWidth(), getHeight(), true);
        canvas.drawBitmap(child_background, 0 , 0, paint);

        //monster
        @SuppressLint("DrawAllocation") Bitmap monster2= BitmapFactory.decodeResource(getResources(), R.drawable.monster2);
        @SuppressLint("DrawAllocation") Bitmap monster= BitmapFactory.decodeResource(getResources(), R.drawable.monster);
        monster2 = Bitmap.createScaledBitmap(monster2, imgXmonster, imgYmonster, true);
        monster = Bitmap.createScaledBitmap(monster, imgXmonster, imgYmonster, true);
        canvas.drawBitmap(monster2, x-imgXmonster/2 , y-2*imgYmonster/3, paint);
        canvas.drawBitmap(monster, x-imgXmonster/2 , y-2*imgYmonster/3, paint);

        //circle
        paint.setColor(Color.rgb(198, 180, 217));
        canvas.drawCircle(x, y, radius, paint);

        //circle2
        paint.setColor(Color.rgb(85, 92, 106));
        paint.setStrokeWidth(6);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(x, y, radius, paint);
    }

}
