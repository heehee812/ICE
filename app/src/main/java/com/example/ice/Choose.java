package com.example.ice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Choose extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        Log.d("button child", "yes");
        Button button_child = findViewById(R.id.button_child);
        Log.d("button child", "yes");

        button_child.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("button child", "true");
                Intent ChooseIntent = new Intent(Choose.this, ChildActivity.class);
                startActivity(ChooseIntent);
            }
        });
    }
}
