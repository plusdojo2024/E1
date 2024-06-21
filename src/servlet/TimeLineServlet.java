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

import dao.ReviewDao;
import model.Review2;

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
        HttpSession session = request.getSession();

        // セッションが存在しない場合はログインページにリダイレクト
//        if (session.getAttribute("id") == null) {
//            response.sendRedirect("/bckanri/LoginServlet");
//            return;
//        }

        String[] image_path2 = new String[100];
        String[] image_url2 = new String[100];

        // セッションからIDを取得する場合
//        int id = (int) session.getAttribute("id");

        // ReviewDaoを使用してレビューリストを取得
        ReviewDao tDao = new ReviewDao();
        List<Review2> TList = tDao.select();

        // レビューリストの最初の要素から名前を取得（例として）
        String name = TList.isEmpty() ? "" : TList.get(0).getPnickname();
//        request.setAttribute("name", name);
        request.setAttribute("TList", TList);

        // JSPにフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/TimeLine.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}