# DBスキーマ設計書

| DB | スキーマ|
| :---: | :---: |
| library_15 | public |

## テーブル設計

### cataloglist

__資料目録テーブル__  
各種資料を管理する

| # | 列名 | データ型 | 主キー | 制約 | 説明 |
| :---: | :---: | :---: | :---: | :---: | :--- |
| 1 | isbn | text | 〇 |  | ISBN番号<br>を一意に特定する |
| 2 | title | text |  |  | 資料名 |
| 3 | category_code | integer |  | 外部キー(categorylist,category_code) | 分類コード<br>分類コードテーブルと紐づくコード |
| 4 | author | text |  |  | 著者名 |
| 5 | publisher | text |  |  | 出版社名 |
| 6 | publish_date | date |  |  | 出版日 |