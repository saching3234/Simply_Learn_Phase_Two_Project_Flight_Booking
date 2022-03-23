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
-- Table structure for table `userflightbooking`
--

DROP TABLE IF EXISTS `userflightbooking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userflightbooking` (
  `bookingId` int NOT NULL AUTO_INCREMENT,
  `FlightId` int DEFAULT NULL,
  `FlightSource` varchar(50) DEFAULT NULL,
  `FlightDestinatio` varchar(45) DEFAULT NULL,
  `AirLineName` varchar(45) DEFAULT NULL,
  `TicketPrice` int DEFAULT NULL,
  `PassangerCount` int DEFAULT NULL,
  `FinalPrice` int DEFAULT NULL,
  `PaymentStatus` varchar(45) DEFAULT NULL,
  `userName` varchar(45) DEFAULT NULL,
  `dateofjourney` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`bookingId`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userflightbooking`
--

LOCK TABLES `userflightbooking` WRITE;
/*!40000 ALTER TABLE `userflightbooking` DISABLE KEYS */;
INSERT INTO `userflightbooking` VALUES (1,5,'mumbai','pune','Air India',20000,1,20000,'true','nana32','3/22/2022'),(7,5,'mumbai','pune','Air India',20000,2,40000,'true','sachin32','2022-03-30'),(8,8,'mumbai','pune','Go Air',3000,8,24000,'false','sachin32','2022-03-25'),(9,9,'pune','Karad','Air Asia',3400,2,6800,'true','sachin32','2022-03-25'),(10,8,'mumbai','pune','Go Air',3000,3,9000,'false','sachin32','2022-03-01'),(11,8,'mumbai','pune','Go Air',3000,3,9000,'true','nana32','2022-04-01'),(12,8,'mumbai','pune','Go Air',3000,3,9000,'true','ketan32','2022-03-29'),(13,9,'pune','Karad','Air Asia',3400,3,10200,'false','ketan32','2022-03-31'),(14,11,'pune','bangalor','Delta Air Lines',23000,2,46000,'true','sandip32','2022-03-25'),(15,9,'pune','Karad','Air Asia',3400,1,3400,'false','sandip32','2022-03-28'),(16,16,'pune','bangalor','King Fisher',12000,2,24000,'false','sandip32','2022-04-01'),(17,13,'pune','kolhapur','King Fisher',5000,3,15000,'true','sandip32','2022-04-04');
/*!40000 ALTER TABLE `userflightbooking` ENABLE KEYS */;
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
