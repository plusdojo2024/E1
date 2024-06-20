package model;

import java.io.Serializable;

public class Review implements Serializable {
	private int RV_ID ;		// レビューID
	private int USER_ID;	// ユーザーID
	private String RV_ONSENNAME;	// レビュー温泉
	private int RV_POINT;
	private String RV_DAY;
	private String RV_IMG;
	private String RV_REMARK;
	private String RV_HIDUKE;
	private int RV_IINECHECK;
	private int RV_BOOK;
	

	public Review(int RV_ID, int USER_ID, String RV_ONSENNAME, int RV_POINT, String RV_DAY, String RV_IMG, String RV_REMARK, String RV_HIDUKE, int RV_IINECHECK, int RV_BOOK) {
		this.RV_ID = RV_ID;
		this.USER_ID = USER_ID;
		this.RV_ONSENNAME = RV_ONSENNAME;
		this.RV_POINT = RV_POINT;
		this.RV_DAY = RV_DAY;
		this.RV_IMG = RV_IMG;
		this.RV_REMARK  = 	RV_REMARK ;
		this.RV_HIDUKE = RV_HIDUKE;
		this.RV_IINECHECK = RV_IINECHECK;
		this.RV_BOOK =RV_BOOK;
	}
	public Review() {
		this.RV_ID = 0;
		this.USER_ID = 0;
		this.RV_ONSENNAME = "";
		this.RV_POINT = 0;
		this.RV_DAY = "";
		this.RV_IMG = "";
		this.RV_REMARK  = 	"" ;
		this.RV_HIDUKE = "";
		this.RV_IINECHECK = 0;
		this.RV_BOOK =0;

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

	public String getRV_DAY() {
		return RV_DAY;
	}

	public void setRV_DAY(String rV_DAY) {
		RV_DAY = rV_DAY;
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

	public String getRV_HIDUKE() {
		return RV_HIDUKE;
	}

	public void setRV_HIDUKE(String rV_HIDUKE) {
		RV_HIDUKE = rV_HIDUKE;
	}

	public int getRV_IINECHECK() {
		return RV_IINECHECK;
	}

	public void setRV_IINECHECK(int rV_IINECHECK) {
		RV_IINECHECK = rV_IINECHECK;
	}

	public int getRV_BOOK() {
		return RV_BOOK;
	}

	public void setRV_BOOK(int rV_BOOK) {
		RV_BOOK = rV_BOOK;
	}

	
	

}
