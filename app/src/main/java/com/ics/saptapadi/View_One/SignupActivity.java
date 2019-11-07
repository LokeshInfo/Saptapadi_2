package com.ics.saptapadi.View_One;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.ics.saptapadi.Adapter.ViewPager_adapter;
import com.ics.saptapadi.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class SignupActivity extends AppCompatActivity {

    TextView signup;
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new ViewPager_adapter(getSupportFragmentManager()));

        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);


    }

    public void select_frag(int position)
    {
        viewPager.setCurrentItem(position);
    }

}
