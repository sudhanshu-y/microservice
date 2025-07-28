INSERT INTO roles (id, parent_id, name, color) VALUES (1, 0, 'Warrior', 'red');
INSERT INTO roles (id, parent_id, name, color) VALUES (2, 0, 'Wizard', 'green');
INSERT INTO roles (id, parent_id, name, color) VALUES (3, 0, 'Priest', 'white');
INSERT INTO roles (id, parent_id, name, color) VALUES (4, 0, 'Rogue', 'yellow');

INSERT INTO roles (id, parent_id, name, color) VALUES (5, 1, 'Fighter', 'blue');
INSERT INTO roles (id, parent_id, name, color) VALUES (6, 1, 'Paladin', 'lightblue');
INSERT INTO roles (id, parent_id, name, color) VALUES (7, 1, 'Ranger', 'lightgreen');

INSERT INTO roles (id, parent_id, name, color) VALUES (8, 2, 'Mage', 'grey');
INSERT INTO roles (id, parent_id, name, color) VALUES (9, 2, 'Specialist wizard', 'lightgrey');

INSERT INTO roles (id, parent_id, name, color) VALUES (10, 3, 'Cleric', 'red');
INSERT INTO roles (id, parent_id, name, color) VALUES (11, 3, 'Druid', 'green');
INSERT INTO roles (id, parent_id, name, color) VALUES (12, 3, 'Priest of specific mythos', 'white');

INSERT INTO roles (id, parent_id, name, color) VALUES (13, 4, 'Thief', 'yellow');
INSERT INTO roles (id, parent_id, name, color) VALUES (14, 4, 'Bard', 'blue');

INSERT INTO roles (id, parent_id, name, color) VALUES (15, 13, 'Assassin', 'lightblue');

COMMIT;