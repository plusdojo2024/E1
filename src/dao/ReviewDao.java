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
		boolean result = false;
		Connection conn = null;
		List<Review> cardList = new ArrayList<Review>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

			// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
			String sql = "INSERT INTO Review VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getUSER_ID() != 0) {
				pStmt.setString(1,Integer.toString(card.getUSER_ID()));
			} else {
				pStmt.setString(1, "0");
			}
			if (card.getRV_ONSENNAME() != null && !card.getRV_ONSENNAME().equals("")) {
				pStmt.setString(2, card.getRV_ONSENNAME());
			} else {
				pStmt.setString(2, "（未設定）");
			}
			if (card.getRV_POINT() != 0) {
				pStmt.setString(3, Integer.toString(card.getRV_POINT()));//Intのときにif文で何を入れるか松川さんに聞く
			} else {
				pStmt.setString(3, "0");
			}
			if (card.getRV_DAY() != 0) {
				pStmt.setString(4, Integer.toString(card.getRV_DAY()));
			} else {
				pStmt.setString(4, "（未設定）");
			}
			if (card.getRV_IMG() != null && !card.getRV_IMG().equals("")) {
				pStmt.setString(5, card.getRV_IMG());
			} else {
				pStmt.setString(5, "（未設定）");
			}
			if (card.getRV_REMARK() != null && !card.getRV_REMARK().equals("")) {
				pStmt.setString(6, card.getRV_REMARK());
			} else {
				pStmt.setString(6, "（未設定）");
			}
			if (card.getRV_HIDUKE() != 0) {
				pStmt.setString(7, Integer.toString(card.getRV_HIDUKE()));
			} else {
				pStmt.setString(7, "0");
			}
			if (card.getRV_IINECHECK() != 0) {
				pStmt.setString(8, Integer.toString(card.getRV_IINECHECK()));
			} else {
				pStmt.setString(8, "0");
			}
			if (card.getRV_BOOK() != 0) {
				pStmt.setString(9, Integer.toString(card.getRV_BOOK()));
			} else {
				pStmt.setString(9, "0");
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
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		// 結果を返す
		return result;
		}

	public boolean update(Review card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

			// SQL文を準備する
			String sql = "UPDATE Review SET RV_ONSENNAME=?, RV_POINT=?, RV_DAY=?, RV_IMG=?, RV_REMARK=?, RV_HIDUKE=?, RV_IINECHECK=?, RV_BOOK=?" ;
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getRV_ONSENNAME() != null && !card.getRV_ONSENNAME().equals("")) {
				pStmt.setString(1, card.getRV_ONSENNAME());
			}else {
				pStmt.setString(1, null);
			}

			if (card.getRV_POINT() != 0) {
				pStmt.setString(2,Integer.toString(card.getRV_POINT()));
			}else {
				pStmt.setString(2, null);
			}

			if (card.getRV_DAY() != 0) {
				pStmt.setString(3,Integer.toString(card.getRV_DAY()));
			}else {
				pStmt.setString(3, null);
			}

			if (card.getRV_IMG() != null && !card.getRV_IMG().equals("")) {
				pStmt.setString(4, card.getRV_IMG());
			}else {
				pStmt.setString(4, null);
			}

			if (card.getRV_REMARK() != null && !card.getRV_REMARK().equals("")) {
				pStmt.setString(5, card.getRV_REMARK());
			}else {
				pStmt.setString(5, null);
			}

			if (card.getRV_HIDUKE() != 0) {
				pStmt.setString(6,Integer.toString(card.getRV_HIDUKE()));
			}else {
				pStmt.setString(6, null);
			}

			if (card.getRV_IINECHECK() != 0) {
				pStmt.setString(7,Integer.toString(card.getRV_IINECHECK()));
			}else {
				pStmt.setString(7, null);
			}

			if (card.getRV_BOOK() != 0) {
				pStmt.setString(8,Integer.toString(card.getRV_BOOK()));
			}else {
				pStmt.setString(8, null);;

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
}
