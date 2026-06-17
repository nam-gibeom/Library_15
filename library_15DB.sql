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
INSERT INTO cataloglist VALUES('9784101373713', 'イチローの流儀', 0, '小西慶三／著', '新潮社', DATE'20260401');
INSERT INTO cataloglist VALUES('9784480081377', '存在と時間 上', 1, 'Heidegger,Martin／著 細谷貞雄／翻訳 ハイデッガーマルティン／著', '筑摩書房', DATE'19940601');
INSERT INTO cataloglist VALUES('9784532176204', '自壊の病理 日本陸軍の組織分析', 2, '戸部良一／著', '日本経済新聞出版社', DATE'20170427');
INSERT INTO cataloglist VALUES('9784106038280', '経済学者たちの日米開戦', 1, '牧野邦昭／著', '新潮社', DATE'2018-05-25');
INSERT INTO cataloglist VALUES('9784844607656', '知るほど楽しい鎌倉時代', 2, '中西立太／著 多賀譲治／著', '理工図書', DATE'20110101');
INSERT INTO cataloglist VALUES('9784000613156', '社会科学と因果分析', 3, '佐藤俊樹／著', '岩波書店', '20190130');
INSERT INTO cataloglist VALUES('9784766425659', '制度とは何か', 3, 'フランチェスコ・グァラ／著 瀧澤弘和／著 水野孝之／翻訳', '慶應義塾大学出版会', DATE'20181113');
INSERT INTO cataloglist VALUES('9784595315848', '自然科学はじめの一歩', 4, '大森聡一／著 岸根順一郎／著', '放送大学教育振興会 : NHK出版', DATE'20150301');
INSERT INTO cataloglist VALUES('9784130420679', '基礎統計学 3 (自然科学の統計学)', 4, '東京大学／著 東京大学教養学部統計学教室／著', '東京大学出版会', DATE'19920801');
INSERT INTO cataloglist VALUES('9784860645274', '「物理・化学」の単位・記号がまとめてわかる事典', 4, '齋藤勝裕／著', 'ベレ出版', DATE'20171023');
INSERT INTO cataloglist VALUES('9784822255923', '日経テクノロジー展望2019 世界をつなぐ 100の技術', 5, '日経BP社／著', '日経ＢＰ', DATE'20181026');
INSERT INTO cataloglist VALUES('9784774142043', 'Webを支える技術 : HTTP、URI、HTML、そしてREST', 5, '山本陽平／著', '技術評論社', DATE'20260501');
INSERT INTO cataloglist VALUES('9784806530008', '新産業構造ビジョン　一人ひとりの、世界の課題を解決する日本の未来', 6, '経済産業省経済産業政策局産業再生課／編集', '経済産業調査会', DATE'20170912');
INSERT INTO cataloglist VALUES('9784532321116', '第四次産業革命', 6, 'クラウス・シュワブ／著 世界経済フォーラム／翻訳', '日本経済新聞出版社', DATE'20161018');
INSERT INTO cataloglist VALUES('9784295402008', 'テクノロジーがすべてを塗り変える産業地図', 6, '泉田良輔／著', 'クロスメディア・パブリッシング;インプレス(発売)', DATE'20180701');
INSERT INTO cataloglist VALUES('9784772695336', '言語が違えば、世界も違って見えるわけ', 7, 'Deutscher,Guy／著 椋田直子／翻訳 ドイッチャーガイ／著', 'インターシフト : 合同出版', DATE'20121201');
INSERT INTO cataloglist VALUES('9784409100400', 'アートとは何か 芸術の存在論と目的論', 8, 'アーサー・Ｃ・ダントー／著 佐藤一進／著', '人文書院', DATE'20181128',);
INSERT INTO cataloglist VALUES('9784416718025', '文学理論講義 新しいスタンダード', 9, 'ピーター・バリー／著 高橋和久／監修', 'ミネルヴァ書房', DATE'20250501');


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


INSERT INTO memberlist VALUES(1,'山田太郎','〒111-1111東京','000-000-000','a@example.com',DATE '19990102',DATE '2010101',DATE '20131121');
INSERT INTO memberlist VALUES(2,'田中一郎','〒111-1112東京','000-000-111','b@example.com',DATE '20000104',DATE '2012101',DATE '20131202');
INSERT INTO memberlist VALUES(3,'山本次郎','〒111-1113東京','000-000-222','c@example.com',DATE '20010202',DATE '2014101',DATE '20190911');

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