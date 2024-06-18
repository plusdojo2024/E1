package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Review;

public class ReviewDao {
	public boolean insert(Review card) {
		Connection conn = null;
		List<Review> cardList = new ArrayList<Review>();

	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

		// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
		String sql = "INSERT INTO Review VALUES (NULL, NULL, ?, NULL, NULL, ?, ?, NULL, NULL, NULL)";
		PreparedStatement pStmt = conn.prepareStatement(sql);

		// SQL文を完成させる
			if (card.getRV_ONSENNAME()) != null && !card.getRV_ONSENNAME().equals("")) {
				pStmt.setString(1, card.getRV_ONSENNAME());
			}
			else {
				pStmt.setString(1, "（未設定）");
			}
			if (card.getRV_POINT() != 0) {
				pStmt.setInt(2, card.getRV_POINT());
			}
			else {
				pStmt.setInt(2, 0);
			}
			if (card.getRV_DAY() != 0) {
				pStmt.setInt(3, card.getRV_DAY());
			}
			else {
				pStmt.setString(3, "（未設定）");
			}
			if (card.getRV_IMG() != null && !card.getRV_IMG().equals("")) {
				pStmt.setString(4, card.getRV_IMG());
			}
			else {
				pStmt.setString(4, "（未設定）");
			}
			if (card.getRV_REMARK() != null && !card.getRV_REMARK().equals("")) {
				pStmt.setString(5, card.getRV_REMARK());
			}
			else {
				pStmt.setString(5, "（未設定）");
			}
			if (card.getRV_HIDUKE() != 0) {
				pStmt.setInt(6, card.getRV_HIDUKE());
			}
			else {
				pStmt.setInt(6, 0);
			}
			if (card.getRV_IINECHECK() != 0) {
				pStmt.setInt(7, card.getRV_IINECHECK());
			}
			else {
				pStmt.setInt(7, 0);
			}
			if (card.getRV_BOOK() != 0) {
				pStmt.setInt(8, card.getRV_BOOK());
			}
			else {
				pStmt.setInt(8, 0);
			}
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

