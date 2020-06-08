package com.example.ice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

        Button button_back =  findViewById(R.id.button_back);
        Button button_next = findViewById(R.id.button_next);

        /*button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("button click", "yes");
                Intent SignUpActivityIntent = new Intent(SignUp.this, MainActivity.class);
                startActivity(SignUpActivityIntent);
            }
        });*/
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Sign next", "true");
                Intent CharacterChooseActivityIntent = new Intent(SignUp.this, Choose.class);
                startActivity(CharacterChooseActivityIntent);
            }
        });
    }
}
