package com.example.root.quiettime;


/*
class that describes a user and the data that pertains to them:
name records the username and pw the password. qt is an instance
of the QT class that manages quiet times
*/
class User extends StorageUtil {
    String name;
    String pw;
    QT qt;

    User(){
        name = new String();
        pw = new String();
        qt = new QT();
    }



}




