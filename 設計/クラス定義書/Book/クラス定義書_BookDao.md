****# DAO

## BookDAO
資料情報のデータ操作をするためのDAOクラス

| package | class |
|:---:|:---:|
| la.dao | (public) BookDAO |

### 機能概要


#### データ操作
PostgreSQLに対して資料情報のデータ操作をする  
DBの設定は下記の通り

##### DB設定
| データベース名 | ユーザ名 | パスワード |
| :---: | :---: | :---: |
| library_15 | postgres | himitu |

##### テーブル一覧
| # | テーブル名 |
| :---: | :---: |
| 1 | categorylist |
| 2 | memberlist |
| 3 | cataloglist |
| 4 | stocklist |
| 5 | rentlist |
| 6 | adminlist |


#### JavaBeans
データベースから取得したデータは以下のJavaBeansに格納する

- BookBean

#### エラー処理
内部で発生したエラーは以下の例外に読み替えてスローする

- DAOException

### フィールド

#### private String url
JDBCの接続に必要なURL、"jdbc:postgresql:library_15"で初期化
#### private String user
JDBCの接続に必要なユーザーID、"postgres"で初期化
#### private String pass
JDBCの接続に必要なパスワード、"himitu"で初期化


### コンストラクタ

#### public BookDAO() throws DAOException
このコンストラクターが呼び出されるとPostgreSQLのドライバーが登録される

### メソッド

<!-- ISBNを用いて出版日を獲得 -->
#### public String findPublishDate(String isbn) throws DAOException
指定されたISBN番号に属する資料の出版日を取得する  

- 戻り値
    - public String
        - 指定されたISBN番号に属する資料の出版日
- 引数
    - String isbn
        - ISBN番号
- 使用するSQL
    - __SELECT publish_date FROM cataloglist WHERE  isbn = ?__

cataloglistテーブルから取得したレコードは、BookBeanのArrayListに格納して返す
		
##### メソッドの流れ

```java
// SQL文の作成
// コネクションを確立する（フィールドを使用）
// PreparedStatementオブジェクトの取得
// 引数で与えられたカテゴリコードをPreparedStatementオブジェクトに設定する
// SQLの実行
// 出版年月日を返す。
```




<!-- 延滞日数を表示 -->
#### public List\<BookBean> calDelay() throws DAOException
延滞日数を計算

- 戻り値
    - public List \<BookBean>
        - 指定された会員番号に属する貸出中の資料の貸出履歴のリスト
- 引数
    - なし
- 使用するSQL
    - __SELECT CURRENT_DATE - return_deadline AS days_diff FROM rentlist　where day_diff > 0__

rentlistテーブルから取得したレコードは、BookBeanのArrayListに格納して返す
		
##### メソッドの流れ

```java
// SQL文の作成
// コネクションを確立する（フィールドを使用）
// PreparedStatementオブジェクトの取得
// 引数で与えられたカテゴリコードをPreparedStatementオブジェクトに設定する
// SQLの実行
// ItemBeanのArrayListオブジェクトの作成
while (レコードが存在する間レコードの取得) {
   // レコードをItemBeanに格納
   // ItemBeanをリストに追加
}
// リストを返す
```




<!-- 現在貸出中の資料のID (上のfindinfoと重複)-->
 #### public List\<BookBean> findRentBook(int book_id) throws DAOException
指定された資料IDの貸出中の資料情報を取得する  

- 戻り値
    - public List \<BookBean>
        - 指定された資料IDの貸出中の資料情報を取得したリスト
- 引数
    - int book_id
        - 資料ID
- 使用するSQL
    - __SELECT book_id FROM rentlist WHERE book_id = ? AND return_date is null__

cataloglistテーブルから取得したレコードは、BookBeanのArrayListに格納して返す
		
##### メソッドの流れ

```java
// SQL文の作成
// コネクションを確立する（フィールドを使用）
// PreparedStatementオブジェクトの取得
// 引数で与えられたカテゴリコードをPreparedStatementオブジェクトに設定する
// SQLの実行
// ItemBeanのArrayListオブジェクトの作成
while (レコードが存在する間レコードの取得) {
   // レコードをItemBeanに格納
   // ItemBeanをリストに追加
}
// リストを返す
```


<!-- 在庫台帳に本を登録 （資料登録のうち、両方の登録ボタン押したら実行されること）O -->
#### public void addStock(String isbn,date arrival_date) throws DAOException
資料を在庫台帳に新規登録する

- 戻り値
    - なし
- 引数
    - String isbn
        - ISBN番号
    - date arrival_date
        - 入荷年月日
- 使用するSQL
    - __insert into stocklist(isbn,arrival_date) values(?,current_date)__


##### メソッドの流れ

```java
// SQL文の作成
// コネクションを確立する（フィールドを使用）
// PreparedStatementオブジェクトの取得
// 引数で与えられたアイテムコードをPreparedStatementオブジェクトに設定する
// SQLの実行
// ItemBeanのArrayListオブジェクトの作成
if (レコードが存在する) {
    // レコードをItemBeanに格納
    // レコードを格納したItemBeanを返す
}
else {
   // nullを返す
}
```

<!-- 資料目録に新規資料を登録するためのメソッド（登録のうち、したのボタンだけ実行される） O -->
#### public void addCatalog(String isbn, String title, int category_code, String writer, String publisher, date publish_date) throws DAOException
資料を在庫台帳に新規登録する

- 戻り値
    - なし
- 引数
    - String isbn
        - ISBN番号
    - String title
        - 入荷年月日
    - int category_code
        - 分類コード
    - String writer
        - 著者
    - String publisher
        - 出版社
    - date publish_date
        - 出版日
- 使用するSQL
    - __insert into cataloglist(isbn,title,category_code,writer,publisher,publish_date) values(?,?,?,?,?,?)__


##### メソッドの流れ

```java
// SQL文の作成
// コネクションを確立する（フィールドを使用）
// PreparedStatementオブジェクトの取得
// 引数で与えられたアイテムコードをPreparedStatementオブジェクトに設定する
// SQLの実行
// ItemBeanのArrayListオブジェクトの作成
if (レコードが存在する) {
    // レコードをItemBeanに格納
    // レコードを格納したItemBeanを返す
}
else {
   // nullを返す
}
```

<!-- O -->
#### public List\<DiscardBean> findDiscard(int book_id) throws DAOException
資料IDで資料情報を検索する

- 戻り値
     - public List \<DiscardBean>
        - 指定された資料IDに属する資料情報のリスト
- 引数
    - int book_id
        - 資料ID


- 使用するSQL
    - __select s.book_id, s.isbn, c.title, s.arrival_date from stocklist s join cataloglist c on s.isbn = c.isbn where s.book_id = ?__


##### メソッドの流れ

```java
// SQL文の作成
// コネクションを確立する（フィールドを使用）
// PreparedStatementオブジェクトの取得
// 引数で与えられたアイテムコードをPreparedStatementオブジェクトに設定する
// SQLの実行
// ItemBeanのArrayListオブジェクトの作成
if (レコードが存在する) {
    // レコードをItemBeanに格納
    // レコードを格納したItemBeanを返す
}
else {
   // nullを返す
}
```

<!-- O -->
#### public void discardBook(int book_id, date discard_date,String remarks) throws DAOException
紛失した資料を廃棄する日付を廃棄年月日として記録する

- 戻り値
    - なし
- 引数
    - int book_id
        - 資料ID
    - date discard_date
        - 廃棄年月日
    - String remarks
        - 備考

- 使用するSQL　
    - __update stocklist set discard_date = ?, remarks = ? where book_id = ?__




<!-- O -->
#### public void returnBook(String member_id, String book_id) throws DAOException
会員が資料を返却したらテーブルにその日付を登録

- 戻り値
    - なし
- 引数
    - String member_id
      - 会員ID
    - String book_id
      - 資料ID
 

- 使用するSQL 
    - __update rentlist set rent_date = current_date, remarks = null where member_id = ? and book_id = ?__


##### メソッドの流れ

```java
// SQL文の作成
// コネクションを確立する（フィールドを使用）
// PreparedStatementオブジェクトの取得
// 与えられた引数をPreparedStatementオブジェクトに設定する
// SQLの実行
```

<!-- O -->
#### public List\<貸出台帳Bean> rentBook(String member_id, String book_id, String return_deadline) throws DAOException
会員が資料を返却したらテーブルにその日付を登録

- 戻り値
    - なし
- 引数
    - String member_id
      - 会員ID
    - String book_id
      - 資料ID
    - String current_date
      - 返却年月日に入れる日付(JAVAで設定)
    - String return_deadline
      - 資料の出版日を参照してJavaで自動的に設定 

- 使用するSQL 
    - __insert into rentlist(member_id, book_id, rent_date, return_deadline) values(?, ?, current_date, ?)__
    - __select * from rentlist where member_id = ? and book_id = ? and rent_date = ?__

##### メソッドの流れ

```java
// SQL文の作成
// 一つ目のコネクションを確立する（フィールドを使用）
// PreparedStatementオブジェクトの取得
// 与えられた引数をPreparedStatementオブジェクトに設定する
// SQLの実行
// 二つ目のコネクションを確立する（フィールドを使用）
// PreparedStatementオブジェクトの取得
// 与えられた引数をPreparedStatementオブジェクトに設定する
// SQLの実行
// <貸出台帳Bean>のArrayListオブジェクトの作成
while (レコードが存在する) {
    // <貸出台帳Bean>に格納
  
}
// レコードを格納したList<貸出台帳Bean>を返す

```


<!-- O -->
#### public String getIsbnByBookId(int book_id) throws DAOException
資料IDからISBNを検索するためのDAO

- 戻り値
    - String ISBN

- 引数
    - String book_id
      - 資料ID
    
- 使用するSQL 
    - __select isbn from stocklist where book_id = ?__


##### メソッドの流れ

```java
// SQL文の作成
// 一つ目のコネクションを確立する（フィールドを使用）
// PreparedStatementオブジェクトの取得
// 与えられた引数をPreparedStatementオブジェクトに設定する
// SQLの実行
// レコードのISBNを返す

```

<!-- O -->
#### public List\<目録Bean> getCatalogListInfo(String type, String value) throws DAOException
資料IDからISBNを検索するためのDAO

- 戻り値
    - List\<目録Bean> (ISBN番号、資料名、分類コード、著者、出版社、出版日)

- 引数
    - String type
      - ISBNか資料名かを確認
    - String value
      - 値
    
- 使用するSQL 
    - __select * from catalogist where ? like %?%__ 
    - __select * from catalogist where ? = ?__


##### メソッドの流れ

```java
// SQL文の作成
// 一つ目のコネクションを確立する（フィールドを使用）
// PreparedStatementオブジェクトの取得
// 与えられた引数をPreparedStatementオブジェクトに設定する
// SQLの実行
// レコードのISBNを返す

```


<!-- O -->
#### public List\<int> getBookIdByIsbn(String isbn) throws DAOException
資料IDからISBNを検索するためのDAO

- 戻り値
    - List\<int> 
      - 資料IDリスト

- 引数
    - String isbn
      - ISBN
    
- 使用するSQL 
    - __select book_id from stocklist where isbn = ?__


##### メソッドの流れ

```java
// SQL文の作成
// 一つ目のコネクションを確立する（フィールドを使用）
// PreparedStatementオブジェクトの取得
// 与えられた引数をPreparedStatementオブジェクトに設定する
// SQLの実行
// レコードのISBNを返す

```


<!-- O -->
#### public List\<int> getBookIdByTitle(String title) throws DAOException
test


- 戻り値
    - List\<int> 
      - 資料IDリスト

- 引数
    - String title
      - title
    
- 使用するSQL 
    - __select s.book_id from stocklist s join cataloglist c on s.isbn = c.isbn where c.title = ?__


##### メソッドの流れ

```java
// SQL文の作成
// 一つ目のコネクションを確立する（フィールドを使用）
// PreparedStatementオブジェクトの取得
// 与えられた引数をPreparedStatementオブジェクトに設定する
// SQLの実行
// レコードのISBNを返す

```

<!-- IDに対して現在貸出中の資料IDと資料名を表示　O -->
#### public List\<showRentBean> showRentList(int member_id) throws DAOException
資料IDに対応する資料名を出力するメソッド

- 戻り値
    - List\<showRentBean>
      - 資料名
- 引数
    - String member_id
        - 会員ID

- 使用するSQL
    - __select r.book_id, c.title from rentlist r join stocklist s on r.book_id = s.book_id join cataloglist c on s.isbn = c.isbn where r.return_deadline is null and r.member_id = ?__


##### メソッドの流れ

```java
// SQL文の作成
// コネクションを確立する（フィールドを使用）
// PreparedStatementオブジェクトの取得
// 引数で与えられたアイテムコードをPreparedStatementオブジェクトに設定する
// SQLの実行
// ItemBeanのArrayListオブジェクトの作成
if (レコードが存在する) {
    // レコードをItemBeanに格納
    // レコードを格納したItemBeanを返す
}
else {
   // nullを返す
}
```

<!-- O -->
#### public void setDelay() throws DAOException
備考欄に延滞と記録する

- 戻り値
    - String title
      - 資料名
- 引数
    - String book_id
        - 資料ID

- 使用するSQL
    - __update rentlist set remarks = "延滞" where current_date - return_deadline > 0 and return_date is not null__


##### メソッドの流れ

```java
// SQL文の作成
// コネクションを確立する（フィールドを使用）
// PreparedStatementオブジェクトの取得
// 引数で与えられたアイテムコードをPreparedStatementオブジェクトに設定する
// SQLの実行
// ItemBeanのArrayListオブジェクトの作成
```

<!-- O -->
#### public List\<overduebean> findOverdue() throws DAOException
備考欄に延滞と記録する

- 戻り値
    - List\<overdueBean>
      - 延滞情報が含まれているリスト
  
- 引数
    - なし

- 使用するSQL
    - __select * from rentlist where remarks = "延滞"__


##### メソッドの流れ

```java
// SQL文の作成
// コネクションを確立する（フィールドを使用）
// PreparedStatementオブジェクトの取得
// 引数で与えられたアイテムコードをPreparedStatementオブジェクトに設定する
// SQLの実行
// ItemBeanのArrayListオブジェクトの作成
```

<!-- 資料IDを基にそれの資料目録の内容を表示 O-->
#### public \<Infobean> getInfoByBookId(int book_id) throws DAOException
在庫台帳と資料目録を結合して資料IDに当てはまる内容を表示

- 戻り値
    - \<infoBean>
      - 資料ID, ISBN, Title, 分類, author, publisher, publish_dateを表示
  
- 引数
    - int book_id
      - 資料ID

- 使用するSQL
    - __select * from stocklist s join cataloglist c on s.isbn = c.isbn where s.id = ?__


##### メソッドの流れ

```java
// SQL文の作成
// コネクションを確立する（フィールドを使用）
// PreparedStatementオブジェクトの取得
// 引数で与えられたアイテムコードをPreparedStatementオブジェクトに設定する
// SQLの実行
// ItemBeanのArrayListオブジェクトの作成
```


<!-- 資料目録から入力してもらったISBNの情報を O-->
#### public \<Infobean> getInfoByIsbn(String isbn) throws DAOException
在庫台帳と資料目録を結合して資料IDに当てはまる内容を表示

- 戻り値
    - \<infobean>
      - 資料ID, ISBN, Title, 分類, author, publisher, publish_dateを表示
  
- 引数
    - String isbn
      - 資料ISBN

- 使用するSQL
    - __select * from stocklist where isbn = ?__


##### メソッドの流れ

```java
// SQL文の作成
// コネクションを確立する（フィールドを使用）
// PreparedStatementオブジェクトの取得
// 引数で与えられたアイテムコードをPreparedStatementオブジェクトに設定する
// SQLの実行
// ItemBeanのArrayListオブジェクトの作成
```