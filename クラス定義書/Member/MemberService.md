# Service
## MemberService

| package | class | 
| :---: | :---: | 
| la.service | (protected) MemberService |

### 機能概要

サーブレットからもらった情報を用いてDAOをインスタンス化し、操作を行わせる機能    
なお、DAOの結果をまたサーブレットに送信する役割である


#### Servlet, DAO, DTO
- MemberServlet
- MemberDAO
- MemberBean

#### エラー制御
エラー発生時はエラーページ(errInternal.jsp)を表示

### フィールド

- MemberDAOクラスをもとにするDAO生成

### コンストラクタ

- フィールドのDAOに新しいMemberDAOをコンストラクタ化する

<div style="page-break-before:always"></div>


### メソッド

ーーー
#### private List\<MemberBean> add(int code) throws ServletException, IOException 
インスタンス化されたDAOでSearchMember()メソッドを行ってRequestスコープに登録する

##### Service, DTO

- MemberDAO
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


ーーー

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