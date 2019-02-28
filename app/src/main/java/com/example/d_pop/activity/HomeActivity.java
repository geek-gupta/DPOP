package com.example.d_pop.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.d_pop.adapter.HomeTabAdapter;
import com.example.d_pop.R;
import com.example.d_pop.fragments.HomeTabFragFour;
import com.example.d_pop.fragments.HomeTabFragOne;
import com.example.d_pop.fragments.HomeTabFragThree;
import com.example.d_pop.fragments.HomeTabFragTwo;

public class HomeActivity extends AppCompatActivity {

    private ActionBar mActionBar;
    private HomeTabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toast.makeText(this, "I am in Home Act.", Toast.LENGTH_SHORT).show();
        init();
    }

    private void init() {
//        mActionBar = getS


        viewPager = findViewById(R.id.home_viewpager);
        tabLayout = findViewById(R.id.tabLayout);

        adapter = new HomeTabAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeTabFragFour(), "Project");
        adapter.addFragment(new HomeTabFragOne(), "Query");
        adapter.addFragment(new HomeTabFragTwo(), "Notice");
        adapter.addFragment(new HomeTabFragThree(), "Attendance");


        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
