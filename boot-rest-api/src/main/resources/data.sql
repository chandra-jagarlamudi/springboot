INSERT INTO PEOPLE (person_id, name, age) VALUES (10001, 'Chandra', 27);
INSERT INTO PEOPLE (person_id, name, age) VALUES (10002, 'Shannon', 36);
INSERT INTO PEOPLE (person_id, name, age) VALUES (10003, 'Cheryl', 45);

INSERT INTO SKILLS (skill_id, person_id, name, level) VALUES (1, 10002, 'GOOD', 'Juggling');
INSERT INTO SKILLS (skill_id, person_id, name, level) VALUES (2, 10001, 'AWESOME', 'Dancing');
INSERT INTO SKILLS (skill_id, person_id, name, level) VALUES (3, 10003, 'AWESOME', 'Juggling');
INSERT INTO SKILLS (skill_id, person_id, name, level) VALUES (4, 10002, 'GODLIKE', 'Story-telling');
INSERT INTO SKILLS (skill_id, person_id, name, level) VALUES (5, 10001, 'GOOD', 'Singing');

INSERT INTO PARTIES (party_id, location, party_date) VALUES (1, 'Old Folks Club', '2018-01-20');
INSERT INTO PARTIES (party_id, location, party_date) VALUES (2, 'Luxury Yacht Party', '2018-01-20');
	
INSERT INTO PEOPLE_PARTIES  (person_id, party_id) VALUES (10001, 1);
INSERT INTO PEOPLE_PARTIES  (person_id, party_id) VALUES (10001, 2);
INSERT INTO PEOPLE_PARTIES  (person_id, party_id) VALUES (10002, 1);
INSERT INTO PEOPLE_PARTIES  (person_id, party_id) VALUES (10003, 2);

INSERT INTO USERS (user_id, username, password, enabled) VALUES ('1', 'chandra@ragas.com', '$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri', true);
INSERT INTO USERS (user_id, username, password, enabled) VALUES ('2', 'shannon@ragas.com', '$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri', true);
INSERT INTO USERS (user_id, username, password, enabled) VALUES ('3', 'cheryl@ragas.com', '$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri', true);