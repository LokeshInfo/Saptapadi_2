package com.ics.saptapadi;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;

import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.ics.saptapadi.Adapter.SectionsPagerAdapter;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class UberTestActivity extends AppCompatActivity {
    public NestedScrollView nesscroll;
    private Fragment Frag1;
    private Fragment Frag2;
    private Fragment Frag3;
    private Fragment Frag4;
    private Fragment Frag5;
    View v1,v2;
    LinearLayout linearLayout1,linearLayout2,linearLayout3,linearLayout4,linearLayout5;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uber_test);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        Frag1 = getSupportFragmentManager().findFragmentById(R.id.frg1);
        Frag2 = getSupportFragmentManager().findFragmentById(R.id.frag2);
        Frag3=getSupportFragmentManager().findFragmentById(R.id.frag3);
        Frag4 = getSupportFragmentManager().findFragmentById(R.id.frag4);
        Frag5=getSupportFragmentManager().findFragmentById(R.id.frag5);
        linearLayout1 = findViewById(R.id.linearLayout1);
        linearLayout2 = findViewById(R.id.linearLayout2);
        linearLayout3 = findViewById(R.id.linearLayout3);
        linearLayout4 = findViewById(R.id.linearLayout4);
        linearLayout5 = findViewById(R.id.linearLayout5);

        nesscroll = findViewById(R.id.nesscroll);
//        v1 = findViewById(R.id.v1);
//        v2 = findViewById(R.id.v2);

        viewPager.setAdapter(sectionsPagerAdapter);
        final TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
//        Frag2.getContext().
//        if (savedInstanceState == null) {
//            Frag1 = getSupportFragmentManager().findFragmentById(R.id.frg1);
//        }
//        FloatingActionButton fab = findViewById(R.id.fab);
//
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        if(linearLayout1.getForegroundGravity() == Gravity.TOP)
        {
            Toast.makeText(UberTestActivity.this, "It is in center", Toast.LENGTH_SHORT).show();
        }
        nesscroll.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                Rect scrollBounds = new Rect();
                nesscroll.getHitRect(scrollBounds);

//               int pos[] = new int[2];
//               linearLayout2.getLocationOnScreen(pos);
//               int centerX = pos[0] + linearLayout2.getTop();
//               int centerY = pos[1] + linearLayout2.getBottom();
//               int centerX1 = pos[1] + linearLayout2.getTop();
//               int centerY1 = pos[0] + linearLayout2.getBottom();
//               int gravity1 = linearLayout1.getGravity();
//               int gravity4 = linearLayout2.getGravity();
//               int gravity2 = Gravity.TOP;
//               int gravity3 = Gravity.BOTTOM;
//               if(linearLayout1.getGravity() == Gravity.TOP)
//               {
//                   Toast.makeText(UberTestActivity.this, "It is in center", Toast.LENGTH_SHORT).show();
//               }else if(linearLayout2.getForegroundGravity() == Gravity.TOP) {
//                   Toast.makeText(UberTestActivity.this, "No it is not", Toast.LENGTH_SHORT).show();
//               }
                if(linearLayout2.getLocalVisibleRect(scrollBounds))
                {
                    TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
                    TabLayout.Tab tab = tabLayout.getTabAt(1);
                    tab.select();
                    // tabs.setScrollPosition(1 ,1,true);
                    //      Toast.makeText(UberTestActivity.this, "Now this is visibke", Toast.LENGTH_SHORT).show();
                }else if(linearLayout1.getLocalVisibleRect(scrollBounds)) {
                    TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
                    TabLayout.Tab tab = tabLayout.getTabAt(0);
                    tab.select();
                    //     Toast.makeText(UberTestActivity.this, "Not now", Toast.LENGTH_SHORT).show();
                }else if(linearLayout3.getLocalVisibleRect(scrollBounds)) {
                    TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
                    TabLayout.Tab tab = tabLayout.getTabAt(2);
                    tab.select();
                }else if(linearLayout4.getLocalVisibleRect(scrollBounds)) {
                    TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
                    TabLayout.Tab tab = tabLayout.getTabAt(3);
                    tab.select();
                }else if(linearLayout5.getLocalVisibleRect(scrollBounds)) {
                    TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
                    TabLayout.Tab tab = tabLayout.getTabAt(4);
                    tab.select();
                }



            }
        });


        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //    Toast.makeText(UberTestActivity.this, "tab selected"+tab.getPosition(), Toast.LENGTH_SHORT).show();
                if(tab.getPosition() ==0)
                {
                    linearLayout1.requestFocus();
                    //   = // your scrollview
                    //     View insideView = // find the View that you need to scroll to which is inside this ScrollView
//                    nesscroll.fullScroll(ScrollView.DRAG_FLAG_GLOBAL);
                    nesscroll.scrollTo(0, (int)linearLayout1.getY());
//                    linearLayout2.requestFocus(5);
//                    Frag1.getActivity().
                }else  if(tab.getPosition() ==1)
                {
//                    nesscroll.fullScroll(ScrollView.DRAG_FLAG_GLOBAL);
                    linearLayout2.requestFocus();
                    nesscroll.scrollTo(0, (int)linearLayout2.getY());
                }else  if(tab.getPosition() ==2)
                {
//                    nesscroll.fullScroll(ScrollView.DRAG_FLAG_GLOBAL);
                    linearLayout3.requestFocus();
                    nesscroll.scrollTo(0, (int)linearLayout3.getY());
                }else  if(tab.getPosition() ==3)
                {
//                    nesscroll.fullScroll(ScrollView.DRAG_FLAG_GLOBAL);
                    linearLayout4.requestFocus();
                    nesscroll.scrollTo(0, (int)linearLayout4.getY());
                }else  if(tab.getPosition() ==4)
                {
//                    nesscroll.fullScroll(ScrollView.DRAG_FLAG_GLOBAL);
                    linearLayout5.requestFocus();
                    nesscroll.scrollTo(0, (int)linearLayout5.getY());
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // Toast.makeText(UberTestActivity.this, "tab selected"+tab.getText(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //  Toast.makeText(UberTestActivity.this, "tab selected"+tab.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}