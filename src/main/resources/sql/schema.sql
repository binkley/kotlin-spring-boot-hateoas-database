CREATE TABLE thingies
(
    id IDENTITY PRIMARY KEY,
    text VARCHAR NOT NULL,
    moby BOOLEAN NOT NULL
);

CREATE TABLE authors
(
    id VARCHAR PRIMARY KEY,
    firstName VARCHAR NOT NULL,
    lastName VARCHAR NOT NULL
);

CREATE TABLE books
(
    id VARCHAR PRIMARY KEY,
    authorId VARCHAR REFERENCES authors(id),
    title VARCHAR NOT NULL,
    pageCount INTEGER NOT NULL,
    moby BOOLEAN NOT NULL
);
