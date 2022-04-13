package main.java.popcorn;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PopcornCLI {
    static void run() {
        Scanner selectorInput = new Scanner(System.in);
        System.out.println("Welcome to popcorn, What would you like to do?\n");
        System.out.println("Select from the following options.\n");
        System.out.println("1. Show list of movies\n");
        System.out.println("2. Book a movie on a specific date and theater\n");
        System.out.println("3. Cancel booked ticket\n");
        System.out.println("4. Cancel specific tickets within a booking\n");
        System.out.println("5. Exit\n");
       
        int selector = 0;
        if(selectorInput.hasNextInt()){
            selector = selectorInput.nextInt();
        }
        BookingAgent bookingAgent = BookingAgent.create();
        switch (selector) {
            case 1:
                displayMovies(bookingAgent.showList());
                break;
            case 2:
                displayTheaters(bookingAgent.showTheaters());
                String theaterName = "";
                String date = "2022-04-10";
                selectorInput.nextLine();
                if (selectorInput.hasNext()) {
                    theaterName = selectorInput.nextLine();
                }
                System.out.println("Enter the date you would like to watch the show on. (YYYY-MM-DD)\n");
                selectorInput.nextLine();
                if (selectorInput.hasNextLine()) {
                    date = selectorInput.nextLine();
                }
                displaySchedules(bookingAgent.showList(theaterName, date));
                break;
            case 3:
                
                break;
            case 4:
                
                break;
            case 5:
                
                break;            
            default:
                break;
        }
        selectorInput.close();
    }

    public static void displayMovies(List<Movie> listOfMovies) {
        if (listOfMovies == null) {
            return;
        }
        Iterator<Movie> movieIterator = listOfMovies.iterator();
        while (movieIterator.hasNext()) {
            Movie currentMovie = movieIterator.next();
            System.out.println("ID: " + currentMovie.ID + "\nName: " + currentMovie.name + "\nRating: "
                    + currentMovie.rating + "\n");
        }
    }

    public static void displayTheaters(List<Theater> listOfTheaters) {
        if (listOfTheaters == null) {
            return;
        }
        Iterator<Theater> theaterIterator = listOfTheaters.iterator();
        while (theaterIterator.hasNext()) {
            Theater currentTheater = theaterIterator.next();
            System.out.println("TheaterID: " + currentTheater.theaterID + "\nTheater: " + currentTheater.name + ", " + currentTheater.locationName + "\n");
        }
    }

    public static void displaySchedules(List<ScheduleInfo> listOfSchedules) {
        if (listOfSchedules == null) {
            return;
        }
        Iterator<ScheduleInfo> scheduleIterator = listOfSchedules.iterator();
        while (scheduleIterator.hasNext()) {
            ScheduleInfo currentScheduleInfo = scheduleIterator.next();
            System.out.println(
                    "ScheduleID: " + currentScheduleInfo.scheduleID + "\nMovie Name: " + currentScheduleInfo.movieName
                            + "\nTheater Name: " + currentScheduleInfo.theaterName + " - " + currentScheduleInfo.hallName
                            + "\nTiming: " + currentScheduleInfo.scheduleTiming + " "
                            + currentScheduleInfo.scheduleDate + "\n"
            );
        }
    }
}