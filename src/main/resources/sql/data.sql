-- Authors
INSERT INTO authors(id, first_name, last_name)
VALUES ('author-1', 'Joanne', 'Rowling');
INSERT INTO authors(id, first_name, last_name)
VALUES ('author-2', 'Herman', 'Melville');
INSERT INTO authors(id, first_name, last_name)
VALUES ('author-3', 'Anne', 'Rice');

-- Books
INSERT INTO books(id, author_id, title, page_count, moby)
VALUES ('book-1', 'author-1', 'Harry Potter and the Philosopher''s Stone',
        223, true);
INSERT INTO books(id, author_id, title, page_count, moby)
VALUES ('book-2', 'author-2', 'Moby Dick', 635, false);
INSERT INTO books(id, author_id, title, page_count, moby)
VALUES ('book-3', 'author-3', 'Interview with the vampire', 371, false);
