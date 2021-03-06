package com.example.ice;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ice.Views.ChildView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class WishActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish);
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
                Toast.makeText(WishActivity.this, "log out!", Toast.LENGTH_SHORT).show();
                Intent LogoutActivityIntent = new Intent(WishActivity.this, MainActivity.class);
                startActivity(LogoutActivityIntent);
            }
        });

        //button home
        final Button button_home= findViewById(R.id.button_home);
        button_home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                button_home.setBackgroundColor(Color.rgb(204, 233, 232));
                Intent LogoutActivityIntent = new Intent(WishActivity.this, MainChildActivity.class);
                startActivity(LogoutActivityIntent);
            }
        });


        //button my mission
        final Button button_mission= findViewById(R.id.button_mission);
        button_mission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_mission.setBackgroundColor(Color.rgb(204, 233, 232));
                Intent LogoutActivityIntent = new Intent(WishActivity.this, MissionActivity.class);
                startActivity(LogoutActivityIntent);
            }
        });

        //button coin
        final boolean[] coinClicked = {false};
        final Button button_wish_done= findViewById(R.id.button_wish_done);
        final Button button_wish_cancel= findViewById(R.id.button_wish_cancel);
        final EditText wish_papper= findViewById(R.id.edit_wish_papper);
        final Button button_coin = findViewById(R.id.button_coin);
        button_coin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.e("click coin", String.valueOf(coinClicked));
                if(!coinClicked[0]) {
                    wish_papper.setVisibility(View.VISIBLE);
                    button_wish_done.setVisibility(View.VISIBLE);
                    button_wish_cancel.setVisibility(View.VISIBLE);
                    coinClicked[0]= true;
                }
                else
                {
                    wish_papper.setVisibility(View.INVISIBLE);
                    button_wish_done.setVisibility(View.INVISIBLE);
                    button_wish_cancel.setVisibility(View.INVISIBLE);
                    coinClicked[0]= false;
                }
            }
        });

        //button wish papper done
        button_wish_done.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                wish_papper.setVisibility(View.INVISIBLE);
                button_wish_done.setVisibility(View.INVISIBLE);
                button_wish_cancel.setVisibility(View.INVISIBLE);
            }
        });

        //button wish papper cancel
        button_wish_cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                wish_papper.setVisibility(View.INVISIBLE);
                button_wish_done.setVisibility(View.INVISIBLE);
                button_wish_cancel.setVisibility(View.INVISIBLE);
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
