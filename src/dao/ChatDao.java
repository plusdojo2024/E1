package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Chat;

public class ChatDao {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
		public List<Chat> select(Chat card) {
			Connection conn = null;
			List<Chat> cardList = new ArrayList<Chat>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/E1", "sa", "");

				// SQL文を準備する
				String sql = "SELECT * FROM CHAT_BOT ";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				// SQL文を完成させる


				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Chat record = new Chat(
					rs.getInt("CBOT_ID"),
					rs.getString("BOT_CHAT")
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
