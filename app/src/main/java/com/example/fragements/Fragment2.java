package com.example.fragements;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import org.w3c.dom.Text;

public class Fragment2 extends Fragment {


    TextView fragment1_tv,fragment2_tv,fragment3_tv;
    Button send_data_to_next_fragment_btn;
    EditText fragment2_email_et,fragment2_name_et;


    Fragment1 fragment1;
    Fragment3 fragment3;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment2,container,false);

        fragment2_email_et = view.findViewById(R.id.fragement2_email_et);
        fragment2_name_et = view.findViewById(R.id.fragement2_name_et);

        fragment2_tv = view.findViewById(R.id.fragment2_tv);
        fragment3_tv = view.findViewById(R.id.fragment3_tv);



        fragment1_tv = (TextView) view.findViewById(R.id.fragment1_tv);
        fragment2_tv = (TextView) view.findViewById(R.id.fragment2_tv);

        fragment1 = new Fragment1();
        fragment3 = new Fragment3();


        fragment1_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.frame, fragment1).commit();
            }
        });

        fragment3_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.frame, fragment3).commit();
            }
        });


        send_data_to_next_fragment_btn = view.findViewById(R.id.send_data_to_next_fragement_btn);

        send_data_to_next_fragment_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();

                bundle.putString("fragment2_email",fragment2_email_et.getText().toString());
                bundle.putString("fragment2_name",fragment2_name_et.getText().toString());


                fragment3.setArguments(bundle);

                getFragmentManager().beginTransaction()
                        .replace(R.id.frame, fragment3).commit();

            }
        });

        return view;
    }
}
