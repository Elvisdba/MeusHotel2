package by.htp3.hotel.DAO;

import by.htp3.hotel.DAO.impl.SQLAdminDAO;
import by.htp3.hotel.DAO.impl.SQLRoomDAO;
import by.htp3.hotel.DAO.impl.SQLUserDAO;

public final class DAOFactory {

	private static final DAOFactory instance = new DAOFactory();

	private UserDAO userDAO = new SQLUserDAO();
	private AdminDAO adminDAO = new SQLAdminDAO();
	private RoomDAO roomDAO = new SQLRoomDAO();

	private DAOFactory() {
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public AdminDAO getAdminDAO() {
		return adminDAO;
	}

	public RoomDAO getRoomDAO() {
		return roomDAO;
	}

	public static DAOFactory getInstance() {
		return instance;
	}

}
