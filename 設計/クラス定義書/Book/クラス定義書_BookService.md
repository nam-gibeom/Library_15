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
<!-- 貸出（貸出・返却画面で使う：次へボタン） -->
#### public List\<貸出台帳Bean> rentBooksByID(int member_id, List\<int> book_id) 
サーブレットからもらった二つの引数と共に、現在の日付と返却期日を自動的に計算して貸出台帳に行を追加する。

##### Service, DTO

- BookDAO
- 貸出台帳Bean

##### 処理の流れ

1. Javaパッケージを用いて当日の日付を変数に保存(current_date)
2. For文を用いてBook_idを用いて「__getInfoByBookId__」を実行し、出版日だけ獲得する
3. 出版年月日をもとに貸出可能日数を計算する
4. Current_dateに貸出可能日数を足してreturn_deadlineを変数として設定
5. 引数としてもらった2つとreturn_deadlineをDAOの「__addRentlistAndGetInfo__」メソッドを実行してリストを保存（資料ID、返却期日）
6. 資料IDごとに資料名を獲得するため「__getInfoByBookId__」を実行してgetTitle()メソッドで獲得する（資料名）
7. 保存されたリストと資料名を戻り値として返す（貸出確認JSPに資料ID、資料名、返却期日三つのパラメータを）
8. 
---


<!-- 現在、会員が貸出中の資料リストを表示（貸出・返却画面で使う：検索ボタン）　-->
#### public List\<貸出台帳Bean> showCurrentRentList(int member_id) 
サーブレットから会員ＩＤをもらったら貸出台帳を参照してその人が現在、貸出中の資料目録を表示

##### Service, DTO

- BookDAO
- 貸出台帳Bean

##### 処理の流れ

1. Daoの「__getRentedBookIdTitlebyMember__」メソッドを実行
2. メソッドの結果を戻り値として表示
---


<!-- ある会員の特定の資料を返却（貸出・返却画面で使う：返却ボタン）　-->
#### public void returnBook(int member_id, int book_id) 
貸出台帳に特定の会員と資料を見つけて返却年月日を記入後、またその人の貸出状況を表示

##### Service, DTO

- BookDAO
- 貸出台帳Bean

##### 処理の流れ

1. DAOの「__updateRentDate__」にmember_id, book_id, current_dateを入れて実行
---


<!-- 検索 -->
#### public list\<searchBean> searchBooks (String type, String value) 


##### Service, DTO

- BookDAO
- 貸出台帳Bean

##### 処理の流れ

1. IF文を使ってtypeによるValueの型を変更する(資料名、ISBNの場合、String ; 資料IDの場合、Int)
   1. 資料IDの場合、ISBNに変換する作業を行う。「__getIsbnByBookId__」
2. 資料名またはISBNを用いてDAOを実行する
   1. 資料名の場合、String type = "title"を変数として保存 
   2. IBSNの場合、String type = "ISBN"を変数として保存
3. DAOの「__getCatalogListInfo__」を実行
4. IF ELSE文を使って貸出日数を（現在の日付ー出版日）が3ヶ月以上の場合15、じゃない場合は10日に設定する。（一つの変数に保存する）
5. 検索された資料の数が二つ以上の場合、For文を使って以下を実行する。
   1. 資料ごとにISBNまた資料名によって「__getBookIdByIsbn__」または「__getBookIdByTitle__」を使って現在の総冊数を保存する。
6. findRentBook（貸出中の冊数）/総冊数として変数に保存
---




<!-- 延滞：ログイン、延滞ボタンが押された時 -->
#### public List\<overduebean> searchOverdueBooks () 


##### Service, DTO

- BookDAO
- overdueBean(member_id, book_id, title, return_deadline, overdue)

##### 処理の流れ
1. アプリケーションスコープでFinalEditDate(最終更新日)を呼び出す
   1. もし、FinalEditDateがない場合、新しく作成する。
2. 当日の日付とFinalEditDateを比較する（一致しない場合、以下の順番を実行する）
   1. 貸出台帳のうち、返却年月日がNullの資料(貸出中)の中で、返却年月日がが当日の日付を過ぎた行の備考欄に延滞を記入するメソッド「__updateRemarksDelay__」を実行
   2. その後、備考欄に延滞って書いてある会員のIDを保存「__getRemarksAsOverdue__.member_id」
   3. MemberDAOの「searchMember」でメールアドレスを取得する
   4. メールを送信する
   5. アプリケーションスコープのFinalEditDateに当日の日付を再記入する
3. DAOの「__getRemarksAsOverdue__」と資料名「getInfoByBookId.getTitle」、延滞日数（Javaで計算）を戻り値として返還する。



<!-- ISBNを用いて存在するかどうかを確認 -->
#### public Boolean isIsbnExist (String isbn) 


##### Service, DTO

- BookDAO

##### 処理の流れ
1. daoの「getInfoByIsbn」を実行して、infoBeanをもらう。
2. InfoBeanに情報が入っているならTrue,じゃないとFalseを返還
    1. trueの場合、「getInfoByIsbn」を返還
    2. Falseの場合、全部NullのinfoBeanを返還


<!-- ISBNが存在するする場合 -->
#### public void addStock (String isbn) 


##### Service, DTO

- BookDAO

##### 処理の流れ
1. DAOの「__addStockList__」を実行して在庫を増やす


<!-- ISBNがない場合 -->
#### public void addCatalog (String isbn, String title, int category_code, String author, String publisher, String publish_date) 


##### Service, DTO

- BookDAO

##### 処理の流れ

1. DAOの「__addCatalogList__」を実行して目録に登録する(引数全部)
2. DAOの「__addStockList__」を実行して在庫を増やす(引数ISBNのみ)





<!-- 廃棄する資料検索 -->
#### public List\<DiscardBean> searchDiscard (int book_id) 


##### Service, DTO

- BookDAO
- DiscardBean(book_id, isbn, title, 入荷年月日)

##### 処理の流れ

1. DAOの「__getSTockListByBookId__」を実行して戻り値にする



<!-- 廃棄実施 -->
#### public void discardBook (int book_id, String discard_date, String remarks) 


##### Service, DTO

- BookDAO

##### 処理の流れ

1. DAOの「updateStockListDiscard」に全ての引数を入れて実行
