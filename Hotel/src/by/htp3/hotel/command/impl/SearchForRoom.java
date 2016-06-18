package by.htp3.hotel.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp3.hotel.command.Command;

import by.htp3.hotel.service.RoomService;
import by.htp3.hotel.service.ServiceFactory;
import by.htp3.hotel.service.exception.ServiceException;

public class SearchForRoom implements Command {
	private static final String KIND = "kind";
	private static final String SEARCH_QUERY = "http://localhost:8080/Hotel/Controller?command=search_for_room";
	private static final String TYPE = "type";
	private static final String PRICE_A_DAY = "price_a_day";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String type = request.getParameter(TYPE);
		String priceADay = request.getParameter(PRICE_A_DAY);
		String kind = request.getParameter(KIND);
		try {

			RoomService roomService = ServiceFactory.getInstance().getRoomService();

			roomService.searchForRoom(priceADay, kind, type);

			response.sendRedirect(SEARCH_QUERY);

		} catch (ServiceException e) {
			e.printStackTrace();
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}

	}

}
