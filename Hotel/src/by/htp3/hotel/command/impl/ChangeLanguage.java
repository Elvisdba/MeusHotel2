package by.htp3.hotel.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp3.hotel.command.Command;

public class ChangeLanguage implements Command {
	private final static String LANGUAGE = "language";
	private final static String LOCALE = "locale";
	private final static String PREV_QUERY = "prev_query";
	private final static String INDEX_QUERY = "index.jsp";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		HttpSession session = request.getSession(true);

		session.setAttribute(LOCALE, request.getParameter(LANGUAGE));

		String prev_query = (String) request.getSession(false).getAttribute(PREV_QUERY);

		if (prev_query != null) {
			response.sendRedirect(prev_query);
		} else {
			request.getRequestDispatcher(INDEX_QUERY).forward(request, response);
		}
	}

}
