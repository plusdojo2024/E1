package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ChatData;

	public class ChatDataDao {

		List<ChatData> cardList = new ArrayList<ChatData>();

	public boolean insert(ChatData card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/DOJO2024DB/E1", "sa", "");

			// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
			String sql = "INSERT INTO Chat VALUES (null, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getcBot_Id() != 0 ) {
				pStmt.setString(1, Integer.toString(card.getcBot_Id()));
			}
			else {
				pStmt.setString(1, "（未設定）");/* 現状未設定を暫定的に登録 */
			}
			if (card.getUser_Chat() != null && !card.getUser_Chat().equals("")) {
				pStmt.setString(2, card.getUser_Chat());
			}
			else {
				pStmt.setString(2, "（未設定）");/* 現状未設定を暫定的に登録 */
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

	// 引数paramで検索項目を指定し、検索結果のリストを返す
			public List<ChatData> select(ChatData card) {
				Connection conn = null;
				List<ChatData> cardList = new ArrayList<ChatData>();

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/DOJO2024DB/E1", "sa", "");

					// SQL文を準備する
					String sql = "SELECT * FROM ONSEN WHERE  cBot_Id LIKE ? ";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					// SQL文を完成させる
					if (card.getcBot_Id() != 0) {
						pStmt.setString(1, "%" + card.getcBot_Id() + "%");
					}
					else {
						pStmt.setString(1, "%");
					}


					// SQL文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					// 結果表をコレクションにコピーする
					while (rs.next()) {
						ChatData record = new ChatData(
						rs.getInt("cUser_Id"),
						rs.getInt("cBot_Id"),
						rs.getString("User_Chat")
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

