package servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReviewDao;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ReviewDao RDao = new ReviewDao();
		int max = RDao.count();
		Random r = new Random();
		int rd = r.nextInt(max-1);
	    String[] os = RDao.selectos(rd);//ランダムな温泉のデータを回収してきている。
	    request.setAttribute("os", os);
	    String[][] oslank=new String[5][3];

	    if(max<30) {
	    	oslank[0]= RDao.selectos(max+1);
	    	oslank[1]= RDao.selectos(max+2);
	    	oslank[2]= RDao.selectos(max+3);
	    	oslank[3]= RDao.selectos(max+4);
	    	oslank[4]= RDao.selectos(max+5);
	    }else {
	    	oslank[0]= RDao.selectos(max-5);
	    	oslank[1]= RDao.selectos(max-4);
	    	oslank[2]= RDao.selectos(max-3);
	    	oslank[3]= RDao.selectos(max-2);
	    	oslank[4]= RDao.selectos(max-1);
	    }
	    request.setAttribute("osrn", oslank);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Home.jsp");
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
