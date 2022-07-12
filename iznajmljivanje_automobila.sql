/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 8.0.26 : Database - iznajmljivanje_automobila
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`iznajmljivanje_automobila` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `iznajmljivanje_automobila`;

/*Table structure for table `automobil` */

DROP TABLE IF EXISTS `automobil`;

CREATE TABLE `automobil` (
  `registracioniBroj` varchar(10) NOT NULL,
  `model` varchar(15) DEFAULT NULL,
  `marka` varchar(15) DEFAULT NULL,
  `tip` int DEFAULT NULL,
  PRIMARY KEY (`registracioniBroj`),
  KEY `tip` (`tip`),
  CONSTRAINT `automobil_ibfk_1` FOREIGN KEY (`tip`) REFERENCES `tipautomobila` (`tipID`) ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `automobil` */

insert  into `automobil`(`registracioniBroj`,`model`,`marka`,`tip`) values 
('BG041KL','Logan','Dacia',1),
('BG120','206','Pezoooo',1),
('BG134','Civic','Honda',3),
('BG1890','XC40','Volvo',4),
('BG556','WRX','Subaru',2),
('BG999','Cupra','SeatTT',3);

/*Table structure for table `korisnik` */

DROP TABLE IF EXISTS `korisnik`;

CREATE TABLE `korisnik` (
  `korisnikID` int NOT NULL,
  `korisnickoIme` varchar(20) DEFAULT NULL,
  `sifra` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`korisnikID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `korisnik` */

insert  into `korisnik`(`korisnikID`,`korisnickoIme`,`sifra`) values 
(1,'admin','admin'),
(2,'akile','123');

/*Table structure for table `potvrdaoiznajmljivanju` */

DROP TABLE IF EXISTS `potvrdaoiznajmljivanju`;

CREATE TABLE `potvrdaoiznajmljivanju` (
  `potvrdaID` int NOT NULL,
  `datumOD` date DEFAULT NULL,
  `datumDO` date DEFAULT NULL,
  `cena` double DEFAULT NULL,
  `automobil` varchar(10) DEFAULT NULL,
  `vozac` int DEFAULT NULL,
  `korisnik` int DEFAULT NULL,
  PRIMARY KEY (`potvrdaID`),
  KEY `automobil` (`automobil`),
  KEY `vozac` (`vozac`),
  KEY `korisnik` (`korisnik`),
  CONSTRAINT `potvrdaoiznajmljivanju_ibfk_1` FOREIGN KEY (`automobil`) REFERENCES `automobil` (`registracioniBroj`) ON UPDATE RESTRICT,
  CONSTRAINT `potvrdaoiznajmljivanju_ibfk_2` FOREIGN KEY (`vozac`) REFERENCES `vozac` (`vozacID`) ON UPDATE RESTRICT,
  CONSTRAINT `potvrdaoiznajmljivanju_ibfk_3` FOREIGN KEY (`korisnik`) REFERENCES `korisnik` (`korisnikID`) ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `potvrdaoiznajmljivanju` */

insert  into `potvrdaoiznajmljivanju`(`potvrdaID`,`datumOD`,`datumDO`,`cena`,`automobil`,`vozac`,`korisnik`) values 
(1,'2022-04-30','2022-05-04',12800,'BG041KL',1,2),
(2,'2022-03-30','2022-03-31',121,'BG041KL',1,2),
(3,'2022-03-29','2022-03-31',1666,'BG556',1,2),
(4,'2022-05-19','2022-05-21',8000,'BG041KL',1,1),
(5,'2022-04-30','2022-05-04',17000,'BG120',1,2),
(6,'2022-07-19','2022-07-30',3434,'BG041KL',1,2),
(7,'2022-07-14','2022-07-15',111,'BG041KL',2,2);

/*Table structure for table `termini_voznje` */

DROP TABLE IF EXISTS `termini_voznje`;

CREATE TABLE `termini_voznje` (
  `potvrdaID` int NOT NULL,
  `redniBroj` int NOT NULL,
  `dan` date DEFAULT NULL,
  `vreme` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`potvrdaID`,`redniBroj`),
  CONSTRAINT `termini_voznje_ibfk_1` FOREIGN KEY (`potvrdaID`) REFERENCES `potvrdaoiznajmljivanju` (`potvrdaID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `termini_voznje` */

insert  into `termini_voznje`(`potvrdaID`,`redniBroj`,`dan`,`vreme`) values 
(1,1,'2022-04-30','16:00'),
(1,2,'2022-05-03','16:00'),
(2,1,'2022-03-31','22:00'),
(3,1,'2022-03-31','22:00'),
(4,1,'2022-05-19','18:00'),
(4,2,'2022-05-21','18:00'),
(5,1,'2022-04-30','16:00'),
(5,2,'2022-05-03','18:00'),
(5,3,'2022-05-01','22:00'),
(6,1,'2022-07-21','16:00'),
(6,2,'2022-07-29','16:00'),
(7,1,'2022-07-14','20:00');

/*Table structure for table `tipautomobila` */

DROP TABLE IF EXISTS `tipautomobila`;

CREATE TABLE `tipautomobila` (
  `tipID` int NOT NULL,
  `nazivTipa` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`tipID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `tipautomobila` */

insert  into `tipautomobila`(`tipID`,`nazivTipa`) values 
(1,'Karavan'),
(2,'Sedan'),
(3,'Hecbek'),
(4,'SUV');

/*Table structure for table `vozac` */

DROP TABLE IF EXISTS `vozac`;

CREATE TABLE `vozac` (
  `vozacID` int NOT NULL,
  `ime` varchar(15) DEFAULT NULL,
  `prezime` varchar(20) DEFAULT NULL,
  `email` varchar(15) DEFAULT NULL,
  `adresa` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`vozacID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `vozac` */

insert  into `vozac`(`vozacID`,`ime`,`prezime`,`email`,`adresa`) values 
(1,'Aleksa','Aleksic','aki1e@gmail.com','Volgina 7'),
(2,'Mirko','Mirkovic','mirko@gmail.com','Beogradska'),
(3,'Milos','Milosevic','milos@gmail.com','Novosadska'),
(4,'Stefan','Stefanovic','stefa@gmail.com','Mirijevska');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
