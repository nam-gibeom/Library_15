DROP DATABASE IF EXISTS library_15;
DROP USER IF EXISTS postgres;
CREATE USER postgres WITH PASSWORD 'himitu';
CREATE DATABASE library_15 OWNER postgres ENCODING 'UTF8';
\c library_15

DROP TABLE IF EXISTS adminlist;
CREATE TABLE adminlist (
    staff_id INTEGER PRIMARY KEY,
    staff_name TEXT, 
    staff_password TEXT
    );
    


INSERT INTO adminlist VALUES(1, 'ジャン', '1111' );
INSERT INTO adminlist VALUES(2, '平', '2222' );
INSERT INTO adminlist VALUES(3, '高', '3333' );
INSERT INTO adminlist VALUES(4, 'ナム', '4444' );
INSERT INTO adminlist VALUES(5, '若松', '5555' );


DROP TABLE IF EXISTS cataloglist;
CREATE TABLE cataloglist (
    isbn TEXT PRIMARY KEY,
    title TEXT, 
    category_code INTEGER,
    author TEXT,
    publisher TEXT,
    publish_date DATE
);
INSERT INTO cataloglist VALUES('4163918272','センスの哲学',1,'千葉 雅也','文藝春秋',DATE '20240405');


DROP TABLE IF EXISTS categorylist;
CREATE TABLE categorylist(
  category_code SERIAL PRIMARY KEY,
  category_name TEXT
);

INSERT INTO categorylist VALUES(0,'総記');
INSERT INTO categorylist VALUES(1,'哲学');
INSERT INTO categorylist VALUES(2,'歴史');
INSERT INTO categorylist VALUES(3,'社会科学');
INSERT INTO categorylist VALUES(4,'自然科学');
INSERT INTO categorylist VALUES(5,'技術');
INSERT INTO categorylist VALUES(6,'産業');
INSERT INTO categorylist VALUES(7,'芸術');
INSERT INTO categorylist VALUES(8,'言語');
INSERT INTO categorylist VALUES(9,'文学');


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


INSERT INTO memberlist VALUES(1,'山田太郎','〒111-1111東京','000-000-000','a@example.com',DATE '19990102',DATE '20101101',DATE '20131121');
INSERT INTO memberlist VALUES(2,'田中一郎','〒111-1112東京','000-000-111','b@example.com',DATE '20000104',DATE '2012101',DATE '20131202');
INSERT INTO memberlist VALUES(3,'山本次郎','〒111-1113東京','000-000-222','c@example.com',DATE '20010202',DATE '20141101',DATE '20190911');
INSERT INTO memberlist VALUES(4,'羽生 章洋','〒111-1114東京','000-080-222','d@example.com',DATE '20010902',DATE '20240101',DATE '20100911');
INSERT INTO memberlist VALUES(5,'釜本 喜美子','〒111-1113東京','000-001-222','c@example.com',DATE '20010202',DATE '2014101',DATE '20190911');
INSERT INTO memberlist VALUES(6,'安部 弘江','〒111-1113大阪','000-060-222','c@example.com',DATE '20010202',DATE '2014101',DATE '20190911');
INSERT INTO memberlist VALUES(7,'松村 秀和','〒111-1113神戸','000-240-222','c@example.com',DATE '20010202',DATE '2014101',DATE '20190911');
INSERT INTO memberlist VALUES(8,'萩原 恵理子','〒111-1113横浜','240-000-222','c@example.com',DATE '20010202',DATE '2014101',DATE '20190911');
INSERT INTO memberlist VALUES(9,'松田正気','〒111-1113栃木','000-040-222','c@example.com',DATE '20010202',DATE '2014101',DATE '20190911');
INSERT INTO memberlist VALUES(10,'元気太郎','〒111-1113北海道','000-050-222','c@example.com',DATE '20010202',DATE '2014101',DATE '20190911');




ALTER TABLE categorylist OWNER TO postgres;
ALTER TABLE memberlist OWNER TO postgres;
ALTER TABLE adminlist OWNER TO postgres;
ALTER TABLE cataloglist OWNER TO postgres;

DROP TABLE IF EXISTS rentlist;
CREATE TABLE rentlist
(
  rent_id SERIAL PRIMARY KEY,
  member_id INTEGER,
  book_id INTEGER,
  rent_date DATE,
  return_deadline DATE,
  return_date DATE,
  remarks TEXT
);

INSERT INTO rentlist VALUES(1,1, 100, DATE '20040322', DATE '20260617',null,null);
INSERT INTO rentlist VALUES(2,2, 110, DATE '20040422', DATE '20260627',null,null);
INSERT INTO rentlist VALUES(3,3, 120, DATE '20040522', DATE '20260614',null,null);


DROP TABLE IF EXISTS stocklist;
CREATE TABLE stocklist
(
  book_id SERIAL PRIMARY KEY,
  isbn TEXT,
  arrival_date DATE,
  discard_date DATE,
  remarks TEXT
);






INSERT INTO stocklist VALUES(1, '732189',DATE '20260617',null,null);
INSERT INTO stocklist VALUES(2, '479811',DATE '20260617',null,null);
INSERT INTO stocklist VALUES(3, '579831',DATE '20260617',null,null);

ALTER TABLE rentlist OWNER TO postgres;
ALTER TABLE stocklist OWNER TO postgres;

DROP TABLE t1;