-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 10 Nov 2017 pada 00.58
-- Versi Server: 10.1.13-MariaDB
-- PHP Version: 5.6.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sisgaji`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `mskaryawan`
--

CREATE TABLE `mskaryawan` (
  `id` int(11) NOT NULL,
  `fullname` varchar(64) NOT NULL,
  `start_work` date NOT NULL,
  `address` varchar(155) NOT NULL,
  `phone` varchar(30) NOT NULL,
  `dob` date NOT NULL,
  `gender` tinyint(4) NOT NULL,
  `marital` tinyint(4) NOT NULL,
  `status` tinyint(4) NOT NULL,
  `dept` smallint(6) NOT NULL,
  `position` smallint(6) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `mskaryawan`
--

INSERT INTO `mskaryawan` (`id`, `fullname`, `start_work`, `address`, `phone`, `dob`, `gender`, `marital`, `status`, `dept`, `position`, `created_at`, `updated_at`) VALUES
(1, 'Lynne G. Fong', '2014-11-01', '1900 Brookview Drive\r\nBeaumont, TX 77701', '640-18-0254', '1955-09-15', 2, 2, 1, 1, 1, '2017-11-09 00:00:00', '2017-11-09 00:00:00'),
(2, 'Paula G. Sweatman', '2015-06-09', '4647 Adamsville Road\r\nMcallen, TX 78501', '956-767-7568', '1950-09-07', 2, 2, 1, 2, 2, '2017-11-09 00:00:00', '2017-11-09 00:00:00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mskaryawan`
--
ALTER TABLE `mskaryawan`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `mskaryawan`
--
ALTER TABLE `mskaryawan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
