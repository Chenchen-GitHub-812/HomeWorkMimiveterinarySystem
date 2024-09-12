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
-- Table structure for table `to_do_table`
--

DROP TABLE IF EXISTS `to_do_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `to_do_table` (
  `number` int NOT NULL AUTO_INCREMENT,
  `adddate` varchar(255) NOT NULL,
  `addtime` varchar(255) NOT NULL,
  `addstaffnumber` varchar(255) NOT NULL,
  `transferto` varchar(255) NOT NULL,
  `content` varchar(255) NOT NULL,
  `finished` varchar(255) DEFAULT NULL,
  `finishedstaffnumber` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`number`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `to_do_table`
--

LOCK TABLES `to_do_table` WRITE;
/*!40000 ALTER TABLE `to_do_table` DISABLE KEYS */;
INSERT INTO `to_do_table` VALUES (1,'2024-09-05','21:00:00','24010812','美容','請早班同事早上9:00到COCO家接他','yes','24010812'),(3,'2024-09-06','15:08:07','24010812','美容','請晚班人員協助將ＹＯＣＯ送回家','yes','24010812'),(4,'2024-09-06','15:12:41','24010812','行政','請行政同事協助美容部購買酒精',NULL,NULL),(5,'2024-09-07','10:07:25','24010812','醫療','請晚班醫師協助施打犬籠1_牛牛的抗生素藥物',NULL,NULL),(6,'2024-09-07','12:14:16','24010812','醫療','明早店貓柳丁要抽血檢查，請晚班同事下班前將柳丁水碗及食物撤掉',NULL,NULL),(7,'2024-09-07','12:27:21','24010812','行政','行政人員請協助商品架庫存盤點',NULL,NULL),(8,'2024-09-07','12:42:24','24010812','美容','請晚班美容人員於19:00將Oma送回家',NULL,NULL),(56,'2024-09-11','12:38:49','24010812','行政','updateOwner 與 updatePet','yes','23020930'),(57,'2024-09-11','12:39:50','24010812','行政','petGrooming',NULL,NULL);
/*!40000 ALTER TABLE `to_do_table` ENABLE KEYS */;
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
