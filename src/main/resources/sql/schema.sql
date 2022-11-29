CREATE TABLE authors
(
    id VARCHAR PRIMARY KEY,
    first_name VARCHAR NOT NULL,
    last_name VARCHAR NOT NULL
);

CREATE TABLE books
(
    id VARCHAR PRIMARY KEY,
    isbn VARCHAR NOT NULL,
    author_id VARCHAR REFERENCES authors(id),
    title VARCHAR NOT NULL,
    pages INTEGER NOT NULL,
    moby BOOLEAN NOT NULL
);
