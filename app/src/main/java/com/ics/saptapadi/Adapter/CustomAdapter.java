package com.ics.saptapadi.Adapter;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ics.saptapadi.CateringActivity;
import com.ics.saptapadi.Decoration_Activity;
import com.ics.saptapadi.Gift_Activity;
import com.ics.saptapadi.HallListActivity;
import com.ics.saptapadi.Hotel_BookingActivity;
import com.ics.saptapadi.InvitionActivity;
import com.ics.saptapadi.Jewellry_Activity;
import com.ics.saptapadi.MakeupActivity;
import com.ics.saptapadi.PhotographyActivity;
import com.ics.saptapadi.R;
import com.ics.saptapadi.Rental_Apparel_Activity;
import com.ics.saptapadi.TransportActivity;
import com.ics.saptapadi.View_One.MahendiActivity;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    ArrayList<String> Names;
    ArrayList<Integer> Images;
    Activity activity;

    public CustomAdapter(Activity context, ArrayList<String> Names, ArrayList<Integer> Images) {
        this.activity = context;
        this.Names = Names;
        this.Images = Images;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.categories,viewGroup,false);
        return new CustomAdapter.MyViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {
        myViewHolder.name.setText(""+Names.get(i));
        // myViewHolder.image.setImageResource(Images.get(i));
        myViewHolder.image.setImageResource(Images.get(i));


        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namee = Names.get(i);
                int getindex = Names.indexOf(namee);
                switch (getindex)
                {
                    case 0:
                        Intent intent= new Intent(activity, HallListActivity.class);
                        activity.startActivity(intent);
                        Toast.makeText(activity, ""+namee, Toast.LENGTH_SHORT).show();
                        break;

                    case 1:
                        Toast.makeText(activity, ""+namee, Toast.LENGTH_SHORT).show();
                        Intent intent0= new Intent(activity, Decoration_Activity.class);
                        activity.startActivity(intent0);
                        break;

                    case 2:
                        Toast.makeText(activity, ""+namee, Toast.LENGTH_SHORT).show();
                        Intent intent1= new Intent(activity, CateringActivity.class);
                        activity.startActivity(intent1);
                        break;

                    case 3:
                        Toast.makeText(activity, ""+namee, Toast.LENGTH_SHORT).show();
                        Intent intent2= new Intent(activity, PhotographyActivity.class);
                        activity.startActivity(intent2);
                        break;

                    case 4:
                        Toast.makeText(activity, ""+namee, Toast.LENGTH_SHORT).show();
                        Intent intent3= new Intent(activity, MakeupActivity.class);
                        activity.startActivity(intent3);
                        break;
                    case 5:
                        Toast.makeText(activity, ""+namee, Toast.LENGTH_SHORT).show();
                        Intent intent4= new Intent(activity, MahendiActivity.class);
                        activity.startActivity(intent4);

                        break;
                    case 6:
                        Toast.makeText(activity, ""+namee, Toast.LENGTH_SHORT).show();
                        Intent intent6= new Intent(activity, InvitionActivity.class);
                        activity.startActivity(intent6);
                        break;
                    case 7:
                        Toast.makeText(activity, ""+namee, Toast.LENGTH_SHORT).show();
                        Intent intent7= new Intent(activity, TransportActivity.class);
                        activity.startActivity(intent7);
                        break;

                    case 8:
                        Toast.makeText(activity, ""+namee, Toast.LENGTH_SHORT).show();
                        Intent intent8= new Intent(activity, Gift_Activity.class);
                        activity.startActivity(intent8);
                        break;

                    case 9:
                        Toast.makeText(activity, ""+namee, Toast.LENGTH_SHORT).show();
                         Intent intent9= new Intent(activity, Hotel_BookingActivity.class);
                      activity.startActivity(intent9);
                        break;

                    case 10:
                        Toast.makeText(activity, ""+namee, Toast.LENGTH_SHORT).show();
                        Intent intent10= new Intent(activity, Jewellry_Activity.class);
                        activity.startActivity(intent10);

                        break;

                    case 11:
                        Toast.makeText(activity, ""+namee, Toast.LENGTH_SHORT).show();
                        Intent intent11= new Intent(activity, Rental_Apparel_Activity.class);
                        activity.startActivity(intent11);
                        break;

                }
            }
        });

//        Animation animation;
//        animation = AnimationUtils.loadAnimation(activity,
//                R.anim.slide_down);
//        myViewHolder.image.startAnimation(animation);

    }

    @Override
    public int getItemCount() {
        return Images.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            image = (ImageView) itemView.findViewById(R.id.image);

        }
    }
}
