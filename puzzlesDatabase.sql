-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 30, 2023 at 04:51 AM
-- Server version: 5.7.36
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `puzzles`
--

-- --------------------------------------------------------

--
-- Table structure for table `eightqueensanswers`
--

DROP TABLE IF EXISTS `eightqueensanswers`;
CREATE TABLE IF NOT EXISTS `eightqueensanswers` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `uname` varchar(30) NOT NULL,
  `answer` varchar(150) NOT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `eightqueensanswers`
--

INSERT INTO `eightqueensanswers` (`aid`, `uid`, `uname`, `answer`) VALUES
(3, 1, 'Harith', '1 0 0 0 0 0 0 0 \n0 0 0 0 0 0 1 0 \n0 0 0 0 1 0 0 0 \n0 0 0 0 0 0 0 1 \n0 1 0 0 0 0 0 0 \n0 0 0 1 0 0 0 0 \n0 0 0 0 0 1 0 0 \n0 0 1 0 0 0 0 0'),
(7, 2, 'Chamod', '0 0 1 0 0 0 0 0 \n0 0 0 0 1 0 0 0 \n0 1 0 0 0 0 0 0 \n0 0 0 0 0 0 0 1 \n0 0 0 0 0 1 0 0 \n0 0 0 1 0 0 0 0 \n0 0 0 0 0 0 1 0 \n1 0 0 0 0 0 0 0'),
(5, 1, 'Harith', '1 0 0 0 0 0 0 0 \n0 0 0 0 0 1 0 0 \n0 0 0 0 0 0 0 1 \n0 0 1 0 0 0 0 0 \n0 0 0 0 0 0 1 0 \n0 0 0 1 0 0 0 0 \n0 1 0 0 0 0 0 0 \n0 0 0 0 1 0 0 0'),
(6, 2, 'Chamod', '0 0 0 0 0 0 1 0 \n0 0 0 0 1 0 0 0 \n0 0 1 0 0 0 0 0 \n1 0 0 0 0 0 0 0 \n0 0 0 0 0 1 0 0 \n0 0 0 0 0 0 0 1 \n0 1 0 0 0 0 0 0 \n0 0 0 1 0 0 0 0'),
(8, 2, 'Chamod', '0 0 0 0 1 0 0 0 \n0 1 0 0 0 0 0 0 \n0 0 0 1 0 0 0 0 \n0 0 0 0 0 0 1 0 \n0 0 1 0 0 0 0 0 \n0 0 0 0 0 0 0 1 \n0 0 0 0 0 1 0 0 \n1 0 0 0 0 0 0 0'),
(9, 2, 'Chamod', '0 0 0 1 0 0 0 0 \n0 1 0 0 0 0 0 0 \n0 0 0 0 0 0 1 0 \n0 0 1 0 0 0 0 0 \n0 0 0 0 0 1 0 0 \n0 0 0 0 0 0 0 1 \n0 0 0 0 1 0 0 0 \n1 0 0 0 0 0 0 0');

-- --------------------------------------------------------

--
-- Table structure for table `minimumconnectorsanswers`
--

DROP TABLE IF EXISTS `minimumconnectorsanswers`;
CREATE TABLE IF NOT EXISTS `minimumconnectorsanswers` (
  `caid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `uname` varchar(30) NOT NULL,
  `disBetCities` varchar(500) NOT NULL,
  `startPoint` int(11) NOT NULL,
  `uanswer` varchar(150) NOT NULL,
  `uTotDis` int(11) NOT NULL,
  PRIMARY KEY (`caid`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `minimumconnectorsanswers`
--

INSERT INTO `minimumconnectorsanswers` (`caid`, `uid`, `uname`, `disBetCities`, `startPoint`, `uanswer`, `uTotDis`) VALUES
(1, 1, 'Harith', '0 -> 1   :19 Km || 0 -> 2   :81 Km || 0 -> 3   :74 Km || 0 -> 4   :23 Km || 1 -> 0   :19 Km || 1 -> 2   :89 Km || 1 -> 3   :41 Km || 1 -> 4   :26 Km || 2 -> 0   :81 Km || 2 -> 1   :89 Km || 2 -> 3   :12 Km || 2 -> 4   :42 Km || 3 -> 0   :74 Km || 3 -> 1   :41 Km || 3 -> 2   :12 Km || 3 -> 4   :91 Km || 4 -> 0   :23 Km || 4 -> 1   :26 Km || 4 -> 2   :42 Km || 4 -> 3   :91 Km || ', 0, '[0, 1, 19, 3, 2, 12, 1, 3, 41, 0, 4, 23]', 95),
(2, 1, 'Harith', '0 -> 1   :83 Km || 0 -> 2   :26 Km || 0 -> 3   :60 Km || 0 -> 4   :82 Km || 1 -> 0   :83 Km || 1 -> 2   :83 Km || 1 -> 3   :76 Km || 1 -> 4   :42 Km || 2 -> 0   :26 Km || 2 -> 1   :83 Km || 2 -> 3   :47 Km || 2 -> 4   :20 Km || 3 -> 0   :60 Km || 3 -> 1   :76 Km || 3 -> 2   :47 Km || 3 -> 4   :50 Km || 4 -> 0   :82 Km || 4 -> 1   :42 Km || 4 -> 2   :20 Km || 4 -> 3   :50 Km || ', 4, '[4, 1, 42, 0, 2, 26, 2, 3, 47, 2, 4, 20]', 135),
(3, 1, 'Harith', '0 -> 1   :54 Km || 0 -> 2   :40 Km || 0 -> 3   :71 Km || 0 -> 4   :28 Km || 1 -> 0   :54 Km || 1 -> 2   :34 Km || 1 -> 3   :50 Km || 1 -> 4   :91 Km || 2 -> 0   :40 Km || 2 -> 1   :34 Km || 2 -> 3   :58 Km || 2 -> 4   :21 Km || 3 -> 0   :71 Km || 3 -> 1   :50 Km || 3 -> 2   :58 Km || 3 -> 4   :49 Km || 4 -> 0   :28 Km || 4 -> 1   :91 Km || 4 -> 2   :21 Km || 4 -> 3   :49 Km || ', 2, '[2, 1, 34, 4, 2, 21, 4, 3, 49, 0, 4, 28]', 132),
(4, 1, 'Harith', '0 -> 1   :60 Km || 0 -> 2   :37 Km || 0 -> 3   :79 Km || 0 -> 4   :55 Km || 1 -> 0   :60 Km || 1 -> 2   :43 Km || 1 -> 3   :13 Km || 1 -> 4   :93 Km || 2 -> 0   :37 Km || 2 -> 1   :43 Km || 2 -> 3   :26 Km || 2 -> 4   :88 Km || 3 -> 0   :79 Km || 3 -> 1   :13 Km || 3 -> 2   :26 Km || 3 -> 4   :100 Km || 4 -> 0   :55 Km || 4 -> 1   :93 Km || 4 -> 2   :88 Km || 4 -> 3   :100 Km || ', 3, '[3, 1, 13, 0, 2, 37, 2, 3, 26, 0, 4, 55]', 131),
(5, 2, 'Chamod', '0 -> 1   :39 Km || 0 -> 2   :85 Km || 0 -> 3   :23 Km || 0 -> 4   :40 Km || 1 -> 0   :39 Km || 1 -> 2   :47 Km || 1 -> 3   :25 Km || 1 -> 4   :69 Km || 2 -> 0   :85 Km || 2 -> 1   :47 Km || 2 -> 3   :52 Km || 2 -> 4   :80 Km || 3 -> 0   :23 Km || 3 -> 1   :25 Km || 3 -> 2   :52 Km || 3 -> 4   :85 Km || 4 -> 0   :40 Km || 4 -> 1   :69 Km || 4 -> 2   :80 Km || 4 -> 3   :85 Km || ', 3, '[3, 1, 25, 1, 2, 47, 0, 3, 23, 0, 4, 40]', 135);

-- --------------------------------------------------------

--
-- Table structure for table `shortestpathanswers`
--

DROP TABLE IF EXISTS `shortestpathanswers`;
CREATE TABLE IF NOT EXISTS `shortestpathanswers` (
  `said` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `uname` varchar(30) NOT NULL,
  `disBetCities` varchar(400) NOT NULL,
  `startPoint` varchar(10) NOT NULL,
  `uanswer` varchar(400) NOT NULL,
  PRIMARY KEY (`said`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `shortestpathanswers`
--

INSERT INTO `shortestpathanswers` (`said`, `uid`, `uname`, `disBetCities`, `startPoint`, `uanswer`) VALUES
(5, 2, 'Chamod', '[ A to B, 42,  A to I, 40,  B to I, 42,  B to C, 27,  C to D, 8,  I to D, 41,  D to E, 30,  H to E, 41,  E to F, 5,  H to F, 28,  F to G, 31,  H to G, 10,  I to H, 5]', 'H', '[H, A, 45, H, B, 47, H, C, 54, H, D, 46, H, E, 33, H, F, 28, H, G, 10, H, H, 0, H, I, 5]'),
(6, 2, 'Chamod', '[ A to B, 17,  A to I, 36,  B to I, 17,  B to C, 28,  C to D, 30,  I to D, 16,  D to E, 11,  H to E, 9,  E to F, 29,  H to F, 45,  F to G, 17,  H to G, 46,  I to H, 44]', 'C', '[C, A, 45, C, B, 28, C, C, 0, C, D, 30, C, E, 41, C, F, 70, C, G, 87, C, H, 50, C, I, 45]'),
(3, 3, 'Amasha', '[ A to B, 5,  A to I, 38,  B to I, 35,  B to C, 38,  C to D, 40,  I to D, 16,  D to E, 9,  H to E, 41,  E to F, 18,  H to F, 44,  F to G, 39,  H to G, 11,  I to H, 40]', 'E', '[E, A, 63, E, B, 60, E, C, 49, E, D, 9, E, E, 0, E, F, 18, E, G, 52, E, H, 41, E, I, 25]'),
(4, 2, 'Chamod', '[ A to B, 32,  A to I, 14,  B to I, 37,  B to C, 46,  C to D, 14,  I to D, 30,  D to E, 40,  H to E, 24,  E to F, 25,  H to F, 13,  F to G, 30,  H to G, 39,  I to H, 21]', 'C', '[C, A, 58, C, B, 46, C, C, 0, C, D, 14, C, E, 54, C, F, 78, C, G, 104, C, H, 65, C, I, 44]');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(30) NOT NULL,
  `uemail` varchar(30) NOT NULL,
  `upwd` varchar(30) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`uid`, `uname`, `uemail`, `upwd`) VALUES
(1, 'Harith', 'harith@gmail.com', 'harith123'),
(2, 'Chamod', 'chamod@gmail.com', 'chamod123'),
(3, 'Amasha', 'amasha@gmail.com', 'amasha123'),
(4, 'Visuri', 'visuri@gmail.com', 'visuri123');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
