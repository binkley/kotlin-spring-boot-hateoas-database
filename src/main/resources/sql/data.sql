-- Authors
INSERT INTO authors(id, first_name, last_name)
VALUES ('author-1', 'Joanne', 'Rowling');
INSERT INTO authors(id, first_name, last_name)
VALUES ('author-2', 'Herman', 'Melville');
INSERT INTO authors(id, first_name, last_name)
VALUES ('author-3', 'Anne', 'Rice');

-- Books
INSERT INTO books(id, isbn, author_id, title, pages, moby)
VALUES ('book-1', '0-00-000000-0', 'author-1',
        'Harry Potter and the Philosopher''s Stone', 223, true);
INSERT INTO books(id, isbn, author_id, title, pages, moby)
VALUES ('book-2', '0-00-000000-1', 'author-2', 'Moby Dick', 635, false);
INSERT INTO books(id, isbn, author_id, title, pages, moby)
VALUES ('book-3', '0-00-000000-0', 'author-3', 'Interview with the vampire',
        371, false);
