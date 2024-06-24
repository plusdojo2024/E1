package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.OnsenData;

public class OnsensearchDao {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
			public List<OnsenData> select(String HS_ADDRESS, String HS_EFFECT, String HS_ROTEN, String HS_KEIKAN, String HS_KYAKUSITUBURO) {
				Connection conn = null;
				List<OnsenData> cardList = new ArrayList<OnsenData>();

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/E1", "sa", "");

					// SQL文を準備する
					String sql = "SELECT * FROM ONSEN WHERE hs_address LIKE ? And HS_Effect Like ? AND hs_roten LIKE ? AND hs_keikan LIKE ? AND hs_kyakuburo LIKE ? ORDER BY hs_id ";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					// SQL文を完成させる
					pStmt.setString(1,HS_ADDRESS );
					pStmt.setString(2,HS_EFFECT );
					pStmt.setString(3,HS_ROTEN );
					pStmt.setString(4,HS_KEIKAN );
					pStmt.setString(5,HS_KYAKUSITUBURO );

					// SQL文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					// 結果表をコレクションにコピーする
					while (rs.next()) {
						OnsenData record = new OnsenData(
						rs.getInt("hs_id"),
						rs.getString("hs_name"),
						rs.getString("hs_address"),
						rs.getString("hs_phone"),
						rs.getString("hs_effect"),
						rs.getString("hs_value"),
						rs.getString("hs_img"),
						rs.getString("hs_url"),
						rs.getString("hs_roten"),
						rs.getString("hs_keikan"),
						rs.getString("hs_kyakuburo")

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
