package com.example.ice;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ice.Views.ParentView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import org.w3c.dom.Text;

public class MainParentActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_parent);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final float[] angle = {0};
        final float numberOfMission=30;
        final ParentView parentview;
        parentview= findViewById(R.id.parentview_idd);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);

        //button circle on monster
        final Boolean[] buttonFinishClicked = {false};
        final Boolean[] circleClicked = {false};
        final Button button_circle= findViewById(R.id.button_circle);
        final TextView text_rule= findViewById(R.id.text_rule_eat);
        final Button buttonFinish= findViewById(R.id.button_finish);
        final Button buttonFail= findViewById(R.id.button_fail);
        button_circle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!circleClicked[0]) {
                    Log.d("click circle", "click");
                    text_rule.setVisibility(View.VISIBLE);
                    buttonFinish.setVisibility(View.VISIBLE);
                    buttonFail.setVisibility(View.VISIBLE);
                    circleClicked[0] = !circleClicked[0];

                    //button finish
                    buttonFinish.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v){
                            Log.d("button", "click");
                            if(!buttonFinishClicked[0]) {
                                Log.d("button in in", "click");
                                Toast.makeText(MainParentActivity.this, "mission success !", Toast.LENGTH_SHORT).show();
                                if(parentview!=null) {
                                    if(angle[0] <360) {
                                        angle[0] += (360 / numberOfMission);
                                        if(angle[0]==360) {
                                            text_rule.setBackgroundColor(Color.rgb(211, 208, 216));
                                        }
                                    }
                                    else {
                                        angle[0] =360 / numberOfMission;
                                    }
                                    parentview.angleIncrease(angle[0]);
                                    Log.d("button in", "click");
                                    parentview.invalidate();
                                }
                                else{
                                    Log.d("button null", "click");
                                }
                                text_rule.setBackgroundColor(Color.rgb(211, 208, 216));
                                text_rule.setVisibility(View.INVISIBLE);
                                buttonFinish.setVisibility(View.INVISIBLE);
                                buttonFail.setVisibility(View.INVISIBLE);

                                buttonFinishClicked[0] =true;
                            }
                            else
                            {
                                buttonFinishClicked[0] = false;
                            }
                        }

                    });
                    circleClicked[0]= !circleClicked[0];

                }
                else{
                    text_rule.setVisibility(View.INVISIBLE);
                    buttonFinish.setVisibility(View.INVISIBLE);
                    buttonFail.setVisibility(View.INVISIBLE);
                    circleClicked[0]= !circleClicked[0];
                }
            }
        });

        //button logout
        final Button button_logout =  findViewById(R.id.button_logout);
        button_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_logout.setBackgroundColor(Color.rgb(204, 233, 232));
                Log.d("button click", "yes");
                Toast.makeText(MainParentActivity.this, "log out!", Toast.LENGTH_SHORT).show();
                Intent LogoutActivityIntent = new Intent(MainParentActivity.this, MainActivity.class);
                startActivity(LogoutActivityIntent);
            }
        });

        //button my wish
        final Button button_wish= findViewById(R.id.button_my_wish);
        button_wish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_wish.setBackgroundColor(Color.rgb(204, 233, 232));
                Intent LogoutActivityIntent = new Intent(MainParentActivity.this, WishActivity.class);
                startActivity(LogoutActivityIntent);
            }
        });

        //button my mission
        final Button button_mission= findViewById(R.id.button_mission);
        button_mission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_mission.setBackgroundColor(Color.rgb(204, 233, 232));
                Intent LogoutActivityIntent = new Intent(MainParentActivity.this, MissionActivity.class);
                startActivity(LogoutActivityIntent);
            }
        });

        //button new mission
        final Boolean[] newClicked= {false};
        final Button button_ok= findViewById(R.id.button_ok);
        final Button button_cancel= findViewById(R.id.button_cancel);
        final EditText edit_set_mission= findViewById(R.id.edit_set_mission);
        final Button button_add_mission= findViewById(R.id.button_add_mission);
        button_add_mission.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!newClicked[0]) {
                    edit_set_mission.setVisibility(View.VISIBLE);
                    button_cancel.setVisibility(View.VISIBLE);
                    button_ok.setVisibility(View.VISIBLE);

                    button_ok.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v){
                            Toast.makeText(MainParentActivity.this, "set finish !", Toast.LENGTH_SHORT).show();
                        }

                    });
                    newClicked[0] = !newClicked[0];
                }
                else{
                    edit_set_mission.setVisibility(View.INVISIBLE);
                    button_cancel.setVisibility(View.INVISIBLE);
                    button_ok.setVisibility(View.INVISIBLE);
                    newClicked[0] = !newClicked[0];
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_parent, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
