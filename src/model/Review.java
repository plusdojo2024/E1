package model;

import java.io.Serializable;

public class Review implements Serializable {
	private int RV_ID ;		// レビューID
	private int USER_ID;	// ユーザーID
	private String RV_ONSENNAME;	// レビュー温泉
	private int RV_POINT;
	private int RV_DAY;
	private String RV_IMG;
	private String RV_REMARK;
	private int RV_HIDUKE;
	private int RV_IINECHECK;
	private int RV_BOOK;

	public Review(int RV_ID, int USER_ID, String RV_ONSENNAME, int RV_POINT, int RV_DAY, String RV_IMG, String RV_REMARK, int RV_HIDUKE, int RV_IINECHECK, int RV_BOOK) {
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
		this.RV_DAY = 0;
		this.RV_IMG = "";
		this.RV_REMARK  = 	"" ;
		this.RV_HIDUKE = 0;
		this.RV_IINECHECK = 0;
		this.RV_BOOK =0;
	}
	

}
