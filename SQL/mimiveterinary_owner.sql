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
-- Table structure for table `owner`
--

DROP TABLE IF EXISTS `owner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `owner` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ownerName` varchar(45) NOT NULL,
  `ownerPhone` varchar(45) NOT NULL,
  `ownerAddress` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `owner`
--

LOCK TABLES `owner` WRITE;
/*!40000 ALTER TABLE `owner` DISABLE KEYS */;
INSERT INTO `owner` VALUES (1,'陳*橙','0937***192','台北市中正區**路**段**號**樓'),(4,'林*蓉','0966***369','新北市三重區**街**號**樓'),(5,'朱*貞','0973***555','新北市板橋區**路**段**號**樓'),(6,'王*涵','0955***456','新北市新莊區**路**段**巷**號**樓之**'),(7,'李*君','0933***147','新北市三峽區**路**段**巷**號**樓'),(8,'林*如','0955***874','新北市永和區**路**段**號**樓'),(9,'金*珍','0933***741','台北市中山區**街**號**樓'),(10,'王*樹','0935***413','新北市三峽區**路**號'),(11,'鐘*玲','0939***764','新北市土城區**路**段**號**樓之**'),(12,'羅*豪','06966***719','台北市松山區**街**號之**'),(13,'陳*雲','0974***953','台北市中正區**路**號**樓'),(14,'郭*萱','0973***363','台北市萬華區**路**巷**號**樓'),(15,'陳*品','0973***156','新北市三重區**路**巷**號**樓'),(16,'蔡*文','0912***965','台北市大安區**路**巷**號'),(17,'王*緯','0987***999','台北市萬華區**路**號**樓之**'),(18,'郭*添','0966***858','新北市板橋區**路**號**樓');
/*!40000 ALTER TABLE `owner` ENABLE KEYS */;
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
