INSERT INTO PEOPLE VALUES (10001, 27,'Chandra');
INSERT INTO PEOPLE VALUES (10002, 36,'Shannon');
INSERT INTO PEOPLE VALUES (10003, 45,'Cheryl');

INSERT INTO SKILLS VALUES (1, 'GOOD', 'Juggling', 10002);
INSERT INTO SKILLS VALUES (2, 'AWESOME', 'Dancing', 10001);
INSERT INTO SKILLS VALUES (3, 'AWESOME', 'Juggling', 10003);
INSERT INTO SKILLS VALUES (4, 'GODLIKE', 'Story-telling', 10002);
INSERT INTO SKILLS VALUES (5, 'GOOD', 'Singing', 10001);

INSERT INTO PARTIES VALUES (1, '2018-01-20','Old Folks Club');
INSERT INTO PARTIES VALUES (2, '2018-01-20', 'Luxury Yacht Party');
	
INSERT INTO PEOPLE_PARTIES VALUES (1, 10001);
INSERT INTO PEOPLE_PARTIES VALUES (2, 10001);
INSERT INTO PEOPLE_PARTIES VALUES (1, 10002);
INSERT INTO PEOPLE_PARTIES VALUES (2, 10003);