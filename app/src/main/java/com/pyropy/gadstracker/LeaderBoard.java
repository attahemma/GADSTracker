package com.pyropy.gadstracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;
import com.pyropy.gadstracker.Adapters.ViewPagerAdapter;
import com.pyropy.gadstracker.FragmentSwitch.LearningLeaders;
import com.pyropy.gadstracker.FragmentSwitch.SkillLeaders;

public class LeaderBoard extends AppCompatActivity {

    private static final String TAG = "LeaderBoard";
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ViewPagerAdapter mViewPagerAdapter;
    private Toolbar mMyToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setTheme(R.style.CustomTheme1);
        setContentView(R.layout.activity_leader_board);

        //initialize components
        initComponents();

        //add fragments to adapter
        addFragToAdapter();

        //prep display
        prepDisplay();

    }

    private void prepDisplay() {
        //set adapter to viewpager
        mViewPager.setAdapter(mViewPagerAdapter);

        //add viewpager to tablayout
        mTabLayout.setupWithViewPager(mViewPager);
        Log.d(TAG,"Display ready and launched.");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);
    }

    private void addFragToAdapter() {
        mViewPagerAdapter.addFragment(new LearningLeaders(),"Learning Leaders");
        mViewPagerAdapter.addFragment(new SkillLeaders(),"Skill IQ Leaders");
        Log.d(TAG,"Fragments added to Adapter.");
    }

    private void initComponents() {
        mMyToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(mMyToolbar);
        mTabLayout = findViewById(R.id.tablayout);
        mViewPager = findViewById(R.id.viewpager);

        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        Log.d(TAG,"Components Initialized and ViewPagerAdapter Created.");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.leaderboard_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.submit_menu:
                Intent intent = new Intent(this,SubmissionActivity.class);
                startActivity(intent);
                return true;
            default:
                return true;
        }
    }
}