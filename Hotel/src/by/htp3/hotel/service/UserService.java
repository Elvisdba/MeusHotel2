package by.htp3.hotel.service;

import by.htp3.hotel.bean.User;
import by.htp3.hotel.service.exception.ServiceAuthException;
import by.htp3.hotel.service.exception.ServiceException;

public interface UserService {

	User authorisation(String login, String password) throws ServiceException;

	User registration(String name, String surname, String login, String password, String repeat_pass)
			throws ServiceAuthException, ServiceException;

	void giveFeedback(String name, String email, String message) throws ServiceAuthException, ServiceException;

	boolean pay(int price);

}
