package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.OnsenData;
public class OnsenDetailDAO {
    // 引数paramで検索項目を指定し、検索結果のリストを返す
    public List<OnsenData> select(int hs_Id) {
        Connection conn = null;
        List<OnsenData> cardlist = new ArrayList<OnsenData>();
        try {
            // JDBCドライバを読み込む
            Class.forName("org.h2.Driver");
            // データベースに接続する
            conn = DriverManager.getConnection("jdbc:h2:file:C:/DOJO2024DB/E1", "sa", "");
            // SQL文を準備する   ↓DISTINCT
            String sql = "SELECT * FROM Onsen WHERE hs_id=?";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            // SQL文を完成させる
            pStmt.setInt(1,hs_Id );
            // SQL文を実行し、結果表を取得する
            ResultSet rs = pStmt.executeQuery();
            // 結果表をコレクションにコピーする
                    while (rs.next()) {
                        OnsenData record = new OnsenData(
                        rs.getInt("hs_id"),
                        rs.getString("ONSEN_NAME"),
                        rs.getString("HS_ADDRESS"),
                        rs.getString("HS_PHONE"),
                        rs.getString("HS_EFFECT"),
                        rs.getString("HS_VALUE"),
                        rs.getString("HS_IMG"),
                        rs.getString("HS_URL"),
                        rs.getString("HS_ROTEN"),
                        rs.getString("HS_KEIKAN"),
                        rs.getString("HS_KYAKUBURO")
                        );
                        cardlist.add(record);
                    };
            }

        catch (SQLException e) {
            e.printStackTrace();
            cardlist = null;
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            cardlist = null;
        }
        finally {
            // データベースを切断
            if (conn != null) {
                try {
                    conn.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                    cardlist = null;
                }
            }
        }
        // 結果を返す
        return cardlist;
    }
}






