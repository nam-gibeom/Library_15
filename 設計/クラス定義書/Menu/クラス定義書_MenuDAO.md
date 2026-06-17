# DAO

## MenuDAO

パスワード認証とログインをしてるDAOクラス

| package | class |
|:-------:|:-----:|
| la.dao | (public) MenuDAO |

### 機能概要

#### データ操作

PostgreSQLに対してパスワード認証をする操作  
DBの設定は下記の通り

##### DB設定

| データベース名 | ユーザ名 | パスワード |
|:-------:|:----:|:-----:|
| library_15 | postgres | himitu |

##### テーブル一覧

| \# | テーブル名 |
|:-:|:-----:|
| 1 | adminlist |

#### JavaBeans

Bean 不要

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

#### public MenuDAO() throws DAOException

このコンストラクターが呼び出されるとPostgreSQLのドライバーが登録される

### メソッド

#### public String getName(String id) throws DAOException

SQLで'id'引数に当たる会員の名前を取得する

- 戻り値 
  - String name 
    - idに当たる職員の名前
- 引数 
  - String id
- 使用するSQL 
  - __SELECT staff_name FROM adminlist WHERE staff_id = ?__



##### メソッドの流れ

```java
// SQL文の作成
// コネクションを確立する（フィールドを使用）
// PreparedStatementオブジェクトの取得
// 引数をPreparedStatementオブジェクトに設定する
// SQLの実行
// String nameを返す
```



#### public String getPass(String id) throws DAOException

全てのカテゴリを取得する

- 戻り値 
  - String pass 
    - idに当たる職員のパスワード
- 引数 
  - String id

- 使用するSQL 
  - __SELECT staff_password FROM adminlist WHERE Staff_id = ?__

##### メソッドの流れ

```java
// SQL文の作成
// コネクションを確立する（フィールドを使用）
// PreparedStatementオブジェクトの取得
// 引数をPreparedStatementオブジェクトに設定する
// SQLの実行
// String passを返す
```