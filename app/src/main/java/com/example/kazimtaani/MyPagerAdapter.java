package com.example.kazimtaani;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

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
               return new pendingfragment();
       }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
