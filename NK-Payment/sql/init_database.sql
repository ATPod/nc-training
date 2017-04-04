-- Dumping database structure for nk-payment
DROP DATABASE IF EXISTS `nk-payment`;
CREATE DATABASE IF NOT EXISTS `nk-payment`;
USE `nk-payment`;

-- Dumping structure for table nk-payment.client
DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `client_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `client_status` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table nk-payment.client: ~3 rows (approximately)
DELETE FROM `client`;
INSERT INTO `client` (`client_id`, `client_status`, `name`) VALUES
	(1, 0, 'nic'),
	(2, 0, 'vasya'),
	(3, 0, 'petya');

-- Dumping structure for table nk-payment.creditcard
DROP TABLE IF EXISTS `creditcard`;
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

-- Dumping data for table nk-payment.creditcard: ~4 rows (approximately)
DELETE FROM `creditcard`;
INSERT INTO `creditcard` (`crditcard_id`, `client_id`, `money`, `account_status`, `pass`) VALUES
	('1111111111111111', 2, 111, 0, '1111'),
	('1234567890123456', 1, 50, 0, '1234'),
	('1234567890123457', 1, 1000, 0, '1488'),
	('6543210987654321', 3, 500, 0, '6554');
