DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS simulation;
DROP TABLE IF EXISTS admin;

CREATE TABLE user
(
    user_id integer primary key auto_increment,
    email varchar(50) not null,
    password varchar(50) not null,
    token varchar(50)
);

CREATE TABLE simulation
(
    simulation_id integer primary key auto_increment,
    last_input date not null,
    user integer not null,
    foreign key (user) references user(user_id),
    age_aircraft integer not null,
    no_of_passengers integer not null,
    pic_licence varchar(50) not null,
    pic_age integer not null,
    total_hrs integer not null,
    type_hrs integer not null,
    ninety_day_hrs integer not null,
    twenty_eight_day_hrs integer not null,
    day_of_week varchar(10),
    accident_severity varchar(150),
    injury_severity varchar(150),
    probability varchar(150)
);

CREATE TABLE admin
(
    admin_id integer primary key auto_increment,
    email varchar(50) not null,
    password varchar(50) not null,
    token varchar(50)
);

INSERT INTO user (email, password)
VALUES ('adam@gmail.com', 'password1'),
       ('bob@gmail.com', 'password2'),
       ('colin@gmail.com', 'password3');

INSERT INTO simulation (last_input, user, age_aircraft, no_of_passengers, pic_licence, pic_age, total_hrs, type_hrs, ninety_day_hrs, twenty_eight_day_hrs, day_of_week, accident_severity, injury_severity, probability)
VALUES ('2023-01-01', 1, 15, 0, 'student', 21, 35, 35, 24, 8, null, 'Predicted severity class for simulation: non-severe', null, 'Estimated membership probability of the simulation for predicted severity class: 0.64'),
       ('2023-02-02', 2, 25, 1, 'airline transport pilot licence', 52, 10000, 2, 180, 60, 'Wed', null, 'Predicted severity class for simulation: minor/none', 'Estimated membership probability of the simulation for predicted severity class: 0.71'),
       ('2023-03-03', 3, 35, 1, 'private pilot licence', 67, 3000, 2100, 24, 8, null, 'Predicted severity class for simulation: non-severe', null, 'Estimated membership probability of the simulation for predicted severity class: 0.74');

INSERT INTO admin(email, password)
VALUES ('admin1@gmail.com', 'passwordadmin1'),
       ('admin2@gmail.com', 'passwordadmin2');

