package com.ics.saptapadi.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ics.saptapadi.AllCityListActivity;
import com.ics.saptapadi.CateringActivity;
import com.ics.saptapadi.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class CateringAdapter extends RecyclerView.Adapter<CateringAdapter.MyViewHolder> {

    ArrayList Names;
    ArrayList<Integer> Images;
    Context context;

    public CateringAdapter(Context context, ArrayList Names, ArrayList<Integer> Images) {
        this.context = context;
        this.Names = Names;
        this.Images = Images;
    }

    @NonNull
    @Override
    public CateringAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.catering_adapter,viewGroup,false);

        return new CateringAdapter.MyViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull final CateringAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.name.setText(""+Names.get(i));
        myViewHolder.circleimageview.setImageResource(Images.get(i));
//
//        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent= new Intent(context, AllCityListActivity.class);
//                context.startActivity(intent);
//            }
//        });
    }
    @Override
    public int getItemCount()
    {
        return Images.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public CircleImageView circleimageview;
        TextView name;
        CircleImageView circleImageView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            name = (TextView) itemView.findViewById(R.id.name);
            circleimageview=(CircleImageView)itemView.findViewById(R.id.circleimageview);

        }
    }
}
