# DBスキーマ設計書

| DB | スキーマ|
| :---: | :---: |
| library_15 | public |

## テーブル設計

### rentlist

__貸出管理テーブル__  
貸出情報を管理する

| # | 列名 | データ型 | 主キー | 制約 | 説明 |
| :---: | :---: | :---: | :---: | :---: | :--- |
| 1 |rent_id | serial | 〇 |  |  |
| 2 | member_id | integer |  | 外部キー(memberlist,member_id) | 会員ID<br>会員情報テーブルと紐づくコード |
| 3 | book_id | integer |  | 外部キー(stocklist,book_id) | 資料ID<br>在庫管理テーブルと紐づくコード |
| 4 | rent_date | date |  |  | 貸出年月日 |
| 5 | return_deadline | date |  |  | 返却期日 |
| 6 | return_date | date |  |  | 返却年月日 |
| 7 | remarks | text |  |  | 備考 |