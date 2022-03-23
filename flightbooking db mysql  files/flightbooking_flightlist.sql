-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: flightbooking
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `flightlist`
--

DROP TABLE IF EXISTS `flightlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flightlist` (
  `Flight_Id` int NOT NULL AUTO_INCREMENT,
  `FSource` varchar(45) DEFAULT NULL,
  `FDestinatiom` varchar(45) DEFAULT NULL,
  `AirlineName` varchar(45) DEFAULT NULL,
  `Ticket_Price` int DEFAULT NULL,
  PRIMARY KEY (`Flight_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flightlist`
--

LOCK TABLES `flightlist` WRITE;
/*!40000 ALTER TABLE `flightlist` DISABLE KEYS */;
INSERT INTO `flightlist` VALUES (5,'mumbai','pune','Air India',20000),(6,'pune','Karad','King Fisher',5000),(8,'mumbai','pune','Go Air',3000),(9,'pune','Karad','Air Asia',3400),(11,'pune','bangalor','Delta Air Lines',23000),(12,'pune','kolhapur','Air India',12000),(13,'pune','kolhapur','King Fisher',5000),(14,'pune','kolhapur','Delta Air Lines',30000),(15,'pune','bangalor','Air India',5000),(16,'pune','bangalor','King Fisher',12000),(17,'pune','bangalor','Air Asia',2300);
/*!40000 ALTER TABLE `flightlist` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-23 22:11:18
