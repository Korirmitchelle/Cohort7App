package com.example.mitchelle.cohort7.activities;

import android.content.res.Configuration;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.mitchelle.cohort7.events.DrawerSectionItemClickedEvent;
import com.example.mitchelle.cohort7.utils.EventBus;
import com.example.mitchelle.cohort7.fragments.ExhibitsListFragment;
import com.example.mitchelle.cohort7.fragments.GalleryFragment;
import com.example.mitchelle.cohort7.fragments.MitchMapFragment;
import com.example.mitchelle.cohort7.R;
import com.squareup.otto.Subscribe;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private String mCurrentFragmentTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_opened, R.string.drawer_closed) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if (getSupportActionBar() != null)
                    getSupportActionBar().setTitle(R.string.drawer_opened);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                if (getSupportActionBar() != null)
                    getSupportActionBar().setTitle(R.string.drawer_closed);
            }
        };
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
        displayInitialFragment();

    }
    private void displayInitialFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, ExhibitsListFragment.getInstance()).commit();
        mCurrentFragmentTitle = "Exhibits";  /*doesnt need to load if on the same page*/
    }
    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mActionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mActionBarDrawerToggle.onConfigurationChanged(newConfig);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mActionBarDrawerToggle.onOptionsItemSelected(item))
            return true;

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override      /*Starts up the event bus to listen and post message*/
    protected void onStart() {
        super.onStart();
        EventBus.getInstance().register(this);

    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getInstance().unregister(this);
        super.onStop();
    }
    @Subscribe
    public void onDrawerSectionItemClickEvent(DrawerSectionItemClickedEvent event){
        mDrawerLayout.closeDrawers();

        if (event==null || TextUtils.isEmpty(event.section) || event.section.equalsIgnoreCase(mCurrentFragmentTitle)){
            return;
        }
        Toast.makeText(this, "MainActivity:Section clicked: " +event.section, Toast.LENGTH_SHORT).show();


        if (event.section.equalsIgnoreCase("maps")){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, MitchMapFragment.getInstance()).commit();
        }
        else if (event.section.equalsIgnoreCase("gallery")){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, GalleryFragment.getInstance()).commit();
        }
        else if (event.section.equalsIgnoreCase("exhibits")){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,  ExhibitsListFragment.getInstance()).commit();
        }
        else {
            return;
        }
        mCurrentFragmentTitle = event.section;
    }


}
