DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    enabled boolean NOT NULL DEFAULT true,
    PRIMARY KEY (username)
);

CREATE TABLE authorities (
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    FOREIGN KEY (username) REFERENCES users(username)
);

INSERT INTO users (username, password, enabled)
VALUES
    ('sergey', '{noop}sergey', true),
    ('elena', '{noop}elena', true),
    ('ivan', '{noop}ivan', true);

INSERT INTO authorities(username, authority)
VALUES
    ('sergey', 'ROLE_EMPLOYEE'),
    ('elena', 'ROLE_HR'),
    ('ivan', 'ROLE_HR'),
    ('ivan', 'ROLE_MANAGER');