package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.TimeLine;

public class TimeLineDao {
	public List<TimeLine> selectcm() {
		Connection conn = null;
		List<TimeLine> Timeline = new ArrayList<TimeLine>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/DOJO2024DB/E1", "sa", "");
			 Statement statement = conn.createStatement();
			// SQL文を準備する
			String sql = "SELECT RV_ID, B.USER_ID, COMMENT, A.P_NICKNAME,A.P_IMG FROM  Users  A INNER JOIN  TimeLINE   B ON A.USER_ID = B.USER_ID; ";
			ResultSet rs = statement.executeQuery(sql);
			// SQL文を完成させる

			// SQL文を実行し、結果表を取得する
			

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				TimeLine record = new TimeLine(
						
						rs.getInt("RV_ID"),
						rs.getInt("USER_ID"),
						rs.getString("COMMENT")
				);
				Timeline.add(record);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			Timeline = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			Timeline = null;
		} 

		// 結果を返す
		return Timeline;
	}

}
