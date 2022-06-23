CREATE SEQUENCE hibernate_sequence START 1 INCREMENT 1;

CREATE TABLE student(
        id int NOT NULL,
        first_name text DEFAULT NULL,
        last_name text DEFAULT NULL,
        email text DEFAULT NULL,
        PRIMARY KEY (id)
        );
