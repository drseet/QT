package com.example.root.quiettime;

import java.util.HashMap;


/*
class that defines and manages quiet time sessions. qt_start and qt_end keep track of the
beginning and end of quiet time, respectively. qt_avg keeps track of the average length of each
quiet time sessions, and qt_sesh_num  the number of quiet time sessions that have occurred
*/
class QT extends StorageUtil {
    HashMap<String, Integer> qt_times;          //all quiettime session times stored within a HashMap
    int qt_start = 0;
    int qt_end = 0;
    int qt_avg = 0;
    int qt_sesh_num = 0;

}
