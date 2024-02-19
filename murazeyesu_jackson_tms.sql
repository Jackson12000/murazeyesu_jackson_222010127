-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2024 at 11:57 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.1.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `murazeyesu_jackson_tms`
--

-- --------------------------------------------------------

--
-- Table structure for table `accommodation`
--

CREATE TABLE `accommodation` (
  `id` int(20) NOT NULL,
  `residental` varchar(220) NOT NULL,
  `tourist_email` varchar(220) NOT NULL,
  `gender` varchar(202) NOT NULL,
  `room` varchar(202) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `accommodation`
--

INSERT INTO `accommodation` (`id`, `residental`, `tourist_email`, `gender`, `room`) VALUES
(1, 'Rwanda', 'jackson@gmail.com', 'male', 'Flow One'),
(2, 'Rwanda', 'diogene@gmail.com', 'male', 'Flow Two'),
(3, 'Kenya', 'ruimba@gmail.com', 'female', 'Flow Two'),
(4, 'USA', 'j@gmail.com', 'male', 'Flow Two'),
(5, 'Uganda', 'mura\\@gmail.com', 'male', 'Flow One'),
(6, 'English', 'ing@gmail.com', 'female', 'Flow Two'),
(7, 'JAPAN', 'j@gmail.com', 'male', 'Flow Two');

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `id` int(20) NOT NULL,
  `first_name` varchar(220) DEFAULT NULL,
  `last_name` varchar(220) DEFAULT NULL,
  `email` varchar(202) DEFAULT NULL,
  `position` varchar(202) NOT NULL,
  `phone_number` varchar(220) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`id`, `first_name`, `last_name`, `email`, `position`, `phone_number`) VALUES
(1, 'murazeyesu ', 'jackson', 'j@gmail.com', 'programmer', '078654321'),
(2, 'Mahoro ', 'ENOCK', 'j@gmail.com', 'programmer', '078654321'),
(3, 'STIZZO', 'KIGALI', 'stizzo@gmail.com', 'programmer', '0789654421'),
(4, 'VANNESSA', 'Mucyo', 'mucyo@gmail.com', 'programmer', '0789654321');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `id` int(20) NOT NULL,
  `payment_method` varchar(220) DEFAULT NULL,
  `payment_amount` varchar(220) DEFAULT NULL,
  `payment_date` varchar(202) DEFAULT NULL,
  `tourist_email` varchar(202) DEFAULT NULL,
  `tourist_name` varchar(220) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`id`, `payment_method`, `payment_amount`, `payment_date`, `tourist_email`, `tourist_name`) VALUES
(1, 'Aitel money', '2000000', '15/06/2024', 'rugwirogerrard@gmail.com', 'Rugwiro Gerrard');

-- --------------------------------------------------------

--
-- Table structure for table `siginup`
--

CREATE TABLE `siginup` (
  `id` int(20) NOT NULL,
  `first_name` varchar(220) NOT NULL,
  `last_name` varchar(220) NOT NULL,
  `user_name` varchar(202) NOT NULL,
  `pass_word` varchar(202) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `siginup`
--

INSERT INTO `siginup` (`id`, `first_name`, `last_name`, `user_name`, `pass_word`) VALUES
(1, 'murazeyes', 'jackson', 'jackson', '1234567'),
(2, '', '', '', ''),
(3, '', '', '', ''),
(4, 'BONHEUR', 'KWIZERA', 'KDOT', '12345678');

-- --------------------------------------------------------

--
-- Table structure for table `tourist`
--

CREATE TABLE `tourist` (
  `tourist_id` int(11) NOT NULL,
  `first_name` varchar(220) NOT NULL,
  `last_name` varchar(220) NOT NULL,
  `email` varchar(202) NOT NULL,
  `phone` varchar(202) NOT NULL,
  `nationality` varchar(220) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tourist`
--

INSERT INTO `tourist` (`tourist_id`, `first_name`, `last_name`, `email`, `phone`, `nationality`) VALUES
(1, 'diogene', 'man', 'man@gmail.com', '0789654321', 'Rwanda'),
(50, 'Murazeyesu ', 'Jackson', 'jackson@gmail.com', '0789654321', 'Rwanda'),
(246, 'kwizera', 'wenyewe', 'bhbhbchg@gmail.com', '0786365465', 'rwandan'),
(247, 'ENOCK', 'MAHORO', 'mahoro@gmail.com', '0789654321', 'CANADA');

-- --------------------------------------------------------

--
-- Table structure for table `transport`
--

CREATE TABLE `transport` (
  `id` int(20) NOT NULL,
  `tourist_telephone` varchar(220) DEFAULT NULL,
  `tourist_email` varchar(220) DEFAULT NULL,
  `tourist_residental` varchar(202) DEFAULT NULL,
  `transport_comyany_name` varchar(202) DEFAULT NULL,
  `time_arrival` varchar(220) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transport`
--

INSERT INTO `transport` (`id`, `tourist_telephone`, `tourist_email`, `tourist_residental`, `transport_comyany_name`, `time_arrival`) VALUES
(1, '078654321', 'jackson@gmail.com', 'Kenya', 'HORIZON', '4:00PM'),
(2, '0987654321', 'wwwwwwwwwwwwwwwwwwwww', 'USA', 'HORIZON', '12:00PM');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accommodation`
--
ALTER TABLE `accommodation`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `siginup`
--
ALTER TABLE `siginup`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tourist`
--
ALTER TABLE `tourist`
  ADD PRIMARY KEY (`tourist_id`);

--
-- Indexes for table `transport`
--
ALTER TABLE `transport`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `accommodation`
--
ALTER TABLE `accommodation`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `employees`
--
ALTER TABLE `employees`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `siginup`
--
ALTER TABLE `siginup`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tourist`
--
ALTER TABLE `tourist`
  MODIFY `tourist_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=248;

--
-- AUTO_INCREMENT for table `transport`
--
ALTER TABLE `transport`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
