# DAO

## MemberDAO
会員データを操作するためのDAOクラス

| package | class |
|:---:|:---:|
| la.dao | (public) MemberDAO |

### 機能概要


#### データ操作
PostgreSQLに対して会員データ操作をする  
DBの設定は下記の通り

##### DB設定
| データベース名 | ユーザ名 | パスワード |
| :---: | :---: | :---: |
| library_15 | postgres | himitu |

##### テーブル一覧
| # | テーブル名 |
| :---: | :---: |
| 1 | MemberList |


#### JavaBeans
データベースから取得したデータは以下のJavaBeansに格納する

- MemberBean

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

#### public MemberDAO() throws DAOException
このコンストラクターが呼び出されるとPostgreSQLのドライバーが登録される


### メソッド

#### public List\<String> searchLastIdName() throws DAOException
テーブル上、最後に登録された人のIDと名前を取得する

- 戻り値
  - List\<String>
    - IDと名前の情報

- 引数
  - なし。

- 使用するSQL
  - __select member_id, member_name from memberlist order by member_id desc limit 1__

MemberListテーブルから取得したレコードは、Listに格納して返す

##### メソッドの流れ  
```java
// SQL文の作成
// コネクションを確立する（フィールドを使用）
// PreparedStatementオブジェクトの取得
// SQLの実行
// List<String> インスタンス作成
// レコードのIDと名前をインスタンスに保存する
// インスタンスを返す
```


#### public MemberBean searchMember(int member_id) throws DAOException
全ての会員情報を取得する

- 戻り値
  - MemberBean
    - IDに該当する会員の情報

- 引数
  - int member_id
    - 会員ID

- 使用するSQL
  - __Select * from memberlist where member_id = ?__

MemberListテーブルから取得したレコードは、MemberBeanに格納して返す

##### メソッドの流れ  
```java
// SQL文の作成
// コネクションを確立する（フィールドを使用）
// PreparedStatementオブジェクトの取得
// 引数をPreparedStatementオブジェクトに設定する
// SQLの実行
// MemberBeanオブジェクトの作成
// レコードの値を変数に保存する
// MemberBeanを返す
```


#### public void addMember(String member_name, String member_address, String member_tel, String member_mail, String member_birth, String current_date) throws DAOException

書いてもらった情報をもとにMemberListテーブルに登録後、最終的に登録された会員のIDと名前を返す

- 戻り値
  - void
    - レコードに登録するだけで、戻り値なし。

- 引数
  - String member_name
    - 会員氏名
  - String member_address
    - 会員住所
  - String member_tel
    - 会員電話番号
  - String member_mail
    - 会員メールアドレス
  - String member_birth
    - 会員誕生日
  - String current_date
    - 当時の年月日

- 使用するSQL
  - __insert into memberlist(member_name, member_address, member_tel, member_mail, member_birth, member_registdate) values(?, ?, ?, ?, ?, ?)__

MemberListテーブルにレコードを登録後、MemberBeanのArrayListとして返す。  

##### メソッドの流れ  
```java
// SQL文の作成
// コネクションを確立する（フィールドを使用）
// PreparedStatementオブジェクトの取得
// 当時の年月日をJavaで自動的に変数に代入 (current date)
// 引数(入力してもらう５つ)とCurrent dateをPreparedStatementオブジェクトに設定する
// SQLの実行
```


#### public void updateMember(int member_id, String member_name, String member_address, String member_tel, String member_mail, String member_birth) throws DAOException
既存のレコードの情報を引数に書いてあるどおり、変更する。

- 戻り値
    - void
        - アップデートするメソッドなので、戻り値なし。
- 引数
  - int member_id
    - 会員ID
  - String member_name 
    - 会員氏名
  - String member_address 
    - 会員住所
  - String member_tel 
    - 会員電話番号
  - String member_mail 
    - 会員メールアドレス
  - String member_birth 
    - 会員誕生日
  
- 使用するSQL
    - __update memberlist set member_name = ?, member_address = ?, member_tel = ?, member_mail = ?, member_birth = ? where member_id = ?__

memberlistテーブル内、引数と同じ会員IDを見つけて、内容を修正して保存する    

		
##### メソッドの流れ

```java
// SQL文の作成
// コネクションを確立する（フィールドを使用）
// PreparedStatementオブジェクトの取得
// 引数をPreparedStatementオブジェクトに設定する
// SQLの実行
```
 


#### public void cancelMember(int member_id, String current_date) throws DAOException
既存のレコードの退会年月日に情報を追加する

- 戻り値
    - void
        - アップデートするメソッドなので、戻り値なし。
- 引数
  - int member_id
    - 会員ID
  - String current_date
    - 当時の年月日
  
- 使用するSQL
    - __update memberlist set member_canceldate = ? where member_id = ?__

memberlistテーブル内、引数と同じ会員IDを見つけて、退会年月日に当日の日付を入力する
		
##### メソッドの流れ

```java
// SQL文の作成
// コネクションを確立する（フィールドを使用）
// PreparedStatementオブジェクトの取得
// 引数をPreparedStatementオブジェクトに設定する
// SQLの実行
```
 

