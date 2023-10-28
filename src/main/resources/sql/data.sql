-- Authors
INSERT INTO authors(id, first_name, last_name)
VALUES ('author-1', 'Joanne', 'Rowling');
INSERT INTO authors(id, first_name, last_name)
VALUES ('author-2', 'Herman', 'Melville');
INSERT INTO authors(id, first_name, last_name)
VALUES ('author-3', 'Anne', 'Rice');
INSERT INTO authors(id, first_name, last_name)
VALUES ('author-4', 'Liu', 'Cixin');
INSERT INTO authors(id, first_name, last_name)
VALUES ('author-5', 'John', 'Tolkien');

-- Books
INSERT INTO books(id, isbn, author_id, title, pages, moby)
VALUES ('book-1', '978-1-408855-652', 'author-1',
        'Harry Potter and the Philosopher''s Stone', 223, true);
INSERT INTO books(id, isbn, author_id, title, pages, moby)
VALUES ('book-2', '978-0-486432-151', 'author-2', 'Moby-Dick', 635, false);
INSERT INTO books(id, isbn, author_id, title, pages, moby)
VALUES ('book-3', '978-0-345337-665', 'author-3', 'Interview with the vampire',
        371, false);
INSERT INTO books(id, isbn, author_id, title, pages, moby)
VALUES ('book-4', '978-1-250254-498', 'author-4', 'Three-Body Problem', 1515,
        true);
INSERT INTO books(id, isbn, author_id, title, pages, moby)
VALUES ('book-5', '978-0-048231-253', 'author-5',
        'Farmer Giles of Ham / The Adventures of Tom Bombadil', 144,
        true);
