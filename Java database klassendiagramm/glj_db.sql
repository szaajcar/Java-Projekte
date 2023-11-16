-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 15. Nov 2023 um 22:11
-- Server-Version: 10.4.28-MariaDB
-- PHP-Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `glj_db`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `personen`
--

CREATE TABLE `personen` (
  `vorname` varchar(25) NOT NULL,
  `name` varchar(25) NOT NULL,
  `geschlecht` varchar(25) NOT NULL,
  `geburtsdatum` varchar(25) NOT NULL,
  `ahv` varchar(25) NOT NULL,
  `region` varchar(25) NOT NULL,
  `kinder` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Daten für Tabelle `personen`
--

INSERT INTO `personen` (`vorname`, `name`, `geschlecht`, `geburtsdatum`, `ahv`, `region`, `kinder`) VALUES
('John', 'Doe', 'Male', '1990-01-01', '123456789', 'City1', 2),
('Jane', 'Doe', 'Female', '1992-05-15', '987654321', 'City2', 1),
('Alice', 'Smith', 'Female', '1985-08-20', '456789012', 'Town1', 0),
('Bob', 'Johnson', 'Male', '1988-03-10', '789012345', 'Town2', 3),
('Eva', 'Miller', 'Female', '1995-11-25', '345678901', 'Village1', 2),
('Chris', 'Brown', 'Male', '1980-09-18', '678901234', 'Village2', 1),
('Sophia', 'Davis', 'Female', '1998-04-30', '234567890', 'City3', 4),
('David', 'Moore', 'Male', '1982-07-12', '567890123', 'City4', 0),
('Emma', 'White', 'Female', '1993-12-05', '890123456', 'Town3', 1),
('Michael', 'Taylor', 'Male', '1987-06-22', '012345678', 'Town4', 2),
('Olivia', 'Jones', 'Female', '1996-02-14', '543210987', 'Village3', 3),
('Daniel', 'Clark', 'Male', '1984-10-08', '321098765', 'Village4', 1),
('Ava', 'Hall', 'Female', '1991-03-28', '876543210', 'City5', 0),
('Matthew', 'Walker', 'Male', '1989-09-03', '109876543', 'City6', 2),
('Isabella', 'Hill', 'Female', '1997-07-19', '654321098', 'Town5', 1),
('Andrew', 'Baker', 'Male', '1983-01-15', '210987654', 'Town6', 4),
('Mia', 'Turner', 'Female', '1994-05-10', '987654321', 'Village5', 0),
('Christopher', 'Fisher', 'Male', '1986-11-02', '543210987', 'Village6', 3),
('Amelia', 'Adams', 'Female', '1999-08-24', '876543210', 'City7', 2),
('William', 'Young', 'Male', '1981-04-17', '012345678', 'City8', 1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
