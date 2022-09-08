INSERT INTO root(id, name) VALUES (1, 'Cherry');
INSERT INTO root(id, name) VALUES (2, 'Apple');
INSERT INTO root(id, name) VALUES (3, 'Banana');
INSERT INTO root(id, name) VALUES (4, 'Avocado');
INSERT INTO root(id, name) VALUES (5, 'Strawberry');
INSERT INTO oneentity(id, name) VALUES (200, 'one');
INSERT INTO subentity(id, name, root_id, one_id) VALUES (100, 'pie', 1, 200);
INSERT INTO subentity(id, name, root_id) VALUES (101, 'on top', 1);
INSERT INTO subentity(id, name, root_id) VALUES (102, 'pie', 2);
INSERT INTO subentity(id, name, root_id) VALUES (103, 'cake', 2);
INSERT INTO subentity(id, name, root_id) VALUES (104, 'juice', 2);
INSERT INTO subentity(id, name, root_id) VALUES (105, 'split', 3);
INSERT INTO subentity(id, name, root_id) VALUES (106, 'cake', 3);

