package by.htp3.hotel.service.impl;

import java.util.List;

import by.htp3.hotel.DAO.DAOFactory;
import by.htp3.hotel.DAO.RoomDAO;

import by.htp3.hotel.DAO.exception.DAOException;
import by.htp3.hotel.bean.Room;
import by.htp3.hotel.service.RoomService;
import by.htp3.hotel.service.exception.ServiceAuthException;
import by.htp3.hotel.service.exception.ServiceException;

public class RoomServiceImpl implements RoomService {

	List<Room> rooms;

	@Override
	public void addNewRoom(String type, String price_a_day, String kind, String isValid) throws ServiceException {

		if (!Validation.validate(type, price_a_day, kind)) {
			System.out.println(isValid);
			System.out.println(type);
			System.out.println(price_a_day);
			System.out.println(kind);
			throw new ServiceAuthException("Wrong parameters!");
		}

		DAOFactory daoFactory = DAOFactory.getInstance();
		RoomDAO dao = daoFactory.getRoomDAO();

		try {
			dao.addNewRoom(type, price_a_day, kind, isValid);

		} catch (DAOException e) {
			throw new ServiceException("Error in source!", e);

		}

	}

	static class Validation {

		static boolean validate(String type, String price_a_day, String kind) {
			if (type == null || type.isEmpty()) {
				return false;
			}
			if (kind == null || kind.isEmpty()) {
				return false;
			}
			if (price_a_day == null || price_a_day.isEmpty()) {
				return false;
			}

			/*
			 * Format parser = NumberFormat.getInstance(); try { Object obj =
			 * parser.parseObject(price_a_day); if (!(obj instanceof Integer)) {
			 * 
			 * return false; } } catch (ParseException e) { throw new
			 * IllegalArgumentException("Illegal value: " + price_a_day); }
			 */
			return true;
		}
	}

	@Override
	public List<Room> showFreeRooms() throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		RoomDAO dao = daoFactory.getRoomDAO();

		try {
			rooms = dao.showFreeRooms();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return rooms;
	}

	@Override
	public void bookRoom(String arrive, String depart, String message, String people, String type, String kind)
			throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		RoomDAO dao = daoFactory.getRoomDAO();

		try {
			dao.bookRoom(arrive, depart, message, people, type, kind);
		} catch (DAOException e) {
			throw new ServiceException("Error in source!", e);
		}
	}

	@Override
	public void searchForRoom(String price_a_day, String kind, String type) throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		RoomDAO dao = daoFactory.getRoomDAO();

		try {
			dao.searchForRoom(price_a_day, kind, type);
		} catch (DAOException e) {
			throw new ServiceException("Error in source!", e);
		}

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rooms == null) ? 0 : rooms.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoomServiceImpl other = (RoomServiceImpl) obj;
		if (rooms == null) {
			if (other.rooms != null)
				return false;
		} else if (!rooms.equals(other.rooms))
			return false;
		return true;
	}

}
