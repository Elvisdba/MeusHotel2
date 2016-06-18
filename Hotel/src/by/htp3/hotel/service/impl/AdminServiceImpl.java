package by.htp3.hotel.service.impl;

import java.text.Format;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.htp3.hotel.DAO.AdminDAO;
import by.htp3.hotel.DAO.DAOFactory;
import by.htp3.hotel.DAO.exception.DAOException;
import by.htp3.hotel.bean.Admin;
import by.htp3.hotel.bean.User;
import by.htp3.hotel.service.AdminService;
import by.htp3.hotel.service.exception.ServiceAuthException;
import by.htp3.hotel.service.exception.ServiceException;
import by.htp3.hotel.service.impl.UserServiceImpl.Validation;

public class AdminServiceImpl implements AdminService {
	private final static String ADMIN = "admin";
	List<User> users;

	public Admin authorisation(String login, String password)
			throws ServiceException, ServiceAuthException, DAOException {

		if (!Validation.validate(login, password)) {
			throw new ServiceAuthException("Wrong parameters!");
		}
		if (!login.equals(ADMIN)) {
			throw new ServiceAuthException("Wrong login or password!");
		}
		DAOFactory daoFactory = DAOFactory.getInstance();
		AdminDAO dao = daoFactory.getAdminDAO();

		Admin admin;
		admin = dao.authorisation(login, password);
		if (admin == null) {
			throw new ServiceAuthException("Wrong login or password!");
		}

		return admin;
	}

	static boolean validate(String price_a_day) {
		Format parser = NumberFormat.getInstance();
		try {
			Object obj = parser.parseObject(price_a_day);
			if (!(obj instanceof Integer)) {
				return false;
			}
		} catch (ParseException e) {
			throw new IllegalArgumentException("Illegal value: " + price_a_day);
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

		if (login == null || login.isEmpty()) {

			return false;
		}

		if (password == null || password.isEmpty()) {

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

	@Override
	public List<User> showUsers() throws ServiceAuthException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		AdminDAO dao = daoFactory.getAdminDAO();

		try {
			users = dao.showUsers();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public void blockUser(String login_block) throws ServiceAuthException {
		if (login_block.isEmpty() || login_block == null) {
			System.out.println(login_block);
			throw new ServiceAuthException("Wrong parameters!");
		}
		if (login_block.equals(ADMIN)) {
			throw new ServiceAuthException("You can't delete yourself!");
		}
		DAOFactory daoFactory = DAOFactory.getInstance();
		AdminDAO dao = daoFactory.getAdminDAO();

		try {
			dao.blockUser(login_block);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void showHotelInfo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void showFreeRooms() throws ServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void addNewRoom(String type, String price_a_day, String kind) throws ServiceException {

	}

	@Override
	public boolean bookRoom(String name, String surname, int numRoom) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void searchForRoom(String price_a_day, String kind, String type) throws ServiceException {
		// TODO Auto-generated method stub

	}

}
