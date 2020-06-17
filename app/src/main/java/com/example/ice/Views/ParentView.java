package com.example.ice.Views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.ice.R;

public class ParentView extends View{

    private float angle=0;
    private int GiveGift= 0;
    private Paint paint= new Paint();

    public ParentView(Context context){
        super(context);

        init(null);
    }

    public ParentView(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        init(attrs);
    }

    public ParentView(Context context, AttributeSet attrs, int defStyleAttrs){
        super(context, attrs, defStyleAttrs);

        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ParentView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes){
        super(context, attrs, defStyleAttr, defStyleRes);

        init(attrs);
    }

    private void init(@Nullable AttributeSet set){

    }

    //angle
    public void angleIncrease(float angle)
    {
        Log.d("angleIncrease", "found");
        this.angle=angle;
    }

    //gift
    public void giveGiftOrNot(int GiveGift)
    {
        this.GiveGift=GiveGift;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas){

        int x=getWidth()/2, y=3*getHeight()/5;
        int imgXmonster=800, imgYmonster=1000;
        int imgXgift= 1500, imgYgift= 1800;
        int radius= 200;

        //background
        @SuppressLint("DrawAllocation") Bitmap child_background= BitmapFactory.decodeResource(getResources(), R.drawable.child_background);
        child_background = Bitmap.createScaledBitmap(child_background, getWidth(), getHeight(), true);
        canvas.drawBitmap(child_background, 0 , 0, paint);

        //monster
        @SuppressLint("DrawAllocation") Bitmap monster2= BitmapFactory.decodeResource(getResources(), R.drawable.monster2);
        monster2 = Bitmap.createScaledBitmap(monster2, imgXmonster, imgYmonster, true);
        if(GiveGift==0)
            canvas.drawBitmap(monster2, x-imgXmonster/2 , y-imgYmonster/2, paint);

        //arc
        Log.d("angle", String.valueOf(angle));
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.rgb(225, 225, 195));
        RectF oval = new RectF( x-radius, y, x+radius, y+2*radius);
        if(GiveGift==0)
            canvas.drawArc(oval,270, angle, true, paint);

        //arc2
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(6);
        paint.setColor(Color.rgb(105, 118, 155));
        if(GiveGift==0)
            canvas.drawArc(oval,270, angle, true, paint);


        //circle2
        paint.setColor(Color.rgb(105, 118, 155));
        paint.setStrokeWidth(6);
        paint.setStyle(Paint.Style.STROKE);
        if(GiveGift==0)
            canvas.drawCircle(x, y+radius, radius, paint);

    }
}
