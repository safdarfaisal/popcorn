package main.java.popcorn;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.LinkedList;

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
                int scheduleID = 0;
                int hallClassID = 0;
                selectorInput.nextLine();
                if (selectorInput.hasNext()) {
                    theaterName = selectorInput.nextLine();
                }
                System.out.println("Enter the date you would like to watch the show on. (YYYY-MM-DD)\n");
                if (selectorInput.hasNextLine()) {
                    date = selectorInput.nextLine();
                }
                displaySchedules(bookingAgent.showList(theaterName, date));
                System.out.println("Enter scheduleID for the movie you would like to watch\n");
                if(selectorInput.hasNextInt()){
                    scheduleID = selectorInput.nextInt();
                }
                displayPrices(bookingAgent.showClassPrice(scheduleID));
                System.out.println("Select a ClassID for which class you would like to buy a ticket. \n");
                if(selectorInput.hasNextInt()){
                    hallClassID = selectorInput.nextInt();
                }
                displaySeats(bookingAgent.showAvailableSeats(scheduleID, hallClassID));
                System.out.println("Enter all seats you would like to book (using space separated values).");
                List<Integer> seatList = new LinkedList<>();
                while(selectorInput.hasNextInt()){
                    seatList.add(selectorInput.nextInt());
                }    
                bookingAgent.bookTickets(seatList, hallClassID, scheduleID);
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

    public static void displayPrices(List<HallClass> listOfClasses){
        if (listOfClasses == null) {
            return;
        }
        Iterator<HallClass> classIterator = listOfClasses.iterator();
        while (classIterator.hasNext()) {
            HallClass currentClass = classIterator.next();
            System.out.println(
                    "ClassID: " + currentClass.hallClassID + "\nHall Name: " + currentClass.className
                            + "\nTicket Price: " + currentClass.price
            );
        }
    }
    public static void displaySeats(List<Integer> listOfSeats){
        if(listOfSeats == null){
            return;
        }
        Iterator<Integer> seatIterator = listOfSeats.iterator();
        System.out.println("Seat IDs for available seats\n");
        while (seatIterator.hasNext()) {
            Integer currentSeat = seatIterator.next();
            System.out.print(
                currentSeat + " "
            );
        }
        System.out.println("");

    }
}