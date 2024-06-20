package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TimeLineDao;
import model.Review;

/**
 * Servlet implementation class TimeLineServlet
 */
@WebServlet("/TimeLineServlet")
public class TimeLineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimeLineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
//		if (session.getAttribute("id") == null) {
//			response.sendRedirect("/bckanri/LoginServlet");
//			return;
//		}
		String[] image_path2 = new String[100];
		String[] image_url2 = new String[100];;
//		int id = (int) session.getAttribute("id");
		TimeLineDao tDao = new TimeLineDao();
		List<Review> TList = tDao.select();
		request.setAttribute("TList", TList);
		
			try {
				Connection conn = DriverManager.getConnection("jdbc:h2:file:C:/DOJO2024DB/meisi", "sa", "");

		        // SQLクエリを実行
		        
		        Statement stmt = conn.createStatement();
		        ResultSet rs = stmt.executeQuery("SELECT * FROM USERS WHERE USERS ");
		        request.setAttribute("resultSet", rs);
//		    	rs.updateString(1, "%" + ac + "%");
		        int cou=0;
		        // 結果をレスポンスとして送信
		        while (rs.next()) {
		        image_path2[cou] = rs.getString("image_path");
				image_url2[cou] =  rs.getString("image_url");
		        }
		        rs.close();
		        stmt.close();
		        conn.close();
		        
		    } catch (SQLException e) {
		        throw new ServletException("SQL error", e);
		    }

        session.setAttribute("image_path",image_path2);
		session.setAttribute("image_url",image_url2);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/TimeLine.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
