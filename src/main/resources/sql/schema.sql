CREATE TABLE thingies
(
    id IDENTITY PRIMARY KEY,
    text VARCHAR(255) NOT NULL
);

INSERT INTO thingies(text)
VALUES ('Frodo lives!')
