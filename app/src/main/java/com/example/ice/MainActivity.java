package com.example.ice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_sign_in = (Button) findViewById(R.id.button_sign_in);
        Button button_sign_up = (Button) findViewById(R.id.button_sign_up);
        button_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this,"success!", Toast.LENGTH_SHORT).show();
                Intent SignUpActivityIntent = new Intent(MainActivity.this,SignUp.class);
                startActivity(SignUpActivityIntent);
            }
        });

    }

}
