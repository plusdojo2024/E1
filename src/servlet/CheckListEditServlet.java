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
 * Servlet implementation class UpdateDeleteServlet
 */
@WebServlet("/CheckListEditServlet")
public class CheckListEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("User_Id") == null) {
			response.sendRedirect("/YuTrip/LoginServlet");
			return;
		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		int cl_Id = Integer.parseInt(request.getParameter("cl_Id"));
		int User_Id = Integer.parseInt(request.getParameter("User_Id"));
		// ここから改造
		String cl_Name = request.getParameter("cl_Name");
		String cl_Element = request.getParameter("cl_Element");
		String Hiduke = request.getParameter("Hiduke");

		// ここまで

		// 更新または削除を行う
		CheckListDAO clDao = new CheckListDAO();
		if (request.getParameter("submit").equals("更新")) {
			// ここを改造する
			if (clDao.update(new CheckList(cl_Id, User_Id, cl_Name, cl_Element, Hiduke))) {	// 更新成功
			// ここまで
				request.setAttribute("result",
				new Result("更新成功！", "レコードを更新しました。", "/YuTrip/ChekListServlet"));
			}
			else {												// 更新失敗
				request.setAttribute("result",
				new Result("更新失敗！", "レコードを更新できませんでした。", "/YuTrip/ChekListServlet"));
			}
		}
		else {
			if (clDao.delete(Integer.toString(cl_Id))) {	// 削除成功
				request.setAttribute("result",
				new Result("削除成功！", "レコードを削除しました。", "/YuTrip/CheckListServlet"));
			}
			else {						// 削除失敗
				request.setAttribute("result",
				new Result("削除失敗！", "レコードを削除できませんでした。", "/YuTrip/CheckListServlet"));
			}
		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CheckListView.jsp");
		dispatcher.forward(request, response);
	}
}