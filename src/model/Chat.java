package model;
import java.io.Serializable;

public class Chat implements Serializable {
	private int CBOT_ID; //チャットボットID
	private String BOT_CHAT; //チャット質問文


	//引数があるコンストラクタ
	public Chat(int CBOT_ID, String BOT_CHAT) {
		super();
		this.CBOT_ID = CBOT_ID;
		this.BOT_CHAT = BOT_CHAT;

	}
	//引数がないコンストラクタ
		public Chat() {
			this.CBOT_ID =0;
			this.BOT_CHAT ="";

		}
		public int getCBOT_ID() {
			return CBOT_ID;
		}
		public void setCBOT_ID(int cBOT_ID) {
			CBOT_ID = cBOT_ID;
		}
		public String getBOT_CHAT() {
			return BOT_CHAT;
		}
		public void setBOT_CHAT(String bOT_CHAT) {
			BOT_CHAT = bOT_CHAT;
		}
}
