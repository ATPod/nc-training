-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.17-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5168
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for nk-payment
CREATE DATABASE IF NOT EXISTS `nk-payment` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `nk-payment`;

-- Dumping structure for table nk-payment.client
CREATE TABLE IF NOT EXISTS `client` (
  `client_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `client_status` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table nk-payment.client: ~0 rows (approximately)
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
/*!40000 ALTER TABLE `client` ENABLE KEYS */;

-- Dumping structure for table nk-payment.creditcard
CREATE TABLE IF NOT EXISTS `creditcard` (
  `crditcard_id` varchar(16) NOT NULL,
  `client_id` int(10) unsigned NOT NULL,
  `money` double unsigned NOT NULL,
  `account_status` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `pass` varchar(4) NOT NULL,
  PRIMARY KEY (`crditcard_id`),
  KEY `FK_creditcard_client` (`client_id`),
  CONSTRAINT `FK_creditcard_client` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table nk-payment.creditcard: ~0 rows (approximately)
/*!40000 ALTER TABLE `creditcard` DISABLE KEYS */;
/*!40000 ALTER TABLE `creditcard` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
