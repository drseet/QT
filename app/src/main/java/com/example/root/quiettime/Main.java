package com.example.root.quiettime;


import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class Main extends User{

    MessageDigest md;

    protected String hash(String input) {

        try{
            md = MessageDigest.getInstance("SHA-256");
            md.update(input.getBytes());
            byte result[] = md.digest();
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i< result.length; ++i)
                sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));

            return sb.toString();
        }catch (NoSuchAlgorithmException ex) {
            Log.v("QT","ERROR: Unable to hash password");
            ex.printStackTrace(System.out);
        }
        return null;
    }

    protected boolean credsMatch(String username, String password) {
        User user;
        hash(password);
        user = getUser(username);

        if(user == null)
            return false;
        else
            if(user.pw.equals(password))
                return true;
        return false;
    }

    //add updateUser method

    protected void createUser(String username, String password) {
        User user = new User();
        user.name = username;
        user.pw = password;
        storeUser(user);
        Log.v("QT","User stored");
    }

}
