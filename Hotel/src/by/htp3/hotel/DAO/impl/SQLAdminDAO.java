package by.htp3.hotel.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import by.htp3.hotel.DAO.AdminDAO;
import by.htp3.hotel.DAO.exception.DAOException;
import by.htp3.hotel.DAO.impl.pool.ConnectionPool;
import by.htp3.hotel.DAO.impl.pool.ConnectionPoolException;
import by.htp3.hotel.bean.Admin;
import by.htp3.hotel.bean.User;

public class SQLAdminDAO implements AdminDAO {

	Logger logger = Logger.getLogger(SQLAdminDAO.class.getName());
	private static final String AUTH_QUERY = "select * from clients where login=? and password=?";
	private static final String USER_QUERY = "SELECT * FROM CLIENTS";
	private static final String BLOCK_QUERY = "DELETE FROM clients WHERE login=?";
	List<User> users = new ArrayList<>();

	@Override
	public List<User> showUsers() throws DAOException {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {

			con = ConnectionPool.getInstance().takeConnection();

			st = con.prepareStatement(USER_QUERY);

			rs = st.executeQuery();

			while (rs.next()) {

				User u = new User(rs.getString(2), rs.getString(3), rs.getString(4));
				users.add(u);
			}

		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Showing sql error..", e);
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
		return users;

	}

	@Override
	public void blockUser(String login_block) throws DAOException {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {

			con = ConnectionPool.getInstance().takeConnection();

			st = con.prepareStatement(BLOCK_QUERY);

			st.setString(1, login_block);

			rs = st.executeQuery();

		} catch (SQLException | ConnectionPoolException e) {
			throw new DAOException("Blocking sql error..", e);
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
	public void showHotelInfo() {
		// TODO Auto-generated method stub

	}

	@Override
	public Admin authorisation(String login, String password) throws DAOException {
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

			Admin admin = new Admin();
			admin.setName(rs.getString("name"));

			return admin;

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

}
