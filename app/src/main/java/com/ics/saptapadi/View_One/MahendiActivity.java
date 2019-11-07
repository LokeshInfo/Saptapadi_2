package com.ics.saptapadi.View_One;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.ics.saptapadi.Cateing_Booking_Activity;
import com.ics.saptapadi.CateringActivity;
import com.ics.saptapadi.R;

public class MahendiActivity extends AppCompatActivity {
    ImageView backarrow;
    Button Mahendi_booking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahendi);

        backarrow=(ImageView)findViewById(R.id.backarrow);
        Mahendi_booking=(Button)findViewById(R.id.Mahendi_booking);
        Mahendi_booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MahendiActivity.this, Mahendi_Booking_Activity.class);
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
