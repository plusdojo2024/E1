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
 * Servlet implementation class SearchServlet
 */
@WebServlet("/CheckListRegistServlet")
public class CheckListRegistServlet extends HttpServlet {
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


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CheckListRegist.jsp");
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

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CheckList.jsp");
		dispatcher.forward(request, response);
	}
}
