CREATE DATABASE  IF NOT EXISTS `mimiveterinary` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mimiveterinary`;
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
-- Table structure for table `pet`
--

DROP TABLE IF EXISTS `pet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pet` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ownerName` varchar(45) NOT NULL,
  `ownerPhone` varchar(45) NOT NULL,
  `ownerAddress` varchar(45) DEFAULT NULL,
  `petName` varchar(45) NOT NULL,
  `species` varchar(45) NOT NULL,
  `variety` varchar(45) NOT NULL,
  `sex` varchar(45) NOT NULL,
  `birthday` varchar(45) NOT NULL,
  `age` int NOT NULL,
  `sterilization` varchar(45) NOT NULL,
  `color` varchar(45) NOT NULL,
  `feeding` varchar(45) NOT NULL,
  `drugallergy` varchar(45) NOT NULL,
  `drugallergyContent` varchar(45) DEFAULT NULL,
  `noteContent` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='	';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pet`
--

LOCK TABLES `pet` WRITE;
/*!40000 ALTER TABLE `pet` DISABLE KEYS */;
INSERT INTO `pet` VALUES (1,'陳*橙','0937***192','台北市中正區**路**段**號**樓','Orange','','米克斯','公','2023/05/20',1,'是','橘','藥粉','否','','調皮愛叫'),(4,'郭*萱','0973***363','台北市萬華區**路**巷**號**樓','貓咪','cat','mix','girl','2014/09/09',10,'yes','三花','藥丸','no',NULL,NULL),(5,'林*蓉','0966***369','新北市三重區**街**號**樓','momo','犬','瑪爾濟斯','公','2021/06/03',3,'是','','藥粉','否','',''),(7,'朱*貞','0973***555','新北市板橋區**路**段**號**樓','HAPPY','犬','瑪爾濟斯','公','2007/09/12',16,'是','白','藥水','','','無'),(8,'王*涵','0955***456','新北市新莊區**路**段**巷**號**樓之**','丫肥','犬','英國鬥牛犬','公','2010/03/01',14,'是','白','藥丸','','','易中暑，注意補水及室內溫度'),(10,'陳*橙','0937***192','台北市中正區**路**段**號**樓','飯桶','犬','柯基犬','母','2002/04/03',22,'是','三花','藥丸','否','','寵物已死亡'),(11,'陳*橙','0937***192','台北市中正區**路**段**號**樓','皮皮','犬','柯基犬','公','2004/08/01',20,'是','黃白','藥水','否','','已走失'),(12,'李*君','0933***147','新北市三峽區**路**段**巷**號**樓','李馬斯','犬','黃金獵犬','公','2019/01/30',5,'否','黃','藥丸','','',''),(13,'林*如','0955***874','新北市永和區**路**段**號**樓','亮亮','貓','波斯','母','2021/05/21',3,'否','白','藥粉','','',''),(14,'金*珍','0933***741','台北市中山區**街**號**樓','Alex','犬','米格魯','公','2014/07/09',10,'否','花','藥粉','','','超級愛叫'),(15,'王*樹','0935***413','新北市三峽區**路**號','拉拉','貓','金吉拉','公','2023/04/15',1,'否','黑','藥丸','','',''),(16,'鐘*玲','0939***764','新北市土城區**路**段**號**樓之**','DiDi','犬','貴','公','2016/09/12',7,'否','花','藥粉','','',''),(17,'羅*豪','06966***719','台北市松山區**街**號之**','拐拐','貓','扁臉波斯','公','2022/11/04',1,'否','三花','藥粉','','',''),(18,'陳*雲','0974***953','台北市中正區**路**號**樓','亮亮','犬','博美','母','2018/06/02',6,'是','白','藥水','','',''),(19,'陳*品','0973***156','新北市三重區**路**巷**號**樓','momo','貓','米克斯','公','2022/09/14',1,'是','黑','藥粉','','',''),(20,'蔡*文','0912***965','台北市大安區**路**巷**號','天天','貓','米克斯','母','2001/06/08',23,'是','三花','藥粉','','','寵物已死亡'),(21,'王*緯','0987***999','台北市萬華區**路**號**樓之**','地瓜','犬','柯基犬','公','2009/01/09',15,'是','三色','藥丸','','液體麻醉',''),(22,'郭*添','0966***858','新北市板橋區**路**號**樓','艾咪','貓','布偶貓','母','2019/03/29',5,'是','黑','藥粉','是','麻醉相關藥物','脾氣不好，有攻擊性');
/*!40000 ALTER TABLE `pet` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-13 10:01:23
