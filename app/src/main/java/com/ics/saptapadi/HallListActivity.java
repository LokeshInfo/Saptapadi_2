package com.ics.saptapadi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ics.saptapadi.Adapter.NotificationAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class HallListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    CircleImageView circleimageview;
    TextView name, dates, time, guest, days;
    ImageView hallimage,backarrow;


    ArrayList Names = new ArrayList<>(Arrays.asList("Dellhi", " Mumbai", " Kolkata", "Indore", "Banglore", "Goa", "Chennai", "Hyderabad","All City"));
    ArrayList<Integer> Images = new ArrayList<>(Arrays.asList(R.drawable.hotel, R.drawable.hotel, R.drawable.hotel, R.drawable.hotel, R.drawable.hotel, R.drawable.hotel, R.drawable.hotel, R.drawable.hotel,R.drawable.hotel));
    //String[] list={"1","2","3","4","5"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hall_list);


        hallimage=(ImageView)findViewById(R.id.hallimage);
        backarrow=(ImageView)findViewById(R.id.backarrow);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        Intent intent = getIntent(); // get Intent which was set from adapter of Previous Activity
        LinearLayoutManager linearHorizontal = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(linearHorizontal);
        final NotificationAdapter notificationAdapter = new NotificationAdapter(HallListActivity.this, Names, Images);
        recyclerView.setAdapter(notificationAdapter); // set the Adapter to RecyclerView

        hallimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(HallListActivity.this,UberTestActivity.class);
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
