package com.example.ice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MissionActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);


        //button logout
        final Button button_logout =  findViewById(R.id.button_logout);
        button_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_logout.setBackgroundColor(Color.rgb(204, 233, 232));
                Log.d("button click", "yes");
                Toast.makeText(MissionActivity.this, "log out!", Toast.LENGTH_SHORT).show();
                Intent LogoutActivityIntent = new Intent(MissionActivity.this, MainActivity.class);
                startActivity(LogoutActivityIntent);
            }
        });

        //button my wish
        final Button button_wish= findViewById(R.id.button_my_wish);
        button_wish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_wish.setBackgroundColor(Color.rgb(204, 233, 232));
                Intent LogoutActivityIntent = new Intent(MissionActivity.this, WishActivity.class);
                startActivity(LogoutActivityIntent);
            }
        });

        //button home
        final Button button_home= findViewById(R.id.button_home);
        button_home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                button_home.setBackgroundColor(Color.rgb(204, 233, 232));
                Intent LogoutActivityIntent = new Intent(MissionActivity.this, MainChildActivity.class);
                startActivity(LogoutActivityIntent);
            }
        });

        //button new mission
        final Button button_new_mission= findViewById(R.id.button_new_mission);
        final TextView text_rule_walk= findViewById(R.id.text_rule_walk);
        final Boolean[] newClicked = {false};
        button_home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d("click new", "click");
                if(!newClicked[0]) {
                    button_new_mission.setBackgroundColor(Color.rgb(211, 195, 255));
                    text_rule_walk.setVisibility(View.VISIBLE);
                    newClicked[0] = !newClicked[0];
                }
                else{
                    text_rule_walk.setVisibility(View.INVISIBLE);
                    newClicked[0] = !newClicked[0];
                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_child, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

}
