package com.example.kazimtaani;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;

public class SectionPagerAdapter extends PagerAdapter {
    public SectionPagerAdapter(FragmentManager supportFragmentManager) {
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        return super.instantiateItem(container, position);
    }
}
