DROP DATABASE IF EXISTS `justWeddings`;
CREATE DATABASE IF NOT EXISTS `justWeddings` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `justWeddings`;

DROP TABLE IF EXISTS `events`;
CREATE TABLE IF NOT EXISTS `events` (
  `id` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `start_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `end_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `all_day` varchar(1) NOT NULL DEFAULT 'N',
  `description` varchar(250) DEFAULT NULL,
  `wedding_id` varchar(36) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_events_wedding` (`wedding_id`),
  CONSTRAINT `FK_events_wedding` FOREIGN KEY (`wedding_id`) REFERENCES `wedding` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `guest`;
CREATE TABLE IF NOT EXISTS `guest` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `LAST_NAME` varchar(255) NOT NULL,
  `ALLERGE` varchar(250) DEFAULT NULL,
  `BUS_REQUIRED` varchar(1) NOT NULL DEFAULT 'N',
  `CONFIRMATION_RECEIVED` varchar(1) NOT NULL DEFAULT 'N',
  `GUESTS_GROUP` varchar(255) DEFAULT NULL,
  `INVITATION_SEND` varchar(1) NOT NULL DEFAULT 'N',
  `INVITED_BY` varchar(255) DEFAULT NULL,
  `SEX` varchar(1) NOT NULL,
  `VEGETARIAN` varchar(1) NOT NULL DEFAULT 'N',
  `WEDDING_ID` varchar(36) NOT NULL,
  `TABLE_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_guest_tables` (`TABLE_ID`),
  KEY `FK_guest_wedding` (`WEDDING_ID`),
  CONSTRAINT `FK_guest_tables` FOREIGN KEY (`TABLE_ID`) REFERENCES `tables` (`id`),
  CONSTRAINT `FK_guest_wedding` FOREIGN KEY (`WEDDING_ID`) REFERENCES `wedding` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `suppliers`;
CREATE TABLE IF NOT EXISTS `suppliers` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(250) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `suppliers4wedding`;
CREATE TABLE IF NOT EXISTS `suppliers4wedding` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SUPPLIER_ID` int(11) NOT NULL,
  `WEDDING_ID` varchar(36) NOT NULL,
  `NAME` varchar(250) NOT NULL,
  `CONFIRMED` varchar(1) NOT NULL DEFAULT 'N',
  `ESTIMATED_PRICE` double NOT NULL DEFAULT '0',
  `FINAL_PRICE` double DEFAULT NULL,
  `AMOUNT_PAID` double DEFAULT NULL,
  `NOTES` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `supplier` (`SUPPLIER_ID`),
  KEY `wedding` (`WEDDING_ID`),
  CONSTRAINT `FK_suppliers4wedding_suppliers` FOREIGN KEY (`SUPPLIER_ID`) REFERENCES `suppliers` (`ID`),
  CONSTRAINT `FK_suppliers4wedding_wedding` FOREIGN KEY (`WEDDING_ID`) REFERENCES `wedding` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tables`;
CREATE TABLE IF NOT EXISTS `tables` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `INVITED_BY` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) NOT NULL,
  `NUMBER` int(11) NOT NULL,
  `TYPE` varchar(1) NOT NULL,
  `X_POSITION` int(11) NOT NULL,
  `Y_POSITION` int(11) NOT NULL,
  `WEDDING_ID` varchar(36) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_tables_wedding` (`WEDDING_ID`),
  CONSTRAINT `FK_tables_wedding` FOREIGN KEY (`WEDDING_ID`) REFERENCES `wedding` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  `LAST_NAME` varchar(255) DEFAULT NULL,
  `SEX` varchar(1) DEFAULT NULL,
  `ADRESS` varchar(255) DEFAULT NULL,
  `BIRTHDAY` datetime DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `TELEPHONE` varchar(255) DEFAULT NULL,
  `THEME` varchar(255) DEFAULT NULL,
  `WEDDING_ID` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_user_wedding` (`WEDDING_ID`),
  CONSTRAINT `FK_user_wedding` FOREIGN KEY (`WEDDING_ID`) REFERENCES `wedding` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `wedding`;
CREATE TABLE IF NOT EXISTS `wedding` (
  `id` varchar(36) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `place` varchar(100) NOT NULL,
  `type` varchar(1) NOT NULL,
  `restaurant` varchar(250) DEFAULT NULL,
  `groom_name` varchar(50) NOT NULL,
  `bride_name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;