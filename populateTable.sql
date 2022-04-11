DELETE FROM classseats;
DELETE FROM hallclass;
DELETE FROM halls;
DELETE FROM halltime;
DELETE FROM locations;
DELETE FROM movies;
DELETE FROM movieschedule;
DELETE FROM schedule;
DELETE FROM theater;
DELETE FROM ticketrows;
DELETE FROM tickets;
--
INSERT INTO Locations (LocationID, Name) VALUES (1, 'Pilani');
INSERT INTO Locations (LocationID, Name) VALUES (2, 'Delhi');
INSERT INTO Locations (LocationID, Name) VALUES (3, 'Kochi');
INSERT INTO Locations (LocationID, Name) VALUES (4, 'Jaipur');
--
INSERT INTO Movies (MovieID, Name, Rating) VALUES (1, 'The Shawnshank Redemption', 9.5);
INSERT INTO Movies (MovieID, Name, Rating) VALUES (2, 'The Godfather', 9.8);
INSERT INTO Movies (MovieID, Name, Rating) VALUES (3, 'Sholay', 8.8);
INSERT INTO Movies (MovieID, Name, Rating) VALUES (4, 'Lord of the Rings: Return of the Kings', 8.7);
INSERT INTO Movies (MovieID, Name, Rating) VALUES (5, 'The Hobbit', 7.9);
INSERT INTO Movies (MovieID, Name, Rating) VALUES (6, 'Dark Knight Returns', 8.6);
INSERT INTO Movies (MovieID, Name, Rating) VALUES (7, 'Dracula', 8.0);
INSERT INTO Movies (MovieID, Name, Rating) VALUES (8, 'It', 8.4);
--
INSERT INTO Theater (TheaterID, Name, LocationID) VALUES (1, 'Imax', 1);
INSERT INTO Theater (TheaterID, Name, LocationID) VALUES (2, 'Saritha', 3);
INSERT INTO theater (TheaterID, Name, LocationID) VALUES (3, 'Uphaar', 2);
INSERT INTO theater (TheaterID, Name, LocationID) VALUES (4, 'Rex', 3);
INSERT INTO theater (TheaterID, Name, LocationID) VALUES (5, 'Kohinoor', 3);
INSERT INTO theater (TheaterID, Name, LocationID) VALUES (6, 'Carnival', 3);
INSERT INTO theater (TheaterID, Name, LocationID) VALUES (7, 'Regal', 4);
INSERT INTO theater (TheaterID, Name, LocationID) VALUES (8, 'Minerva', 2);
--
INSERT INTO Halls (HallID, TheaterID, HallName) VALUES (1, 1, 'A1');
INSERT INTO Halls (HallID, TheaterID, HallName) VALUES (2, 1, 'A2');
INSERT INTO Halls (HallID, TheaterID, HallName) VALUES (3, 1, 'A3');
INSERT INTO Halls (HallID, TheaterID, HallName) VALUES (4, 1, 'A4');
INSERT INTO Halls (HallID, TheaterID, HallName) VALUES (5, 1, 'A5');
INSERT INTO Halls (HallID, TheaterID, HallName) VALUES (6, 2, 'Main');
INSERT INTO Halls (HallID, TheaterID, HallName) VALUES (7, 3, 'Jasmine');
INSERT INTO Halls (HallID, TheaterID, HallName) VALUES (8, 3, 'Rose');
INSERT INTO Halls (HallID, TheaterID, HallName) VALUES (9, 4, 'Ruby');
INSERT INTO Halls (HallID, TheaterID, HallName) VALUES (10, 4, 'Emerald');
INSERT INTO Halls (HallID, TheaterID, HallName) VALUES (11, 5, 'Sagar');
INSERT INTO Halls (HallID, TheaterID, HallName) VALUES (12, 5, 'Narmada');
INSERT INTO Halls (HallID, TheaterID, HallName) VALUES (13, 5, 'Ganga');
INSERT INTO Halls (HallID, TheaterID, HallName) VALUES (14, 5, 'Yamuna');
INSERT INTO Halls (HallID, TheaterID, HallName) VALUES (15, 6, 'Shah');
INSERT INTO Halls (HallID, TheaterID, HallName) VALUES (16, 6, 'Noor');
INSERT INTO Halls (HallID, TheaterID, HallName) VALUES (17, 6, 'Ashoka');
INSERT INTO Halls (HallID, TheaterID, HallName) VALUES (18, 7, 'Mumtaz');
INSERT INTO Halls (HallID, TheaterID, HallName) VALUES (19, 7, 'Zeb');
INSERT INTO Halls (HallID, TheaterID, HallName) VALUES (20, 7, 'Raj');
INSERT INTO Halls (HallID, TheaterID, HallName) VALUES (21, 7, 'Princess');
INSERT INTO Halls (HallID, TheaterID, HallName) VALUES (22, 8, 'Apollo');
INSERT INTO Halls (HallID, TheaterID, HallName) VALUES (23, 8, 'Calliope');
INSERT INTO Halls (HallID, TheaterID, HallName) VALUES (24, 8, 'Artemis');

INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (1, 1, 'Silver', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (2, 1, 'Gold', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (3, 1, 'Platinum', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (4, 2, 'Silver', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (5, 2, 'Gold', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (6, 2, 'Platinum', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (7, 2, 'VIP', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (8, 3, 'Silver', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (9, 3, 'Gold', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (10, 3, 'Platinum', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (11, 3, 'VIP', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (12, 4, 'Silver', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (13, 4, 'Gold', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (14, 4, 'Platinum', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (15, 4, 'VIP', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (16, 5, 'Silver', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (17, 5, 'Gold', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (18, 5, 'Platinum', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (19, 5, 'VIP', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (20, 5, 'Special', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (21, 6, 'AS1', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (22, 7, 'BS21', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (23, 8, 'X12', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (24, 8, 'Y15', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (25, 9, 'TR24', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (26, 9, 'Balcony', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (27, 10, 'Marco', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (28, 10, 'Columbus', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (29, 11, 'Special', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (30, 12, 'Collective', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (31, 13, 'Polo', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (32, 13, 'Definitive', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (33, 13, 'Fizz', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (34, 14, 'France', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (35, 14, 'Bolivia', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (36, 15, 'C1', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (37, 15, 'C2', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (38, 16, 'C1', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (39, 16, 'C2', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (40, 16, 'C3', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (41, 17, 'D1', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (42, 18, 'D1', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (43, 19, 'D1', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (44, 20, 'D1', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (45, 21, 'D1', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (43, 21, 'D2', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (44, 22, 'D1', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (45, 23, 'D1', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (46, 23, 'D2', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (47, 24, 'D1', 100);
INSERT INTO HallClass (HallClassID, HallID, ClassName, TicketPrice) VALUES (48, 24, 'D2', 100);