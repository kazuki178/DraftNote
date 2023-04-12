package model;
import java.util.List;

import DAO.TextDAO;
public class GetTextDataLogic {
	public List<TextData>execute(){
		TextDAO dao = new TextDAO();
		List<TextData>textdatalist = dao.findAll();
		return textdatalist;
	}
}
