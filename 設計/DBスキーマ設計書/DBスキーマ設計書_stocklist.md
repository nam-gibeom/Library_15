# DBスキーマ設計書

| DB | スキーマ|
| :---: | :---: |
| library_15 | public |

## テーブル設計

### stocklist

__在庫管理テーブル__  
資料の在庫情報を管理する

| # | 列名 | データ型 | 主キー | 制約 | 説明 |
| :---: | :---: | :---: | :---: | :---: | :--- |
| 1 | book_id | int | 〇 |  | 分類コード<br>を一意に特定する |自動採番
| 2 | isbn | text |  | 外部キー(cataloglist,isbn) | ISBN番号<br>資料目録と紐づくコード |
| 3 | arrival_date | text |  |  | 入荷年月日 |
| 4 | discard_date | text |  |  | 廃棄年月日 |
| 5 | remarks | text |  |  | 備考 |