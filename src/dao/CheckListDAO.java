package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CheckList;

public class CheckListDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<CheckList> select(CheckList param) {
		Connection conn = null;
		List<CheckList> CheckList = new ArrayList<CheckList>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/YuTrip DB/YuTrip dadada", "sa", "");

			// SQL文を準備する
			String sql = "SELECT * FROM CHECKLIST WHERE cl_Name LIKE ? AND cl_Element LIKE ? ORDER BY cl_Id";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を完成させる
			if (param.getCl_Name() != null) {
				pStmt.setString(1, "%" + param.getCl_Name() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}
			if (param.getCl_Element() != null) {
				pStmt.setString(2, "%" + param.getCl_Element() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				CheckList record = new CheckList(
				rs.getInt("cl_Id"),
				rs.getInt("User_Id"),
				rs.getString("cl_Name"),
				rs.getString("cl_element"),
				rs.getString("Hiduke")
				);
				CheckList.add(record);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			CheckList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			CheckList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					CheckList = null;
				}
			}
		}

		// 結果を返す
		return CheckList;
	}

	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(CheckList param) {///========================================================================================
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/YuTrip DB/YuTrip dadada", "sa", "");
			// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
			String sql = "INSERT INTO CheckList VALUES (NULL, NULL, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getCl_Name() != null && !param.getCl_Name().equals("")) {
				pStmt.setString(1, param.getCl_Name());
			}
			else {
				pStmt.setString(1, "（未設定）");
			}
			if (param.getCl_Element() != null && !param.getCl_Element().equals("")) {
				pStmt.setString(2, param.getCl_Element());
			}
			else {
				pStmt.setString(2, "（未設定）");
			}
			if (param.getHiduke() != null && !param.getHiduke().equals("")) {
				pStmt.setString(3, param.getHiduke());
			}
			else {
				pStmt.setString(3, "（未設定）");
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

	// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
	public boolean update(CheckList param) {//=====================================================================
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/YuTrip DB/YuTrip dadada", "sa", "");
			// SQL文を準備する
			String sql = "UPDATE CHECKLIST  SET CL_NAME = ?, CL_ELEMENT = ?, HIDUKE = ? WHERE CL_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる


			if (param.getCl_Name() != null && !param.getCl_Name().equals("")) {
				pStmt.setString(1, param.getCl_Name());
			}
			else {
				pStmt.setString(1, null);
			}
			if (param.getCl_Element() != null && !param.getCl_Element().equals("")) {
				pStmt.setString(2, param.getCl_Element());
			}
			else {
				pStmt.setString(2, null);
			}
			if (param.getHiduke() != null && !param.getHiduke().equals("")) {
				pStmt.setString(3, param.getHiduke());
			}
			else {
				pStmt.setString(3, null);
			}

			pStmt.setInt(4, param.getCl_Id());

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

	// 引数numberで指定されたレコードを削除し、成功したらtrueを返す
	public boolean delete(String word) {//=====================================================================================
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/YuTrip DB/YuTrip dadada", "sa", "");

			// SQL文を準備する
			String sql = "DELETE FROM checklist "
					+ "WHERE cl_Name = ? "
					+ "AND User_Id IN (SELECT User_Id FROM users);";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, word);

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
}
