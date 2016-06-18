package by.htp3.hotel.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp3.hotel.command.Command;

public class AddNewRoomForm implements Command {
	private final static String ADD_QUERY = "WEB-INF/jsp/addNewRoom.jsp";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		request.getRequestDispatcher(ADD_QUERY).forward(request, response);

	}

}
