package impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Rents;
import dao.DaoException;
import dao.RentsDao;
import utils.JdbcUtils;

public class RentsDaoImpl implements RentsDao {

	@Override
	public void addRent(Rents rents) {
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "INSERT INTO rents(rentNumber, memNumber, registrationNumber, distance, orderDate, requiredDate)"
					+ " VALUES(?,?,?,?,?,?)";
			st = con.prepareStatement(sql);
			st.setInt(1, rents.getRentNumber());
			st.setInt(2, rents.getMemNumber());
			st.setInt(3, rents.getRegistrationNumber());
			st.setDouble(4, rents.getDistance());
			st.setDate(5, new Date(rents.getOrderDate().getTime()));
			st.setDate(6, new Date(rents.getRequiredDate().getTime()));
			int count = st.executeUpdate();
			System.out.println("Add record: " + count);
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(null, st, con);
		}
	}

	@Override
	public Rents getRent(int rentNumber) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "SELECT * FROM rents WHERE RNUmber = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, rentNumber);
			rs = st.executeQuery();
			Rents rents = new Rents();
			while(rs.next()) {
				rents.updateRentNumber(rentNumber);
				rents.updateMemNumber(rs.getInt("memNumber"));
				rents.updateRegistrationNumber(rs.getInt("registrationNumber"));
				rents.updateDistance(rs.getDouble("distance"));
				rents.updateOrderDate(rs.getDate("orderDate"));
				rents.updateRequiredDate(rs.getDate("requiredDate"));
			}
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
			String sql = "UPDATE rents SET memNumber = ?, registrationNumber = ?, distance = ?,"
					+ " orderDate = ?, requiredDate = ? WHERE rentNumber = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, rents.getMemNumber());
			st.setInt(2, rents.getRegistrationNumber());
			st.setDouble(3, rents.getDistance());
			st.setDate(4, new Date(rents.getOrderDate().getTime()));
			st.setDate(5, new Date(rents.getRequiredDate().getTime()));
			st.setInt(6, rents.getRentNumber());
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
			String sql = "DELETE FROM rents WHERE rentNumber = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, rents.getRentNumber());
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
