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

public class WishView extends View{

    public WishView(Context context){
        super(context);

        init(null);
    }

    public WishView(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        init(attrs);
    }

    public WishView(Context context, AttributeSet attrs, int defStyleAttrs){
        super(context, attrs, defStyleAttrs);

        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public WishView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes){
        super(context, attrs, defStyleAttr, defStyleRes);

        init(attrs);
    }

    private void init(@Nullable AttributeSet set){

    }

    @SuppressLint("DrawAllocation")
    protected void onDraw(Canvas canvas){


        Paint paint;
        paint= new Paint();
        int imgXwishpool= getWidth();
        int imgYwishpool= getHeight();

        //wish pool
        @SuppressLint("DrawAllocation") Bitmap wish_pool= BitmapFactory.decodeResource(getResources(), R.drawable.wish_pool);
        wish_pool = Bitmap.createScaledBitmap(wish_pool, imgXwishpool, imgYwishpool, true);
        canvas.drawBitmap(wish_pool,0, 0, paint);

    }

}
