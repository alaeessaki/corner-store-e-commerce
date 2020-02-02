-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Feb 02, 2020 at 02:15 PM
-- Server version: 5.7.24
-- PHP Version: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `corner_store`
--

-- --------------------------------------------------------

--
-- Table structure for table `admins`
--

DROP TABLE IF EXISTS `admins`;
CREATE TABLE IF NOT EXISTS `admins` (
  `user_id` int(11) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FK_721om36osan088rncmuxn6sal` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `admins`
--

INSERT INTO `admins` (`user_id`, `created_at`, `updated_at`, `password`, `username`, `role_id`) VALUES
(1, '2020-01-23 00:00:00', '2020-01-15 00:00:00', 'alae12', 'alaeessaki', 1);

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
CREATE TABLE IF NOT EXISTS `categories` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `label` varchar(255) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`category_id`),
  KEY `FKsaok720gsu4u2wrgbk10b5n8d` (`parent_id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`category_id`, `created_at`, `updated_at`, `label`, `parent_id`) VALUES
(11, '2020-01-31 10:35:15', '2020-01-31 10:35:15', 'Accessories And Shoes', NULL),
(9, '2020-01-31 10:33:10', '2020-01-31 10:33:10', 'Jeans', NULL),
(10, '2020-01-31 10:35:03', '2020-01-31 10:35:03', 'Socks', NULL),
(8, '2020-01-31 09:36:38', '2020-01-31 09:36:38', 'pants', NULL),
(12, '2020-01-31 10:35:40', '2020-01-31 10:35:40', 'Bags', NULL),
(13, '2020-01-31 10:36:06', '2020-01-31 10:36:06', 'Wallets', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
CREATE TABLE IF NOT EXISTS `clients` (
  `user_id` int(11) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `role_id` int(11) NOT NULL,
  `adress1` varchar(255) DEFAULT NULL,
  `adress2` varchar(255) DEFAULT NULL,
  `birth_date` date NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FK_auhog8w9n8kor20332iq7gkr5` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `clients`
--

INSERT INTO `clients` (`user_id`, `created_at`, `updated_at`, `password`, `username`, `role_id`, `adress1`, `adress2`, `birth_date`, `city`, `country`, `email`, `first_name`, `last_name`, `phone`, `zip`) VALUES
(1, '2020-01-28 18:48:38', '2020-01-28 18:48:38', 'alae12', 'khalil', 1, '361 qu agendis', NULL, '1997-11-02', 'youssoufia', 'morocco', 'alaeessaki@gmail.com', 'alae', 'essaki', '0693438016', '46300'),
(2, '2020-01-28 18:50:54', '2020-01-28 18:50:54', 'alae12', 'khalilkessa', 2, '361 qu agendis', NULL, '1997-11-02', 'youssoufia', 'morocco', 'alaeessaki@gmail.com', 'alae', 'essaki', '0693438016', '46300');

-- --------------------------------------------------------

--
-- Table structure for table `colors`
--

DROP TABLE IF EXISTS `colors`;
CREATE TABLE IF NOT EXISTS `colors` (
  `color_id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `label` varchar(255) NOT NULL,
  PRIMARY KEY (`color_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `colors`
--

INSERT INTO `colors` (`color_id`, `created_at`, `updated_at`, `label`) VALUES
(1, '2020-01-23 00:00:00', '2020-01-15 00:00:00', 'red');

-- --------------------------------------------------------

--
-- Table structure for table `coupons`
--

DROP TABLE IF EXISTS `coupons`;
CREATE TABLE IF NOT EXISTS `coupons` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `base` varchar(255) NOT NULL,
  `code` longtext NOT NULL,
  `discount_percent` float NOT NULL,
  `end_date` date NOT NULL,
  `start_date` date NOT NULL,
  `status` tinyint(1) DEFAULT '0',
  `client_id` int(11) DEFAULT NULL,
  `piece_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_bbt8stedw4rl6kp3dwjpbru6i` (`base`),
  KEY `FKi70ltcdn4nbdxmx0xkxlghswj` (`client_id`),
  KEY `FKjk275v184ox5cm8x8mkl91i9i` (`piece_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequences`
--

DROP TABLE IF EXISTS `hibernate_sequences`;
CREATE TABLE IF NOT EXISTS `hibernate_sequences` (
  `sequence_name` varchar(255) NOT NULL,
  `next_val` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`sequence_name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hibernate_sequences`
--

INSERT INTO `hibernate_sequences` (`sequence_name`, `next_val`) VALUES
('default', 3);

-- --------------------------------------------------------

--
-- Table structure for table `images`
--

DROP TABLE IF EXISTS `images`;
CREATE TABLE IF NOT EXISTS `images` (
  `image_id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `alt` varchar(255) DEFAULT NULL,
  `src` varchar(255) NOT NULL,
  `product_id` int(11) NOT NULL,
  PRIMARY KEY (`image_id`),
  KEY `FKghwsjbjo7mg3iufxruvq6iu3q` (`product_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `images`
--

INSERT INTO `images` (`image_id`, `created_at`, `updated_at`, `alt`, `src`, `product_id`) VALUES
(1, '2020-01-30 09:58:50', '2020-01-30 09:58:50', 't-shirt1 image', 'dqsdq.jpg', 1),
(2, '2020-01-31 10:46:34', '2020-01-31 10:46:34', 'pant1 image', 'dqsdq.jpg', 2),
(3, '2020-01-31 10:46:47', '2020-01-31 10:46:47', 'pant2 image', 'dqsdq.jpg', 3),
(4, '2020-01-31 10:46:52', '2020-01-31 10:46:52', 'pant3 image', 'dqsdq.jpg', 4),
(5, '2020-01-31 10:46:56', '2020-01-31 10:46:56', 'pant4 image', 'dqsdq.jpg', 5),
(6, '2020-01-31 10:46:59', '2020-01-31 10:46:59', 'pant5 image', 'dqsdq.jpg', 6);

-- --------------------------------------------------------

--
-- Table structure for table `ligne_de_piece`
--

DROP TABLE IF EXISTS `ligne_de_piece`;
CREATE TABLE IF NOT EXISTS `ligne_de_piece` (
  `ligne_id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `quantity` int(11) NOT NULL,
  `total_price` float NOT NULL,
  `client_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`ligne_id`),
  KEY `FKqg1oc850uq0a87tvt5hc7bwr9` (`client_id`),
  KEY `FKrdcu5ksgkx900h0oi07bmh49d` (`product_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `ligne_de_piece_piece`
--

DROP TABLE IF EXISTS `ligne_de_piece_piece`;
CREATE TABLE IF NOT EXISTS `ligne_de_piece_piece` (
  `piece_id` int(11) NOT NULL,
  `ligne_id` int(11) NOT NULL,
  UNIQUE KEY `UK_oyfdqamdduea2pck10s6e0nj2` (`ligne_id`),
  KEY `FK6v7fqt22jilenf66hcc3rnit9` (`piece_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

DROP TABLE IF EXISTS `payments`;
CREATE TABLE IF NOT EXISTS `payments` (
  `payment_id` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(255) NOT NULL,
  `payment_type_id` int(11) NOT NULL,
  PRIMARY KEY (`payment_id`),
  KEY `FKrax3c0bm2lpch6m7sh19um7sp` (`payment_type_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `payment_types`
--

DROP TABLE IF EXISTS `payment_types`;
CREATE TABLE IF NOT EXISTS `payment_types` (
  `payment_id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `label` varchar(255) NOT NULL,
  PRIMARY KEY (`payment_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `piece`
--

DROP TABLE IF EXISTS `piece`;
CREATE TABLE IF NOT EXISTS `piece` (
  `piece_id` int(11) NOT NULL AUTO_INCREMENT,
  `dynamic_id` varchar(255) NOT NULL,
  `total_price` float NOT NULL,
  PRIMARY KEY (`piece_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `piece_heads`
--

DROP TABLE IF EXISTS `piece_heads`;
CREATE TABLE IF NOT EXISTS `piece_heads` (
  `piece_head_id` int(11) NOT NULL AUTO_INCREMENT,
  `is_shipped` tinyint(1) DEFAULT '0',
  `phone` varchar(255) DEFAULT NULL,
  `ship_adress` varchar(255) NOT NULL,
  `ship_adress2` varchar(255) DEFAULT NULL,
  `ship_name` varchar(255) NOT NULL,
  `zip` varchar(255) NOT NULL,
  `piece_id` int(11) NOT NULL,
  `piece_type_id` int(11) NOT NULL,
  PRIMARY KEY (`piece_head_id`),
  KEY `FK3jtjeffhntpwq2t3cpsbx9n03` (`piece_id`),
  KEY `FKfwy5egifyul1xpf82ywoe43fp` (`piece_type_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `piece_payment`
--

DROP TABLE IF EXISTS `piece_payment`;
CREATE TABLE IF NOT EXISTS `piece_payment` (
  `payment_id` int(11) DEFAULT NULL,
  `piece_id` int(11) NOT NULL,
  PRIMARY KEY (`piece_id`),
  KEY `FK7aw0eygfdfhcs6jd3baabqrfq` (`payment_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `piece_shipping`
--

DROP TABLE IF EXISTS `piece_shipping`;
CREATE TABLE IF NOT EXISTS `piece_shipping` (
  `shipping_id` int(11) DEFAULT NULL,
  `piece_id` int(11) NOT NULL,
  PRIMARY KEY (`piece_id`),
  KEY `FK5527qburkw00qtgxbbdsu0fbf` (`shipping_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `piece_types`
--

DROP TABLE IF EXISTS `piece_types`;
CREATE TABLE IF NOT EXISTS `piece_types` (
  `piece_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `label` varchar(255) NOT NULL,
  `last_inc_id` int(11) NOT NULL,
  PRIMARY KEY (`piece_type_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
CREATE TABLE IF NOT EXISTS `products` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `description` longtext NOT NULL,
  `live` tinyint(1) DEFAULT '0',
  `name` varchar(255) NOT NULL,
  `number_of_sells` int(11) DEFAULT '0',
  `price` float NOT NULL,
  `sku` varchar(255) NOT NULL,
  `stock` int(11) NOT NULL,
  `thumb` varchar(255) NOT NULL,
  `category_id` int(11) NOT NULL,
  `stars_collection_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `FKog2rp4qthbtt2lfyhfo32lsw9` (`category_id`),
  KEY `FKda1nljhsm8c19orbgbd10bugx` (`stars_collection_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`product_id`, `created_at`, `updated_at`, `description`, `live`, `name`, `number_of_sells`, `price`, `sku`, `stock`, `thumb`, `category_id`, `stars_collection_id`) VALUES
(2, '2020-01-31 10:46:34', '2020-01-31 10:46:34', 'description1', 0, 'pant1', 0, 20, 'qsdqsdqsdsq', 30, 'dqdsqdq.jpg', 8, 2),
(3, '2020-01-31 10:46:47', '2020-01-31 10:46:47', 'description1', 0, 'pant2', 0, 20, 'qsdqsdqsdsq', 30, 'dqdsqdq.jpg', 8, 3),
(4, '2020-01-31 10:46:52', '2020-01-31 10:46:52', 'description1', 0, 'pant3', 0, 20, 'qsdqsdqsdsq', 30, 'dqdsqdq.jpg', 8, 4),
(5, '2020-01-31 10:46:56', '2020-01-31 10:46:56', 'description1', 0, 'pant4', 0, 20, 'qsdqsdqsdsq', 30, 'dqdsqdq.jpg', 8, 5),
(6, '2020-01-31 10:46:59', '2020-01-31 10:46:59', 'description1', 0, 'pant5', 0, 20, 'qsdqsdqsdsq', 30, 'dqdsqdq.jpg', 8, 6);

-- --------------------------------------------------------

--
-- Table structure for table `product_color`
--

DROP TABLE IF EXISTS `product_color`;
CREATE TABLE IF NOT EXISTS `product_color` (
  `product_id` int(11) NOT NULL,
  `color_id` int(11) NOT NULL,
  KEY `FKpk6riqswj8f8ldulumm9hmpq` (`color_id`),
  KEY `FKjs0ht7btbgt5u0jpossmgvfk5` (`product_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product_color`
--

INSERT INTO `product_color` (`product_id`, `color_id`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 1);

-- --------------------------------------------------------

--
-- Table structure for table `product_size`
--

DROP TABLE IF EXISTS `product_size`;
CREATE TABLE IF NOT EXISTS `product_size` (
  `product_id` int(11) NOT NULL,
  `size_id` int(11) NOT NULL,
  KEY `FK1yl8bbmokvonm64131xlscnci` (`size_id`),
  KEY `FK9qjgp0xvl5jfetdt683i7wqwr` (`product_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product_size`
--

INSERT INTO `product_size` (`product_id`, `size_id`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 1);

-- --------------------------------------------------------

--
-- Table structure for table `reviews`
--

DROP TABLE IF EXISTS `reviews`;
CREATE TABLE IF NOT EXISTS `reviews` (
  `review_id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `content` longtext NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `stars` int(11) NOT NULL,
  `client_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  PRIMARY KEY (`review_id`),
  KEY `FKo2cmyvyjrvumg4b3de9dcvfxa` (`client_id`),
  KEY `FKpl51cejpw4gy5swfar8br9ngi` (`product_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `reviews`
--

INSERT INTO `reviews` (`review_id`, `created_at`, `updated_at`, `content`, `image`, `stars`, `client_id`, `product_id`) VALUES
(1, '2020-01-30 10:04:16', '2020-01-30 10:04:16', 'i like this project', NULL, 5, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `label` varchar(255) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`role_id`, `created_at`, `updated_at`, `label`) VALUES
(1, '2020-01-23 00:00:00', '2020-01-15 00:00:00', 'admin'),
(2, '2020-01-28 18:50:36', '2020-01-28 18:50:36', 'client');

-- --------------------------------------------------------

--
-- Table structure for table `shippings`
--

DROP TABLE IF EXISTS `shippings`;
CREATE TABLE IF NOT EXISTS `shippings` (
  `shipping_id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `description` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` float NOT NULL,
  PRIMARY KEY (`shipping_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `sizes`
--

DROP TABLE IF EXISTS `sizes`;
CREATE TABLE IF NOT EXISTS `sizes` (
  `size_id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `label` varchar(255) NOT NULL,
  PRIMARY KEY (`size_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sizes`
--

INSERT INTO `sizes` (`size_id`, `created_at`, `updated_at`, `label`) VALUES
(1, '2020-01-23 00:00:00', '2020-01-15 00:00:00', 'XL');

-- --------------------------------------------------------

--
-- Table structure for table `stars_collections`
--

DROP TABLE IF EXISTS `stars_collections`;
CREATE TABLE IF NOT EXISTS `stars_collections` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `stars_collections`
--

INSERT INTO `stars_collections` (`id`, `created_at`, `updated_at`) VALUES
(1, '2020-01-30 09:58:50', '2020-01-30 09:58:50'),
(2, '2020-01-31 10:46:34', '2020-01-31 10:46:34'),
(3, '2020-01-31 10:46:47', '2020-01-31 10:46:47'),
(4, '2020-01-31 10:46:52', '2020-01-31 10:46:52'),
(5, '2020-01-31 10:46:56', '2020-01-31 10:46:56'),
(6, '2020-01-31 10:46:59', '2020-01-31 10:46:59');

-- --------------------------------------------------------

--
-- Table structure for table `stars_collection_stars_data`
--

DROP TABLE IF EXISTS `stars_collection_stars_data`;
CREATE TABLE IF NOT EXISTS `stars_collection_stars_data` (
  `stars_collection_id` int(11) NOT NULL,
  `stars` int(11) DEFAULT NULL,
  `stars_data_key` int(11) NOT NULL,
  PRIMARY KEY (`stars_collection_id`,`stars_data_key`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `stars_collection_stars_data`
--

INSERT INTO `stars_collection_stars_data` (`stars_collection_id`, `stars`, `stars_data_key`) VALUES
(1, 0, 0),
(1, 0, 2),
(1, 0, 3),
(1, 1, 4),
(1, 0, 1),
(2, 0, 1),
(2, 0, 3),
(2, 0, 4),
(2, 0, 2),
(2, 0, 0),
(3, 0, 1),
(3, 0, 3),
(3, 0, 4),
(3, 0, 2),
(3, 0, 0),
(4, 0, 1),
(4, 0, 3),
(4, 0, 4),
(4, 0, 2),
(4, 0, 0),
(5, 0, 1),
(5, 0, 3),
(5, 0, 4),
(5, 0, 2),
(5, 0, 0),
(6, 0, 1),
(6, 0, 3),
(6, 0, 4),
(6, 0, 2),
(6, 0, 0);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
