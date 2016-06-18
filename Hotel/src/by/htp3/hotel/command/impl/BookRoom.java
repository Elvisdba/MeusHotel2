package by.htp3.hotel.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp3.hotel.command.Command;
import by.htp3.hotel.service.RoomService;
import by.htp3.hotel.service.ServiceFactory;
import by.htp3.hotel.service.exception.ServiceException;

public class BookRoom implements Command {

	private static final String ARRIVE = "arrive";
	private static final String DEPART = "depart";
	private static final String PEOPLE = "people";
	private static final String MESSAGE = "message";
	private static final String KIND = "kind";
	private static final String TYPE = "type";
	private final static String MAIN_QUERY = "index.jsp";
	private static final String ERROR_QUERY = "error.jsp";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String depart = request.getParameter(DEPART);
		String arrive = request.getParameter(ARRIVE);
		String people = request.getParameter(PEOPLE);
		String type = request.getParameter(TYPE);
		String kind = request.getParameter(KIND);
		String message = request.getParameter(MESSAGE);

		try {
			RoomService roomService = ServiceFactory.getInstance().getRoomService();
			roomService.bookRoom(arrive, depart, message, people, type, kind);

			request.getRequestDispatcher(MAIN_QUERY).forward(request, response);

		} catch (ServiceException e) {
			e.printStackTrace();
			request.getRequestDispatcher(ERROR_QUERY).forward(request, response);
		}

	}
}
