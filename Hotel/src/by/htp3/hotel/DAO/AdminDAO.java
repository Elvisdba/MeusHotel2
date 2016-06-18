package by.htp3.hotel.DAO;

import java.util.List;

import by.htp3.hotel.DAO.exception.DAOException;
import by.htp3.hotel.bean.Admin;
import by.htp3.hotel.bean.User;

public interface AdminDAO {
	List<User> showUsers() throws DAOException;

	void blockUser(String login) throws DAOException;

	void showHotelInfo();

	Admin authorisation(String login, String password) throws DAOException;

}
