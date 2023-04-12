package model;

import DAO.TextDAO;
public class PostTextDataLogic {
	public void execute(TextData textdata) {
		TextDAO dao = new TextDAO();
		dao.create(textdata);
	}
}
