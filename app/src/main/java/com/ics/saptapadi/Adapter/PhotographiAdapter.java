package com.ics.saptapadi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ics.saptapadi.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class PhotographiAdapter extends RecyclerView.Adapter<PhotographiAdapter.MyViewHolder> {

    ArrayList Names;
    ArrayList<Integer> Images;
    Context context;

    public PhotographiAdapter(Context context, ArrayList Names, ArrayList<Integer> Images) {
        this.context = context;
        this.Names = Names;
        this.Images = Images;
    }

    @NonNull
    @Override
    public PhotographiAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.photoghaphiy_adapter, viewGroup, false);

        return new PhotographiAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final PhotographiAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.name.setText(""+Names.get(i));
        myViewHolder.circleimageview.setImageResource(Images.get(i));
    }

    @Override
    public int getItemCount() {
        return Images.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public CircleImageView circleimageview;
        TextView name;
        CircleImageView circleImageView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            name = (TextView) itemView.findViewById(R.id.name);
            circleimageview = (CircleImageView) itemView.findViewById(R.id.circleimageview);

        }
    }
}
