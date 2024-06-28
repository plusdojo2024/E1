package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OnsenDetailDAO;
import model.OnsenData;

/**
 * Servlet implementation class ChatResultServlet
 */
@WebServlet("/ChatResultServlet")
public class ChatResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChatResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//			String hs_address = "新潟";
//			String hs_effect = "リウマチ";
//			String hs_roten = "X";
//			String hs_keikan = "山";
//			String hs_kyakuburo = "X";
//
//			//呼びたいときのダオの書き方
//	         OnsensearchDao osDao  =new OnsensearchDao();
//	         List<OnsenData> cardlist = osDao.select(hs_address,hs_effect,hs_roten,hs_keikan,hs_kyakuburo);
//
//	         request.setAttribute("cardlist", cardlist);
//
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/SearchResult.jsp");
//			dispatcher.forward(request, response);


//			int hs_id= Integer.parseInt(request.getParameter("hs_id"));
			int hs_id= 1;
			OnsenDetailDAO odDao =new OnsenDetailDAO();
			List<OnsenData> cardlist =  odDao.select(hs_id);
			 request.setAttribute("cardlist", cardlist);
			 RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/SearchResult.jsp");
				dispatcher.forward(request, response);

		}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


}
