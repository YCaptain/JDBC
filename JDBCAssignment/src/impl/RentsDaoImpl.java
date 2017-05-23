package impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.DaoException;
import dao.RentsDao;
import entity.Rents;
import utils.JdbcUtils;

public class RentsDaoImpl implements RentsDao {

	@Override
	public void addRent(Rents rents) {
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "INSERT INTO rents(RNumber, MNumber, registrationNumber, distance, orderDate, requiredDate, rentPrice)"
					+ " VALUES(?,?,?,?,?,?,?)";
			st = con.prepareStatement(sql);
			st.setInt(1, rents.getRNumber());
			st.setInt(2, rents.getMNumber());
			st.setInt(3, rents.getRegistrationNumber());
			st.setDouble(4, rents.getDistance());
			st.setDate(5, new Date(rents.getOrderDate().getTime()));
			st.setDate(6, new Date(rents.getRequiredDate().getTime()));
			st.setDouble(7, rents.getRentPrice());
			int count = st.executeUpdate();
			System.out.println("Add record: " + count);
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(null, st, con);
		}
	}

	@Override
	public Rents getRent(int RNumber) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "SELECT * FROM rents WHERE RNUmber = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, RNumber);
			rs = st.executeQuery();
			Rents rents = new Rents();
			rents.updateRNumber(RNumber);
			rents.updateMNumber(rs.getInt("MNumber"));
			rents.updateRegistrationNumber(rs.getInt("registrationNumber"));
			rents.updateDistance(rs.getDouble("distance"));
			rents.updateOrderDate(rs.getDate("orderDate"));
			rents.updateRequiredDate(rs.getDate("requiredDate"));
			rents.updateRentPrice(rs.getDouble("rentPrice"));
			return rents;
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(rs, st, con);
		}
	}

	@Override
	public int update(Rents rents) {
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "UPDATE rents SET MNumber = ?, registrationNumber = ?, distance = ?,"
					+ " orderDate = ?, requiredDate = ?, rentPrice = ? WHERE RNumber = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, rents.getMNumber());
			st.setInt(2, rents.getRegistrationNumber());
			st.setDouble(3, rents.getDistance());
			st.setDate(4, new Date(rents.getOrderDate().getTime()));
			st.setDate(5, new Date(rents.getRequiredDate().getTime()));
			st.setDouble(6, rents.getRentPrice());
			st.setInt(7, rents.getRNumber());
			int count = st.executeUpdate();
			System.out.println("Update record: " + count);
			return count;
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(null, st, con);
		}
	}

	@Override
	public int delete(Rents rents) {
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "DELETE FROM rents WHERE RNumber = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, rents.getRNumber());
			int count = st.executeUpdate();
			System.out.println("Delete record: " + count);
			return count;
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(null, st, con);
		}
	}

}
