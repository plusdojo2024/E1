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
					if (card.getName() != null) {
						pStmt.setString(1, "%" + card.getName() + "%");
					}
					else {
						pStmt.setString(1, "%");
					}
					if (card.getAddress() != null) {
						pStmt.setString(2, "%" + card.getAddress() + "%");
					}
					else {
						pStmt.setString(2, "%");
					}

					if (card.getEmail() != null) {
						pStmt.setString(3, "%" + card.getEmail() + "%");
					}
					else {
						pStmt.setString(3, "%");
					}
					if (card.getCompany() != null) {
						pStmt.setString(4, "%" + card.getCompany() + "%");
					}
					else {
						pStmt.setString(4, "%");
					}
					if (card.getDepartmentname() != null) {
						pStmt.setString(5, "%" + card.getDepartmentname() + "%");
					}
					else {
						pStmt.setString(5, "%");
					}
					if (card.getTel() != null ){
						pStmt.setString(6, "%" + card.getTel() + "%");
					}
					else {
						pStmt.setString(6, "%");
					}
					if (card.getPostname() != null){
						pStmt.setString(7, "%" + card.getPostname() + "%");
					}
					else {
						pStmt.setString(7, "%");
					}
					if (card.getFax() != null){
						pStmt.setString(8, "%" + card.getFax() + "%");
					}
					else {
						pStmt.setString(8, "%");
					}
					if (card.getRemark() != null){
						pStmt.setString(9, "%" + card.getRemark() + "%");
					}
					else {
						pStmt.setString(9, "%");
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
