package com.example.root.quiettime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class configTime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_time);
    }

    public void onStartTap(View v) {
        Toast.makeText(getApplicationContext(), "Start", Toast.LENGTH_LONG).show();
    }
}
