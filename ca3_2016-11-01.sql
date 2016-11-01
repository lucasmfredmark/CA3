# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: localhost (MySQL 5.5.5-10.1.18-MariaDB)
# Database: ca3
# Generation Time: 2016-11-01 15:03:23 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table FOLLOWER
# ------------------------------------------------------------

DROP TABLE IF EXISTS `FOLLOWER`;

CREATE TABLE `FOLLOWER` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fk_user_follow_username` varchar(255) DEFAULT NULL,
  `fk_user_username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_FOLLOWER_fk_user_username` (`fk_user_username`),
  KEY `FK_FOLLOWER_fk_user_follow_username` (`fk_user_follow_username`),
  CONSTRAINT `FK_FOLLOWER_fk_user_follow_username` FOREIGN KEY (`fk_user_follow_username`) REFERENCES `USER` (`username`),
  CONSTRAINT `FK_FOLLOWER_fk_user_username` FOREIGN KEY (`fk_user_username`) REFERENCES `USER` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table POKEMON
# ------------------------------------------------------------

DROP TABLE IF EXISTS `POKEMON`;

CREATE TABLE `POKEMON` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pokedex_id` int(11) DEFAULT NULL,
  `fk_user_username` varchar(255) DEFAULT NULL,
  `fk_team_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_POKEMON_fk_user_username` (`fk_user_username`),
  KEY `FK_POKEMON_fk_team_id` (`fk_team_id`),
  CONSTRAINT `FK_POKEMON_fk_team_id` FOREIGN KEY (`fk_team_id`) REFERENCES `TEAM` (`id`),
  CONSTRAINT `FK_POKEMON_fk_user_username` FOREIGN KEY (`fk_user_username`) REFERENCES `USER` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table ROLE
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ROLE`;

CREATE TABLE `ROLE` (
  `rolename` varchar(255) NOT NULL,
  PRIMARY KEY (`rolename`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `ROLE` WRITE;
/*!40000 ALTER TABLE `ROLE` DISABLE KEYS */;

INSERT INTO `ROLE` (`rolename`)
VALUES
	('Admin'),
	('User');

/*!40000 ALTER TABLE `ROLE` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table ROLE_USER
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ROLE_USER`;

CREATE TABLE `ROLE_USER` (
  `roles_rolename` varchar(255) NOT NULL,
  `users_username` varchar(255) NOT NULL,
  PRIMARY KEY (`roles_rolename`,`users_username`),
  KEY `FK_ROLE_USER_users_username` (`users_username`),
  CONSTRAINT `FK_ROLE_USER_roles_rolename` FOREIGN KEY (`roles_rolename`) REFERENCES `ROLE` (`rolename`),
  CONSTRAINT `FK_ROLE_USER_users_username` FOREIGN KEY (`users_username`) REFERENCES `USER` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `ROLE_USER` WRITE;
/*!40000 ALTER TABLE `ROLE_USER` DISABLE KEYS */;

INSERT INTO `ROLE_USER` (`roles_rolename`, `users_username`)
VALUES
	('Admin','Lucas'),
	('Admin','Patrick'),
	('Admin','Thomas');

/*!40000 ALTER TABLE `ROLE_USER` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table TEAM
# ------------------------------------------------------------

DROP TABLE IF EXISTS `TEAM`;

CREATE TABLE `TEAM` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `fk_user_username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_TEAMS_fk_user_username` (`fk_user_username`),
  CONSTRAINT `FK_TEAMS_fk_user_username` FOREIGN KEY (`fk_user_username`) REFERENCES `USER` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table USER
# ------------------------------------------------------------

DROP TABLE IF EXISTS `USER`;

CREATE TABLE `USER` (
  `username` varchar(255) NOT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `passwordhash` varchar(255) DEFAULT NULL,
  `points` int(11) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `USER` WRITE;
/*!40000 ALTER TABLE `USER` DISABLE KEYS */;

INSERT INTO `USER` (`username`, `firstname`, `gender`, `lastname`, `passwordhash`, `points`)
VALUES
	('Lucas','Lucas','Fredmark','Male','sha1:64000:18:N6QG2dco4u+Gnpfbx85nUP1iv2UdEl0z:z4v5u/fWFFzSgnTBrCrtFOCB',NULL),
	('Patrick','Patrick','Johansen','Male','sha1:64000:18:ypldmeTGk7mnDJrkotqM8s1FMD4pqwus:n5fTcltBhyfxrwRjledJ6oQh',NULL),
	('Thomas','Thomas','Staal','Male','sha1:64000:18:n0lauWKYOJ3FWUJ/C5mlkVV2kVQjGJk2:crKgpou10zkd2rZZkdmT5fBd',NULL);

/*!40000 ALTER TABLE `USER` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
