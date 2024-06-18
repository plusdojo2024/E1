package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CheckListDAO;
import model.CheckList;

/**
 * Servlet implementation class HomeW
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

  		if (session.getAttribute("User_Id") == null) {


			response.sendRedirect("/YuTrip test/LoginServlet");
			return;
		}


		CheckListDAO cDao = new CheckListDAO();
		List<CheckList> CheckList = cDao.select(new CheckList(100, 100, "", "", ""));



		// 検索結果をリクエストスコープに格納する
		request.setAttribute("CheckList", CheckList);



		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CheckListView.jsp");
		dispatcher.forward(request, response);
	}
}

