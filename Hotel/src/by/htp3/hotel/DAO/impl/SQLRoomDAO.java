package by.htp3.hotel.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import by.htp3.hotel.DAO.RoomDAO;
import by.htp3.hotel.DAO.exception.DAOException;
import by.htp3.hotel.DAO.impl.pool.ConnectionPool;
import by.htp3.hotel.DAO.impl.pool.ConnectionPoolException;
import by.htp3.hotel.bean.Room;

public class SQLRoomDAO implements RoomDAO {

	Logger logger = Logger.getLogger(SQLRoomDAO.class.getName());
	private static final String ADD_QUERY = "INSERT INTO rooms (type, price_a_day, kind, isValid) VALUES (?,?,?,?)";
	private static final String SHOW_QUERY = "select * from rooms";
	private static final String FLAG_RESERVATION = "OK";
	private static final String SEARCH_QUERY = "select * from rooms where price_a_day=? and type=? and kind=?";
	private static final String BOOK_QUERY = "INSERT INTO booking (arrive, depart, message, people, type, kind) VALUES (?,?,?,?,?,?)";
	List<Room> rooms = new ArrayList<>();

	@Override
	public void addNewRoom(String type, String price_a_day, String kind, String isValid) throws DAOException {

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {

			con = ConnectionPool.getInstance().takeConnection();

			st = con.prepareStatement(ADD_QUERY);

			st.setString(1, type);
			st.setString(2, price_a_day);
			st.setString(3, kind);
			st.setString(4, isValid);

			st.executeUpdate();

		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException(e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					logger.log(Level.SEVERE, "Exception: ", e);
				}
			}

			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					logger.log(Level.SEVERE, "Exception: ", e);
				}
			}
			if (con != null) {
				try {
					ConnectionPool.getInstance().returnConnection(con);
				} catch (ConnectionPoolException e) {
					logger.log(Level.SEVERE, "Exception: ", e);
				}
			}

		}
	}

	@Override
	public List<Room> showFreeRooms() throws DAOException {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			con = ConnectionPool.getInstance().takeConnection();

			st = con.prepareStatement(SHOW_QUERY);

			rs = st.executeQuery();

			while (rs.next()) {

				if (rs.getString(5).equals(FLAG_RESERVATION)) {
					Room r = new Room(rs.getString(2), rs.getString(3), rs.getString(4));
					rooms.add(r);
				}
			}

		} catch (SQLException e) {
			throw new DAOException("Logination sql error..", e);
		} catch (ConnectionPoolException e) {
			throw new DAOException("pool exception", e);
		}

		finally {

			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					logger.log(Level.SEVERE, "Exception: ", e);
				}
			}
			try {
				ConnectionPool.getInstance().returnConnection(con);
			} catch (ConnectionPoolException e) {
				logger.log(Level.SEVERE, "Exception: ", e);
			}

		}
		return rooms;

	}

	@Override
	public Room searchForRoom(String price_a_day, String type, String kind) throws DAOException {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			con = ConnectionPool.getInstance().takeConnection();

			st = con.prepareStatement(SEARCH_QUERY);
			st.setString(1, price_a_day);
			st.setString(2, type);
			st.setString(3, kind);

			rs = st.executeQuery();

			if (!rs.next()) {
				return null;
			}

		} catch (SQLException e) {
			throw new DAOException("Logination sql error..", e);
		} catch (ConnectionPoolException e) {
			throw new DAOException("pool exception", e);
		}

		finally {

			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					logger.log(Level.SEVERE, "Exception: ", e);
				}
			}
			try {
				ConnectionPool.getInstance().returnConnection(con);
			} catch (ConnectionPoolException e) {
				logger.log(Level.SEVERE, "Exception: ", e);
			}

		}
		Room room = new Room();

		return room;

	}

	@Override
	public void bookRoom(String arrive, String depart, String message, String people, String type, String kind)
			throws DAOException {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {

			con = ConnectionPool.getInstance().takeConnection();

			st = con.prepareStatement(BOOK_QUERY);

			st.setString(1, arrive);
			st.setString(2, depart);
			st.setString(3, message);
			st.setString(4, people);
			st.setString(5, type);
			st.setString(6, kind);
			st.executeUpdate();

		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException(e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					logger.log(Level.SEVERE, "Exception: ", e);
				}
			}

			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					logger.log(Level.SEVERE, "Exception: ", e);
				}
			}
			if (con != null) {
				try {
					ConnectionPool.getInstance().returnConnection(con);
				} catch (ConnectionPoolException e) {
					logger.log(Level.SEVERE, "Exception: ", e);
				}
			}

		}
	}

}
