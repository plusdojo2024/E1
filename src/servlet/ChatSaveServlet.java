package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OnsensearchDao;
import model.OnsenData;

/**
 * Servlet implementation class ChatSaveServlet
 */
@WebServlet("/ChatSaveServlet")
public class ChatSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
	public ChatSaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログインページにフォワードする

				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ChatSearchResult.jsp");
				dispatcher.forward(request, response);

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	// リクエストパラメータを取得する
			request.setCharacterEncoding("UTF-8");
			String User_chat = request.getParameter("User_chat");
			String hs_address=request.getParameter("hs_address");
			String hs_roten = request.getParameter("hs_roten");
			String hs_keikan = request.getParameter("hs_keikan");
			String hs_kyakuburo = request.getParameter("hs_kyakuburo");


			//	検索処理を行う
				OnsensearchDao cDao =new OnsensearchDao();
			List<OnsenData> OnsenData = cDao.select(new OnsenData(0,"",hs_address,"","","","","",hs_roten,hs_keikan,hs_kyakuburo));

	        // 検索結果をリクエストスコープに格納する
	        request.setAttribute("OnsenData",OnsenData );

	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/SearchResult.jsp");
			dispatcher.forward(request, response);
			}
}

