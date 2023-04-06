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
    last_input datetime not null,
    target varchar(50) not null,
    no_of_attributes integer not null,
    day_of_week varchar(10),
    accident_severity varchar(50),
    injury_severity varchar(50)
);

INSERT INTO user (email)
VALUES ('adam@gmail.com'),
       ('bob@gmail.com'),
       ('colin@gmail.com');

INSERT INTO simulation (last_input, target, no_of_attributes, day_of_week, accident_severity, injury_severity)
VALUES ('2023-01-01 01:11:11', 'accident severity', 8, null, 'non-severe', null),
       ('2023-02-02 02:22:22', 'injury severity', 9, 'Wednesday', null, 'minor/no injury'),
       ('2023-03-03 03:33:33', 'accident severity', 8, null, 'severe', null);

