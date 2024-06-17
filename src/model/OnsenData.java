package model;
import java.io.Serializable;

public class OnsenData implements Serializable {
		private int HS_ID; //温泉ID
		private String ONSEN_NAME; //温泉名
		private String HS_ADDRESS; //住所
		private String HS_PHONE; //電話番号
		private String HS_EFFECT; //効能
		private String HS_VALUE; //温泉料金
		private String HS_IMG; //温泉画像
		private String HS_URL; //温泉URL


		//引数があるコンストラクタ
		public OnsenData(int HS_ID, String ONSEN_NAME, String HS_ADDRESS, String HS_PHONE, String HS_EFFECT, String HS_VALUE, String HS_IMG, String HS_URL) {
			super();
			this.HS_ID = HS_ID;
			this.ONSEN_NAME = ONSEN_NAME;
			this.HS_ADDRESS = HS_ADDRESS;
			this.HS_PHONE = HS_PHONE;
			this.HS_EFFECT = HS_EFFECT;
			this.HS_VALUE = HS_VALUE;
			this.HS_IMG = HS_IMG;
			this.HS_URL = HS_URL;

		}
		//引数がないコンストラクタ
			public OnsenData() {
				this.HS_ID =0;
				this.ONSEN_NAME ="";
				this.HS_ADDRESS ="";
				this.HS_PHONE ="";
				this.HS_EFFECT ="";
				this.HS_VALUE ="";
				this.HS_IMG ="";
				this.HS_URL ="";

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
			public String getHS_ADDRESS() {
				return HS_ADDRESS;
			}
			public void setHS_ADDRESS(String hS_ADDRESS) {
				HS_ADDRESS = hS_ADDRESS;
			}
			public String getHS_PHONE() {
				return HS_PHONE;
			}
			public void setHS_PHONE(String hS_PHONE) {
				HS_PHONE = hS_PHONE;
			}
			public String getHS_EFFECT() {
				return HS_EFFECT;
			}
			public void setHS_EFFECT(String hS_EFFECT) {
				HS_EFFECT = hS_EFFECT;
			}
			public String getHS_VALUE() {
				return HS_VALUE;
			}
			public void setHS_VALUE(String hS_VALUE) {
				HS_VALUE = hS_VALUE;
			}
			public String getHS_IMG() {
				return HS_IMG;
			}
			public void setHS_IMG(String hS_IMG) {
				HS_IMG = hS_IMG;
			}
			public String getHS_URL() {
				return HS_URL;
			}
			public void setHS_URL(String hS_URL) {
				HS_URL = hS_URL;
			}

}
