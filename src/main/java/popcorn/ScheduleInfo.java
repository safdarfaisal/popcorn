package main.java.popcorn;

import java.sql.Date;
import java.sql.Time;

public class ScheduleInfo {
    int scheduleID;
    String movieName;
    String theaterName;
    String hallName;
    Time scheduleTiming; 
    Date scheduleDate;

    public ScheduleInfo(int id, String movieName, String theaterName, String hallName, Time timing, Date date) {
        scheduleID = id;
        this.movieName = movieName;
        this.theaterName = theaterName;
        this.hallName = hallName;
        scheduleTiming = timing;
        scheduleDate = date;
    }
}
