CREATE DATABASE  IF NOT EXISTS `mydb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `mydb`;
-- MySQL dump 10.13  Distrib 5.7.9, for osx10.9 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	5.7.13

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
-- Table structure for table `ANWENDER`
--

DROP TABLE IF EXISTS `ANWENDER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ANWENDER` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `benutzername` varchar(3) NOT NULL,
  `passwort` varchar(255) NOT NULL,
  `email` varchar(20) NOT NULL,
  `vorname` varchar(20) DEFAULT NULL,
  `nachname` varchar(20) DEFAULT NULL,
  `job_beschreibung` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `benutzername` (`benutzername`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ANWENDER`
--

LOCK TABLES `ANWENDER` WRITE;
/*!40000 ALTER TABLE `ANWENDER` DISABLE KEYS */;
INSERT INTO `ANWENDER` VALUES (1,'mtc','EuoS6s59ZV9HHOVeNPibG3ej2dBaRFyoKHfdIjW+qlE=','mtc@adorsys.de','Maturin','Tchatchouang','Entwickler'),(2,'stc','EuoS6s59ZV9HHOVeNPibG3ej2dBaRFyoKHfdIjW+qlE=','stc@adorsys.de','Simplice','Tchoupkoua','J2EE Entwickler'),(3,'wch','EuoS6s59ZV9HHOVeNPibG3ej2dBaRFyoKHfdIjW+qlE=','wch@adorsys.de','Willie','Chieukam','Projektleiter & Entwickler'),(4,'sha','EuoS6s59ZV9HHOVeNPibG3ej2dBaRFyoKHfdIjW+qlE=','sha@adorsys.de','Stefan','Hamm','Geschäftsführer');
/*!40000 ALTER TABLE `ANWENDER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ANWENDER_ROLLE`
--

DROP TABLE IF EXISTS `ANWENDER_ROLLE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ANWENDER_ROLLE` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `benutzername` varchar(3) NOT NULL,
  `rolle_id` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `benutzername` (`benutzername`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ANWENDER_ROLLE`
--

LOCK TABLES `ANWENDER_ROLLE` WRITE;
/*!40000 ALTER TABLE `ANWENDER_ROLLE` DISABLE KEYS */;
INSERT INTO `ANWENDER_ROLLE` VALUES (1,'mtc','1'),(2,'stc','2'),(3,'wch','3'),(4,'sha','2');
/*!40000 ALTER TABLE `ANWENDER_ROLLE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ROLLE`
--

DROP TABLE IF EXISTS `ROLLE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ROLLE` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rolle` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ROLLE`
--

LOCK TABLES `ROLLE` WRITE;
/*!40000 ALTER TABLE `ROLLE` DISABLE KEYS */;
INSERT INTO `ROLLE` VALUES (1,'admin'),(2,'mitarbeiter'),(3,'gast');
/*!40000 ALTER TABLE `ROLLE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'mydb'
--

--
-- Dumping routines for database 'mydb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-20 23:48:11
