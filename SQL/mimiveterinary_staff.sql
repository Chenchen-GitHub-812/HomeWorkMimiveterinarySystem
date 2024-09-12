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
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `sex` varchar(45) NOT NULL,
  `idnumber` varchar(45) NOT NULL,
  `birthday` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `emergency_contact_name` varchar(45) NOT NULL,
  `emergency_contact_phone` varchar(45) NOT NULL,
  `emergency_contact_relationship` varchar(45) NOT NULL,
  `start_date` varchar(45) NOT NULL,
  `end_date` varchar(45) DEFAULT NULL,
  `staffnumber` varchar(45) NOT NULL,
  `staffpassword` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (1,'陳*柚','女','F22*****78','1985/04/12','台北市大同區**路*段***號','0937****45','yoyo*****@gmail.com','楊*琴','0975*****9','母女','2002/07/01',NULL,'19070412','0412'),(2,'陳*育','女','F22*****93','1990/08/12','新北市土城區**路**號**樓','0932****75','yuyu*****@yahoo.com.tw','楊*琴','0975*****4','母女','2024/01/01',NULL,'24010812','0812'),(4,'廖*杰','男','J11******64','1983/09/30','台北市中山區**路**段**號','0965****51','jj*****@gmail.com','郭*均','0910*****2','太太','2023/02/01',NULL,'23020930','0930'),(5,'王*南','男','N13*****88','1986/04/26','台北市大安區**路**號**樓','0983****74','k******@gmail.com','梁*家','0974*****4','父子','2022/09/15',NULL,'22090426','0426');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-12 20:49:43
