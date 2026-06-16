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
#### public BookBean addCatalog(String isbn,) throws DAOException
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

#### public BookBean findMember(String member_id) throws DAOException
会員の現在貸出状況を確認

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