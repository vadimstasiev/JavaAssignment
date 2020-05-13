-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 13, 2020 at 11:20 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.5

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
(24, 'c697776c-2ca0-4552-9caf-360fbf963a32', 8475532),
(26, 'e2360bbf-54f5-4416-8acf-82d09b9d1ff0', 8475532),
(28, 'f7148ee4-a0ad-4782-aa77-e8ef3cc54290', 7071425),
(29, 'c697776c-2ca0-4552-9caf-360fbf963a32', 7071425),
(30, 'c697776c-2ca0-4552-9caf-360fbf963a32', 1826848),
(31, 'b525b470-fa5a-49e1-9e10-553d1e9d05ed', 1826848),
(32, 'e2360bbf-54f5-4416-8acf-82d09b9d1ff0', 1826848),
(34, '72b71ce5-ec95-4e90-b93f-e5ef291b3c6f', 1141800),
(35, 'f7148ee4-a0ad-4782-aa77-e8ef3cc54290', 1141800),
(36, 'b525b470-fa5a-49e1-9e10-553d1e9d05ed', 7409197),
(37, 'c697776c-2ca0-4552-9caf-360fbf963a32', 7409197),
(39, 'f7148ee4-a0ad-4782-aa77-e8ef3cc54290', 1693751),
(40, 'c697776c-2ca0-4552-9caf-360fbf963a32', 1693751),
(41, '72b71ce5-ec95-4e90-b93f-e5ef291b3c6f', 1693751),
(42, '72b71ce5-ec95-4e90-b93f-e5ef291b3c6f', 1588292),
(44, 'c697776c-2ca0-4552-9caf-360fbf963a32', 1588292);

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
('72b71ce5-ec95-4e90-b93f-e5ef291b3c6f', 'A004', 'What is Esport?', 'This presentation is about what is esport, what are benefits of being part of gaming community following by Q&A. Anyone is welcome no matter what level of involement into video games. ', '2020-06-12', '16:00', 50, 7071425),
('b2f1732a-349c-4e9f-a815-bab54809dd0c', 'A004', 'Football history presentation', 'This presentation will put you in depth about history of football with focus on why did it become such a famous sport', '2020-05-22', '15:00', 60, 1111591),
('b525b470-fa5a-49e1-9e10-553d1e9d05ed', 'G101', 'Spanish Language for Beginners', 'Hello my name is Sofia and I am aspiring to be a Spanish language teacher. During this lecture I will try to introduce you to Spanish lagnuage and hopefully encourage you to continue learning it. ', '2020-06-19', '18:00', 70, 8475532),
('c697776c-2ca0-4552-9caf-360fbf963a32', 'A004', 'CV writing lesson', 'Hello my name is Ewa. I have been working in HR department for more than 10 years and using that experience I will present most common mistakes people make when writing CV and how to write a good CV that stands out among others. As well there will be a Q&A regarding any work related topic. Anyone is welcome and places are limited!', '2020-06-02', '17:00', 50, 1588611),
('ccab8b3d-f24c-446e-b39d-d27fb878628d', 'J200', 'Book discussion group', 'During this session we encourage everyone to bring their favourite book and tell little about to encourage others to read it. \n', '2020-05-15', '16:00', 25, 1111591),
('e2360bbf-54f5-4416-8acf-82d09b9d1ff0', 'J105', 'Chinese culture club', 'In this club we can share/learn/teach about chinese culture. Anyone is welcome', '2020-05-20', '18:00', 20, 1185037),
('f7148ee4-a0ad-4782-aa77-e8ef3cc54290', 'D104', 'Programming club', 'Programming club will be an session when everyone no matter of experience can come and learn, teach find out about what programming is. ', '2020-05-25', '16:00', 40, 1521715);

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
(1, 'Vadim', 'Stasiev', 'Male', '12 High Street', 'Dunstable', 'Bedfordshire', 'LU6 1JZ\r\n', '1998-05-27', 0, 1, '$2a$10$R08VJOWUSl2ik548C4CbFenkycEILvDkaZShf2.4cxPFxNHbvG..2'),
(1003852, 'Vanessa ', 'Zakharova', 'Female', '51 Fox Lane', 'Bodney', 'Bedfordshire', 'IP26 1JT', '1985-12-02', 0, 0, '$2a$10$R08VJOWUSl2ik548C4CbFenkycEILvDkaZShf2.4cxPFxNHbvG..2'),
(1111591, 'Thomas', 'Richardson', 'Male', '25 Golf Road', 'Dunstable', 'Bedfordshire', 'LU4 21A', '1994-09-08', 1, 0, '$2a$10$R08VJOWUSl2ik548C4CbFenkycEILvDkaZShf2.4cxPFxNHbvG..2'),
(1141800, 'Dylan', 'Butler', 'Male', '55 Quay Street', 'Luton', 'Bedfordshire', 'LU2 1AX', '1996-10-11', 0, 0, '$2a$10$R08VJOWUSl2ik548C4CbFenkycEILvDkaZShf2.4cxPFxNHbvG..2'),
(1185037, 'Yu', 'Cheng', 'Female', '17 Kingsway North', 'Hitchin', 'Bedfordshire', 'SG44GA', '1986-01-02', 1, 0, '$2a$10$R08VJOWUSl2ik548C4CbFenkycEILvDkaZShf2.4cxPFxNHbvG..2'),
(1521715, 'Leo', 'Perkins', 'Male', '58 Nottingham Rd', 'Swanland', 'Hertfordshire', 'HU14 8AB', '1987-01-22', 1, 0, '$2a$10$R08VJOWUSl2ik548C4CbFenkycEILvDkaZShf2.4cxPFxNHbvG..2'),
(1588292, 'Josephine', 'Gómez', 'Female', '25 Fitzroy Court \r\nVicarage Street', 'Luton', 'Bedfordshire', 'LU1 3FA', '1993-03-07', 0, 0, '$2a$10$R08VJOWUSl2ik548C4CbFenkycEILvDkaZShf2.4cxPFxNHbvG..2'),
(1588611, 'Ewa', 'Kowalska', 'Female', '17 Fore St', 'Luton', 'Bedfordshire', 'LU24AT', '1989-11-23', 1, 0, '$2a$10$R08VJOWUSl2ik548C4CbFenkycEILvDkaZShf2.4cxPFxNHbvG..2'),
(1619077, 'Mollie ', 'Barrett', 'Male', '115  Golden Knowes Road', 'Frithville', 'Bedfordshire', 'PE22 8AL', '1997-03-28', 0, 0, '$2a$10$R08VJOWUSl2ik548C4CbFenkycEILvDkaZShf2.4cxPFxNHbvG..2'),
(1693751, 'Rebecca', 'Pratt', 'Female', '62 Main Road', 'Colliston', 'Bedfordshire', 'N12 8RG', '1997-12-12', 0, 0, '$2a$10$R08VJOWUSl2ik548C4CbFenkycEILvDkaZShf2.4cxPFxNHbvG..2'),
(1709212, 'Alex', 'Smith', 'Male', '59  Bullwood Rd', 'Hangleton', 'Hertfordshire', 'NP6 9PT', '1998-06-23', 0, 0, '$2a$10$R08VJOWUSl2ik548C4CbFenkycEILvDkaZShf2.4cxPFxNHbvG..2'),
(1804870, 'Sibal', 'Khan', 'Female', '21 Birch wood Street', 'Stevenage', 'Bedfordshire', 'SG11AA', '1987-07-22', 0, 0, '$2a$10$R08VJOWUSl2ik548C4CbFenkycEILvDkaZShf2.4cxPFxNHbvG..2'),
(1826848, 'Ava', 'Reeves', 'Female', '43  Walden Road', 'Greenfield', 'Bedfordshire', 'RG9 9ER', '1990-05-01', 0, 0, '$2a$10$R08VJOWUSl2ik548C4CbFenkycEILvDkaZShf2.4cxPFxNHbvG..2'),
(1906422, '', '', '', '', '', '', '', '', 0, 0, '$2a$10$u7fQGUQ8JoqSS9R8JOKgOupe4q/WilKXrVuyesjVeIiz65x6/pYj6'),
(1963913, 'Cameron', 'Wilson', 'Male', '99 Constitution St', 'Newdigate', 'Bedfordshire', 'RH5 2YL', '1994-09-19', 1, 0, '$2a$10$R08VJOWUSl2ik548C4CbFenkycEILvDkaZShf2.4cxPFxNHbvG..2'),
(1964364, 'Patrycja ', 'Nowicka', 'Female', '245 Hitchin Rd', 'Luton', 'Bedfordshire', 'LU2 7SL', '1992-01-13', 0, 0, '$2a$10$R08VJOWUSl2ik548C4CbFenkycEILvDkaZShf2.4cxPFxNHbvG..2'),
(2183887, 'Cheng', 'Tsao', 'Male', '21 Luton Road', 'Harpenden', 'Bedfordshire', 'AL51BN', '1989-06-06', 0, 0, '$2a$10$R08VJOWUSl2ik548C4CbFenkycEILvDkaZShf2.4cxPFxNHbvG..2'),
(2474337, 'Nathan', 'Wade', 'Male', '92 Stone Cellar Road', 'Luton', 'Befordshire', 'LU11DH', '1993-03-13', 0, 0, '$2a$10$R08VJOWUSl2ik548C4CbFenkycEILvDkaZShf2.4cxPFxNHbvG..2'),
(2815099, 'David', 'Austerlitz', 'Male', '15 Fitzroy Court \r\nVicarage Street', 'Luton', 'Bedfordshire', 'LU1 3FA', '1990-01-29', 0, 0, '$2a$10$R08VJOWUSl2ik548C4CbFenkycEILvDkaZShf2.4cxPFxNHbvG..2'),
(4770042, 'Olivia', 'Horton', 'Female', '84  Withers Close', 'Alkerton', 'Hertfordshire', 'OX15 7RY', '1990-07-19', 0, 0, '$2a$10$R08VJOWUSl2ik548C4CbFenkycEILvDkaZShf2.4cxPFxNHbvG..2'),
(5170660, 'Valentina', 'Martìnez', 'Female', '30 Fitzroy Court \r\nVicarage Street', 'Luton', 'Bedfordshire', 'LU1 3FA', '1993-03-07', 0, 0, '$2a$10$R08VJOWUSl2ik548C4CbFenkycEILvDkaZShf2.4cxPFxNHbvG..2'),
(5309583, 'Holly', 'Parmentier', 'Female', '95 West St', 'Dunstable', 'Bedfordshire', 'LU32AT', '1994-05-12', 0, 0, '$2a$10$R08VJOWUSl2ik548C4CbFenkycEILvDkaZShf2.4cxPFxNHbvG..2'),
(6024062, 'Elliot', 'Holloway', 'Male', '57  Balsham Road', 'Luton', 'Cambridgeshire', 'LU1 5LQ', '1996-03-17', 0, 0, '$2a$10$R08VJOWUSl2ik548C4CbFenkycEILvDkaZShf2.4cxPFxNHbvG..2'),
(6030998, 'Yanick', 'Bremmer', 'Male', '35 Front St', 'Slip end', 'Bedfordshire', 'LU1 4BW', '1984-04-12', 0, 0, '$2a$10$R08VJOWUSl2ik548C4CbFenkycEILvDkaZShf2.4cxPFxNHbvG..2'),
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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

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
