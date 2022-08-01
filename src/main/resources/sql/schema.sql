CREATE TABLE thingies
(
    id IDENTITY PRIMARY KEY,
    text VARCHAR NOT NULL,
    moby BOOLEAN NOT NULL
);

CREATE TABLE authors
(
    id VARCHAR PRIMARY KEY,
    first_name VARCHAR NOT NULL,
    last_name VARCHAR NOT NULL
);

CREATE TABLE books
(
    id VARCHAR PRIMARY KEY,
    author_id VARCHAR REFERENCES authors(id),
    title VARCHAR NOT NULL,
    page_count INTEGER NOT NULL,
    moby BOOLEAN NOT NULL
);
