package com.example.root.quiettime;


import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class Main extends User{

    MessageDigest md;
    String username;

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

    //keep track of current user for all children of main class
    protected void currentUser(String currentUser){
        this.username = currentUser;
    }

    protected void updateUser(User userUpdate) {
        if(userUpdate == null){
            Log.v("QT", "ERROR: Userfile not found!");
        }
        if(userFound(userUpdate.name))
            deleteUser(userUpdate.name);
        createUser(userUpdate.name, userUpdate.pw);
        Log.v("QT", "Userfile successfully updated");
    }

    protected void createUser(String username, String password) {
        User user = new User();
        user.name = username;
        user.pw = password;
        storeUser(user);
    }

    public void alert() {
        try {
            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
            r.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //storeQTdata w/ updateUser
    //fetch qt data and updateUser

}
