package com.example.kazimtaani;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;

public class payout extends AppCompatActivity {

    MyPagerAdapter mypagerAdapter;
    private ItemViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(ItemViewModel.class);
        setTitle("Pay-out");
        setContentView(R.layout.activity_payout);

       ViewPager2 viewpage= findViewById(R.id.view_pager);
     //  ViewPager2.setUserInputEnabled(false);
       TabLayout tabLayout=findViewById(R.id.tab_layout);
       mypagerAdapter=new MyPagerAdapter(this);
      viewpage.setAdapter(mypagerAdapter);
    tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
         viewpage.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    });
    }
}