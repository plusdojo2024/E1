package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import model.Users;

public class UsersDao {

	public boolean isLoginOK(Users card) {
		Connection conn = null;
		boolean loginResult = false;


		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/YuTrip.db", "sa", "");

			// SQL文を準備する
			String sql = "SELECT * FROM USERS WHERE MAILADDRESS = ? AND USER_PW = ?  ORDER BY number";
			PreparedStatement pStmt = conn.prepareStatement(sql);


			// SQL文を完成させる
			if (card.getMAILADDRESS() != null) {
				pStmt.setString(1, "%" + card.getMAILADDRESS() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}
			if (card.getUSER_PW() != null) {
				pStmt.setString(2, "%" + card.getUSER_PW() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
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
}

// 引数paramで検索項目を指定し、検索結果のリストを返す
public List<Users> select(Users card) {
	Connection conn = null;
	List<Users> cardList = new ArrayList<Users>();

	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/YuTrip.db", "sa", "");

		// SQL文を準備する
		String sql = "SELECT * FROM Users WHERE USER_ID LIKE ? AND USER_PW LIKE ? MAILADDRESS LIKE ? AND P_NICKNAME LIKE ? AND P_IMG LIKE ? AND P_AGE LIKE ? AND P_GENDER LIKE AND HIDUKE ?  ORDER BY number";
		PreparedStatement pStmt = conn.prepareStatement(sql);
		// SQL文を完成させる
					if (card.getUSER_ID() != null) {
						pStmt.setString(1, "%" + card.getUSER_ID() + "%");
					}
					else {
						pStmt.setString(1, "%");
					}
					if (card.getUSER_PW() != null) {
						pStmt.setString(2, "%" + card.getUSER_PW() + "%");
					}
					else {
						pStmt.setString(2, "%");
					}

					if (card.getMAILADDRESS() != null) {
						pStmt.setString(3, "%" + card.getMAILADDRESS() + "%");
					}
					else {
						pStmt.setString(3, "%");
					}
					if (card.getP_NICKNAME() != null) {
						pStmt.setString(4, "%" + card.getP_NICKNAME() + "%");
					}
					else {
						pStmt.setString(4, "%");
					}
					if (card.getP_IMG() != null) {
						pStmt.setString(5, "%" + card.getP_IMG() + "%");
					}
					else {
						pStmt.setString(5, "%");
					}
					if (card.getP_AGE() != null ){
						pStmt.setString(6, "%" + card.getP_AGE() + "%");
					}
					else {
						pStmt.setString(6, "%");
					}
					if (card.getP_GENDER() != null){
						pStmt.setString(7, "%" + card.getP_GENDER() + "%");
					}
					else {
						pStmt.setString(7, "%");
					}
					if (card.getHIDUKE() != null){
						pStmt.setString(8, "%" + card.getHIDUKE() + "%");
					}
					else {
						pStmt.setString(8, "%");
					}


					// SQL文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					// 結果表をコレクションにコピーする
					while (rs.next()) {
						Bc record = new Bc(
						rs.getInt("number"),
						rs.getString("name"),
						rs.getString("address"),
						rs.getString("email"),
						rs.getString("company"),
						rs.getString("departmentname"),
						rs.getString("tel"),
						rs.getString("postname"),
						rs.getString("fax"),
						rs.getString("remark")
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
}
