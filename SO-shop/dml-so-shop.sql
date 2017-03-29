-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.7.17-log - MySQL Community Server (GPL)
-- Операционная система:         Win64
-- HeidiSQL Версия:              9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Дамп данных таблицы so-shop.administrator: ~2 rows (приблизительно)
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
INSERT INTO `administrator` (`id`, `login`, `password`) VALUES
	(1, 'admin', 'admin'),
	(2, 'superuser', '123');
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;

-- Дамп данных таблицы so-shop.client: ~3 rows (приблизительно)
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` (`id`, `login`, `password`, `blacklist`) VALUES
	(1, 'olisve', '123', 0),
	(2, 'meow', 'qwerty', 0),
	(3, 'blacky', '987', 1);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;

-- Дамп данных таблицы so-shop.ordering: ~6 rows (приблизительно)
/*!40000 ALTER TABLE `ordering` DISABLE KEYS */;
INSERT INTO `ordering` (`id`, `idClient`, `paid`) VALUES
	(1, 1, 1),
	(2, 1, 1),
	(3, 1, 0),
	(4, 2, 1),
	(5, 2, 0),
	(6, 3, 0);
/*!40000 ALTER TABLE `ordering` ENABLE KEYS */;

-- Дамп данных таблицы so-shop.ordering_product: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `ordering_product` DISABLE KEYS */;
INSERT INTO `ordering_product` (`idOrdering`, `idProduct`) VALUES
	(1, 1),
	(1, 3),
	(2, 5),
	(2, 8),
	(3, 2),
	(3, 1),
	(3, 3),
	(4, 6),
	(5, 4),
	(6, 7);
/*!40000 ALTER TABLE `ordering_product` ENABLE KEYS */;

-- Дамп данных таблицы so-shop.product: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`id`, `title`, `price`) VALUES
	(1, 't-shirt', 30),
	(2, 'socks', 3),
	(3, 'jeans', 50),
	(4, 'jacket', 80),
	(5, 'skirt', 40),
	(6, 'dress', 70),
	(7, 'shirt', 40),
	(8, 'blouse', 40);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
