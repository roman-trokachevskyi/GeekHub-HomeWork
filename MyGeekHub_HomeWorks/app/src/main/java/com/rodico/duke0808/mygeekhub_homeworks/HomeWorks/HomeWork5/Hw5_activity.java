package com.rodico.duke0808.mygeekhub_homeworks.HomeWorks.HomeWork5;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.nineoldandroids.animation.Animator;
import com.rodico.duke0808.mygeekhub_homeworks.HomeWorks.HW2Activity;
import com.rodico.duke0808.mygeekhub_homeworks.HomeWorks.HomeWork1_Main;
import com.rodico.duke0808.mygeekhub_homeworks.HomeWorks.HomeWork3;
import com.rodico.duke0808.mygeekhub_homeworks.HomeWorks.HomeWork4.Hw4_activity;
import com.rodico.duke0808.mygeekhub_homeworks.R;

public class Hw5_activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{
    TextView fadeTv;
    TextView bounceTv;
    TextView rotateTv;
    TextView scaleTv;

    Animation fade;
    Animation bounce;
    Animation rotate;
    Animation scale;

    Button startAnim;
    Button stopAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw5_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fadeTv = (TextView) findViewById(R.id.fade_in_tv);
        bounceTv = (TextView) findViewById(R.id.bounce_tv);
        rotateTv = (TextView) findViewById(R.id.rotate_tv);
        scaleTv = (TextView) findViewById(R.id.scale_tv);

        fade = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in_out);
        bounce = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
        rotate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        scale = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);

        startAnim = (Button) findViewById(R.id.start_anim_bt);
        stopAnim = (Button) findViewById(R.id.stop_anim_bt);

        startAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fadeTv.startAnimation(fade);
                bounceTv.startAnimation(bounce);
                scaleTv.startAnimation(scale);
                rotateTv.startAnimation(rotate);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.hw5_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(Hw5_activity.this, "Going to set up this app...", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent intent=null;

        switch (id){
            case R.id.nav_hw1:
                intent = new Intent(this, HomeWork1_Main.class);
                break;
            case R.id.nav_hw2:
                intent = new Intent(this, HW2Activity.class);
                break;
            case R.id.nav_hw3:
                intent = new Intent(this, HomeWork3.class);
                break;
            case R.id.nav_hw4:
                intent = new Intent(this, Hw4_activity.class);
                break;
        }
        startActivity(intent);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
