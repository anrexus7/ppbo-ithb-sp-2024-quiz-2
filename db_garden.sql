-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 04, 2024 at 04:11 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_garden`
--

-- --------------------------------------------------------

--
-- Table structure for table `members`
--

CREATE TABLE `members` (
  `idMember` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `kelamin` enum('PRIA','WANITA') NOT NULL,
  `foto` varchar(255) NOT NULL,
  `tanggalLahir` date DEFAULT NULL,
  `tanggalBuat` date DEFAULT NULL,
  `tanggalExp` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `members`
--

INSERT INTO `members` (`idMember`, `nama`, `kelamin`, `foto`, `tanggalLahir`, `tanggalBuat`, `tanggalExp`) VALUES
(1, 'jerryco axek', 'PRIA', 'C:\\Users\\hansl\\OneDrive\\Documents\\image.png', '2024-07-01', '2024-07-04', '2026-06-24'),
(2, 'ahahaha', 'PRIA', 'C:\\Users\\hansl\\OneDrive\\Documents\\image.png', '2024-07-01', '2024-07-04', '2026-06-24'),
(3, 'asa', 'PRIA', 'C:\\Users\\hansl\\OneDrive\\Documents\\image.png', '2024-07-01', '2024-07-05', '2026-06-25'),
(4, 'asder', 'WANITA', 'C:\\Users\\hansl\\OneDrive\\Documents\\image.png', '2024-07-01', '2024-07-04', '2026-06-24'),
(5, 'qwerty', 'WANITA', 'C:\\Users\\hansl\\OneDrive\\Documents\\image.png', '2024-07-01', '2024-07-04', '2026-06-24');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `members`
--
ALTER TABLE `members`
  ADD PRIMARY KEY (`idMember`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `members`
--
ALTER TABLE `members`
  MODIFY `idMember` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
