-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: na_developersteam
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1001,'И.Ильф'),(1002,'Е.Петров');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `developer`
--

LOCK TABLES `developer` WRITE;
/*!40000 ALTER TABLE `developer` DISABLE KEYS */;
INSERT INTO `developer` VALUES (3001,NULL,1),(3002,NULL,2),(3003,7,3);
/*!40000 ALTER TABLE `developer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
INSERT INTO `invoice` VALUES (3,7,1000000,0),(4,7,10,0),(5,7,100,0);
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES (2001,'О.Бендер'),(2002,'А.Балаганов');
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1001,'И.Ильф','ilya97','123456',1),(1002,'Е.Петров','e.petroff','654321',1),(2001,'О.Бендер','ostap.bender','MyDadWasTurkishPartial',2),(2002,'А.Балаганов','shoora','IamSchmidtSon',2),(3001,'Р.Бородач','borodach','27182818284',3),(3002,'С.Беляков','belyakov','tv4eva',3),(3003,'И.Дулин','dulin','michalych',3);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (7,10004,2002),(11,10009,2002),(12,10003,2002);
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `qualification`
--

LOCK TABLES `qualification` WRITE;
/*!40000 ALTER TABLE `qualification` DISABLE KEYS */;
INSERT INTO `qualification` VALUES (1,'Java Developer'),(2,'.NET Developer'),(3,'QA'),(4,'Frontend Developer'),(5,'Designer'),(6,'Database Designer');
/*!40000 ALTER TABLE `qualification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'customer'),(2,'manager'),(3,'developer');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (25,10003,'Store data in database'),(26,10003,'Create web interface'),(27,10003,'Create RESTful API'),(28,10004,'Specification'),(29,10005,'Simple task for two QA'),(30,10005,'Complex task for 3 Java developers'),(34,10009,'Write C# code'),(35,10009,'Test code'),(36,10009,'Write web pages'),(37,10010,'blahblah'),(38,10010,'souhfouh');
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `task_quota`
--

LOCK TABLES `task_quota` WRITE;
/*!40000 ALTER TABLE `task_quota` DISABLE KEYS */;
INSERT INTO `task_quota` VALUES (18,1,6,25),(19,2,4,26),(20,2,1,27),(21,2,3,28),(22,2,3,29),(23,3,1,30),(27,2,2,34),(28,1,3,35),(29,2,1,36),(30,2,1,37),(31,1,4,38);
/*!40000 ALTER TABLE `task_quota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `terms_of_reference`
--

LOCK TABLES `terms_of_reference` WRITE;
/*!40000 ALTER TABLE `terms_of_reference` DISABLE KEYS */;
INSERT INTO `terms_of_reference` VALUES (10003,1001),(10004,1001),(10005,1001),(10009,1001),(10010,1001);
/*!40000 ALTER TABLE `terms_of_reference` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `time_sheet`
--

LOCK TABLES `time_sheet` WRITE;
/*!40000 ALTER TABLE `time_sheet` DISABLE KEYS */;
INSERT INTO `time_sheet` VALUES (5,'2017-06-05',7,3003,100);
/*!40000 ALTER TABLE `time_sheet` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-11  8:50:46
