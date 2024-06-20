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
 * Servlet implementation class UpdateDeleteServlet
 */
@WebServlet("/CheckListEditServlet")
public class CheckListEditServlet extends HttpServlet {
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

		// 検索ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CheckListEdit.jsp");
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

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		int cl_Id = Integer.parseInt(request.getParameter("cl_Id"));
		int User_Id = Integer.parseInt(request.getParameter("User_Id"));
		// ここから改造
		String cl_Name = request.getParameter("cl_Name");
		String cl_Element = request.getParameter("cl_Element");
		String Hiduke = request.getParameter("Hiduke");

		CheckListDAO clDao = new CheckListDAO();
		List<CheckList> CheckList = clDao.select(User_Id);
		request.setAttribute("CheckList", CheckList);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CheckListView.jsp");
		dispatcher.forward(request, response);
	}
}