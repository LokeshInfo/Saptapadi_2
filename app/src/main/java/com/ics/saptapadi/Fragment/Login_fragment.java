package com.ics.saptapadi.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ics.saptapadi.R;
import com.ics.saptapadi.View_One.ForgotActivity;
import com.ics.saptapadi.View_One.SignupActivity;

public class Login_fragment extends Fragment
{
TextView signup;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment1, container, false);
        signup=(TextView)view.findViewById(R.id.signup);

        TextView forgotpswd=(TextView)view.findViewById(R.id.forgotpswd);
        forgotpswd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ForgotActivity.class);
                startActivity(intent);
            }
        });
        Button button = (Button)view.findViewById(R.id.login);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent= new Intent(getActivity(), HomePageActivity.class);
//                startActivity(intent);

//
//            }
//        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((SignupActivity)getActivity()).select_frag(2);
            }
        });


        return view;

    }
}
