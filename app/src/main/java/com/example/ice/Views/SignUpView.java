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

public class SignUpView extends View {
    public SignUpView(Context context){
        super(context);

        init(null);
    }

    public SignUpView(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        init(attrs);
    }

    public SignUpView(Context context, AttributeSet attrs, int defStyleAttrs){
        super(context, attrs, defStyleAttrs);

        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SignUpView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes){
        super(context, attrs, defStyleAttr, defStyleRes);

        init(attrs);
    }

    private void init(@Nullable AttributeSet set){

    }

    @SuppressLint("DrawAllocation")
    protected void onDraw(Canvas canvas){


        Paint paint;
        paint= new Paint();

        int x=getWidth()/4, y=getHeight()/5;
        int imgXicecream=700, imgYicecream=700;

        //background
        @SuppressLint("DrawAllocation") Bitmap bg= BitmapFactory.decodeResource(getResources(), R.drawable.bg);
        bg = Bitmap.createScaledBitmap(bg, getWidth(), getHeight()-200, true);
        canvas.drawBitmap(bg,0, 0, paint);

        //icon
        @SuppressLint("DrawAllocation") Bitmap user= BitmapFactory.decodeResource(getResources(), R.drawable.user);
        user = Bitmap.createScaledBitmap(user, imgXicecream, imgYicecream, true);
        canvas.drawBitmap(user,x, y, paint);

    }
}
