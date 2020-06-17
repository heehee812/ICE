package com.example.ice;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.Toast;

import com.example.ice.Views.ChildView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainChildActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_child);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final float[] angle = {0};
        final float numberOfMission=30;
        final ChildView childview;
        childview= findViewById(R.id.childview_idd);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);

        //button mission
        final Boolean[] buttonFinishClicked = {false};
        final Button buttonCheck= findViewById(R.id.button_gift_check);
        final Button buttonWait= findViewById(R.id.button_gift_wait);
        final Button buttonFinish= findViewById(R.id.button_fin);
        final int[] GiveGift = {0};
        if(childview==null)
            Log.d("button null null", "click");
        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Log.d("button", "click");
                buttonFinishClicked[0] =!buttonFinishClicked[0];
                if(buttonFinishClicked[0])
                {
                    Log.d("button in in", "click");
                    buttonFinish.setBackgroundColor(Color.rgb(151, 68, 68));
                    if(childview!=null) {
                        if(angle[0] <360) {
                            angle[0] += (360 / numberOfMission);
                            GiveGift[0] = 0;
                            if(angle[0]==360) {
                                GiveGift[0] = 1;
                                buttonFinish.setVisibility(View.INVISIBLE);
                                buttonCheck.setVisibility(View.VISIBLE);
                                buttonWait.setVisibility(View.VISIBLE);
                            }
                            else
                                GiveGift[0] =0;
                        }
                        else {
                            GiveGift[0] =0;
                            angle[0] =360 / numberOfMission;
                        }
                        childview.giveGiftOrNot(GiveGift[0]);
                        childview.angleIncrease(angle[0]);
                        Log.d("button in", "click");
                        childview.invalidate();
                    }
                    else{
                        Log.d("button null", "click");
                    }

                }
                else
                {
                    buttonFinish.setBackgroundColor(Color.rgb(181, 131, 141));
                }
                buttonFinishClicked[0]=!buttonFinishClicked[0];
            }

        });

        //button logout
        final Button button_logout =  findViewById(R.id.button_logout);
        button_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_logout.setBackgroundColor(Color.rgb(204, 233, 232));
                Log.d("button click", "yes");
                Toast.makeText(MainChildActivity.this, "log out!", Toast.LENGTH_SHORT).show();
                Intent LogoutActivityIntent = new Intent(MainChildActivity.this, MainActivity.class);
                startActivity(LogoutActivityIntent);
            }
        });

        //button my wish
        final Button button_wish= findViewById(R.id.button_my_wish);
        button_wish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_wish.setBackgroundColor(Color.rgb(204, 233, 232));
                Intent LogoutActivityIntent = new Intent(MainChildActivity.this, WishActivity.class);
                startActivity(LogoutActivityIntent);
            }
        });

        //button gift check
        buttonCheck.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(MainChildActivity.this, "collected !", Toast.LENGTH_SHORT).show();
                buttonCheck.setVisibility(View.INVISIBLE);
                buttonWait.setVisibility(View.INVISIBLE);
                buttonFinish.setVisibility(View.VISIBLE);
            }
        });

        //button gift wait
        buttonWait.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(MainChildActivity.this, "remind you later !", Toast.LENGTH_SHORT).show();
                buttonCheck.setVisibility(View.INVISIBLE);
                buttonWait.setVisibility(View.INVISIBLE);
                buttonFinish.setVisibility(View.VISIBLE);
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
