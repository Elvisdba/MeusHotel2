package by.htp3.hotel.DAO;

import by.htp3.hotel.DAO.exception.DAOException;
import by.htp3.hotel.bean.User;

public interface UserDAO {
	User authorisation(String login, String password) throws DAOException;

	User registration(String name, String surname, String login, String password, String repeat_pass)
			throws DAOException;

	boolean pay(int creditCard, int price);

	void giveFeedback(String name, String email, String message) throws DAOException;

}
