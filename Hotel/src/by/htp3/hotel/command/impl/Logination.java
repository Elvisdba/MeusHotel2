package by.htp3.hotel.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp3.hotel.DAO.exception.DAOException;
import by.htp3.hotel.bean.Admin;
import by.htp3.hotel.bean.User;
import by.htp3.hotel.command.Command;
import by.htp3.hotel.command.util.QueryUtil;
import by.htp3.hotel.service.AdminService;
import by.htp3.hotel.service.ServiceFactory;
import by.htp3.hotel.service.UserService;
import by.htp3.hotel.service.exception.ServiceAuthException;
import by.htp3.hotel.service.exception.ServiceException;

public class Logination implements Command {
	private static final String ADMIN = "admin";
	private static final String LOGIN = "login";
	private static final String PASSWORD = "password";
	private static final String PREV_QUERY = "prev_query";
	private static final String USER_QUERY = "/WEB-INF/jsp/user.jsp";
	private static final String ERROR_QUERY = "error.jsp";
	private static final String MAIN_QUERY = "index.jsp";
	private static final String ADMIN_QUERY = "/WEB-INF/jsp/admin.jsp";
	private static final String USER = "user";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String login = request.getParameter(LOGIN);
		String password = request.getParameter(PASSWORD);

		UserService userService = ServiceFactory.getInstance().getUserService();
		AdminService adminService = ServiceFactory.getInstance().getAdminService();

		String query = QueryUtil.createHttpQueryString(request);
		request.getSession(true).setAttribute(PREV_QUERY, query);

		System.out.println(query);

		try {

			if (login.equals(ADMIN)) {

				Admin admin = adminService.authorisation(login, password);
				request.setAttribute(ADMIN, admin);
				request.getRequestDispatcher(ADMIN_QUERY).forward(request, response);
			} else {

				User user = userService.authorisation(login, password);
				request.setAttribute(USER, user);
				request.getRequestDispatcher(USER_QUERY).forward(request, response);
			}

		} catch (ServiceAuthException e) {

			request.setAttribute("errorMessage", "Wrong login or password");

			request.getRequestDispatcher(MAIN_QUERY).forward(request, response);

		} catch (ServiceException e) {
			request.getRequestDispatcher(ERROR_QUERY).forward(request, response);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
