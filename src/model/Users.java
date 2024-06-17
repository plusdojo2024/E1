package model;

import java.io.Serializable;

public class Users implements Serializable {
	private int USER_ID;		// 番号
	private String USER_PW;	// 氏名
	private String MAILADDRESS;	// 住所
	private String P_NICKNAME; //メールアドレス
	private String P_IMG; //会社名
	private String P_AGE; //部署名
	private String P_GENDER; //電話番号
	private String HIDUKE; //役職名


	//引数があるコンストラクタ
	public Users(int USER_ID, String USER_PW, String MAILADDRESS,String P_NICKNAME,
			String P_IMG,String P_AGE,String P_GENDER,String HIDUKE ) {
		this.USER_ID = USER_ID;
		this.USER_PW = USER_PW;
		this.MAILADDRESS = MAILADDRESS;
		this.P_NICKNAME = P_NICKNAME;
		this.P_IMG = P_IMG;
		this.P_AGE = P_AGE;
		this.P_GENDER = P_GENDER;
		this.HIDUKE = HIDUKE;

	}

	//引数がないコンストラクタ（javaBeansの仕様）
	public Users() {
		this.USER_ID = 0;
		this.USER_PW = "";
		this.MAILADDRESS = "";
		this.P_NICKNAME = "";
		this.P_IMG = "";
		this.P_AGE = "";
		this.P_GENDER = "";
		this.HIDUKE = "";

	}

	public int getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(int uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getUSER_PW() {
		return USER_PW;
	}

	public void setUSER_PW(String uSER_PW) {
		USER_PW = uSER_PW;
	}

	public String getMAILADDRESS() {
		return MAILADDRESS;
	}

	public void setMAILADDRESS(String mAILADDRESS) {
		MAILADDRESS = mAILADDRESS;
	}

	public String getP_NICKNAME() {
		return P_NICKNAME;
	}

	public void setP_NICKNAME(String p_NICKNAME) {
		P_NICKNAME = p_NICKNAME;
	}

	public String getP_IMG() {
		return P_IMG;
	}

	public void setP_IMG(String p_IMG) {
		P_IMG = p_IMG;
	}

	public String getP_AGE() {
		return P_AGE;
	}

	public void setP_AGE(String p_AGE) {
		P_AGE = p_AGE;
	}

	public String getP_GENDER() {
		return P_GENDER;
	}

	public void setP_GENDER(String p_GENDER) {
		P_GENDER = p_GENDER;
	}

	public String getHIDUKE() {
		return HIDUKE;
	}

	public void setHIDUKE(String hIDUKE) {
		HIDUKE = hIDUKE;
	}



}
