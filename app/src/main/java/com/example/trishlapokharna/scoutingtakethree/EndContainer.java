package com.example.trishlapokharna.scoutingtakethree;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;

import com.astuetz.PagerSlidingTabStrip;

public class EndContainer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final int NUM_PAGES = 2;
    public ViewPager mPager;
    public ScreenSlidePagerAdapter mPagerAdapter;
    public String tabTitles[] = new String[]{"End Ratios", "End Averages"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_container);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pagerend);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);


        final PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabsStrip.setViewPager(mPager);


        tabsStrip.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                final InputMethodManager imm = (InputMethodManager) getSystemService(
                        Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(tabsStrip.getWindowToken(), 0);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
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

        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
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
            intent = new Intent(this,RankingContainer.class);
            intent.putExtra("fragmentNumber", 3);
        } else if (id == R.id.nav_rankingend) {
            intent = new Intent(this,EndContainer.class);
            startActivity(intent);
        } else if (id == R.id.nav_rankingoverall) {
            intent = new Intent(this,RankingContainer.class);
            intent.putExtra("fragmentNumber", 4);
        } else if (id == R.id.nav_gohome) {
            intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }

        startActivity(intent);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    /**
     * A simple pager adapter that represents 3 ScreenSlidePageFragment objects, in
     * sequence.
     */
    public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        private Fragment[] tabList = new Fragment[NUM_PAGES];

        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }


        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new EndFirst();
            } else {
                return new EndSecond();
            }
        }

        //@Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }

    }
}
