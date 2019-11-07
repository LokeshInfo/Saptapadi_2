package com.ics.saptapadi.Adapter;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.ics.saptapadi.Fragment.Login_fragment;
import com.ics.saptapadi.Fragment.Sign_Up_fragment;

public class ViewPager_adapter extends FragmentPagerAdapter
{
    private Fragment[] childFragments;

    private String[] fname = {"Signin","Signup"};

    public ViewPager_adapter(FragmentManager fm) {
        super(fm);
        childFragments = new Fragment[] {
                new Login_fragment(), //0
                new Sign_Up_fragment(), //1
        };
    }

    @Override
    public Fragment getItem(int position)
    {

        return childFragments[position];
    }

    @Override
    public int getCount()
    {
        return childFragments.length;
        //3 items
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = fname[position];
        return title;

    }
}
