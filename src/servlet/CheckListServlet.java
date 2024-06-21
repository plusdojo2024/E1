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

import dao.CheckListViewDAO;
import model.CheckList;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/CheckListServlet")
public class CheckListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("User_Id") == null) {
			response.sendRedirect("/E1/LoginServlet");
			return;
		}
*/
		request.setCharacterEncoding("UTF-8");
		int User_Id = 1 ;//Integer.parseInt(request.getParameter("User_Id"));
		CheckListViewDAO clvDao = new CheckListViewDAO();
		List<CheckList> CheckList = clvDao.select(User_Id);
		// 検索ページにフォワードする
		request.setAttribute("CheckList", CheckList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CheckList.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
/*
		if (session.getAttribute("User_Id") == null) {
			response.sendRedirect("/E1/LoginServlet");
			return;
		}
*/
		String cl_Name = "家電" ;//Integer.parseInt(request.getParameter("User_Id"));
		request.setAttribute("家電", cl_Name);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CheckListView.jsp");
		dispatcher.forward(request, response);
	}
}
