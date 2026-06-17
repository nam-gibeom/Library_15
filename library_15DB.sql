DROP DATABASE IF EXISTS library_15;
DROP USER IF EXISTS postgre;
CREATE USER postgre WITH PASSWORD 'himitu';
CREATE DATABASE library_15 OWNER postgre ENCODING 'UTF8';
\c sample

DROP TABLE IF EXISTS adminlist;
CREATE TABLE adminlist (
    staff_id INTEGER PRIMARY KEY,
    staff_name TEXT, 
    staff_password INTEGER
);
DROP TABLE IF EXISTS adminlist;
CREATE TABLE cataloglist (
    isbn INTEGER PRIMARY KEY,
    title TEXT, 
    category_code INTEGER,
    author TEXT,
    publisher TEXT,
    publish_date DATE
);

INSERT INTO adminlist VALUES(1, 'ジャン', 1111 );
INSERT INTO adminlist VALUES(2, '平', 2222 );
INSERT INTO adminlist VALUES(3, '高', 3333 );
INSERT INTO adminlist VALUES(4, 'ナム', 4444 );
INSERT INTO adminlist VALUES(5, '若松', 5555 );

ALTER TABLE adminlist OWNER TO postgre;
