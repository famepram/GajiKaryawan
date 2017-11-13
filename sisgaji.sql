-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 13 Nov 2017 pada 10.06
-- Versi Server: 10.1.9-MariaDB
-- PHP Version: 5.6.15

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
  `nip` varchar(20) NOT NULL,
  `fullname` varchar(64) NOT NULL,
  `start_work` date NOT NULL,
  `address` varchar(155) NOT NULL,
  `phone` varchar(30) NOT NULL,
  `dob` date NOT NULL,
  `gender` varchar(16) NOT NULL,
  `marital` varchar(24) NOT NULL,
  `status` varchar(24) NOT NULL,
  `dept` varchar(28) NOT NULL,
  `position` varchar(20) NOT NULL,
  `gaji_pokok` bigint(20) NOT NULL,
  `tnj_transport` bigint(20) NOT NULL,
  `tnj_lain` bigint(20) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `mskaryawan`
--

INSERT INTO `mskaryawan` (`id`, `nip`, `fullname`, `start_work`, `address`, `phone`, `dob`, `gender`, `marital`, `status`, `dept`, `position`, `gaji_pokok`, `tnj_transport`, `tnj_lain`, `created_at`, `updated_at`) VALUES
(1, '2145', 'Femmy Pramana', '2012-05-01', 'dasdasdsadsadsd', '081265478963', '1988-04-17', 'Pria', 'Single', 'Kontrak', 'Item 1', 'Manager', 10000000, 1000000, 0, '2017-11-13 14:57:31', '2017-11-13 14:57:31'),
(2, '7412', 'Brenda M. Hopkins', '2012-05-17', '4466 Apple Lane Grand Island, NE 68801', '308-991-0579', '1970-03-29', 'Wanita', 'Kawin', 'Kontrak', 'Item 2', 'Manager', 15000000, 1000000, 0, '2017-11-13 15:12:54', '2017-11-13 15:12:54');

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
