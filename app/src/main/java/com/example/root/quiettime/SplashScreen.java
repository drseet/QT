package com.example.root.quiettime;

import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends configTime {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        if(warnTime()){
            Intent warn = new Intent(SplashScreen.this, Warn.class);
            startActivity(warn);
        }

    }
    //record times
    protected boolean warnTime() {
        if(sameHour(tp.getHour()))
            if(threeMinWarn(tp.getMinute()))
                return true;
        return false;
    }

}
