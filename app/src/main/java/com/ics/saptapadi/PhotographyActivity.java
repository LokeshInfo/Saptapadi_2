package com.ics.saptapadi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.ics.saptapadi.Adapter.CateringAdapter;
import com.ics.saptapadi.Adapter.PhotographiAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class PhotographyActivity extends AppCompatActivity {
  Button photoghaphy_booking;
  ImageView backarrow;
  RecyclerView photograp_recyclerView;
    ArrayList Names = new ArrayList<>(Arrays.asList("Dellhi", " Mumbai", " Kolkata", "Indore", "Banglore", "Goa", "Chennai", "Hyderabad","All City"));
    ArrayList<Integer> Images = new ArrayList<>(Arrays.asList(R.drawable.hotel, R.drawable.hotel, R.drawable.hotel, R.drawable.hotel, R.drawable.hotel, R.drawable.hotel, R.drawable.hotel, R.drawable.hotel,R.drawable.hotel));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photography);

        photoghaphy_booking=(Button)findViewById(R.id.photoghaphy_booking);

        backarrow=(ImageView)findViewById(R.id.backarrow);
        photograp_recyclerView=(RecyclerView)findViewById(R.id.photograp_recyclerView);
        backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        photoghaphy_booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PhotographyActivity.this,Photography_Booking_Activity.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent(); // get Intent which was set from adapter of Previous Activity
        LinearLayoutManager linearHorizontal = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        photograp_recyclerView.setLayoutManager(linearHorizontal);
        PhotographiAdapter photographiAdapter = new PhotographiAdapter(PhotographyActivity.this, Names, Images);
        photograp_recyclerView.setAdapter(photographiAdapter); // set the Adapter to RecyclerView
    }
}
