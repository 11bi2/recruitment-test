/*
SQLyog Community Edition- MySQL GUI v8.0 
MySQL - 5.0.51a-community : Database - cobra
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`cobra` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `cobra`;

/*Table structure for table `antwortmoeglichkeiten` */

DROP TABLE IF EXISTS `antwortmoeglichkeiten`;

CREATE TABLE `antwortmoeglichkeiten` (
  `ID_Antwortmoeglichkeit` int(10) unsigned NOT NULL auto_increment,
  `Aufgaben_ID_Aufgaben` int(11) NOT NULL,
  `Antwortmoeglichkeit1` varchar(200) default NULL,
  `Antwortmoeglichkeit2` varchar(200) default NULL,
  `Antwortmoeglichkeit3` varchar(200) default NULL,
  `Antwortmoeglichkeit4` varchar(200) default NULL,
  `Antwortmoeglichkeit5` varchar(200) default NULL,
  PRIMARY KEY  (`ID_Antwortmoeglichkeit`),
  KEY `Aufgaben_ID_Aufgaben` (`Aufgaben_ID_Aufgaben`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `antwortmoeglichkeiten` */

insert  into `antwortmoeglichkeiten`(`ID_Antwortmoeglichkeit`,`Aufgaben_ID_Aufgaben`,`Antwortmoeglichkeit1`,`Antwortmoeglichkeit2`,`Antwortmoeglichkeit3`,`Antwortmoeglichkeit4`,`Antwortmoeglichkeit5`) values (1,1,'4 Jahre','3 Jahre','5 Jahre','6 Jahre','8 Jahre');

/*Table structure for table `aufgaben` */

DROP TABLE IF EXISTS `aufgaben`;

CREATE TABLE `aufgaben` (
  `ID_Aufgaben` int(10) unsigned NOT NULL auto_increment,
  `Kategorien_ID_Kategorie` int(11) default NULL,
  `Aufgabenstellung` text,
  `Bild` longblob,
  `antwortmoeglichkeiten_ID_Antwortmoeglichkeit` int(11) default NULL,
  PRIMARY KEY  (`ID_Aufgaben`),
  KEY `antwortmoeglichkeiten_ID_Antwortmoeglichkeit` (`antwortmoeglichkeiten_ID_Antwortmoeglichkeit`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `aufgaben` */

insert  into `aufgaben`(`ID_Aufgaben`,`Kategorien_ID_Kategorie`,`Aufgabenstellung`,`Bild`,`antwortmoeglichkeiten_ID_Antwortmoeglichkeit`) values (1,1,'Wie lange ist eine Legislaturperiode des Deutschen Bundestages?',NULL,1);

/*Table structure for table `berufswahl` */

DROP TABLE IF EXISTS `berufswahl`;

CREATE TABLE `berufswahl` (
  `ID_Berufswahl` int(10) unsigned NOT NULL auto_increment,
  `Berufsbeschreibung` int(10) unsigned default NULL,
  `Voraussetzung` int(10) unsigned default NULL,
  PRIMARY KEY  (`ID_Berufswahl`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `berufswahl` */

insert  into `berufswahl`(`ID_Berufswahl`,`Berufsbeschreibung`,`Voraussetzung`) values (1,0,0);

/*Table structure for table `bewerber` */

DROP TABLE IF EXISTS `bewerber`;

CREATE TABLE `bewerber` (
  `ID_Bewerber` int(10) unsigned NOT NULL auto_increment,
  `Berufswahl_ID_Berufswahl` int(10) unsigned NOT NULL,
  `Permissions_ID_Permissions` int(10) unsigned NOT NULL,
  `Vorname` text,
  `Nachname` text,
  `Geburtstag` date default NULL,
  `EMail` text NOT NULL,
  `Permission` int(10) unsigned default NULL,
  `Created` int(10) unsigned default NULL,
  `Freigabe` int(10) unsigned default NULL,
  PRIMARY KEY  (`ID_Bewerber`),
  KEY `Berufswahl_ID_Berufswahl` (`Berufswahl_ID_Berufswahl`),
  KEY `Permissions_ID_Permissions` (`Permissions_ID_Permissions`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `bewerber` */

/*Table structure for table `eingabe` */

DROP TABLE IF EXISTS `eingabe`;

CREATE TABLE `eingabe` (
  `ID_Eingabe` int(10) unsigned NOT NULL auto_increment,
  `Aufgaben_ID_Aufgaben` int(11) NOT NULL,
  `Eingabe` text,
  PRIMARY KEY  (`ID_Eingabe`),
  KEY `Aufgaben_ID_Aufgaben` (`Aufgaben_ID_Aufgaben`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `eingabe` */

/*Table structure for table `kategorien` */

DROP TABLE IF EXISTS `kategorien`;

CREATE TABLE `kategorien` (
  `ID_Kategorien` int(10) unsigned NOT NULL auto_increment,
  `Berufswahl_ID_Berufswahl` int(10) unsigned NOT NULL,
  `Aufgaben_ID_Aufgaben` int(11) NOT NULL,
  `Kategorienbezeichnung` text,
  `Verfuegbare_Zeit` time default NULL,
  PRIMARY KEY  (`ID_Kategorien`),
  KEY `Berufswahl_ID_Berufswahl` (`Berufswahl_ID_Berufswahl`),
  KEY `Aufgaben_ID_Aufgaben` (`Aufgaben_ID_Aufgaben`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `kategorien` */

insert  into `kategorien`(`ID_Kategorien`,`Berufswahl_ID_Berufswahl`,`Aufgaben_ID_Aufgaben`,`Kategorienbezeichnung`,`Verfuegbare_Zeit`) values (1,1,0,'Allgemeinwissen - Politik','00:00:10');

/*Table structure for table `loesung` */

DROP TABLE IF EXISTS `loesung`;

CREATE TABLE `loesung` (
  `ID_Loesung` int(10) unsigned NOT NULL auto_increment,
  `Aufgaben_ID_Aufgaben` int(11) NOT NULL,
  `Loesung` int(11) default NULL,
  PRIMARY KEY  (`ID_Loesung`),
  KEY `Aufgaben_ID_Aufgaben` (`Aufgaben_ID_Aufgaben`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `loesung` */

insert  into `loesung`(`ID_Loesung`,`Aufgaben_ID_Aufgaben`,`Loesung`) values (1,1,4);

/*Table structure for table `permissions` */

DROP TABLE IF EXISTS `permissions`;

CREATE TABLE `permissions` (
  `ID_Permissions` int(10) unsigned NOT NULL auto_increment,
  `description` text,
  PRIMARY KEY  (`ID_Permissions`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `permissions` */

/*Table structure for table `schwierigkeit` */

DROP TABLE IF EXISTS `schwierigkeit`;

CREATE TABLE `schwierigkeit` (
  `ID_Schwierigkeit` int(10) unsigned NOT NULL auto_increment,
  `Aufgaben_ID_Aufgaben` int(11) NOT NULL,
  `erreichte_punktzahl` tinyint(3) unsigned default NULL,
  `moegliche_punktzahl` tinyint(3) unsigned default NULL,
  PRIMARY KEY  (`ID_Schwierigkeit`),
  KEY `Aufgaben_ID_Aufgaben` (`Aufgaben_ID_Aufgaben`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `schwierigkeit` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
