package com.example.fragements;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {



    Fragment1 fragment1;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        fragment1 = new Fragment1();
        bundle = new Bundle();

        String email =  getIntent().getStringExtra("Activity_email");
        String name =  getIntent().getStringExtra("Activity_name");

        bundle.putString("activity_email", email);
        bundle.putString("activity_name",name);

        fragment1.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.frame, fragment1).commit();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}