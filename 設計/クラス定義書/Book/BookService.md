# Service
## BookService

| package | class | 
| :---: | :---: | 
| la.service | (protected) BookService |

### 機能概要

サーブレットからもらった情報を用いてDAOをインスタンス化し、操作を行わせる機能    
なお、DAOの結果をまたサーブレットに送信する役割である


#### Servlet, DAO, DTO
- BookServlet
- BookDAO
- BookBean

#### エラー制御
エラー発生時はエラーページ(errInternal.jsp)を表示

### フィールド

- BookDAOクラスをもとにするDAO生成

### コンストラクタ

- フィールドのDAOに新しいBookDAOをコンストラクタ化する

<div style="page-break-before:always"></div>




### メソッド

---
<!-- 貸出 -->
#### private List\<貸出台帳Bean> rentBooksByID(int member_id, List\<int> book_id) 
サーブレットからもらった二つの引数と共に、現在の日付と返却期日を自動的に計算して貸出台帳に行を追加する。

##### Service, DTO

- BookDAO
- 貸出台帳Bean

##### 処理の流れ

1. Javaパッケージを用いて当日の日付を変数に保存(current_date)
2. 引数としてもらった５つと変数Current_dateを用いてDAOの「__addMember__」メソッドを実行
3. DAO「__searchLastIDNAME__」メソッドを実行して結果を変数に保存する
4. 保存されたIDと名前を戻り値として返す
---



