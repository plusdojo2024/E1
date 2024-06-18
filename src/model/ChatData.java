package model;
import java.io.Serializable;

public class ChatData implements Serializable {
	private int cUser_Id;
	private int cBot_Id;
	private String User_Chat;


	//引数がないコンストラクタ
			public ChatData() {
				this.cUser_Id =0;
				this.cBot_Id =0;
				this.User_Chat="";
			}

	public ChatData(int cUser_Id, int cBot_Id, String User_Chat) {
		super();
		this.cUser_Id = cUser_Id;
		this.cBot_Id = cBot_Id;
		this.User_Chat = User_Chat;
	}

	public int getcUser_Id() {
		return cUser_Id;
	}

	public void setcUser_Id(int cUser_Id) {
		this.cUser_Id = cUser_Id;
	}

	public int getcBot_Id() {
		return cBot_Id;
	}

	public void setcBot_Id(int cBot_Id) {
		this.cBot_Id = cBot_Id;
	}

	public String getUser_Chat() {
		return User_Chat;
	}

	public void setUser_Chat(String user_Chat) {
		User_Chat = user_Chat;
	}

/* getter, setter */






}