CLI commands
Display theaters
    list theaters [locationid]

"SELECT * FROM THEATER WHERE locationID = 1;"

Display location
    list locations

"SELECT * FROM locations;"

Display list of movies
    list movies [locationid] [theaterid] [time range]

    select * from movies where Name = "It";
    create view movieList as select * from schedule s JOIN hallTime ht using(halltimeID);
    create view hallMovieList as select scheduleID,halls.theaterID, halls.HallName hallName, MovieID, Timing, Date from movieList join halls using(hallID);
    create view theaterMovieList as select  scheduleID, theater.Name theaterName, MovieID, hallName, Timing, Date from theater join hallMovieList using(theaterID);
    create view theaterNamedList as select scheduleID, movies.name movieName, theaterName, hallName, Timing, Date from movies join theaterMovieList using(movieID); 
    select * from theaterNamedList where theaterName = "Imax" and Date between "2022-04-10" and "2022-04-19" and Timing between "12:20" and "18:40" ;
    drop view hallMovieList;
    drop view theaterMovieList;
    drop view theaterNamedList;
    drop view movieList;
    
    list all schedule slots, ratings
            Book movie in specific theater
                book [movieid] [theaterid] [time]
                    :Select hall (autofill)
                        enter selected number
                    :Select class (show classes along with ticket prices)
                        enter selected class
                    :Select number of tickets
                        enter number of tickets
                    :Select seat
                        List free seat ids, enter the right seat id

                    create view scheduledSeats as select HallClassId, ScheduleID, SeatID from tickets join ticketrows using(ticketID);
                    select count(seatID) from classSeats cs where seatID not IN (select seatID from scheduledSeats);
                    select * from tickets where ticketID = value;
                    drop view scheduledSeats
                    
                    :Confirm and pay
                        Yes/No
                    show ticket id
                    INSERT INTO tickets (TicketID, HallClassID, ScheduleID) VALUES (<random-id>, <Hall-Class>, <Schedule>);
                    Insert INTO ticketrows (RowID, TicketID, SeatID) VALUES (RowID, <random-id>, Seat);
Cancel tickets that have been booked
    cancel [ticketid] [ticket-rowID]
    DELETE FROM ticketrows where rowID = <ticket-rowID> and ticketID = <ticketID>;
    
    DELETE FROM ticketrows where ticketID = <ticketID>;
    DELETE FROM tickets where ticketID = <ticketID>;