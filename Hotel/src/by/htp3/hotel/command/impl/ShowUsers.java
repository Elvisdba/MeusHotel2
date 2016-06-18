package by.htp3.hotel.command.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp3.hotel.bean.User;
import by.htp3.hotel.command.Command;
import by.htp3.hotel.command.util.QueryUtil;
import by.htp3.hotel.service.AdminService;
import by.htp3.hotel.service.ServiceFactory;
import by.htp3.hotel.service.exception.ServiceAuthException;

public class ShowUsers implements Command {
	private static final String SHOW_USERS_QUERY = "/WEB-INF/jsp/showUsers.jsp";
	List<User> users = new ArrayList<>();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AdminService adminService = ServiceFactory.getInstance().getAdminService();

		String query = QueryUtil.createHttpQueryString(request);
		request.getSession(true).setAttribute("prev_query", query);

		try {
			users = adminService.showUsers();

		} catch (ServiceAuthException e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}

		request.setAttribute("show_users", users);
		request.getRequestDispatcher(SHOW_USERS_QUERY).forward(request, response);

	}

}
