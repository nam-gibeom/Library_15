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


#### public List\<BookBean> findIsbn(String isbn) throws DAOException
指定されたISBN番号に属する資料情報を取得する  

- 戻り値
    - public List \<BookBean>
        - 指定されたISBN番号に属する資料情報のリスト
- 引数
    - String isbn
        - ISBN番号
- 使用するSQL
    - __SELECT * FROM item WHERE category_code = ? ORDER BY code__

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
#### public BookBean addCatalog(String isbn) throws DAOException
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



#### public List\<RentBean> findMember(String member_id) throws DAOException
会員の貸出状況を確認する。

- 戻り値
    - なし
- 引数
    - String member_id
        - 会員ID

- 使用するSQL 
    - __select * from rentlist where member_id = ? and return_date is null__


##### メソッドの流れ

```java
// SQL文の作成
// コネクションを確立する（フィールドを使用）
// PreparedStatementオブジェクトの取得
// 引数で与えられたMember_IDをPreparedStatementオブジェクトに設定する
// SQLの実行
// <貸出台帳Bean>のArrayListオブジェクトの作成
while (レコードが存在する) {
    // <貸出台帳Bean>に格納
  
}
  // レコードを格納したList<貸出台帳Bean>を返す

```



#### public void returnBook(String member_id, String book_id, String current_date) throws DAOException
会員が資料を返却したらテーブルにその日付を登録

- 戻り値
    - なし
- 引数
    - String member_id
      - 会員ID
    - String book_id
      - 資料ID
    - String current_date
      - 返却年月日に入れる日付 

- 使用するSQL 
    - __update rentlist set rent_date = ? where member_id = ? and book_id = ?__


##### メソッドの流れ

```java
// SQL文の作成
// コネクションを確立する（フィールドを使用）
// PreparedStatementオブジェクトの取得
// 与えられた引数をPreparedStatementオブジェクトに設定する
// SQLの実行
```


#### public List\<貸出台帳Bean> rentBook(String member_id, String book_id, String current_date String return_deadline) throws DAOException
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
    - __insert into rentlist(member_id, book_id, rent_date, return_deadline) values(?, ?, ?, ?)__
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