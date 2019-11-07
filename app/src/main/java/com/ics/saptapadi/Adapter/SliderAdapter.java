package com.ics.saptapadi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ics.saptapadi.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class SliderAdapter extends SliderViewAdapter <SliderAdapter.SliderAdapterVH> {
    Context context;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.sliding_page, null);
        return new SliderAdapterVH(inflate);
    }



    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, int position) {
       // viewHolder.textview.setText("" + position);

        }


    @Override
    public int getCount() {
        return 4;
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        public ImageView imageGifContainer;
        View itemView;
            ImageView imageview;
           // TextView textview;

            public SliderAdapterVH(View itemView) {
                super(itemView);
                imageview = itemView.findViewById(R.id.imageview);
              //  textview = itemView.findViewById(R.id.textview);
                this.itemView = itemView;
            }
        }
    }
