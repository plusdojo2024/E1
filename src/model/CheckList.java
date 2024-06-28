package model;
import java.io.Serializable;

public class CheckList implements Serializable {
	private int cl_Id;
	private int User_Id;	// ユーザーID
	private String cl_Name;	// チェックリスト名
	private String cl_Element;//項目名
	private String Hiduke; //作成日

	//引数があるコンストラクタ
	public CheckList(int cl_Id, int User_Id, String cl_Name, String cl_Element, String Hiduke){
		super();
		this.cl_Id = cl_Id;
		this.User_Id = User_Id;
		this.cl_Name = cl_Name;
		this.cl_Element = cl_Element;
		this.Hiduke = Hiduke;
	}

	//引数がないコンストラクタ
	public CheckList() {
			super();
			this.cl_Id = 0;
			this.User_Id = 0;
			this.cl_Name = "";
			this.cl_Element = "";
			this.Hiduke = "";
	}

	public CheckList(String cl_Element, String cl_Name) {
		this.cl_Element = cl_Element;
		this.cl_Name = cl_Name;
	}

	public CheckList(int User_Id, String cl_Name) {
		this.User_Id = User_Id;
		this.cl_Name = cl_Name;
	}



		//ゲッタとセッタ--------------------------------------------------------------------------------------
		public int getCl_Id() {
			return cl_Id;
		}

		public int getUser_Id() {
			return User_Id;
		}

		public String getCl_Name() {
			return cl_Name;
		}

		public String getCl_Element() {
			return cl_Element;
		}

		public String getHiduke() {
			return Hiduke;
		}

		public void setCl_Id(int cl_Id) {
			this.cl_Id = cl_Id;
		}

		public void setUser_Id(int user_Id) {
			this.User_Id = user_Id;
		}

		public void setCl_Name(String cl_Name) {
			this.cl_Name = cl_Name;
		}

		public void setCl_Element(String cl_Element) {
			this.cl_Element = cl_Element;
		}

		public void setHiduke(String hiduke) {
			this.Hiduke = hiduke;
		}
}
