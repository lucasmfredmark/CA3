# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: localhost (MySQL 5.5.5-10.1.18-MariaDB)
# Database: ca3
# Generation Time: 2016-12-07 12:09:45 +0000
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



# Dump of table pokemon
# ------------------------------------------------------------

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
