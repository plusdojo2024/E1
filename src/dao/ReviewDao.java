package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Review;
import model.Review2;

public class ReviewDao {
	//表示
	public List<Review2> select() {
		Connection conn = null;
		List<Review2> Timeline = new ArrayList<Review2>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/DOJO2024DB/E1", "sa", "");
			 Statement statement = conn.createStatement();

			// SQL文を準備する
			String sql = "SELECT RV_ID, USER_ID, RV_ONSENNAME,RV_POINT,RV_IMG,RV_REMARK FROM   REVIEW ; ";
			ResultSet rs = statement.executeQuery(sql);
			// SQL文を完成させる

			// SQL文を実行し、結果表を取得する
			
			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Review2 record = new Review2(
						rs.getInt("RV_ID"),
						rs.getInt("USER_ID"),
						rs.getString("RV_ONSENNAME"),
						rs.getInt("RV_POINT"),
						rs.getString("RV_IMG"),
						rs.getString("RV_REMARK")
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
	
	
	//タイムライン用のid取得のselectidtl
	public String[] selectidtl() {
		Connection conn = null;
		String[] cardList = null ;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
	//SELECT ACCOUNTID as id  FROM ACAUNTDB  WHERE USER_PW LIKE ? AND MAILADDRESS LIKE ?
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/DOJO2024DB/E1", "sa", "");		// SQL文を準備する
			String sql = "SELECT USER_ID FROM REVIEW ; ";
			 Statement statement = conn.createStatement();
			 // SQL文を完成させる
						// SQL文を実行し、結果表を取得する
			 ResultSet rs = statement.executeQuery(sql);

						// 結果表をコレクションにコピーする
						

						// 結果表をコレクションにコピーする
			 int i=0;
			 while (rs.next()) {

					cardList[i]=Integer.toString( rs.getInt("USER_ID"));
					i++;
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
	
	//ユーザーネームの引き出し
	public String[][] selectud() {
		Connection conn = null;
		String[][]Timeline;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/DOJO2024DB/E1", "sa", "");
			

			// SQL文を準備する
			String sql = "SELECT  USER_ID, P_NICKNAME, P_IMG FROM USERS W ?cardList[i]  ; ";
			 Statement statement = conn.createStatement();
			 // SQL文を完成させる
						// SQL文を実行し、結果表を取得する
			 String[] name = null;
			 String[] img = null;
			 int x=0;
			 ResultSet rs = statement.executeQuery(sql);
			 int i=0;
			 while (rs.next()) {
				 x =rs.getInt("USER_ID");
				 String d =rs.getString("P_NICKNAME");
				 d =rs.getString("P_IMG");
			}
			 Timeline = new String[x+1][2];
			 Timeline[0][0]="ユーザーなし";
			 Timeline[0][1]="ユーザーなし";
			 conn = DriverManager.getConnection("jdbc:h2:file:C:/DOJO2024DB/E1", "sa", "");
			 sql = "SELECT  USER_ID, P_NICKNAME, P_IMG FROM USERS  ; ";
			 statement = conn.createStatement();
			 rs = statement.executeQuery(sql);
			 String a=null;
			 while(rs.next()) {
				 x =rs.getInt("USER_ID");
				 a =rs.getString("P_NICKNAME");
				 Timeline[i][0]=Integer.toString(x);
				 Timeline[i][1]=a;
				 a=rs.getString("P_IMG"); 
				 Timeline[i][2]=a;
				 i++;

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
	//登録
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
			if (card.getRV_DAY() != "") {
				pStmt.setString(4, card.getRV_DAY());
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
			if (card.getRV_HIDUKE() != "") {
				pStmt.setString(7, card.getRV_HIDUKE());
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
	//更新
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

			if (card.getRV_DAY() != "") {
				pStmt.setString(3,card.getRV_DAY());
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

			if (card.getRV_HIDUKE() != "") {
				pStmt.setString(6,card.getRV_HIDUKE());
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
	//温泉の件数を最大値を持ってくる
	
	public int count() {
		Connection conn = null;
		int count = 0;


		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/DOJO2024DB/E1", "sa", "");

			// SQL文を準備する
			String sql = "SELECT COUNT(*) FROM ONSEN ";
			 Statement statement = conn.createStatement();
			 ResultSet rs = statement.executeQuery(sql);


			// SQL文を完成させる

			// SQL文を実行し、結果表を取得する
			

			// 結果表をコレクションにコピーする
		

			// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
			rs.next();
			count = rs.getInt("COUNT(*)");
		}
		catch (SQLException e) {
			e.printStackTrace();
			count = 0;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			count = 0;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					count = 0;
				}
			}
		}

		// 結果を返す
		return count;
	}
	
	//ランダムで温泉データを引き出してくる
	public String[] selectos(int a) {
		Connection conn = null;
		String[] selectos = new String[3];


		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/DOJO2024DB/E1", "sa", "");

			// SQL文を準備する
			String sql = "SELECT HS_ID,ONSEN_NAME,HS_IMG  FROM ONSEN ";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			
			// SQL文を完成させる

			// SQL文を実行し、結果表を取得する
			
			String[][] kari = null;
			// 結果表をコレクションにコピーする
			int i =0;
			 while(rs.next()) {
				 
				 kari[i][0] =  Integer.toString(rs.getInt("HS_ID"));
				 kari[i][1] = rs.getString("ONSEN_NAME");
				 kari[i][2] =	rs.getString("HS_IMG");	 
				 i++;
			 }

			// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
			rs.next();
			selectos[0] = kari[a][0];
			selectos[1] = kari[a][1];
			selectos[2] = kari[a][3];
		}
		catch (SQLException e) {
			e.printStackTrace();
			selectos = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			selectos = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					selectos = null;
				}
			}
		}

		// 結果を返す
		return selectos;
	}
}
