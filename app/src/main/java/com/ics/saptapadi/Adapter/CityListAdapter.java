package com.ics.saptapadi.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ics.saptapadi.R;

public class CityListAdapter extends RecyclerView.Adapter<CityListAdapter.MyViewHolder> {

//    String[]cities;
    ArrayList list;
    Activity activity;

    public CityListAdapter(ArrayList cities, Activity activity) {
        this.list = cities;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View vi = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_city_listview,viewGroup,false);

        return new CityListAdapter.MyViewHolder(vi);
    }

    @Override
    public void onBindViewHolder(@NonNull CityListAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.cityName.setText(""+list.get(i));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView cityName;


        public MyViewHolder(View view) {
            super(view);

            cityName=(TextView)view.findViewById(R.id.cityName);
        }
    }
}
