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

---
#### private List\<String> addMemberService(String member_name, String member_address, String member_tel, String member_mail, String member_birth) 
サーブレットからもらった５つと加えて当日の日付DAOを実行し、その会員のIDと名前を返す

##### Service, DTO

- MemberDAO
- MemberBean

##### 処理の流れ

1. Javaパッケージを用いて当日の日付を変数に保存(current_date)
2. 引数としてもらった５つと変数Current_dateを用いてDAOの「addMember」メソッドを実行
3. DAO「searchLastIDNAME」メソッドを実行して結果を変数に保存する
4. 保存された変数を戻り値として返す
---




#### private List\<String> SearchAndMove(int member_id, String action) 
member_idを検索してもとのページの位置を表示する

##### Service, DTO

- MemberDAO
- MemberBean

##### 処理の流れ

```java
public class SearchMove {
    public MemberBean;
    public URL;

    public SearchMove(MemberBean bean, String url) {
        this.MemberBean = bean;
        this.URL = url;
    }

}
```

1. サーブレットからもらったIDを用いてDAOの「searchMember」を実行し、Beanを保存
2. サーブレットからもらったactionのうち、変更の場合にはそれに当てはまるjspのアドレスを、削除の場合にも同じくしてURL変数に保存
3. 上記のSearchMoveクラスをインスタンス化して中にBeanとURLを入れて戻り値にして変換

--- 

#### private void updateMemberService(int member_id, String member_name, String member_address, String member_tel, String member_mail, String member_birth) 
もらった引数とおり、そのまま変更を行う

##### Service, DTO

- MemberDAO
- MemberBean

##### 処理の流れ


1. サーブレットからもらった引数を用いてDAOの「updateMember」を実行する

--- 
#### private void updateMemberService(int member_id) 
入力したIDと現在の日付を使って退会メソッドを実行

##### Service, DTO

- MemberDAO
- MemberBean

##### 処理の流れ


1. Javaパッケージを用いて当日の日付を変数に保存(current_date)
2. サーブレットからもらったIDとcurrent_dateを用いてDAOの「cancelMember」を実行する
