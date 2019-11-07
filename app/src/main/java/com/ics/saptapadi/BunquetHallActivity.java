package com.ics.saptapadi;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.ics.saptapadi.Adapter.NotificationAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import de.hdodenhof.circleimageview.CircleImageView;

public class BunquetHallActivity extends AppCompatActivity  {
    RecyclerView recyclerView;
    CircleImageView circleimageview;
    TextView name, dates, time, guest, days;

    ArrayList Names = new ArrayList<>(Arrays.asList("Banquet Halls", "Banquet Halls", "Banquet Halls", "Banquet Halls", "Banquet Halls", "Banquet Halls", "Banquet Halls", "Banquet Halls"));
    ArrayList<Integer> Images = new ArrayList<>(Arrays.asList(R.drawable.hotel, R.drawable.hotel, R.drawable.hotel, R.drawable.hotel, R.drawable.hotel, R.drawable.hotel, R.drawable.hotel, R.drawable.hotel));
    String[] list={"1","2","3","4","5"};
    String[] listdays={"Sunday","Monday","Tuesday","Wedesday","Thursday","Friday","saturday"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bunquet_hall);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        dates = (TextView) findViewById(R.id.dates);
        time = (TextView) findViewById(R.id.time);
        guest = (TextView)findViewById(R.id.guest);
        days=(TextView)findViewById(R.id.days);




        findViewById(R.id.days).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder1 = new AlertDialog.Builder(BunquetHallActivity.this);
                ViewGroup viewGroup = findViewById(android.R.id.content);
                final View dialogView = LayoutInflater.from(v.getContext()).inflate(R.layout.dayscustomview, viewGroup, false);
                final Spinner sspinnerdays = dialogView.findViewById(R.id.spinnerdays);
                Button dayok = dialogView.findViewById(R.id.daysok);
                ArrayAdapter sadays = new ArrayAdapter(BunquetHallActivity.this,android.R.layout.simple_spinner_item,listdays);
                sspinnerdays.setAdapter(sadays);

                builder1.setView(dialogView);
                final AlertDialog alertDialog = builder1.create();
                alertDialog.show();

                dayok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });

                sspinnerdays.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        days.setText(""+listdays[position]);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });


            }
        });



        findViewById(R.id.guest).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(BunquetHallActivity.this);
                ViewGroup viewGroup = findViewById(android.R.id.content);
                final View dialogView = LayoutInflater.from(v.getContext()).inflate(R.layout.customview, viewGroup, false);
                final Spinner sspinnerguest = dialogView.findViewById(R.id.spinnerguest);
                Button ok = dialogView.findViewById(R.id.buttnok);
                ArrayAdapter sad = new ArrayAdapter(BunquetHallActivity.this,android.R.layout.simple_spinner_item,list);
                sspinnerguest.setAdapter(sad);

                builder.setView(dialogView);
                final AlertDialog alertDialog = builder.create();
                alertDialog.show();

                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });

                sspinnerguest.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        guest.setText(""+list[position]);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });


            }
        });


        dates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
// date picker dialog
                DatePickerDialog picker = new DatePickerDialog(BunquetHallActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                if (dayOfMonth < 10) {
                                    dates.setText("0" + dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                    //sob.setHire_from("0" + dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                } else {
                                    dates.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                    //sob.setHire_from(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                }

                            }
                        }, year, month, day);
                Log.d("mill sec is", "" + System.currentTimeMillis());
                picker.getDatePicker().setMinDate((System.currentTimeMillis() + TimeUnit.DAYS.toMillis(1)));
// picker.getDatePicker().setMinDate( (System.currentTimeMillis() -10000000) );
// picker.getDatePicker().getCalendarView().setMinDate();
                picker.show();
            }
        });

        Intent intent = getIntent(); // get Intent which was set from adapter of Previous Activity
        LinearLayoutManager linearHorizontal = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(linearHorizontal);
        NotificationAdapter notificationAdapter = new NotificationAdapter(BunquetHallActivity.this, Names, Images);
        recyclerView.setAdapter(notificationAdapter); // set the Adapter to RecyclerView


        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(BunquetHallActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        time.setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });


       //spinnerguest.setOnItemSelectedListener(this);
//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        list.add("4");
//        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(BunquetHallActivity.this, R.layout.support_simple_spinner_dropdown_item, list);
//        spinnerguest.setAdapter(adapter);
//        spinnerguest.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//
//
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//               String list = parent.getItemAtPosition(position).toString();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

    }
}




























