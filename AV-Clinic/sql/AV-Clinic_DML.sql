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

-- Дамп данных таблицы av-clinic.diagnosis: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `diagnosis` DISABLE KEYS */;
INSERT INTO `diagnosis` (`Id`, `Name`, `PatientId`) VALUES
	(1, 'Грипп', 1),
	(2, 'Слепота', 2),
	(3, 'Глухота', 2),
	(4, 'Рак лёгких', 3),
	(5, 'Рак пищевода', 3);
/*!40000 ALTER TABLE `diagnosis` ENABLE KEYS */;

-- Дамп данных таблицы av-clinic.drug: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `drug` DISABLE KEYS */;
INSERT INTO `drug` (`Id`, `Name`, `PatientId`) VALUES
	(1, 'Аспирин', 1),
	(2, 'Черника', 2),
	(3, 'Кризотиниб', 3);
/*!40000 ALTER TABLE `drug` ENABLE KEYS */;

-- Дамп данных таблицы av-clinic.patient: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` (`Id`, `Name`) VALUES
	(1, 'Иванов'),
	(2, 'Петров'),
	(3, 'Сидоров');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;

-- Дамп данных таблицы av-clinic.procedure: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `procedure` DISABLE KEYS */;
INSERT INTO `procedure` (`Id`, `Name`, `PatientId`) VALUES
	(1, 'Ингаляция', 1),
	(2, 'Химиотерапия', 3);
/*!40000 ALTER TABLE `procedure` ENABLE KEYS */;

-- Дамп данных таблицы av-clinic.surgery: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `surgery` DISABLE KEYS */;
INSERT INTO `surgery` (`Id`, `Name`, `PatientId`) VALUES
	(1, 'Удаление опухоли', 3);
/*!40000 ALTER TABLE `surgery` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
