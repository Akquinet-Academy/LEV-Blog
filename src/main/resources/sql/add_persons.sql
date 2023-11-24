DELETE FROM character;
DELETE FROM actor;

ALTER SEQUENCE actor_id_seq RESTART WITH 1;
ALTER SEQUENCE character_id_seq RESTART WITH 1;

INSERT INTO actor(first_name, last_name, date_of_birth)
VALUES ('John', 'Doe', '1979-01-03'),
       ('Jane', 'Doe', '1981-08-27');

INSERT INTO character (first_name, last_name, actor_id)
VALUES ('James', 'Jekyll', NULL),
       ('Jenny', 'Hyde', NULL);