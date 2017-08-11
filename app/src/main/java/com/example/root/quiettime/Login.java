package com.example.root.quiettime;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Main {

    TextView usr, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usr = (TextView) findViewById(R.id.email_input);
        pass = (TextView) findViewById(R.id.pass_input);

    }

    protected void authenticate() {
        String username = usr.getText().toString();
        String password = pass.getText().toString();

        if(credsMatch(username, password)){
            //**ADD : if username = "admin" && password == "admin" adminMenu intent start else:
            Intent start = new Intent(Login.this, configTime.class);
            startActivity(start);
        }
        else
            Toast.makeText(getApplicationContext(),
                    "User not found, please register", Toast.LENGTH_LONG).show();

    }

    public void onStartTap(View v) {
        authenticate();
    }

    public void onRegTap(View v) {
        Intent reg = new Intent(Login.this, Register.class);
        startActivity(reg);
    }
}