-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 23 Cze 2020, 21:10
-- Wersja serwera: 10.4.11-MariaDB
-- Wersja PHP: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `portal_randkowy`
--

--
-- Zrzut danych tabeli `kategorie`
--

INSERT INTO `kategorie` (`id`, `nazwa`) VALUES
(1, 'Gotowanie'),
(2, 'Sport'),
(3, 'Life style'),
(4, 'Sztuka'),
(5, 'Nauka');

--
-- Zrzut danych tabeli `pod_kategorie`
--

INSERT INTO `pod_kategorie` (`id`, `nazwa`, `kategorie_id`) VALUES
(2, 'Jazda na rowerze', 2),
(1, 'Sporty zespołowe', 2),
(3, 'Sporty zimowe', 2),
(4, 'Sporty wysiłkowe', 2),
(5, 'Taniec', 2),
(6, 'Makijaż', 3),
(7, 'Cukiernictwo', 1),
(8, 'Pieczenie', 1),
(9, 'Gotowanie', 1),
(10, 'Sprzątanie', 3),
(11, 'Moda', 3),
(12, 'Majsterkowanie', 3),
(13, 'Samochody', 3),
(14, 'Książki', 3),
(15, 'Fotografia', 4),
(16, 'Muzyka', 4),
(17, 'Śpiewanie', 4),
(18, 'Grafiki komputerowe', 4),
(19, 'Nauki przyrodnicze', 5),
(20, 'Języki obce', 5),
(21, 'Nauki społeczne', 5),
(22, 'Technologie', 5),
(23, 'Nauki medyczne', 5),
(24, 'Nauki humanistyczne', 5),
(25, 'Inne w Gotowaniu', 1),
(26, 'Inne w Sporcie', 2),
(27, 'Inne w Life style', 3),
(28, 'Inne w Sztuka', 4),
(29, 'Inne w Nauce', 5);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
