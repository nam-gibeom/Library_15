# Service
## menuService

| package | class |
| :---: | :---: | 
| la.service | (public) MenuService | 

### 機能概要

職員のログインログアウト、また画面遷移のメソッドを実行するためのServiceクラス(model)  


#### エラー制御
エラー発生時はエラーページ(errInternal.jsp)を表示

### フィールド

- なし


### コンストラクタ

- public MenuService() 


<div style="page-break-before:always"></div>

### メソッド

#### public String Login(Stirng id, String pass) throws ServiceException
DAOのメソッドを実行してパスワードを取得し、String passと　一致するかを判断してまたDAOを実行し職員の名前を習得する。

- 戻り値
    - String name
        - 職員の名前
- 引数
    - id
      - 入力してもらったID
    - pass
      - 入力してもらったパスワード


##### DAO,DTO

- MenuDAO


##### メソッドの流れ

```java
// DAOのfindPass(id)を実行
// 職員のパスワードを取得
//　取得したパスワードとString passが一致するかを判断
//一致する場合、DAOのfindName(id)を実行
// 職員の名前を取得
// String nameを返す
// 一致しない場合、エラーメッセージを出力
```


<div style="page-break-before:always"></div>


#### public String move(String action) throwServiceException
actionによって画面遷移を行うためのurlを戻す

- 戻り値
    - String url
        - ログイン画面（UI001）のurl
- 引数
    - action
      - サーブレットからもらったAction


##### メソッドの流れ  

```java
// Actionまたはログイン成功によってページを遷移
// この作業はIFとELSEIFを用いて作業
```