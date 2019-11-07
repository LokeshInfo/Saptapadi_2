package com.ics.saptapadi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.ics.saptapadi.Adapter.CityListAdapter;

import java.util.ArrayList;

public class AllCityListActivity extends AppCompatActivity {
    RecyclerView city_list;
    ArrayList<String> city;

    ImageView backarrow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_city_list);

        backarrow=(ImageView)findViewById(R.id.backarrow);

        city_list = (RecyclerView) findViewById(R.id.city_list);
        city = new ArrayList<>();
        city.add("Indore");
        city.add("Bangluru");
        city.add("Chaenni");
        city.add("Mummbai");
        city.add("Delhi");
        city.add("Hydarabad");
        city.add("Hydarabad");

        Intent intent = getIntent(); // get Intent which was set from adapter of Previous Activity
        LinearLayoutManager linearHorizontal = new LinearLayoutManager(AllCityListActivity.this);

        city_list.setLayoutManager(linearHorizontal);
        CityListAdapter cityListAdapter = new CityListAdapter(city, AllCityListActivity.this);
        city_list.setAdapter(cityListAdapter); // set the Adapter to RecyclerView
        backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}


