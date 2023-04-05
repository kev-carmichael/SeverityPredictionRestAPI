DROP TABLE IF EXISTS user;

CREATE TABLE user
(
    id integer primary key auto_increment,
    email varchar(50) not null
);

INSERT INTO user (email)
VALUES ('adam@gmail.com'),
       ('bob@gmail.com'),
       ('colin@gmail.com');

