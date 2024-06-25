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


			    // answerssから正規表現でDB内を検索して答えを導き出す。
			      String HS_Address = request.getParameter("HS_Address");
			      String HS_Effect = request.getParameter("HS_Effect");
			      String HS_Roten = request.getParameter("HS_Roten");
			      String HS_Keikan = request.getParameter("HS_Keikan");
			      String HS_Kyakusituburo = request.getParameter("HS_Kyakusituburo");
				OnsensearchDao OSD = new OnsensearchDao();
				List<OnsenData> searchList = OSD.select(HS_Address, HS_Effect, HS_Roten, HS_Keikan, HS_Kyakusituburo);



	        // 検索結果をリクエストスコープに格納する
	        request.setAttribute("searchList",searchList );

	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/SearchResult.jsp");
			dispatcher.forward(request, response);
			}

}

