package by.htp3.hotel.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.htp3.hotel.DAO.DAOFactory;
import by.htp3.hotel.DAO.UserDAO;
import by.htp3.hotel.DAO.exception.DAOException;
import by.htp3.hotel.bean.User;
import by.htp3.hotel.service.UserService;
import by.htp3.hotel.service.exception.ServiceAuthException;
import by.htp3.hotel.service.exception.ServiceException;

public class UserServiceImpl implements UserService {

	public User authorisation(String login, String password) throws ServiceException, ServiceAuthException {
		if (!Validation.validate(login, password)) {
			throw new ServiceAuthException("Wrong parameters!");
		}

		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO dao = daoFactory.getUserDAO();

		User user;
		try {
			user = dao.authorisation(login, password);

			if (user == null) {
				throw new ServiceAuthException("Wrong login or password!");
			}

		} catch (DAOException e) {

			throw new ServiceException("Error in source!", e);

		}

		return user;
	}

	static class Validation {
		static boolean validate(String login, String password) {

			if (!checkPassRegEx(password)) {
				return false;
			}

			if (!checkPassRegEx(login)) {
				return false;
			}

			if (login == null || login.isEmpty()) {
				return false;
			}

			if (password == null || password.isEmpty()) {
				return false;
			}

			return true;
		}

		static boolean validate(String login, String password, String repeat_pass, String name, String surname) {

			if (!checkPassRegEx(password)) {
				return false;
			}

			if (!checkLogRegEx(login)) {
				return false;
			}

			if (name == null || name.isEmpty()) {
				System.out.println("name!");
				return false;
			}

			if (surname == null || surname.isEmpty()) {
				System.out.println("surname!");
				return false;
			}

			if (login == null || login.isEmpty()) {
				System.out.println("login!");
				return false;
			}

			if (password == null || password.isEmpty()) {
				System.out.println("pass!");
				return false;
			}
			if (repeat_pass == null || repeat_pass.isEmpty()) {
				System.out.println("reppass!");
				return false;
			}
			if (password != repeat_pass) {
				System.out.println("notequls!");
				return false;
			}
			return true;
		}

		public static boolean checkPassRegEx(String password) {
			String regExPass = "^[a-z0-9_]{3,15}$";
			Pattern p = Pattern.compile(regExPass);
			Matcher m = p.matcher(password);
			return m.matches();
		}

		public static boolean checkLogRegEx(String login) {
			String regExPass = "^[a-z0-9_]{3,15}$";
			Pattern p = Pattern.compile(regExPass);
			Matcher m = p.matcher(login);
			return m.matches();
		}

		public static boolean checkNameRegEx(String name) {
			String regExPass = "^[a-z]{3,15}$";
			Pattern p = Pattern.compile(regExPass);
			Matcher m = p.matcher(name);
			return m.matches();
		}

		public static boolean checkSurNamRegEx(String surname) {
			String regExPass = "^[a-z]{3,15}$";
			Pattern p = Pattern.compile(regExPass);
			Matcher m = p.matcher(surname);
			return m.matches();
		}

	}

	@Override
	public User registration(String name, String surname, String login, String password, String repeat_pass)
			throws ServiceException, ServiceAuthException {
		if (!Validation.validate(login, password, repeat_pass, name, surname)) {

			throw new ServiceAuthException("Wrong parameters!");
		}

		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO dao = daoFactory.getUserDAO();

		User user;

		try {
			user = dao.registration(name, surname, login, password, repeat_pass);

			if (user == null) {

				throw new ServiceAuthException("Wrong login or password!");

			}

		} catch (DAOException e) {
			System.out.println(e);
			throw new ServiceException("Error in source!", e);

		}

		return user;
	}

	@Override
	public boolean pay(int price) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void giveFeedback(String name, String email, String message) throws ServiceException {
		/*
		 * if (name == null || name.isEmpty()) { throw new ServiceAuthException(
		 * "Wrong parameters!"); }
		 * 
		 * if (email == null || email.isEmpty()) { throw new
		 * ServiceAuthException("Wrong parameters!"); }
		 * 
		 * if (message == null || message.isEmpty()) { throw new
		 * ServiceAuthException("Wrong parameters!"); }
		 */
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO dao = daoFactory.getUserDAO();

		try {
			dao.giveFeedback(name, email, message);

		} catch (DAOException e) {
			System.out.println(e);
			throw new ServiceException("Error in source!", e);

		}

	}

}
