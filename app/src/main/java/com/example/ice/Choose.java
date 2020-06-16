package com.example.ice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Choose extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        Log.d("button child", "yes");
        final Button button_child = findViewById(R.id.button_child);
        Log.d("button child", "yes");

        button_child.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_child.setBackgroundColor(Color.rgb(211, 208, 216));
                Log.d("button child", "true");
                Toast.makeText(Choose.this,"finish", Toast.LENGTH_SHORT).show();
                Intent ChooseIntent = new Intent(Choose.this, MainChildActivity.class);
                startActivity(ChooseIntent);
            }
        });
    }
}
