package by.htp3.hotel.command.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp3.hotel.bean.Room;
import by.htp3.hotel.command.Command;
import by.htp3.hotel.command.util.QueryUtil;
import by.htp3.hotel.service.RoomService;
import by.htp3.hotel.service.ServiceFactory;
import by.htp3.hotel.service.exception.ServiceException;

public class ShowFreeRooms implements Command {

	private static final String SHOW_QUERY = "/WEB-INF/jsp/showFreeRooms.jsp";
	List<Room> rooms = new ArrayList<>();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		RoomService roomService = ServiceFactory.getInstance().getRoomService();

		String query = QueryUtil.createHttpQueryString(request);
		request.getSession(true).setAttribute("prev_query", query);
		System.out.println(query);

		try {
			rooms = roomService.showFreeRooms();

		} catch (ServiceException e) {

			e.printStackTrace();
		}

		request.setAttribute("free_rooms", rooms);

		request.getRequestDispatcher(SHOW_QUERY).forward(request, response);

	}

}
