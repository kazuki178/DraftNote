package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.TextData;

public class TextDAO {
	//データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:h2:~/public";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public List<TextData> findAll() {
		List<TextData> textdataList = new ArrayList<>();

		//データベース接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//select文の準備
			String sql = "SELECT ID,NAME,TEXT FROM PUBLIC ORDER BY ID DESC";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			//select文を実行
			ResultSet rs = pStmt.executeQuery();

			//select文の実行結果をリストに格納
			while (rs.next()) {
				int id = rs.getInt("ID");
				String userName = rs.getString("NAME");
				String text = rs.getString("TEXT");
				TextData textdata = new TextData(id, userName, text);
				textdataList.add(textdata);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		return textdataList;
	}

	public boolean create(TextData textdata) {
		//データベース接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//insert文の準備　idは自動連番らしい
			String sql = "INSERT INTO PUBLIC  (NAME,TEXT)VALUES(?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//insert文中の？に使用する値を設定しsqlを完成
			pStmt.setString(1, textdata.getUserName());
			pStmt.setString(2, textdata.getText());

			//insert実行
			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	//データベース接続にてパスワード認証(テストok)
	public String findPASS() {
		
		String PASS=null;
		//データベース接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//select文の準備
			String sql = "SELECT PASS FROM PASS";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			//select文を実行
			ResultSet rs = pStmt.executeQuery();

			//select文の実行結果をリストに格納
			while (rs.next()) {
				
			 PASS = rs.getString("PASS");

			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		return PASS;
	}

}
