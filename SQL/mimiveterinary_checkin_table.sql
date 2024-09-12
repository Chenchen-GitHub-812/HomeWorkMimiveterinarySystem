-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: mimiveterinary
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `checkin_table`
--

DROP TABLE IF EXISTS `checkin_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `checkin_table` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `staffnumber` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `date` varchar(45) NOT NULL,
  `check_in_time` varchar(255) NOT NULL,
  `check_out_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`staffnumber`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `checkin_table`
--

LOCK TABLES `checkin_table` WRITE;
/*!40000 ALTER TABLE `checkin_table` DISABLE KEYS */;
INSERT INTO `checkin_table` VALUES (4,'24010812','陳*育','2024-09-04','14:46:39','18:57:24'),(5,'24010812','陳*育','2024-09-04','19:58:36','18:57:24'),(6,'24010812','陳*育','2024-09-06','14:25:38','18:57:24'),(7,'24010812','陳*育','2024-09-10','15:09:06','18:57:24'),(8,'24010812','陳*育','2024-09-11','18:55:41','18:57:24'),(9,'23020930','廖*杰','2024-09-12','15:26:20','18:42:07'),(10,'24010812','陳*育','2024-09-12','20:23:15',NULL);
/*!40000 ALTER TABLE `checkin_table` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-12 20:49:42
