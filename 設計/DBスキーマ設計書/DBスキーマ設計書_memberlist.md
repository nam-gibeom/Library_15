# DBスキーマ設計書

| DB | スキーマ|
| :---: | :---: |
| library_15 | public |

## テーブル設計

### memberlist

__会員情報テーブル__  
会員情報を記録するテーブル

| # | 列名 | データ型 | 主キー | 制約 | 説明 |
| :---: | :---: | :---: | :---: | :---: | :--- |
| 1 | member_id | serial | 〇 |  | 会員ID<br>を一意に特定する |
| 2 | member_name | text |  |  | 会員名 |
| 3 | member_address | text |  |  | 会員の住所 |
| 4 | member_tel | text |  |  | 会員の電話番号 |
| 5 | member_mail | text |  |  | 会員のメールアドレス |
| 6 | member_birth | text |  |  | 会員の生年月日 |
| 7 | member_registdate | text |  |  | 会員の入会年月日 |
| 8 | member_canceldate | text |  |  | 会員の退会年月日 |