package com.example.ice;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleCursorAdapter;

import com.example.ice.Views.ChildView;

public class ChildActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final float[] angle = {0};
        final float numberOfMission=10;
        final ChildView childview;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        childview= findViewById(R.id.childview_id);

        //button
        final Boolean[] buttonFinishClicked = {false};
        final Button buttonFinish= findViewById(R.id.button_finish);
        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                buttonFinishClicked[0] =!buttonFinishClicked[0];
                if(buttonFinishClicked[0])
                {
                    buttonFinish.setBackgroundColor(Color.rgb(151, 68, 68));
                    if(childview!=null) {
                        if(angle[0] <360)
                            angle[0] += (360 / numberOfMission);
                        else {
                            angle[0] =360 / numberOfMission;
                        }

                        childview.angleIncrease(angle[0]);
                        childview.invalidate();
                    }
                }
                else
                {
                    buttonFinish.setBackgroundColor(Color.rgb(181, 131, 141));
                }
                buttonFinishClicked[0]=!buttonFinishClicked[0];
            }

        });

        final Button button_back =  findViewById(R.id.button_logout);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_back.setBackgroundColor(Color.rgb(209, 160, 226));
                Log.d("button click", "yes");
                Intent LogoutActivityIntent = new Intent(ChildActivity.this, MainActivity.class);
                startActivity(LogoutActivityIntent);
            }
        });

    }

}