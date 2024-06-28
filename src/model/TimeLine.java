package model;
import java.io.Serializable;
	public class TimeLine implements Serializable {
		private int TLID;		// 番号
		private int RVID;	// 氏名
		private int USERID;	// 住所
		private String COMMENT;
		private String HIDUKE;


		public TimeLine(int TLID, int RVID, int 	USERID, String COMMENT, String HIDUKE) {
			this.TLID = TLID;
			this.RVID = RVID;
			this.	USERID = 	USERID;
			this.COMMENT =COMMENT;
			this.HIDUKE = HIDUKE;
		}
		
		
		public TimeLine() {
			this.TLID = 0;
			this.RVID = 0;
			this.USERID= 0;
			this.COMMENT = "";
			this.HIDUKE ="";
			
		}
		
		
		public TimeLine(String COMMENT) {
			// TODO 自動生成されたコンストラクター・スタブ
			
			this.COMMENT =COMMENT;
		}

		public TimeLine( int RVID, int 	USERID, String COMMENT) {
			// TODO 自動生成されたコンストラクター・スタブ
			this.RVID = RVID;
			this.	USERID = USERID;
			this.COMMENT =COMMENT;
		}


		public int getTLID() {
			return TLID;
		}

		public void setTLID(int tLID) {
			TLID = tLID;
		}

		public int getRVID() {
			return RVID;
		}

		public void setRVID(int rVID) {
			RVID = rVID;
		}

		public int getUSERID() {
			return USERID;
		}

		public void setUSERID(int uSERID) {
			USERID = uSERID;
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


