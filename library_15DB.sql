DROP DATABASE IF EXISTS library_15;
DROP USER IF EXISTS postgre;
CREATE USER postgre WITH PASSWORD 'himitu';
CREATE DATABASE library_15 OWNER postgre ENCODING 'UTF8';
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
    isbn TEXT PRIMARY KEY,
    title TEXT, 
    category_code INTEGER,
    author TEXT,
    publisher TEXT,
    publish_date DATE
);
INSERT INTO cataloglist VALUES('1234567890','開発演習',1,'ジャン','チームやろう',DATE'2026-06-17');


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

INSERT INTO categorylist VALUES(0,'総記');
INSERT INTO categorylist VALUES(1,'哲学');
INSERT INTO categorylist VALUES(2,'哲学');


INSERT INTO memberlist VALUES(1,'山田太郎','〒111-1111東京','000-000-000','a@example.com',DATE '1999-01-02',DATE '2010-1-01',DATE '2013-11-21');
INSERT INTO memberlist VALUES(2,'田中一郎','〒111-1112東京','000-000-111','b@example.com',DATE '2000-01-04',DATE '2012-1-01',DATE '2013-12-02');
INSERT INTO memberlist VALUES(3,'山本次郎','〒111-1113東京','000-000-222','c@example.com',DATE '2001-02-02',DATE '2014-1-01',DATE '2019-09-11');

ALTER TABLE categorylist OWNER TO postgre;
ALTER TABLE memberlist OWNER TO postgre;
ALTER TABLE adminlist OWNER TO postgre;
ALTER TABLE cataloglist OWNER TO postgre;

DROP TABLE IF EXISTS rentlist;
CREATE TABLE rentlist
(
  member_id SERIAL PRIMARY KEY,
  book_id INTEGER,
  rent_date DATE,
  return_deadline DATE,
  return_date DATE,
  remarks TEXT
);

DROP TABLE IF EXISTS stocklist;
CREATE TABLE stocklist
(
  book_id SERIAL PRIMARY KEY,
  isbn TEXT,
  arrival_date DATE,
  discard_date DATE,
  remarks TEXT
);




INSERT INTO rentlist VALUES(1, 100, DATE '2004-03-22', DATE '2026-06-17',null,null);
INSERT INTO rentlist VALUES(2, 110, DATE '2004-04-22', DATE '2026-06-27',null,null);
INSERT INTO rentlist VALUES(3, 120, DATE '2004-05-22', DATE '2026-06-14',null,null);

INSERT INTO stocklist VALUES(1, '732189',DATE '2026-06-17',null,null);
INSERT INTO stocklist VALUES(2, '479811',DATE '2026-06-17',null,null);
INSERT INTO stocklist VALUES(3, '579831',DATE '2026-06-17',null,null);

ALTER TABLE rentlist OWNER TO postgres;
ALTER TABLE stocklist OWNER TO postgres;