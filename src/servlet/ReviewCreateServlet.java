package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.ReviewDao;
import model.Review;

/**
 * Servlet implementation class ReviewCreateServlet
 */
@MultipartConfig(location = "C:\\pleiades\\workspace\\E1\\WebContent\\image") // アップロードファイルの一時的な保存先
@WebServlet("/ReviewCreateServlet")
public class ReviewCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
//		if (session.getAttribute("id") == null) {
//			response.sendRedirect("/E1/LoginServlet");
//			return;
//
//			// pageで指定した場所へ遷移させる（引数のpathでどこに遷移するか判断する）
//
//		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Review.jsp");
		dispatcher.forward(request, response);
			}
		// ログインページにフォワードする
		/*RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Review.jsp");
		dispatcher.forward(request, response);
	    }*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		Part part = request.getPart("IMAGE"); // getPartで取得

		String img = this.getFileName(part);
		request.setAttribute("image", img);
		// サーバの指定のファイルパスへファイルを保存
	       //場所はクラス名↑の上に指定してある
//		part.write(img);
	       //ディスパッチ


	// リクエストパラメータを取得する　登録ページなどで入力されたデータを持ってくる
	request.setCharacterEncoding("UTF-8");
	int USER_ID = 1; /*Integer.parseInt(request.getParameter("USER_ID"));*/
	String RV_ONSENNAME = request.getParameter("name");
	int RV_POINT = Integer.parseInt(request.getParameter("rate"));
	String RV_DAY = request.getParameter("example");
	String RV_IMG = getFileName(part);
	String RV_REMARK = request.getParameter("text");
	Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String RV_HIDUKE =sdf.format(date);

	//検索処理を行う
	ReviewDao rDao = new ReviewDao();
	 if( rDao.insert(new Review(0, USER_ID, RV_ONSENNAME, RV_POINT, RV_DAY, RV_IMG, RV_REMARK, RV_HIDUKE, 0, 0))){
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/E1/TimeLineServlet.java");//移動する場所を決めるプログラム (相撲を取る場所）
			dispatcher.forward(request, response);//起動する場所（力士たちが集まってくる） //モデルの中のプライベートにあった数だけ入れる)
	 }else {
	// 検索結果をリクエストスコープに格納する

	// レビューページにフォワードする 移動するためのプログラム
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Review.jsp");//移動する場所を決めるプログラム (相撲を取る場所）
		dispatcher.forward(request, response);//起動する場所（力士たちが集まってくる）
	 }
	}
	//ファイルの名前を取得してくる
	private String getFileName(Part part) {
	       String name = null;
	       for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
	           if (dispotion.trim().startsWith("filename")) {
	               name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
	               name = name.substring(name.lastIndexOf("\\") + 1);
	               break;
	           }
	       }		// TODO 自動生成されたメソッド・スタブ
			return name;
		}
	}

