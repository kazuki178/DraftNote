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

import model.GetTextDataLogic;
import model.PostTextDataLogic;
import model.TextData;
import model.User;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		//投稿リストを取得してリクエストスコープに保存
		GetTextDataLogic getTextDataLogic = new GetTextDataLogic();
		List<TextData> textdataList = getTextDataLogic.execute();
		request.setAttribute("textdataList",textdataList);

		//ログインしてるか確認でセッションスコープからユーザ情報を取得
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");

		
		
			
			//ログイン済み
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");

		//入力値の確認
		if (text != null && text.length() != 0) {

			//セッションスコープに保存されたユーザ情報を取得
			HttpSession session = request.getSession();
			User loginUser = (User) session.getAttribute("loginUser");
			
			//選ばれた科目をタイトル(User)に設定
			String kamoku = request.getParameter("example");	//セレクトボックスのexampleのvalueを受け取る
			

			//つぶやきリストに追加
			TextData textdata = new TextData(kamoku,text);
			PostTextDataLogic postTextDataLogic = new PostTextDataLogic();
			postTextDataLogic.execute(textdata);

		} else {
			//エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg","テキストが入力されていません");
		}
		
		
		//投稿を取得してリクエストスコープに保存
		GetTextDataLogic getTextDataLogic = new GetTextDataLogic();
		List<TextData>textdataList=getTextDataLogic.execute();
		request.setAttribute("textdataList",textdataList);

		//メイン画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);

	}

}
