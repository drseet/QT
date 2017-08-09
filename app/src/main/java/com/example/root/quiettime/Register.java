package com.example.root.quiettime;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends Main {
    EditText usr, pass, pass2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        usr = (EditText) findViewById(R.id.username_input);
        pass = (EditText) findViewById(R.id.pass_input);
        pass2 = (EditText) findViewById(R.id.pass_input2);
    }

    public void onCreateTap(View v) {
        String username = new String();

        if(usr != null)
            username = usr.getText().toString();
        else
            Toast.makeText(getApplicationContext(), "Enter a username!", Toast.LENGTH_LONG).show();

        if(pass == null || pass2 == null){
            createUser(username, "");
            Toast.makeText(getApplicationContext(), "User created", Toast.LENGTH_LONG).show();

        }
        else if(pass.getText().toString() == pass2.getText().toString()) {
            if (userFound(username))
                Toast.makeText(getApplicationContext(), "User already exists!", Toast.LENGTH_LONG).show();
            else {
                createUser(username, pass.getText().toString());
                Toast.makeText(getApplicationContext(), "User created", Toast.LENGTH_LONG).show();

            }
        Toast.makeText(getApplicationContext(), pass + " / " + pass2, Toast.LENGTH_LONG).show();
        }
    }
}
