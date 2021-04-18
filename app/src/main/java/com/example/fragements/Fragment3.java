package com.example.fragements;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment3 extends Fragment {

    TextView fragment3_email_tv,fragment_name_tv;


    TextView fragment1_tv,fragment2_tv,fragment3_tv;

    Fragment1 fragment1;
    Fragment2 fragment2;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment3,container,false);

        fragment3_email_tv = (TextView) view.findViewById(R.id.fragment3_email_tv);
        fragment_name_tv = (TextView) view.findViewById(R.id.fragment3_name_tv);


        fragment1_tv = (TextView) view.findViewById(R.id.fragment1_tv);
        fragment2_tv = (TextView) view.findViewById(R.id.fragment2_tv);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();


        fragment1_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.frame, fragment1).commit();
            }
        });

        fragment2_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.frame, fragment2).commit();
            }
        });

        Bundle bundle = this.getArguments();

        if (bundle != null) {
            String email = bundle.getString("fragment2_email", "defaultValue");
            String name = bundle.getString("fragment2_name", "defaultValue");

            fragment3_email_tv.setText(email);
            fragment_name_tv.setText(name);
        }

        return view;
    }
}
