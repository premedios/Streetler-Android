package com.premedios.streetler; /**
 * Created by user on 25/05/2016.
 */

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class StreetlerPagerAdapter extends FragmentStatePagerAdapter {

    Context ctx;

    public StreetlerPagerAdapter(Context ctx, FragmentManager fm) {

        super(fm);
        this.ctx = ctx;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        if (position == 0) return new StreetlerMapFragment();
        if (position == 1) return new MyProfileFragment();
        if (position == 2) return new MyProfileFragment();
        if (position == 3) return new MyProfileFragment();
        return null;
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "MAP";
            case 1:
                return "MY PROFILE";
            case 2:
                return "FRIENDS";
            case 3:
                return "NEWS";
        }
        return null;
    }
}