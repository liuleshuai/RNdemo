package com.awesomeproject.view;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.awesomeproject.R;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
    }

    private void init() {
        TabLayout mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        TabLayout.Tab one = mTabLayout.newTab();
        TabLayout.Tab two = mTabLayout.newTab();
        TabLayout.Tab three = mTabLayout.newTab();
        TabLayout.Tab four = mTabLayout.newTab();
        one.setIcon(R.mipmap.ic_launcher);
        two.setIcon(R.mipmap.ic_launcher);
        three.setIcon(R.mipmap.ic_launcher);
        four.setIcon(R.mipmap.ic_launcher);
        mTabLayout.addTab(one);
        mTabLayout.addTab(two);
        mTabLayout.addTab(three);
        mTabLayout.addTab(four);
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        Fragment fragment1 = Fragment1.newInstance(null, null);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.layout, fragment1);
        transaction.commit();
        this.getSupportFragmentManager().executePendingTransactions();
    }
}
