package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CheckListStart;

public class CheckListViewDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<CheckListStart> select(int User_Id) {
		Connection conn = null;
		List<CheckListStart> CheckList = new ArrayList<CheckListStart>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/YuTrip DB/YuTrip dadada", "sa", "");

			// SQL文を準備する   ↓DISTINCT
			String sql = "SELECT DISTINCT cl_name FROM checklist WHERE User_Id LIKE ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を完成させる
			pStmt.setInt(1,User_Id );

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				CheckListStart record = new CheckListStart(
				rs.getString("cl_Name")
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
}
