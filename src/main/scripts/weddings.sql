<<<<<<< Updated upstream
-- Volcando estructura de base de datos para justWeddings
DROP DATABASE IF EXISTS `justWeddings`;
CREATE DATABASE IF NOT EXISTS `justWeddings` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `justWeddings`;

-- Volcando estructura para tabla justWeddings.events
=======
-- Volcando estructura de base de datos para justweddings
DROP DATABASE IF EXISTS `justweddings`;
CREATE DATABASE IF NOT EXISTS `justweddings` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `justweddings`;

-- Volcando estructura para tabla justweddings.events
>>>>>>> Stashed changes
DROP TABLE IF EXISTS `events`;
CREATE TABLE IF NOT EXISTS `events` (
  `id` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `start_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `end_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `all_day` varchar(1) NOT NULL,
  `description` varchar(250) DEFAULT NULL,
  `wedding_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

<<<<<<< Updated upstream
-- La exportaci髇 de datos fue deseleccionada.
-- Volcando estructura para tabla justWeddings.guest
=======
-- La exportaci贸n de datos fue deseleccionada.
-- Volcando estructura para tabla justweddings.guest
>>>>>>> Stashed changes
DROP TABLE IF EXISTS `guest`;
CREATE TABLE IF NOT EXISTS `guest` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `LAST_NAME` varchar(255) NOT NULL,
  `ALLERGE` varchar(250) DEFAULT NULL,
  `BUS_REQUIRED` varchar(1) NOT NULL DEFAULT 'N',
  `CONFIRMATION_RECEIVED` varchar(1) NOT NULL DEFAULT 'N',
  `GUESTS_GROUP` varchar(255) DEFAULT NULL,
  `INVITATION_SEND` varchar(1) NOT NULL,
  `INVITED_BY` varchar(255) DEFAULT NULL,
  `SEX` varchar(1) NOT NULL,
  `VEGETARIAN` varchar(1) NOT NULL DEFAULT 'N',
  `USER_ID` int(11) NOT NULL,
  `TABLE_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8e9o3v3wtkv1ij401d9ljc9ag` (`USER_ID`),
  KEY `FK_guest_tables` (`TABLE_ID`),
  CONSTRAINT `FK8e9o3v3wtkv1ij401d9ljc9ag` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`ID`),
  CONSTRAINT `FK_guest_tables` FOREIGN KEY (`TABLE_ID`) REFERENCES `tables` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

<<<<<<< Updated upstream
-- La exportaci髇 de datos fue deseleccionada.
-- Volcando estructura para tabla justWeddings.tables
=======
-- La exportaci贸n de datos fue deseleccionada.
-- Volcando estructura para tabla justweddings.outlays
DROP TABLE IF EXISTS `outlays`;
CREATE TABLE IF NOT EXISTS `outlays` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(250) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- La exportaci贸n de datos fue deseleccionada.
-- Volcando estructura para tabla justweddings.outlays4wedding
DROP TABLE IF EXISTS `outlays4wedding`;
CREATE TABLE IF NOT EXISTS `outlays4wedding` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `OUTLAY_ID` int(11) NOT NULL,
  `WEDDING_ID` varchar(36) NOT NULL,
  `NAME` varchar(250) NOT NULL,
  `CONFIRMED` varchar(1) NOT NULL DEFAULT 'N',
  `ESTIMATED_PRICE` double NOT NULL DEFAULT '0',
  `FINAL_PRICE` double DEFAULT NULL,
  `AMOUNT_PAID` double DEFAULT NULL,
  `NOTES` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `supplier` (`OUTLAY_ID`),
  KEY `wedding` (`WEDDING_ID`),
  CONSTRAINT `FK_suppliers4wedding_suppliers` FOREIGN KEY (`OUTLAY_ID`) REFERENCES `outlays` (`ID`),
  CONSTRAINT `FK_suppliers4wedding_wedding` FOREIGN KEY (`WEDDING_ID`) REFERENCES `wedding` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- La exportaci贸n de datos fue deseleccionada.
-- Volcando estructura para tabla justweddings.tables
>>>>>>> Stashed changes
DROP TABLE IF EXISTS `tables`;
CREATE TABLE IF NOT EXISTS `tables` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `INVITED_BY` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `NUMBER` int(11) DEFAULT NULL,
  `TYPE` varchar(1) DEFAULT NULL,
  `X_POSITION` int(11) DEFAULT NULL,
  `Y_POSITION` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

<<<<<<< Updated upstream
-- La exportaci髇 de datos fue deseleccionada.
-- Volcando estructura para tabla justWeddings.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  `LAST_NAME` varchar(255) DEFAULT NULL,
  `SEX` varchar(1) DEFAULT NULL,
=======
-- La exportaci贸n de datos fue deseleccionada.
-- Volcando estructura para tabla justweddings.users
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `EMAIL` varchar(255) NOT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  `NAME` varchar(255) NOT NULL,
  `LAST_NAME` varchar(255) NOT NULL,
  `SEX` varchar(1) NOT NULL,
>>>>>>> Stashed changes
  `ADRESS` varchar(255) DEFAULT NULL,
  `BIRTHDAY` datetime NOT NULL,
  `TELEPHONE` varchar(255) NOT NULL,
  `THEME` varchar(255) DEFAULT NULL,
<<<<<<< Updated upstream
  `WEDDING_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
=======
  `WEDDING_ID` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`EMAIL`),
>>>>>>> Stashed changes
  KEY `FK_user_wedding` (`WEDDING_ID`),
  CONSTRAINT `FK_user_wedding` FOREIGN KEY (`WEDDING_ID`) REFERENCES `wedding` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

<<<<<<< Updated upstream
-- La exportaci髇 de datos fue deseleccionada.
-- Volcando estructura para tabla justWeddings.wedding
=======
-- La exportaci贸n de datos fue deseleccionada.
-- Volcando estructura para tabla justweddings.wedding
>>>>>>> Stashed changes
DROP TABLE IF EXISTS `wedding`;
CREATE TABLE IF NOT EXISTS `wedding` (
  `id` int(11) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `place` varchar(100) NOT NULL,
  `type` varchar(1) NOT NULL,
  `restaurant` varchar(250) DEFAULT NULL,
  `groom_name` varchar(50) NOT NULL,
  `bride_name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;