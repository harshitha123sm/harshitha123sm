CREATE DATABASE MetroDB;
USE MetroDB;
CREATE TABLE Stations (
    station_id INT PRIMARY KEY,
    station_name VARCHAR(50),
    location VARCHAR(50),
    platforms INT
);
CREATE TABLE Metro_Trains (
    train_id INT PRIMARY KEY,
    train_name VARCHAR(50),
    capacity INT,
    station_id INT,
    FOREIGN KEY (station_id) REFERENCES Stations(station_id)
);
ALTER TABLE Stations
ADD opening_year INT;
RENAME TABLE Metro_Trains TO Trains;
INSERT INTO Stations VALUES
(1, 'Central Station', 'Downtown', 4, 2005),
(2, 'City Park', 'North Zone', 3, 2010),
(3, 'Tech Park', 'IT Corridor', 5, 2018),
(4, 'Airport Station', 'Airport Road', 2, 2020),
(5, 'Market Square', 'City Center', 4, 2012);
INSERT INTO Trains VALUES
(101, 'Metro Express', 1000, 1),
(102, 'City Rider', 900, 2),
(103, 'Airport Link', 800, 4);
UPDATE Trains
SET capacity = 1100
WHERE train_id = 101;
DELETE FROM Stations
WHERE station_id = 5;
SELECT * FROM Stations;
SELECT * FROM Trains;
CREATE USER 'metro_staff'@'localhost' IDENTIFIED BY 'password123';
GRANT SELECT ON MetroDB.Stations TO 'metro_staff'@'localhost';
GRANT INSERT ON MetroDB.Trains TO 'metro_staff'@'localhost';
REVOKE INSERT ON MetroDB.Trains FROM 'metro_staff'@'localhost';