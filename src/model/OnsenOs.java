package model;

import java.io.Serializable;

public class OnsenOs  implements Serializable   {

		private int HS_ID; //温泉ID
		private String ONSEN_NAME; //温泉名
		
		private String HS_IMG; //温泉画像
		


		//引数があるコンストラクタ
		public OnsenOs(int HS_ID, String ONSEN_NAME,  String HS_IMG) {
			super();
			this.HS_ID = HS_ID;
			this.ONSEN_NAME = ONSEN_NAME;
			
			this.HS_IMG = HS_IMG;
			
		}
		//引数がないコンストラクタ
			public OnsenOs() {
				this.HS_ID =0;
				this.ONSEN_NAME ="";
				
				this.HS_IMG ="";

			}
			public int getHS_ID() {
				return HS_ID;
			}
			public void setHS_ID(int hS_ID) {
				HS_ID = hS_ID;
			}
			public String getONSEN_NAME() {
				return ONSEN_NAME;
			}
			public void setONSEN_NAME(String oNSEN_NAME) {
				ONSEN_NAME = oNSEN_NAME;
			}
			
			public String getHS_IMG() {
				return HS_IMG;
			}
			public void setHS_IMG(String hS_IMG) {
				HS_IMG = hS_IMG;
			}
			
}


