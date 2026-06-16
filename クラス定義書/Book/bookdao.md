# DAO

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


#### public List\<BookBean> findPublishDate(String isbn) throws DAOException
指定されたISBN番号に属する資料の出版日を取得する  

- 戻り値
    - public List \<BookBean>
        - 指定されたISBN番号に属する資料の出版日のリスト
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
// ItemBeanのArrayListオブジェクトの作成
while (レコードが存在する間レコードの取得) {
   // レコードをItemBeanに格納
   // ItemBeanをリストに追加
}
// リストを返す
```
#### public List\<BookBean> findinfo(int member_id) throws DAOException
指定された会員番号に属する貸出中の資料の貸出履歴を取得する  

- 戻り値
    - public List \<BookBean>
        - 指定された会員番号に属する貸出中の資料の貸出履歴のリスト
- 引数
    - int member_id
        - 会員番号
- 使用するSQL
    - __SELECT member_id,book_id,rent_date,return_deadline FROM rentlist WHERE member_id = ?__

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

#### public List\<BookBean> calDelay() throws DAOException
指定された会員番号に属する貸出中の資料の貸出履歴を取得する  

- 戻り値
    - public List \<BookBean>
        - 指定された会員番号に属する貸出中の資料の貸出履歴のリスト
- 引数
    - なし
- 使用するSQL
    - __SELECT CURRENT_DATE - return_deadline AS days_diff FROM rentlist__

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


#### public List\<BookBean> findBookId(String isbn) throws DAOException
指定されたISBN番号に属する資料のIDを取得する  

- 戻り値
    - public List \<BookBean>
        - 指定されたISBN番号に属する資料のIDのリスト
- 引数
    - String isbn
        - ISBN番号
- 使用するSQL
    - __SELECT book_id FROM stocklist WHERE isbn = ?__

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


#### public BookBean addStock(String isbn,date arrival_date) throws DAOException
資料を在庫台帳に新規登録する

- 戻り値
    - なし
- 引数
    - String isbn
        - ISBN番号
    - date arrival_date
        - 入荷年月日
- 使用するSQL
    - __insert into stocklist(isbn,arrival_date) values(?,?)__


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
#### public BookBean addCatalog(String isbn,String title,int category_code,String writer,String publisher,date publish_date) throws DAOException
資料を資料目録に新規登録する

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
#### public List\<BookBean> findDiscard(int book_id) throws DAOException
資料IDで資料情報を検索する

- 戻り値
     - public List \<BookBean>
        - 指定された資料IDに属する資料情報のリスト
- 引数
    - int book_id
        - 資料ID


- 使用するSQL
    - __select * from stocklist where book_id = ?__


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

#### public BookBean discardBook(date discard_date,String remarks) throws DAOException
紛失した資料を廃棄する日付を廃棄年月日として記録する

- 戻り値
    - なし
- 引数
    - date discard_date
        - 廃棄年月日
    - String remarks
        - 備考

- 使用するSQL
    - __insert into stocklist(discard_date,remarks) values(?,?)__


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