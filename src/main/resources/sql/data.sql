-- Thingies
INSERT INTO thingies(text, moby)
VALUES ('Frodo lives!', TRUE);

-- Authors
INSERT INTO authors(id, firstName, lastName)
VALUES ('author-1', 'Joanne', 'Rowling');
INSERT INTO authors(id, firstName, lastName)
VALUES ('author-2', 'Herman', 'Melville');
INSERT INTO authors(id, firstName, lastName)
VALUES ('author-3', 'Anne', 'Rice');

-- Books
INSERT INTO books(id, authorId, title, pageCount, moby)
VALUES ('book-1', 'author-1', 'Harry Potter and the Philosopher''s Stone',
        223, true);
VALUES ('book-2', 'author-2', 'Moby Dick', 635, false);
VALUES ('book-3', 'author-3', 'Interview with the vampire', 371, false);
