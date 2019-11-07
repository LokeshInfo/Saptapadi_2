package com.ics.saptapadi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.ics.saptapadi.View_One.Mahendi_Booking_Activity;

public class MakeupActivity extends AppCompatActivity {
    Button Makeup_booking;
    ImageView backarrow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makeup);

        Makeup_booking=(Button)findViewById(R.id.Makeup_booking);
        backarrow=(ImageView)findViewById(R.id.backarrow);

        backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Makeup_booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MakeupActivity.this, Mahendi_Booking_Activity.class);
                startActivity(intent);
            }
        });

    }

}
