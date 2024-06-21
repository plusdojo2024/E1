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


/**
 * Servlet implementation class UserchangeServlet
 */
@WebServlet("/UserchangeServlet")
public class UserchangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserchangeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		// もしもログインしていなかったらログインサーブレットにリダイレクトする
				HttpSession session = request.getSession();
				if (session.getAttribute("id") == null) {
					response.sendRedirect("/LoginServlet");
					return;
					}

				// リクエストパラメータを取得する（この場合何を取得？）登録ページなどで入力されたデータを持ってくる
				request.setCharacterEncoding("UTF-8");
				int USER_ID = Integer.parseInt(request.getParameter("id"));
				String USER_PW = request.getParameter("pw");
				String MAILADDRESS = request.getParameter("mail");
				String P_NICKNAME= request.getParameter("nickname");
				String P_IMG = request.getParameter("img");
				String P_AGE = request.getParameter("age");
				String P_GENDER = request.getParameter("gender");
				String HIDUKE = request.getParameter("hiduke");



				// 更新または削除を行う（ここのbcdaoてそもそも何?クラス名？）
				UsersDao bDao = new UsersDao();
				if (request.getParameter("submit").equals("更新")) {
					if (bDao.update(new Users(id, pw ,mail,nickname ,img ,age,gender ,hiduke ))) {	// 更新成功
						request.setAttribute("result",
						new Result("更新成功！", "レコードを更新しました。", "/Servlet"));
					}
					else {												// 更新失敗
						request.setAttribute("result",
						new Result("更新失敗！", "レコードを更新できませんでした。", "/Servlet"));
					} //更新成功時戻るところどこ　そのページ内？
				}
	}
	// 結果ページ(そのページ内に出す？←やり方が普通に不明じゃばすく？)にフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Home.jsp");
			dispatcher.forward (request, response);



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);*/
	}



//ホームとユザ変さーぶれと書く(わからん)

//
