DROP TABLE IF EXISTS rentlist;
DROP TABLE IF EXISTS stocklist;

CREATE TABLE rentlist
(
  member_id INTEGER SERIAL PRIMARY KEY,
  book_id INTEGER,
  rent_date DATE,
  return_deadline DATE,
  return_date DATE,
  note TEXT
);
CREATE TABLE stocklist
(
  book_id SERIAL PRIMARY KEY,
  isbn TEXT
  arrival_date DATE
  discard_date DATE
  note RETURN
);




INSERT INTO rentlist(member_id, book_id, rent_date, return_deadline, return_date, note) VALUES(1, 100, DATE '2004-03-22', DATE '2026-06-17',DATE '','');
INSERT INTO rentlist(member_id, book_id, rent_date, return_deadline, return_date, note) VALUES(2, 110, DATE '2004-04-22', DATE '2026-06-27',DATE '','');
INSERT INTO rentlist(member_id, book_id, rent_date, return_deadline, return_date, note) VALUES(3, 120, DATE '2004-05-22', DATE '2026-06-14',DATE '','');

INSERT INTO rentlist(book_id, isbn, arrival_date, discard_date, note) VALUES(1, 732189,DATE '2026-06-17',DATE '','');
INSERT INTO rentlist(book_id, isbn, arrival_date, discard_date, note) VALUES(1, 479811,DATE '2026-06-17',DATE '','');
INSERT INTO rentlist(book_id, isbn, arrival_date, discard_date, note) VALUES(1, 579831,DATE '2026-06-17',DATE '','');

ALTER TABLE rentlist OWNER TO postgres;
ALTER TABLE stocklist OWNER TO postgres;

