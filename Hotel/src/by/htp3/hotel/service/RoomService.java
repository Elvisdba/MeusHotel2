package by.htp3.hotel.service;

import java.util.List;

import by.htp3.hotel.bean.Room;
import by.htp3.hotel.service.exception.ServiceException;

public interface RoomService {

	void addNewRoom(String type, String price_a_day, String kind, String OK) throws ServiceException;

	List<Room> showFreeRooms() throws ServiceException;

	void searchForRoom(String price_a_day, String kind, String type) throws ServiceException;

	void bookRoom(String arrive, String depart, String message, String people, String type, String kind)
			throws ServiceException;
}
