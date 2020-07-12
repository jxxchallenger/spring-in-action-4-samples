CREATE TABLE spittle (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    message VARCHAR(140) NOT NULL,
    `time` TIMESTAMP NOT NULL,
    latitude DOUBLE,
    longitude DOUBLE
);

CREATE TABLE spitter (
    id IDENTITY,
    username VARCHAR(20) UNIQUE NOT NULL,
    password VARCHAR(20) NOT NULL,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    email VARCHAR(30) NOT NULL
);