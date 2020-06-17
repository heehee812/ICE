package com.example.ice.Views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.ice.R;

public class MissionView extends View {
    public MissionView(Context context){
        super(context);

        init(null);
    }

    public MissionView(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        init(attrs);
    }

    public MissionView(Context context, AttributeSet attrs, int defStyleAttrs){
        super(context, attrs, defStyleAttrs);

        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MissionView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes){
        super(context, attrs, defStyleAttr, defStyleRes);

        init(attrs);
    }

    private void init(@Nullable AttributeSet set){

    }

    @SuppressLint("DrawAllocation")
    protected void onDraw(Canvas canvas){


        Paint paint;
        paint= new Paint();

        int x=getWidth()/3, y=getHeight()/6;

        //background2
        @SuppressLint("DrawAllocation") Bitmap background2= BitmapFactory.decodeResource(getResources(), R.drawable.background2);
        background2 = Bitmap.createScaledBitmap(background2, getWidth(), getHeight()-200, true);
        canvas.drawBitmap(background2,0, 0, paint);
    }

}
