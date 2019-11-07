package com.ics.saptapadi.Fragment;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


import com.ics.saptapadi.R;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag1 extends Fragment {
ImageView image_zoom1,image_zoom2,image_zoom3;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.song_list ,container,false);

        final ImageView image_zoom1=(ImageView) view.findViewById(R.id.image_zoom1);
//        final ImageView image_zoom2=(ImageView) view.findViewById(R.id.image_zoom2);
//        final ImageView image_zoom3=(ImageView) view.findViewById(R.id.image_zoom3);

        Animation animZoomOut = AnimationUtils.loadAnimation(getActivity(),R.anim.slide_down);
                image_zoom1.startAnimation(animZoomOut);
//                image_zoom2.startAnimation(animZoomOut);
//        image_zoom3.startAnimation(animZoomOut);

        return  view;
    }
}
