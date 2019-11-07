package com.ics.saptapadi;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                // This method will be executed once the timer is over
           // Intent intent = new Intent(MainActivity.this,UberTestActivity.class);
               Intent intent = new Intent(MainActivity.this,HomePageActivity.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }
}