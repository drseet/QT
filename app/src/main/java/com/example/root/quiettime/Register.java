package com.example.root.quiettime;

import android.content.Intent;
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
        String username = usr.getText().toString();
        String password = pass.getText().toString();
        String password2 = pass2.getText().toString();

        if(password == null)
            createUser(username, "");
        else
            if(!password.equals(password2))
                Toast.makeText(getApplicationContext(),
                        "Passwords don't match!", Toast.LENGTH_LONG).show();
        if(password.equals(password2)) {
            if (userFound(username))
                Toast.makeText(getApplicationContext(),
                        "Username taken! Try Again", Toast.LENGTH_LONG).show();
            else {
                createUser(username, password);
                Intent login = new Intent(Register.this, Login.class);
                startActivity(login);
            }
        }
    }
}
