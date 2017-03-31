package com.example.trishlapokharna.scoutingtakethree;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

//This is the launcher activity that house a homepage (Welcome!) and the navigation drawer at the left
public class MainActivity extends AppCompatActivity
        {
            TextView file;

            RoboInfo myRobo;
            @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
              //  file = (TextView)findViewById(R.id.textFileName);
               // file.setText(Confirmation.fileN)
               myRobo =  RoboInfo.getInstance();
        myRobo.setFileName("r1.txt");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        file = (TextView) findViewById(R.id.textFileName);
                file.setText(myRobo.getFileName());
        setSupportActionBar(toolbar);

       // DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        /*ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);*/

    }

    public void Go(View v) {
        Intent toInput = new Intent (this, Input.class);
        startActivity(toInput);
    }
            public void GoRanking(View v) {
                Intent toInput = new Intent (this, RankingContainer.class);
                startActivity(toInput);
            }

    /*@Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*@SuppressWarnings("StatementWithEmptyBody")
    @Override
   public boolean onNavigationItemSelected(MenuItem item) { //method for going to another activity
        // Handle navigation view item clicks here.            use intents to go from one activity to another
        int id = item.getItemId();

        if (id == R.id.nav_home) {

        } else if (id == R.id.nav_input) {
            Intent intent = new Intent(this, Input.class);
            startActivity(intent);
        } else if (id == R.id.nav_viewer) {

        } else if (id == R.id.nav_match) {

        } else if (id == R.id.nav_usb) {

        } else if (id == R.id.nav_bluetooth) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/
}