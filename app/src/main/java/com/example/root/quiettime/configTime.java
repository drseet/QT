package com.example.root.quiettime;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class configTime extends Main {

    TimePicker tp;
    int currentMin, currentHour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_time);
        tp = (TimePicker) findViewById(R.id.timePicker);
    }

    /*
    Save current ringtone and change to something that is not jarring ***************
     (change back after)
    */
    protected boolean sameHour (int endHour) {
        currentHour = Calendar.HOUR_OF_DAY;

        if(currentHour >= endHour)
            return true;
        return sameHour(endHour);
    }

    protected boolean threeMinWarn(int endMin){
        currentMin = Calendar.MINUTE;

        if(currentMin < (endMin - 3))
            return threeMinWarn(endMin);
        if(currentMin >= endMin - 3)
            return true;
        return threeMinWarn(endMin);
    }
    public void onStartTap(View v) {
        Intent splash = new Intent(configTime.this, SplashScreen.class);
        startActivity(splash);
    }
}
