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

@WebServlet("/ChatSearchServlet")
public class ChatSearchServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/ChatSearch.jsp");
		dispatcher.forward(req, res);
    }

  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
    String HS_Address = answers.get("region");
    String HS_Effect = answers.get("hotSpringEffect");
    String HS_Roten = answers.get("openAirBath");
    String HS_Keikan = answers.get("scenery");
    String HS_Kyakusituburo = answers.get("privateBath");
    System.out.println(HS_Address);

    String encodedHS_Address = HS_Address;
    String encodedHS_Effect = HS_Effect;
    String encodedHS_Roten = HS_Roten;
    String encodedHS_Keikan = HS_Keikan;
    String encodedHS_Kyakusituburo = HS_Kyakusituburo;


    req.setAttribute("HS_Address",encodedHS_Address);
    req.setAttribute("HS_Effect",encodedHS_Effect);
    req.setAttribute("HS_Roten",encodedHS_Roten);
    req.setAttribute("HS_Keikan",encodedHS_Keikan);
    req.setAttribute("HS_Kyakusituburo",encodedHS_Kyakusituburo);
    req.setAttribute("hantei","hantei");

    Object value = req.getAttribute("HS_Address");
    if (value != null) {
        // データが存在する
        System.out.println("データが存在します: " + value);
    } else {
        // データが存在しない
        System.out.println("データが存在しません");
    }
    String result = calculateResult(answers);
    // 結果をJSON形式で返す
    req.setAttribute("rikomendo", result);
    resp.setContentType("application/json");
    resp.setCharacterEncoding("UTF-8");
    resp.getWriter().write(new ObjectMapper().writeValueAsString(Map.of("result", result)));
    System.out.println("ollok");
    req.setAttribute("result", result); 

    //結果を結果画面にリダイレクト
    //resp.sendRedirect("ChatSaveServlet?result=" + result);

  }

  private String calculateResult(Map<String, String> answers) {
      String HS_Address = answers.get("region");
      String HS_Effect = answers.get("hotSpringEffect");
      String HS_Roten = answers.get("openAirBath");
      String HS_Keikan = answers.get("scenery");
      String HS_Kyakusituburo = answers.get("privateBath");
      System.out.println(HS_Address);
 
    // answerssから正規表現でDB内を検索して答えを導き出す。

	OnsensearchDao OSD = new OnsensearchDao();
	List<OnsenData> testList = OSD.select("","","","","");
	String searchList = OSD.select1(HS_Address, HS_Effect, HS_Roten, HS_Keikan, HS_Kyakusituburo);
	
	return searchList;

    // ...
//    if (searchList != null && !searchList.isEmpty()) {
//        OnsenData recommendedOnsen = searchList.get(0);
//        return  recommendedOnsen.getONSEN_NAME() ;
//    } else {
//        return "申し訳ありませんが、お探しの温泉は見つかりませんでした。";
//    }

 }
}