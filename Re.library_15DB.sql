DROP DATABASE IF EXISTS library_15;
DROP USER IF EXISTS postgres;
CREATE USER postgres WITH PASSWORD 'himitu';
CREATE DATABASE library_15 OWNER postgres ENCODING 'UTF8';
\c library_15

DROP TABLE IF EXISTS adminlist;
CREATE TABLE adminlist (
    staff_id INTEGER PRIMARY KEY,
    staff_name TEXT, 
    staff_password INTEGER
    );
    

ALTER TABLE adminlist ALTER COLUMN staff_name SET NOT NULL;
ALTER TABLE adminlist ALTER COLUMN staff_password SET NOT NULL;

INSERT INTO adminlist VALUES(1, 'ジャン', 1111 );
INSERT INTO adminlist VALUES(2, '平', 2222 );
INSERT INTO adminlist VALUES(3, '高', 3333 );
INSERT INTO adminlist VALUES(4, 'ナム', 4444 );
INSERT INTO adminlist VALUES(5, '若松', 5555 );


DROP TABLE IF EXISTS cataloglist;
CREATE TABLE cataloglist (
    isbn INTEGER PRIMARY KEY,
    title TEXT, 
    category_code INTEGER,
    author TEXT,
    publisher TEXT,
    publish_date DATE
);



DROP TABLE IF EXISTS categorylist;
CREATE TABLE categorylist(
  category_code SERIAL PRIMARY KEY,
  category_name TEXT
);
DROP TABLE IF EXISTS memberlist;
CREATE TABLE memberlist(
  member_id SERIAL PRIMARY KEY,
  member_name TEXT,
  member_address TEXT,
  member_tel TEXT,
  member_mail TEXT,
  member_birth DATE,
  member_registdate DATE,
  member_canceldate DATE
);




ALTER TABLE categorylist OWNER TO postgres;
ALTER TABLE memberlist OWNER TO postgres;
ALTER TABLE adminlist OWNER TO postgres;
ALTER TABLE cataloglist OWNER TO postgres;

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
ALTER TABLE rentlist OWNER TO postgres;


CREATE TABLE stocklist
(
  book_id SERIAL PRIMARY KEY,
  isbn TEXT
  arrival_date DATE
  discard_date DATE
  note RETURN
);
ALTER TABLE stocklist OWNER TO postgres;
INSERT INTO rentlist VALUES(1, 100, DATE '2004-03-22', DATE '2026-06-17',null,null);
INSERT INTO rentlist VALUES(2, 110, DATE '2004-04-22', DATE '2026-06-27',null,null);
INSERT INTO rentlist VALUES(3, 120, DATE '2004-05-22', DATE '2026-06-14',null,null);

INSERT INTO rentlist(book_id, isbn, arrival_date, discard_date, note) VALUES(1, 732189,DATE '2026-06-17',null,null);
INSERT INTO rentlist(book_id, isbn, arrival_date, discard_date, note) VALUES(1, 479811,DATE '2026-06-17',null,null);
INSERT INTO rentlist(book_id, isbn, arrival_date, discard_date, note) VALUES(1, 579831,DATE '2026-06-17',null,null);