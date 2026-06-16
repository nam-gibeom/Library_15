# Servlet
## MemberServlet

| package | class | extends |
| :---: | :---: | :---: |
| la.servlet | (protected) MemberServlet | HttpServlet |

### 機能概要

会員データを操作するためのServletクラス(Controller)   
doGet,doPost共通で同じ処理を実装する

#### Action

| # | action名 | 遷移先 | 機能 |
| :---: | :---: | :---: | :--- |
| 1 | search | memberUpdate.jsp <br> memberCancel.jsp | 操作が行ったページを更新して表示 |
| 2 | regist | registResult.jsp | 登録確認画面を表示する |
| 3 | update | memberUpdate.jsp | 変更後、初期ページに戻る |
| 4 | cancel | memberCancel.jsp | 変更後、初期ページに戻る |

#### Service, DTO
- MemberService
- MemberBean

#### エラー制御
エラー発生時はエラーページ(errInternal.jsp)を表示

### フィールド

- なし

#### スコープオブジェクト

| # | スコープ | オブジェクト名 | クラス(データ型) | 備考 |
| :---: | :---: | :---: | :---: | :---: |
| 1 | request | member | MemberBean | 会員登録、変更、退会で会員情報を表示するために使う  |
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
| 1 | action | search:検索が行われたページの表示 <br> add:確認画面を表示 <br> update:初期ページの表示 <br> cancel:　初期ページの表示 | 機能を示す|
| 2 | member | MemberBean | 会員情報を表示 |

##### Service,DTO

- MemberService
- MemberBean

##### 処理の流れ

1. requestパラメータ(action)の取得
2. actionの値に応じて下記の通り処理を行う
    - action = search
        1. もとのページ(変更または退会)にフォワード(gotoPage)
    - action = add
        1. requestパラメータ(member_n...ame, member_address, member_tel, member_mail, member_birth)の取得
        2. パラメータを用いてMemberServiceをインスタンス化して処理を行う。
        3. MemberServiceで登録した行のID(member_id)を取得し、検索も行って名前を取得する
        4. 取得したIDと名前を"member_id", "member_name"としてrequestスコープに格納
        5. 登録完了画面(UI102)にフォワード(gotoPage)
    - action = update
        1. requestパラメータ(member_n...ame, member_address, member_tel, member_mail, member_birth)の取得
        2. パラメータを用いてMemberServiceをインスタンス化して処理を行う。
        3. 初期画面(UI103)にフォワード(gotoPage)
    - action = cancel
        1.  requestパラメータ(member_id)の取得
        2.  パラメータを用いてMemberServiceをインスタンス化して処理を行う。
        3.  初期画面(UI104)にフォワード(gotoPage)
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