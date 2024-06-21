package model;



import java.io.Serializable;

public class Review2 implements Serializable {
	private int RV_ID ;		// レビューID
	private int USER_ID;	// ユーザーID
	private String RV_ONSENNAME;	// レビュー温泉
	private int RV_POINT;
	private String RV_IMG;
	private String RV_REMARK;

	
	
	
	public Review2() {
		this.RV_ID = 0;
		this.USER_ID = 0;
		this.RV_ONSENNAME = "";
		this.RV_POINT = 0;
		this.RV_IMG = "";
		this.RV_REMARK  = 	"" ;


	}

	
	public Review2(int RV_ID, int USER_ID, String RV_ONSENNAME , int RV_POINT, String RV_IMG, String RV_REMARK ) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.RV_ID = RV_ID;
		this.USER_ID = USER_ID;
		this.RV_ONSENNAME = RV_ONSENNAME;
		this.RV_POINT = RV_POINT;
		this.RV_IMG = RV_IMG;
		this.RV_REMARK  = 	RV_REMARK ;

	}


	public Review2(int USER_ID) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.USER_ID = USER_ID;
	}


	public int getRV_ID() {
		return RV_ID;
	}


	public void setRV_ID(int rV_ID) {
		RV_ID = rV_ID;
	}
	
	


	public int getUSER_ID() {
		return USER_ID;
	}


	public void setUSER_ID(int uSER_ID) {
		USER_ID = uSER_ID;
	}


	public String getRV_ONSENNAME() {
		return RV_ONSENNAME;
	}


	public void setRV_ONSENNAME(String rV_ONSENNAME) {
		RV_ONSENNAME = rV_ONSENNAME;
	}


	public int getRV_POINT() {
		return RV_POINT;
	}


	public void setRV_POINT(int rV_POINT) {
		RV_POINT = rV_POINT;
	}


	public String getRV_IMG() {
		return RV_IMG;
	}


	public void setRV_IMG(String rV_IMG) {
		RV_IMG = rV_IMG;
	}


	public String getRV_REMARK() {
		return RV_REMARK;
	}


	public void setRV_REMARK(String rV_REMARK) {
		RV_REMARK = rV_REMARK;
	}




	
}

