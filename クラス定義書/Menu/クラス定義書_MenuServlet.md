# Servlet
## MenuServlet

| package | class | extends |
| :---: | :---: | :---: |
| la.servlet | (protected) MenuServlet | HttpServlet |

### 機能概要

職員のログインログアウトと画面遷移を操作をするためのServletクラス(Controller)  
doGet,doPost共通で同じ処理を実装する

#### Action

| # | action名 | 遷移先 | 機能 |
| :---: | :---: | :---: | :--- |
| 1 | login | top.jsp/login.jsp | トップページを表示 |
| 2 | logout | login.jsp | ログインページを表示 |
| 3 | regist | memberResult.jsp | 会員登録ページを表示 |
| 4 | update | memberUpdate.jsp | 会員変更ページを表示 |
| 5 | cancel | memberCancel.jsp | 会員退会ページを表示 |
| 6 | search | bookSearch.jsp | 資料検索ページを表示 |
| 7 | rent | bookRr.jsp | 貸出返却ページを表示 |
| 8 | add | bookAdd.jsp | 資料登録ページを表示 |
| 9 | discard | bookDiscard.jsp | 資料紛失を表示 |

#### DAO,DTO,SERVICE
- MenuService

#### エラー制御
エラー発生時はエラーページ(errInternal.jsp)を表示

### フィールド

- なし

#### スコープオブジェクト

| # | スコープ | オブジェクト名 | クラス(データ型) | 備考 |
| :---: | :---: | :---: | :---: | :---: |
| 1 | request | admin | String | 職員名、top.jspで使用 |


### コンストラクタ

- デフォルト

<div style="page-break-before:always"></div>

### メソッド

#### protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
商品とカテゴリに関するリクエストのディスパッチ処理を行う
doPost()が呼び出された時にもdoGet()を呼び出す

##### リクエストパラメータ

| # | パラメータ名 | 内容 | 備考 |
| :---: | :---: | :---: | :--- |
| 1 | action | login: トップページの表示 <br> logout: ログイン画面の表示 <br> regist: 登録画面の表示 <br> update: 変更画面の表示 <br>cancel: 退会画面の表示 <br>search: 資料検索画面の表示 <br>rent: 資料貸出返却の表示 <br>add: 資料登録画面の表示 <br>discard: 資料廃棄画面の表示 | 機能を示す|
| 2 | code | 整数値 | 職員コード |

##### DAO,DTO

- MenuService


##### 処理の流れ

1. requestパラメータ(action)の取得
2. actionの値に応じて下記の通り処理を行う
    - action = login
        1. requestパラメータ(id,name)の取得
        2. (id,name)が登録された情報と一致するならfindName()を呼びだす
        3. 戻り値のnameをrequestスコープに入れる 
        4. top.jspにフォワード(gotoPage)
    - action = logout
        1. login.jspにフォワード(gotoPage)
    - action = regist
        1. memberResult.jspにフォワード(gotoPage)
    - action = update
        1. memberUpdate.jspにフォワード(gotoPage)
    - action = cancel
        1. memberCancel.jspにフォワード(gotoPage)
    - action = search
        1. bookSearch.jspにフォワード(gotoPage)
    - action = rent
        1. bookRr.jspにフォワード(gotoPage)
    - action = add
        1. bookAdd.jspにフォワード(gotoPage)
    - action = discard
        1. bookDiscard.jspにフォワード(gotoPage)

    - 上記以外のaction
        1. エラーメッセージを"message"としてrequestスコープに格納
        2. エラーページ(UI003)にフォワード(gotoPage)



    


<div style="page-break-before:always"></div>

#### public void init() throws ServletException
Servletがインスタンス化された際に一度だけサーブレットコンテナから呼び出される初期化処理  
後続の処理で共通に使用するカテゴリーのリストをアプリケーションスコープに格納する

- 戻り値
    - void
        - なし
- 引数
    - なし

##### DAO,DTO
- MenuDAO


##### メソッドの流れ  

```java
// BookServiceをインスタンス化
// 延滞状況一覧表を取得(BookService.Entai)
// 取得した延滞状況一覧をentaiという名前でリクエストスコープに設定
```

#### private void gotoPage(HttpServletRequest request,HttpServletResponse response, String page) throws ServletException,IOException
指定されたページにフォワードする

- 戻り値
    - void
        - なし
- 引数
    - HttpServletRequest request
        - doGetのリクエストオブジェクト
    - HttpServletResponse response
        - doGetのレスポンスオブジェクト
    - String page
        - フォワード先のページ

##### メソッドの流れ  

```java
// 指定されたページでRequestDispatcherのオブジェクトを取得
// フォワードする
```