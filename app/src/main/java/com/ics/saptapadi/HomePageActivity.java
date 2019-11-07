package com.ics.saptapadi;

import android.content.Intent;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ics.saptapadi.Adapter.CustomAdapter;
import com.ics.saptapadi.Adapter.SliderAdapter;
import com.ics.saptapadi.View_One.Privacy_policyActivity;
import com.ics.saptapadi.View_One.SignupActivity;
import com.ics.saptapadi.View_One.TearmAndConditionActivity;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.Arrays;

public class HomePageActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    SliderView imageSlider;
    ImageView image,header_Image;
    TextView name,profilename;
    RecyclerView recyclerView;
    Animation slide_down;
LinearLayout header;


    ArrayList<String> Names = new ArrayList<String>(Arrays.asList("Banquet Halls", "Decorators", "Caterers", "Photographers", "Makeup Artists", "Mahendi Artists", "Invitation Cards", "Transport", "Gift", "Hotels", "Jewellry" , "Rental Apparel"));
    ArrayList<Integer> Images = new ArrayList<>(Arrays.asList(R.drawable.blanquet_halls, R.drawable.decoration_blue, R.drawable.caters, R.drawable.photography,R.drawable.makeup,R.drawable.mahendi_icon, R.drawable.invition_blue_icon, R.drawable.trasport, R.drawable.gift_blue,R.drawable.hotel_blue_icon,R.drawable.jweler,R.drawable.apparel));
    Drawable d;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View header = navigationView.getHeaderView(0);

        header_Image=(ImageView)header.findViewById(R.id.imageUpload);
        profilename=(TextView)findViewById(R.id.profilename);
        imageSlider=(SliderView)findViewById(R.id.imageSlider);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        imageSlider=(SliderView)findViewById(R.id.imageSlider);





//        profilename.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(HomePageActivity.this,ProfileCameraActivity.class);
//                startActivity(intent);
//            }
//        });
        header_Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (ActivityCompat.checkSelfPermission(HomePageActivity.this,
//                        Manifest.permission.READ_EXTERNAL_STORAGE) !=
//                        PermissionChecker.PERMISSION_GRANTED) {
//                    ActivityCompat.requestPermissions(HomePageActivity.this, new
//                            String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 112);
//                }
//                else
//                {
//                    Intent in=new Intent(Intent.ACTION_PICK,
//                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                    startActivityForResult(in,112);
//                }
            }
        });


        setSupportActionBar(toolbar);
        Drawable drawable=getResources().getDrawable(R.drawable.saptapadi_name_white);



        getSupportActionBar().setTitle("");
        getSupportActionBar().setIcon(drawable);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        navigationView.setNavigationItemSelectedListener(this);





        SliderAdapter adapter;
        adapter = new SliderAdapter(HomePageActivity.this);

        imageSlider.setSliderAdapter(adapter);

        imageSlider.setIndicatorAnimation(IndicatorAnimations.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        imageSlider.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        imageSlider.setIndicatorVisibility(false);
        //imageSlider.setIndicatorSelectedColor(Color.WHITE);
        //imageSlider.setIndicatorUnselectedColor(Color.GRAY);
        imageSlider.setScrollTimeInSec(3); //set scroll delay in seconds :
        imageSlider.startAutoCycle();



        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);

        Intent intent = getIntent(); // get Intent which was set from adapter of Previous Activity
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2, LinearLayoutManager.VERTICAL,false);


        recyclerView.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView

        CustomAdapter customAdapter = new CustomAdapter(HomePageActivity.this,Names,Images);
        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView


    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
      //  if (id == R.id.action_settings) {
            return true;
        }

       // return super.onOptionsItemSelected(item);
    //}

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
           Intent intent=new Intent(HomePageActivity.this,ProfileActivity.class);
           startActivity(intent);

        } else if (id == R.id.nav_order) {


        } else if (id == R.id.nav_contact) {

            Intent intent= new Intent(HomePageActivity.this,ContactActivity.class);
            startActivity(intent);


        } else if (id == R.id.nav_notification) {


        }  else if (id == R.id.nav_privacy) {
            Intent intent=new Intent(HomePageActivity.this, Privacy_policyActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_termcondition) {
            Intent intent = new Intent(HomePageActivity.this, TearmAndConditionActivity.class);
            startActivity(intent);
        }

               else if (id == R.id.nav_share) {
                    shareApp();
        }
        else if (id == R.id.nav_login) {
            Intent intent= new Intent(HomePageActivity.this, SignupActivity.class);
          startActivity(intent);

        }




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void shareApp() {

        try {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
            String shareMessage= "\nLet me recommend you this application\n\n";
            shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID +"\n\n";
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
            startActivity(Intent.createChooser(shareIntent, "choose one"));
        } catch(Exception e) {
            //e.toString();
        }
    }

}
