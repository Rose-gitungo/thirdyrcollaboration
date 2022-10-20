package com.example.kazimtaani;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

class MyPagerAdapter extends FragmentStateAdapter {


    public MyPagerAdapter(payout payout) {
        super(payout);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
       switch(position){
           case 1:
               return new payment();
           case 2:
               return new summary();
           default:
               return new pending();
       }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
