package by.htp3.hotel.DAO;

import java.util.List;

import by.htp3.hotel.DAO.exception.DAOException;
import by.htp3.hotel.bean.Room;

public interface RoomDAO {
	void addNewRoom(String type, String price_a_day, String kind, String isValid) throws DAOException;

	List<Room> showFreeRooms() throws DAOException;

	Room searchForRoom(String price_a_day, String type, String kind) throws DAOException;

	void bookRoom(String arrive, String depart, String message, String people, String type, String kind)
			throws DAOException;

}
