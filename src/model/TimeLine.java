package model;
import java.io.Serializable;
	public class TimeLine implements Serializable {
		private int TL_ID;		// 番号
		private int RV_ID;	// 氏名
		private int USER_ID;	// 住所
		private String COMMENT;
		private String HIDUKE;

		public TimeLine(int TL_ID, int RV_ID, int 	USER_ID, String COMMENT, String HIDUKE) {
			this.TL_ID = TL_ID;
			this.RV_ID = RV_ID;
			this.	USER_ID = 	USER_ID;
			this.COMMENT =COMMENT;
			this.HIDUKE = HIDUKE;
		}
		
		public TimeLine() {
			this.TL_ID = 0;
			this.RV_ID = 0;
			this.USER_ID= 0;
			this.COMMENT = "";
			this.HIDUKE ="";
		}
		
		public int getTL_ID() {
			return TL_ID;
		}

		public void setTL_ID(int tL_ID) {
			TL_ID = tL_ID;
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

		public String getCOMMENT() {
			return COMMENT;
		}

		public void setCOMMENT(String cOMMENT) {
			COMMENT = cOMMENT;
		}

		public String getHIDUKE() {
			return HIDUKE;
		}

		public void setHIDUKE(String hIDUKE) {
			HIDUKE = hIDUKE;
		}


		
	}


