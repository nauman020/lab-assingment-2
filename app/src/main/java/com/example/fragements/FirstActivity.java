package com.example.fragements;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity {


    EditText activity_email_et,activity_name_et;
    Button send_data_to_fragement_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        activity_email_et = findViewById(R.id.activity_email_et);
        activity_name_et = findViewById(R.id.activity_name_et);

        send_data_to_fragement_btn = findViewById(R.id.send_data_to_fragement_btn);

        send_data_to_fragement_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(FirstActivity.this,MainActivity.class);
                intent.putExtra("Activity_email",activity_email_et.getText().toString());
                intent.putExtra("Activity_name",activity_name_et.getText().toString());

                startActivity(intent);

            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}