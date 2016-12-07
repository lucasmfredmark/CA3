# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: localhost (MySQL 5.5.5-10.1.18-MariaDB)
# Database: ca3
# Generation Time: 2016-12-07 11:57:02 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table follow
# ------------------------------------------------------------

DROP TABLE IF EXISTS `follow`;

CREATE TABLE `follow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `me_user_username` varchar(255) DEFAULT NULL,
  `you_user_username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_follow_me_user_username` (`me_user_username`),
  KEY `FK_follow_you_user_username` (`you_user_username`),
  CONSTRAINT `FK_follow_me_user_username` FOREIGN KEY (`me_user_username`) REFERENCES `user` (`username`),
  CONSTRAINT `FK_follow_you_user_username` FOREIGN KEY (`you_user_username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table pokemon
# ------------------------------------------------------------

DROP TABLE IF EXISTS `pokemon`;

CREATE TABLE `pokemon` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pokedex_id` int(11) DEFAULT NULL,
  `fk_user_username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_pokemon_fk_user_username` (`fk_user_username`),
  CONSTRAINT `FK_pokemon_fk_user_username` FOREIGN KEY (`fk_user_username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `pokemon` WRITE;
/*!40000 ALTER TABLE `pokemon` DISABLE KEYS */;

INSERT INTO `pokemon` (`id`, `pokedex_id`, `fk_user_username`)
VALUES
	(1,1,'Lucas'),
	(2,4,'Lucas'),
	(3,7,'Lucas'),
	(4,1,'Patrick'),
	(5,4,'Patrick'),
	(6,7,'Patrick'),
	(7,1,'Thomas'),
	(8,4,'Thomas'),
	(9,7,'Thomas');

/*!40000 ALTER TABLE `pokemon` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `rolename` varchar(255) NOT NULL,
  PRIMARY KEY (`rolename`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;

INSERT INTO `role` (`rolename`)
VALUES
	('Admin'),
	('User');

/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table team
# ------------------------------------------------------------

DROP TABLE IF EXISTS `team`;

CREATE TABLE `team` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `fk_user_username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_team_fk_user_username` (`fk_user_username`),
  CONSTRAINT `FK_team_fk_user_username` FOREIGN KEY (`fk_user_username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `team` WRITE;
/*!40000 ALTER TABLE `team` DISABLE KEYS */;

INSERT INTO `team` (`id`, `name`, `fk_user_username`)
VALUES
	(1,'My awesome team','Lucas'),
	(2,'Team Domination','Patrick'),
	(3,'Team Lars','Thomas');

/*!40000 ALTER TABLE `team` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table team_pokemon
# ------------------------------------------------------------

DROP TABLE IF EXISTS `team_pokemon`;

CREATE TABLE `team_pokemon` (
  `pokemon_id` int(11) NOT NULL,
  `teams_id` int(11) NOT NULL,
  PRIMARY KEY (`pokemon_id`,`teams_id`),
  KEY `FK_team_pokemon_teams_id` (`teams_id`),
  CONSTRAINT `FK_team_pokemon_pokemon_id` FOREIGN KEY (`pokemon_id`) REFERENCES `pokemon` (`id`),
  CONSTRAINT `FK_team_pokemon_teams_id` FOREIGN KEY (`teams_id`) REFERENCES `team` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `team_pokemon` WRITE;
/*!40000 ALTER TABLE `team_pokemon` DISABLE KEYS */;

INSERT INTO `team_pokemon` (`pokemon_id`, `teams_id`)
VALUES
	(1,1),
	(2,1),
	(3,1),
	(4,2),
	(5,2),
	(6,2),
	(7,3),
	(8,3),
	(9,3);

/*!40000 ALTER TABLE `team_pokemon` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `username` varchar(255) NOT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `passwordhash` varchar(255) DEFAULT NULL,
  `points` int(11) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;

INSERT INTO `user` (`username`, `firstname`, `gender`, `lastname`, `passwordhash`, `points`)
VALUES
	('Lucas',NULL,NULL,NULL,'sha1:64000:18:I99jQvIYh5J8md2CnFw0Mo4qoUfJGKWP:/tofGsjTqR7eKMPYvu6jZPKe',0),
	('Patrick',NULL,NULL,NULL,'sha1:64000:18:ORgJ4ICIhHo4wW5FRdgvu8ndPGbP43+D:NGR0O7iZsAniwCdg71ZefDG8',NULL),
	('Thomas',NULL,NULL,NULL,'sha1:64000:18:wrBtd4+bBU3h1DHUDfouu7MEwKJTqZcI:06UjMAJ92eagg4RFpYLMpQLA',NULL);

/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table user_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `roles_rolename` varchar(255) NOT NULL,
  `users_username` varchar(255) NOT NULL,
  PRIMARY KEY (`roles_rolename`,`users_username`),
  KEY `FK_user_role_users_username` (`users_username`),
  CONSTRAINT `FK_user_role_roles_rolename` FOREIGN KEY (`roles_rolename`) REFERENCES `role` (`rolename`),
  CONSTRAINT `FK_user_role_users_username` FOREIGN KEY (`users_username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;

INSERT INTO `user_role` (`roles_rolename`, `users_username`)
VALUES
	('Admin','Lucas'),
	('Admin','Patrick'),
	('Admin','Thomas'),
	('User','Lucas'),
	('User','Patrick'),
	('User','Thomas');

/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
