package com.example.root.quiettime;

import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class Main extends User{

    MessageDigest md;

    protected boolean credsMatch(String username, String password) {
        User user;

        user = getUser(username);
        if(user == null)
            return false;
        else
            if(user.pw == password)
                return true;
        return false;
    }
    private String hash(String input) {

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

    protected void createUser(String username, String password) {
        //hash(pass)
    }

}
