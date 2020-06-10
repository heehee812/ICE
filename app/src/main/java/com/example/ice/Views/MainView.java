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

import com.example.ice.R;

public class MainView extends View {
    public MainView(Context context){
        super(context);

        init(null);
    }

    public MainView(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        init(attrs);
    }

    public MainView(Context context, AttributeSet attrs, int defStyleAttrs){
        super(context, attrs, defStyleAttrs);

        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MainView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes){
        super(context, attrs, defStyleAttr, defStyleRes);

        init(attrs);
    }

    private void init(@Nullable AttributeSet set){

    }

    @SuppressLint("DrawAllocation")
    protected void onDraw(Canvas canvas){


        Paint paint;
        paint= new Paint();

        int x=2*getWidth()/4, y=0;
        int imgXicecream=300, imgYicecream=350;
        int imgXtitle=700, imgYtitle=300;

        canvas.drawColor(Color.rgb(198, 180, 217));
        //icon
        @SuppressLint("DrawAllocation") Bitmap ice_cream_icon= BitmapFactory.decodeResource(getResources(), R.drawable.ice_cream_icon);
        ice_cream_icon = Bitmap.createScaledBitmap(ice_cream_icon, imgXicecream, imgYicecream, true);
        canvas.drawBitmap(ice_cream_icon,x+130, y, paint);

        //title
        @SuppressLint("DrawAllocation") Bitmap title= BitmapFactory.decodeResource(getResources(), R.drawable.title);
        title = Bitmap.createScaledBitmap(title, imgXtitle, imgYtitle, true);
        canvas.drawBitmap(title,x-300 , y+250, paint);
    }

}
