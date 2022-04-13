package main.java.popcorn;

import java.util.LinkedList;
import java.util.List;
import java.sql.*;
import java.util.UUID;
import java.util.Iterator;

public class PopcornDB {
    static final String DB_URL = "jdbc:mysql://localhost/popcorndb?useSSL=false";
    static final String USER = "root";
    static final String PASS = "Safdar12";
    static final String BASIC_LIST_MOVIES_QUERY = "select * from movies";
    static final String FULL_LIST_MOVIES_QUERY = "select * from theaterNamedList where theaterName = ? and Date = ?;";
    static final String THEATER_QUERY = "select * from theaterLocationList";
    static final String CLASS_QUERY = "select HallClassId, HallID, ClassName, TicketPrice from (HallClass join HallTime using(HallID)) join Schedule using(HallTimeId) where ScheduleID = ?";
    static final String AVBL_SEATS_QUERY = "select seatID from classSeats cs where seatID not IN (select seatID from scheduledSeats where ScheduleID = ?) and HallClassID = ?;";
    static final String ADD_TICKET_QUERY = "INSERT INTO tickets (TicketID, HallClassID, ScheduleID) VALUES (?, ?, ?);";
    static final String ADD_TICKET_ROW_QUERY = "Insert INTO ticketrows (TicketPrKey, SeatID) VALUES (?, ?);";
    static final String TICKET_PRKEY_QUERY = "select TicketPrKey from Tickets where TicketId = ?;";

    public List<Movie> listMovies() {
        List<Movie> listOfMovies = new LinkedList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getConstructor().newInstance();
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(BASIC_LIST_MOVIES_QUERY);
            // Extract data from result set
            while (rs.next()) {
                Movie newMovie = new Movie(rs.getInt("MovieID"), rs.getString("Name"), rs.getFloat("Rating"));
                listOfMovies.add(newMovie);
                // Retrieve by column name
                // System.out.print("ID: " + rs.getInt("MovieID"));
                // System.out.print(", Name: " + rs.getString("Name"));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listOfMovies;
    }

    public List<ScheduleInfo> listMovies(String theaterName, String date) {
        List<ScheduleInfo> listOfSchedules = new LinkedList<>();
        try {
            Date currentDate = Date.valueOf(date);
            Class.forName("com.mysql.cj.jdbc.Driver").getConstructor().newInstance();
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement(FULL_LIST_MOVIES_QUERY);
            stmt.setString(1, theaterName);
            stmt.setDate(2, currentDate);
            ResultSet rs = stmt.executeQuery();
            // Extract data from result set
            while (rs.next()) {
                ScheduleInfo newScheduleInfo = new ScheduleInfo(rs.getInt("scheduleID"), rs.getString("movieName"),
                        rs.getString("theaterName"), rs.getString("hallName"), rs.getTime("timing"),
                        rs.getDate("date"));
                listOfSchedules.add(newScheduleInfo);
                // Retrieve by column name
                // System.out.print("ID: " + rs.getInt("MovieID"));
                // System.out.print(", Name: " + rs.getString("Name"));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listOfSchedules;
    }
    
    public List<Theater> listTheaters() {
      List<Theater> listOfTheaters = new LinkedList<>();
      try {
          Class.forName("com.mysql.cj.jdbc.Driver").getConstructor().newInstance();
          Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
          Statement stmt = conn.createStatement();
          ResultSet rs = stmt.executeQuery(THEATER_QUERY);
          // Extract data from result set
          while (rs.next()) {
              Theater newTheater = new Theater(rs.getInt("theaterID"), rs.getString("TheaterName"), rs.getString("LocationName"));
              listOfTheaters.add(newTheater);
              // Retrieve by column name
              // System.out.print("ID: " + rs.getInt("MovieID"));
              // System.out.print(", Name: " + rs.getString("Name"));
          }
          conn.close();
      } catch (Exception e) {
          e.printStackTrace();
      }
      return listOfTheaters;
    }

    public List<HallClass> listPrices(int scheduleID){
      List<HallClass> listOfClasses = new LinkedList<>();
      try {
        Class.forName("com.mysql.cj.jdbc.Driver").getConstructor().newInstance();
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement stmt = conn.prepareStatement(CLASS_QUERY);
        stmt.setInt(1, scheduleID);
        ResultSet rs = stmt.executeQuery();
        // Extract data from result set
        while (rs.next()) {
            HallClass newClass = new HallClass(rs.getInt("HallClassID"), rs.getString("ClassName"),
                    rs.getInt("TicketPrice"));
            listOfClasses.add(newClass);
            // Retrieve by column name
            // System.out.print("ID: " + rs.getInt("MovieID"));
            // System.out.print(", Name: " + rs.getString("Name"));
        }
        conn.close();
      } catch (Exception e) {
          e.printStackTrace();
      }
    return listOfClasses;
    }
    public List<Integer> listAvailableSeats(int scheduleID, int hallClassID){
      List<Integer> listOfSeats = new LinkedList<>();
      try {
        Class.forName("com.mysql.cj.jdbc.Driver").getConstructor().newInstance();
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement stmt = conn.prepareStatement(AVBL_SEATS_QUERY);
        stmt.setInt(1, scheduleID);
        stmt.setInt(2, hallClassID);
        ResultSet rs = stmt.executeQuery();
        // Extract data from result set
        while (rs.next()) {
            listOfSeats.add(rs.getInt("SeatID"));
            // Retrieve by column name
            // System.out.print("ID: " + rs.getInt("MovieID"));
            // System.out.print(", Name: " + rs.getString("Name"));
        }
        conn.close();
      } catch (Exception e) {
          e.printStackTrace();
      }
    return listOfSeats;
    }

    public boolean ticketBookingTransaction(List<Integer> listOfSeatIDs, int hallClassID, int scheduleID){
      try{
        Class.forName("com.mysql.cj.jdbc.Driver").getConstructor().newInstance();
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        try {
          UUID uuid=UUID.randomUUID();
          System.out.println("Hello");
          PreparedStatement ticketstmt = conn.prepareStatement(ADD_TICKET_QUERY);
          PreparedStatement rowstmt = conn.prepareStatement(ADD_TICKET_ROW_QUERY);
          PreparedStatement ticketkeystmt = conn.prepareStatement(TICKET_PRKEY_QUERY);
          conn.setAutoCommit(false);
          ticketstmt.setString(1, uuid.toString());
          ticketstmt.setInt(2, hallClassID);
          ticketstmt.setInt(3, scheduleID);
          ticketstmt.executeUpdate();
          ticketkeystmt.setString(1, uuid.toString());
          ResultSet rs = ticketkeystmt.executeQuery();
          // only one value, Extract data from result set
          int ticketKey = 0;
          while (rs.next()) {
              ticketKey = rs.getInt("TicketPrKey");
              break;
          }
          if (ticketKey == 0) {
              conn.rollback();
              conn.close();
              return false;
          }
          Iterator<Integer> seatIDiterator = listOfSeatIDs.iterator();
          while(seatIDiterator.hasNext()){
            rowstmt.setInt(1, ticketKey);
            rowstmt.setInt(2, seatIDiterator.next());
            System.out.println("Hello");
            rowstmt.addBatch();
          }
          rowstmt.executeBatch();
          conn.commit();
          conn.setAutoCommit(true);
          conn.close();
          System.out.println("Hello");
          return true;
        } catch (Exception e) {
            e.printStackTrace();
            if(conn != null){
              try{
                conn.rollback();
              } catch (SQLException b){
                b.printStackTrace();
              }
            }
            return false;
        }    
      } catch (Exception e){
        e.printStackTrace();
        return false;
      }
    } 

}




/*

mysql -u root -pSafdar12 -h localhost --port 3306 popcorndb

public class FirstExample {
   static final String DB_URL = "jdbc:mysql://localhost/TUTORIALSPOINT";
   static final String USER = "guest";
   static final String PASS = "guest123";
   static final String QUERY = "SELECT id, first, last, age FROM Employees";
   static final String PREP_QUERY = "SELECT id, first, last, age FROM Employees WHERE age < ?";

   public static void main(String[] args) {
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(QUERY);) {
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            System.out.print("ID: " + rs.getInt("id"));
            System.out.print(", Age: " + rs.getInt("age"));
            System.out.print(", First: " + rs.getString("first"));
            System.out.println(", Last: " + rs.getString("last"));
         }
         conn.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }

      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         PreparedStatement stmt=con.prepareStatement(PREP_QUERY);
         stmt.setString(1, "20");
         ResultSet rs = stmt.executeQuery();) {
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            System.out.print("ID: " + rs.getInt("id"));
            System.out.print(", Age: " + rs.getInt("age"));
            System.out.print(", First: " + rs.getString("first"));
            System.out.println(", Last: " + rs.getString("last"));
         }
         conn.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public void updateCoffeeSales(HashMap<String, Integer> salesForWeek) throws SQLException {
    String updateString =
      "update COFFEES set SALES = ? where COF_NAME = ?";
    String updateStatement =
      "update COFFEES set TOTAL = TOTAL + ? where COF_NAME = ?";

    try (PreparedStatement updateSales = con.prepareStatement(updateString);
         PreparedStatement updateTotal = con.prepareStatement(updateStatement))
    
    {
      con.setAutoCommit(false);
      for (Map.Entry<String, Integer> e : salesForWeek.entrySet()) {
        updateSales.setInt(1, e.getValue().intValue());
        updateSales.setString(2, e.getKey());
        updateSales.executeUpdate();

        updateTotal.setInt(1, e.getValue().intValue());
        updateTotal.setString(2, e.getKey());
        updateTotal.executeUpdate();
        con.commit();
      }
    } catch (SQLException e) {
      JDBCTutorialUtilities.printSQLException(e);
      if (con != null) {
        try {
          System.err.print("Transaction is being rolled back");
          con.rollback();
        } catch (SQLException excep) {
          JDBCTutorialUtilities.printSQLException(excep);
        }
      }
    }
  }
}

*/
