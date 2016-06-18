package by.htp3.hotel.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp3.hotel.command.Command;
import by.htp3.hotel.service.RoomService;
import by.htp3.hotel.service.ServiceFactory;
import by.htp3.hotel.service.exception.ServiceException;

public class AddNewRoom implements Command {
	private static final String TYPE = "type";
	private static final String KIND = "kind";
	private static final String ISVALID = "isValid";
	private static final String PRICE_A_DAY = "price_a_day";
	private final static String ADMIN_QUERY = "http://localhost:8080/Hotel/Controller?&command=logination&login=admin&password=password";
	private static final String ERROR_QUERY = "error.jsp";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String type = request.getParameter(TYPE);
		String priceADay = request.getParameter(PRICE_A_DAY);
		String kind = request.getParameter(KIND);
		String isValid = request.getParameter(ISVALID);

		try {

			RoomService roomService = ServiceFactory.getInstance().getRoomService();
			roomService.addNewRoom(type, priceADay, kind, isValid);

			response.sendRedirect(ADMIN_QUERY);

		} catch (ServiceException e) {
			e.printStackTrace();
			request.getRequestDispatcher(ERROR_QUERY).forward(request, response);
		}

	}

}
