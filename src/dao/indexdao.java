package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Review;

public class indexdao {
	public List<Review> select(Review card) {
		Connection conn = null;
		List<Review> cardList = new ArrayList<Review>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/DOJO2024DB/E1", "sa", "");

			// SQL文を準備する
			String sql = "SELECT * FROM Review WHERE name LIKE ? AND address LIKE ? ORDER BY number";
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

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Bc record = new Bc(
				rs.getInt("number"),
				rs.getString("name"),
				rs.getString("address")
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
