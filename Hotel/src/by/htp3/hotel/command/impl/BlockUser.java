package by.htp3.hotel.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp3.hotel.command.Command;
import by.htp3.hotel.service.AdminService;
import by.htp3.hotel.service.ServiceFactory;
import by.htp3.hotel.service.exception.ServiceException;

public class BlockUser implements Command {
	private static final String LOGIN_BLOCK = "login_block";
	private static final String ERROR_QUERY = "error.jsp";
	private final static String ADMIN_QUERY = "http://localhost:8080/Hotel/Controller?&command=logination&login=admin&password=password";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String login_block = request.getParameter(LOGIN_BLOCK);

		try {

			AdminService adminService = ServiceFactory.getInstance().getAdminService();
			adminService.blockUser(login_block);
			response.sendRedirect(ADMIN_QUERY);

		} catch (ServiceException e) {
			e.printStackTrace();
			request.getRequestDispatcher(ERROR_QUERY).forward(request, response);
		}
	}

}
