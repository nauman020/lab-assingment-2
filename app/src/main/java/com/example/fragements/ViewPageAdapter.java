package com.example.fragements;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPageAdapter extends FragmentPagerAdapter {
    public ViewPageAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {

        if(position == 0){
            return new Fragment1();
        }
        else if(position == 1){
            return new Fragment2();
        }
        else if(position ==2){
            return new Fragment3();
        }

        return new Fragment1();
    }

    @Override
    public int getCount()
    {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        super.getPageTitle(position);
        String title = null;

        if(position == 0){
            title = "Fragment1";
        }
        if(position == 1){
            title = "Fragment2";
        }
        if(position == 2){
            title = "Fragment3";
        }

        return title;
    }
}
