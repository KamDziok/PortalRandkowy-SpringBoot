-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 27 Cze 2020, 17:44
-- Wersja serwera: 10.4.13-MariaDB
-- Wersja PHP: 7.4.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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

--
-- Zrzut danych tabeli `uzytkownicy`
--

INSERT INTO `uzytkownicy` (`id`, `haslo`, `mail`, `miejscowosc`, `nick`, `opis`, `plec`, `uprawnienia`) VALUES
(1, 'adam', 'adam@adam.pl', 'adamów', 'adam', 'Jestem kucharzem, chętnie poznam osobę, która podziela moje pasje.', b'1', 0),
(2, 'ada', 'ada@ada.pl', 'adamów', 'ada', 'Studiuje filologię rosyjską, lubię podróżować i odkrywać nowe rzeczy.', b'0', 0),
(3, 'renatka', 'renatka@renatka.pl', 'rzeszów', 'renatka', 'Zaproś mnie do znajomych, a wszystkiego się dowiesz :)', b'0', 0),
(4, 'rudolf', 'rudolf@rudolf.pl', 'kołobrzeg', 'rudolf', 'Cześć, jestem rudolf, ale wcale nie mam czerwonego nosa, napisz do mnie, a może zaiskrzy.', b'1', 0),
(5, 'Aneta', 'aneta@anetka.pl', 'aleksandrów pomorski', 'aneta', 'Jestem skryta, lubię sporty motorowe i szybkie samochody.', b'0', 0),
(6, 'admin', 'admin@admin.pl', 'leżajsk', 'admin', 'Administrator portalu', b'1', 1),
(7, 'kamil', 'Kamil@kamil.pl', 'wrocław', 'Kamil', 'Jestem piękny, bogaty i mam własny helikopter.', b'1', 0),
(8, 'łukasz', 'Łukasz@Łukasz.pl', 'kalalalów', 'Łukasz', 'W moim wniętrzu drzemie dusza artysty.', b'1', 0),
(9, 'rodzinek', 'rodzinek@ooo.pl', 'pacanów', 'Rodzineczek', 'Mogę zostać Twoim rodzyneczkiem, napisz do mnie!', b'0', 0),
(10, 'lolita', 'Lolita@lolololo.pl', 'leżajsk', 'lolita', 'Jestem Lolitka i uwielbiam sztukę', b'0', 0),
(11, 'nadia', 'Nadia@op.pl', 'pacantów', 'Nadia', 'Jestem perkusistą w rockowym zespole, wbijaj jak lubisz ostre granie!', b'0', 0);

--
-- Zrzut danych tabeli `uzytkownicy_pod_kategorie`
--

INSERT INTO `uzytkownicy_pod_kategorie` (`pod_kategodie_id`, `uzytkownika_id`) VALUES
(1, 7),
(1, 8),
(1, 9),
(2, 27),
(2, 15),
(2, 20),
(3, 11),
(3, 14),
(3, 16),
(4, 26),
(4, 2),
(4, 4),
(5, 27),
(5, 2),
(5, 13),
(6, 1),
(6, 2),
(6, 3),
(7, 27),
(7, 28),
(7, 29),
(8, 28),
(8, 11),
(8, 16),
(9, 6),
(9, 5),
(9, 11),
(10, 28),
(10, 16),
(10, 15),
(11, 17),
(11, 16),
(11, 28);

--
-- Zrzut danych tabeli `wiadomosci`
--

INSERT INTO `wiadomosci` (`id`, `data_nadeslania`, `tresc`, `nadawca_id`, `odbiorca_id`) VALUES
(1, '2020-06-27 17:02:34', 'Hej, Łukasz', 2, 8),
(2, '2020-06-27 17:02:40', 'jak się masz?', 2, 8),
(3, '2020-06-27 17:05:56', 'Hej, świetnie! A ty?', 8, 2);

--
-- Zrzut danych tabeli `zdjecia`
--

INSERT INTO `zdjecia` (`id`, `data_dodania`, `link`, `opis`, `status`, `tytul`, `uzytkownik_id`) VALUES
(1, '2020-06-27 16:40:46', 'http://localhost:8000/img/1/27062020164046.png', 'Jestem przystojny?', 0, 'Moje zdjęcie do dowodu', 8),
(2, '2020-06-27 16:42:06', '', 'Dzisiaj była piękna pogoda byłem na rybach i słuchałem szumu jeziora.', 1, 'Ryby', 8),
(4, '2020-06-27 16:46:25', 'http://localhost:8000/img/1/27062020164625.png', '', 0, 'Moja profilówka', 1),
(10, '2020-06-27 16:52:12', 'http://localhost:8000/img/1/27062020165212.jpeg', '', 0, '', 3),
(7, '2020-06-27 16:50:03', 'http://localhost:8000/img/1/27062020165003.jpeg', '', 0, 'W pracy', 2),
(12, '2020-06-27 16:53:15', 'http://localhost:8000/img/1/27062020165315.jpeg', '', 0, '', 4),
(14, '2020-06-27 16:54:35', 'http://localhost:8000/img/1/27062020165435.jpeg', 'Takie tam pod murkiem', 0, '', 5),
(16, '2020-06-27 16:57:42', 'http://localhost:8000/img/1/27062020165742.jpeg', '', 0, '', 9);

--
-- Zrzut danych tabeli `zgloszenie`
--

INSERT INTO `zgloszenie` (`id`, `data_zgloszenia`, `tresc`, `uzytkownik_zglaszajacy_id`, `uzytkownik_zglaszany_id`) VALUES
(1, '2020-06-27 17:22:21', 'Bardzo złe zachowanie użytkownika!', 8, 2),
(2, '2020-06-27 17:23:27', 'Bardzo wulgarny użytkownik!', 1, 9);

--
-- Zrzut danych tabeli `zwiazek`
--

INSERT INTO `zwiazek` (`id`, `zgoda_blokada`, `uzytkownika_id`, `uzytkownikb_id`) VALUES
(1, 2, 8, 2),
(2, 3, 8, 5);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
