package model;

import java.io.Serializable;

public class Review implements Serializable {
	private int rvId ;		// レビューID
	private int userId;	// ユーザーID
	private String rvOnsenName;	// レビュー温泉
	private int rvPoint;
	private String rvDay;
	private String rvImg;
	private String rvRemark;
	private String rvHiduke;
	private int rvIineCheck;
	private int rvBook;


	public Review(int rvId, int userId, String rvOnsenName, int rvPoint, String rvDay, String rvImg, String rvRemark, String rvHiduke, int rvIineCheck, int rvBook) {
		this.rvId = rvId;
		this.userId = userId;
		this.rvOnsenName = rvOnsenName;
		this.rvPoint = rvPoint;
		this.rvDay = rvDay;
		this.rvImg = rvImg;
		this.rvRemark = rvRemark;
		this.rvHiduke = rvHiduke;
		this.rvIineCheck = rvIineCheck;
		this.rvBook =rvBook;
	}

	public Review() {
		this.rvId = 0;
		this.userId = 0;
		this.rvOnsenName = "";
		this.rvPoint= 0;
		this.rvDay = "";
		this.rvImg = "";
		this.rvRemark ="";
		this.rvHiduke = "";
		this.rvIineCheck = 0;
		this.rvBook =0;

	}


	public Review(int rvId, int UserId, String rvOnsenName , int rvPoint, String rvImg) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.rvId =rvId;
		this.userId = UserId;
		this.rvOnsenName = rvOnsenName;
		this.rvPoint = rvPoint;
		this.rvImg =  rvImg;
	}


	public int getRvId() {
		return rvId;
	}

	public void setRvId(int rvId) {
		this.rvId = rvId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getRvOnsenName() {
		return rvOnsenName;
	}

	public void setRvOnsenName(String rvOnsenName) {
		this.rvOnsenName = rvOnsenName;
	}

	public int getRvPoint() {
		return rvPoint;
	}

	public void setRvPoint(int rvPoint) {
		this.rvPoint = rvPoint;
	}

	public String getRvDay() {
		return rvDay;
	}

	public void setRv_day(String rvDay) {
		this.rvDay = rvDay;
	}

	public String getRvImg() {
		return rvImg;
	}

	public void setRv_img(String rvImg) {
		this.rvImg = rvImg;
	}


	public String getRvRemark() {
		return rvRemark;
	}

	public void setRvRemark(String rvRemark) {
		this.rvRemark = rvRemark;
	}


	public String getRvHiduke() {
		return rvHiduke;
	}

	public void setRvHiduke(String rvHiduke) {
		this.rvHiduke = rvHiduke;
	}

	public int getRvIineCheck() {
		return rvIineCheck;
	}

	public void setRvIineChek(int rvIineCheck) {
		this.rvIineCheck = rvIineCheck;
	}

	public int getRvBook() {
		return rvBook;
	}

	public void setRvBook(int rvBook) {
		this.rvBook = rvBook;
	}



}
