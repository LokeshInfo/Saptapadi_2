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
import com.ics.saptapadi.Adapter.NotificationAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class CateringActivity extends AppCompatActivity {
    ArrayList Names = new ArrayList<>(Arrays.asList("Dellhi", " Mumbai", " Kolkata", "Indore", "Banglore", "Goa", "Chennai", "Hyderabad","All City"));
    ArrayList<Integer> Images = new ArrayList<>(Arrays.asList(R.drawable.hotel, R.drawable.hotel, R.drawable.hotel, R.drawable.hotel, R.drawable.hotel, R.drawable.hotel, R.drawable.hotel, R.drawable.hotel,R.drawable.hotel));
    Button cateing_booking;
    RecyclerView recyclerView;
ImageView backarrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catering);

        backarrow=(ImageView)findViewById(R.id.backarrow);
        cateing_booking=(Button)findViewById(R.id.cateing_booking);
        recyclerView = (RecyclerView) findViewById(R.id.catering_recyclerView);


        Intent intent = getIntent(); // get Intent which was set from adapter of Previous Activity
        LinearLayoutManager linearHorizontal = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(linearHorizontal);
        CateringAdapter cateringAdapter = new CateringAdapter(CateringActivity.this, Names, Images);
        recyclerView.setAdapter(cateringAdapter);

        // set the Adapter to RecyclerView
        cateing_booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CateringActivity.this,Cateing_Booking_Activity.class);
                startActivity(intent);
            }
        });

        backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

}
