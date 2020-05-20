-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 20, 2020 at 10:03 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Database: `eva`
--

-- --------------------------------------------------------

--
-- Table structure for table `bookings`
--

CREATE TABLE `bookings` (
  `id` int(11) NOT NULL,
  `event_fk` varchar(70) NOT NULL,
  `user_fk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bookings`
--

INSERT INTO `bookings` (`id`, `event_fk`, `user_fk`) VALUES
(46, 'e2360bbf-54f5-4416-8acf-82d09b9d1ff0', 1),
(47, 'f7148ee4-a0ad-4782-aa77-e8ef3cc54290', 1),
(48, 'ccab8b3d-f24c-446e-b39d-d27fb878628d', 1),
(49, '72b71ce5-ec95-4e90-b93f-e5ef291b3c6f', 1),
(52, 'c697776c-2ca0-4552-9caf-360fbf963a32', 1),
(53, 'ccab8b3d-f24c-446e-b39d-d27fb878628d', 1521715),
(54, 'e2360bbf-54f5-4416-8acf-82d09b9d1ff0', 1521715),
(55, '72b71ce5-ec95-4e90-b93f-e5ef291b3c6f', 1964364),
(56, 'c697776c-2ca0-4552-9caf-360fbf963a32', 1964364),
(58, 'f7148ee4-a0ad-4782-aa77-e8ef3cc54290', 1964364);

-- --------------------------------------------------------

--
-- Table structure for table `events`
--

CREATE TABLE `events` (
  `uuid` varchar(70) NOT NULL,
  `location` varchar(300) NOT NULL,
  `title` varchar(120) NOT NULL,
  `description` text NOT NULL,
  `date` varchar(60) NOT NULL,
  `time` varchar(60) NOT NULL,
  `placeLimitation` int(11) NOT NULL,
  `user_fk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `events`
--

INSERT INTO `events` (`uuid`, `location`, `title`, `description`, `date`, `time`, `placeLimitation`, `user_fk`) VALUES
('72b71ce5-ec95-4e90-b93f-e5ef291b3c6f', 'A004', 'What is Esport?', 'This presentation is about electronic sports, the different benefits of being part of the gaming community followed by a Q&A. Anyone is welcome to join, regardless of their level of involement in gaming. ', '2020-06-12', '16:00', 50, 1185037),
('b2f1732a-349c-4e9f-a815-bab54809dd0c', 'A004', 'Football history presentation', 'This presentation will be about the history of football, specifically on why did it became such a famous sport.', '2020-05-22', '15:00', 60, 1185037),
('b525b470-fa5a-49e1-9e10-553d1e9d05ed', 'G101', 'Spanish Language for Beginners', 'Hello my name is Sofia and I am aspiring to be a Spanish language teacher. During this lecture I will do my best to introduce you to some basic Spanish and hopefully encourage you to continue learning it. ', '2020-06-19', '18:00', 70, 1521715),
('c697776c-2ca0-4552-9caf-360fbf963a32', 'A004', 'CV writing lesson', 'Hello my name is Ewa. I have been working in the HR department for more than 10 years and I want to talk about some of the common mistakes that people make in writing their CVs, I will talk about some techniques to improve yours and end the session with a Q&A. Please come, everyone is welcome!', '2020-06-02', '17:00', 50, 1521715),
('ccab8b3d-f24c-446e-b39d-d27fb878628d', 'J200', 'Book discussion group', 'During this session we encourage everyone to bring their favourite book and talk a little bit about it to encourage others to read it. \n', '2020-05-15', '16:00', 25, 7071425),
('e2360bbf-54f5-4416-8acf-82d09b9d1ff0', 'J105', 'Chinese culture club', 'In this club we can share/learn/talk about the chinese culture. Everyone is welcome.', '2020-05-20', '18:00', 20, 7071425),
('f7148ee4-a0ad-4782-aa77-e8ef3cc54290', 'D104', 'Programming Introduction', 'This session will be a brief introduction to programming. It will mostly targetted at people that have no programming experience whatsover and it will cover some basic programming concepts using multiple different programming languages as examples.', '2020-05-25', '16:00', 40, 1963913);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(8) NOT NULL,
  `first_name` varchar(60) NOT NULL,
  `last_name` varchar(60) NOT NULL,
  `gender` varchar(60) NOT NULL,
  `address_line` varchar(120) NOT NULL,
  `town` varchar(120) NOT NULL,
  `county` varchar(120) NOT NULL,
  `postcode` varchar(120) NOT NULL,
  `dob` varchar(120) NOT NULL,
  `isOrganizer` tinyint(1) NOT NULL,
  `isAdmin` tinyint(1) NOT NULL,
  `hashed_password` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `first_name`, `last_name`, `gender`, `address_line`, `town`, `county`, `postcode`, `dob`, `isOrganizer`, `isAdmin`, `hashed_password`) VALUES
(1, 'Administrator', '1', 'Other', 'no address', 'no town', 'Bedfordshire', 'no post code', '2020-05-20', 0, 1, '$2a$10$ST/DHEiNPb4Vwx1wstzOMuIsCw8/h6/aMP85W2OjdzMCXU7vm5tx6'),
(1003852, 'Vanessa ', 'Zakharova', 'Female', '51 Fox Lane', 'Bodney', 'Bedfordshire', 'IP26 1JT', '1985-12-02', 0, 0, '$2a$10$GocnlhkdqTBSegcghUfTW.hQs7Deo3TmMYqe9azhNoSh8d/mCS8ze'),
(1111591, 'Thomas', 'Richardson', 'Male', '25 Golf Road', 'Dunstable', 'Bedfordshire', 'LU4 21A', '1994-09-08', 1, 0, '$2a$10$GocnlhkdqTBSegcghUfTW.hQs7Deo3TmMYqe9azhNoSh8d/mCS8ze'),
(1141800, 'Dylan', 'Butler', 'Male', '55 Quay Street', 'Luton', 'Bedfordshire', 'LU2 1AX', '1996-10-11', 0, 0, '$2a$10$GocnlhkdqTBSegcghUfTW.hQs7Deo3TmMYqe9azhNoSh8d/mCS8ze'),
(1185037, 'Yu', 'Cheng', 'Female', '17 Kingsway North', 'Hitchin', 'Bedfordshire', 'SG44GA', '1986-01-02', 1, 0, '$2a$10$GocnlhkdqTBSegcghUfTW.hQs7Deo3TmMYqe9azhNoSh8d/mCS8ze'),
(1521715, 'Leo', 'Perkins', 'Male', '58 Nottingham Rd', 'Swanland', 'Hertfordshire', 'HU14 8AB', '1987-01-22', 1, 0, '$2a$10$GocnlhkdqTBSegcghUfTW.hQs7Deo3TmMYqe9azhNoSh8d/mCS8ze'),
(1588292, 'Josephine', 'Gómez', 'Female', '25 Fitzroy Court \r\nVicarage Street', 'Luton', 'Bedfordshire', 'LU1 3FA', '1993-03-07', 0, 0, '$2a$10$GocnlhkdqTBSegcghUfTW.hQs7Deo3TmMYqe9azhNoSh8d/mCS8ze'),
(1588611, 'Ewa', 'Kowalska', 'Female', '17 Fore St', 'Luton', 'Bedfordshire', 'LU24AT', '1989-11-23', 1, 0, '$2a$10$GocnlhkdqTBSegcghUfTW.hQs7Deo3TmMYqe9azhNoSh8d/mCS8ze'),
(1619077, 'Mollie ', 'Barrett', 'Male', '115  Golden Knowes Road', 'Frithville', 'Bedfordshire', 'PE22 8AL', '1997-03-28', 0, 0, '$2a$10$GocnlhkdqTBSegcghUfTW.hQs7Deo3TmMYqe9azhNoSh8d/mCS8ze'),
(1693751, 'Rebecca', 'Pratt', 'Female', '62 Main Road', 'Colliston', 'Bedfordshire', 'N12 8RG', '1997-12-12', 0, 0, '$2a$10$GocnlhkdqTBSegcghUfTW.hQs7Deo3TmMYqe9azhNoSh8d/mCS8ze'),
(1709212, 'Alex', 'Smith', 'Male', '59  Bullwood Rd', 'Hangleton', 'Hertfordshire', 'NP6 9PT', '1998-06-23', 0, 0, '$2a$10$GocnlhkdqTBSegcghUfTW.hQs7Deo3TmMYqe9azhNoSh8d/mCS8ze'),
(1804870, 'Sibal', 'Khan', 'Female', '21 Birch wood Street', 'Stevenage', 'Bedfordshire', 'SG11AA', '1987-07-22', 0, 0, '$2a$10$GocnlhkdqTBSegcghUfTW.hQs7Deo3TmMYqe9azhNoSh8d/mCS8ze'),
(1826848, 'Ava', 'Reeves', 'Female', '43  Walden Road', 'Greenfield', 'Bedfordshire', 'RG9 9ER', '1990-05-01', 0, 0, '$2a$10$GocnlhkdqTBSegcghUfTW.hQs7Deo3TmMYqe9azhNoSh8d/mCS8ze'),
(1963913, 'Cameron', 'Wilson', 'Male', '99 Constitution St', 'Newdigate', 'Bedfordshire', 'RH5 2YL', '1994-09-19', 1, 0, '$2a$10$GocnlhkdqTBSegcghUfTW.hQs7Deo3TmMYqe9azhNoSh8d/mCS8ze'),
(1964364, 'Patrycja ', 'Nowicka', 'Female', '245 Hitchin Rd', 'Luton', 'Bedfordshire', 'LU2 7SL', '1992-01-13', 0, 0, '$2a$10$GocnlhkdqTBSegcghUfTW.hQs7Deo3TmMYqe9azhNoSh8d/mCS8ze'),
(2183887, 'Cheng', 'Tsao', 'Male', '21 Luton Road', 'Harpenden', 'Bedfordshire', 'AL51BN', '1989-06-06', 0, 0, '$2a$10$GocnlhkdqTBSegcghUfTW.hQs7Deo3TmMYqe9azhNoSh8d/mCS8ze'),
(2474337, 'Nathan', 'Wade', 'Male', '92 Stone Cellar Road', 'Luton', 'Befordshire', 'LU11DH', '1993-03-13', 0, 0, '$2a$10$GocnlhkdqTBSegcghUfTW.hQs7Deo3TmMYqe9azhNoSh8d/mCS8ze'),
(2815099, 'David', 'Austerlitz', 'Male', '15 Fitzroy Court \r\nVicarage Street', 'Luton', 'Bedfordshire', 'LU1 3FA', '1990-01-29', 0, 0, '$2a$10$GocnlhkdqTBSegcghUfTW.hQs7Deo3TmMYqe9azhNoSh8d/mCS8ze'),
(4770042, 'Olivia', 'Horton', 'Female', '84  Withers Close', 'Alkerton', 'Hertfordshire', 'OX15 7RY', '1990-07-19', 0, 0, '$2a$10$GocnlhkdqTBSegcghUfTW.hQs7Deo3TmMYqe9azhNoSh8d/mCS8ze'),
(5170660, 'Valentina', 'Martìnez', 'Female', '30 Fitzroy Court \r\nVicarage Street', 'Luton', 'Bedfordshire', 'LU1 3FA', '1993-03-07', 0, 0, '$2a$10$GocnlhkdqTBSegcghUfTW.hQs7Deo3TmMYqe9azhNoSh8d/mCS8ze'),
(5309583, 'Holly', 'Parmentier', 'Female', '95 West St', 'Dunstable', 'Bedfordshire', 'LU32AT', '1994-05-12', 0, 0, '$2a$10$GocnlhkdqTBSegcghUfTW.hQs7Deo3TmMYqe9azhNoSh8d/mCS8ze'),
(6024062, 'Elliot', 'Holloway', 'Male', '57  Balsham Road', 'Luton', 'Cambridgeshire', 'LU1 5LQ', '1996-03-17', 0, 0, '$2a$10$GocnlhkdqTBSegcghUfTW.hQs7Deo3TmMYqe9azhNoSh8d/mCS8ze'),
(6030998, 'Yanick', 'Bremmer', 'Male', '35 Front St', 'Slip end', 'Bedfordshire', 'LU1 4BW', '1984-04-12', 0, 0, '$2a$10$GocnlhkdqTBSegcghUfTW.hQs7Deo3TmMYqe9azhNoSh8d/mCS8ze'),
(7071425, 'Gabriel', 'Martin', 'Male', '3 Flower Street', 'Toddington', 'Bedfordshire', 'LU56AX', '1987-05-15', 1, 0, '$2a$10$R08VJOWUSl2ik548C4CbFenkycEILvDkaZShf2.4cxPFxNHbvG..2'),
(7409197, 'Michelle ', 'Klug', 'Female', '8 Fitzroy Court \r\nVicarage Street', 'Luton', 'Bedfordshire', 'LU1 3FA', '1988-06-01', 0, 0, '$2a$10$R08VJOWUSl2ik548C4CbFenkycEILvDkaZShf2.4cxPFxNHbvG..2'),
(7949419, 'Aisha', 'Ali', 'Female', '12 Baker St', 'Leighton Buzzard', 'Bedfordshire', 'LU7 1NL', '1995-11-11', 0, 0, '$2a$10$R08VJOWUSl2ik548C4CbFenkycEILvDkaZShf2.4cxPFxNHbvG..2'),
(8176029, 'Feng', 'Lei', 'Male', '59  Bullwood Rd', 'Hangleton', 'Hertfordshire', 'NP6 9PT', '1998-06-23', 0, 0, '$2a$10$R08VJOWUSl2ik548C4CbFenkycEILvDkaZShf2.4cxPFxNHbvG..2'),
(8475532, 'Sofía', 'Rodríguez', 'Female', '12 Fitzroy Court \r\nVicarage Street', 'Luton', 'Bedfordshire', 'LU1 3FA', '1999-07-20', 1, 0, '$2a$10$R08VJOWUSl2ik548C4CbFenkycEILvDkaZShf2.4cxPFxNHbvG..2'),
(9475656, 'Steffen ', 'Braun', 'Male', '59 Fitzroy Court \r\nVicarage Street', 'Luton', 'Bedfordshire', 'LU1 3FA', '1993-12-10', 0, 0, '$2a$10$R08VJOWUSl2ik548C4CbFenkycEILvDkaZShf2.4cxPFxNHbvG..2');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bookings`
--
ALTER TABLE `bookings`
  ADD PRIMARY KEY (`id`),
  ADD KEY `event_fk` (`event_fk`),
  ADD KEY `user_fk` (`user_fk`);

--
-- Indexes for table `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`uuid`),
  ADD KEY `user_fk` (`user_fk`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bookings`
--
ALTER TABLE `bookings`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;

--
-- AUTO_INCREMENT for table `events`
--
ALTER TABLE `events`
  MODIFY `user_fk` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8475533;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=76543213;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bookings`
--
ALTER TABLE `bookings`
  ADD CONSTRAINT `event_fk` FOREIGN KEY (`event_fk`) REFERENCES `events` (`uuid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `user_fk` FOREIGN KEY (`user_fk`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;
