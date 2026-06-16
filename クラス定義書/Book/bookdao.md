# DAO

## ItemDAO
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

#### public List\<BookBean> findIsbn() throws DAOException
ISBN番号で資料情報を取得する

- 戻り値
    - List \<BookBean>
        - 検索したISBN番号の資料情報リスト
- 引数
    - ?
- 使用するSQL
    - __SELECT * FROM cataloglist where isbn = ? ORDER BY code__

categoryテーブルから取得したレコードは、CategoryBeanのArrayListに格納して返す  

##### メソッドの流れ  

```java
// SQL文の作成
// コネクションを確立する（フィールドを使用）
// PreparedStatementオブジェクトの取得
// SQLの実行
// CategoryBeanのArrayListオブジェクトの作成
while (レコードが存在する間レコードの取得) {
   // レコードをCategoryBeanに格納
   // CategoryBeanをリストに追加
}
// リストを返す
```

#### public List\<BookBean> (int categoryCode) throws DAOException
指定されたカテゴリコードに属するアイテムを取得する  

- 戻り値
    - public List \<ItemBean>
        - 指定されたカテゴリコードに属するアイテムのリスト
- 引数
    - int categoryCode
        - カテゴリコード
- 使用するSQL
    - __SELECT * FROM item WHERE category_code = ? ORDER BY code__

itemテーブルから取得したレコードは、ItemBeanのArrayListに格納して返す
		
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
 
#### public ItemBean findByPrimayKey(int key) throws DAOException
指定されたアイテムコードのアイテムを取得する

- 戻り値
    - ItemBean
        - 指定されたアイテムコードのアイテム。
        - 該当のアイテムがない場合はnullが返される"
- 引数
    - int key
        - アイテムコード
- 使用するSQL
    - __SELECT * FROM item WHERE code = ?__

itemテーブルから取得したレコードは、ItemBeanに格納して返す

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
