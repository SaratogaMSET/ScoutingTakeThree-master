package com.example.trishlapokharna.scoutingtakethree;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DisplaySingleMatchNew extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    RoboInfo myRobo = RoboInfo.getInstance();

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_single_match_new);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        TableLayout tl = (TableLayout) findViewById(R.id.tablelayoutsinglematch);
        TextView name = (TextView) findViewById(R.id.matchnumberteamname);

        try {
            verifyStoragePermissions(this);

            String yourFilePath = "/sdcard/TeamsMatches/" + myRobo.getSingleTeam() + "_"
                    + myRobo.getMatchNumber() + ".txt";
            name.setText(myRobo.getSingleTeam() + " - Match " + myRobo.getMatchNumber());

            File yourFile = new File(yourFilePath);
            if (!yourFile.exists()) {
                Toast.makeText(this, "File does not exist!", Toast.LENGTH_SHORT).show();
            } else {
                BufferedReader reader = new BufferedReader(new FileReader(yourFile));
                String line;
                while ((line = reader.readLine()) != null) {

                    String[] values = line.split(",");

                    TableRow tr = new TableRow(this);
                    TableRow.LayoutParams layoutParams = new TableRow.LayoutParams
                            (TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1.0f);

                    TextView tv1 = new TextView(this);
                    tv1.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.MATCH_PARENT, 0.65f));
                    tv1.setPadding(0, 5, 20, 5);
                    tv1.setText(values[0]);

                    TextView tv2 = new TextView(this);
                    tv2.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.MATCH_PARENT, 0.35f));
                    tv2.setPadding(30, 5, 5, 5);
                    tv2.setText(values[1]);

                    tr.addView(tv1);
                    tr.addView(tv2);
                    tl.addView(tr, layoutParams);
                }
            }
        }catch(IOException e) {
            e.printStackTrace();
            Log.d("file error", "" + e.getMessage());
        }
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
        getMenuInflater().inflate(R.menu.ranking_container, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Intent intent = null;
        if (id == R.id.nav_allteams) {
            intent = new Intent(this, AllTeamsNew.class);
            startActivity(intent);
        } else if (id == R.id.nav_matches) {
            intent = new Intent(this,RankingContainer.class);
            intent.putExtra("fragmentNumber", 2);
        } else if (id == R.id.nav_rankingauto) {
            intent = new Intent(this,AutoContainer.class);
            startActivity(intent);
        } else if (id == R.id.nav_rankingthigh) {
            intent = new Intent(this, TeleopHighContainer.class);
            startActivity(intent);
        } else if (id == R.id.nav_rankingtlow) {
            intent = new Intent(this, TeleopLowContainer.class);
            startActivity(intent);
        } else if (id == R.id.nav_rankingteleop) {
            intent = new Intent(this,TeleopOverallContainer.class);
            startActivity(intent);
        } else if (id == R.id.nav_rankingend) {
            intent = new Intent(this,EndContainer.class);
            startActivity(intent);
        } else if (id == R.id.nav_rankingoverall) {
            intent = new Intent(this,TeleopOverallContainer.class);
            startActivity(intent);
        } else if (id == R.id.nav_gohome) {
            intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }

        startActivity(intent);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }
}
