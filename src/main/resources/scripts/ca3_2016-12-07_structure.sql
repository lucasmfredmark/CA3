# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: localhost (MySQL 5.5.5-10.1.18-MariaDB)
# Database: ca3
# Generation Time: 2016-12-07 12:09:22 +0000
# ************************************************************
USE ca3;

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



# Dump of table role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `rolename` varchar(255) NOT NULL,
  PRIMARY KEY (`rolename`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



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




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
