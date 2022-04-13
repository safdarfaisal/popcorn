package main.java.popcorn;

import java.util.List;

public class BookingAgent {
    private PopcornDB dbConnection;

    private BookingAgent() {}

    private BookingAgent(PopcornDB conn) {
        dbConnection = conn;
    }

    public static BookingAgent create(){
        PopcornDB dbConnection = new PopcornDB();
        return new BookingAgent(dbConnection);
    }

    public List<Movie> showList() {
        return dbConnection.listMovies();
    }

    public List<ScheduleInfo> showList(String theaterName, String date) {
        return dbConnection.listMovies(theaterName, date);
    }

    public List<Theater> showTheaters() {
        return dbConnection.listTheaters();
    }
}

