package by.htp3.hotel.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import by.htp3.hotel.bean.User;
import by.htp3.hotel.DAO.UserDAO;
import by.htp3.hotel.DAO.exception.DAOException;
import by.htp3.hotel.DAO.impl.pool.ConnectionPool;
import by.htp3.hotel.DAO.impl.pool.ConnectionPoolException;

public class SQLUserDAO implements UserDAO {

	Logger logger = Logger.getLogger(SQLRoomDAO.class.getName());
	private static final String AUTH_QUERY = "select * from clients where login=? and password=?";
	private static final String REG_QUERY = "INSERT INTO clients (name, surname, login, password) VALUES (?,?,?,?)";
	private static final String FEED_QUERY = "INSERT INTO FEEDBACK (name, email, message) VALUES (?,?,?)";

	@Override
	public User authorisation(String login, String password) throws DAOException {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			con = ConnectionPool.getInstance().takeConnection();

			st = con.prepareStatement(AUTH_QUERY);

			st.setString(1, login);
			st.setString(2, password);

			rs = st.executeQuery();

			if (!rs.next()) {

				return null;
			}

			User user = new User();
			user.setName(rs.getString("name"));
			user.setSurname(rs.getString("surname"));

			return user;

		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Logination sql error..", e);
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
	public User registration(String name, String surname, String login, String password, String repeat_pass)
			throws DAOException {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {

			con = ConnectionPool.getInstance().takeConnection();

			st = con.prepareStatement(REG_QUERY);

			st.setString(1, name);
			st.setString(2, surname);
			st.setString(3, login);
			st.setString(4, password);
			st.executeUpdate();

			User user = new User();

			user.setName(st.getResultSet().getString("name"));
			user.setName(st.getResultSet().getString("surname"));

			return user;

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
	public boolean pay(int creditCard, int price) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void giveFeedback(String name, String email, String message) throws DAOException {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {

			con = ConnectionPool.getInstance().takeConnection();

			st = con.prepareStatement(FEED_QUERY);

			st.setString(1, name);
			st.setString(2, email);
			st.setString(3, message);

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
