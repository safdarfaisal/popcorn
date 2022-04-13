# Movie ticket booking system


## Use cases


- Display list of movies 
    - Display theaters where said movie can be seen
    - Book movie in specific theater
        - Select number of tickets
        - Select class of tickets
        - Proceed to pay screen
        - Show confirmation screen and give ticket id(?)

- Display the list of movies in a specific theater
- Cancel tickets that have been booked
- Display the list of theaters in the vicinity
- Order list of active movies based on rating
- Allow rating of movies(?)

## Database Design
- Required Data
    - Movies
        - Movie Id
        - Name
        - Rating
        - Synopsis
    - Theaters
        - Theater ID
        - Name
    - Locations
        - Name
    <!-- - Customers(If log-in Implemented)
        - Name
        - Address
        - Username(?)
        - -->
    - Ticket classes
        - Class ID
        - Hall ID
        - Price
        - Number of Seats
    - Seats
        - Seat ID
        - Booking Status
    - Screening Halls
        - Hall ID
        - Name 
    - Tickets
        - Ticket ID
        - Class
        - Seat
        

Relations Model

- Movie-Hall 
- Hall-Theater
- Classes-Hall
- Seat-Ticket 
- 





- SQL queries needed(?)

- Frontend
    - Web based(?)


