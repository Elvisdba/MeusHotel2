package by.htp3.hotel.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp3.hotel.service.ServiceFactory;
import by.htp3.hotel.service.UserService;

import by.htp3.hotel.bean.User;
import by.htp3.hotel.command.Command;
import by.htp3.hotel.service.exception.ServiceAuthException;
import by.htp3.hotel.service.exception.ServiceException;

public class Registration implements Command {

	private static final String LOGIN = "login";
	private static final String NAME = "name";
	private static final String SURNAME = "surname";
	private static final String PASSWORD = "password";
	private static final String REPEAT_PASS = "password";
	private final String REG_QUERY = "/WEB-INF/jsp/register.jsp";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter(LOGIN);
		String password = request.getParameter(PASSWORD);
		String repeat_pass = request.getParameter(REPEAT_PASS);
		String name = request.getParameter(NAME);
		String surname = request.getParameter(SURNAME);

		UserService userService = ServiceFactory.getInstance().getUserService();

		try {
			User user = userService.registration(name, surname, login, password, repeat_pass);

			request.setAttribute("user", user);

			request.getRequestDispatcher(REG_QUERY).forward(request, response);
		} catch (ServiceAuthException e) {

			request.setAttribute("errorMessage", "Wrong login or password");

			request.getRequestDispatcher("index.jsp").forward(request, response);

		} catch (ServiceException e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}

	}

}
