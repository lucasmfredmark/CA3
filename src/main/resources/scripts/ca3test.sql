USE CA3;
INSERT INTO `ROLE` (`rolename`)
VALUES
	('Admin'),
	('User');

INSERT INTO `ROLE_USER` (`roles_rolename`, `users_username`)
VALUES
	('Admin','Lucas'),
	('Admin','Patrick'),
	('Admin','Thomas');
    
    INSERT INTO `USER` (`username`, `firstname`, `lastname`, `gender`, `passwordhash`, `points`)
VALUES
	('Lucas','Lucas','Fredmark','Male','sha1:64000:18:N6QG2dco4u+Gnpfbx85nUP1iv2UdEl0z:z4v5u/fWFFzSgnTBrCrtFOCB',100),
	('Patrick','Patrick','Johansen','Male','sha1:64000:18:ypldmeTGk7mnDJrkotqM8s1FMD4pqwus:n5fTcltBhyfxrwRjledJ6oQh',100),
	('Thomas','Thomas','Staal','Male','sha1:64000:18:n0lauWKYOJ3FWUJ/C5mlkVV2kVQjGJk2:crKgpou10zkd2rZZkdmT5fBd',100);

INSERT INTO `TEAM` (`name`, `fk_user_username`)
VALUES
('My awesome team', 'Lucas'),
('Total Domination', 'Patrick'),
('Team Lars', 'Thomas');

INSERT INTO `POKEMON` (`pokedex_id`, `fk_user_username`, fk_team_id)
VALUES
(3,'Lucas',1),
(6, 'Lucas', 1),
(9, 'Lucas',1),
(25, 'Lucas',1),
(208, 'Lucas',1),
(150, 'Lucas',1),

(38,'Patrick',2),
(134, 'Patrick', 2),
(169, 'Patrick',2),
(186, 'Patrick',2),
(197, 'Patrick',2),
(208, 'Patrick',2),

(144,'Thomas',3),
(145, 'Thomas', 3),
(146, 'Thomas',3),
(243, 'Thomas',3),
(244, 'Thomas',3),
(245, 'Thomas',3);

INSERT INTO `FOLLOWER` (`fk_user_follow_username`, `fk_user_username`)
VALUES
('Thomas', 'Lucas'),
('Patrick', 'Lucas');
