DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS simulation;

CREATE TABLE user
(
    user_id integer primary key auto_increment,
    email varchar(50) not null
);

CREATE TABLE simulation
(
    simulation_id integer primary key auto_increment,
    last_input datetime not null
);

INSERT INTO user (email)
VALUES ('adam@gmail.com'),
       ('bob@gmail.com'),
       ('colin@gmail.com');

INSERT INTO simulation (last_input)
VALUES ('2023-01-01 01:11:11'),
       ('2023-02-02 02:22:22'),
       ('2023-03-03 03:33:33');

