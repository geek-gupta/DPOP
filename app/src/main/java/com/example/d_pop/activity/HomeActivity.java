package com.example.d_pop.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.d_pop.adapter.HomeTabAdapter;
import com.example.d_pop.R;
import com.example.d_pop.fragments.HomeTabFragFour;
import com.example.d_pop.fragments.HomeTabFragOne;
import com.example.d_pop.fragments.HomeTabFragThree;
import com.example.d_pop.fragments.HomeTabFragTwo;
import com.example.d_pop.utility.SaveSharedPreferences;

public class HomeActivity extends AppCompatActivity {


    private HomeTabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
    }

    private void init() {

        viewPager = findViewById(R.id.home_viewpager);
        tabLayout = findViewById(R.id.tabLayout);

        adapter = new HomeTabAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeTabFragOne(), "Query");
        adapter.addFragment(new HomeTabFragFour(), "Project");
        adapter.addFragment(new HomeTabFragTwo(), "Notes");
        adapter.addFragment(new HomeTabFragThree(), "Attendance");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int  id = item.getItemId();
        switch (id) {
            case R.id.logout:
                SaveSharedPreferences.setLoggedIn(getApplicationContext(), false);
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                break;

            case R.id.about_me_profile:
                Intent intent1 = new Intent(this, ProfileActivity.class);
                startActivity(intent1);
                break;

            case R.id.teachers_profile:
                Intent intent2 = new Intent(this, TeachersProfileActivity.class);
                startActivity(intent2);
                break;
        }
        return true;
    }
}
