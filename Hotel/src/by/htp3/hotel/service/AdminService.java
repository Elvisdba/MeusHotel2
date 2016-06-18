package by.htp3.hotel.service;

import java.util.List;

import by.htp3.hotel.DAO.exception.DAOException;
import by.htp3.hotel.bean.Admin;
import by.htp3.hotel.bean.User;
import by.htp3.hotel.service.exception.ServiceAuthException;
import by.htp3.hotel.service.exception.ServiceException;

public interface AdminService {
	List<User> showUsers() throws ServiceAuthException;

	void blockUser(String login_block) throws ServiceAuthException;

	void showHotelInfo();

	Admin authorisation(String login, String password) throws ServiceException, DAOException;

	void showFreeRooms() throws ServiceException;

	void addNewRoom(String type, String price_a_day, String kind) throws ServiceException;

	boolean bookRoom(String name, String surname, int numRoom);

	void searchForRoom(String price_a_day, String kind, String type) throws ServiceException;
}
