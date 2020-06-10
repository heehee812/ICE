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

public class ChooseView extends View {

    private Paint paint= new Paint();

    public ChooseView(Context context){
        super(context);

        init(null);
    }

    public ChooseView(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        init(attrs);
    }

    public ChooseView(Context context, AttributeSet attrs, int defStyleAttrs){
        super(context, attrs, defStyleAttrs);

        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ChooseView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes){
        super(context, attrs, defStyleAttr, defStyleRes);

        init(attrs);
    }

    private void init(@Nullable AttributeSet set){

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas){

        int x=getWidth()/2, y=getHeight()/3;
        int radius= 200;

        //background
        @SuppressLint("DrawAllocation") Bitmap child_background= BitmapFactory.decodeResource(getResources(), R.drawable.bg);
        child_background = Bitmap.createScaledBitmap(child_background, getWidth(), getHeight(), true);
        canvas.drawBitmap(child_background, 0 , 0, paint);

        //circle
        paint.setColor(Color.rgb(255, 244, 237));
        paint.setStrokeWidth(6);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(x, y, radius, paint);

        //circle2
        paint.setColor(Color.rgb(211, 189, 255));
        paint.setStrokeWidth(15);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(x, y, radius, paint);

        //circle
        paint.setColor(Color.rgb(255, 244, 237));
        paint.setStrokeWidth(6);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(x, 2*y, radius, paint);

        //circle2
        paint.setColor(Color.rgb(211, 189, 255));
        paint.setStrokeWidth(15);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(x, 2*y, radius, paint);
    }

}
