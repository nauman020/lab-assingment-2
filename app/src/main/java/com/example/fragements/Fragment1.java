package com.example.fragements;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {


    Fragment2 fragment2;
    Fragment3 fragment3;


    TextView fragment1_tv,fragment2_tv,fragment3_tv;

    TextView fragment1_email_tv,fragment1_name_tv;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment1,container,false);

        fragment1_email_tv = (TextView) view.findViewById(R.id.fragement1_email_tv);
        fragment1_name_tv =  (TextView) view.findViewById(R.id.fragement1_name_tv);


        fragment2_tv = (TextView) view.findViewById(R.id.fragment2_tv);
        fragment3_tv = (TextView) view.findViewById(R.id.fragment3_tv);

        fragment2 = new Fragment2();
        fragment3 = new Fragment3();


        fragment2_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.frame, fragment2).commit();
            }
        });

        fragment3_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.frame, fragment3).commit();
            }
        });


        Bundle bundle = this.getArguments();


        if (bundle != null) {
            String email = bundle.getString("activity_email", "defaultValue");
            String name = bundle.getString("activity_name", "defaultValue");

            fragment1_email_tv.setText(email);
            fragment1_name_tv.setText(name);


        }

        return view;
    }


}
