package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import dao.OnsensearchDao;
import model.OnsenData;

@WebServlet("/ChatSearch")
public class ChatSearchServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/ChatSearch.jsp");
		dispatcher.forward(req, res);
    }

  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    // JSON形式のリクエストボディをパース
	  req.setCharacterEncoding("UTF-8");
    String requestBody = req.getReader().lines().collect(Collectors.joining());
    System.out.println("RequestBody:" + requestBody);
    Map<String, String> answers = new HashMap<>();
    try {
      answers = new ObjectMapper().readValue(requestBody, new TypeReference<Map<String, String>>() {});
    } catch (JsonParseException e) {
      // エラー処理
      e.printStackTrace(); // エラー内容をコンソールに出力
      // 適切なエラーレスポンスを返す
      resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      resp.getWriter().write("{\"error\": \"Invalid JSON format\"}");
      return; // 処理を中断
    }


    // 結果を計算
    String result = calculateResult(answers);

    // 結果をJSON形式で返す
    resp.setContentType("application/json");
    resp.setCharacterEncoding("UTF-8");
    resp.getWriter().write(new ObjectMapper().writeValueAsString(Map.of("result", result)));

    //結果を結果画面にリダイレクト
    resp.sendRedirect("E1/ChatSaveServlet?answer=" + result);
  }

  private String calculateResult(Map<String, String> answers) {
    // answerssから正規表現でDB内を検索して答えを導き出す。
      String HS_Address = answers.get("HS_Address");
      String HS_Effect = answers.get("HS_Effect");
      String HS_Roten = answers.get("HS_Roten");
      String HS_Keikan = answers.get("HS_Keikan");
      String HS_Kyakusituburo = answers.get("HS_Kyakusituburo");
	OnsensearchDao OSD = new OnsensearchDao();
	List<OnsenData> searchList = OSD.select(HS_Address, HS_Effect, HS_Roten, HS_Keikan, HS_Kyakusituburo);



    // ...
    if (searchList != null && !searchList.isEmpty()) {
        OnsenData recommendedOnsen = searchList.get(0);
        return "おすすめ結果：" + recommendedOnsen.getONSEN_NAME() ;
    } else {
        return "申し訳ありませんが、お探しの温泉は見つかりませんでした。";
    }

  }
}
