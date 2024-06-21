package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDao;
import model.Users;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログインページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp"); //移動する先
				dispatcher.forward(request, response); //起動する場所
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				String MAILADDRESS = request.getParameter("log");
				String USER_PW = request.getParameter("pw");

				// ログイン処理を行う
				UsersDao iDao = new UsersDao();
				if (iDao.isLoginOK(new Users(0,USER_PW,MAILADDRESS,null,null,null,null,null))) {	// ログイン成功
					// セッションスコープにIDを格納する
					HttpSession session = request.getSession();
					String id= iDao.selectid(new Users(0,USER_PW,MAILADDRESS,null,null,null,null,null)); //
					session.setAttribute("id",id);
					String un= iDao.selectun(new Users(0,USER_PW,MAILADDRESS,null,null,null,null,null)); //
					session.setAttribute("un",un);
					String ic= iDao.selectic(new Users(0,USER_PW,MAILADDRESS,null,null,null,null,null)); //
					session.setAttribute("ic",ic);

					// メニューサーブレットにリダイレクトする
					response.sendRedirect("/E1/LoginServlet");
				}
				else {									// ログイン失敗
					// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
					//request.setAttribute("result",
					//new ("ログイン失敗！", "IDまたはPWに間違いがあります。", "/E1/LoginServlet"));

					// 結果ページにフォワードする
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");
					dispatcher.forward(request, response);
				}

		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
