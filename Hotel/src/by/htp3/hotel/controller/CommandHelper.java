package by.htp3.hotel.controller;

import java.util.HashMap;
import java.util.Map;

import by.htp3.hotel.command.Command;
import by.htp3.hotel.command.impl.AddNewRoom;
import by.htp3.hotel.command.impl.AddNewRoomForm;
import by.htp3.hotel.command.impl.BlockUser;
import by.htp3.hotel.command.impl.BlockUserForm;
import by.htp3.hotel.command.impl.BookRoom;
import by.htp3.hotel.command.impl.BookRoomForm;
import by.htp3.hotel.command.impl.ChangeLanguage;
import by.htp3.hotel.command.impl.SearchForRoom;
import by.htp3.hotel.command.impl.ShowFreeRooms;
import by.htp3.hotel.command.impl.GiveFeedback;
import by.htp3.hotel.command.impl.GiveFeedbackForm;
import by.htp3.hotel.command.impl.GoToLogination;
import by.htp3.hotel.command.impl.GoToMain;
import by.htp3.hotel.command.impl.GoToPayment;
import by.htp3.hotel.command.impl.LogOut;
import by.htp3.hotel.command.impl.Logination;
import by.htp3.hotel.command.impl.Payment;
import by.htp3.hotel.command.impl.Registration;
import by.htp3.hotel.command.impl.ShowNews;
import by.htp3.hotel.command.impl.ShowUsers;

public final class CommandHelper {

	private static final CommandHelper instance = new CommandHelper();

	private Map<CommandName, Command> commands = new HashMap<>();

	private CommandHelper() {
		commands.put(CommandName.LOGINATION, new Logination());
		commands.put(CommandName.CHANGE_LANGUAGE, new ChangeLanguage());
		commands.put(CommandName.SHOW_FREE_ROOMS, new ShowFreeRooms());
		commands.put(CommandName.REGISTRATION, new Registration());
		commands.put(CommandName.ADD_NEW_ROOM, new AddNewRoom());
		commands.put(CommandName.ADD_NEW_ROOM_FORM, new AddNewRoomForm());
		commands.put(CommandName.GIVE_FEEDBACK, new GiveFeedback());
		commands.put(CommandName.SHOW_NEWS, new ShowNews());
		commands.put(CommandName.BOOK_ROOM, new BookRoom());
		commands.put(CommandName.PAYMENT, new Payment());
		commands.put(CommandName.SEARCH_FOR_ROOM, new SearchForRoom());
		commands.put(CommandName.LOGOUT, new LogOut());
		commands.put(CommandName.BLOCK_USER_FORM, new BlockUserForm());
		commands.put(CommandName.SHOW_USERS, new ShowUsers());
		commands.put(CommandName.GO_TO_MAIN, new GoToMain());
		commands.put(CommandName.GO_TO_PAYMENT, new GoToPayment());
		commands.put(CommandName.GIVE_FEEDBACK_FORM, new GiveFeedbackForm());
		commands.put(CommandName.BOOK_ROOM_FORM, new BookRoomForm());
		commands.put(CommandName.GO_TO_LOGIN, new GoToLogination());
		commands.put(CommandName.BLOCK_USER, new BlockUser());
	}

	public Command getCommand(String name) {
		name = name.replace('-', '_');
		CommandName commandName = CommandName.valueOf(name.toUpperCase());

		Command command = commands.get(commandName);

		return command;
	}

	public static CommandHelper getInstance() {
		return instance;
	}

}
