package by.htp3.hotel.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.htp3.hotel.command.Command;
import by.htp3.hotel.service.ServiceFactory;
import by.htp3.hotel.service.UserService;
import by.htp3.hotel.service.exception.ServiceException;

public class GiveFeedback implements Command {

	private static final String NAME = "name";
	private static final String EMAIL = "email";
	private static final String MESSAGE = "message";

	private final String FEED_QUERY = "index.jsp";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter(NAME);
		String email = request.getParameter(EMAIL);
		String message = request.getParameter(MESSAGE);

		UserService userService = ServiceFactory.getInstance().getUserService();

		try {
			userService.giveFeedback(name, email, message);
			request.getRequestDispatcher(FEED_QUERY).forward(request, response);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}

}
