# Servlet
## BookServlet

| package | class | extends |
| :---: | :---: | :---: |
| la.servlet | (protected) BookServlet | HttpServlet |

### 機能概要

資料のでーたを操作するためのServletクラス(Controller)   
doGet,doPost共通で同じ処理を実装する

#### Action

| # | action名 | 遷移先 | 機能 |
| :---: | :---: | :---: | :--- |
| 1 | booksearch |  Booksearch.jsp <br>  BookAdd.jsp <br>  BookDiscard.jsp <br> BookRr.jsp |  操作が行ったページを更新して表示 |
| 2 | add | BookAdd.jsp | 登録後、初期ページに戻る |
| 3 | discard | BookDiscard.jsp | 変更後、初期ページに戻る |
| 4 | confirm | BookConfirm.jsp | 登録確認ページを表示する |
| 5 | rent | BookRr.jsp | 変更後、初期ページに戻る  |
| 6 | return | BookRr.jsp |  変更後、初期ページに戻る |

#### Service, DTO
- BookService
- BookBean

#### エラー制御
エラー発生時はエラーページ(errInternal.jsp)を表示

### フィールド

- なし

#### スコープオブジェクト

| # | スコープ | オブジェクト名 | クラス(データ型) | 備考 |
| :---: | :---: | :---: | :---: | :---: |
| 1 | request | book | BookBean | 資料登録、廃棄、検索、貸出、返却で資料情報を表示するために使う  |
| 2 | request | message | String | エラーメッセージ(errInput.jspで使用) |


### コンストラクタ

- デフォルト

<div style="page-break-before:always"></div>


### メソッド

#### protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
会員の情報に関するリクエストのディスパッチ処理を行う
doPost()が呼び出された時にもdoGet()を呼び出す

##### リクエストパラメータ

| # | パラメータ名 | 内容 | 備考 |
| :---: | :---: | :---: | :--- |
| 1 | action | booksearch:検索が行われたページの表示 <br> add:資料の登録画面を表示 <br> discard:資料の廃棄画面の表示 <br> confirm:資料の貸出確認画面 <br> rent:資料の貸出、返却画面の表示 <br> return:資料の貸出、返却画面の表示 | 機能を示す|
| 2 | book | BookBean | 資料情報を表示 |

##### Service,DTO

- BookService
- BookBean

##### 処理の流れ

1. requestパラメータ(action)の取得

2. actionの値に応じて下記の通り処理を行う

    - action = membersearch
        1. requestパラメータ(member_id)の取得
        2. パラメータを用いてBookServiceをインスタンス化して処理を行う。
        3. BookServiceで登録した行のID(member_id)を取得し、検索も行って資料Idとタイトルを取得する
        4-1. 取得したIDとタイトルを"member_id", "title"としてrequestスコープに格納
        4-2. 取得した資料の情報を"isbn", "title","category_code","author","rent"としてrequestスコープに格納
        4-3.取得した資料の情報を"book_id","isbn", "title","arrival_date","としてrequestスコープに格納
        5. 資料の貸出、返却画面(UI202)にフォワード(gotoPage)

    - action = add
        1. requestパラメータ(isbn, title, category_code, author, publisher, publish_date)の取得
        2. パラメータを用いてBookServiceをインスタンス化して処理を行う。
        3. BookServiceで登録した行の資料に情報（isbn, title, category_code, author, publisher, publish_date）を取得し、データベースに保存する
        5. 資料の登録画面(UI204)にフォワード(gotoPage)

    - action = discard
        1. requestパラメータ(note)の取得
        2. パラメータを用いてBookServiceをインスタンス化して処理を行う。
        3. BookServiceで登録した行の廃棄の理由（note）を取得し、データベースに当日の日付とnoteをUPDATEする
        4. 資料の廃棄画面(UI205)にフォワード(gotoPage)

    - action = confirm
        1.   資料の貸出確認画面(UI203)にフォワード(gotoPage)
    
    - action = rent
        1.  requestパラメータ資料ID,資料名,返却期日(book_id,title,int型の整数)の取得
        2. パラメータを用いてBookServiceをインスタンス化して処理を行う。
        3. 取得したIDと資料名、返却期日を"book_id", "title, int型の整数"としてrequestスコープに格納
        4. 資料の貸出、返却画面(UI202)にフォワード(gotoPage)

    - action = return
        1.  requestパラメータ資料IDと資料名(book_id,title)の取得
        2. パラメータを用いてBookServiceをインスタンス化して処理を行う。 
        3. 取得したIDと資料名"book_id", "title, "としてrequestスコープに格納
        4. 資料の貸出、返却画面(UI202)にフォワード(gotoPage)
    
    - 上記以外のaction
        1. エラーメッセージを"message"としてrequestスコープに格納
        2. エラーページ(UI004)にフォワード(gotoPage)

<div style="page-break-before:always"></div>

<!-- #### public void init() throws ServletException
Servletがインスタンス化された際に一度だけサーブレットコンテナから呼び出される初期化処理  
後続の処理で共通に使用するカテゴリーのリストをアプリケーションスコープに格納する

- 戻り値
    - void
        - なし
- 引数
    - なし

##### DAO,DTO
- ItemDAO
- CategoryBean

##### メソッドの流れ  

```java
// ItemDAOをインスタンス化
// categoeyCodeの一覧を取得(ItemDAO.findAllCategoryCode)
// 取得したカテゴリー一覧をcategoriesという名前でリクエストスコープに設定
``` -->

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