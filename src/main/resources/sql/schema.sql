CREATE TABLE thingies
(
    id IDENTITY PRIMARY KEY,
    text VARCHAR(255) NOT NULL,
    moby BOOLEAN NOT NULL
);

INSERT INTO thingies(text, moby)
VALUES ('Frodo lives!', TRUE)
