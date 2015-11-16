-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: baza
-- ------------------------------------------------------
-- Server version	5.7.9-log

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
-- Table structure for table `produkty`
--

DROP TABLE IF EXISTS `produkty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produkty` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nazwa` varchar(30) NOT NULL,
  `ilosc` int(11) NOT NULL,
  `vat` float NOT NULL,
  `cena` float NOT NULL,
  `kategoria` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produkty`
--

LOCK TABLES `produkty` WRITE;
/*!40000 ALTER TABLE `produkty` DISABLE KEYS */;
INSERT INTO `produkty` VALUES (1,'Czekolada Milka',10,0.08,2.99,'spozywcze'),(2,'Baton Twix',30,0.08,1.49,'spozywcze'),(3,'Chleb Baltanowski',20,0.05,1.39,'spozywcze'),(4,'Woda niegazowana Cisowianka',18,0.05,0.99,'spozywcze'),(5,'Woda gazowana Cisowianka',18,0.05,1.39,'spozywcze'),(6,'Masło Smakowita',15,0.05,3.49,'spozywcze'),(7,'Margaryna Kasia',15,0.05,2.49,'spozywcze'),(8,'Ser topiony Hochland',30,0.08,1.79,'spozywcze'),(9,'Mleko Laciate',30,0.05,1.99,'spozywcze'),(10,'Bulki',50,0.05,0.39,'spozywcze'),(11,'Krzeslo Verossi',20,0.23,149.99,'meble'),(12,'Stolek Marius',30,0.23,39.99,'meble'),(13,'Biurko Sonoma',10,0.23,359.99,'meble'),(14,'Komoda Olcha',15,0.23,449.99,'meble'),(15,'Polka na sciane Sonoma',35,0.23,69.99,'meble'),(16,'Stol Granas',15,0.23,349.99,'meble'),(17,'Lozko Select hilding',5,0.23,959.99,'meble'),(18,'Kanapa Madryt3',6,0.23,1199.99,'meble'),(19,'Szuflada Gotland',40,0.23,29.99,'meble'),(20,'Lustro Venge',25,0.23,239.99,'meble'),(21,'Proszek do prania Ajax',150,0.08,49.99,'przemyslowe'),(22,'Plyn do mycia naczyn Perla',150,0.08,12.99,'przemyslowe'),(23,'Gabka',250,0.23,0.99,'przemyslowe'),(24,'plyn do plukania Pervoll',150,0.08,24.99,'przemyslowe'),(25,'Plyn do mycia szyb Mr muscle',150,0.08,16.99,'przemyslowe'),(26,'Plyn do podlog Ajax',200,0.08,11.99,'przemyslowe'),(27,'Proszek do prania Vizir',250,0.08,24.99,'przemyslowe'),(28,'Proszek do prania Vanish',250,0.08,32.99,'przemyslowe'),(29,'Mydlo Bialy Jelen',350,0.08,2.59,'przemyslowe'),(30,'Szampon do wlosow Schauma',200,0.23,12.99,'przemyslowe'),(31,'Swietlowka Led 5W/E14 kula',150,0.23,12.99,'elektroniczne'),(32,'Swietlowka, Led 5W/E27 kula',150,0.23,13.99,'elektroniczne'),(33,'Bateria Vipow',400,0.23,1.85,'elektroniczne'),(34,'Interfejs Bluetooth USB',120,0.23,6.99,'elektroniczne'),(35,'Zlaczka SVGA(D-Sub)',200,0.23,7.99,'elektroniczne'),(36,'Wentylator Revoltec',50,0.23,11.99,'elektroniczne'),(37,'Mysz optyczna Simple',30,0.23,10.99,'elektroniczne'),(38,'Mysz optyczna Marvel',30,0.23,12.99,'elektroniczne'),(39,'Odkurzacz USB',50,0.23,4.99,'elektroniczne'),(40,'Odtwarzacz mp3',50,0.23,29.99,'elektroniczne');
/*!40000 ALTER TABLE `produkty` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-16 20:51:37
