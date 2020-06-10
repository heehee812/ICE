package com.example.ice;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ice.Views.ChildView;


public class MainActivity extends AppCompatActivity {

    Boolean clicked= false;

    public static class CustomView extends View {
        Paint paint;
        public CustomView(Context context){
            super(context);
            paint= new Paint();
        }

        @SuppressLint("DrawAllocation")
        protected void onDraw(Canvas canvas){

//            monster
            int x=getWidth() / 2;
            @SuppressLint("DrawAllocation") Bitmap icecream_logo= BitmapFactory.decodeResource(getResources(), R.drawable.ice_cream_icon);
            icecream_logo = Bitmap.createScaledBitmap(icecream_logo, 500, 500, true);
            canvas.drawBitmap(icecream_logo, x , 0, paint);

        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button_sign_in = findViewById(R.id.button_sign_in);
        final Button button_sign_up = findViewById(R.id.button_sign_up);
        button_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_sign_up.setBackgroundColor(Color.rgb(209, 160, 226));
                Intent SignUpActivityIntent = new Intent(MainActivity.this,SignUp.class);
                startActivity(SignUpActivityIntent);
            }
        });

        button_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_sign_in.setBackgroundColor(Color.rgb(209, 160, 226));
                Toast.makeText(MainActivity.this,"success!", Toast.LENGTH_SHORT).show();
                Intent ChildActivityIntent = new Intent(MainActivity.this, ChildActivity.class);
                startActivity(ChildActivityIntent);
            }
        });

    }

}
