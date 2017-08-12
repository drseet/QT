package com.example.root.quiettime;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Chronometer;

public class SplashScreen extends configTime {

    Chronometer chron;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        chron = (Chronometer) findViewById(R.id.chron);

        //begin displaying elapsed time
        chron.start();

        if(warnTime()){
            Intent warn = new Intent(SplashScreen.this, Warn.class);
            startActivity(warn);
        }

    }
    //record times
    protected boolean warnTime() {
        if(sameHour(tp.getCurrentHour()))
            if(threeMinWarn(tp.getCurrentMinute()))
                return true;
        return false;
    }

}
