package com.ics.saptapadi.View_One;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ics.saptapadi.R;

public class ForgotActivity extends AppCompatActivity {
    TextView back;
    Button getcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        back=(TextView)findViewById(R.id.back);
        getcode=(Button)findViewById(R.id.getcode);
        back.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        getcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ForgotActivity.this,ForgotOTPActivity.class);
                startActivity(intent);

            }
        });
    }
}
