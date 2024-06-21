package servlet;

import java.io.IOException;
import java.util.List;

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
		if (session.getAttribute("User_Id") == null) {
			response.sendRedirect("/E1/LoginServlet");
			return;
		}
*/

		request.setCharacterEncoding("UTF-8");

		// ここから改造
		String cl_Name = "家電"; //request.getParameter("cl_Name");

		CheckListDAO clDao = new CheckListDAO();
		List<CheckList> CheckList = clDao.select(cl_Name);
		request.setAttribute("CheckList", CheckList);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CheckListView.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cl_Name = "家電"; //request.getParameter("cl_Name");

		CheckListDAO clDao = new CheckListDAO();
		List<CheckList> CheckList = clDao.select(cl_Name);
		request.setAttribute("CheckList", CheckList);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CheckListView.jsp");
		dispatcher.forward(request, response);
	}
}
