package com.ics.saptapadi.Fragment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.ics.saptapadi.R;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Guest_Date extends Fragment {


    ImageView to_dates,from_dates,guest_time,guests;
TextView text_todates,text_fromdates,text_time,text_guests;

String[] list={"1","2","3","4","5"};
// String[] listdays={"Sunday","Monday","Tuesday","Wedesday","Thursday","Friday","saturday"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_guest__date, container, false);
         to_dates=(ImageView)view.findViewById(R.id.to_dates);
        from_dates=(ImageView)view.findViewById(R.id.from_dates);
        guest_time=(ImageView)view.findViewById(R.id.guest_time);
        guests=(ImageView)view.findViewById(R.id.guests);
        text_todates=(TextView)view.findViewById(R.id.text_todates);
        text_fromdates=(TextView)view.findViewById(R.id.text_fromdates);
        text_time=(TextView)view.findViewById(R.id.text_time);
        text_guests=(TextView)view.findViewById(R.id.text_guests);


to_dates.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        final Calendar cldr = Calendar.getInstance();
        int day = cldr.get(Calendar.DAY_OF_MONTH);
        int month = cldr.get(Calendar.MONTH);
        int year = cldr.get(Calendar.YEAR);
// date picker dialog
        DatePickerDialog picker = new DatePickerDialog(getActivity(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        if (dayOfMonth < 10) {
                            text_todates.setText("0" + dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            //sob.setHire_from("0" + dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                        } else {
                            text_todates.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
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
from_dates.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        final Calendar cldr = Calendar.getInstance();
        int day = cldr.get(Calendar.DAY_OF_MONTH);
        int month = cldr.get(Calendar.MONTH);
        int year = cldr.get(Calendar.YEAR);
// date picker dialog
        DatePickerDialog picker = new DatePickerDialog(getActivity(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        if (dayOfMonth < 10) {
                            text_fromdates.setText("0" + dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            //sob.setHire_from("0" + dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                        } else {
                            text_fromdates.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
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

guest_time.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                text_time.setText(selectedHour + ":" + selectedMinute);
            }
        }, hour, minute, true);//Yes 24 hour time
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();
    }
});

guests.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        ViewGroup viewGroup = view.findViewById(android.R.id.content);
        final View dialogView = LayoutInflater.from(v.getContext()).inflate(R.layout.customview, viewGroup, false);
        final Spinner sspinnerguest = dialogView.findViewById(R.id.spinnerguest);
        Button ok = dialogView.findViewById(R.id.buttnok);
        ArrayAdapter sad = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,list);
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
                text_guests.setText(""+list[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
});
        return view;
    }

}
