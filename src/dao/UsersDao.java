package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Users;

public class UsersDao {

	//ログインするための
	public boolean isLoginOK(Users card) {
		Connection conn = null;
		boolean loginResult = false;


		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/DOJO2024DB/E1", "sa", "");

			// SQL文を準備する
			String sql = "SELECT COUNT(*) FROM USERS WHERE MAILADDRESS = ? AND USER_PW = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);


			// SQL文を完成させる
			if (card.getMAILADDRESS() != null) {
				pStmt.setString(1, card.getMAILADDRESS() );
			}
			else {
				pStmt.setString(1, "");
			}
			if (card.getUSER_PW() != null) {
				pStmt.setString(2, card.getUSER_PW());
			}
			else {
				pStmt.setString(2, "");
			}


			// SQL文を実行し、結果表を取得する
			

			// 結果表をコレクションにコピーする
		
			ResultSet rs = pStmt.executeQuery();

			// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
			rs.next();
			if (rs.getInt("COUNT(*)") == 1) {
				loginResult = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			loginResult = false;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			loginResult = false;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					loginResult = false;
				}
			}
		}

		// 結果を返す
		return loginResult;
	}



// 引数paramで検索項目を指定し、検索結果のリストを返す(登録してあるのを表示)
public List<Users> select(Users card) {
	Connection conn = null;
	List<Users> cardList = new ArrayList<Users>();

	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/YuTrip.db", "sa", "");

		// SQL文を準備する
		String sql = "SELECT * FROM Users WHERE USER_ID =?  ORDER BY number";
		PreparedStatement pStmt = conn.prepareStatement(sql);
		// SQL文を完成させる
					if (card.getUSER_ID() != 0) {
						pStmt.setString(1, "%" + card.getUSER_ID() + "%");
					}
					else {
						pStmt.setString(1, "0");
					}



					// SQL文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					// 結果表をコレクションにコピーする
					while (rs.next()) {
						Users record = new Users(
						rs.getInt("USER_ID"),
						rs.getString("USER_PW"),
						rs.getString("MAILADDRESS"),
						rs.getString("P_NICKNAME"),
						rs.getString("P_IMG"),
						rs.getString("P_AGE"),
						rs.getString("P_GENDER"),
						rs.getString("HIDUKE")

						);
						cardList.add(record);

					}
				}
				catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
					cardList = null;
				}
				finally {
					// データベースを切断
					if (conn != null) {
						try {
							conn.close();
						}
						catch (SQLException e) {
							e.printStackTrace();
							cardList = null;
						}
					}
				}

				// 結果を返す
				return cardList;
			}



// 引数cardで指定されたレコードを更新し、成功したらtrueを返す(登録してあるもの変更)
public boolean update(Users card) {
	Connection conn = null;
	boolean result = false;

	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/YuTrip.db", "sa", "");

		// SQL文を準備する
		String sql = "UPDATE Users SET  USER_PW=?, MAILADDRESS=?,P_NICKNAME=?,P_IMG=?,P_AGE=?,P_GENDER=? WHERE  USER_ID =?";
		PreparedStatement pStmt = conn.prepareStatement(sql);

		// SQL文を完成させる

		if (card.getUSER_PW() != null && !card.getUSER_PW().equals("")) {
			pStmt.setString(1, card.getUSER_PW());
		}
		else {
			pStmt.setString(1, null);
		}
		if(card.getMAILADDRESS() != null && !card.getMAILADDRESS().equals("")){
			pStmt.setString(2, card.getMAILADDRESS());
		}
		else {
			pStmt.setString(2, null);
		}
		if(card.getP_NICKNAME() != null && !card.getP_NICKNAME().equals("")){
			pStmt.setString(3, card.getP_NICKNAME());
		}
		else {
			pStmt.setString(3, null);
		}
		if(card.getP_IMG() != null && !card.getP_IMG().equals("")){
			pStmt.setString(4, card.getP_IMG());
		}
		else {
			pStmt.setString(4,null);
		}
		if(card.getP_AGE() != null && !card.getP_AGE().equals("")){
			pStmt.setString(5, card.getP_AGE());
		}
		else {
			pStmt.setString(5,null);
		if(card.getP_GENDER() != null && !card.getP_GENDER().equals("")){
			pStmt.setString(6, card.getP_GENDER());
		}
		else {
			pStmt.setString(6,null);
		}

		if (card.getUSER_ID() != 0 ) {
			pStmt.setString(7, Integer.toString(card.getUSER_ID()));
		}
		else {
			pStmt.setString(7, null);
		}

		// SQL文を実行する
		if (pStmt.executeUpdate() == 1) {
			result = true;
		}
		}
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	finally {
		// データベースを切断
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 結果を返す
	return result;
}

//ユーザー情報登録のやつ
// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
public boolean insert(Users card) {
	Connection conn = null;
	boolean result = false;

	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/YuTrip.db", "sa", "");

		// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
		String sql = "INSERT INTO Users VALUES (NULL, ?, ?,?,?,?,?,?)";
		PreparedStatement pStmt = conn.prepareStatement(sql);

		// SQL文を完成させる
		if (card.getUSER_ID() != 0 ) {
			pStmt.setString(1,Integer.toString(card.getUSER_ID()));
		}
		else {
			pStmt.setString(1, "（未設定）");
		}
		if (card.getUSER_PW() != null && !card.getUSER_PW().equals("")) {
			pStmt.setString(2, card.getUSER_PW());
		}
		else {
			pStmt.setString(2, "（未設定）");
		}
		if(card.getMAILADDRESS() != null && !card.getMAILADDRESS().equals("")){
			pStmt.setString(3, card.getMAILADDRESS());
		}
		else {
			pStmt.setString(3, "(未設定)");
		}
		if(card.getP_NICKNAME() != null && !card.getP_NICKNAME().equals("")){
			pStmt.setString(4, card.getP_NICKNAME());
		}
		else {
			pStmt.setString(4, "(未設定)");
		}
		if(card.getP_IMG() != null && !card.getP_IMG().equals("")){
			pStmt.setString(5, card.getP_IMG());
		}
		else {
			pStmt.setString(5, "(未設定)");
		}
		if(card.getP_AGE() != null && !card.getP_AGE().equals("")){
			pStmt.setString(6, card.getP_AGE());
		}
		else {
			pStmt.setString(6, "(未設定)");
		}
		if(card.getP_GENDER() != null && !card.getP_GENDER().equals("")){
			pStmt.setString(7, card.getP_GENDER());
		}
		else {
			pStmt.setString(7, "(未設定)");
		}
		if(card.getHIDUKE() != null && !card.getHIDUKE().equals("")){
			pStmt.setString(8, card.getHIDUKE());
		}
		else {
			pStmt.setString(8, "(未設定)");
		}


		// SQL文を実行する
		if (pStmt.executeUpdate() == 1) {
			result = true;
		}
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	finally {
		// データベースを切断
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 結果を返す
	return result;
}


//引数paramで検索項目を指定し、検索結果のリストを返す(登録してあるのを表示)
//idの取得
public String selectid(Users card) {
	Connection conn = null;
	String cardList = "";

	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");
//SELECT ACCOUNTID as id  FROM ACAUNTDB  WHERE USER_PW LIKE ? AND MAILADDRESS LIKE ?
		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/DOJO2024DB/E1", "sa", "");		// SQL文を準備する
		String sql = "SELECT USER_ID FROM Users WHERE USER_PW = ? AND 	MAILADDRESS = ? ";
		PreparedStatement pStmt = conn.prepareStatement(sql);
		// SQL文を完成させる
		
					if (card.getUSER_PW() != null && !card.getUSER_PW().equals("")) {
						pStmt.setString(1,  card.getUSER_PW());
					}
					else {
						pStmt.setString(1, "");
					}

					if (card.getMAILADDRESS() != null && !card.getMAILADDRESS().equals("")) {
						pStmt.setString(2, card.getMAILADDRESS() );
					}
					else {
						pStmt.setString(2, "");
					}

					// SQL文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					// 結果表をコレクションにコピーする
					

					// 結果表をコレクションにコピーする
					while (rs.next()) {
						cardList=Integer.toString(rs.getInt("USER_ID"));
					} 

						


				}
				catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
					cardList = null;
				}
				finally {
					// データベースを切断
					if (conn != null) {
						try {
							conn.close();
						}
						catch (SQLException e) {
							e.printStackTrace();
							cardList = null;
						}
					}
				}

				// 結果を返す
				return cardList;
			}

//ユーザーネームの取得
public String selectun(Users card) {
	Connection conn = null;
	String cardList = "";

	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/DOJO2024DB/E1", "sa", "");

		// SQL文を準備する
		String sql = "SELECT P_NICKNAME FROM Users WHERE USER_PW = ? AND 	MAILADDRESS = ?";
		PreparedStatement pStmt = conn.prepareStatement(sql);
		// SQL文を完成させる
		if (card.getUSER_PW() != null && !card.getUSER_PW().equals("")) {
			pStmt.setString(1,  card.getUSER_PW() );
		}
		else {
			pStmt.setString(1, "");
		}

		if (card.getMAILADDRESS() != null && !card.getMAILADDRESS().equals("")) {
			pStmt.setString(2,  card.getMAILADDRESS() );
		}
		else {
			pStmt.setString(2, "");
		}


					// SQL文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					// 結果表をコレクションにコピーする
					while (rs.next()) {
						cardList = rs.getString("P_NICKNAME");
					} 


						


				}
				catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
					cardList = null;
				}
				finally {
					// データベースを切断
					if (conn != null) {
						try {
							conn.close();
						}
						catch (SQLException e) {
							e.printStackTrace();
							cardList = null;
						}
					}
				}

				// 結果を返す
				return cardList;
			}

//ユーザーアイコンの取得
public String selectic(Users card) {
	Connection conn = null;
	String cardList = "";

	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/DOJO2024DB/E1", "sa", "");

		// SQL文を準備する
		String sql = "SELECT P_IMG FROM Users WHERE USER_PW = ? AND 	MAILADDRESS = ?";
		PreparedStatement pStmt = conn.prepareStatement(sql);
		// SQL文を完成させる
		if (card.getUSER_PW() != null && !card.getUSER_PW().equals("")) {
			pStmt.setString(1, card.getUSER_PW() );
		}
		else {
			pStmt.setString(1, "");
		}

		if (card.getMAILADDRESS() != null && !card.getMAILADDRESS().equals("")) {
			pStmt.setString(2,  card.getMAILADDRESS());
		}
		else {
			pStmt.setString(2, "");
		}


					// SQL文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					// 結果表をコレクションにコピーする
					while (rs.next()) {
						cardList = rs.getString("P_IMG");
					} 
					


				}
				catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
					cardList = null;
				}
				finally {
					// データベースを切断
					if (conn != null) {
						try {
							conn.close();
						}
						catch (SQLException e) {
							e.printStackTrace();
							cardList = null;
						}
					}
				}

				// 結果を返す
				return cardList;
			}


}
