package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class CheckListServlet
 */
@WebServlet("/CheckListViewServlet")
public class CheckListViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
/*
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/E1/LoginServlet");
			return;
		}


		BcDAO bDao = new BcDAO();
		List<Bc> cardList = bDao.select(new Bc("", "", "", "", "", "", "","","",""));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("cardList", cardList);
*/
		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CheckListView.jsp");
		dispatcher.forward(request, response);
	}
}

