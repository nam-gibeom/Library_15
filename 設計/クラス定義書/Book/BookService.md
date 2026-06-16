# Service
## BookService

| package | class | 
| :---: | :---: | 
| la.service | (protected) BookService |

### 機能概要

サーブレットからもらった情報を用いてDAOをインスタンス化し、操作を行わせる機能    
なお、DAOの結果をまたサーブレットに送信する役割である


#### Servlet, DAO, DTO
- BookServlet
- BookDAO
- BookBean

#### エラー制御
エラー発生時はエラーページ(errInternal.jsp)を表示

### フィールド

- BookDAOクラスをもとにするDAO生成

### コンストラクタ

- フィールドのDAOに新しいBookDAOをコンストラクタ化する

<div style="page-break-before:always"></div>




### メソッド

---
<!-- 貸出 -->
#### private List\<貸出台帳Bean> rentBooksByID(int member_id, List\<int> book_id) 
サーブレットからもらった二つの引数と共に、現在の日付と返却期日を自動的に計算して貸出台帳に行を追加する。

##### Service, DTO

- BookDAO
- 貸出台帳Bean

##### 処理の流れ

1. Javaパッケージを用いて当日の日付を変数に保存(current_date)
2. For文を用いてBook_idに対するISBN番号を検索する「__getIsbnByBookId__」
3. ISBNを用いて出版年月日を獲得する「__findPublishDate__」
4. 出版年月日をもとに貸出可能日数を計算する
5. Current_dateに貸出可能日数を足してreturn_deadlineを変数として設定
6. 引数としてもらった2つとCurrent_date、return_deadlineをDAOの「__rentBook__」メソッドを実行してリストを保存
7. 保存されたリストを戻り値として返す
---

<!-- 検索 -->
#### private searchBooks (String type, String value) 


##### Service, DTO

- BookDAO
- 貸出台帳Bean

##### 処理の流れ

1. IF文を使ってtypeによるValueの型を変更する(資料名、ISBNの場合、String ; 資料IDの場合、Int)
   1. 資料IDの場合、ISBNに変換する作業を行う。「__getIsbnByBookId__」
2. 資料名またはISBNを用いてDAOを実行する
   1. 資料名の場合、String type = "title"を変数として保存 
   2. IBSNの場合、String type = "ISBN"を変数として保存
3. DAOの「__getCatalogListInfo__」を実行
4. IF ELSE文を使って貸出日数を（現在の日付ー出版日）が3ヶ月以上の場合15、じゃない場合は10日に設定する。（一つの変数に保存する）
5. 検索された資料の数が二つ以上の場合、For文を使って以下を実行する。
   1. 資料ごとにISBNまた資料名によって「__getBookIdByIsbn__」または「__getBookIdByTitle__」を使って現在の総冊数を保存する。
6. findRentBook（貸出中の冊数）/総冊数として変数に保存
---


