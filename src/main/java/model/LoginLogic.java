package model;
import DAO.TextDAO;
public class LoginLogic {
	TextDAO dao = new TextDAO();
	public boolean execute(User user) {
		if (user.getPass().equals(dao.findPASS())) {
			return true;
		}
		return false;
	}
}
